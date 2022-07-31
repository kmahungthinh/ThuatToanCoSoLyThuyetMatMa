/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coban;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Cau28_PhanTuSinh extends General {

    int n;
    int p, k,count;
    int[] pTs = new int[1000];
    int[] i_PtS = new int[1000];
    Cau31_GiaTriHamEuler cgthe = new Cau31_GiaTriHamEuler();
    NhanBinhPhuongCoLap nbpcl = new NhanBinhPhuongCoLap();

    public boolean coDangpLuyThuak(int n) {
        for (int i = 1; i <= n; i++) {
            p = (int) ((float) Math.pow(n, 1. * 1 / i));
            if (laSoNguyenTo(p) == true && Math.pow(p, i) == n) {
                k = i;
                return true;
            }
        }
        return false;
    }

    public boolean coDang2NhanpLuyThuak(int n) {
        
        int temp = n / 2;
        if (coDangpLuyThuak(temp) == true) {
            return true;
        }
        return false;
    }

    public boolean kiemTraLaPhanTuSinh() {
        if (n == 2) {
            System.out.println("Z(2) có là phần tử sinh");
        } else if (n == 4) {
            System.out.println("Z(4) có là phần tử sinh");
        } else if (laSoNguyenTo(n) == true) {
            System.out.println("Z(" + n + ") có là phần tử sinh vì là số nguyên tố");
            cgthe.timCacThuaSoNguyenTo(n - 1);
            cgthe.timSoMuCuaThuaSoNguyenTo();
            cgthe.ketQuaPhanTichThuaSoNguyenTo();
        } else if (coDangpLuyThuak(n) == true) {
            System.out.println("Z(" + n + ") có là phần tử sinh vì có dạng " + p + "^" + k);
        } else if (coDang2NhanpLuyThuak(n) == true) {
            cgthe.timCacThuaSoNguyenTo(n );
            cgthe.timSoMuCuaThuaSoNguyenTo();
            cgthe.ketQuaPhanTichThuaSoNguyenTo();
            System.out.println("Z(" + n + ") có là phần tử sinh vì có dạng 2*" + p + "^" + k);
        } else {
            System.out.println("Z(" + n + ") không là phần tử sinh");
            return false;
        }
        return true;
    }

    public void sortASC(int[] arr, int count) {
        int temp = arr[1];
        for (int i = 1; i <= count - 1; i++) {
            for (int j = i + 1; j <= count; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public void timPhanTuSinhConLai() {

        System.out.println("Để GCD (i,pi(" + n + "))=1 thì i thuộc Z(" + (n - 1) + ")");
        for (int i = 1; i <= n - 1; i++) {
            if (gcd(i, n - 1) == 1) {
                count++;
                i_PtS[count] = i;
                nbpcl.Nhap(pTs[1], i, n);
                nbpcl.Tinh();
                pTs[count] = nbpcl.b[nbpcl.length - 1];
                System.out.println(i_PtS[count] + "=>" + pTs[1] + "^"
                        + i_PtS[count] + " mod " + n + " =" + pTs[count]);

            }
        }
        sortASC(pTs, count);
        System.out.println("Vậy kết quả nhóm phần tử sinh của Z(" + n + ") là: ");
        
        for (int i = 1; i <= count; i++) {
            System.out.print(pTs[i] + "\t");
        }
        System.out.println("Số lượng phần tử sinh trong nhóm "+p+" là = "+count);
    }

    public void timPhanTuSinhDauTien() {
        int temp;

        boolean TM = false;
        System.out.println("Cần tìm phần tử sinh sao cho: ");
        for (int i = 1; i <= cgthe.countSNT; i++) {
            System.out.println("x^(pi(" + n + ")/" + cgthe.A[i] + ") mod " + n + "!=1");

        }
        for (int j = 2; j < n; j++) {
            System.out.println("Xét x =" + pTs[j]);
            TM = true;
            for (int i = 1; i <= cgthe.countSNT; i++) {
                System.out.println(j + "^(pi(" + n + ")/" + cgthe.A[i] + ") mod " + n + "!=1");
                temp = (int) (Math.pow(j, (n - 1) / cgthe.A[i]) % n);
                if (temp != 1) {
                    System.out.println("Thấy " + temp + "!=" + 1 + "=> Thỏa mãn");
                } else {
                    TM = false;
                    break;
                }
            }
            if (TM == true) {
                System.out.println("Đã tìm đc pt sinh đầu tiên " + j);
                pTs[1] = j;
                break;
            }
        }

    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập n = ");
        n = sc.nextInt();
    }

    public static void main(String[] args) {
        Cau28_PhanTuSinh cpts = new Cau28_PhanTuSinh();
        cpts.Nhap();
        if (cpts.kiemTraLaPhanTuSinh() == true) {
            cpts.coDangpLuyThuak(cpts.n);
            cpts.timPhanTuSinhDauTien();
            cpts.timPhanTuSinhConLai();
        }

    }

}
