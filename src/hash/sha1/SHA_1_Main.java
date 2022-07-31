package hash.sha1;

import hash.sha1.*;
import java.util.Scanner;

public class SHA_1_Main {

    public static void main(String[] args) {

        String[] w = new String[80];
        Scanner sc = new Scanner(System.in);
        String chuoidauvao;
        System.out.println("Nhập chuỗi text đầu vào: ");
        chuoidauvao = sc.nextLine();
        System.out.println("========Bước 1: Xử lý chuỗi========");
        SHA_1_XuLyChuoiDauVao ckd = new SHA_1_XuLyChuoiDauVao();
        ckd.Run(chuoidauvao, w);
        System.out.println("========Bước 2: Tính toán thông điệp========");
        SHA1_TinhToanThongDiep tttd = new SHA1_TinhToanThongDiep();
        tttd.Run(w);
        System.out.println("\n\n========Bước 3: Nén bằng cách xử dụng vòng lặp chính========");
        SHA_1_Nen nen = new SHA_1_Nen();
        nen.Run(w);
        System.out.println("\n\n========Bước 4: Giá trị băm mới========");
        SHA_1_SuaDoiGiaTriH sdgth = new SHA_1_SuaDoiGiaTriH();
        sdgth.Run(nen);
        System.out.println("\n\n========Bước 5: Tạo kết quả cuối========");
        SHA_1_TaoKetQuaCuoi tkqc = new SHA_1_TaoKetQuaCuoi();
        tkqc.Run(sdgth, chuoidauvao);
    }
}
