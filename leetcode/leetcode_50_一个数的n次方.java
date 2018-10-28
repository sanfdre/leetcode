package leetcode;

public class leetcode_50_一个数的n次方 {
    public static void main(String[] args) {
        leetcode_50_一个数的n次方 l = new leetcode_50_一个数的n次方();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        System.out.println(Math.abs(Integer.MIN_VALUE));
        System.out.println(-5>>1);
        System.out.println(l.myPow(2.0,-3));
    }

    /**
     * 针对除二和判断是否是偶数采用位运算提高效率
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 0) return 0;
        if(n==Integer.MIN_VALUE) {
            return 1/(pow(x,Integer.MAX_VALUE)*x);
        }
        double result =  pow(x, Math.abs(n));
        if(n<0) result = 1/result;
        return result;

    }

    public double pow(double x,int n){
        if(n==1) return x;
        double lastPow = pow(x,n>>1);
        if((n&1)==0){
            return lastPow*lastPow;
        }else {
            return lastPow*lastPow*x;
        }
    }

    /**
     * 注意这里 取绝对值后结果还是Integer.MIN_VALUE 人能够认识负数 所以不能这样直接取结果进行计算
     */
//    public double myPow(double x, int n) {
//        if(n==0) return 1;
//        if(x==0) return 0;
//        return pow(x,n);
//    }
//
//    public double pow(double x,int n){
//        double temp = x;
//        if(n==0) return 1;
//        double lastPow = pow(x,n/2);
//        if(n%2==0){
//            return lastPow*lastPow;
//        }else {
//            if(n>0){
//                return lastPow*lastPow*temp;
//            }else {
//                return lastPow*lastPow/temp;
//            }
//        }
//    }

    /**
     * 时间复杂度n 超时
     * @param x
     * @param n
     * @return
     */
//    public double myPow(double x, int n) {
//        if(n==0) return 1;
//        if(x==0) return 0;
//        int abs = Math.abs(n);
//        double result = 1;
//        for(int i = 0;i<abs;i++){
//            result = result*x;
//        }
//        if(n<0){
//            result = 1d/result;
//        }
//        return result;
//    }
}
