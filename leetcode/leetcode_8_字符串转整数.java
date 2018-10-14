package leetcode;


/**
 * @Author: lilinglin
 * @Description:
 * @Date: Created in 2018/10/12
 */
public class leetcode_8_字符串转整数 {
    public static void main(String[] args) {
        int i = myAtoi("-000000000000001");
        System.out.println(i);
    }
    public static int myAtoi(String str) {
        int result = 0;
        boolean isPositive = true;
        str = str.trim();
        for (int i = 0;i<str.length();i++){
            char c = str.charAt(i);
            if(i==0 && (c=='+' || c=='-')){
                if(c=='-'){
                    isPositive = false;
                }
            }else if(i==0 && !(c>='0'&&c<='9')){
                return 0;
            }else {
                if(c>='0'&&c<='9'){
                    if(isPositive){
                        //正数
                        if(result>(Integer.MAX_VALUE-c+48)/10){
                            return Integer.MAX_VALUE;
                        }
                    }else {
                        //负数
                        if(result*(-1)<(Integer.MIN_VALUE+c-48)/10){
                            return Integer.MIN_VALUE;
                        }
                    }
                    result=result*10+c-48;
                }else {
                    break;
                }
            }
        }

        if(isPositive){
            return result;
        }
        return result*-1;
    }
}
