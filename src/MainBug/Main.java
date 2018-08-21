package MainBug;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        System.out.println("选择年级：一年级——1     二年级——2    三年级——3    四年级——4    五年级——5    六年级——6");

        Scanner scanner=new Scanner(System.in);
        int nianji = scanner.nextInt();
        System.out.println("输入选择做题数目：");
        int num=scanner.nextInt();
        makeProblem.printText(nianji,num);
    }
}

