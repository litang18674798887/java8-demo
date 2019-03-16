package com.lt.lambda;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : litang
 * @date : Create in 2019-03-06
 * @Description
 */
public class Test01 {

    @Test
    public void test01 (){

        List<String> collected = Stream.of("a","b","c").collect(Collectors.toList());

    }

}
