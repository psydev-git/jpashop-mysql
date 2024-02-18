package jpabook.jpashop.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForEachMainTest {

    public static void main(String[] args) {


        String[] booksName = {"해리포터", "반지의제왕", "타이타닉"};
        List<String> booksNames = new ArrayList<>(Arrays.asList(booksName));

     //   booksNames.forEach();

        for (String bookName : booksNames) {
            System.out.println(bookName);
        }
        System.out.println("--------------------------------");
        booksNames.forEach(str -> System.out.println(str));

    }
}
