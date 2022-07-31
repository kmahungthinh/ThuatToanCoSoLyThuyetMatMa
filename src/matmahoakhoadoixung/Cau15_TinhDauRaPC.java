/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matmahoakhoadoixung;

/**
 *
 * @author User
 */
public class Cau15_TinhDauRaPC {

    int P[] = {
        16, 7, 20, 21,
        29, 12, 28, 17,
        1, 15, 23, 26,
        5, 18, 31, 10,
        2, 8, 24, 14,
        32, 27, 3, 9,
        19, 13, 30, 6,
        22, 11, 4, 25};
    //Đầu vào nhập fix cứng tại đây
    int C[] = {
        1, 0, 0, 1,
        0, 1, 1, 1,
        1, 1, 1, 0,
        1, 1, 0, 0,
        1, 0, 0, 1,
        0, 1, 1, 1,
        0, 1, 0, 1,
        0, 1, 1, 0
    };

    int giaTriPCuaViTriLienQuan[] = 
    {
        12, 28, 31, 10, 2, 30, 6
    };
    int soLuongBit = 7;
    int viTriLienQuan[] = new int[100];
    int PC[] = new int[100];

    public void bangKetQuaPC() {
        int count = 0;
        System.out.println("Bảng kết quả P(C)");
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 4; j++) {
                System.out.print("\t" + PC[count]);
                count++;
            }
            System.out.println();
        }
    }

    public void ketQuaChuoiBitCanLay() {
        System.out.println("\nCác bit tại vị trí còn thiếu \n");
        for (int i = 0; i < soLuongBit; i++) {
            System.out.print("\t"+PC[viTriLienQuan[i]]);
        }
        System.out.println("\n");
    }

    public void layViTriLienQuan() {
        System.out.println("Các vị trí liên quan tới chuỗi bit là\n");
        int count = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < soLuongBit; j++) {
                if (P[i] == giaTriPCuaViTriLienQuan[j]) {
                    viTriLienQuan[count] = i;
                    count++;
                    System.out.print("\t" + i);
                }
            }
            //System.out.println();
        }
    }

    public void hoanVi() {
        for (int i = 0; i < 32; i++) {
            PC[i] = C[P[i]-1];
        }
    }

    public static void main(String[] args) {
        Cau15_TinhDauRaPC ctdrpc = new Cau15_TinhDauRaPC();
        ctdrpc.hoanVi();
        ctdrpc.bangKetQuaPC();
        ctdrpc.layViTriLienQuan();
        ctdrpc.ketQuaChuoiBitCanLay();
    }

}
