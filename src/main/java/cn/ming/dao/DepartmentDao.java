package cn.ming.dao;

import cn.ming.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ASUS on 2020/8/10.
 */
//部门dao
@Repository
public class DepartmentDao {
    //模拟数据库数据
    private static Map<Integer,Department> departments = null;
    static {
        departments = new HashMap<Integer,Department>();  //创建部门表
        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"市场部"));
        departments.put(103,new Department(103,"教研部"));
        departments.put(104,new Department(104,"财务部"));
        departments.put(105,new Department(105,"后勤部"));
    }

    //获取所有部分信息
    public Collection<Department> getDepartment(){
        return departments.values();
    }

    //通过id得到部门
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}
