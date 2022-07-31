/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matmahoakhoacongkhai;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Cau26_yAyB_Rabin_MaHoa {

    public int p, q, n, m, c;
    Scanner sc = new Scanner(System.in);
/*
    Đề
    p=199 q=211 m=1234
 */
    public void Nhap() {
        System.out.println("Nhập p: ");
        p = sc.nextInt();
        System.out.println("Nhập q: ");
        q = sc.nextInt();
        System.out.println("Nhập thông điệp: ");
        m = sc.nextInt();
        n = q * p;
    }

    public void maHoa() {
        if (m < (n - 1) && m > 0) {
            System.out.println("Thông điệp m thỏa mãn thuộc [0," + (n - 1) + "]");
        } else {
            System.out.println("Không thỏa mãn"); return;
        }
        c=(int) (Math.pow(m, 2))% n;
        System.out.println("Bản mã c = "+c);
    }

    public static void main(String[] args) {
        Cau26_yAyB_Rabin_MaHoa chmr = new Cau26_yAyB_Rabin_MaHoa();
        chmr.Nhap();
        chmr.maHoa();
    }
}
