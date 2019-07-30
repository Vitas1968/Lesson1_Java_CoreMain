package Lesson5;

public class MyThread extends Thread
{
    private Calculatior calculatior;
    private float [] array;


    public MyThread(Calculatior calculatior,float [] array)
    {
        this.calculatior=calculatior;
        this.array=array;
    }
    @Override
    public void run()
    {
        calculatior.calculateTrig(array);

    }
}
