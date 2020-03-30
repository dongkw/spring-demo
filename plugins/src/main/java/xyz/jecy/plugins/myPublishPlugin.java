package xyz.jecy.plugins;

import javax.inject.Inject;
import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.artifacts.dsl.RepositoryHandler;
import org.gradle.api.internal.CollectionCallbackActionDecorator;
import org.gradle.api.internal.DocumentationRegistry;
import org.gradle.api.internal.FeaturePreviews;
import org.gradle.api.internal.artifacts.ArtifactPublicationServices;
import org.gradle.api.internal.artifacts.ivyservice.projectmodule.ProjectPublicationRegistry;
import org.gradle.api.internal.project.ProjectInternal;
import org.gradle.api.publish.Publication;
import org.gradle.api.publish.PublicationContainer;
import org.gradle.api.publish.PublishingExtension;
import org.gradle.api.publish.internal.DefaultPublicationContainer;
import org.gradle.api.publish.internal.DefaultPublishingExtension;
import org.gradle.api.publish.internal.PublicationInternal;
import org.gradle.internal.model.RuleBasedPluginListener;
import org.gradle.internal.reflect.Instantiator;

public class myPublishPlugin implements Plugin<Project> {

  public static final String PUBLISH_TASK_GROUP = "publishing";
  public static final String PUBLISH_LIFECYCLE_TASK_NAME = "publish";

  private final Instantiator instantiator;
  private final ArtifactPublicationServices publicationServices;
  private final ProjectPublicationRegistry projectPublicationRegistry;
  private final FeaturePreviews featurePreviews;
  private final DocumentationRegistry documentationRegistry;
  private CollectionCallbackActionDecorator collectionCallbackActionDecorator;

  @Inject
  public myPublishPlugin(ArtifactPublicationServices publicationServices,
      Instantiator instantiator,
      ProjectPublicationRegistry projectPublicationRegistry,
      FeaturePreviews featurePreviews,
      DocumentationRegistry documentationRegistry,
      CollectionCallbackActionDecorator collectionCallbackActionDecorator) {
    this.publicationServices = publicationServices;
    this.instantiator = instantiator;
    this.projectPublicationRegistry = projectPublicationRegistry;
    this.featurePreviews = featurePreviews;
    this.documentationRegistry = documentationRegistry;
    this.collectionCallbackActionDecorator = collectionCallbackActionDecorator;
  }

  public void apply(final Project project) {
    RepositoryHandler repositories = publicationServices.createRepositoryHandler();
    PublicationContainer publications = instantiator
        .newInstance(DefaultPublicationContainer.class, instantiator,
            collectionCallbackActionDecorator);
    PublishingExtension extension = project.getExtensions()
        .create(PublishingExtension.class, PublishingExtension.NAME,
            DefaultPublishingExtension.class, repositories, publications);
    project.getTasks().register(PUBLISH_LIFECYCLE_TASK_NAME, new Action<Task>() {
      @Override
      public void execute(Task task) {
        task.setDescription("Publishes all publications produced by this project.");
        task.setGroup(PUBLISH_TASK_GROUP);
      }
    });
    extension.getPublications().all(new Action<Publication>() {
      @Override
      public void execute(Publication publication) {
        PublicationInternal internalPublication = (PublicationInternal) publication;
        ProjectInternal projectInternal = (ProjectInternal) project;
        projectPublicationRegistry.registerPublication(projectInternal, internalPublication);
      }
    });
    bridgeToSoftwareModelIfNeeded((ProjectInternal) project);
  }

  private void bridgeToSoftwareModelIfNeeded(ProjectInternal project) {
    project.addRuleBasedPluginListener(new RuleBasedPluginListener() {
      @Override
      public void prepareForRuleBasedPlugins(Project project) {
        project.getPluginManager().apply(PublishingPluginRules.class);
      }
    });
  }
}
