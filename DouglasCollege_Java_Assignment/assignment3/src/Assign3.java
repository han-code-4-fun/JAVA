import java.io.*;
import java.lang.management.MemoryManagerMXBean;
import java.util.*;



import java.text.*;  // For NumberFormat
import static java.lang.System.out;

public class Assign3 {

    public static void main(String[] args) {

        Scanner myScan = new Scanner(System.in);
        Assign3 myMethod = new Assign3();

        String names[] = {"Carol Danvers","halo JOnes", "lex LUthor", "NEal adams",
                "halo Jones","theo KOjak", "david starsky",
                "clark KEnt", "Carol Danvers","bruce LEE", "bruce WAYne","donald trump",
                "NEal adams", "DONAld TRump", "david starsky", "clark KEnt", "Bruce Lee",
                "bruce WAYne","xavier chuck", "donald trump","JAck Kirby","LOis LAne",
                "LAdy Penelope","DIana Prince","Carol Danvers","","","","",""};
        
       
        //String input = myScanner.nextLine();
        boolean exit = false;
        int[] test = new int[5];
        
        String input;

        myMethod.sortArray(names);
        out.println("Alphabetical Order");
        myMethod.displayArray(names);
        
        
		do {
			out.print("Please enter name to search or remove (-) (0 to Exit):");
			input = myScan.nextLine();
			if(input.charAt(0) == '-')
			{
				input = input.replace('-', ' ').trim();
				myMethod.removeNames(names, input);
				myMethod.searchAllName(names, input);
			}else if(input.charAt(0) == '0')
			{
				exit = true;
			}else {
				myMethod.searchAllName(names, input);
			}

		}while(exit == false);
		
		

    }
    
    private  void  displayArray(String[] a)
    {

        for (int i = 0; i < a.length; i++)
        {
            if(a[i].equals(""))
            {
                out.println((i+1)+ "----- " +"== Empty ==");
            }else {
                out.println((i+1)+ "----- " +a[i]);
            }

        }
    }


    private void sortArray(String input[])
    {
        int numberOfDisqualifiedElement = countEmptyElement(input);
        bubbleSort( input, numberOfDisqualifiedElement) ;

    }

    private  void  bubbleSort(String[] temp, int numberOfDisqualifiedElement)
    {
        int qualifiedNumber = temp.length-numberOfDisqualifiedElement;
        String tempSwap;
        for (int i = 1; i < qualifiedNumber; i++) {
            for (int j = 0; j < qualifiedNumber-1; j++) {
                if(temp[j].compareToIgnoreCase(temp[j+1])  >  0)
                {
                    tempSwap = temp[j];
                    temp[j]= temp[j+1];
                    temp[j+1] = tempSwap;
                }

            }
        }
        for (int i = qualifiedNumber; i < temp.length; i++)
        {
            temp[i]= "";
        }
    }


    private int countEmptyElement(String[] input)
    {
        int numberOfDisqualifiedElement = 0;
        for (int i = 0; i < input.length; i++) {
            if(input[i] == ""){
                numberOfDisqualifiedElement++;
            }
        }
        return numberOfDisqualifiedElement;

    }

    private int binSrch(String[] input, String keyword)
    {
        int left = 0;
        int right = input.length- countEmptyElement(input) -1;
        int middle;

        while(left <= right) {
            //all relationships stays inside the loop before break out
            middle = left+ (right-left)/2;
            if(input[middle].compareToIgnoreCase(keyword) == 0)
            {
                return middle;
            }
            if(input[middle].compareToIgnoreCase(keyword)>0) {
                right = middle-1;

            }else {
                left = middle +1;
            }
        }

        return  -1;
    }



    private void searchAllName(String[] inputArray, String keyword)
    {
        //add one more number, last number as indicator for valid number in the array
        int [] positionForSearchResult = new int[inputArray.length+1];
        //array contains position of  keyword
        int counterforArray =0;
        int[] finalPosition; //sorted array contains position of valid keyword

        if(checkArrayEmpty(inputArray) == false)//array is not empty
        {


            positionForSearchResult= linearNBinarySrch(inputArray, keyword,positionForSearchResult,counterforArray);
            finalPosition = new int[positionForSearchResult[inputArray.length]];
            finalPosition = sortAndOptimizeIntArray(positionForSearchResult, inputArray.length);
            printSearchResult(finalPosition, keyword);

        }else  //array is empty
        {
            out.println("There are No names left to search/remove");
        }

    }

    private int[] sortAndOptimizeIntArray(int[] positionForSearchResult, int lastPosition )
    {
        int finalPositionResult[] = new int[positionForSearchResult[lastPosition]];
        for (int i = 0; i < positionForSearchResult[lastPosition]; i++) {
            finalPositionResult[i]= positionForSearchResult[i];
        }
        int tempSwap;
        for (int i = 1; i < finalPositionResult.length; i++) {
            for (int j = 0; j < finalPositionResult.length-1; j++) {
                if(finalPositionResult[j] > finalPositionResult[j+1])
                {
                    tempSwap = finalPositionResult[j];
                    finalPositionResult[j]= finalPositionResult[j+1];
                    finalPositionResult[j+1] = tempSwap;
                }

            }
        }


        return finalPositionResult;

    }

    private int[] linearNBinarySrch(String[] inputArray,
                                   String keyword,
                                   int[] position,
                                   int counter)
    {
        int numberOfValidElement = 0;
        if(binSrch(inputArray, keyword) !=  -1) {
            
            int binSrchResult = binSrch(inputArray, keyword);


            position[counter] = binSrchResult;
            counter++;
            numberOfValidElement++;


            while(binSrchResult > 0 &&
                    inputArray[binSrchResult-1].compareToIgnoreCase(keyword) == 0)
            {
                position[counter] = (binSrchResult-1);
                counter++;
                numberOfValidElement++;
                binSrchResult--;
            }
            binSrchResult = binSrch(inputArray, keyword);

            while(inputArray[binSrchResult+1].compareToIgnoreCase(keyword) == 0)
            {
                position[counter] = (binSrchResult+1);
                counter++;
                numberOfValidElement++;
                binSrchResult++;
            }

            position[inputArray.length] = numberOfValidElement;

        }else {
            out.println(keyword+ " is not found");
        }

        return position;
    }



    private boolean checkArrayEmpty(String[] inputArray)
    {
        boolean output;
        for (int i = 0; i < inputArray.length; i++)
        {
            if(inputArray[i] != "" && inputArray[i] != "zzzzzzz") {
                output = false;//array is not empty
                return output;
            }
        }
        output = true; //array is empty
        return output;
    }

    public void removeNames(String[] inputArray, String keyword)
    {
        int removePosition;
        while(binSrch(inputArray, keyword) !=  -1)
        {
            removePosition= binSrch(inputArray, keyword);
            inputArray[removePosition] = "zzzzzzz";

            sortArray(inputArray);

        }
    }

    public void printSearchResult(int[] inputIntArray, String keyword)
    {
        boolean first = true;
        if(inputIntArray.length > 0) {
        	   out.println(keyword+" is located in");
               for (int i = 0; i < inputIntArray.length; i++)
               {

                   if(first) {
                       out.println("position "+ (inputIntArray[i]+1));
                       first = false;
                   }else {
                      
                           out.println("and in position " +  (inputIntArray[i]+1));
                       

                   }
               }
        }
     

    }

}
