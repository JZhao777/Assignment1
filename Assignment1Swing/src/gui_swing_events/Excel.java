package gui_swing_events;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Excel {
   //Declare the private class variable
    private ArrayList<Double> arrayLst;
    
    public Excel(ArrayList<Double> arrayLst){
        arrayLst = new ArrayList<>();
        this.arrayLst = arrayLst;
    }
    //create a string constructor 
    public Excel(String myString){
        //creates a new instance of the ArrayList class and assigns it to the variable arrayLst
        arrayLst = new ArrayList<>();
        // using .split() to seperate each number
        String[] stringArray =myString.split(" "); 
        
        //using .asList() method of the "Arrays" class
        List<String> strNumList = Arrays.asList(stringArray);
        
        //Creating an ArrayList object ("ArrayList" Class) from the previous List:
        ArrayList<String> strNumArrayList =new ArrayList<String>(strNumList);
        
        //using for loop to iterate each element in strNumArrayList, and convert each 
        //element into double using Double.valueOf(), then add into arrayLst
        for (int i = 0; i< strNumArrayList.size();i++){
             String element = strNumArrayList.get(i);
             Double dElement = Double.valueOf(element);
             arrayLst.add(dElement);
        }
    }
    //create findTotal method: use for loop
    public double findTotal(){
        double total=0.0;
        for (double number : arrayLst){
            total = total + number;
        }
        return total;
    }

    //create findAverage method 
    public double findAverage(){
        //if the length of arrayLst is 0, return 0
        if (arrayLst.size()==0){
            return 0;
        }
        //otherwise return the average by diving the size of the arrayLst
        return findTotal()/arrayLst.size();
    }

    //create findMax method
    public double findMax(){
        // if there is no element in the list, return 0
        if (arrayLst.size()==0){
            return 0;
        }
        //assume the first element is the max
        double max = arrayLst.get(0);

        //compare it with each element in the list
        //if any element is greater than max, set it to max
        for(double number : arrayLst){
            if (number > max){
                max = number;
            } 
        }
        return max;
    }

    //create findMin method
    public double findMin(){
       // if there is no element in the list, return 0
        if (arrayLst.size()==0){
            return 0;
        }
         //assume the first element is the min
        double min = arrayLst.get(0);

        //compare it with each element in the list
        //if any element is lesser than min, set it to min
        for(double number: arrayLst){
            if (number< min){
                min = number;
            }
        }
        return min;

    }

}
