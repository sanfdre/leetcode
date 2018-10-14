package leetcode;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class leetcode_20_有效的括号 {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }
    public static boolean isValid(String s) {
        char ls = '(';
        char rs = ')';
        char lm = '[';
        char rm = ']';
        char ll = '{';
        char rl = '}';
        Stack<Character> stack1 = new Stack<>();
        for (int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c==ll || c==ls || c==lm){
                stack1.push(c);
            }else {
                if(stack1.isEmpty()) return false;
                Character c1 = stack1.pop();
                if(c1==ls && c!=rs) return false;
                if(c1==lm && c!=rm) return false;
                if(c1==ll && c!=rl) return false;
            }
        }
        return stack1.isEmpty();
    }
}
