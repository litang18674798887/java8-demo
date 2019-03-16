package com.lt.utils;


import com.lt.bean.Person;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 在现在系统中有很多需要批量查询远程服务，提高效率。
 * 返回都是list,在使用到list的逻辑需要自己去匹配查找
 * <p>
 * 现在提供较为方便的的工具类，通过list来转换hashMap,方便使用时查找。省去转map的冗余代码
 * 只需要提供一个构建key的Function即可
 *
 * @author : litang
 * @date : Create in 2019-03-08
 * @Description
 */
public class CollectionHelper<Element, key> {

    private HashMap<key, Element> map;

    public CollectionHelper(List<Element> list, Function<Element, key> keyFunction) {
        this.map = creatMap(list, keyFunction);
    }

    public CollectionHelper(Supplier<List<Element>> supplier, Function<Element, key> keyFunction) {
        this.map = creatMap(supplier.get(), keyFunction);
    }

    private HashMap<key, Element> creatMap(List<Element> list, Function<Element, key> keyFunction) {

        return list
                .stream()
                .collect(
                        Collectors.toMap(
                                keyFunction,
                                Function.identity(),
                                (key1, key2) -> key2, HashMap::new
                        )
                );
    }

}
