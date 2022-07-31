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
public class Cau32_KhoaChay {

    String KhoaK, str_KhoaKChay;
    String banRo, banMa;
    String str_maTran_BanRo[] = new String[1000];
    String str_maTran_BanMa[] = new String[1000];
    int int_maTran_KhoaChay[] = new int[1000];
    int y[] = new int[1000];
    int x[] = new int[1000];
    String str_maTran_KhoaChay[] = new String[1000];

    public String soThanhChu(int t) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return String.valueOf(alphabet.charAt(t));
    }

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

    public void maHoa() {
        System.out.print("Bản rõ\t\t");
        for (int i = 0; i < banRo.length(); i++) {
            str_maTran_BanRo[i] = String.valueOf(banRo.charAt(i));
            System.out.print("\t" + str_maTran_BanRo[i]);
        }

        System.out.println("\n");
        System.out.print("x(mã hóa)\t");
        for (int i = 0; i < banRo.length(); i++) {
            str_maTran_BanRo[i] = String.valueOf(banRo.charAt(i));
            x[i] = chuThanhSo(str_maTran_BanRo[i]);
            System.out.print("\t" + x[i]);
        }
        System.out.println("\n");
        System.out.print("Khóa chạy (ký tự)");
        for (int i = 0; i < banRo.length(); i++) {
            str_maTran_KhoaChay[i] = String.valueOf(str_KhoaKChay.charAt(i));
            System.out.print("\t" + str_maTran_KhoaChay[i]);
        }

        System.out.println("\n");
        System.out.print("Khóa chạy (số)\t");
        for (int i = 0; i < banRo.length(); i++) {
            int_maTran_KhoaChay[i] = chuThanhSo(String.valueOf(str_KhoaKChay.charAt(i)));
            System.out.print("\t" + int_maTran_KhoaChay[i]);
        }

        System.out.println("\n");
        System.out.print("y\t\t");
        for (int i = 0; i < banRo.length(); i++) {
            y[i] = (x[i] + int_maTran_KhoaChay[i]) % 26;
            System.out.print("\t" + y[i]);
        }

        System.out.println("\n");
        System.out.print("Bản mã\t\t");
        for (int i = 0; i < banRo.length(); i++) {
            str_maTran_BanMa[i] = soThanhChu(y[i]);
            System.out.print("\t" + str_maTran_BanMa[i]);
        }

    }

    public void giaiMa() {
        System.out.print("Bản mã\t\t");
        for (int i = 0; i < banMa.length(); i++) {
            str_maTran_BanMa[i] = String.valueOf(banMa.charAt(i));
            System.out.print("\t" + str_maTran_BanMa[i]);
        }

        System.out.println("\n");
        System.out.print("y\t\t");
        for (int i = 0; i < banMa.length(); i++) {
            str_maTran_BanMa[i] = String.valueOf(banMa.charAt(i));
            y[i] = chuThanhSo(str_maTran_BanMa[i]);
            System.out.print("\t" + y[i]);
        }
        System.out.println("\n");
        System.out.print("Khóa chạy (số)\t");
        for (int i = 0; i < banMa.length(); i++) {
            int_maTran_KhoaChay[i] = chuThanhSo(String.valueOf(str_KhoaKChay.charAt(i)));
            System.out.print("\t" + int_maTran_KhoaChay[i]);
        }
        System.out.println("\n");
        System.out.print("x\t\t");
        for (int i = 0; i < banMa.length(); i++) {
            if (y[i] - int_maTran_KhoaChay[i] < 0) {
                x[i] = (y[i] - int_maTran_KhoaChay[i]) + 26;
            } else {
                x[i] = (y[i] - int_maTran_KhoaChay[i]) % 26;
            }
            System.out.print("\t" + x[i]);
        }
        System.out.println("\n");
        System.out.print("Bản rõ\t\t");
        for (int i = 0; i < banMa.length(); i++) {
            str_maTran_BanMa[i] = soThanhChu(x[i]);
            System.out.print("\t" + str_maTran_BanMa[i]);
        }
        System.out.println("");

    }

    /*
    ===Mã hóa===
    VD1:
    Chọn: 1
    Khóa: DECEPTIVE
    Bản rõ: WEAREDISCOVEREDSAVEYOURSELF
    Kết quả đúng bản mã: ZICVTWQNGKZEIIGASXSTSLVVWLA
    VD2:
    Chọn: 1
    Khóa: SUN
    Bản rõ: SQUIDGAME
    Kết quả đúng bản mã: KKHATAIPK
    
    ===Giải mã===
    chọn: 2
    Khóa sinh từ bản mã: SUNSQUIDG
    Bản mã: KKHATAIPK
    Kết quả đúng bản mã: SQUIDGAME
     */
    public void nhapBanRo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập từ khóa K");
        KhoaK = sc.nextLine();
        System.out.println("Nhập bản rõ (ký tự alphabet) = ");
        banRo = sc.nextLine();
        str_KhoaKChay = (KhoaK + banRo).substring(0, banRo.length());

    }

    public void nhapBanMa() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập khóa sinh từ bản rõ");
        str_KhoaKChay = sc.nextLine();
        System.out.println("Nhập bản mã (ký tự alphabet) = ");
        banMa = sc.nextLine();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cau32_KhoaChay chmkc = new Cau32_KhoaChay();

        int chon;
        System.out.println("\n1)Mã hóa. \n2)Giải mã. \nBạn chọn: ");
        chon = sc.nextInt();
        if (chon == 1) {
            chmkc.nhapBanRo();
            chmkc.maHoa();
        } else if (chon == 2) {
            chmkc.nhapBanMa();
            chmkc.giaiMa();
        }
    }
}
