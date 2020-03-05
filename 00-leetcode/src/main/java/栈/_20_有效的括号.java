package 栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _20_有效的括号 {

    static Map<Character, Character> map = new HashMap<Character, Character>();

    static{
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }

    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<Character>();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                //如果是左括号则入栈
                stack.push(c);
            }else{
                if(stack.isEmpty()) return false;
                char left = stack.pop();
                if(c != map.get(left)) return false;
            }
        }

        return stack.isEmpty();
    }

    /**
     * 有效括号
     * 1.如果字符是左括号就入栈，如果字符是右括号就出栈并进行比较，如果可以匹配上，则返回true，否则false
     * 2.如果刚开始就是右括号，直接返回false
     * 3.如果最后栈中不是空的，返回false
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        int len = s.length();
        for (int i = 0; i < len; i++) {
           char c = s.charAt(i);
           if(c == '(' || c == '{' || c == '['){
               //如果是左括号则入栈
               stack.push(c);
           }else{
               if(stack.isEmpty()) return false;
               char left = stack.pop();
               if(left == '(' && c != ')') return false;
               if(left == '{' && c != '}') return false;
               if(left == '[' && c != ']') return false;
           }
        }

        return stack.isEmpty();
    }

}
