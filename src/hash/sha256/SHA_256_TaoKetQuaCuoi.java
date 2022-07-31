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
public class SHA_256_TaoKetQuaCuoi extends Cal{
    public void Run(SHA_256_SuaDoiGiaTriH sdgth,String chuoidauvao)
    {
        String chuoi256bit="";
 chuoi256bit+=ketQuaChuyenDecimaSangBinary(sdgth.h0);
chuoi256bit+=ketQuaChuyenDecimaSangBinary(sdgth.h1);
 chuoi256bit+=ketQuaChuyenDecimaSangBinary(sdgth.h2);
chuoi256bit+=ketQuaChuyenDecimaSangBinary(sdgth.h3);
chuoi256bit+=ketQuaChuyenDecimaSangBinary(sdgth.h4);
chuoi256bit+=ketQuaChuyenDecimaSangBinary(sdgth.h5);
  chuoi256bit+=ketQuaChuyenDecimaSangBinary(sdgth.h6);
 chuoi256bit+=ketQuaChuyenDecimaSangBinary(sdgth.h7);
 System.out.println("Giá trị băm sha256(bit): ");
 for(int i=0;i<256;i++)
 {
     
        System.out.print(chuoi256bit.charAt(i));
        if(i%100==0&&i!=0) System.out.println();
        
 }
       System.out.println("\nGiá trị băm sha256(hex) của text "+chuoidauvao+" là: "+BinToHex(chuoi256bit));
    }
    
}
