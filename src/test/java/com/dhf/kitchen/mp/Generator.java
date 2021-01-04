package com.dhf.kitchen.mp;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @Author : FangWanJun
 * @Date : created in 13:30 2020/11/13
 */
public class Generator {

    public static final String DB_URL = "jdbc:mysql://localhost:3306/kitchen?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&&serverTimezone=Asia/Shanghai";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "root";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String AUTHOR = "fangwanjun";
    //生成的文件输出到哪个目录
    public static final String OUTPUT_FILE = "F:\\javawebDemo\\esint_demo\\src\\main\\java";

    //包名，会按照com/example/demo这种形式生成类
    public static final String PACKAGE = "com.dhf.esint_demo.system";
    //TODO 更多配置请参考http://mp.baomidou.com/#/generate-code

    public void generateByTables(boolean serviceNameStartWithI, String... tableNames) {
        GlobalConfig config = new GlobalConfig();
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig
                .setUrl(DB_URL)
                .setUsername(USER_NAME)
                .setPassword(PASSWORD)
                .setDriverName(DRIVER);
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setEntityLombokModel(false)
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(false)
                .setAuthor(AUTHOR)
                .setOutputDir(OUTPUT_FILE)
                .setFileOverride(true);
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(PACKAGE)
                                .setController("controller")
                                .setEntity("model")
                ).execute();
    }


}
