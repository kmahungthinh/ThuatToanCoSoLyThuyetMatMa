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
public class Cau7_NhanBinhPhuongCoLap_ChiTietLoiGiai extends General {

  
    public int a, k, n,length;
    public int K[] = new int[100], A[] = new int[100], b[] = new int[100];

    public int ketQua() {
        
        return b[length-1];
    }
    public void Tinh() {
        String s = ketQuaChuyenDecimaSangBinary(k, chuoiNhiPhanDoDaiToiThieu(k));
        StringBuffer stringBuffer = new StringBuffer(s);
        s = stringBuffer.reverse().toString();
        length = s.length();
        System.out.println("" + length);
        for (int i = 0; i < length; i++) {
            K[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
            System.out.print(K[i] + "\t");
        }
        System.out.println();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                A[i] = a;
            } else {
                A[i] = (int) (Math.pow(A[i - 1], 2) % n);
            }
            System.out.print(A[i] + "\t");
        }
        System.out.println();
        for (int i = 0; i < length; i++) {
            if (K[i] == 1 && i == 0) {
                b[0] = a;
            } else if (K[i] == 0 && i == 0) {
                b[0] = 1;
                // b[i]=(A[i]*b[i])%n;
            } else if (K[i] == 0 && i != 0) {
                b[i] = b[i - 1];
            } else if (K[i] == 1 && i != 0) {
                b[i] = (b[i - 1] * A[i]) % n;
            }
            System.out.print(b[i] + "\t");
        }
    }
    /*
    a: 27
    k: 101
    n: 211
    
    Kết quả 90
    */
    public void Nhap() {
        System.out.println("Nhân bình phương có lặp (a^k) mod n");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số a");
        a = sc.nextInt();
        System.out.println("Nhập số k");
        k = sc.nextInt();
        System.out.println("Nhập số n");
        n = sc.nextInt();
    }
    public void Nhap(int x,int y,int z) {
        Scanner sc = new Scanner(System.in);
        a = x;
        k = y;
        n = z;
        Tinh();
    }
    public static void main(String[] args) {
        Cau7_NhanBinhPhuongCoLap_ChiTietLoiGiai nbpcl = new Cau7_NhanBinhPhuongCoLap_ChiTietLoiGiai();
        nbpcl.Nhap();
        nbpcl.Tinh();
        nbpcl.ketQua();
        System.out.println("\nVậy kết quả "+nbpcl.a+"^"+nbpcl.k+" mod "+nbpcl.n+" = "+nbpcl.b[nbpcl.length-1]);
        //System.out.println(""+nbpcl.chuoiNhiPhanDoDaiToiThieu(10));
    }
}
