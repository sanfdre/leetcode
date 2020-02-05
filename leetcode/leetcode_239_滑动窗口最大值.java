package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lilinglin
 * @date 2020/2/3 21:53
 */
public class leetcode_239_滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
       if(nums.length*k==0){
           return new int[0];
       }
       Deque<Integer> deque = new LinkedList<>();
       int[] result = new int[nums.length-k+1];

       for(int i = 0; i<nums.length;i++){
           if (deque.size() != 0) {
               while (deque.size() > 0 && deque.getFirst() < i - k + 1) {
                   deque.removeFirst();
               }

               while (deque.size() > 0 && nums[deque.getLast()] <= nums[i]) {
                   deque.removeLast();
               }

           }
           deque.add(i);
           if(i+1>=k){
               result[i-k+1] = nums[deque.getFirst()];
           }
       }
       return result;
    }

    public static void main(String[] args) {
        leetcode_239_滑动窗口最大值 leetcode_239_滑动窗口最大值 = new leetcode_239_滑动窗口最大值();
        int[] a = {1,3,1,2,0,5};
        for (int i : leetcode_239_滑动窗口最大值.maxSlidingWindow(a, 3)) {
            System.out.println(i);
        }
    }
}
