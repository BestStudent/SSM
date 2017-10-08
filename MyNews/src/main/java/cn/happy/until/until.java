package cn.happy.until;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class until {
    static String resource="mybatis-config.xml";
    static InputStream is;
    static SqlSessionFactory factory ;
    static{
        try {
            is  = Resources.getResourceAsStream(resource);
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  static SqlSession getsession(){
        return  factory.openSession(true);
    }
}