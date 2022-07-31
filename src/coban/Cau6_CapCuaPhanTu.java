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
public class Cau6_CapCuaPhanTu {

    int Z_s_dk;
    CapCuaPhanTu_BangPhanTich ccptbpt = new CapCuaPhanTu_BangPhanTich();
    //a=17, p=20
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tính câp của phần tử ");
        System.out.println("Nhập a = ");
        Z_s_dk = sc.nextInt();
        ccptbpt.Nhap();
    }

    public void Tinh() {
        ccptbpt.tinhToan(Z_s_dk);
    }
    public static void main(String[] args) {
        Cau6_CapCuaPhanTu cccpt = new Cau6_CapCuaPhanTu();
        
        cccpt.Nhap();
        cccpt.Tinh();

    }
}
