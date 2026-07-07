import java.util.HashMap;

class Solution {

    private HashMap<String, Integer> hash = new HashMap<>();

    public int minSubArrayLen(int target, int[] nums) {
        // want to go across the array, first in ones, then in two's
        // once a sum >= target is found, create an array between those indexes, and return it

        for (int i = 0; i < nums.length; i++){ // i is how far you go
            for (int j = 0; j < nums.length - i; j++){
                if (subSum(j, i, nums) >= target){
                    return i+1;
                }
            }
        }

        return 0;
    }

    private int subSum(int start, int length, int[] arr){
        int rv = 0;

        if (length == 0){
            hash.put(start+","+length, arr[start]);
            return arr[start];
        }

        rv = hash.get(start+","+(length-1)) + arr[start+length];
        hash.put(start+","+length, rv);

        // for (int i = start; i <= start + length; i++){
        //     rv += arr[i];
        // }
        return rv;
    }
}