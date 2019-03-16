package com.lt.lambda;

import com.lt.bean.Employee;

/**
 * @author : litang
 * @date : Create in 2019-03-11
 * @Description
 */
public class FilterEmpoyeeByAge implements  MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 35;
    }
}
