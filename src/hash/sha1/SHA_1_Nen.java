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
public class SHA_1_Nen extends Cal {

    String a_hex = "67452301";
    String b_hex = "efcdab89";
    String c_hex = "98badcfe";
    String d_hex = "10325476";
    String e_hex = "c3d2e1f0";
    int a, b, c, d, e, f, k;

    public void Run(String[] w) {
        a = hextoDecima(a_hex);
        b = hextoDecima(b_hex);
        c = hextoDecima(c_hex);
        d = hextoDecima(d_hex);
        e = hextoDecima(e_hex);
        for (int i = 0; i < 80; i++) {
            if (i >= 0 && i < 20) {
                f = (b & c) | ((~b) & d);
                k = hextoDecima("5a827999");
            } else if (i >= 20 && i < 40) {
                f = b ^ c ^ d;
                k = hextoDecima("6ed9eba1");
            } else if (i >= 40 && i < 60) {
                f = (b & c) | (b & d) | (c & d);
                k = hextoDecima("8f1bbcdc");
            } else if (i >= 60 && i < 80) {
                f = (b ^ c ^ d);
                k = hextoDecima("ca62c1d6");
            }
            int temp = (leftRotate(a, 5)) + f + e + k + ketQuaChuyenBinarySangDecima(w[i]);
            e = d;
            d = c;
            c = leftRotate(b, 30);
            b = a;
            a = temp;
        }
        System.out.println("Giá trị a-e cuối");
        System.out.println("a: " + ketQuaChuyenDecimaSangBinary(a));
        System.out.println("b: " + ketQuaChuyenDecimaSangBinary(b));
        System.out.println("c: " + ketQuaChuyenDecimaSangBinary(c));
        System.out.println("d: " + ketQuaChuyenDecimaSangBinary(d));
        System.out.println("e: " + ketQuaChuyenDecimaSangBinary(e));
    }

}
