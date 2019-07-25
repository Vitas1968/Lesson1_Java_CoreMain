package Lesson3;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TormentedArray
{
    HashSet<String> hashSet;
    Map<String, Integer> hm;
    static String [] arr={"Коля","Аня","Вася","Коля","Аня","Женя","Толя","Люда",
            "Коля","Витя","Леша","Аня"};

    public TormentedArray()
    {
        printArray();
    }
    public TormentedArray(String ...arr)
    {
        this.arr=arr;
        printArray();
    }



     public void printArray()
    {
        System.out.println("Исходный массив");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    HashSet<String> uniqValues()
    {
        System.out.println("Уникальные значения массива");
        hashSet = new HashSet <>();
        Collections.addAll(hashSet,arr);
        System.out.println(hashSet);
        return hashSet;
    }

    void duplicate()
    {
        hm = new HashMap<>();
        System.out.println("Количество повторов элементов");
        for (int i = 0; i < arr.length; i++)
        {

            Integer res = hm.get(arr[i]);

            hm.put(arr[i], res == null ? 1 : res + 1);
        }
        System.out.println(hm);
    }
}
