package tech.vedaSource.cms.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Arrays;
import java.util.List;

/**
 * Mysql代码生成
 *
 * @author konghang
 */
public class MySQLGenerator {

  public static void main(String[] args) {
    // 数据源配置
    DataSourceConfig dataSourceConfig = new DataSourceConfig.Builder(
      "jdbc:mysql://localhost:3306/veda_source?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai",
      "root",
      "123456"
    ).build();

    // 全局配置
    GlobalConfig globalConfig = new GlobalConfig.Builder()
      .outputDir(System.getProperty("user.dir") + "/vedaSource-cms" + "/src/main/java")
      .author("Bruno")
      .disableOpenDir()
      .disableOpenDir()
      .fileOverride()
      .build();


    TemplateConfig templateConfig = new TemplateConfig.Builder()
//      .disable(TemplateType.CONTROLLER, TemplateType.SERVICE, TemplateType.SERVICE_IMPL)
      .build();

//    genSysModule(dataSourceConfig, globalConfig, templateConfig);
    genBizModule(dataSourceConfig, globalConfig, templateConfig);
  }

  private static String SYS_TABLES = "organization,resource,role,role_resource,session,storage_config,storage_file,stored_event,user,user_credential,user_role";
//  private static String BIZ_TABLES = "t_dict,t_content_config,t_hero_section,t_product,t_product_property,t_product_property_item,t_product_category_property_config";
  private static String BIZ_TABLES = "t_leader";
  private static void genSysModule(DataSourceConfig dataSourceConfig, GlobalConfig globalConfig, TemplateConfig templateConfig) {
    // sys模块生成
    // 包配置
    PackageConfig sysPackageConfig = new PackageConfig.Builder()
      .parent("tech.vedaSource.cms")
      .moduleName("sys")
      .entity("entity")
      .mapper("mapper")
      .service("service")
      .serviceImpl("service.impl")
      .build();

    // 策略配置
    StrategyConfig sysStrategyConfig = new StrategyConfig.Builder()
      .addInclude(SYS_TABLES)
      .addTablePrefix("s_")
      .entityBuilder().superClass("BaseEntity")
      .addSuperEntityColumns("id", "createDate", "updateDate", "status")
      .enableLombok()
      .enableFileOverride()
      .naming(NamingStrategy.underline_to_camel)
      .columnNaming(NamingStrategy.underline_to_camel)
      .build();

    // 代码生成器配置
    AutoGenerator sysAutoGenerator = new AutoGenerator(dataSourceConfig)
      .global(globalConfig)
      .packageInfo(sysPackageConfig)
      .template(templateConfig)
      .strategy(sysStrategyConfig);

    // 执行生成代码
    sysAutoGenerator.execute();
  }

  private static void genBizModule(DataSourceConfig dataSourceConfig, GlobalConfig globalConfig, TemplateConfig templateConfig) {
    // biz模块生成
    // 包配置
    PackageConfig packageConfig = new PackageConfig.Builder()
      .parent("tech.vedaSource.cms")
      .moduleName("biz")
      .entity("entity")
      .mapper("mapper")
      .service("service")
      .serviceImpl("service.impl")
      .build();

//    List<String> excludes = Arrays.asList(SYS_TABLES.split(","));
    List<String> includes = Arrays.asList(BIZ_TABLES.split(","));
    // 策略配置
    StrategyConfig strategyConfig = new StrategyConfig.Builder()
      .addInclude(includes)
      .addTablePrefix("t_")
      .entityBuilder()
      .superClass("tech.vedaSource.cms.biz.common.BaseEntity")
      .addSuperEntityColumns("id","status", "createDate", "updateDate")
      .enableLombok()
      .enableFileOverride()

      .entityBuilder()
      .naming(NamingStrategy.underline_to_camel)
      .columnNaming(NamingStrategy.underline_to_camel)
      .build();

    // 代码生成器配置
    AutoGenerator autoGenerator = new AutoGenerator(dataSourceConfig)
      .global(globalConfig)
      .packageInfo(packageConfig)
      .template(templateConfig)
      .strategy(strategyConfig);

    // 执行生成代码
    autoGenerator.execute();
  }

}
