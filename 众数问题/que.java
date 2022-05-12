import java.io.*;
public class que {

    public static int chong = 0, zhong = 0;

    public static void main(String[] args) {

        FileReader fr = null;
        BufferedReader br = null;
        FileReader fr2 = null;
        BufferedReader br2 = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {

            fr = new FileReader("src//1.txt");
            br = new BufferedReader(fr);
            fw = new FileWriter("src//2.txt");
            bw = new BufferedWriter(fw);
        } catch (IOException e) {

            System.out.println("error1");
        }
        int i = 0, count = 0;
        String s;
        try {
            // 计算有多少个数
            while ((s = br.readLine()) != null) {

                count++;
            }
            br.close();
        } catch (Exception e) {

            System.out.println("error2");
        }
        int[] arr = new int[count];
        try//读取n个数
        {

            fr2 = new FileReader("src//1.txt");
            br2 = new BufferedReader(fr2);
            while ((s = br2.readLine()) != null) {

                arr[i] = Integer.parseInt(s);
                i++;
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        sort(arr);

        zhongshu(arr, 0, arr.length - 1);
        try {

            bw.write(zhong + "");
            bw.newLine();
            bw.write(chong + "");
            bw.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public static void zhongshu(int arr[], int l, int r) {

        int m, c1 = 0, c2 = 0, i, j, val;
        m = (r + l) / 2;
        i = m;
        j = m;
        val = arr[m];
        while (i >= l && arr[i] == val) {

            i--;
            c1++;
        }

        while (j <= r && arr[j] == val) {

            j++;
            c2++;
        }
        if (chong < j - i - 1) {

            chong = j - i - 1;
            zhong = val;
        }
        if (i - l + 1 > chong)
            zhongshu(arr, l, i);
        if (r - j + 1 > chong)
            zhongshu(arr, j, r);
    }


    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            int min = i; // 遍历的区间最小的值
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[min]) {

                    // 找到当前遍历区间最小的值的索引
                    min = j;
                }
            }
            if (min != i) {

                // 发生了调换
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }


}