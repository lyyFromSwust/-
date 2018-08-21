package MainBug;

import java.util.Random;
import java.util.Scanner;

class f{
    int x;//分子
    int y;//分母
}

public class produceNum {

    public static int gcd(int x,int y)
    {
        if(y==0)return x;
        else return gcd(y,x%y);
    }
    public static f setf(f s)
    {
        Random random=new Random();
        s.x=random.nextInt(10)+1;
        s.y=random.nextInt(10)+1;
        int yue=gcd(s.x,s.y);
        s.x=s.x/yue;
        s.y=s.y/yue;
        return s;
    }

    public static f addf(f a,f b)
    {
        f ansf=new f();
        ansf.y=a.y*b.y;
        ansf.x=a.x*b.y+a.y*b.x;
        int yue=gcd(ansf.x,ansf.y);
        ansf.x=ansf.x/yue;
        ansf.y=ansf.y/yue;
        return ansf;
    }

    public static f reducef(f a,f b)
    {
        f ansf=new f();
        ansf.y=a.y*b.y;
        ansf.x=a.x*b.y-a.y*b.x;
        int yue=gcd(ansf.x,ansf.y);
        ansf.x=ansf.x/yue;
        ansf.y=ansf.y/yue;
        return ansf;
    }

    public static f chengf(f a,f b)
    {
        f ansf=new f();
        ansf.y=a.y*b.y;
        ansf.x=a.x*b.x;
        int yue=gcd(ansf.x,ansf.y);
        ansf.x=ansf.x/yue;
        ansf.y=ansf.y/yue;
        return ansf;
    }

    public static f chuf(f a,f b)
    {
        f ansf=new f();
        ansf.y=a.y*b.x;
        ansf.x=a.x*b.y;
        int yue=gcd(ansf.x,ansf.y);
        ansf.x=ansf.x/yue;
        ansf.y=ansf.y/yue;
        return ansf;
    }

    //单个加减
    public String one(int dep)
    {
        Random random=new Random();
        int num= random.nextInt(3);
        //System.out.println(num);
        if((num==0&&dep>0)||dep>=1) {
            return String.valueOf(random.nextInt(9)+1);
        }
        else if(num==1) {
            return one(dep+1)+" + "+one(dep+1);
        }
        else{
            return one(dep+1)+" - "+one(dep+1);
        }
    }

    //加减混合
    public String two(int dep)
    {
        Random random=new Random();
        int num= random.nextInt(3);
        //System.out.println(num);
        if((num==0&&dep>0)||dep>=2) {
            return String.valueOf(random.nextInt(9)+1);
        }
        else if(num==1) {
            return two(dep+1)+" + "+two(dep+1);
        }
        else{
            return two(dep+1)+" - "+two(dep+1);
        }
    }

    //单个乘除
    public String three(int dep)
    {
        Random random=new Random();
        int num= random.nextInt(3);
        //System.out.println(num);
        if((num==0&&dep>0)||dep>=1) {
            return String.valueOf(random.nextInt(9)+1);
        }
        else if(num==1) {
            return three(dep+1)+" * "+three(dep+1);
        }
        else{
            return three(dep+1)+" / "+three(dep+1);
        }
    }

    public String four(int dep)
    {
        Random random=new Random();
        int num= random.nextInt(3);
        //System.out.println(num);
        if((num==0&&dep>0)||dep>=2) {
            return String.valueOf(random.nextInt(9)+1);
        }
        else if(num==1) {
            return four(dep+1)+" * "+four(dep+1);
        }
        else{
            return four(dep+1)+" / "+four(dep+1);
        }
    }

