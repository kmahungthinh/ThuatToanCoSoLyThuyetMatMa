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
public class Cal {
    static final int INT_BITS = 32;
    public String hangSoKthu(int i)
    {
  String k[]= 
  {"428a2f98","71374491","b5c0fbcf","e9b5dba5","3956c25b","59f111f1","923f82a4","ab1c5ed5",
"d807aa98","12835b01","243185be","550c7dc3","72be5d74","80deb1fe","9bdc06a7","c19bf174",
"e49b69c1","efbe4786","0fc19dc6","240ca1cc","2de92c6f","4a7484aa","5cb0a9dc","76f988da",
"983e5152","a831c66d","b00327c8","bf597fc7","c6e00bf3","d5a79147","06ca6351","14292967",
"27b70a85","2e1b2138","4d2c6dfc","53380d13","650a7354","766a0abb","81c2c92e","92722c85",
"a2bfe8a1","a81a664b","c24b8b70","c76c51a3","d192e819","d6990624","f40e3585","106aa070",
"19a4c116","1e376c08","2748774c","34b0bcb5","391c0cb3","4ed8aa4a","5b9cca4f","682e6ff3",
"748f82ee","78a5636f","84c87814","8cc70208","90befffa","a4506ceb","bef9a3f7","c67178f2"};
        return k[i];
    }
    public String giaTriBamHThu(int i)
    {
        String h[]={"6a09e667","bb67ae85","3c6ef372","a54ff53a","510e527f"
                ,"9b05688c","1f83d9ab","5be0cd19"};
       return h[i];
    }
    public String giaTriBamHSHA_1(int i)
    {
        String h[]={"67452301","efcdab89","98badcfe","10325476","c3d2e1f0"};
        return h[i];
    }
    public String BinToHex(String bin){
        String hex="";
        
       for(int i=0;i<=bin.length()-4;i++)
       {
           if(i%4==0)
           {
           String temp=bin.substring(i,i+4);
        if(temp.equals("1010")) hex+="A" ;
       else if(temp.equals("1011")) hex+="B" ;
       else if(temp.equals("1100")) hex+="C" ;
       else if(temp.equals("1101")) hex+="D" ;
       else if(temp.equals("1110")) hex+="E" ;
       else if(temp.equals("1111")) hex+="F" ;
       else if(temp.equals("0000")) hex+="0" ;
       else if(temp.equals("0001")) hex+="1" ;
       else if(temp.equals("0010")) hex+="2" ;
       else if(temp.equals("0011")) hex+="3" ;
       else if(temp.equals("0100")) hex+="4" ;
       else if(temp.equals("0101")) hex+="5" ;
       else if(temp.equals("0110")) hex+="6" ;
       else if(temp.equals("0111")) hex+="7" ;
       else if(temp.equals("1000")) hex+="8" ;
       else if(temp.equals("1001")) hex+="9" ;
        }
       }
        /*bin = bin.replaceAll("1011","B" );
        bin = bin.replaceAll("1100","C" );
        bin = bin.replaceAll("1101","D" );
        bin = bin.replaceAll("1110","E" );
        bin = bin.replaceAll("1111","F" );
        bin = bin.replaceAll("0000","0");
        bin = bin.replaceAll("0001","1" );
        bin = bin.replaceAll("0010","2" );
        bin = bin.replaceAll("0011","3" );
        bin = bin.replaceAll("0100","4" );
        bin = bin.replaceAll("0101","5" );
        bin = bin.replaceAll("0110","6" );
        bin = bin.replaceAll("0111","7" );
        bin = bin.replaceAll("1000","8" );
        bin = bin.replaceAll("1001","9" );*/
       
        return hex;
    }
    public void xemKQWord(String[] w,String name,int soword)
        {
            System.out.println(name);
             for(int i=0;i<soword;i++)
       {
           if(i%2==0) {System.out.print("\n");}
           else if(i%2==1) {System.out.print("\t");}
           System.out.print("word "+i+": "+w[i]);
       }
                 System.out.println("\n");
        }
    public String hexToBin(String hex){
        hex = hex.replaceAll("0", "0000");
        hex = hex.replaceAll("1", "0001");
        hex = hex.replaceAll("2", "0010");
        hex = hex.replaceAll("3", "0011");
        hex = hex.replaceAll("4", "0100");
        hex = hex.replaceAll("5", "0101");
        hex = hex.replaceAll("6", "0110");
        hex = hex.replaceAll("7", "0111");
        hex = hex.replaceAll("8", "1000");
        hex = hex.replaceAll("9", "1001");
        hex = hex.replaceAll("a", "1010");
        hex = hex.replaceAll("b", "1011");
        hex = hex.replaceAll("c", "1100");
        hex = hex.replaceAll("d", "1101");
        hex = hex.replaceAll("e", "1110");
        hex = hex.replaceAll("f", "1111");
        return hex;
    }
    public int hextoDecima(String hex)
    {
        String chuoitbit=hexToBin(hex);
        return ketQuaChuyenBinarySangDecima(chuoitbit);
    }
    public String calDuong(int n)
    {
        int[] output=new int[60];
        String chuoibit="";
                int count=0;
		while(n>0)
		{
                  if(n==0)
		{
		output[count]=0;
                count++;
                break;
		}
                   else{
                   output[count]=n%2;
                   
                   count++;
	           n=n/2;
                  
		}
                }
                for(int i=32;i>=count;i--)
                {
                    output[i]=0;
                }
                 for(int i=31;i>=0;i--)
                {
                     chuoibit+=String.valueOf(output[i]);
                }
                // //System.out.println("*"+chuoibit);
                return chuoibit;
    }
     public  String calAm(int[] output)
     {
         String chuoibit="";
         int[] outputnew=new int[33];
        boolean tempnho=false;
        
         for(int i=31;i>=0;i--)
                {
               if(output[i]==0) output[i]=1;
               else output[i]=0;
                    ////System.out.print("--"+output[i]);
                }
         for(int i=0;i<32;i++)
                {
               if(i==0) 
               {
          if(output[i]==1) {tempnho=true;outputnew[i]=0;  }
         else if(output[i]==0) {tempnho=false;outputnew[0]=1; }
               }
               else if(tempnho==true)
               {
            if(output[i]==0) {tempnho=false;outputnew[i]=1;}
                   else outputnew[i]=0;
               }
               else if(tempnho==false) { outputnew[i]=output[i];}
                }
         //System.out.println("\n");
         for(int i=31;i>=0;i--)
                {
                output[i]=outputnew[i];
                chuoibit+=outputnew[i];
                }
         
         
        return chuoibit;
     }
    public int RightShift(String w,int sobitdich)
    {
        int n=ketQuaChuyenBinarySangDecima(w);
          return ketQuaChuyenBinarySangDecima(w) >>> sobitdich; 
    }
    public int leftShift(int n,int sobitdich)
    {
          return n << sobitdich; 
    }
    
