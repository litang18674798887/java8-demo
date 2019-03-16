package com.lt.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java8 内置的四大核心函数式接口
 *
 *
 *      Consumer<T> 消费型接口
 *          void accept(T t);
 *
 *      Supplier<T> 供给型接口
 *          T get();
 *
 *      Function<T, R> 函数型接口
 *          R apply(T t);
 *
 *      Predicate<T> 断言型接口
 *          boolean test(T t);
 *
 */
public class TestLambda3 {

    /**
     * Consumer<T> 消费型接口 ：  void accept(T t);
     */
    @Test
    public void test1 (){
        happy(1000,(e) -> System.out.println("小姐姐一次要给" + e+ "元"));
    }

    /**
     * Supplier<T> 供给型接口    T get();
     */
    @Test
    public void test2(){
        List<Integer> numberList = getNumberList(10, () -> (int) Math.random() * 1000);
        for (Integer num : numberList) {
            System.out.println(num);
        }
    }

    /**
     * Function<T, R> 函数型接口  R apply(T t);
     */
    @Test
    public void test3(){
        String newStr = strHandler("\t\t\t\t\t我叫李唐 ", (str) -> str.trim());
        System.out.println(newStr);
    }

    /**
     * Predicate<T> 断言型接口    boolean test(T t);
     */
    @Test
    public void test4(){
        List<String> list = Arrays.asList("hello", "litang", "Lambda", "xx");
        List<String> strList = filterStr(list, s -> s.length() > 4);
        for (String str : strList) {
            System.out.println(str);

        }
    }

    // 需求：将满足条件的字符串，放入集合中
    public List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> strList = new ArrayList<>();

        for (String str : list) {
            if (pre.test(str)) {
                strList.add(str);
            }
        }
        return strList;
    }


    // 需求：用于处理字符串
    public String strHandler (String str, Function<String,String> fun) {
        return fun.apply(str);

    }
    public void happy (double money, Consumer<Double> con){
        con.accept(money);
    }

    // 需求:产生指定个数的整数，并放入集合中
    public List<Integer> getNumberList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < num;i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }



}
