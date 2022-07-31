/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash.sha1;

import hash.sha1.*;
import hash.sha256.Cal;

/**
 *
 * @author Admin
 */
public class SHA1_TinhToanThongDiep extends Cal {

    public void w(String[] w, int i) {
        int wi_3 = ketQuaChuyenBinarySangDecima(w[i - 3]);
        int wi_8 = ketQuaChuyenBinarySangDecima(w[i - 8]);
        int wi_14 = ketQuaChuyenBinarySangDecima(w[i - 14]);
        int wi_16 = ketQuaChuyenBinarySangDecima(w[i - 16]);
        int kqwxor = (wi_3 ^ wi_8 ^ wi_14 ^ wi_16);
        int kqxoaytrai = leftRotate(kqwxor, 1);
        w[i] = ketQuaChuyenDecimaSangBinary(kqxoaytrai);
    }

    public void Run(String[] w) {
        for (int i = 16; i < 80; i++) {
            w(w, i);
        }
        xemKQWord(w, "80 WORD SAU KHI TÍNH TOÁN HẾT VÒNG LẶP THÔNG ĐIỆP", 80);
    }

}
