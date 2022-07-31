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
public class ThuatToan2_CanBac2 {

    int a, p, r, d;

    public void tinhToan() {
        int k;
        SoJacobi sj = new SoJacobi();
        sj.Nhap(a, p);
        sj.TinhToan();
        if (sj.ketQuaJacobi == -1) {
            System.out.println(a + " không có căn bậc 2 trên modulo " + p);
        } else {
            NhanBinhPhuongCoLap nbpcl = new NhanBinhPhuongCoLap();
            k = (p - 1) / 4;
            nbpcl.Nhap(a, k, p);
            nbpcl.Tinh();
            d = nbpcl.ketQua();
            if (d == 1) {
                System.out.println("Thấy d=1");
                k = (p + 3) / 8;
                nbpcl.Nhap(a, k, p);
                nbpcl.Tinh();
                r = nbpcl.ketQua();
            } else if (d == p - 1) {
                System.out.println("thấy " + d + "= (" + p + "-1" + ") hay d=(p-1)");
                k = (p - 5) / 8;
                nbpcl.Nhap(4 * a, k, p);
                nbpcl.Tinh();
                r = (2 * a * nbpcl.ketQua() % p);
            }
            System.out.println("Kết quả 2 căn bậc 2 là (r,-r): là (" + r + "," + (p - r) + ")");
        }
    }

    /*
    a=40
    p=53
    Kết quả đúng: (r,-r) là (27,26)
    
    a=29
    p=53
    Kết quả đúng: (r,-r) là (33,20)
     */
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tính căn bậc 2 của a mod p với p đồng dư với 3 mod 4");
        System.out.println("Nhập a = ");
        a = sc.nextInt();
        System.out.println("Nhập p = ");
        p = sc.nextInt();

    }

    public static void main(String[] args) {
        ThuatToan2_CanBac2 ttcb = new ThuatToan2_CanBac2();
        ttcb.Nhap();
        ttcb.tinhToan();
    }
}
