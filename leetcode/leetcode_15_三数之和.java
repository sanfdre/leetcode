package leetcode;

import java.util.*;

public class leetcode_15_三数之和 {
    public static void main(String[] args) {
        leetcode_15_三数之和 l = new leetcode_15_三数之和();
        int[] nums = {-1,0,1,2,-1,-4};
        l.threeSum(nums);
    }

    /**
     * 排序 指针往中间夹 任然o(n2) 再循环的时候进行判断  避免添加重复的结果集
     * 避免对resultLists进行去重判断  否则任然超时
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultLists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0;i<nums.length-1;i++){
            if(i==0 || nums[i]!=nums[i-1]){ //去重 切记 必须加
                if(nums[i]>0) break;
                int target = 0-nums[i];
                int l = i+1;
                int r = nums.length-1;
                while (l<r){
                    int sum = nums[l]+nums[r];
                    if(sum==target){
                        resultLists.add(Arrays.asList(nums[i],nums[l],nums[r]));
                        while (l<r&&nums[l]==nums[l+1]) l++; //去重 切记 必须加
                        while (l<r&&nums[r]==nums[r-1]) r--; //去重 切记 必须加
                        l++;
                        r--;
                    }
                    if(sum<target){
                        l++;
                    }else if(sum>target){
                        r--;
                    }
                }
            }
        }
        return resultLists;
    }


    /**
     * 此方法  通过空间换时间  hashmap  时间复杂度为o(n2) 超时 空间复杂度o(1)
     */
//    public List<List<Integer>> threeSum(int[] nums) {
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for (int i = 0;i<nums.length;i++){
//            Integer num = map.get(nums[i]);
//            if(num == null){
//                num = 1;
//            }else {
//                num++;
//            }
//            map.put(nums[i],num);
//        }
//        HashSet<String> set = new HashSet<>();
//        List<List<Integer>> resultList = new ArrayList<>();
//        for (int i = 0;i<nums.length;i++){
//            for (int j = i+1;j<nums.length;j++){
//                int target = 0-nums[i]-nums[j];
//                int num = 1;
//                if(nums[i]==target) num++;
//                if(nums[j]==target) num++;
//                Integer remainTarget = map.get(target);
//                if(remainTarget==null) remainTarget = 0;
//                if(remainTarget>=num){
//                    if(!set.contains(getSortString(target,nums[i],nums[j]))){
//                        set.add(getSortString(target,nums[i],nums[j]));
//                        List<Integer> list = new ArrayList<>();
//                        list.add(target);
//                        list.add(nums[i]);
//                        list.add(nums[j]);
//                        resultList.add(list);
//                    }
//                }
//            }
//        }
//        return resultList;
//    }
//
//    public int getMax(int a,int b,int c){
//        if(a>=b&&a>=c) return a;
//        if(b>=a&&b>=c) return b;
//        return c;
//    }
//
//    public String getSortString(int a,int b,int c){
//        int max,middle,min;
//        max = getMax(a, b, c);
//        if(max==a){
//            if(b==Math.max(b,c)){
//                middle=b;min=c;
//            }else {
//                middle=c;min=b;
//            }
//        }else if(max==b){
//            if(a==Math.max(a,c)){
//                middle=a;min=c;
//            }else {
//                middle=c;min=a;
//            }
//        }else {
//            if(a==Math.max(a,b)){
//                middle=a;min=b;
//            }else {
//                middle=b;min=a;
//            }
//        }
//        return ""+max+","+middle+","+min;
//    }
}
