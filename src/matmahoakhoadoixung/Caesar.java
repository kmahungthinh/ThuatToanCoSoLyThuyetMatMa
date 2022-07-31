/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matmahoakhoadoixung;

import coban.EuclideMoRong;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Caesar {

    int a, b;
    String[] arr_str_BanRo = new String[100];
    int[] arr_int_BanRo = new int[100];
    String[] arr_str_BanMa = new String[100];
    int k;
    String banRo, banMa;

    public int chuThanhSo(String chu) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int i;
        for (i = 0; i < alphabet.length(); i++) {
            if (chu.equals(String.valueOf(alphabet.charAt(i)))) {
                break;
            }
        }
        return i;
    }

    public String soThanhChu(int t) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return String.valueOf(alphabet.charAt(t));
    }

    public void maHoa() {

        System.out.print("\nBản rõ\t\t");
        for (int i = 0; i < banRo.length(); i++) {
            arr_str_BanRo[i] = String.valueOf(banRo.charAt(i));
            System.out.print("\t" + arr_str_BanRo[i]);
        }

        System.out.println("\n");
        System.out.print("x\t\t");
        for (int i = 0; i < banRo.length(); i++) {
            System.out.print("\t" + chuThanhSo(arr_str_BanRo[i]));
        }

        System.out.println("\n");
        System.out.print("y = (x+" + k + ") mod 26");
        for (int i = 0; i < banRo.length(); i++) {
            System.out.print("\t" + (chuThanhSo(arr_str_BanRo[i]) + k) % 26);
        }

        System.out.println("\n");
        System.out.print("Bản mã\t\t");
        for (int i = 0; i < banRo.length(); i++) {
            arr_str_BanMa[i] = soThanhChu((chuThanhSo(arr_str_BanRo[i]) + k) % 26);
            System.out.print(arr_str_BanMa[i]);
        }
    }

    void hoanViThamSo() {
        banMa = banRo;
        for (int i = 0; i < banMa.length(); i++) {
            arr_str_BanMa[i] = String.valueOf(banMa.charAt(i));
        }

    }

    public void giaiMa() {
        hoanViThamSo();
        System.out.println("\n");
        System.out.print("Bản mã\t");
        for (int i = 0; i < banMa.length(); i++) {
            System.out.print("\t" + arr_str_BanMa[i]);
        }
        System.out.println("\n");
        System.out.print("y\t");
        for (int i = 0; i < banMa.length(); i++) {
            System.out.print("\t" + (chuThanhSo(arr_str_BanMa[i])));
        }

        System.out.println("\n");
        System.out.print("x\t");
        for (int i = 0; i < banMa.length(); i++) {
            int temp = 0;
            if (chuThanhSo(arr_str_BanMa[i]) - k < 0) {
                arr_int_BanRo[i] = chuThanhSo(arr_str_BanMa[i]) - k + 26;
            } else {
                arr_int_BanRo[i] = chuThanhSo(arr_str_BanMa[i]) - k;
            }
            System.out.print("\t" + (chuThanhSo(arr_str_BanMa[i]) - k) % 26);
        }
        System.out.println("\n");
         System.out.print("Bản rõ\t");
        for (int i = 0; i < banMa.length(); i++) {
            System.out.print("\t" + soThanhChu(arr_int_BanRo[i]));
        }
        System.out.println("");
    }

    /*
    Mã hóa
    k=5
    HOCTAPTOTLAODONGTOT
     */
 /*
    Giải mã
    k=5
    MTHYFUYTYQFTITSLYTY
     */
    public void Nhap() {
        Scanner sc = new Scanner(System.in);

        System.out.println("khóa K =  ");
        k = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập bản rõ (chuỗi ký tự alphabet viết in) = ");

        banRo = sc.nextLine();

    }

    public static void main(String[] args) {
        
        Caesar ca = new Caesar();
        ca.Nhap();
        int chon;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n1)Mã hóa. \n2)Giải mã. \nBạn chọn: ");
        chon = sc.nextInt();
        if (chon == 1) {
            ca.maHoa();
        } else if (chon == 2) {
            ca.giaiMa();
        }
    }
}
