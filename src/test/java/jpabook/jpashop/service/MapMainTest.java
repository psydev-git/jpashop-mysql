package jpabook.jpashop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapMainTest {
    public static void main(String[] args) {
        System.out.println("LIST CREATED.");

        ArrayList list = new ArrayList();

        list.add("일");
        list.add("월");
        list.add("수");

        Iterator iter = list.iterator();

        while(iter.hasNext()==true){
            String day = (String)iter.next();
            if(day == "수"){
                iter.remove();
            }
            System.out.println("Day : " + day);
        }

        System.out.println("-----------------");
        iter = list.iterator();
        while(iter.hasNext()==true){
            String day = (String)iter.next();

            System.out.println("Day : " + day);
        }
    }
}
