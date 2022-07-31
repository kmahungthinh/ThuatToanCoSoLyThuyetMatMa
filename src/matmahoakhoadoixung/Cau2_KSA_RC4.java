/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matmahoakhoadoixung;

import java.util.Random;

/**
 *
 * @author User
 */
public class Cau2_KSA_RC4 {

    int SoPhanTu;

    void Run() {
        int i;
        SoPhanTu = 256;
        int S[] = new int[300];
        int T[] = new int[300];
        //Thay tại đây
        T[0] = 13;
        T[1] = 27;
        for (i = 0; i < 256; i++) {
            if (i == 0 || i == 1) {
                continue;
            }
            T[i] = 0;
        }
        for (i = 0; i < SoPhanTu; i++) {
            S[i] = i;
        }

        int j = 0, temp = 0;
        //Xét vòng lặp thứ 1 nên chọn i<1
        for (i = 0; i < 1; i++) {
            j = (j + S[i] + T[i]) % SoPhanTu;
            temp = S[i];
            S[i] = S[j];
            S[j] = temp;
        }
        for (i = 0; i < SoPhanTu; i++) {
            System.out.println(i + ": " + S[i]);
        }
    }

    public static void main(String[] args) {
        Cau2_KSA_RC4 kr = new Cau2_KSA_RC4();
        kr.Run();
    }

}
