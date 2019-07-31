package Lesson5;

public class MainTesThread
{
    public static void main(String[] args)
    {
        // задаём число потоков
        int numberOfThreads = 4;
        Calculatior calc = new Calculatior(numberOfThreads);
        // расчет линейеым способом
        calc.calcTrigArray();
        // расчет многопоточным способом
        calc.mainMethod();

    }
}
