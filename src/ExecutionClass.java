import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 29.11.13
 * Time: 0:31
 * To change this template use File | Settings | File Templates.
 */
public class ExecutionClass {
    public static void main(String[] arg){
        ExecutionClass executionClass = new ExecutionClass();
        System.out.println("Choose number of task.\n " +
                "1. Adding arrays. \n " +
                "2. Merge without duplicates. \n " +
                "3. Inner Join. \n " +
                "4. Outer Join. \n " +
                "5. Left Join. \n " +
                "6. Right Join. \n " +
                "Press 7 for getting not implemented exception");
        Scanner readLine = new Scanner(System.in);
        Country Ukraine = new Country.Builder()
                .fullName("Ukraine")
                .capital("Kiev")
                .shortCode("UA")
                .build();
        Country France = new Country.Builder()
                .fullName("France")
                .capital("Paris")
                .shortCode("FR")
                .build();
        Country Poland = new Country.Builder()
                .fullName("Poland")
                .capital("Warsaw")
                .shortCode("PL")
                .build();
        Country CzechRepublic = new Country.Builder()
                .fullName("Czech Republic")
                .capital("Prague")
                .shortCode("CZ")
                .build();
        Country Italy = new Country.Builder()
                .fullName("Italy")
                .capital("Rome")
                .shortCode("IT")
                .build();
        Country Spain = new Country.Builder()
                .fullName("Spain")
                .capital("Madrid")
                .shortCode("SP")
                .build();
        Country Portugal = new Country.Builder()
                .fullName("Portugal")
                .capital("Lisbon")
                .shortCode("PT")
                .build();
        Country Russia = new Country.Builder()
                .fullName("Russia")
                .capital("Moskow")
                .shortCode("RU")
                .build();
        Country [] firstArray = new Country[]{ Poland, Portugal, Ukraine, Spain, Italy};
        Country [] secondArray = new Country[]{Portugal, CzechRepublic, France, Russia, Poland};
        switch (readLine.nextInt()){
            case 1: executionClass.Task1(firstArray, secondArray); break;
            case 2: executionClass.Task2(firstArray, secondArray); break;
            case 3: executionClass.Task3(firstArray, secondArray); break;
            case 4: executionClass.Task4(firstArray, secondArray); break;
            case 5: executionClass.Task5(firstArray, secondArray); break;
            case 6: executionClass.Task6(firstArray, secondArray); break;
            case 7: throw new NotImplementedException();
            default: System.out.println("Task does not exist!");
        }
    }

    public void Task1(Country[] arr1, Country [] arr2){
        Country [] result = AddingArray(arr1, arr2);
        printElements(result);
    }
    public void Task2(Country[] arr1, Country [] arr2){
        Country [] result = MergeArrays(arr1, arr2);
        printElements(result);
    }
    public void Task3(Country[] arr1, Country[] arr2){
        Country [] result = InnerJoin(arr1,arr2);
        printElements(result);
    }
    public void Task4(Country[] arr1, Country[] arr2){
        Country [] result = OuterJoin(arr1, arr2);
        printElements(result);
    }
    public void Task5(Country[] arr1, Country[] arr2){
        //Left Join
        Country [] result = LeftJoin(arr1, arr2);
        printElements(result);
    }
    public void Task6(Country[] arr1, Country[] arr2){
        //Right Join
        Country [] result = RightJoin(arr1, arr2);
        printElements(result);
    }

    public Country [] AddingArray(Country [] array1, Country [] array2){
        int k=array1.length+array2.length;
        Country [] result1=new Country[k];
        for(int i=0; i< array1.length;i++)
            result1[i]= array1[i];
        for(int j =0; j<array2.length; j++)
            result1[array1.length+j]= array2[j];
        return result1;
    }

    public void printElements(Country [] array){
        for (int i=0; i<array.length;i++)
            System.out.printf(i+1+ ". " + array[i].toString()+"\n");
    }

    public Country [] MergeArrays(Country [] arr1, Country [] arr2){
        Country [] rez = new Country [arr1.length+arr2.length];

        for(int i=0; i<arr1.length;i++)
            rez[i]=arr1[i];
        int index=arr1.length;
        for(int i=0; i<arr2.length; i++)
            for(int j=0; j<arr1.length;j++)
                if(arr2[i]!=arr1[j] && j==arr1.length-1){
                    rez[index]=arr2[i];
                    index++;
                } else if(arr1[j]==arr2[i]) break;
        return removeNullElements(rez, index);
    }
    public Country [] InnerJoin(Country [] arr1, Country [] arr2){
        Country [] rez=new Country[arr1.length];
        int index=0;
        for (int i=0; i<arr1.length; i++)
            for (int j=0; j<arr2.length; j++)
                if (arr1[i]==arr2[j]){
                    rez[index] = arr1[i];
                    index++;
                    break;
                }
        return removeNullElements(rez, index);
    }
    public Country [] OuterJoin(Country [] arr1, Country [] arr2){
        Country [] res = new Country[arr1.length+arr2.length];
        int index=0;
        for (int i=0; i<arr1.length;i++)
            for (int j=0; j< arr2.length; j++)
                if (arr1[i]!=arr2[j] && j==arr2.length-1){
                    res[index]=arr1[i];
                    index++;
                } else if (arr1[i]==arr2[j]) break;
        for (int i=0; i<arr2.length; i++)
            for (int j=0; j<arr1.length; j++)
                if (arr2[i]!=arr1[j] && j==arr1.length-1){
                    res[index]=arr2[i];
                    index++;
                } else if(arr1[j]==arr2[i]) break;
        return removeNullElements(res, index);
    }
    public Country [] LeftJoin(Country [] arr1, Country [] arr2){
        int k=arr1.length+arr2.length;
        Country [] result=new Country[k];
        for(int i=0; i< arr1.length;i++)
            result[i]= arr1[i];
        int index=arr1.length;
        for (int i=0; i<arr2.length; i++)
            for (int j=0; j<arr1.length; j++)
                if (arr2[i]==arr1[j]){
                    result[index] = arr1[j];
                    index++;
                    break;
                }
        return removeNullElements(result,index);
    }
    public Country [] RightJoin(Country [] arr1, Country [] arr2){
        int k=arr1.length+arr2.length;
        Country [] result=new Country[k];
        for(int i=0; i< arr2.length;i++)
            result[i]= arr2[i];
        int index=arr2.length;
        for (int i=0; i<arr1.length; i++)
            for (int j=0; j<arr2.length; j++)
                if (arr1[i]==arr2[j]){
                    result[index] = arr1[i];
                    index++;
                    break;
                }
        return removeNullElements(result,index);
    }
    public Country [] removeNullElements(Country [] arr, int countOfElements){
        Country [] rez = new Country [countOfElements];
        for (int i=0; i<countOfElements; i++)
            rez[i] = arr[i];
        return rez;
    }


}
