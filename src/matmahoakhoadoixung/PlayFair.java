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
public class PlayFair {

    String tuKhoaChuanHoa5x5, tuKhoaSauKhiLoaiTrung, tuKhoa, banRo;
    String[] arr_Str_CapDoiAlphabetTuBanRo = new String[100];
    int count_CapBanMaDuocPhanTach;

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập từ khóa: ");
        tuKhoa = sc.nextLine();
        System.out.println("Nhập bản rõ: ");
        banRo = sc.nextLine();
        taoTuKhoaSauKhiLoaiBoKyTuTrung();
    }
    String maTran_5x5[][] = new String[100][100];

    /*
    Mã hóa
    Từ khóa: CHARLES
    Bản rõ: MEETMEATHAMMERSMITHBRIDGETONIGHT
    KQ đúng của bản mã: GDDOGDRQARKYGDHDNKPRDAMSOGUPGKICQY
    
    Giải mã
    Từ khóa: CHARLES
    Bản mã: GDDOGDRQARKYGDHDNKPRDAMSOGUPGKICQY
    KQ đúng của bản rõ: MEETMEATHAMMERSMITHBRIDGETONIGHT
     */
    public void taoTuKhoaSauKhiLoaiBoKyTuTrung() {
        tuKhoaSauKhiLoaiTrung = "";
        for (int i = 0; i < tuKhoa.length(); i++) {
            if (coChua(tuKhoaSauKhiLoaiTrung, String.valueOf(tuKhoa.charAt(i))) == false) {
                tuKhoaSauKhiLoaiTrung += String.valueOf(tuKhoa.charAt(i));
            }
        }

    }

    public boolean coChua(String str, String kytu) {
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equals(kytu)) {
                return true;
            }
        }
        return false;

    }

    public int xacDinhViTri_i_KyTuTrongMaTran(String kyTuDauVao) {
        int count = 0;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                if (maTran_5x5[i][j].equals(kyTuDauVao)) {
                    return i;
                }

            }
        }
        return 0;
    }

    public int xacDinhViTri_j_KyTuTrongMaTran(String kyTuDauVao) {
        int count = 0;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                if (maTran_5x5[i][j].equals(kyTuDauVao)) {
                    return j;
                }

            }
        }
        return 0;
    }

    public void taoMaTran5x5() {
        int count = 0;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                maTran_5x5[i][j] = String.valueOf(tuKhoaChuanHoa5x5.charAt(count));
                count++;
                System.out.print("\t" + maTran_5x5[i][j]);
            }
            System.out.println("");
        }
    }

    public void buDapHoanThienChuoi25KyTu() {
        String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        String temp = tuKhoaSauKhiLoaiTrung;
        boolean coTrung = false;
        for (int i = 0; i < alphabet.length(); i++) {
            for (int j = 0; j < tuKhoaSauKhiLoaiTrung.length(); j++) {
                if ((String.valueOf(alphabet.charAt(i)).equals(String.valueOf(tuKhoaSauKhiLoaiTrung.charAt(j))))) {
                    coTrung = true;
                    break;
                }
            }
            if (coTrung == false) {
                temp += String.valueOf(alphabet.charAt(i));
            } else {
                coTrung = false;
            }
        }
        tuKhoaChuanHoa5x5 = temp;
        System.out.println("Bản rõ sau chuẩn hóa: " + tuKhoaChuanHoa5x5);
    }

    public String ketQuaMaHoaCapDoi(String capDoi) {

        int a = xacDinhViTri_i_KyTuTrongMaTran(String.valueOf(capDoi.charAt(0)));
        int b = xacDinhViTri_j_KyTuTrongMaTran(String.valueOf(capDoi.charAt(0)));
        int c = xacDinhViTri_i_KyTuTrongMaTran(String.valueOf(capDoi.charAt(1)));
        int d = xacDinhViTri_j_KyTuTrongMaTran(String.valueOf(capDoi.charAt(1)));
        if (a != c && b != d) {
            return maTran_5x5[a][d] + maTran_5x5[c][b];
        } else if (a == c) {
            if (b + 1 == 6) {
                b = 0;
            }
            if (d + 1 == 6) {
                d = 0;
            }
            return maTran_5x5[a][b + 1] + maTran_5x5[c][d + 1];
        } else if (b == d) {

            if (a + 1 == 6) {
                a = 0;
            }
            if (c + 1 == 6) {
                c = 0;
            }
            return maTran_5x5[a + 1][d] + maTran_5x5[c + 1][b];
        }
        return null;

    }
    public String ketQuaGiaiMaCapDoi(String capDoi) {

        int a = xacDinhViTri_i_KyTuTrongMaTran(String.valueOf(capDoi.charAt(0)));
        int b = xacDinhViTri_j_KyTuTrongMaTran(String.valueOf(capDoi.charAt(0)));
        int c = xacDinhViTri_i_KyTuTrongMaTran(String.valueOf(capDoi.charAt(1)));
        int d = xacDinhViTri_j_KyTuTrongMaTran(String.valueOf(capDoi.charAt(1)));
        if (a != c && b != d) {
            return maTran_5x5[a][d] + maTran_5x5[c][b];
        } else if (a == c) {
            if (b - 1 == 0) {
                b = 6;
            }
            if (d - 1 == 0) {
                d = 6;
            }
            
            return maTran_5x5[a][b - 1] + maTran_5x5[c][d - 1];
        } else if (b == d) {

            if (a - 1 == 0) {
                a = 6;
            }
            if (c - 1 == 0) {
                c = 6;
            }
            return maTran_5x5[a - 1][d] + maTran_5x5[c - 1][b];
        }
        return null;

    }

    public void taoCapBanRo() {
        String chuoiBanRoCaiBien = "";
        int tang = 2;
        int tacdong = 0;
        for (int i = 0; i < banRo.length() - 1; i += tang) {
            count_CapBanMaDuocPhanTach++;
            if (banRo.charAt(i) == banRo.charAt(i + 1)) {
                chuoiBanRoCaiBien += String.valueOf(banRo.charAt(i)) + "X$";
                tang = 1;
                tacdong++;
            } else {
                chuoiBanRoCaiBien += String.valueOf(banRo.charAt(i)) + String.valueOf(banRo.charAt(i + 1)) + "$";
                tang = 2;
            }

        }
        if ((banRo.length() % 2 == 0 && tacdong % 2 == 1) || (banRo.length() % 2 == 1 && tacdong % 2 == 0)) {
            chuoiBanRoCaiBien += String.valueOf(banRo.charAt(banRo.length() - 1)) + "X$";
            count_CapBanMaDuocPhanTach++;
        }
        arr_Str_CapDoiAlphabetTuBanRo = chuoiBanRoCaiBien.split("\\$");
        for (int i = 0; i < count_CapBanMaDuocPhanTach; i++) {
            System.out.println("Cặp bản rõ cải biến: " + arr_Str_CapDoiAlphabetTuBanRo[i]);
        }
        System.out.println("Chuỗi bản rõ cải biến: " + chuoiBanRoCaiBien);

    }

    public void taoBanMa() {
        String chuoiBanMa = "";
        for (int i = 0; i < count_CapBanMaDuocPhanTach; i++) {
            chuoiBanMa += ketQuaMaHoaCapDoi(arr_Str_CapDoiAlphabetTuBanRo[i]);
            System.out.println("Mã Hóa: " + ketQuaMaHoaCapDoi(arr_Str_CapDoiAlphabetTuBanRo[i]));
        }
        System.out.println("Chuỗi bản mã: " + chuoiBanMa);
    }
    String chuoiBanRoChuaX;
    public void taoBanRo() {
        chuoiBanRoChuaX="";
        for (int i = 0; i < count_CapBanMaDuocPhanTach; i++) {
            chuoiBanRoChuaX += ketQuaGiaiMaCapDoi(arr_Str_CapDoiAlphabetTuBanRo[i]);
            System.out.println("Giải mã: " + ketQuaGiaiMaCapDoi(arr_Str_CapDoiAlphabetTuBanRo[i]));
        }
        System.out.println("Chuỗi bản rõ chứa X: " + chuoiBanRoChuaX);
    }
    public void taoBanRoChuanKhiLoaiBoKyTuX()
    {
        String banRoChuan="";
        for (int i = 0; i < chuoiBanRoChuaX.length(); i++) {
            if(chuoiBanRoChuaX.charAt(i)!='X')
            banRoChuan += String.valueOf(chuoiBanRoChuaX.charAt(i));
        }
        System.out.println("Chuỗi bản rõ chuẩn: " + banRoChuan);
        
    }
    public void maHoa() {
        taoTuKhoaSauKhiLoaiBoKyTuTrung();
        buDapHoanThienChuoi25KyTu();
        taoMaTran5x5();
        taoCapBanRo();
        taoBanMa();
    }
    
    public void giaiMa() {
        taoTuKhoaSauKhiLoaiBoKyTuTrung();
        buDapHoanThienChuoi25KyTu();
        taoMaTran5x5();
        taoCapBanRo();
        taoBanRo();
        taoBanRoChuanKhiLoaiBoKyTuX();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlayFair pf = new PlayFair();
        pf.Nhap();
        
        int chon;
        System.out.println("\n1)Mã hóa. \n2)Giải mã. \nBạn chọn: ");
        chon = sc.nextInt();
        if (chon == 1) {
            pf.maHoa();
        } else if (chon == 2) {
            pf.giaiMa();
        }
       

    }
}
