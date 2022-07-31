/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matmahoakhoadoixung;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Cau24_Hill {

    public int chuThanhSo(String chu) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int i;
        for (i = 0; i < alphabet.length(); i++) {
            if (chu.equals(String.valueOf(alphabet.charAt(i)))) {
                break;
            }
        }
        return i;
    }

    public String soThanhChu(int t) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return String.valueOf(alphabet.charAt(t));
    }
    String thongDiepMaHoa;
    int capMatran;
    int hang;
    String[][] ThongDiepDauVaoChu = new String[200][200];
    int[][] ThongDiepDauVaoSo = new int[200][200];
    int[][] ThongDiepMaHoaSo = new int[200][200];
    String[][] ThongDiepMaHoaChu = new String[200][200];
    String banMaThongDiep;
    int[][] K = new int[200][200];

    public void maHoa() {
        System.out.println("Dựa vào độ dài bản rõ ta chọn ma trận K cỡ " + hang + "x" + capMatran + " "
                + "=> m=" + capMatran + ", bản rõ sẽ được chia thành các" + hang + " phần tử mỗi phần tử chứa "
                + capMatran + " ký tự ");

        int count = 0;
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < capMatran; j++) {
                ThongDiepDauVaoChu[i][j] = String.valueOf(thongDiepMaHoa.charAt(count));
                count++;
            }

        }
        System.out.println("Bản rõ được biểu diễn bằng ma trận chữ sau");
        inMaTranChu(ThongDiepDauVaoChu, hang, capMatran);
        System.out.println("Bản rõ được biểu diễn bằng ma trận số sau");
        inMaTranChuyenTuChuThanhSo(ThongDiepDauVaoChu, hang, capMatran);
        System.out.println("Nhập khóa K");
        nhapMaTranKhoaK();
        System.out.println("Kết quả mã hóa (tích ma trận rõ và khóa)");
        tich2MaTran(ThongDiepDauVaoSo, K, ThongDiepMaHoaSo, hang, capMatran);
        inMaTranSo(ThongDiepMaHoaSo, hang, capMatran);
        System.out.println("Kết quả mã hóa cuối (rút gọn module)");
        ketQuaRutGonModule(ThongDiepMaHoaSo, hang, capMatran);
        inMaTranSo(ThongDiepMaHoaSo, hang, capMatran);
        System.out.println("Ma trận thông điệp sau mã hóa");
        inMaTranChuyenTuSoThanhChu(ThongDiepMaHoaSo, hang, capMatran);
        System.out.println("Bản mã thông điệp " + banMaThongDiep);

    }

    public void giaiMa() {

    }

    /*
    Đề
    Ma trận vuông cấp: 2
    Bản rõ: FRIDAY
    Tìm khóa để có bản mã ADDHOM
    Thử khóa qua các đáp án
    K: 9 1 2 15
    K. 7 19 8 3
    K: 3 8 19 7 (đáp án đúng)
    K: 19 8 19 7
     */
    public void nhapMaHoa() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập cấp ma trận (m) = ");
        capMatran = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập vào thông điệp cần mã hóa");
        thongDiepMaHoa = scanner.nextLine();
        int length = thongDiepMaHoa.length();
        hang = (int) (length / capMatran);
        if (hang * capMatran == length) {
            System.out.println("MQH giữa độ dài và thông điệp thỏa mãn có thê mã hóa");
        } else {
            System.out.println("Không thể mã hóa");
            return;
        }

    }

    public void tich2MaTran(int A[][], int B[][], int C[][], int hang, int cot) {
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < capMatran; j++) {
                C[i][j] = 0;
                for (int k = 0; k < capMatran; k++) {
                    C[i][j] = C[i][j] + A[i][k] * B[k][j];
                }
            }
        }
    }

    public void ketQuaRutGonModule(int C[][], int hang, int cot) {
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < capMatran; j++) {
                C[i][j] = C[i][j] % 26;
            }
        }
    }

    public void nhapMaTranKhoaK() {
        // hiển thị 2 ma trận vừa nhập
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < capMatran; i++) {
            for (int j = 0; j < capMatran; j++) {
                System.out.print("A[" + i + "][" + j + "] = ");
                K[i][j] = scanner.nextInt();
            }
        }
    }

    public void inMaTranChu(String[][] MT, int hang, int cot) {
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < cot; j++) {
                System.out.print(MT[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    public void inMaTranSo(int[][] MT, int hang, int cot) {
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < cot; j++) {
                System.out.print(MT[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    public void inMaTranChuyenTuChuThanhSo(String[][] MT, int hang, int cot) {
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < cot; j++) {
                ThongDiepDauVaoSo[i][j] = chuThanhSo(MT[i][j]);
                System.out.print(ThongDiepDauVaoSo[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    public void inMaTranChuyenTuSoThanhChu(int[][] MT, int hang, int cot) {
        banMaThongDiep = "";
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < cot; j++) {
                ThongDiepMaHoaChu[i][j] = soThanhChu(MT[i][j]);
                banMaThongDiep += ThongDiepMaHoaChu[i][j];
                System.out.print(ThongDiepMaHoaChu[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        Cau24_Hill chmh = new Cau24_Hill();
        
        int chon;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n1)Mã hóa. \n2)Giải mã. \nBạn chọn: ");
        chon = sc.nextInt();
        if (chon == 1) {
            chmh.nhapMaHoa();
            chmh.maHoa();
        } else if (chon == 2) {
            chmh.giaiMa();
        }

    }
}
