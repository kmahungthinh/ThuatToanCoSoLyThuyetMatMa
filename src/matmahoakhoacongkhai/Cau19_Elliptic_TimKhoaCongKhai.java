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
public class Cau19_Elliptic_TimKhoaCongKhai {

    int p, a, b, nA, x, y, xgoc, x2, ygoc, y2, Lamda, x3, y3, G_2_x, G_2_y;

    public int getA() {
        return a;
    }

    public void lamdaTinhTheoTruongHop() {
        System.out.println("===Tính toán===");
        EuclideMoRong emr = new EuclideMoRong();
        int Tu, Mau;
        for (int i = 1; i <= nA - 1; i++) {
            if (xgoc == x2 && ygoc == y2) {
                Tu = (int) (3 * Math.pow(xgoc, 2) + a);
                Mau = (2 * ygoc);
                emr.Run(Mau, p);

                if (Tu == 1) {
                    Lamda = emr.X[emr.count][5];
                } else {
                    Lamda = (Tu * emr.X[emr.count][5]) % p;
                }

                while (true) {
                    if (Lamda < 0) {
                        Lamda += p;
                    } else {
                        break;
                    }
                }
                x3 = ((int) (Math.pow(Lamda, 2)) - xgoc - x2);
                while (true) {
                    if (x3 < 0) {
                        x3 += p;
                    } else {
                        break;
                    }
                }
                x3 = x3 % p;

                y3 = ((int) Lamda * (xgoc - x3) - ygoc);

                while (true) {
                    if (y3 < 0) {
                        y3 += p;
                    } else {
                        break;
                    }
                }
                y3 = y3 % p;
                System.out.println((i + 1) + "*G" + "=(" + x3 + "," + y3 + ")");
                if (i + 1 == 2) {
                    G_2_x = x3;
                    G_2_y = y3;
                }

            } else if (xgoc != x2 || ygoc != y2) {
                Tu = (y2 - ygoc);
                Mau = (x2 - xgoc);
                emr.Run(Mau, p);

                if (Tu == 0) {
                    Lamda = 0;
                } else if (Tu == 1) {
                    Lamda = emr.X[emr.count][5];
                } else {
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
                x3 = (int) ((Math.pow(Lamda, 2) - xgoc - x2));
                while (true) {
                    if (x3 < 0) {
                        x3 += p;
                    } else {
                        break;
                    }
                }

                x3 = x3 % p;
                y3 = (Lamda * (xgoc - x3) - ygoc);
                while (true) {
                    if (y3 < 0) {
                        y3 += p;
                    } else {
                        break;
                    }
                }
                y3 = y3 % p;
                System.out.println((i + 1) + "*G" + "=(" + x3 + "," + y3 + ")");
            }
            x2 = x3;
            y2 = y3;
        }
        System.out.println("===Khóa công khai của A===");
        System.out.println(nA + "*G" + "=(" + x3 + "," + y3 + ")");

    }

    public void Tinh() {
        lamdaTinhTheoTruongHop();
    }
    /*
    Tài liệu
    p=17 a=1 b=1 Gx=0 Gy=1 nA=3
    Đề
    p=11 a=1 b=6 Gx=2 Gy=7 nA=3
    */
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập hệ số mod p = ");
        p = sc.nextInt();
        System.out.println("Nhập a = ");
        a = sc.nextInt();
        System.out.println("Nhập b = ");
        b = sc.nextInt();
        System.out.println("===Nhập điểm sinh===");
        System.out.println("Nhập Gx = ");
        xgoc = sc.nextInt();
        System.out.println("Nhập Gy = ");
        ygoc = sc.nextInt();
        x2 = xgoc;
        y2 = ygoc;
        System.out.println("Nhập khóa riêng nA =");
        nA = sc.nextInt();
        
      //tài liệu
      /*p = 17;
        a = 1;
        b = 1;
        xgoc = 0;
        ygoc = 1;
        x2 = 0;
        y2 = 1;
        nA = 4;*/
        //Đề
       /*p = 11;
        a = 1;
        b = 6;
        xgoc = 2;
        ygoc = 7;
        x2 = 2;
        y2 = 7;
        nA = 3;*/
      
    }

    public void Nhap(int p, int a, int b, int xgoc
            , int ygoc, int x2,int y2,int nA) {
        this.p = p;
        this.a = a;
        this.b = b;
        this.xgoc = xgoc;
        this.ygoc = ygoc;
        this.x2 = x2;
        this.y2 = y2;
        this.nA = nA;

    }

    public static void main(String[] args) {
        Cau19_Elliptic_TimKhoaCongKhai ce = new Cau19_Elliptic_TimKhoaCongKhai();
        ce.Nhap();
        ce.Tinh();
    }
}
