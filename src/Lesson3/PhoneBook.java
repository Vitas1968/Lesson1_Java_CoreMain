package Lesson3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PhoneBook
{
    HashMap<String, ArrayList<String>> phoneBook;
    String name;
    ArrayList<String> phoneNumbers;

    public PhoneBook()
    {
        phoneBook= new HashMap <>();
    }

    void add(String name, String... phones)
    {
        phoneNumbers=new ArrayList <>();
        this.name = name;
        Collections.addAll(phoneNumbers,phones);
        phoneBook.put(this.name,phoneNumbers);
    }

    ArrayList<String> get(String name)
    {
        return phoneBook.get(name);
    }


}
