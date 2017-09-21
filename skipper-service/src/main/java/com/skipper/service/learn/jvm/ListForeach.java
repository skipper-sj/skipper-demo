package com.skipper.service.learn.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListForeach {

    public List<Integer> prepare(Integer count) {
        List<Integer> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        Integer count = 10000000;
        ListForeach listForeach = new ListForeach();
        List<Integer> list = listForeach.prepare(count);
        long time = System.currentTimeMillis();
        Integer result = 0;
        List<Integer> newlist = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (i > 2000 && i < 50000) {

                newlist.add(list.get(i));
            }

        }
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        Integer result2;
        list.stream().filter(number -> (number > 2000 && number < 50000)).collect(Collectors.toList());

        System.out.println(System.currentTimeMillis() - time);
    }

}
