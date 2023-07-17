package gui_swing_events;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Excel {
    private ArrayList<Double> arrayLst;
    public Excel(ArrayList<Double> arrayLst){
        arrayLst = new ArrayList<>();
        this.arrayLst = arrayLst;
    }
    public Excel(String myString){
        arrayLst = new ArrayList<>();
        String[] stringArray =myString.split(" ");
        List<String> strNumList = Arrays.asList(stringArray);
        ArrayList<String> strNumArrayList =new ArrayList<String>(strNumList);
        for (int i = 0; i< strNumArrayList.size();i++){
             String element = strNumArrayList.get(i);
             Double dElement = Double.valueOf(element);
             arrayLst.add(dElement);
        }

    }
    public double findTotal(){
        double total=0.0;
        for (double number : arrayLst){
            total = total + number;
        }
        return total;

    }
    public double findAverage(){
        if (arrayLst.size()==0){
            return 0;
        }
        return findTotal()/arrayLst.size();
    }
    public double findMax(){
        if (arrayLst.size()==0){
            return 0;
        }
        double max = arrayLst.get(0);
        for(double number : arrayLst){
            if (number > max){
                max = number;
            } 
        }
        return max;


    }
    public double findMin(){
        if (arrayLst.size()==0){
            return 0;
        }
        double min = arrayLst.get(0);
        for(double number: arrayLst){
            if (number< min){
                min = number;
            }
        }
        return min;

    }

}
