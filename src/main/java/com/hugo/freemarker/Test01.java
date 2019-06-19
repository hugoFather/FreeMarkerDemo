package com.hugo.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.HashMap;

/**
 * Create by Administrator on 2019-06-19.
 */
public class Test01 {

    public static void main(String[] args)throws Exception {
        // 1.设置配置类
        Configuration configuration = new Configuration(Configuration.getVersion());
        //2. 设置模板所在的目录
        //基于文件系统路径
//        configuration.setDirectoryForTemplateLoading(
//                new File("C:\\Users\\Administrator\\Desktop/FreeMarkerDemo/src/main/resources/"));
        //基于target后的目录 需要以 "/" 开头
        configuration.setClassForTemplateLoading(Test01.class,"/");
        //基于WebRoot下setServletContextForTemplateLoading

        //3.设置字符集
        configuration.setDefaultEncoding("utf-8");
        //4.加载模板
        Template template = configuration.getTemplate("test.ftl");
        //5.创建数据模型
        HashMap map = new HashMap();
        map.put("name", "周杰伦");
        map.put("message", "我是你的老歌迷了");
        //6.创建Writer对象
//        FileWriter writer = new FileWriter(new File("E:/freemaker/test.html"));
        StringWriter sw = new StringWriter((int) (10 * 1.2));
        //7.输出数据模型到文件中  可选输出到模型中，还是字符串中
        template.process(map, sw);
        System.out.println(sw.toString());
        //8.关闭Writer对象
        sw.close();
    }

}
