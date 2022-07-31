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
public class Diffie_Hellman {

    int p, alpha, x, y, giaTriAGuiChoB, giaTriBGuiChoA;
    NhanBinhPhuongCoLap nbpcl = new NhanBinhPhuongCoLap();

    public void ketLuan() {

        System.out.println("A gửi " + giaTriAGuiChoB + " cho B, B nhận và tính khóa công khai");
        nbpcl.Nhap(giaTriAGuiChoB, y, p);
        nbpcl.Tinh();
        System.out.println("K=(alpha^x)^y mod p = " + alpha + "^" + x + " mod " + p + " = "+nbpcl.ketQua());
        
        System.out.println("B gửi " + giaTriBGuiChoA + " cho A, A nhận và tính khóa công khai");
        nbpcl.Nhap(giaTriBGuiChoA, x, p);
        nbpcl.Tinh();
        System.out.println("K=(alpha^y)^x mod p = " + alpha + "^" + y + " mod " + p + " = "+nbpcl.ketQua());
    }

    public void tinhToan() {

        System.out.print("Giá trị A gửi cho B " + alpha + "^" + x + " mod " + p);
        nbpcl.Nhap(alpha, x, p);
        nbpcl.Tinh();
        giaTriAGuiChoB = nbpcl.ketQua();
        System.out.println(" = " + giaTriAGuiChoB);

        System.out.print("Giá trị B gửi cho A " + alpha + "^" + y + " mod " + p);
        nbpcl.Nhap(alpha, y, p);
        nbpcl.Tinh();
        giaTriBGuiChoA = nbpcl.ketQua();
        System.out.println(" = " + giaTriAGuiChoB);
    }

    /*
    Giá trị công khai
    p=211
    alpha=74
    Giá trị bí mật
    x=103
    y=52
    Khóa công khai chia sẻ đúng: 137
     */
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Giá trị công khai p của A và B = ");
        p = sc.nextInt();
        System.out.println("Giá trị công khai alpha của A và B = ");
        alpha = sc.nextInt();
        System.out.println("Giá trị bí mật x của A =");
        x = sc.nextInt();
        System.out.println("Giá trị bí mật y của B =");
        y = sc.nextInt();

    }

    public static void main(String[] args) {
        Diffie_Hellman dh = new Diffie_Hellman();
        dh.Nhap();
        dh.tinhToan();
        dh.ketLuan();
    }
}
