/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matmahoakhoacongkhai;

import coban.NhanBinhPhuongCoLap;
import coban.EuclideMoRong;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Cau26_yC_HeMatRaBin_4CanBac2_ThuatToan3 {

    int p, q, n, r, s, x1, x2, y1, y2, c, a, b;
    EuclideMoRong emr = new EuclideMoRong();
    NhanBinhPhuongCoLap cnbpcl = new NhanBinhPhuongCoLap();

    /*
    Đề 
    c=11152
    n=41989
     */
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Thuật toán 3 tính căn bậc 2 của c mod n "
                + "\n(n=p*q, mà p và q đều đồng dư 3 mod 4)");
        System.out.println("Nhập bản mã c = ");
        c = sc.nextInt();
        System.out.println("Nhập n (tích p*q) = ");
        n = sc.nextInt();
    }

    public void phanTich_n_Thanh_p_Va_q() {

        for (int i = 3; i <= n; i++) {
            for (int j = n; j >= 3; j--) {
                if ((i * j) == n && (i % 4) == 3 && (j % 4) == 3) {
                    p = i;
                    q = j;
                }
            }
        }
        System.out.println(n + " được phân tích thành 2 số mà module với 4 bằng 3 là:");
        System.out.println("p: " + p);
        System.out.println("q: " + q);
    }
    //c=43, n=57

    public void Tinha_b() {

        System.out.println("Cần tìm a và b thỏa mãn a." + p + "+" + "b." + q + "=1, dựa vào euclide mở rộng");
        emr.Run(p, q);
        a = emr.X[emr.count][5];
        b = emr.X[emr.count][6];
        System.out.println("a = " + emr.X[emr.count][5]);
        System.out.println("b = " + emr.X[emr.count][6]);

    }

    public void tinhCan() {
        cnbpcl.Nhap(c, (p + 1) / 4, p);
        cnbpcl.Tinh();
        r = cnbpcl.ketQua() % p;
        cnbpcl.Nhap(c, (q + 1) / 4, q);
        cnbpcl.Tinh();
        s = cnbpcl.ketQua() % q;
        x1 = (a * p * s + b * q * r);
        while (true) {
            if (x1 < 0) {
                x1 += n;
            } else {
                break;
            }
        }
        x1 = x1 % n;
        x2 = n - x1;

        y1 = (a * p * s - b * q * r) % n;
        while (true) {
            if (y1 < 0) {
                y1 += n;
            } else {
                break;
            }
        }
        y1 = y1 % n;
        y2 = n - y1;
        System.out.println("4 căn bậc 2 là: " + x1 + "," + x2 + "," + y1 + "," + y2);
    }

    public static void main(String[] args) {
        System.out.flush();
        Cau26_yC_HeMatRaBin_4CanBac2_ThuatToan3 ccbtt = new Cau26_yC_HeMatRaBin_4CanBac2_ThuatToan3();
        ccbtt.Nhap();
        ccbtt.phanTich_n_Thanh_p_Va_q();
        ccbtt.Tinha_b();
        ccbtt.tinhCan();
    }
}
