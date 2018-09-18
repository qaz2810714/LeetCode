package Easy;

import java.util.Stack;

/**
 * 有效的括号
 *
 * @author yang.shang
 * @create 2018-09-17 14:28
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串
 **/
public class ValidParentheses {

    //很容易联想到 栈 数据结构 然后做对应存储就行
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack=new Stack<>();
        char cur;
        for (char aChar : chars) {
            cur = aChar;
            switch (cur) {
                case '(':
                    stack.push(1);
                    break;
                case '{':
                    stack.push(2);
                    break;
                case '[':
                    stack.push(3);
                    break;
                case ')':
                    if (stack.size()==0 || stack.peek() != 1)
                        return false;
                    stack.pop();
                    break;
                case '}':
                    if (stack.size()==0 || stack.peek() != 2)
                        return false;
                    stack.pop();
                    break;
                case ']':
                    if (stack.size()==0 || stack.peek() != 3)
                        return false;
                    stack.pop();
                    break;
            }
        }
        return  (stack.size() == 0);
    }

    //LeetCode上找到一种更加简洁的写法，不过时间复杂度和空间复杂度和上面差不多
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
