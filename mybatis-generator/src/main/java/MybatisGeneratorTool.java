import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MybatisGeneratorTool {

	public static void main(String[] args) {
		System.out.println("========================================");
		System.out.println("Mybatis数据库代码自动转换开始");
		List<String> warnings = new ArrayList<String>();
		boolean orverwrite = false;
		String genConfigFilePath = "/mybatis-generator/generatorConfig.xml";
		URL url = MybatisGeneratorTool.class.getResource(genConfigFilePath);
		System.out.println("配置文件路径："+url.getPath());
		File configFile = new File(MybatisGeneratorTool.class.getResource(genConfigFilePath).getFile());
	
		ConfigurationParser cp = new ConfigurationParser(warnings);
	
		Configuration config = null;
	
		try {
			config = cp.parseConfiguration(configFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DefaultShellCallback callback = new DefaultShellCallback(orverwrite);
		
		MyBatisGenerator myBatisGenerator = null;
		
		try {
			myBatisGenerator = new MyBatisGenerator(config,callback,warnings);
		} catch (InvalidConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			myBatisGenerator.generate(null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Mybatis数据库代码自动转换结束");
		System.out.println("========================================");
		
	}

}
