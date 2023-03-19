package com.backstreetbrogrammer.module1_javaFundamentalsRecap.ch02_oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImmutableClassTest {

    @Test
    void testImmutableClass() {
        final List<String> list = new ArrayList<>();
        list.add("tok1");
        list.add("tok2");

        final Map<String, String> map = new HashMap<>();
        map.put("1", "first");
        map.put("2", "second");

        final ImmutableClass obj = new ImmutableClass(101L, "ABC", list, map);
        System.out.println(obj);

        list.add("tok3");
        list.add("tok4");
        // Remains unchanged due to deep copy in constructor
        System.out.println(obj.getTokens());

        map.put("3", "third");
        map.put("4", "fourth");
        // Remains unchanged due to deep copy in constructor
        System.out.println(obj.getMetadata());
    }

}
