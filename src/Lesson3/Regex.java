package Lesson3;

public class Regex
{
    public static void main(String[] args)
    {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;


        String passWord = "12GHJdghjJK@";


        for (int j = 0; j < passWord.length(); j++)
        {
            // символ цифра
            if (Character.getType(passWord.charAt(j))==9) {count1++; }
            // маленькая буква
            if (Character.getType(passWord.charAt(j))==2) {count2++; }
            // большая буква
            if (Character.getType(passWord.charAt(j))==1) {count3++;}
            // спецсимволы
            if (Character.getType(passWord.charAt(j))==24 ||
                    Character.getType(passWord.charAt(j))==25 ||
                    Character.getType(passWord.charAt(j))==26) {count4++;}
        }
        if (passWord.length()>8 && passWord.length()<=20 ) count5++;

        if(count1!=0  && count2!=0&& count3!=0&& count4!=0&& count5!=0)
            System.out.println("Пароль корректный");
        else System.out.println("Пароль некорректный");


    }
}
