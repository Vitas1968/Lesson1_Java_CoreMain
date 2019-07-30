package Lesson5;

public class MainTesThread
{
    public static void main(String[] args)
    {
        int numberOfThreads = 4;
        Calculatior calc = new Calculatior(numberOfThreads);
        calc.calcTrigArray();
        calc.mainMethod();

    }
}
