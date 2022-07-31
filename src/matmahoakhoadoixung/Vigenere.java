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
public class Vigenere {

    int a, b;
    String[] arr_str_BanRo = new String[100];

    String[] arr_str_BanMa = new String[100];
    int[] arr_K = new int[100];
    int[] arr_int_BanRo = new int[100];
    int ketQuaa_mu_tru1_module26;
    int soLuongPhanTuKhoaK;
    int count;
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

        System.out.print("\nBản rõ\t");
        for (int i = 0; i < banRo.length(); i++) {
            arr_str_BanRo[i] = String.valueOf(banRo.charAt(i));
            System.out.print("\t" + arr_str_BanRo[i]);
        }

        System.out.println("\n");
        System.out.print("x\t");
        for (int i = 0; i < banRo.length(); i++) {
            arr_str_BanRo[i] = String.valueOf(banRo.charAt(i));
            System.out.print("\t" + chuThanhSo(arr_str_BanRo[i]));
        }

        System.out.println("\n");
        System.out.print("Khóa\t");
        for (int i = 0; i < banRo.length(); i++) {
            System.out.print("\t" + arr_K[i]);
        }

        System.out.println("\n");
        System.out.print("y\t");
        for (int i = 0; i < banRo.length(); i++) {
            System.out.print("\t" + (chuThanhSo(arr_str_BanRo[i]) + arr_K[i]) % 26);
        }

        System.out.println("\n");
        System.out.print("Bản mã\t");
        for (int i = 0; i < banRo.length(); i++) {
            arr_str_BanMa[i] = soThanhChu((chuThanhSo(arr_str_BanRo[i]) + arr_K[i]) % 26);
            System.out.print("" + arr_str_BanMa[i]);
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
        System.out.print("Khóa\t");
        for (int i = 0; i < banMa.length(); i++) {
            System.out.print("\t" + arr_K[i]);
        }
        System.out.println("\n");
        System.out.print("x\t");
        for (int i = 0; i < banMa.length(); i++) {
            int temp = 0;
            if (chuThanhSo(arr_str_BanMa[i]) - arr_K[i] < 0) {
                arr_int_BanRo[i] = chuThanhSo(arr_str_BanMa[i]) - arr_K[i] + 26;
            } else {
                arr_int_BanRo[i] = chuThanhSo(arr_str_BanMa[i]) - arr_K[i];
            }
            System.out.print("\t" + arr_int_BanRo[i]);
        }
        System.out.print("\nBản rõ\t");
        for (int i = 0; i < banMa.length(); i++) {
            System.out.print("\t" + soThanhChu(arr_int_BanRo[i]));
        }
    }

    public void moRongKhoa() {
        int khoaCanGapLenSoLanLa = (banRo.length() / soLuongPhanTuKhoaK) + 1;
        System.out.println("so lan: " + khoaCanGapLenSoLanLa);
        for (int i = 0; i < khoaCanGapLenSoLanLa * soLuongPhanTuKhoaK; i++) {
            arr_K[i] = arr_K[i % soLuongPhanTuKhoaK];
        }
        System.out.println("Khóa sau khi mở rộng");
        for (int i = 0; i < banRo.length(); i++) {
            System.out.print(" " + arr_K[i]);
        }
    }

    /*
   Mã hóa 
   Số phần tử: 6 
   Phần tử khóa K=(2,8,15,7,4,17): 2 8 15 7 4 17 
   Bản rõ: INFORMATIONSECURITY
     */

 /*
   Giải mã 
   Số phần tử: 6 
   Phần tử khóa K=(2,8,15,7,4,17): 2 8 15 7 4 17 
   Bản rõ: KVUVVDCBXVRJGKJYMKA
     */
    public void Nhap() {
        Scanner sc = new Scanner(System.in);

        String tempKhoaMoRong = "";
        System.out.println("Nhập số lượng phần tử khóa K =  ");
        soLuongPhanTuKhoaK = sc.nextInt();
        for (int i = 0; i < soLuongPhanTuKhoaK; i++) {
            System.out.println("Phần tử thứ [" + i + "] = ");
            arr_K[i] = sc.nextInt();
            tempKhoaMoRong += arr_K[i];
        }
        sc.nextLine();
        System.out.println("Nhập bản rõ (chuỗi ký tự alphabet viết in) = ");

        banRo = sc.nextLine();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vigenere ca = new Vigenere();
        ca.Nhap();
        ca.moRongKhoa();
        int chon;
        System.out.println("\n1)Mã hóa. \n2)Giải mã. \nBạn chọn: ");
        chon = sc.nextInt();
        if (chon == 1) {
            ca.maHoa();
        } else if (chon == 2) {
            ca.giaiMa();
        }
    }
}
