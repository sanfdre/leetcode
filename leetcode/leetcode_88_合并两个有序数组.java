package leetcode;

public class leetcode_88_合并两个有序数组 {
    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};
        merge(nums1,0,nums2,1);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m-1;
        int index2 = n-1;
        int index = m+n-1;
        while (index1>=0&&index2>=0){
            int num1 = nums1[index1];
            int num2 = nums2[index2];
            if(num1>num2){
                nums1[index] = num1;
                index1--;
            }else {
                nums1[index] = num2;
                index2--;
            }
            index--;
        }
        if(index2>=0){
            for (int i = index2;i>=0;i--){
                nums1[i] = nums2[i];
            }
        }
    }
}
