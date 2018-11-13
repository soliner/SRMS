package cn.itcast.web.listener;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class Demo1 {
	@Test
	public void fun1(){
		/**
		 * 我们现在写两个配置文件，一个文件放中文信息，另一个放英文信息
		 * 我们使用一个类，来通过语言环境，最终识别加载哪一个文件的信息：ResourceBundle
		 * 什么语言环境：Locale
		 * > zh_CN
		 * > en_US
		 * 
		 * 资源文件的格式：基本名称+Locale部分+.properties
		 * 例如：res_zh_CN.properties,其中基本名称为res，而zh_CN是Locale的部分
		 * 必须所有的资源文件基本名称要相同！不同之处就是Locale部件
		 * 
		 */
		Locale locale = Locale.CHINA; 
		//得到ResourceBundle
		//第一个参数是：基本名称；
		//第二个参数是：Locale
		
		ResourceBundle rb = ResourceBundle.getBundle("res",locale);
		System.out.println(rb.getString("username"));
		System.out.println(rb.getString("password"));
		System.out.println(rb.getString("login"));
	}

}
