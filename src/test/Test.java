package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args){

        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(0);
        list.addFirst(9);
        list.addFirst(10);
        Integer res =list.get(new Integer(0));
        System.out.println(list.get(new Integer(0)));

    }
}
