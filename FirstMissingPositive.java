import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class FirstMissingPositive {

    //    private int[] array;
    private ArrayList<Integer> array;

    private static int maxValue(int[] arr) {
        int max = arr[0];
        for (int ktr = 0; ktr < arr.length; ktr++) {
            if (arr[ktr] > max) {
                max = arr[ktr];
            }
        }
        return max;
    }

    private static int minValue(int[] arr) {
        int min = arr[0];
        for (int ktr = 0; ktr < arr.length; ktr++) {
            if (arr[ktr] < min ) {
                min = arr[ktr];
            }
        }
        return min;
    }

    private boolean checkNumber(int value){
        for (int i = 0; i < array.size(); i++) {
            if (array.contains(value)) {
                return true;
            }
        }
        return false;
    }

    private void generateArray(int min, int length){

        for(int i =0 ; i< length; i++){
            array.add(min);
            min++;
        }
    }

    private int getValue(int[] array){

        int[] ints = {1, 2, 3};
        List<Integer> intList = new ArrayList<Integer>();
        for (int index = 0; index < ints.length; index++)
        {
            intList.add(array[index]);
        }

        for(int i = 0 ; i<intList.size(); i++){
            if(intList.get(i) <=0){
                intList.remove(i);
            }
        }

        int maxValue = Collections.max(intList);
        int minValue = Collections.min(intList);
        


    }


    public int firstMissingPositive(int[] nums) {
        int check[] = {3,4,-1,1};
        int maxCheck = 0, minCheck = 0;
        maxCheck = maxValue(check);
        minCheck = minValue(check);
        generateArray(minCheck, check.length);

        int ret = 0;
        ret = getValue(nums);

        return 0;
    }

}