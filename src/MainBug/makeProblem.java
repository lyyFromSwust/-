package MainBug;

import java.util.Scanner;
public class makeProblem {
    public static void printText(int grade, int num) {
        int rightQue[]=new int [55],k=0;
        int wrongQue[]=new int [55],h=0;
        for (int i = 1; i <= num; i++) {
            String ansRight="";
            String ansWrong="";
            if (grade == 1)//一年级
            {
                produceNum pro = new produceNum();
                EvaluateExpression eval = new EvaluateExpression();
                String str = pro.one(0);
                double result2 = eval.evaluateExpressionDouble(str);
                //判断负号和小数，如果有负号，小数，重新生成
                while (result2 < 0 || (int) result2 != result2) {
                    pro = new produceNum();
                    eval = new EvaluateExpression();
                    str = pro.one(0);
                    result2 = eval.evaluateExpressionDouble(str); //计算表达式
                }
                System.out.println(i + "、 " + str + " = ");
                ansRight=String.valueOf((int)result2);
            }
            else if (grade == 2)//二年级
            {
                produceNum pro = new produceNum();
                EvaluateExpression eval = new EvaluateExpression();
                String str = pro.two(0);
                double result2 = eval.evaluateExpressionDouble(str);
                //判断负号和小数，如果有负号，小数，重新生成
                while (result2 < 0 || (int) result2 != result2) {
                    pro = new produceNum();
                    eval = new EvaluateExpression();
                    str = pro.two(0);
                    result2 = eval.evaluateExpressionDouble(str); //计算表达式
                }
                System.out.println(i + "、 " + str + " = ");
                ansRight=String.valueOf((int)result2);
            } else if (grade == 3)//三年级
            {
                produceNum pro = new produceNum();
                EvaluateExpression eval = new EvaluateExpression();
                String str = pro.three(0);
                double result2 = eval.evaluateExpressionDouble(str);
                //判断负号和小数，如果有负号，小数，重新生成
                while (result2 < 0 || (int) result2 != result2) {
                    pro = new produceNum();
                    eval = new EvaluateExpression();
                    str = pro.three(0);
                    result2 = eval.evaluateExpressionDouble(str); //计算表达式
                }
                System.out.println(i + "、 " + str + " = ");
                ansRight=String.valueOf((int)result2);
            } else if (grade == 4)//四年级
            {
                produceNum pro = new produceNum();
                EvaluateExpression eval = new EvaluateExpression();
                String str = pro.four(0);
                double result2 = eval.evaluateExpressionDouble(str);
                //判断负号和小数，如果有负号，小数，重新生成
                while (result2 < 0 || (int) result2 != result2) {
                    pro = new produceNum();
                    eval = new EvaluateExpression();
                    str = pro.four(0);
                    result2 = eval.evaluateExpressionDouble(str); //计算表达式
                }
                System.out.println(i + "、 " + str + " = " );
                ansRight=String.valueOf((int)result2);
            }
            else if (grade == 5)//五年级
            {
                produceNum pro = new produceNum();
                f ansf = pro.five();
                while (ansf.x / ansf.y < 0) {
                    pro = new produceNum();
                    ansf = pro.five();
                }

                if (ansf.x == 0) {
                    ansRight = String.valueOf(0);
                } else if (ansf.y == 1) {
                    ansRight = String.valueOf(ansf.x);
                } else if (ansf.x < ansf.y) {
                    ansRight = String.valueOf(ansf.x) + "/" + String.valueOf(ansf.y);
                } else {
                    int dai = ansf.x / ansf.y;
                    int fen = ansf.x % ansf.y;
                    ansRight = String.valueOf(dai) + "`" + String.valueOf(fen) + "/" + String.valueOf(ansf.y);
                }
            } else {
                produceNum pro = new produceNum();
                f ansf = pro.six();
                while (ansf.x / ansf.y < 0) {
                    pro = new produceNum();
                    ansf = pro.six();
                }

                if (ansf.x == 0) {
                    ansRight = String.valueOf(0);
                } else if (ansf.y == 1) {
                    ansRight = String.valueOf(ansf.x);
                } else if (ansf.x < ansf.y) {
                    ansRight = String.valueOf(ansf.x) + "/" + String.valueOf(ansf.y);
                } else {
                    int dai = ansf.x / ansf.y;
                    int fen = ansf.x % ansf.y;
                    ansRight = String.valueOf(dai) + "`" + String.valueOf(fen) + "/" + String.valueOf(ansf.y);
                }

            }
            System.out.println("请输出第"+i+"题的答案：");
            Scanner scanner=new Scanner(System.in);
            ansWrong=scanner.nextLine();
            if(ansWrong.equals(ansRight))
            {
               rightQue[k++]=i;
            }
            else
            {
                wrongQue[h++]=i;
            }
        }
        if(k<=0)
        {
            System.out.println("你没有答对题目，真是笨蛋！");
        }
        else
        {
            System.out.println("你共答对"+k+"道题，你的正确答题题目是：");
            String ansRightNum="";
            for(int i=0;i<k;i++)
            {
                System.out.print(rightQue[i]+" ");
            }
        }
        System.out.println();
        if(h<=0)
        {
            System.out.println("你全对啦，真是天才！");
        }
        else
        {
            System.out.println("你共答错"+h+"道题，你的回答错误题目是：");
            for(int i=0;i<h;i++)
            {
                System.out.print(wrongQue[i]+" ");
            }
            System.out.println();
        }

    }

}
