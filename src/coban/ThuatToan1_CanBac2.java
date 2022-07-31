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
public class ThuatToan1_CanBac2 {

    int a, p, r;

    public void tinhToan() {
        SoJacobi sj = new SoJacobi();
        sj.Nhap(a, p);
        sj.TinhToan();
        if (sj.ketQuaJacobi == -1) {
            System.out.println(a + " không có căn bậc 2 trên modulo " + p);
        } else {
            NhanBinhPhuongCoLap nbpcl = new NhanBinhPhuongCoLap();
            int k = (p + 1) / 4;
            nbpcl.Nhap(a, k, p);
            nbpcl.Tinh();
            r = nbpcl.ketQua();
            System.out.println("Kết quả 2 căn bậc 2 là (r,-r): là (" + r + "," + (p - r) + ")");
        }
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tính căn bậc 2 của a mod p với p đồng dư với 3 mod 4");
        System.out.println("Nhập a = ");
        a = sc.nextInt();
        System.out.println("Nhập p = ");
        p = sc.nextInt();

    }

    public static void main(String[] args) {
        ThuatToan1_CanBac2 ttcb = new ThuatToan1_CanBac2();
        ttcb.Nhap();
        ttcb.tinhToan();
    }
}
