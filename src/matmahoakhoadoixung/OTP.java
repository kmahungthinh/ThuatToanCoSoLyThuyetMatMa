/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matmahoakhoadoixung;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class OTP {

    int count, countsub;
    int banRo[] = new int[100];
    int banMa[] = new int[100];
    int K[] = new int[100];

    /*
Mã hóa
Đếm Tổng 9
Đếm nhóm con 3
Dãy phần tử: 1 0 1 0 1 0 1 1 1 
Dãy phần tử khóa: 0 1 0 1 0 0 1 1 0
     */
 /*
Giả mã 
Đếm Tổng 9
Đếm nhóm con 3
Dãy phần tử: 1 1 1 1 1 0 0 0 1 
Dãy phần tử khóa: 0 1 0 1 0 0 1 1 0
     */
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tổng lượng phần tử của khóa cũng như của bản mã = ");
        count = sc.nextInt();
        System.out.println("Số lượng phần tử của khóa cũng như của bản mã trong 1 nhóm = ");
        countsub = sc.nextInt();
        for (int i = 1; i <= count; i++) {
            System.out.println("Nhập phần tử thứ [" + i + "] của bản rõ: ");
            banRo[i] = sc.nextInt();
        }
        System.out.print("Bản rõ (bản mã) vừa nhập (");
        for (int i = 1; i <= count; i++) {
            System.out.print(banRo[i] + " ");
            if (i % countsub == 0 && i != count) {
                System.out.print(",");
            }
        }
        System.out.println(")");
        for (int i = 1; i <= count; i++) {
            System.out.println("Nhập phần tử thứ [" + i + "] của khóa K: ");
            K[i] = sc.nextInt();
        }
        System.out.print("Khóa K (");
        for (int i = 1; i <= count; i++) {
            System.out.print(K[i] + " ");
            if (i % countsub == 0 && i != count) {
                System.out.print(",");
            }
        }
        System.out.println(")");
    }

    public void maHoaVaGiaiMa() {
        for (int i = 1; i <= count; i++) {
            banMa[i] = banRo[i] ^ K[i];
        }
        System.out.print("Bản mã (Bản rõ)");
        for (int i = 1; i <= count; i++) {
            System.out.print(banMa[i] + " ");
            if (i % countsub == 0 && i != count) {
                System.out.print(",");
            }
        }
        System.out.println(")");
    }

    public static void main(String[] args) {
        OTP hmotp = new OTP();
        hmotp.Nhap();
        hmotp.maHoaVaGiaiMa();
    }
}
