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
public class CapCuaPhanTu_BangPhanTich extends General {

    int n;
    int Z_sao[] = new int[100];
    int ord_a[] = new int[100];
    int count;

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập n = ");
        n = sc.nextInt();
    }

    public int tinhOrd(int Z_s) {
        int i;
        for (i = 1;; i++) {
            if ((Math.pow(Z_s, i) % n) == 1) {
                break;
            }
        }
        return i;
    }
    public int tinhOrd(int Z_s,int Z_s_DK) {
        int i;
        for (i = 1;; i++) {
            if ((Math.pow(Z_s, i) % n) == 1) {
                break;
            }
        }
        return i;
    }

    public void tinhToan() {
        System.out.println("\n");
        for (int i = 1; i <= n; i++) {
            if (gcd(i, n) == 1) {
                count++;
                Z_sao[count] = i;
                System.out.print("\t" + Z_sao[count]);
            }
        }
        System.out.println("\n");
        for (int i = 1; i <= count; i++) {

            System.out.print("\t" + tinhOrd(Z_sao[i]));
        }
        System.out.println("\n");
    }
    public void tinhToan(int Z_s_dieukien) {
           
            System.out.println("Cấp của "+Z_s_dieukien+" trên "+n+" = " + tinhOrd(Z_s_dieukien));
    }

    public static void main(String[] args) {
        CapCuaPhanTu_BangPhanTich ccptbpt = new CapCuaPhanTu_BangPhanTich();
        ccptbpt.Nhap();
        ccptbpt.tinhToan();
    }
}
