/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash.sha1;

import hash.sha1.*;
import hash.sha256.SHA_256_XuLyChuoiDauVao;

/**
 *
 * @author Admin
 */
public class SHA_1_XuLyChuoiDauVao extends SHA_256_XuLyChuoiDauVao {

    public void chenThem64TuSau16Tu(String[] w) {
        for (int i = 16; i <= 79; i++) {
            w[i] = "";
            for (int j = 0; j < 32; j++) {
                w[i] += "0";
            }
        }
    }

    @Override
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

        chenThem64TuSau16Tu(w);

        xemKQWord(w, "80 WORD SAU KHI ĐƯỢC CHÈN THÊM 64 WORD VÀO MẢNG 16 WORD", 80);

    }
}
