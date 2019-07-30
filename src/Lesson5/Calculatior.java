package Lesson5;

import java.util.ArrayList;

public class Calculatior
{

//    static final int h = size / 2;
//    private float [] tmp1;
//    private float [] tmp2;
    //-----------------------------
    static final int size = 20_000_000;
    private int numberOfThreads;
    private int paramH;
    float[] mainArray;
    ArrayList<Thread> threadList;
    ArrayList <float[]> floatArrayList ;

    public Calculatior(int numberOfThreads)
    {
        this.numberOfThreads=numberOfThreads>0 ? numberOfThreads : 1;
        paramH= numberOfThreads>0 ? size/this.numberOfThreads : 1;

    }

    protected void calcTrigArray()
    {
        System.out.println("Линейный способ расчета");
        System.out.println(Thread.currentThread().getName());

        float[] arr = createArray();

        System.out.println("Время расчета значений линейным способом,ms-> "+calculate(arr));
        System.out.println();
    }

    private long calculate(float[] arr)
    {
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++)
        {
            arr[i]= (float)(arr[i] * Math.sin(0.2f + i / 5)
                    * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        }
        System.out.println();
        return System.currentTimeMillis()-start;
    }
    private float[] createArray()
    {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i]=1;
        }
        System.out.println();
        return arr;
    }

    ///////////////////////////////////////////////////////////////

//    protected  void  newCalcTrigArrayThread()
//    {
//
//        float[] arr = createArray();
//        calculate(arr);
//         tmp1=new float[h];
//         tmp2=new float[h];
//
//
//
//        long start = System.currentTimeMillis();
//        System.arraycopy(arr, 0, tmp1, 0, h);
//        System.arraycopy(arr, h, tmp2, 0, h);
//        System.out.println("Разбивка массива,мс -> "+(System.currentTimeMillis()-start) );
//
//        Thread thread1= new Thread(new Runnable()
//        {
//            @Override
//            public void run()
//            {
//                System.out.println("Запуск потока "+Thread.currentThread().getName());
//                tmp1=caclTryg(tmp1);
//
//            }
//        });
//        thread1.start();
//        Thread thread2=new Thread(new Runnable()
//        {
//            @Override
//            public void run()
//            {
//                System.out.println("Запуск потока "+Thread.currentThread().getName());
//               tmp2= caclTryg(tmp2);
//
//            }
//        });
//        thread2.start();
//        try
//        {
//            thread1.join();
//            thread2.join();
//        } catch (InterruptedException e)
//        {
//            e.printStackTrace();
//        }
//
//
//        start = System.currentTimeMillis();
//        System.arraycopy(tmp1, 0, arr, 0, h);
//        System.arraycopy(tmp2, 0, arr, h, h);
//        System.out.println("Склейка массива,мс -> "+(System.currentTimeMillis()-start));
//
//
//    }

//    private   float[] caclTryg(float[] arr)
//    {
//       long start = System.currentTimeMillis();
//        for (int i = 0; i <arr.length ; i++)
//        {
//            arr[i]=(float)(arr[i] * Math.sin(0.2f + i / 5)
//                    * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        }
//        System.out.println("Расчет значений для "+Thread.currentThread().getName()
//                +" ,мс -> "+(System.currentTimeMillis()-start));
//        return arr;
//
//    }

    ///////////////////////
    ///////////////////////


    private ArrayList <Thread> createListThreads()
    {
        threadList= new ArrayList <>(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++)
        {
            threadList.add(new MyThread(this,floatArrayList.get(i)));
        }
        return threadList;
    }

    private ArrayList <float[]> createListArray()
    {
        floatArrayList= new ArrayList <>(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++)
        {
            floatArrayList.add(new float[paramH]);
        }
        return floatArrayList;
    }

    private void createMainArray()
    {
        mainArray = new float[size];
        for (int i = 0; i < mainArray.length; i++)
        {
            mainArray[i]=1;
        }
    }

    private void disconnectArray()
    {
        int i,j;

        for (i=0,j=0; i<numberOfThreads; i++,j=i*paramH )
        {
            //System.arraycopy(mainArray, 0, tmp1, 0, h);
            System.arraycopy(mainArray, j,floatArrayList.get(i) , 0, paramH);
        }

    }

    private void connectArray()
    { //System.arraycopy(tmp1, 0, arr, 0, h);

        int i,j;

        for (i=0,j=0; i<numberOfThreads; i++,j=i*paramH )
        {
            //System.arraycopy(mainArray, 0, tmp1, 0, h);
            System.arraycopy(floatArrayList.get(i), 0,mainArray , j, paramH);
        }
    }
    protected float [] calculateTrig(float [] arr)
    {
//
        for (int i = 0; i < arr.length; i++)
        {
            arr[i]= (float)(arr[i] * Math.sin(0.2f + i / 5)
                    * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arr;
    }

    protected void mainMethod()
    {
        createMainArray();
        createListArray();
        createListThreads();

        long start = System.currentTimeMillis();
        disconnectArray();

        for (int i = 0; i < threadList.size(); i++)
        {
            threadList.get(i).start();
        }
        for (int i = 0; i < threadList.size(); i++)
        {
            try
            {
                threadList.get(i).join();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        connectArray();
        System.out.println("Время расчета значений многопоточным способом,ms-> "+
                (System.currentTimeMillis()-start));

    }


}
