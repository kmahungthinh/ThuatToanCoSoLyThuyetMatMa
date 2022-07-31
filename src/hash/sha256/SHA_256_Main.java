package hash.sha256;

import java.util.Scanner;

public class SHA_256_Main {

    public static void main(String[] args) {

        String[] w = new String[64];
        Scanner sc = new Scanner(System.in);
        String chuoidauvao = "";
        System.out.println("Nhập chuỗi text đầu vào: ");
        chuoidauvao = sc.nextLine();
        System.out.println("========Bước 1: Xử lý chuỗi========");
        SHA_256_XuLyChuoiDauVao ckd = new SHA_256_XuLyChuoiDauVao();
        ckd.Run(chuoidauvao, w);

        System.out.println("\n\n========Bước 2: Tính toán thông điệp========");
        SHA_256_TinhToanThongDiep tttd = new SHA_256_TinhToanThongDiep();
        tttd.Run(w);

        System.out.println("\n\n========Bước 3: Nén bằng cách xử dụng vòng lặp chính========");
        SHA_256_Nen nen = new SHA_256_Nen();
        nen.Run(w);

        System.out.println("\n\n========Bước 4: Giá trị băm mới========");
        SHA_256_SuaDoiGiaTriH sdgth = new SHA_256_SuaDoiGiaTriH();
        sdgth.Run(nen);

        System.out.println("\n\n========Bước 5: Tạo kết quả cuối========");
        SHA_256_TaoKetQuaCuoi tkqc = new SHA_256_TaoKetQuaCuoi();
        tkqc.Run(sdgth, chuoidauvao);

    }
}
