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
public class SHA_1_SuaDoiGiaTriH extends Cal {

    int h0, h1, h2, h3, h4, h5, h6, h7;

    public void Run(SHA_1_Nen nen) {
        String chuoi256bit = "";
        System.out.print("h0 = h0 + a =" + hexToBin(giaTriBamHSHA_1(0)) + " + "
                + ketQuaChuyenDecimaSangBinary(nen.a));
        h0 = hextoDecima(giaTriBamHSHA_1(0)) + nen.a;
        String h0bina = ketQuaChuyenDecimaSangBinary(h0);
        System.out.println(" =>h0 = " + h0bina);

        System.out.print("h1 = h1 + b =" + hexToBin(giaTriBamHSHA_1(1)) + " + "
                + ketQuaChuyenDecimaSangBinary(nen.b));
        h1 = hextoDecima(giaTriBamHSHA_1(1)) + nen.b;
        String h1bina = ketQuaChuyenDecimaSangBinary(h1);
        System.out.println(" =>h1 = " + h1bina);

        System.out.print("h2 = h2 + c =" + hexToBin(giaTriBamHSHA_1(2)) + " + "
                + ketQuaChuyenDecimaSangBinary(nen.c));
        h2 = hextoDecima(giaTriBamHSHA_1(2)) + nen.c;
        String h2bina = ketQuaChuyenDecimaSangBinary(h2);
        System.out.println(" =>h2 = " + h2bina);

        System.out.print("h3 = h3 + d =" + hexToBin(giaTriBamHSHA_1(3)) + " + "
                + ketQuaChuyenDecimaSangBinary(nen.d));
        h3 = hextoDecima(giaTriBamHSHA_1(3)) + nen.d;
        String h3bina = ketQuaChuyenDecimaSangBinary(h3);
        System.out.println(" =>h3 = " + h3bina);

        System.out.print("h4 = h4 + e =" + hexToBin(giaTriBamHSHA_1(4)) + " + "
                + ketQuaChuyenDecimaSangBinary(nen.e));
        h4 = hextoDecima(giaTriBamHSHA_1(4)) + nen.e;
        String h4bina = ketQuaChuyenDecimaSangBinary(h4);
        System.out.println(" =>h4 = " + h4bina);

    }
}
