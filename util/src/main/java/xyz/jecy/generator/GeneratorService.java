package xyz.jecy.generator;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


public class GeneratorService {

  public static void main(String[] args) {
    GeneratorService service=new GeneratorService();
    service.generateCode();
  }
  public void generateCode() {
    String packageName = "xyz.jecy.user";
    boolean serviceNameStartWithI = true;//user -> UserService, 设置成true: user -> IUserService
    generateByTables(serviceNameStartWithI, packageName, "user");
  }

  private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
    GlobalConfig config = new GlobalConfig();
    String dbUrl = "jdbc:mysql://localhost:3306/user";
    DataSourceConfig dataSourceConfig = new DataSourceConfig();
    dataSourceConfig.setDbType(DbType.MYSQL)
        .setUrl(dbUrl)
        .setUsername("root")
        .setPassword("mysql")
        .setDriverName("com.mysql.jdbc.Driver");
    StrategyConfig strategyConfig = new StrategyConfig();
    strategyConfig
        .setCapitalMode(true)
        .setEntityLombokModel(true)
        .setNaming(NamingStrategy.underline_to_camel)
        .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
    config.setActiveRecord(false)
        .setAuthor("kw")
        .setOutputDir("service/user-service/src/main/java/")
        .setFileOverride(false);

    if (!serviceNameStartWithI) {
      config.setServiceName("%sService");
    }
    new AutoGenerator()
        .setTemplateEngine(new MyTemp()).setGlobalConfig(config)
        .setDataSource(dataSourceConfig)
        .setStrategy(strategyConfig)
        .setPackageInfo(
            new PackageConfig()
                .setParent(packageName)
                .setController("controller")
                .setEntity("entity")
        ).execute();


  }

  private void generateByTables(String packageName, String... tableNames) {
    generateByTables(true, packageName, tableNames);
  }
}