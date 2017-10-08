package cn.happy.dao;

import cn.happy.entity.DeptNew;
import cn.happy.entity.StudentNew;
import cn.happy.entity.dept;
import cn.happy.entity.student;
import cn.happy.until.until;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Test20170921 {
    @Test
    public void findstubydept() {
        SqlSession session = until.getsession();
        DeptNewDAO mapper = session.getMapper(DeptNewDAO.class);
        DeptNew studentByDeptId = mapper.findStudentByDeptId(1);
        System.out.println(studentByDeptId.getDid());
        System.out.println(studentByDeptId.getDname());
       for (StudentNew item:studentByDeptId.getStudents()){
           System.out.println(item.getId()+item.getName());
       }
    }


}