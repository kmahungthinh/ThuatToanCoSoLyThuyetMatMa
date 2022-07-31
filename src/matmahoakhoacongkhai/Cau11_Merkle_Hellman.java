/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matmahoakhoacongkhai;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Cau11_Merkle_Hellman {

    int n, M, W;
    int phanTuDaySieuTang[] = new int[100];
    int phanTuHoanViPi[] = new int[100];
    int phanTuKhoaCongKhai[] = new int[100];
//Đề
/*
Nhập n = 
6
Phần tử dãy siêu tăng
12 17 33 64 137 326
Nhập M = 
737
Nhập W = 
635
Phần tử hoán vị pi
3 6 1 2 5 4
    
Nhập n = 
6
Phần tử dãy siêu tăng
12 17 33 64 137 326
Nhập M = 
737
Nhập W = 
635
Phần tử hoán vị pi
4 5 2 1 6 3   
Đáp án khóa công khai: (105, 29, 477, 250, 650, 319)
 
*/
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập n = ");
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Nhập phần tử siêu tăng " + i + " = ");
            phanTuDaySieuTang[i] = sc.nextInt();
        }
        System.out.println("Nhập M = ");
        M = sc.nextInt();
        System.out.println("Nhập W = ");
        W = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Nhập phần tử hoán vị pi(" + i + ") = ");
            phanTuHoanViPi[i] = sc.nextInt();
        }
       
    }

    public void khoaBiMat() {
        System.out.println();
        System.out.println("Khóa bí mật của A là: (pi,M,W(dãy siêu tăng))");
        System.out.print("Cụ thể là: (");
        for(int i=1;i<=6;i++)
        {
            System.out.print("pi("+i+")="+phanTuHoanViPi[i]+",");
        }
        System.out.print(M+","+W+"(");
        for(int i=1;i<=6;i++)
        {
            System.out.print(phanTuDaySieuTang[i]);
            if (i != n) {
                System.out.print(", ");
            }
        }
        System.out.print(")");
    }

    public void khoaCongKhai() {
        System.out.print("Khóa công khai: (");
        for (int i = 1; i <= n; i++) {
            System.out.print(phanTuKhoaCongKhai[i]);
            if (i != n) {
                System.out.print(", ");
            }
        }
        System.out.print(")");
    }

    public void tinhAi() {
        for (int i = 1; i <= n; i++) {

            System.out.println("a" + i + " = W.PTSIEUTANGpi(" + i + ") mod M = "
                    + W + ".M" + phanTuHoanViPi[i] + "mod " + M + " = " + W + "." + phanTuDaySieuTang[phanTuHoanViPi[i]] + " mod " + M
                    + " = " + (W * phanTuDaySieuTang[phanTuHoanViPi[i]]) % M);
            phanTuKhoaCongKhai[i] = (W * phanTuDaySieuTang[phanTuHoanViPi[i]]) % M;

        }
    }

    public static void main(String[] args) {
        Cau11_Merkle_Hellman cmh = new Cau11_Merkle_Hellman();
        cmh.Nhap();
        cmh.tinhAi();
        cmh.khoaCongKhai();
        cmh.khoaBiMat();
    }

}
