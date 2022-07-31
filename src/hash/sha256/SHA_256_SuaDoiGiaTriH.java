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
public class SHA_256_SuaDoiGiaTriH extends Cal{
   int h0,h1,h2,h3,h4,h5,h6,h7;
    public void Run(SHA_256_Nen nen)
    {
        String chuoi256bit="";
        System.out.print("h0 = h0 + a ="+hexToBin(giaTriBamHThu(0))+" + "
              +ketQuaChuyenDecimaSangBinary(nen.c));
       h0=hextoDecima(giaTriBamHThu(0))+nen.a;
        String h0bina=ketQuaChuyenDecimaSangBinary(h0);
        System.out.println(" =>h0 = "+h0bina);
       
        System.out.print("h1 = h1 + b ="+hexToBin(giaTriBamHThu(1))+" + "
              +ketQuaChuyenDecimaSangBinary(nen.b));
        h1=hextoDecima(giaTriBamHThu(1))+nen.b;
        String h1bina=ketQuaChuyenDecimaSangBinary(h1);
        System.out.println(" =>h1 = "+h1bina);
        
        
         System.out.print("h2 = h2 + c ="+hexToBin(giaTriBamHThu(2))+" + "
              +ketQuaChuyenDecimaSangBinary(nen.c));
        h2=hextoDecima(giaTriBamHThu(2))+nen.c;
        String h2bina=ketQuaChuyenDecimaSangBinary(h2);
        System.out.println(" =>h2 = "+h2bina);
       
      System.out.print("h3 = h3 + d ="+hexToBin(giaTriBamHThu(3))+" + "
              +ketQuaChuyenDecimaSangBinary(nen.d));
       h3=hextoDecima(giaTriBamHThu(3))+nen.d;
        String h3bina=ketQuaChuyenDecimaSangBinary(h3);
        System.out.println(" =>h3 = "+h3bina);
        
         System.out.print("h4 = h4 + e ="+hexToBin(giaTriBamHThu(4))+" + "
              +ketQuaChuyenDecimaSangBinary(nen.e));
       h4=hextoDecima(giaTriBamHThu(4))+nen.e;
        String h4bina=ketQuaChuyenDecimaSangBinary(h4);
        System.out.println(" =>h4 = "+h4bina);
        
        System.out.print("h5 = h5 + f ="+hexToBin(giaTriBamHThu(5))+" + "
              +ketQuaChuyenDecimaSangBinary(nen.f));
         h5=hextoDecima(giaTriBamHThu(5))+nen.f;
        String h5bina=ketQuaChuyenDecimaSangBinary(h5);
        System.out.println(" =>h5 = "+h5bina);
        
         System.out.print("h6 = h6 + g ="+hexToBin(giaTriBamHThu(6))+" + "
              +ketQuaChuyenDecimaSangBinary(nen.g));
       h6=hextoDecima(giaTriBamHThu(6))+nen.g;
        String h6bina=ketQuaChuyenDecimaSangBinary(h6);
        System.out.println(" =>h6 = "+h6bina);
      
         System.out.print("h7 = h7 + g ="+hexToBin(giaTriBamHThu(7))+" + "
              +ketQuaChuyenDecimaSangBinary(nen.h));
       h7=hextoDecima(giaTriBamHThu(7))+nen.h;
        String h7bina=ketQuaChuyenDecimaSangBinary(h7);
        System.out.println(" =>h7 = "+h7bina);
        
        
        
    }
    
}
