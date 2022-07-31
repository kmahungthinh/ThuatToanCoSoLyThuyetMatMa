/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash.sha256;

/**
 *
 * @author Ad_h_hexe_h_hexexxmin
 */
public class SHA_256_Nen extends Cal {

    String a_hex = "6a09e667";
    String b_hex = "bb67ae85";
    String c_hex = "3c6ef372";
    String d_hex = "a54ff53a";
    String e_hex = "510e527f";
    String f_hex = "9b05688c";
    String g_hex = "1f83d9ab";
    String h_hex = "5be0cd19";
    int a, b, c, d, e, f, g, h;

    public int s0() {
        // (a_hex rightrotate 2) xor (a_hex rightrotate 13) xor (a_hex rightrotate 22)
        int s0 = 0;
        int temp1s0 = rightRotate(ketQuaChuyenDecimaSangBinary(a), 2);
        int temp2s0 = rightRotate(ketQuaChuyenDecimaSangBinary(a), 13);
        int temp3s0 = rightRotate(ketQuaChuyenDecimaSangBinary(a), 22);
        s0 = temp1s0 ^ temp2s0 ^ temp3s0;
        //       System.out.println("s0: "+s0);
        return s0;
    }

    public int s1() {

        int s1 = 0;
        int temp1s1 = rightRotate(ketQuaChuyenDecimaSangBinary(e), 6);
        int temp2s1 = rightRotate(ketQuaChuyenDecimaSangBinary(e), 11);
        int temp3s1 = rightRotate(ketQuaChuyenDecimaSangBinary(e), 25);
        s1 = temp1s1 ^ temp2s1 ^ temp3s1;
        //    System.out.println("s1: "+s1);
        return s1;
    }

    public int ch() {
        int ch = 0;

        ch = (e & f) ^ ((~e) & g);
        //    System.out.println("ch: "+ch);
        return ch;
    }

    public int maj() {
        int maj = 0;

        maj = (a & b) ^ (a & c) ^ (b & c);
        //  System.out.println("maj: "+maj);
        return maj;
    }

    public int temp2() {
        int temp2 = maj() + s0();
        //System.out.println("temp2: "+temp2);
        return temp2;
    }

    public int temp1(int i, String[] w) {
        //temp1 = h_hex + S1 + ch + k[i] + w[i]

        String[] k = new String[1000];
        k[i] = hangSoKthu(i);

        int temp1 = h + s1() + ch() + ketQuaChuyenBinarySangDecima(w[i]) + hextoDecima(k[i]);
        //System.out.println("temp1: "+temp1);
        return temp1;
    }

    public void cal(int i, String w[]) {
        //gán lần đầu cho d

        //start
        int s1 = s1();
        int ch = ch();

        int temp1 = temp1(i, w);
        int s0 = s0();
        int maj = maj();
        int temp2 = temp2();

        h = g;
        g = f;
        f = e;
        e = d + temp1;
        d = c;
        c = b;
        b = a;
        a = temp1 + temp2;

    }

    public void Run(String[] w) {
        a = hextoDecima(a_hex);
        b = hextoDecima(b_hex);
        c = hextoDecima(c_hex);
        d = hextoDecima(d_hex);
        e = hextoDecima(e_hex);
        f = hextoDecima(f_hex);
        g = hextoDecima(g_hex);
        h = hextoDecima(h_hex);

        for (int i = 0; i < 64; i++) {
            cal(i, w);
        }
        System.out.println("Giá trị a-h cuối");
        System.out.println("a: " + ketQuaChuyenDecimaSangBinary(a));
        System.out.println("b: " + ketQuaChuyenDecimaSangBinary(b));
        System.out.println("c: " + ketQuaChuyenDecimaSangBinary(c));
        System.out.println("d: " + ketQuaChuyenDecimaSangBinary(d));
        System.out.println("e: " + ketQuaChuyenDecimaSangBinary(e));
        System.out.println("f: " + ketQuaChuyenDecimaSangBinary(f));
        System.out.println("g: " + ketQuaChuyenDecimaSangBinary(g));
        System.out.println("h: " + ketQuaChuyenDecimaSangBinary(h));
    }

    public static void main(String[] args) {
        SHA_256_Nen ttn = new SHA_256_Nen();
        /* ttn.s0();
        ttn.s1();
        ttn.ch();
        ttn.maj();
        ttn.temp2();
        ttn.temp1(0);*/
        //ttn.cal(0);
    }

}
