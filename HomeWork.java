package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeWork {

    public static void main(String[] args) {
        Serie serie = new Serie();
        HomeWork homeWork = new HomeWork();
        
        //FIND BIGGEST NUMBER IN VECTOR
        System.out.println("The biggest number is: " + homeWork.getMax(serie.getNums()));
        
        //FIND BIGGEST NUMBER IN VECTOR
        System.out.println("The smallest number is: " + homeWork.getMin(serie.getNums()));
        
        //FIND AVERAGE NUMBER IN VECTOR
        System.out.println("The averegare number is: " + homeWork.getAverage(serie.getNums()));
        
        //FIND VARIANCE NUMBER IN VECTOR
        System.out.println("The variance number is: " + homeWork.getVariance(serie.getNums()));
        
        //FIND MEDIAN NUMBER IN VECTOR
        System.out.println("The median number is: " + homeWork.getMedian(serie.getNums()));
        
        //FIND MODA NUMBER IN VECTOR
        System.out.println("The moda number is: " + homeWork.getModa(serie.getNums()));
        
        //FIND PERCENTAGE NUMBER IN VECTOR
        System.out.println("The percentage number is: " + homeWork.getPercentage(25, serie.getNums()));
        
    }
    
    public int getMax(int[] nums) {
        int biggest = 0;
        for(int num : nums) {
            if(biggest < num) biggest = num;
        }
        return biggest;
    }
    
    public int getMin(int[] nums) {
        int smallest = nums[0];
        for(int num : nums) {
            if(num < smallest) smallest = num;
        }
        return smallest;
    }
    
    public double getAverage(int[] nums) {
        double sum = 0;
        for(int num: nums) {
            sum += num;
        }
        return sum/nums.length;
    }
    
    public double getVariance(int[] nums) {
        double average = getAverage(nums);
        double variance = 0;
        for(int num : nums) {
            variance += Math.pow((num - average), 2);
        }
        
        return variance/nums.length;
    }
    
    public double getMedian(int[] nums) {
        List<Integer> intList = new ArrayList<>();
        for(int num : nums) intList.add(num);
        Collections.sort(intList);
        int middle = intList.size() / 2;
        if(intList.size() % 2 == 1) return intList.get(middle);
        return (intList.get(middle-1) + intList.get(middle)) / 2.0;
    }
    
    public int getModa(int nums[]) {
        Map<Integer, Integer> counter = new HashMap();
        
        for(int num : nums) {
            if(counter.containsKey(num)) {
                counter.put(num, counter.get(num) + 1);
            } else {
                counter.put(num, 1);
            }
        }
        
        int moda = 0;
        for(Map.Entry<Integer, Integer> entry: counter.entrySet()) {
            if(entry.getValue() > 1) {
                if(moda < entry.getValue()) moda = entry.getKey();
            }
        }
        return moda;
    }
    
    public double getPercentage(int n, int[] nums) {
        System.out.println(nums.length);
        return n * 100 / nums.length;
        
    }
    
}
