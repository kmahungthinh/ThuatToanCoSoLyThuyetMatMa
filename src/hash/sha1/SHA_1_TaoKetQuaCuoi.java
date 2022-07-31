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
public class SHA_1_TaoKetQuaCuoi extends Cal {

    public void Run(SHA_1_SuaDoiGiaTriH sdgth, String chuoidauvao) {
        /*   int hh=leftShift(sdgth.h0, 128)| (leftShift(sdgth.h1, 96)) | 
        (leftShift(sdgth.h2, 64)) | (leftShift(sdgth.h3, 32)) | sdgth.h4;*/
        String temp1 = ketQuaChuyenDecimaSangBinary(leftShift(sdgth.h0, 128));
        String temp2 = ketQuaChuyenDecimaSangBinary(leftShift(sdgth.h1, 96));
        String temp3 = ketQuaChuyenDecimaSangBinary(leftShift(sdgth.h2, 64));
        String temp4 = ketQuaChuyenDecimaSangBinary(leftShift(sdgth.h3, 32));
        String temp5 = ketQuaChuyenDecimaSangBinary(leftShift(sdgth.h4, 0));

        String chuoi160bit = temp1 + temp2 + temp3 + temp4 + temp5;
        System.out.println("Giá trị băm sha1(160-bit): ");
        for (int i = 0; i < 160; i++) {

            System.out.print(chuoi160bit.charAt(i));
            if (i % 100 == 0 && i != 0) {
                System.out.println();
            }

        }
        System.out.println("\nGiá trị băm sha1(hex) của text " + chuoidauvao + " là: " + BinToHex(chuoi160bit));
    }

}
