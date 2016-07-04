package org.navid;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by navid on 2016-07-04.
 */
public class CollectionsVsStreams {
    public static void main(String [] args){
        System.out.println("Gor Beh");



        long start = System.currentTimeMillis();
        //usingCollections();

        usingStreams();
        long end = System.currentTimeMillis();

        System.out.println((end - start));




    }

    private static void usingStreams() {

        Random random = new Random();

        final List<Integer> list = new ArrayList();

        for (int i = 0; i < 1000000 ; i++){
            list.add(random.nextInt());
        }


        ArrayList<Integer> transactionsIds = list.stream(i -> System.out.println(i));


    }

    private static void usingCollections() {

        Random random = new Random();

        List<Integer> list = new ArrayList();

        for (int i = 0; i < 1000000 ; i++){
            list.add(random.nextInt());
        }

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
    }
}
