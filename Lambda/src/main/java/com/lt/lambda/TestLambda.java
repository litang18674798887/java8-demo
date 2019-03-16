package com.lt.lambda;

import com.lt.bean.Employee;
import org.junit.Test;

import java.util.*;

/**
 * @author : litang
 * @date : Create in 2019-03-10
 * @Description
 */
public class TestLambda {

    List<Employee> employees = Arrays.asList(
            new Employee(1,"张三", 18, 111.1),
            new Employee(2,"李四", 34, 111.1),
            new Employee(3,"王五", 53, 111.1),
            new Employee(4,"望牛", 342, 111.1),
            new Employee(5,"您", 132, 111.1),
            new Employee(6,"ninnin", 16, 50000.1)
    );


    @Test
    public void test01() {

        // 原来的匿名内部类
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };
        Set<Integer> set = new TreeSet<>(com);
    }

    // Lambda 表达式
    @Test
    public void test02() {

        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> integers = new TreeSet<>(com);
    }


    // 需求：获取当前公司中员工年龄大于35的员工信息
    @Test
    public void test3() {

        List<Employee> employees = filterEmployees(this.employees);
        for (Employee employee : employees) {
            System.out.println(employee);

        }
    }

    /**
     * 优化方式一：策略设计模式
     */
    @Test
    public void test04() {

        List<Employee> employees = filterEmployee(this.employees, new FilterEmpoyeeByAge());
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("------------");

        List<Employee> employees1 = filterEmployee(this.employees, new FilterEmpoyeeBySalary());
        for (Employee employee : employees1) {
            System.out.println(employee);

        }
    }

    /**
     * 优化方式二：匿名内部类
     */
    @Test
    public void test05() {

        List<Employee> employees = filterEmployee(this.employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() < 5000;
            }
        });
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    /**
     * 优化方式三：Lambda表达式
     */
    @Test
    public void test06() {

        List<Employee> employees = filterEmployee(this.employees, (e) -> e.getSalary() <= 5000);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    /**
     * 优化方式四 Stream API
     */
    @Test
    public void test07() {

        employees.stream()
                .filter((e) -> e.getSalary() <= 5000)
                .limit(2)
                .forEach(System.out::println);

        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }


    // 获取
    public List<Employee> filterEmployees(List<Employee> list) {

        List<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if (emp.getAge() >= 35) {
                emps.add(emp);
            }
        }
        return emps;
    }

    // 优化方式一 接口
    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp) {

        List<Employee> result = new ArrayList<>();
        for (Employee employee : list) {

            if (mp.test(employee)) {
                result.add(employee);
            }
        }
        return result;

    }


}
