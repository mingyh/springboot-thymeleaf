package cn.ming.dao;

import cn.ming.pojo.Department;
import cn.ming.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ASUS on 2020/8/10.
 */
@Repository
public class EmployeeDao {
    //模拟数据库数据
    private static Map<Integer,Employee> employees = null;
    //员工有所属部门
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees = new HashMap<Integer,Employee>();  //创建部门表
        employees.put(1001,new Employee(1001,"AA","741168@qq.com",1,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","741168@qq.com",0,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"CC","741168@qq.com",1,new Department(103,"教研部")));
        employees.put(1004,new Employee(1004,"DD","741168@qq.com",0,new Department(104,"财务部")));
        employees.put(1005,new Employee(1005,"EE","741168@qq.com",0,new Department(105,"后勤部")));
    }

    private static Integer initId = 1006;

    //增加一个员工
    public void save(Employee employee){
        if (employee.getId() == null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    //查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    public void delete(Integer id){
        employees.remove(id);
    }


}
