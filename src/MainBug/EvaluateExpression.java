package MainBug;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Stack;
import java.util.regex.Pattern;


public class EvaluateExpression {

    public  double evaluateExpressionDouble(String exp) {
        String result="";
        double value = 0;
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        try {
            result=  engine.eval(exp).toString();
            value= Double.parseDouble(result);
            //System.out.println("value:"+value);
        } catch (ScriptException e) {


            e.printStackTrace();
        }
        return  value;
    }

    // 将中缀表达式转换为后缀表达式
    public  String infixToSuffix(String exp) {
        // 创建操作符堆栈
        Stack<Character> s = new Stack<Character>();
        // 要输出的后缀表达式字符串
        String suffix = "";
        int length = exp.length(); // 输入的中缀表达式的长度
        for (int i = 0; i < length; i++) {
            char temp;// 临时字符变量
            // 获取该中缀表达式的每一个字符并进行判断
            char ch = exp.charAt(i);
            switch (ch) {
                // 忽略空格
                case ' ':
                    break;
                // 如果是左括号直接压入堆栈
                case '(':
                    s.push(ch);
                    break;

                // 碰到'+' '-'，将栈中的所有运算符全部弹出去，直至碰到左括号为止，输出到队列中去
                case '+':
                case '-':
                    while (s.size() != 0) {
                        temp = s.pop();
                        if (temp == '(') {
                            // 重新将左括号放回堆栈，终止循环
                            s.push('(');
                            break;
                        }
                        suffix += temp;
                    }
                    // 没有进入循环说明是当前为第一次进入或者其他前面运算都有括号等情况导致栈已经为空,此时需要将符号进栈
                    s.push(ch);
                    break;

                // 如果是乘号或者除号，则弹出所有序列，直到碰到加好、减号、左括号为止，最后将该操作符压入堆栈
                case '*':
                case '/':
                    while (s.size() != 0) {
                        temp = s.pop();
                        // 只有比当前优先级高的或者相等的才会弹出到输出队列，遇到加减左括号，直接停止当前循环
                        if (temp == '+' || temp == '-' || temp == '(') {
                            s.push(temp);
                            break;
                        } else {
                            suffix += temp;
                        }
                    }
                    // 没有进入循环说明是当前为第一次进入或者其他前面运算都有括号等情况导致栈已经为空,此时需要将符号进栈
                    s.push(ch);
                    break;

                // 如果碰到的是右括号，则距离栈顶的第一个左括号上面的所有运算符弹出栈并抛弃左括号
                case ')':
                    // 这里假设一定会遇到左括号了，此为自己改进版，已经验证可以过
                    // while ((temp = s.pop()) != '(') {
                    // suffix += temp;
                    // }
                    while (!s.isEmpty()) {
                        temp = s.pop();
                        if (temp == '(') {
                            break;
                        } else {
                            suffix += temp;
                        }
                    }
                    break;
                // 默认情况，如果读取到的是数字，则直接送至输出序列
                default:
                    suffix += ch;
                    break;
            }

        }
        // 如果堆栈不为空，则把剩余运算符一次弹出，送至输出序列
        while (s.size() != 0) {
            suffix += s.pop();
        }
        //
        return suffix;
    }

    // 将后缀表达式的进行计算得到运算结果 eg:325-6*3/+
    public  double suffixToArithmetic(String exp) {
        // 使用正则表达式匹配数字
        Pattern pattern = Pattern.compile("\\d+||(\\d+\\.\\d+)");
        // 将后缀表达式分割成字符串数组,此处直接使用空白也可以对字符串进行分割！！
        String[] strings = exp.split("");
        Stack<Double> stack = new Stack<Double>();
        for (int i = 0; i < strings.length; i++) {
            // 这里最好是进行判断彻底消除空格，在该数组的第一位为一个隐形的空格，这里一定要注意在使用exp.split("")剔除空白""
            // 由于使用的是""截取导致在数组第一位上面的值为空白
            if (strings[i].equals("")) {
                continue;
            }
            int tx=0,ty=0;
            // 如果遇到了数字则直接进栈
            if (pattern.matcher(strings[i]).matches()) {
                stack.push(Double.parseDouble(strings[i]));
            }
            // 如果是运算符，则弹出栈顶的两个数进行计算
            else {
                // ！！！这里需要注意，先弹出的那个数其实是第二个计算数值，这里记作y！
                // 自己书写的时候出错
                double y = stack.pop();
                double x = stack.pop();
                // 将运算结果重新压栈
                stack.push(calculate(tx,ty,x, y, strings[i]));
            }
        }
        // 弹出栈顶元素就是最终结果
        return stack.pop();
    }

    private  Double calculate(int tx,int ty,double x, double y, String string) {
        // TODO Auto-generated method stub
        // 其实使用case逻辑也可以
        if (string.trim().equals("+")) {
            System.out.println("x:"+x+" +   y:"+y);
            return x + y;
        }
        if (string.trim().equals("-")) {
            System.out.println("x:"+x+" -   y:"+y);
            return x - y;
        }
        if (string.trim().equals("*")) {
            System.out.println("x:"+x+"  *  y:"+y);
            return x * y;
        }
        if (string.trim().equals("/")) {
            System.out.println("x:"+x+"   / y:"+y);
            return x / y;
        }
        return (double) 0;
    }
}


