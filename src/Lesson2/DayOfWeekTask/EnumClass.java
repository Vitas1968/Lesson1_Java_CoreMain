package Lesson2.DayOfWeekTask;

import java.util.Scanner;

public class EnumClass
{
    final static int work_hours_week = 40;
    final static int work_hours_day = 8;
    DaysOfWeek daysOfWeek;
    String day;


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        EnumClass enumClass = new EnumClass();

        enumClass.day = scanner.nextLine();
        //System.out.println(enumClass.day);

        //enumClass.day=enumClass.daysOfWeek.Понедельник.toString();

        switch (enumClass.day)
        {
            case "Понедельник":
                enumClass.calculate(enumClass.daysOfWeek.Понедельник);
                break;
            case "Вторник":
                enumClass.calculate(enumClass.daysOfWeek.Вторник);
                break;
            case "Среда":
                enumClass.calculate(enumClass.daysOfWeek.Среда);
                break;
            case "Четверг":
                enumClass.calculate(enumClass.daysOfWeek.Четверг);
                break;
            case "Пятница":
                enumClass.calculate(enumClass.daysOfWeek.Пятница);
                break;
            case "Суббота":
            case "Воскресенье":
                System.out.println("Выходной");
                break;
                default: System.out.println("Нет такого дня недели");
        }
    }

    void calculate(DaysOfWeek daysOfWeek)
    {
        int result=work_hours_week - (work_hours_day*daysOfWeek.ordinal());


        System.out.println("Сегодня утро "+daysOfWeek);
        System.out.println("До конца рабочей недели осталось "+result+" часов" +
                "("+result/work_hours_day+"  дней)");

    }




}
