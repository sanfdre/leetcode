package leetcode;

public class leetcode_125_验证回文串 {
    public boolean isPalindrome(String s) {
        if(s==null || s=="") return true;
        int length = s.length();

        int index1 = 0;
        int index2 = length-1;

        while (index1<=length-1&&index2>=0){
            while (index1<=length-1&&!checkIsChar(s.charAt(index1))){
                index1++;
            }

            while (index2>=0&&!checkIsChar(s.charAt(index2))){
                index2--;
            }

            if(index1>length-1&&index2<0) return true;
            if(index1>length-1 || index2<0) return false;
            char c1 = s.charAt(index1);
            char c2 = s.charAt(index2);
            if(!checkEquals(c1,c2)) return false;
            index1++;
            index2--;
        }
        return true;
    }

    public boolean checkIsChar(char c){
        if(c>='0' && c<='9') return true;
        return checkIsLetter(c);
    }

    public boolean checkIsLetter(char c){
        if(c>='a' && c<='z') return true;
        if(c>='A' && c<='Z') return true;
        return false;
    }

    public boolean checkEquals(char a,char b){
        if(a==b) return true;
        if(checkIsLetter(a)&&checkIsLetter(b)){
            if(Math.abs(a-b)==('a'-'A')) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        leetcode_125_验证回文串 leetcode_125_验证回文串 = new leetcode_125_验证回文串();
        System.out.println(leetcode_125_验证回文串.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
