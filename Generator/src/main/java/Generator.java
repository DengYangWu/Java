import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.config.xml.MyBatisGeneratorConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import javax.naming.ConfigurationException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Generator {
    public static void main(String[] args)throws Exception{
        List<String> warnings=new ArrayList<String>();
        boolean overwirte=true;
        File configFile = new File("src/main/resources/GeneratorConfig.xml");
        ConfigurationParser cp=new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback=new DefaultShellCallback(overwirte);
        MyBatisGenerator myBatisGenerator=new MyBatisGenerator(config,callback,warnings);
        myBatisGenerator.generate(null);
    }
}