/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matmahoakhoadoixung;

import coban.General;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Cau10_DauRaS1Box extends General {

    int S1[] = {14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7,
        0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8,
        4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0,
        15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13};
    String B1;
    int hang, cot, viTriPhanTuBit;
    String bitHang, bitCot;

    public void Tinh() {
        bitHang = String.valueOf(B1.charAt(0)) + String.valueOf(B1.charAt(5));
        for (int i = 1; i <= 4; i++) {
            bitCot += String.valueOf(B1.charAt(i));
        }
        System.out.println("Bit hàng: " + bitHang);
        System.out.println("B1it cột: " + bitCot);
        if (bitHang.equals("00")) {
            hang = 1;
        } else if (bitHang.equals("01")) {
            hang = 2;
        } else if (bitHang.equals("10")) {
            hang = 3;
        } else if (bitHang.equals("11")) {
            hang = 4;
        }
        cot = ketQuaChuyenBinarySangDecima("0000" + bitCot);
        System.out.println("h: " + hang);
        System.out.println("c: " + cot);
        viTriPhanTuBit = (hang - 1) * 16 + cot;
        System.out.println("vi tri bit: " + viTriPhanTuBit);
        System.out.println("Giá trị nguyên S1(B1): " + S1[viTriPhanTuBit]);
        System.out.println("\n\n=>Kết quả bit đầu ra S1(B1) "
                + ketQuaChuyenDecimaSangBinary(S1[viTriPhanTuBit], 4));
    }

    /*
    Video https://www.youtube.com/watch?v=B7PSAeb7jL0&t=1747s 30:37
    101110=>1011=11
    Video https://www.youtube.com/watch?v=sLIkHz7ztfI&t=875s 15:00
    011000=>0101=5
    Đề
    B1 (6 ký tự nhị phân): 110101
    Kết quả S1(B1 4 ký tự nhị phân) đúng: 0011 
    */
    public void Nhap() {
        bitHang = "";
        bitCot = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập B1 =");
        B1 = sc.nextLine();

    }

    public static void main(String[] args) {
        Cau10_DauRaS1Box cdrsb = new Cau10_DauRaS1Box();
        cdrsb.Nhap();
        cdrsb.Tinh();
    }
}
