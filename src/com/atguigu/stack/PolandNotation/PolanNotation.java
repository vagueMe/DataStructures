package com.atguigu.stack.PolandNotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author hudi 逆波兰表达式的转换和计算
 * @date 2022/10/17 15:24
 */
public class PolanNotation {
    // 逆波兰表达式的转换
/*    转换规则
    1,初始化两个栈，运算符栈s1和存储中间结构的栈s2
    2,从左到右扫描
    3,遇到操作数时，将其压入s2
    4,遇到运算符时，比较其与s1栈顶运算符的优先级:
        4.1 如果s1为空，或栈顶运算符为左括号"(" 则直接将此运算符入栈。
        4.2 否则，若优先级比栈顶运算符高也将运算符压入s1
        4.3 否则，将s1栈顶的运算符弹出并压入到s2中，再次转到4.1与s1中的栈顶元素进行比较
    5, 遇到括号时:
        5.1 如果是左括号"(" 则直接压入s1.
        5.2 如果是右括号")" 则依次弹出s1栈顶的运算符，并压入s2，知道遇到左括号为止，此时将这一对括号丢弃。
    6, 重复步骤2至5，知道表达式的最右边。
    7, 将s1中剩余的运算符依次弹出并压入s2
    8， 依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式。
    */


    // 中缀表达式字符串转换成数组
    public static List<String> toInfixExpressionList(String s){
        List<String> ls = new ArrayList<>();
        char[] chars = s.toCharArray();
        String temp = "";
        for (int i = 0; i < chars.length; i++) {
            if(i != chars.length -1){ //
                if( chars[i] <= 48 || chars[i] >= 57){ // 非数字
                    ls.add(chars[i] + "");
                } else {
                    if( chars[i+1] >= 48 && chars[i+1] <= 57){ // 为数字
                        temp = temp + chars[i] + "";
                    } else {
                        ls.add(temp+chars[i]);
                        temp = "";
                    }
                }
            } else {
                ls.add(temp+chars[i]);
            }
        }

        return ls;
    }

    public static List<String> toResultString(List<String> old){
        Stack<String> oper = new Stack<>();
        List<String> all = new ArrayList<>();
        for (String s : old) {
            if(notNumber(s)){
                if(oper.isEmpty() || "(".equals(s) || isAdd(s , oper.peek())){
                    oper.push(s);
                }else{
                    setRight(oper, all, s);
                }
            } else {
                all.add(s);
            }
        }
        while (!oper.empty()){
            all.add(oper.pop());
        }
        return all;
    }

    public static void setRight(Stack<String> s1, List<String> s2, String temp){

        String pop = s1.pop();
        if(")".equals(temp)){

            if("(".equals(pop)){
                return;
            } else {
                s2.add(pop);
                setRight(s1,  s2, temp);
            }
        } else {
            s2.add(pop);
            if(s1.isEmpty() || isAdd(temp , s1.peek())){
                s1.push(temp);
                return;
            } else {
                setRight( s1,  s2, temp);
            }
        }

    }

    public static boolean notNumber(String s){

        return "+".equals(s) || "-".equals(s) || "*".equals(s) || "%".equals(s) || "(".equals(s) || ")".equals(s);
    }

    public static boolean isAdd(String a , String b){

        if("(".equals(b)){
            return true;
        }
        if( ("*".equals(a) || "%".equals(a)) && ("+".equals(b) || "-".equals(b)) ){
            return true;
        }
        return false;
    }

    public static Integer getResult(List<String> list){
        Stack<Integer> result = new Stack<>();
        for (String s : list) {
            if(notNumber(s)){
                Integer pop2 = result.pop();
                Integer pop1 = result.pop();
                switch (s){
                    case "+":
                        result.push(pop1 + pop2);
                        break;
                    case "-":
                        result.push(pop1 - pop2);
                        break;
                    case "*":
                        result.push(pop1 * pop2);
                        break;
                    case "%":
                        result.push(pop1 / pop2);
                        break;
                    default:
                        throw new RuntimeException("运算符有误");
                }
            } else {
                result.push(Integer.parseInt(s));
            }
        }
        return result.pop();

    }


    public static void main(String[] args) {
        List<String> strings = toInfixExpressionList("1+((2+3)*4)-5");
        List<String> strings1 = toResultString(strings);
        System.out.println(strings1);
        Integer result = getResult(strings1);
        System.out.println("result = " + result);
    }
}
