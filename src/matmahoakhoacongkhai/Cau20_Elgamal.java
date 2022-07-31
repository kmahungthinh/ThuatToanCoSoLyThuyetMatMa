/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matmahoakhoacongkhai;

import coban.NhanBinhPhuongCoLap;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Cau20_Elgamal {

    int p, alpha, a, alpha_mu_a, m, k, delta, gamma, gamma_mu_p_tru1_trua;
    NhanBinhPhuongCoLap cnbpcl = new NhanBinhPhuongCoLap();

    /*
    Sách
    p=2357 alpha=2 a=1751 m=2035 k=1520
    Tài liệu
    p=211 alpha=41 a=117 m=56 k=23
    Đề
    p=211 alpha=41 a=117 m=56 k=33
    */
    public void tinhKhoaCongKhai() {
        cnbpcl.Nhap(alpha, a, p);
        cnbpcl.Tinh();
        alpha_mu_a = cnbpcl.ketQua();
        System.out.println("\nKhóa công khai là (p=" + p + ", alpha=" + alpha + ", alpha^a=" + alpha_mu_a + ")");
    }

    public void maHoaBanTin() {
        cnbpcl.Nhap(alpha, k, p);
        cnbpcl.Tinh();
        gamma = cnbpcl.ketQua();

        cnbpcl.Nhap(alpha_mu_a, k, p);
        cnbpcl.Tinh();
        delta = (m * cnbpcl.ketQua()) % p;

        System.out.println("\nBản tin c được mã hóa là c: (gamma=" + gamma + ", delta=" + delta + ")");
    }

    public void giaiMaBanTin() {
        cnbpcl.Nhap(gamma, (p - 1 - a), p);
        cnbpcl.Tinh();
        gamma_mu_p_tru1_trua = cnbpcl.ketQua();
        System.out.println("\nĐể giải mã thì cần tính gamma^(p-1-a) mod p = ");
        System.out.println("=" + gamma + "^" + (p - 1 - a) + " mod " + p + " = " + gamma_mu_p_tru1_trua);
        System.out.println("Khôi phục bản rõ m bằng cách lấy (gamma.gamma^(p-1-a)) mod p ");
        System.out.println("=(" + gamma + "." + gamma_mu_p_tru1_trua + ") mod " + p + " = " + ((delta * gamma_mu_p_tru1_trua) % p));
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập p = ");
        p = sc.nextInt();
        System.out.println("Nhập phần tử sinh alpha của Z(" + p + ") =");
        alpha = sc.nextInt();
        System.out.println("Nhập khóa bí mật a = ");
        a = sc.nextInt();
        System.out.println("Nhập bản tin cần mã hóa m = ");
        m = sc.nextInt();
        System.out.println("Nhập số ngẫu nhiên k = ");
        k = sc.nextInt();

    }

    public static void main(String[] args) {
        Cau20_Elgamal ce = new Cau20_Elgamal();
        ce.Nhap();
        ce.tinhKhoaCongKhai();
        ce.maHoaBanTin();
        ce.giaiMaBanTin();
    }
}
