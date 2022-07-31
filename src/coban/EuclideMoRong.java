/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coban;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class EuclideMoRong {

    public int gcd(int a, int b) {
        // Nếu a = 0 => ucln(a,b) = b
        // Nếu b = 0 => ucln(a,b) = a
        if (a == 0 || b == 0) {
            return a + b;
        }
        while (a != b) {
            if (a > b) {
                a -= b; // a = a - b
            } else {
                b -= a;
            }
        }
        return a; // return a or b, bởi vì lúc này a và b bằng nhau
    }
    /*
    Q,  A1, A2, A3, B1, B2, B3
    X1, X2, X3, X4, X5, X6, X7
     */
   public int b, m, count;
   public int X[][] = new int[100][100];

    public EuclideMoRong() {
    }

    public void buoc2() {
        while (true) {
            count++;
            X[count][1] = X[count - 1][4] / X[count - 1][7];
            X[count][7] = X[count - 1][4] % X[count - 1][7];
            X[count][5] = X[count - 1][2] - X[count][1] * X[count - 1][5];
            X[count][6] = X[count - 1][3] - X[count][1] * X[count - 1][6];
            X[count][2] = X[count - 1][5];
            X[count][3] = X[count - 1][6];
            X[count][4] = X[count - 1][7];
            if (X[count][7] == 1 || X[count][7] == 0) {
                break;
            }
        }
        Xuat();

    }

    public void Xuat() {
        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= 7; j++) {
               // System.out.print(X[i][j] + "\t");
            }
            //System.out.println("");
        }

    }

    public void KetLuan() {
        //System.out.println("Vậy (" + X[count][5] + "*" + b + ")+(" + X[count][6] + "*" + m + ")=1");
        //System.out.println("Hoặc " + b + "^(-1) mod " + m + " = " + X[count][5]);
        //System.out.println("Hoặc " + m + "^(-1) mod " + b + "= " + X[count][6]);
    }

    public void buoc1() {
        X[count][2] = 1;
        X[count][3] = 0;
        X[count][4] = b;
        X[count][5] = 0;
        X[count][6] = 1;
        X[count][7] = m;
        // Xuat();
        buoc2();
    }

    public void Run() {
        Scanner sc = new Scanner(System.in);
        //System.out.println("Nhập số b: ");
        b = sc.nextInt();
        //System.out.println("Nhập số m: ");
        m = sc.nextInt();
        if (gcd(b, m) == 1) {
            //System.out.println("UCLN(" + b + "," + m + ")=1" + " =>Có thể giải tiếp với Euclid Mở Rộng");
            count = 1;
            buoc1();
        } else {
            //System.out.println("UCLN(" + b + "," + m + ")!=1" + " =>Không thể giải tiếp với Euclid Mở Rộng ");
        }

    }

    public void Run(int x, int y) {
        Scanner sc = new Scanner(System.in);
        b = x;
        m = y;
        if (gcd(b, m) == 1) {
            //System.out.println("UCLN(" + b + "," + m + ")=1" + " =>Có thể giải tiếp với Euclid Mở Rộng");
            count = 1;
            buoc1();
        } else {
            //System.out.println("UCLN(" + b + "," + m + ")!=1" + " =>Không thể giải tiếp với Euclid Mở Rộng ");
        }

    }

    public static void main(String[] args) {
        EuclideMoRong e = new EuclideMoRong();
        //e.Run();
        //e.KetLuan();
        System.out.println(""+Math.pow(360000, 2)%97);
        ////System.out.println(""+Math.pow(40, 10)%97);

    }
}
