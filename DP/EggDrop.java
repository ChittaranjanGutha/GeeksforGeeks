/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class EggDrop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        while (input > 0) {
            input--;
            int eggs = sc.nextInt();//
            int floors = sc.nextInt();
            System.out.println(new EggDrop().compute(eggs, floors));
        }
    }

    public int compute(int n, int k) {
        int[][] values = new int[n + 1][k + 1];
        for (int i = 0; i < n + 1; i++) {

            //IF the number of floors is 0 Then we only need 0 eggs
            values[i][0] = 0;
            //If the number of floors is 1 then we only need one egg
            values[i][1] = 1;
        }
        for (int i = 0; i < k + 1; i++) {
            values[0][i] = 0;
        }

        //If there is only one egg then we need to traverse in the worst case all the floors
        for (int i = 0; i < k + 1; i++) {
            values[1][i] = i;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                values[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= j; x++) {
                    int eggbreak = values[i - 1][x - 1];
                    int eggnotbreak = values[i][j - x];
                    int res = Math.max(eggbreak, eggnotbreak) + 1;
                    if (res < values[i][j]) {
                        values[i][j] = res;
                    }
                }
            }
        }
        return values[n][k];
    }
}