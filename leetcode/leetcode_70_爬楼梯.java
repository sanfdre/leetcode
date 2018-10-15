package leetcode;

public class leetcode_70_爬楼梯 {
    public int climbStairs(int n) {
        int twoB = 1;
        int oneB = 2;
        int now  = n;
        for (int i = 3;i<=n;i++){
            now = twoB+oneB;
            twoB = oneB;
            oneB = now;
        }
        return now;
    }
}