    public f five()
    {
        Random rand=new Random();
        int num=rand.nextInt(17)+1;

        f anst=new f();f s1=new f();f s2=new f();f s3=new f();f s4=new f();
        s1=setf(s1);s2=setf(s2);s3=setf(s3);s4=setf(s4);
        String ss="";
        switch (num)
        {
            case 1:
                anst=reducef(addf(s1,s2),addf(s3,s4));
                ss="("+s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y+") - ("+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+")";
                //System.out.println("("+s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y+") - ("+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+") = "+anst.x+"/"+anst.y);
                break;
            case 2:
                anst=reducef(reducef(s1,s2),addf(s3,s4));
                ss="("+s1.x+"/"+s1.y+" - "+s2.x+"/"+s2.y+") - ("+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+")";
                //System.out.println("("+s1.x+"/"+s1.y+" - "+s2.x+"/"+s2.y+") - ("+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+") = "+anst.x+"/"+anst.y);
                break;
            case 3:
                anst=reducef(reducef(s1,s2),reducef(s3,s4));
                ss="("+s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y+") - ("+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y+")";
                //System.out.println("("+s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y+") - ("+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y+") = "+anst.x+"/"+anst.y);
                 break;
            case 4:
                anst=chengf(addf(s1,s2),addf(s3,s4));
                ss="("+s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+")";
                //System.out.println("("+s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+") = "+anst.x+"/"+anst.y);
                 break;
            case 5:
                anst=chengf(addf(s1,s2),reducef(s3,s4));
                ss="("+s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y+")";
                //System.out.println("("+s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y+") = "+anst.x+"/"+anst.y);
                 break;
            case 6:
                anst=chengf(reducef(s1,s2),addf(s3,s4));
                ss="("+s1.x+"/"+s1.y+" - "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+")";
                //System.out.println("("+s1.x+"/"+s1.y+" - "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+") = "+anst.x+"/"+anst.y);
                break;
            case 7:
                anst=chengf(reducef(s1,s2),reducef(s3,s4));
                ss="("+s1.x+"/"+s1.y+" - "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y+")";
                //System.out.println("("+s1.x+"/"+s1.y+" - "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y+") = "+anst.x+"/"+anst.y);
                break;
            case 8:
                anst=chengf(chengf(s1,s2),addf(s3,s4));
                ss="("+s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+")";
                //System.out.println("("+s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+") = "+anst.x+"/"+anst.y);
                break;
            case 9:
                anst=chengf(chengf(s1,s2),reducef(s3,s4));
                ss="("+s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y+")";
               // System.out.println("("+s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y+") = "+anst.x+"/"+anst.y);
                break;
            case 10:
                anst=addf(addf(s1,s2),addf(s3,s4));
                ss=s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y+" + "+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y;
                //System.out.println(s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y+" + "+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+" = "+anst.x+"/"+anst.y);
                break;
            case 11:
                anst=reducef(s1,reducef(reducef(s2,s3),s4));
                ss=s1.x+"/"+s1.y+" - "+s2.x+"/"+s2.y+" - "+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y;
                //System.out.println(s1.x+"/"+s1.y+" - "+s2.x+"/"+s2.y+" - "+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y+" = "+anst.x+"/"+anst.y);
                break;
            case 12:
                anst=chengf(s1,chengf(s2,s3));
                ss=s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+" * "+s3.x+"/"+s3.y;
               // System.out.println(s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+" * "+s3.x+"/"+s3.y+" = "+anst.x+"/"+anst.y);
                break;
            case 13:
                anst=addf(chengf(s1,chengf(s2,s3)),s4);
                ss=s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+" * "+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y;
               // System.out.println(s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+" * "+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+" = "+anst.x+"/"+anst.y);
                break;
            case 14:
                anst=reducef(chengf(s1,chengf(s2,s3)),s4);
                ss=s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+" * "+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y;
                //System.out.println(s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+" * "+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y+" = "+anst.x+"/"+anst.y);
                break;
            case 15:
                anst=addf(s1,s2);
                ss=s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y;
                //System.out.println(s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y+" = "+anst.x+"/"+anst.y);
                break;
            case 16:
                anst=reducef(s1,s2);
                ss=s1.x+"/"+s1.y+" - "+s2.x+"/"+s2.y;
                //System.out.println(s1.x+"/"+s1.y+" - "+s2.x+"/"+s2.y+" = "+anst.x+"/"+anst.y);
                break;
            case 17:
                anst=chengf(s1,s2);
                ss=s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y;
                //System.out.println(s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+" = "+anst.x+"/"+anst.y);
                break;
        }
        if(anst.x/anst.y>=0)
        { System.out.println(ss+" = ");
        }
    return anst;
    }

