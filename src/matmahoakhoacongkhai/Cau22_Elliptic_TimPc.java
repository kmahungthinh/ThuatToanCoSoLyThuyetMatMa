/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matmahoakhoacongkhai;

import coban.EuclideMoRong;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Cau22_Elliptic_TimPc {

    int k, PMx, PMy, PAx, PAy, kPAx, kPAy, Lamda, p, x3, y3, a, b, Gx, Gy;

    public void Tinh() {
        EuclideMoRong emr = new EuclideMoRong();
        System.out.println("PM + 2PB = " + "(" + PMx + "," + PMy + ") + " + "(" + kPAx + "," + kPAy + ")");
        int Tu, Mau;
        Tu = (kPAy - PMy);
        Mau = (kPAx - PMx);
        System.out.println("t: " + Tu);
        System.out.println("m: " + Mau);
        
         while (true) {
                if (Mau < 0) {

                    Mau += p;
                } else {
                    break;
                }
                Mau = Mau % p;
            }
         emr.Run(Mau, p);
        
        if (Tu == 0) {
            Lamda = 0;

        } else if (Tu == 1) {
            Lamda = emr.X[emr.count][5];
        } else {
            System.out.println("Hello");
            Lamda = (Tu * emr.X[emr.count][5]);
            while (true) {
                if (Lamda < 0) {

                    Lamda += p;
                } else {
                    break;
                }
                Lamda = Lamda % p;
            }
            while (true) {
                if (emr.X[emr.count][5] < 0) {

                    emr.X[emr.count][5] += p;
                } else {
                    break;
                }
            }
        }
        x3 = (int) ((Math.pow(Lamda, 2) - PMx - kPAx));
        System.out.println("x3: " + x3);
        while (true) {
            if (x3 < 0) {

                x3 += p;
            } else {
                break;
            }
        }

        x3 = x3 % p;
        y3 = (Lamda * (PMx - x3) - PMy);
        while (true) {
            if (y3 < 0) {
                
                y3 += p;
            } else {
                break;
            }
        }
        
        y3 = y3 % p;
        Cau19_Elliptic_TimKhoaCongKhai cetkck
                = new Cau19_Elliptic_TimKhoaCongKhai();
        cetkck.Nhap(p, a, b, Gx, Gy, Gx, Gy, k);
        cetkck.Tinh();
        System.out.println("Vậy Pc=[(2G),(PM+2PB)] = " + "[("
                + cetkck.G_2_x + "," + cetkck.G_2_y + "),(" + x3 + "," + y3 + ")]");
    }

    public void Nhap() {

        //Tài liệu
        /* p = 17;
        a = 1;
        b = 1;
        Gx = 0;
        Gy = 1;
        k = 2;
        PAx = 9;
        PAy = 12;
        kPAx = 15;
        kPAy = 12;
        PMx = 10;
        PMy = 12;
        
        Đề
        p = 11;
        a = 1;
        b = 6;
        Gx = 7;
        Gy = 2;
        k = 2;
        PAx = 5;
        PAy = 2;
        kPAx = 10;
        kPAy = 2;
        PMx = 3;
        PMy = 6;
        11 1 6 7 2 2 5 2 10 2 3 6
        
        p = 11;
        a = 1;
        b = 6;
        Gx = 7;
        Gy = 2;
        k = 3;
        PAx = 7;
        PAy = 2;
        kPAx = 3;
        kPAy = 5;
        PMx = 10;
        PMy = 9;
        11 1 6 7 2 3 7 2 3 5 10 9
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập hệ số mod p = ");
        p = sc.nextInt();
        System.out.println("Nhập a = ");
        a = sc.nextInt();
        System.out.println("Nhập b = ");
        b = sc.nextInt();
        System.out.println("===Nhập điểm sinh===");
        System.out.println("Nhập Gx = ");
        Gx = sc.nextInt();
        System.out.println("Nhập Gy = ");
        Gy = sc.nextInt();

        System.out.println("Nhập số ngẫu nhiên k: ");
        k = sc.nextInt();
        System.out.println("Nhập PAx: ");
        PAx = sc.nextInt();
        System.out.println("Nhập PAy: ");
        PAy = sc.nextInt();
        System.out.println("Nhập " + k + "PAx: ");
        kPAx = sc.nextInt();
        System.out.println("Nhập " + k + "PAy: ");
        kPAy = sc.nextInt();
        System.out.println("Nhập PMx: ");
        PMx = sc.nextInt();
        System.out.println("Nhập PMy: ");
        PMy = sc.nextInt();
    }

    public static void main(String[] args) {
        Cau22_Elliptic_TimPc cetp = new Cau22_Elliptic_TimPc();
        cetp.Nhap();
        cetp.Tinh();
    }
}
