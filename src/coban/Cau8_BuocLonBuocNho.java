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
public class Cau8_BuocLonBuocNho {

    int p, alpha, beta, m, viTrii, viTrij;
    ;
    //61 31 45 
    //97 17 15
    int A[] = new int[100];
    int B[] = new int[100];

    public void ketLuan() {
        System.out.println("\nVậy kết quả log(" + alpha + ")" + beta + " trên Z" + p + "=" + (viTrii * m + viTrij));
    }

    public void duyetTimKiemViTriiKhopViTrij() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (A[j] == B[i]) {
                    viTrii = i;
                    viTrij = j;
                    break;
                }
            }
        }
    }

    public void Tinh() {
        m = (int) (Math.sqrt(p)) + 1;
        System.out.print("Lập bảng (j," + alpha + "^j mod )" + p);
        System.out.println("\tVới 0<= j <" + m);
        for (int j = 0; j < m; j++) {
            System.out.print(j + "\t");
        }
        System.out.println("");
        for (int j = 0; j < m; j++) {
            A[j] = (int) (Math.pow(alpha, j) % p);

            System.out.print(A[j] + "\t");
        }
        System.out.println("\nCần tính: " + beta + "*(" + alpha + "^(-" + m + "))^i mod " + p);

        System.out.println("\t= " + beta + "*(" + alpha + "^(-1))^(" + m + "i) mod " + p);
        System.out.println("Sử dụng thuật toán euclide mở rộng, tính " + alpha + "^(-1) mod " + p);
        EuclideMoRong emr = new EuclideMoRong();
        emr.Run(alpha, p);
        System.out.println("=> " + alpha + "^(-1) mod " + p + " = " + emr.X[emr.count][5]);
        System.out.println("=> " + beta + "*(" + alpha + "^(-" + m + "))^i mod " + p);
        NhanBinhPhuongCoLap nbpcl = new NhanBinhPhuongCoLap();
        nbpcl.Nhap(emr.X[emr.count][5], m, p);
        int ketQuanbpcl = nbpcl.ketQua();
        System.out.println("\n");
        System.out.println("=  " + beta + "*(" + ketQuanbpcl + ")^i mod " + p);
        System.out.print("Lập bảng (j," + beta + "*" + ketQuanbpcl + "^j mod )" + p);
        System.out.println("\tVới 0<= j <" + m);
        for (int i = 0; i < m; i++) {
            System.out.print(i + "\t");
        }
        System.out.println("");
        for (int i = 0; i < m; i++) {
            B[i] = (int) (beta * Math.pow(ketQuanbpcl, i) % p);
            System.out.print(B[i] + "\t");
        }

    }
    /*
    alpha: 17
    beta: 15
    p: 97
    Kết quả đúng: 31
    */
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Nhập alpha = ");
        alpha = sc.nextInt();
        System.out.println("Nhập beta = ");
        beta = sc.nextInt();
        System.out.println("Nhập p (của Z sao)= ");
        p = sc.nextInt();
        Tinh();

    }

    public static void main(String[] args) {
        Cau8_BuocLonBuocNho blbn = new Cau8_BuocLonBuocNho();
        // System.out.println(""+(Math.pow(31, 7))%61);
        blbn.Nhap();
        blbn.duyetTimKiemViTriiKhopViTrij();
        blbn.ketLuan();
    }
}
