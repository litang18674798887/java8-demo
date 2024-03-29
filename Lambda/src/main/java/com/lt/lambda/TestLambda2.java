package com.lt.lambda;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * 一：Lambda 表达式的基础语法：java8中引入了一个新的操作符 "->" 该操作符称为箭头操作符或Lambda 操作符
 *                          箭头操作符将Lambda 表达式拆分为两部分
 *
 *    左侧：Lambda 表达式的参数列表
 *    右侧：Lambda 表达式中所需执行的功能，即Lambda 体
 *
 *
 *    语法格式一：无参数，无返回值
 *      () -> System.out.println("Hello Lambda!")
 *
 *    语法格式二：有一个参数，并且无返回值
 *      (x) -> System.out.println(x);
 *
 *    语法格式三：若只要一个参数，小括号可以省略不写
 *
 *    语法格式四：有两个以上的参数，并且Lambda体重有多条语句
 *       Comparator<Integer> com = (o1,o2) -> {
 *             System.out.println("函数式接口");
 *             return Integer.compare(o1,o2);
 *         };
 *
 *    语法格式五：若Lambda体重只有一条语句，return和大括号都可以省略不写
 *
 *    语法格式六：Lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器可以通过上下文推断出，数据类型，即 "类型推断"
 *      (Integer x, Integer y) -> Integer.compare(x,y);
 *
 *
 *    上联：左右遇一括号省
 *    下联：左侧推断类型省
 *    横批：能省则省
 *
 *
 *
 * 二：Lambda 表达式需要 "函数式接口" 的支持
 * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。可以使用注解 @FunctionalInterface 注解修饰
 *
 *
 *
 */
public class TestLambda2 {

    @Test
    public void test1(){

        // jdk 1.7前，必须是final
        int num = 0;

        // 原来
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World !" + num);
            }
        };
        r.run();

        System.out.println("-------------------");

        // 现在
        Runnable r1 = () -> System.out.println("Hello Lambda !");
        r1.run();
    }

    @Test
    public void test2(){

        Consumer<String > consumer = (x) -> System.out.println(x);
        consumer.accept("你好呀！小姐姐");

        // 小括号可以不写
        Consumer<String > consumer2 = x -> System.out.println(x);
        consumer2.accept("你好呀！小姐姐");
    }

    @Test
    public void test3(){

        Comparator<Integer> com = (o1,o2) -> {
            System.out.println("函数式接口");
            return Integer.compare(o1,o2);
        };
        com.compare(1,2);
    }

    @Test
    public void test4() {
        // Integer::compare 方法引用
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        com.compare(1, 2);
    }

    @Test
    public void test5(){

        // 类型推断
//        String[] strs = {"aaa","bbb","ccc"};
//        List<String> list = new ArrayList<>();

        // 1.7 不能推断
        show(new HashMap<>());
    }

    public void show (Map<String,Integer> map) {

    }

    // 需求: 对一个数进行运算
    @Test
    public void test6(){

        Integer num = operation(100, e -> e * e);
        System.out.println(num);

        System.out.println(operation(200,y -> y + 200));


    }

    public Integer operation (Integer num,MyFun mf) {
        return mf.getValue(num);
    }




}
