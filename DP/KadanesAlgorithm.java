import org.omg.PortableInterceptor.INACTIVE;

import java.util.Scanner;

public class KadanesAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        KadanesAlgorithm obj = new KadanesAlgorithm();
        while (input > 0) {
            input--;
            int length = sc.nextInt();
            int[] arr = new int[length];
            for (int i = 0; i < length; i++)
                arr[i] = sc.nextInt();
            System.out.println(obj.max_Sum(arr, length));
        }
    }

    public int max_Sum(int[] arr, int length) {
     int[] dp=new int[length];
     dp[0]=arr[0];
     int max=arr[0];
     for(int i=1;i<arr.length;i++) {
         dp[i] = arr[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
         max = Math.max(dp[i], max);
     }
     return max;
    }
}