    public int bitBatDauLaSo0(String chuoibinary)
    {
        int giatridecimal=0;
        for(int i=0;i<chuoibinary.length();i++)
    {
    if(chuoibinary.charAt(i)=='1') 
    giatridecimal=(int)(giatridecimal+Math.pow(2,chuoibinary.length()-i-1));
      }
        //System.out.println("Giá trị: "+giatridecimal);
        return giatridecimal;
    }
    public int bitBatDauLaSo1(String chuoibinary)
    {
        int giatridecimal=0;
        for(int i=0;i<chuoibinary.length();i++)
    {
    if(chuoibinary.charAt(i)=='0') 
    giatridecimal=(int)(giatridecimal+Math.pow(2,chuoibinary.length()-i-1));
      }
         //System.out.println("Giá trị: "+(-(giatridecimal+1)));
        return -(giatridecimal+1);
       
    }
    public String ketQuaChuyenDecimaSangBinary(int decima)
    {
        if(decima>=0)
               {
                return calDuong(decima);
	       }
                else 
                {
                    String chuoidaobitstr=calDuong(-decima);
                    int[] chuoidaobit=new int[34];
                    for(int i=0;i<32;i++)
                    {
           chuoidaobit[i]=Integer.parseInt(String.valueOf(chuoidaobitstr.charAt(31-i)));
                      //  //System.out.print("*"+chuoidaobit[i]);
                    }
                 return calAm(chuoidaobit);
                }
    }
    public int ketQuaChuyenBinarySangDecima(String w)
    {
        int n=0;
        if(w.charAt(0)=='0')
    {
        n=bitBatDauLaSo0(w);
    }
    else 
    {
        if(w.length()==32)
        n=bitBatDauLaSo1(w);
        else bitBatDauLaSo0(w);
    } 
        return n;
    }
    public int rightRotate(String w, int d) {
       int n=ketQuaChuyenBinarySangDecima(w);
    return (n >>> d) | (n << (INT_BITS - d));
    }
    
    public int leftRotate(int n, int d) {
    return (n << d) | (n >>> (INT_BITS - d));
    
}
}
