package org.navid;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by navid on 2016-07-04.
 */
public class CollectionsVsStreams {
    public static void main(String [] args){
        Random random = new Random();

        final List<Integer> list = new ArrayList();

        for (int i = 0; i < 10000000 ; i++){
            list.add(random.nextInt());
        }
        usingStreams(list);
        usingCollections(list);
        //usingParallelStreams(list);


    }


    private static void usingStreams(List<Integer> list) {
        long start = System.currentTimeMillis();

       List<String> transactionsIds = list.stream()
               .filter(i -> i % 2 == 0)
               .sorted()
               .map(i -> Integer.toString(i))
               .collect(Collectors.toList());

        long end = System.currentTimeMillis();
        System.out.println("Streams:");
        System.out.println((end - start));


    }

    private static void usingCollections(List<Integer> list) {
        long start = System.currentTimeMillis();

        List<Integer> evenList = new ArrayList();

        for (Integer i : list){
            if (i % 2 == 0){
                evenList.add(i);
            }
        }

        Collections.sort(evenList);

        List<String> sortedStringList = new ArrayList();

        for (Integer i : evenList){
            sortedStringList.add(String.valueOf(i));
        }

        long end = System.currentTimeMillis();
        System.out.println("Collections:");
        System.out.println((end - start));


    }

}
