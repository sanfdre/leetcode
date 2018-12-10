package leetcode;

public class leetcode_28_实现strStr {
    //解法1 遍历 暴力
//    public int strStr(String haystack, String needle) {
//        if(needle==null || needle.equals("")) return 0;
//        for (int i = 0;i<haystack.length();i++){
//            boolean isSame = true;
//            for (int j = 0;j<needle.length();j++){
//                int outIndex = i+j;
//                if(outIndex>=haystack.length()) return -1;
//                if(haystack.charAt(i+j)!=needle.charAt(j)){
//                    isSame = false;
//                    break;
//                }
//            }
//            if(isSame) return i;
//        }
//        return -1;
//    }

    public static void main(String[] args) {
        String begin = "mississippi";
        String end = "issip";
        leetcode_28_实现strStr code = new leetcode_28_实现strStr();
        System.out.println(code.strStr(begin,end));
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) return 0;
        if (haystack == null || haystack.equals("")) return -1;

        int[] next = new int[needle.length()];
        getNext(needle,next);
        for (int i = 0;i<haystack.length();i++){
            boolean isSame = true;
            int notSameIndex = 0;
            for(int j = 0;j<needle.length();j++){
                int outIndex = i + j;
                if (outIndex >= haystack.length()) return -1;
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    isSame = false;
                    notSameIndex = j;
                    break;
                }
            }
            if(isSame){
                return i;
            }else {
                i +=notSameIndex-next[notSameIndex]-1;
            }
        }
        return -1;
    }

    private int getNext(String str,int[] next){
        int i = 0;
        int k = -1;
        int plen = str.length();
        int mlen = plen - 1;

        next[i] = k;
        while(i < mlen)
        {
            if((-1 == k) || (str.charAt(i) == str.charAt(k)))
            {
                next[++ i] = ++ k;
                if(str.charAt(i)==str.charAt(k)){
                    next[i] = next[k];
                }
            }
            else
            {
                k = next[k];
            }
        }
        return plen;
    }
}
