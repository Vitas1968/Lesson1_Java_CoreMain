package Lesson5;

public class Calculatior
{
    static final int size = 10_000_000;
    static final int h = size / 2;
    private float [] tmp1;
    private float [] tmp2;


    protected void calcTrigArray()
    {
        System.out.println(Thread.currentThread().getName());
        float[] arr = createArray();

        System.out.println("Время расчета значений линейным способом,ms-> "+calculate(arr));
        System.out.println();

    }


    private float[] createArray()
    {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i]=1;
        }
        return arr;
    }

    private long calculate(float[] arr)
    {
        long start = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++)
        {
            arr[i]= (float)(arr[i] * Math.sin(0.2f + i / 5)
                    * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return System.currentTimeMillis()-start;
    }

    protected  void  newCalcTrigArrayThread()
    {

        float[] arr = createArray();
        calculate(arr);
         tmp1=new float[h];
         tmp2=new float[h];



        long start = System.currentTimeMillis();
        System.arraycopy(arr, 0, tmp1, 0, h);
        System.arraycopy(arr, h, tmp2, 0, h);
        System.out.println("Разбивка массива,мс -> "+(System.currentTimeMillis()-start) );

        Thread thread1= new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("Запуск потока "+Thread.currentThread().getName());
                tmp1=caclTryg(tmp1);

            }
        });
        thread1.start();
        Thread thread2=new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("Запуск потока "+Thread.currentThread().getName());
               tmp2= caclTryg(tmp2);

            }
        });
        thread2.start();
        try
        {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }


        start = System.currentTimeMillis();
        System.arraycopy(tmp1, 0, arr, 0, h);
        System.arraycopy(tmp2, 0, arr, h, h);
        System.out.println("Склейка массива,мс -> "+(System.currentTimeMillis()-start));


    }

    private   float[] caclTryg(float[] arr)
    {
       long start = System.currentTimeMillis();
        for (int i = 0; i <arr.length ; i++)
        {
            arr[i]=(float)(arr[i] * Math.sin(0.2f + i / 5)
                    * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Расчет значений для "+Thread.currentThread().getName()
                +" ,мс -> "+(System.currentTimeMillis()-start));
        return arr;

    }


}
