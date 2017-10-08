package cn.happy.day01;

import cn.print.paper.Paper;
import cn.print.print.Print;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHappyService {
    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Print print = (Print) context.getBean("printer");
        print.print();
    }

}