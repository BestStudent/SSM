package cn.happy.dao;

import cn.happy.entity.StudentA;
import cn.happy.entity.TeacherA;
import cn.happy.until.until;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Test20170923 {
    @Test
    public void find(){
        SqlSession session = until.getsession();
        ITeacherDAO mapper = session.getMapper(ITeacherDAO.class);
        TeacherA teacherA = mapper.findStudentByTeacherId(1);
        System.out.println(teacherA);
        System.out.println("=========================我是高贵的分割线=============================");
        TeacherA teacherB = mapper.findStudentByTeacherId(1);
        System.out.println(teacherB);
        session.close();
       /* String path = System.getProperty("java.io.tmpdir");
        System.out.println(path);*/
        }
    }

