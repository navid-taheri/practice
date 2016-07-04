package org.navid;

import java.util.Arrays;

/**
 * Created by navid on 2016-07-04.
 */
public class Test {
    public static void main(String [] args) {
        Arrays.asList(1,2,3,4,5).stream().forEach(i -> System.out.println(i));
    }

}
