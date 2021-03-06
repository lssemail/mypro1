package com.erp.generator;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuai on 2016/4/16.
 */
public class Generator {

    public static void main(String[] args) {
        try {
            System.out.println("start generator ...");
            System.out.print(Generator.class.getName());
            String filePath = Generator.class.getResource("generatorConfig.xml").getFile();
            System.out.println(">>>>"+filePath);
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            File configFile = new File(filePath);
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
            System.out.println("end generator!");
            for(String e: warnings){
                System.out.println(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
