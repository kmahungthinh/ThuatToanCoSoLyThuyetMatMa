/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash.sha256;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 *
 * @author Admin
 */
public class SHA_256_XuLyChuoiDauVao extends Cal {

    public void chenThem48TuSau16Tu(String[] w) {
        for (int i = 16; i <= 63; i++) {
            w[i] = "";
            for (int j = 0; j < 32; j++) {
                w[i] += "0";
            }
        }
    }

    public void gomNhom16TuVaLuuVaoW(String chuoi, String[] w) {
        System.out.println("16 WORD");
        int count = 0;
        for (int i = 0; i < 512; i++) {
            if (i % 32 == 0) {
                w[count] = chuoi.substring(i, i + 32);
                count++;
            }
        }
        for (int i = 0; i < 16; i++) {
            if (i % 2 == 0) {
                System.out.print("\n");
            } else if (i % 2 == 1) {
                System.out.print("\t");
            }
            System.out.print("word: " + i + " " + w[i]);
        }
        System.out.println("\n");
    }

    public void inChuoiCoTratTu(String chuoi, int length, String name) {
        System.out.println(name);
        for (int i = 0; i < length; i++) {
            if (i % 8 == 0) {
                System.out.print("\t");
            }
            if (i % 64 == 0) {
                System.out.print("\n");
            }
            System.out.print(chuoi.charAt(i));
        }
        System.out.println("\n");
    }

    public String them64BitVaoChuoi448Bit(String chuoi448bit, String chuoi8bit) {
        String chuoi512bit = "";
        String chuoi64bitcuoi = "";
        for (int i = 448; i < 512; i++) {
            {
                if (i >= 504) {
                    chuoi64bitcuoi += String.valueOf(chuoi8bit.charAt(i - 504));
                } else {
                    chuoi64bitcuoi += "0";
                }
            }
        }
        System.out.println("chuoi 64 bit cuoi: " + chuoi64bitcuoi);
        chuoi512bit = chuoi448bit + chuoi64bitcuoi;
        return chuoi512bit;
    }

    public String chuoiKhiThemBit0DeTroThanh448bit(String chuoithem1bit) {
        for (int i = 0; i < 448; i++) {
            if (i >= chuoithem1bit.length()) {
                chuoithem1bit += "0";
            }
        }
        return chuoithem1bit;
    }

    public String chuoiNhiPhanSauKhiThemBit1VaoCuoi(String chuoidauvaonhiphan) {
        int n = chuoidauvaonhiphan.length();
        for (int i = 0; i <= n; i++) {
            if (i == n) {
                chuoidauvaonhiphan += "1";//Thêm 1 vào nhóm bit sau nhóm có ký tự cuối
            }
        }
        return chuoidauvaonhiphan;
    }

    public String chuoiDem64Bit(String chuoidauvaonhiphan) {
        int length = chuoidauvaonhiphan.length();
        String temp = ketQuaChuyenDecimaSangBinary(length);
        return "00000000000000000000000000000000" + temp.substring(0, 32);
    }

    public void Run(String thongdiepdauvao, String[] w) {

        System.out.println("Thông điệp đầu vào: " + thongdiepdauvao);
        //Chuyển chuỗi đầu vào sang nhị phân
        String chuoidauvaonhiphan = chuoiVanBanSangNhiPhan(thongdiepdauvao);
        inChuoiCoTratTu(chuoidauvaonhiphan, chuoidauvaonhiphan.length(), "CHUỖI ĐẦU VÀO NHỊ PHÂN");

        //Thêm bit 1 vào đoạn cuối dữ liệu gốc
        String chuoithembit1 = chuoiNhiPhanSauKhiThemBit1VaoCuoi(chuoidauvaonhiphan);

        inChuoiCoTratTu(chuoithembit1, chuoithembit1.length(), "CHUỖI NHỊ PHÂN ĐẦU VÀO THÊM 1 BIT");

        //Mở rộng thành chuối nhỏ nhất mà chia 
        String chuoi448bit = chuoiKhiThemBit0DeTroThanh448bit(chuoithembit1);
        inChuoiCoTratTu(chuoi448bit, 448, "CHUỖI 448 bit");

        String chuoidem64bit = chuoiDem64Bit(chuoidauvaonhiphan);
        inChuoiCoTratTu(chuoidem64bit, 64, "CHUỖI ĐỆM 64 BIT");

        String chuoi512bit = chuoi448bit + chuoidem64bit;
        inChuoiCoTratTu(chuoi512bit, 512, "CHUỖI 512 BIT");

        gomNhom16TuVaLuuVaoW(chuoi512bit, w);

        chenThem48TuSau16Tu(w);

        xemKQWord(w, "64 WORD SAU KHI ĐƯỢC CHÈN THÊM 48 WORD VÀO MẢNG 16 WORD", 64);

    }

    public String chuoiVanBanSangNhiPhan(String chuoidauvao) {
        byte[] bytes = chuoidauvao.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes) {
            int val = b;
            for (int i = 0; i < 8; i++) {
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
        }
        return String.valueOf(binary);
    }
    /* public static void main(String[] args) {
        SHA_256_XuLyChuoiDauVao ckd=new SHA_256_XuLyChuoiDauVao();
        //hello world
 //ckd.Run("0110100001100101011011000110110001101111001000000111011101101111011100100110110001100100");
        //Hello KMA
        String[] w=new String[64];
     ckd.Run("010010000110010101101100011011000110111100100000010010110100110101000001",w);
     for(int i=0;i<64;i++)
       {
           System.out.println("-"+w[i]);
       }
    }*/
}
