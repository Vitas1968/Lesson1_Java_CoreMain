package Lesson5;

public class MainTesThread
{
    public static void main(String[] args)
    {
        int numberOfThreads = 2;
        Calculatior calc = new Calculatior();
        calc.calcTrigArray();
        calc.newCalcTrigArrayThread();

    }
}
