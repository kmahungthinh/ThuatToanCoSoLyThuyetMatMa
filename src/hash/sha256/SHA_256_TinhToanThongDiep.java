/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash.sha256;

/**
 *
 * @author Admin
 */
public class SHA_256_TinhToanThongDiep extends Cal {

    public int s0(String[] w, int i) {
        int s0 = rightRotate(w[i - 15], 7) ^ rightRotate(w[i - 15], 18) ^ RightShift(w[i - 15], 3);
        //System.out.println("s0: "+s0);
        return s0;
    }

    public int s1(String[] w, int i) {
        int s1 = rightRotate(w[i - 2], 17) ^ rightRotate(w[i - 2], 19) ^ RightShift(w[i - 2], 10);
        //System.out.println("s1: "+s1);
        return s1;
    }

    public String w(String[] w, int i) {
        int s0 = s0(w, i);
        int s1 = s1(w, i);
        int wiDecima = ketQuaChuyenBinarySangDecima(w[i - 16]) + s0
                + ketQuaChuyenBinarySangDecima(w[i - 7]) + s1;
        //System.out.println("D: "+wiDecima);
        w[i] = ketQuaChuyenDecimaSangBinary(wiDecima);
        //System.out.println("KQ D->B: "+ketQuaChuyenDecimaSangBinary(wiDecima));
        return w[i];
    }

    public void Run(String[] w) {
        for (int i = 16; i < 64; i++) {
            w(w, i);
        }
        xemKQWord(w, "64 WORD SAU KHI TÍNH TOÁN HẾT VÒNG LẶP THÔNG ĐIỆP", 64);
    }

    public static void main(String[] args) {
        SHA_256_TinhToanThongDiep tttd = new SHA_256_TinhToanThongDiep();
        String[] w = new String[50];
        //Tính toán thông điệp 16
        w[0] = "01001000011001010110110001101100";
        w[1] = "01101111001000000100101101001101";
        w[9] = "00000000000000000000000000000000";
        w[14] = "00000000000000000000000000000000";

        tttd.w(w, 16);

    }
}
