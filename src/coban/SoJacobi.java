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
public class SoJacobi {

    int a, p, k, t, ketQuaJacobi;
    String dau;

    public boolean coDang2Mu_k_Nhan_t(int m) {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                if ((Math.pow(2, j) * i == m) && (i % 2 == 1)) {
                    k = j;
                    t = i;
                    return true;
                }
            }
        }
        return false;
    }
    public void xuLy_a_Bang2() {
        if (p % 8 == 1 || (p + 1) % 8 == 0) {
            //System.out.println(dau + "= 1");
            p = 1;
            a = 1;
        } else if (p % 8 == 3 || (p + 3) % 8 == 0) {
            if (dau == "") {
                ketQuaJacobi=-1;
                //System.out.println(ketQuaJacobi);
            } else {
                ketQuaJacobi=1;
                //System.out.println(ketQuaJacobi);
            }
            p = 1;
            a = -1;
        }
    }
    public void quyVeDau() {
        if (p % 8 == 1 || (p + 1) % 8 == 0) {
            dau = "";
        } else if (p % 8 == 3 || (p + 3) % 8 == 0) {
            dau = "-";
        }
        //System.out.println(dau + t + "/" + p);
    }
    public void TinhToan() {
        dau = "";
        //System.out.println("Đa thức vừa nhập" + "(" + a + "/" + p + ")");
        while (true) {

            if ((a % p == (a % p) % p) && a > p) {
                //System.out.println(dau + "(" + (a % p) + "/" + p + ")");
                a = a % p;
            } else if (a == 2) {
                xuLy_a_Bang2();
            } else if (coDang2Mu_k_Nhan_t(a) == true) {
                //System.out.println(dau + "(2/" + p + ")^" + k + "*(" + t + "/" + p + ")");
                quyVeDau();
                a = t;
            } else if ((a % 4 == 3) && (p % 4 == 3)) {
                if (dau.equals("-")) {
                    dau = "";
                } else {
                    dau = "-";
                }
                //System.out.println(dau + "(" + p + "/" + a + ")");
                int temp = p;
                p = a;
                a = temp;
            } else {
                //System.out.println("(" + p + "/" + a + ")");
                int temp = p;
                p = a;
                a = temp;
            }
            if (a == 2) {
                break;
            }
            else if (a == 1) {
                break;
            }

        }
        if (a == 2) {
            xuLy_a_Bang2();
        } else if (a == 1) {
            if (dau.equals("")) {
                ketQuaJacobi = 1;
                //System.out.println(ketQuaJacobi);
            } else {
                ketQuaJacobi = -1;
                //System.out.println(ketQuaJacobi);
            }
        }
    }
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số nguyên  a = ");
        a = sc.nextInt();
        System.out.println("Nhập số nguyên tố lẻ p = ");
        p = sc.nextInt();
        
    }
    public void Nhap(int a,int p) {
       
        this.a = a;
        this.p = p;
    }
    public static void main(String[] args) {
        SoJacobi sj = new SoJacobi();
        sj.Nhap();
        //System.out.println("Kết quả Jacobi");
        sj.TinhToan();
    }
}
