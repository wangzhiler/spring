package com.qaqa.spring.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by thinkpad on 2018/6/28.
 */
public class JDBCTest {

    private ApplicationContext ctx = null;
    private JdbcTemplate jdbcTemplate;
    private EmployeeDao employeeDao;
    private DepartmentDao departmentDao;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        employeeDao = ctx.getBean(EmployeeDao.class);
        departmentDao = ctx.getBean(DepartmentDao.class);
        namedParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);
    }

    //使用具名参数时,可以使用update(String sql, SqlParameterSource paramSource)方法进行更新操作
    //1. SQL语句中的参数名和类的属性一致!
    //2. 使用SqlParameterSource的BeanPropertySqlParameterSource实现类作为参数
    @Test
    public void testNamedParameterJdbcTemplate2() {
        String sql = "INSERT INTO employees(LAST_NAME,EMAIL,DEPT_ID) VALUES (:lastName,:email,:deptId)";
        Employee employee = new Employee();
        employee.setLastName("XYZ");
        employee.setEmail("XYZ@123.com");
        employee.setDeptId(3);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(employee);
        namedParameterJdbcTemplate.update(sql, paramSource);
    }

    //可以为参数起名字
    //1. 好处: 若有多个参数,则不用再去对应位置,直接对应参数名,便于维护
    //2. 缺点: 较为麻烦
    @Test
    public void testNamedParameterJdbcTemplate() {
        String sql = "INSERT INTO employees(LAST_NAME,EMAIL,DEPT_ID) VALUES (:ln,:email,:deptid)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ln", "FF");
        paramMap.put("email", "ff@a.com");
        paramMap.put("deptid", 2);
        namedParameterJdbcTemplate.update(sql, paramMap);
    }

    @Test
    public void testDepartmentDao() {
        System.out.println(departmentDao.get(1));
    }

    @Test
    public void testEmployeeDao() {
        System.out.println(employeeDao.get(1));
    }


    //获取单个列的值,或做统计查询
    //使用queryForObject(String sql, Class<Long> requiredType)
    @Test
    public void testQuertForObject2() {
        String sql = "SELECT count(id) FROM employees";
        long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);
    }

    //查到实体类的集合
    //注意调用的不是queryForList方法
    @Test
    public void testQueryForList() {
        String sql = "SELECT ID,LAST_NAME lastName,EMAIL FROM employees WHERE ID>?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        List<Employee> employees = jdbcTemplate.query(sql, rowMapper, 5);
        System.out.println(employees);
    }

    //从数据库中获取一条记录,实际得到对应的一个对象
    //注意不是调用queryForObject(String sql, Class<Employee> requiredType, Object... args)方法!
    //而需要调用queryForObject(String sql, RowMapper<Employee> rowMapper, Object ...args)
    //1. 其中的RowMapper指定如何去映射结果集的行,常用的实现类为BeanPropertyRowMapper
    //2. 使用SQL中列的别名完成列名和类的属性名的映射,例如last_name lastName
    //3. 不支持级联属性,JdbcTemplate到底是一个JDBC的小工具,而不是ORM框架
    @Test
    public void testQueryForObject() {
        String sql = "SELECT ID,LAST_NAME lastName,EMAIL, DEPT_ID \"Department.id\" FROM employees WHERE ID=?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 1);
        System.out.println(employee);
    }

    //执行批量更新: 批量的Insert,update,delete
    //最后一个参数是Object[]的list类型: 因为修改一条记录需要一个Object的数组,那么多条不就需要多个Object的数组码
    @Test
    public void testBatchUpdate() {
        String sql = "INSERT INTO employees(LAST_NAME,EMAIL,DEPT_ID) VALUES (?,?,?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"WW", "123", 3});
        batchArgs.add(new Object[]{"EE", "123", 2});
        batchArgs.add(new Object[]{"RR", "123", 1});
        batchArgs.add(new Object[]{"TT", "123", 2});
        batchArgs.add(new Object[]{"UU", "123", 1});
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    //执行insert update delete
    @Test
    public void testUpdate() {
        String sql = "UPDATE employees SET LAST_NAME=? WHERE ID=?";
        jdbcTemplate.update(sql, "Jack", 1);
    }

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