    public f six()
    {
        Random rand=new Random();
        int num=rand.nextInt(23)+1;

        f anst=new f();f s1=new f();f s2=new f();f s3=new f();f s4=new f();
        s1=setf(s1);s2=setf(s2);s3=setf(s3);s4=setf(s4);
        String ss="";
        switch (num)
        {
            case 1:
                anst=reducef(addf(s1,s2),addf(s3,s4));
                ss="("+s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y+") - ("+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+")";
                //System.out.println("("+s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y+") - ("+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+") = "+anst.x+"/"+anst.y);
                break;
            case 2:
                anst=reducef(reducef(s1,s2),addf(s3,s4));
                ss="("+s1.x+"/"+s1.y+" - "+s2.x+"/"+s2.y+") - ("+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+")";
                //System.out.println("("+s1.x+"/"+s1.y+" - "+s2.x+"/"+s2.y+") - ("+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+") = "+anst.x+"/"+anst.y);
                break;
            case 3:
                anst=reducef(reducef(s1,s2),reducef(s3,s4));
                ss="("+s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y+") - ("+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y+")";
                //System.out.println("("+s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y+") - ("+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y+") = "+anst.x+"/"+anst.y);
                break;
            case 4:
                anst=chengf(addf(s1,s2),addf(s3,s4));
                ss="("+s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+")";
                //System.out.println("("+s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+") = "+anst.x+"/"+anst.y);
                break;
            case 5:
                anst=chengf(addf(s1,s2),reducef(s3,s4));
                ss="("+s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y+")";
                //System.out.println("("+s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y+") = "+anst.x+"/"+anst.y);
                break;
            case 6:
                anst=chengf(reducef(s1,s2),addf(s3,s4));
                ss="("+s1.x+"/"+s1.y+" - "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+")";
                //System.out.println("("+s1.x+"/"+s1.y+" - "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+") = "+anst.x+"/"+anst.y);
                break;
            case 7:
                anst=chengf(reducef(s1,s2),reducef(s3,s4));
                ss="("+s1.x+"/"+s1.y+" - "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y+")";
                break;
            case 8:
                anst=chengf(chengf(s1,s2),addf(s3,s4));
                ss="("+s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+")";
                //System.out.println("("+s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+") = "+anst.x+"/"+anst.y);
                break;
            case 9:
                anst=chengf(chengf(s1,s2),reducef(s3,s4));
                ss="("+s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y+")";
                // System.out.println("("+s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y+") = "+anst.x+"/"+anst.y);
                break;
            case 10:
                anst=chuf(addf(s1,s2),addf(s3,s4));
                ss="("+s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y+") / ("+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+")";
                //System.out.println("("+s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+") = "+anst.x+"/"+anst.y);
                break;
            case 11:
                anst=chuf(addf(s1,s2),reducef(s3,s4));
                ss="("+s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y+") / ("+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y+")";
                //System.out.println("("+s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y+") = "+anst.x+"/"+anst.y);
                break;
            case 12:
                anst=chuf(reducef(s1,s2),addf(s3,s4));
                ss="("+s1.x+"/"+s1.y+" - "+s2.x+"/"+s2.y+") / ("+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+")";
                //System.out.println("("+s1.x+"/"+s1.y+" - "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+") = "+anst.x+"/"+anst.y);
                break;
            case 13:
                anst=chuf(reducef(s1,s2),reducef(s3,s4));
                ss="("+s1.x+"/"+s1.y+" - "+s2.x+"/"+s2.y+") / ("+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y+")";
                //System.out.println("("+s1.x+"/"+s1.y+" - "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y+") = "+anst.x+"/"+anst.y);
                break;
            case 14:
                anst=chuf(chengf(s1,s2),addf(s3,s4));
                ss="("+s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+") / ("+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+")";
                //System.out.println("("+s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+") = "+anst.x+"/"+anst.y);
                break;
            case 15:
                anst=chuf(chengf(s1,s2),reducef(s3,s4));
                ss="("+s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y+")";
                // System.out.println("("+s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+") * ("+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y+") = "+anst.x+"/"+anst.y);
                break;
            case 16:
                anst=addf(addf(s1,s2),addf(s3,s4));
                ss=s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y+" + "+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y;
                //System.out.println(s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y+" + "+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+" = "+anst.x+"/"+anst.y);
                break;
            case 17:
                anst=reducef(s1,reducef(reducef(s2,s3),s4));
                ss=s1.x+"/"+s1.y+" - "+s2.x+"/"+s2.y+" - "+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y;
                //System.out.println(s1.x+"/"+s1.y+" - "+s2.x+"/"+s2.y+" - "+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y+" = "+anst.x+"/"+anst.y);
                break;
            case 18:
                anst=chengf(s1,chengf(s2,s3));
                ss=s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+" * "+s3.x+"/"+s3.y;
                // System.out.println(s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+" * "+s3.x+"/"+s3.y+" = "+anst.x+"/"+anst.y);
                break;
            case 19:
                anst=addf(chengf(s1,chengf(s2,s3)),s4);
                ss=s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+" * "+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y;
                // System.out.println(s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+" * "+s3.x+"/"+s3.y+" + "+s4.x+"/"+s4.y+" = "+anst.x+"/"+anst.y);
                break;
            case 20:
                anst=reducef(chengf(s1,chengf(s2,s3)),s4);
                ss=s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+" * "+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y;
                //System.out.println(s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+" * "+s3.x+"/"+s3.y+" - "+s4.x+"/"+s4.y+" = "+anst.x+"/"+anst.y);
                break;
            case 21:
                anst=addf(s1,chuf(s2,s3));
                ss=s1.x+"/"+s1.y+" + ("+s2.x+"/"+s2.y+s3.x+"/"+s3.y+")";
                //System.out.println(s1.x+"/"+s1.y+" + "+s2.x+"/"+s2.y+" = "+anst.x+"/"+anst.y);
                break;
            case 22:
                anst=chuf(reducef(s1,s2),s3);
                ss="("+s1.x+"/"+s1.y+" - "+s2.x+"/"+s2.y+") / "+s3.x+"/"+s3.y;
                //System.out.println(s1.x+"/"+s1.y+" - "+s2.x+"/"+s2.y+" = "+anst.x+"/"+anst.y);
                break;
            case 23:
                anst=chuf(chengf(s1,s2),s3);
                ss=s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+" / "+s3.x+"/"+s3.y;
                //System.out.println(s1.x+"/"+s1.y+" * "+s2.x+"/"+s2.y+" = "+anst.x+"/"+anst.y);
                break;
        }
        if(anst.x/anst.y>=0)
        {
            System.out.println(ss+" = ");
        }
        return anst;
    }
}
