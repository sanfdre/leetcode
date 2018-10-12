package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: lilinglin
 * @Description:
 * @Date: Created in 2018/10/12
 */
public class 两数之和1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int index = nums[i];
            int remain = target-index;
            Integer targetIndex = map.get(remain);
            if(targetIndex!=null){
                result[0] = i;
                result[1] = targetIndex;
                return result;
            }
            map.put(index,i);
        }
        return result;
    }
}
