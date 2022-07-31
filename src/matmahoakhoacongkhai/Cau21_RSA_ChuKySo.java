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
public class Cau21_RSA_ChuKySo {

    NhanBinhPhuongCoLap cnbpcl = new NhanBinhPhuongCoLap();
    EuclideMoRong emr = new EuclideMoRong();
    public int phy, p, q, d, n, m, e , S, mxacthuc;

    public int thongDiepSauKhiKy(int m, int n, int d) {
        cnbpcl.Nhap(m, d, n);
        cnbpcl.Tinh();
        S = cnbpcl.b[cnbpcl.length - 1];
        return S;
    }

    public int thongDiepSauKhiGiaiMaXacMinh(int S, int e, int n) {
        cnbpcl.Nhap(S, e, n);
        cnbpcl.Tinh();
        mxacthuc = cnbpcl.b[cnbpcl.length - 1];
        return mxacthuc;
    }

    public void khoaCongKhai() {
        emr.Run(d, phy);
        while (true) {
            if (emr.X[emr.count][5] < 0) {
                emr.X[emr.count][5] += phy;
                emr.X[emr.count][6] -= d;
            }else{
                break;
            }
        }
        e=emr.X[emr.count][5];
        System.out.println("Khóa công khai: (n = " + n + ", e = " + e + ")");
    }

    //p=31, q=23, d=223, m=439
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập p (số nguyên tố thứ nhất): ");
        p = sc.nextInt();
        System.out.println("Nhập q (số nguyên tố thứ hai): ");
        q = sc.nextInt();
        System.out.println("Nhập d (khóa bí mật): ");
        d = sc.nextInt();
        System.out.println("Nhập m (thông điệp): ");
        m = sc.nextInt();
        n = p * q;
        phy = (p - 1) * (q - 1);
    }

    public static void main(String[] args) {
        Cau21_RSA_ChuKySo rsatck = new Cau21_RSA_ChuKySo();
        rsatck.Nhap();
        rsatck.khoaCongKhai();
        System.out.println("\n=>Thông điệp sau ký S = (m^d) mod n = (" + rsatck.m + "^" + rsatck.d + ") mod " + rsatck.n + " = "
                + rsatck.thongDiepSauKhiKy(rsatck.m, rsatck.n, rsatck.d));
        System.out.println("\n=>Xác minh chữ ký m = (S^e) mod n = (" + rsatck.S + "^" + rsatck.e + ") mod " + rsatck.n + " = "
                + rsatck.thongDiepSauKhiGiaiMaXacMinh(rsatck.S, rsatck.e, rsatck.n));
        
    }

}
