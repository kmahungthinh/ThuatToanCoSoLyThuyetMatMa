package coban;

import java.util.Scanner;

public class Cau1_ThuatToan4_CanBac2_ChiTieLoiGiai {

    int a, p, b, t, s, c, r, d, a_mu_tru1;

    public void chon_b() {
        System.out.println("Chọn số nguyên b để (b/p) = -1");
        SoJacobi sj = new SoJacobi();
        for (int i = 1; i <= p; i++) {
            sj.Nhap(i, p);
            sj.TinhToan();
            if (sj.ketQuaJacobi == -1) {
                b = i;
                break;
            }
        }
        System.out.println("Chọn được b = " + b);
    }

    public void phanTich_pTru1() {
        for (int i = 1; i <= p - 1; i++) {
            for (int j = 1; j <= p - 1; j++) {
                if ((Math.pow(2, j) * i == (p - 1)) && (i % 2 == 1)) {
                    s = j;
                    t = i;
                }
            }
        }
        System.out.println("s = " + s);
        System.out.println("t = " + t);
    }

    public void tinh_aMu_tru1modp() {
        EuclideMoRong e = new EuclideMoRong();
        e.Run(a, p);
        e.KetLuan();
        while (true) {
            if (e.X[e.count][5] < 0) {
                e.X[e.count][5] += e.m;
            } else {
                break;
            }
        }
        a_mu_tru1 = e.X[e.count][5];
        System.out.println("a: " + e.X[e.count][5]);
    }

    public void tinh_c_r() {
        c = (int) (Math.pow(b, t) % p);
        r = (int) Math.pow(a, (t + 1) / 2) % p;
        //System.out.println("a: " + c + "r: " + r);
    }

    public void kiemTraJacobi() {
        SoJacobi sj = new SoJacobi();
        sj.Nhap(a, p);
        sj.TinhToan();
        if (sj.ketQuaJacobi == 1) {
            System.out.println("Kết quả Jacobi khác -1 nên " + a + " có căn bậc 2 trên modulo " + p);
        } else {
            System.out.println("Kết quả Jacobi bằng -1 nên " + a + " không có căn bậc 2 trên modulo " + p);
        }
    }

    /*
    a: 75 
    p: 97
    Kết quả đúng tại vòng lặp nhất i=1 là: 
    d= 1
    r= 96
    c= 8
    */
    public void Nhap() {
        System.out.println("Thuật toán tính căn bậc 2 của a mod p\n(với p là số nguyên tố lẻ)");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập a = ");
        a = sc.nextInt();
        System.out.println("Nhập số nguyên tố lẻ p = ");
        p = sc.nextInt();
    }

    public void tinh_d() {
        for (int i = 1; i <= s - 1; i++) {
            System.out.println("Vòng lặp thứ " + i);
            NhanBinhPhuongCoLap cnbpcl = new NhanBinhPhuongCoLap();
            int tich_d_mod = (int) (Math.pow(r, 2) * a_mu_tru1);
            int k = (int) Math.pow(2, s - i - 1);
            cnbpcl.Nhap(tich_d_mod, k, p);
            cnbpcl.Tinh();
            cnbpcl.ketQua();
            d = cnbpcl.b[cnbpcl.length - 1];
            if ((d + 1) % p == 0) {
                d = -1;
            }
            if (d == -1) {
                r = (r * c) % p;
            }
            c = (int) (Math.pow(c, 2) % p);
            System.out.println("tích d mod= " + tich_d_mod);
            System.out.println("k= " + k);
            System.out.println("p= " + p);
            //System.out.println("a= " + cnbpcl.b[cnbpcl.length - 1]);
            System.out.println("d= " + d);
            System.out.println("r= " + r);
            System.out.println("c= " + c);
        }
        System.out.println("Kết quả 2 căn bậc 2 là (-r,r): là (" + (p - r) + "," + r + ")");
    }

    public static void main(String[] args) {
        Cau1_ThuatToan4_CanBac2_ChiTieLoiGiai ttcb = new Cau1_ThuatToan4_CanBac2_ChiTieLoiGiai();
        ttcb.Nhap();
        ttcb.kiemTraJacobi();
        ttcb.chon_b();
        ttcb.phanTich_pTru1();
        ttcb.tinh_aMu_tru1modp();
        ttcb.tinh_c_r();
        ttcb.tinh_d();
    }
}
