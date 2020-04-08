package xyz.jecy.plugins.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader.Provider;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lombok.Data;
import org.gradle.api.Task;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.artifacts.ConfigurationContainer;
import org.gradle.api.artifacts.Dependency;
import org.gradle.api.artifacts.DependencyConstraint;
import org.gradle.api.artifacts.DependencySet;
import org.gradle.api.artifacts.UnknownConfigurationException;
import org.gradle.api.artifacts.dsl.DependencyHandler;
import org.gradle.api.artifacts.type.ArtifactTypeContainer;
import org.gradle.api.execution.TaskExecutionGraph;
import org.gradle.api.execution.TaskExecutionGraphListener;
import org.gradle.api.internal.artifacts.DefaultDependencySet;
import org.gradle.api.internal.artifacts.ResolverResults;
import org.gradle.api.internal.artifacts.dependencies.DefaultExternalModuleDependency;
import org.gradle.api.internal.provider.DefaultProvider;
import org.gradle.api.tasks.TaskDependency;
import redis.clients.jedis.Jedis;
import xyz.jecy.plugins.RedisUtil;
import xyz.jecy.plugins.util.DependencyUtil;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/3/31 3:08 下午
 */
@Data
public class QuoteListener implements TaskExecutionGraphListener {


  @Override
  public void graphPopulated(TaskExecutionGraph graph) {

    DependencyUtil.setDependency(graph.getAllTasks().get(0).getProject());

  }
}
