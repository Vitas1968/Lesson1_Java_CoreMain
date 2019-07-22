package Lesson3;

import jdk.nashorn.api.tree.ArrayLiteralTree;

import java.util.ArrayList;
import java.util.HashMap;

public class Main
{
    public static void main(String[] args)
    {
        PhoneBook phoneBook=new PhoneBook();
        phoneBook.add("Bill","89039872345");
        phoneBook.add("Stiv","8902456997","89039872345");
        phoneBook.add("Kate","89039872345","8902456997","8902456997");
        phoneBook.add("Bob","89039872345","89039872345","89039872345","89039872345");
        phoneBook.add("Arni","89039872345","89039872345","89039872345","89039872345","89039872345");
        phoneBook.add("Lucy","89039872345","89039872345","89039872345","89039872345","89039872345","89039872345");


        System.out.println(phoneBook.get("Kate"));
        System.out.println(phoneBook.get("Bob"));
        System.out.println(phoneBook.get("Arni"));
        System.out.println(phoneBook.get("Lucy"));






    }
}
