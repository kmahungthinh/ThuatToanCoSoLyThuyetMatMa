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
public class KiemTraSoNguyenTo {
    /**
     * main
     * 
     * @author viettuts.vn
     * @param args
     */
    public static void main(String[] args) {
        int soKiemTra;
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập số ");soKiemTra=sc.nextInt();
            if (isPrimeNumber(soKiemTra)==true) {
                System.out.println("Có là số nguyên tố");
        }
    }
  
    /**
     * check so nguyen to
     * 
     * @author viettuts.vn
     * @param n: so nguyen duong
     * @return true la so nguyen so, 
     *         false khong la so nguyen to
     */
    public static boolean isPrimeNumber(int n) {
        // so nguyen n < 2 khong phai la so nguyen to
        if (n < 2) {
            return false;
        }
        // check so nguyen to khi n >= 2
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
