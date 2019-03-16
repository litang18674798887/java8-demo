package com.lt.test;

import com.lt.bean.Person;
import com.lt.utils.CollectionHelper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : litang
 * @date : Create in 2019-03-08
 * @Description
 */
public class CollectionHelperTest {


    @Test
    public void find() {

        Person person1 = new Person(1, "a");
        Person person2 = new Person(2, "b");
        Person person3 = new Person(3, "c");
        Person person4 = new Person(4, "d");
        Person person5 = new Person(5, "e");
        Person person6 = new Person(6, "f");

        List<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);
        list.add(person6);

        CollectionHelper<Person, Integer> helper = new CollectionHelper<>(list, Person::getAge);
    }

}
