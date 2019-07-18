package Lesson2.ExeptionTask;

import java.util.IllegalFormatException;

public class Main
{
    static String [][]array3x3 =
            {       {"1","2","3"},
                    {"4","5","6"},
                    {"7","8","9"}};
    static String [][]array4x4 =
            {       {"1","2","3","4"},
                    {"5","6","7","8"},
                    {"9","10","11","12"},
                    {"13","14","15","z"}};

    public static void main(String[] args)
    { int res=0;
        try
        {
            res=sumItemsArray(array4x4);

        } catch (MyArrayDataException e){
            System.out.println(e.getMessage()+" "+e.getNumber());
        }catch (MyArraySizeException e){
            System.out.println(e.getMessage());
            System.out.println("Введите массив с корректным размером");
            //System.exit(0);
        }
        System.out.println("Результат = "+res);



    }

    // проверка размерности массива

    static int sumItemsArray(String [][]array) throws MyArraySizeException, MyArrayDataException
    { int result = 0;
        if(array.length!=4 && array[1].length!=4 ) throw new MyArraySizeException("Неверный размер массива");

        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[1].length; j++)
            {
                try
                {
                    result += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException("В ячейке " +
                        "["+i+"] ["+j+"] содержится: ", array[i][j]);
                }
            }
        }
        return result;
    }

}

class MyArraySizeException extends Exception
{
    public MyArraySizeException(String message)
    {

        super(message);
    }


}

class MyArrayDataException extends NumberFormatException
{
    private String number;
    public String getNumber()
    {
        return number;
    }
    public MyArrayDataException(String message, String num){

        super(message);
        number=num;
    }
}
