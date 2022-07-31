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
public class Cau31_GiaTriHamEuler extends General {

    int n, countSNT;
    int A[] = new int[100];
    int mu[] = new int[100];
    int Euler[] = new int[100];

    public void ketQuaPhanTichThuaSoNguyenTo() {
        System.out.print("Kết quả phân tích "+n+"= ");
        for (int i = 1; i <= countSNT; i++) {
            System.out.print(A[i]);
            if (mu[i] != 1) {
                System.out.print("^" + mu[i]);
            }
            if (i != countSNT) {
                System.out.print(" * ");
            }
        }
        System.out.println();
    }

    public int giaTriHamEuler() {
        int p = 1;
        for (int i = 1; i <= countSNT; i++) {
            if (mu[i] == 1) {
                p *= (A[i] - 1);
            } else {
                p *= Math.pow(A[i], mu[i]) - Math.pow(A[i], mu[i] - 1);
            }
        }
        
        return p;
    }

    public void timSoMuCuaThuaSoNguyenTo() {
        int temp;
        for (int i = 1; i <= countSNT; i++) {
            temp = n;
            while (true) {
                if (temp % A[i] == 0) {
                    mu[i]++;
                    temp /= A[i];
                } else {
                    break;
                }
            }
        }
    }

    public void TimCacThuaSoNguyenTo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số phy: ");
        n = sc.nextInt();
        countSNT = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 0 && laSoNguyenTo(i) == true) {
                countSNT++;
                A[countSNT] = i;
                //System.out.println(A[countSNT]);
            }
        }
    }

    public void timCacThuaSoNguyenTo(int x) {
        Scanner sc = new Scanner(System.in);
        n = x;
        countSNT = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 0 && laSoNguyenTo(i) == true) {
                countSNT++;
                A[countSNT] = i;
                System.out.println(A[countSNT]);
            }
        }
    }

    public static void main(String[] args) {
        Cau31_GiaTriHamEuler cgthe = new Cau31_GiaTriHamEuler();
        cgthe.TimCacThuaSoNguyenTo();
        cgthe.timSoMuCuaThuaSoNguyenTo();
        cgthe.ketQuaPhanTichThuaSoNguyenTo();
        System.out.println("Giá trị hàm euler: " + cgthe.giaTriHamEuler());
        
    }
}
