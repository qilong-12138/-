import java.util.Scanner;

public class fu {
    //计算分解的个数
    static int count=0;
    public static void factor(int n)
    {
        //每次n=1代表一次分解成功
        if(n==1)
        { //次数+1
            count++;
        }

        for (int i=2;i<=n;i++)
        {
            //如果取余为0说明可以整除
            if(n%i==0)
            {
                //n整除i，直到n变为1
                factor(n/i);
            }
        }

    }
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        //输入分解的整数
        int n=input.nextInt();
        //执行分解函数
        factor(n);
        //输出次数
        System.out.println(count);
    }
}
