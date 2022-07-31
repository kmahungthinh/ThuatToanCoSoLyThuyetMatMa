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
public class Cau18_Affine {

    int a, b;
    String maTran_BanRo[] = new String[100];
    String[] arr_str_BanMa = new String[100];
    int ketQuaa_mu_tru1_module26;

    int count;
    String banRo, banMa;
    EuclideMoRong emr = new EuclideMoRong();

    public int ketQuaNghichDaoModule(int x, int y) {
        emr.Run(x, y);
        while (true) {
            if (emr.X[emr.count][5] < 0) {
                emr.X[emr.count][5] += y;
                emr.X[emr.count][6] -= x;
            } else {
                break;
            }
        }
        return emr.X[emr.count][5];
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

    public String soThanhChu(int t) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return String.valueOf(alphabet.charAt(t));
    }

    public void maHoa() {
        System.out.println("Quy tắc mã hóa e(k) = ax+b mod 26");
        System.out.println("Vậy e[k](y) = " + a + "x+" + b + " mod 26");
        ketQuaa_mu_tru1_module26 = ketQuaNghichDaoModule(a, 26);
        System.out.println("Vậy d[k](y) = " + a + "^(-1).(y-" + b + ") mod 26 = \n"
                + "\t" + ketQuaa_mu_tru1_module26 + ".(y-" + b + ") mod 26");
        System.out.print("Bản rõ\t");
        for (int i = 0; i < banRo.length(); i++) {
            maTran_BanRo[i] = String.valueOf(banRo.charAt(i));
            System.out.print("\t" + maTran_BanRo[i]);
        }
        System.out.println("\n");
        System.out.print("x\t");
        for (int i = 0; i < banRo.length(); i++) {
            maTran_BanRo[i] = String.valueOf(banRo.charAt(i));
            System.out.print("\t" + chuThanhSo(maTran_BanRo[i]));
        }
        System.out.println("\n");
        System.out.print("y\t");
        for (int i = 0; i < banRo.length(); i++) {
            System.out.print("\t" + (a * chuThanhSo(maTran_BanRo[i]) + b) % 26);
        }
        System.out.println("\n");
        System.out.print("Bản mã\t");
        for (int i = 0; i < banRo.length(); i++) {
            arr_str_BanMa[i] = soThanhChu((a * chuThanhSo(maTran_BanRo[i]) + b) % 26);
            System.out.print("\t" + arr_str_BanMa[i]);
        }
        System.out.println("");
    }

    void hoanViThamSo() {
        banMa = banRo;
        for (int i = 0; i < banMa.length(); i++) {
            arr_str_BanMa[i] = String.valueOf(banMa.charAt(i));
        }
    }

    public void giaiMa() {
        hoanViThamSo();
        ketQuaa_mu_tru1_module26 = ketQuaNghichDaoModule(a, 26);
        System.out.println("\n");
        System.out.print("Bản mã");
        for (int i = 0; i < banMa.length(); i++) {
            System.out.print("\t" + arr_str_BanMa[i]);
        }
        System.out.println("\n");
        System.out.print("y");
        for (int i = 0; i < banMa.length(); i++) {
            System.out.print("\t" + chuThanhSo(arr_str_BanMa[i]));
        }
        System.out.println("\n");
        System.out.print("x");
        for (int i = 0; i < banMa.length(); i++) {
            
            System.out.print("\t" + (ketQuaa_mu_tru1_module26 * (chuThanhSo(arr_str_BanMa[i]) - b)) % 26);
        }
        System.out.println("\n");
        System.out.print("Bản rõ thu được");
        for (int i = 0; i < banMa.length(); i++) {
            System.out.print("\t" + soThanhChu((ketQuaa_mu_tru1_module26 * (chuThanhSo(arr_str_BanMa[i]) - b)) % 26));
        }
        System.out.println("\n");
    }

/*
Đề
Mã hóa
Khóa 1 a=3;b=7: 3 7
Khóa 2 a=4;b=3: 4 3
Khóa 3 a=7;b=3: 7 3
Khóa 4 a=3;b=3: 3 4 (Khóa Đúng)
Hãy mã hóa bản rõ: TE
*/
/*
Bổ sung
Giải mã
Khóa a=3;b=3: 3 4 
Hãy giải mã bản mã: JQ
 */
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập thông số khóa K");
        System.out.println("Nhập số a = ");
        a = sc.nextInt();
        System.out.println("Nhập số b = ");
        b = sc.nextInt();
        System.out.println("Nhập bản rõ (ký tự alphabet) = ");
        sc.nextLine();
        banRo = sc.nextLine();

    }

    public static void main(String[] args) {
        Cau18_Affine ca = new Cau18_Affine();
        Scanner sc = new Scanner(System.in);
        ca.Nhap();
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
