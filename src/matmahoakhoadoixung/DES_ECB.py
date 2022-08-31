import math
khoaKText = "123457799BBCDFF1"
thongDiep = "85E813540F0AB405"
binary_C=[i for i in range(0,28)]
binary_D=[i for i in range(0,28)]
L=[i for i in range(0,20)]
R=[i for i in range(0,20)]
KEY=[i for i in range(0,17)]
def binToDeci(binary_num):
  dec_num = int(binary_num, 2)
  return dec_num
def binaryToHex(str_binary):
  return hex(int(str_binary, 2))[2:len(str_binary)].upper()
def decimalToBinary(n):
  return bin(n).replace("0b", "")
def dichBit(chuoiBit,huongDich,soBitDich):
  dau=""
  cuoi=""
  if huongDich == "trai":
    dau=chuoiBit[0:int(soBitDich)]
    cuoi=chuoiBit[int(soBitDich):len(chuoiBit)]
    return cuoi+dau 
  elif huongDich == "phai":
    dau=chuoiBit[0:len(chuoiBit)-int(soBitDich)]
    cuoi=chuoiBit[len(chuoiBit)-int(soBitDich):len(chuoiBit)]
    return cuoi+dau
def MaHoa(q):
  #==================Mở rộng khóa E=Mở rộng của R(1)=====================================
  E=[32,1,2,3,4,5,
  4,5,6,7,8,9,
  8,9,10,11,12,13,
  12,13,14,15,16,17,
  16,17,18,19,20,21,
  20,21,22,23,24,25,
  24,25,26,27,28,29,
  28,29,30,31,32,1]
  R[q-1]="x"+R[q-1]
  R0_moRongKhoa=""
  for i in range(0,48):
    R0_moRongKhoa+=R[q-1][E[i]]
  #print("E(R0): ",R0_moRongKhoa)
  #====================Phép thế A = (K1 xor Khóa mở rộng)======================
  A_xorK1_VS_ERO=decimalToBinary(binToDeci(R0_moRongKhoa)^binToDeci(KEY[q]))
  A_xorK1_VS_ERO=demChoDu(A_xorK1_VS_ERO,48)+A_xorK1_VS_ERO
  #print(A_xorK1_VS_ERO)
  cap6bit=[]
  cap6bithang=[]
  cap6bitcot=[]
  chiSoMang=[]
  x=0
  y=6
  for i in range(0,8):
    cap6bit.append(A_xorK1_VS_ERO[x:y])
    x=x+6
    y=y+6
  '''for i in cap6bit:
    print(i)'''
  x=0
  y=5
  for i in range(0,8):
    temp=A_xorK1_VS_ERO[x]+A_xorK1_VS_ERO[y]
    cap6bithang.append(temp)
    x=x+6
    y=y+6
  x=1
  y=2
  z=3
  t=4
  for i in range(0,8):
    temp=A_xorK1_VS_ERO[x]+A_xorK1_VS_ERO[y]+A_xorK1_VS_ERO[z]+A_xorK1_VS_ERO[t]
    cap6bitcot.append(temp)
    x=x+6
    y=y+6
    z=z+6
    t=t+6
  '''print("6 bit cột")
  for i in range(0,8):
    print(cap6bitcot[i])
  print("6 bit hàng")
  for i in range(0,8):
    print(cap6bithang[i])
  print("Chỉ số mảng")'''
  for i in range(0,8):
    chiSoMang.append(binToDeci(cap6bithang[i]+cap6bitcot[i]))
    #print(chiSoMang[i])
  S=[i for i in range(0,8)]
  S[0]=[14,4,13,1,2,15,11,8,3,10,6,12,5,9,0,7
      ,0,15,7,4,14,2,13,1,10,6,12,11,9,5,3,8
      ,4,1,14,8,13,6,2,11,15,12,9,7,3,10,5,0
      ,15,12,8,2,4,9,1,7,5,11,3,14,10,0,6,13]
  S[1]=[15,1,8,14,6,11,3,4,9,7,2,13,12,0,5,10
      ,3,13,4,7,15,2,8,14,12,0,1,10,6,9,11,5
      ,0,14,7,11,10,4,13,1,5,8,12,6,9,3,2,15
      ,13,8,10,1,3,15,4,2,11,6,7,12,0,5,14,9]
  S[2]=[10,0,9,14,6,3,15,5,1,13,12,7,11,4,2,8
      ,13,7,0,9,3,4,6,10,2,8,5,14,12,11,15,1
      ,13,6,4,9,8,15,3,0,11,1,2,12,5,10,14,7
      ,1,10,13,0,6,9,8,7,4,15,14,3,11,5,2,12]
  S[3]=[7,13,14,3,0,6,9,10,1,2,8,5,11,12,4,15
      ,13,8,11,5,6,15,0,3,4,7,2,12,1,10,14,9
      ,10,6,9,0,12,11,7,13,15,1,3,14,5,2,8,4
      ,3,15,0,6,10,1,13,8,9,4,5,11,12,7,2,14]
  S[4]=[2,12,4,1,7,10,11,6,8,5,3,15,13,0,14,9
      ,14,11,2,12,4,7,13,1,5,0,15,10,3,9,8,6
      ,4,2,1,11,10,13,7,8,15,9,12,5,6,3,0,14
      ,11,8,12,7,1,14,2,13,6,15,0,9,10,4,5,3]
  S[5]=[12,1,10,15,9,2,6,8,0,13,3,4,14,7,5,11
      ,10,15,4,2,7,12,9,5,6,1,13,14,0,11,3,8
      ,9,14,15,5,2,8,12,3,7,0,4,10,1,13,11,6
      ,4,3,2,12,9,5,15,10,11,14,1,7,6,0,8,13]

  S[6]=[4,11,2,14,15,0,8,13,3,12,9,7,5,10,6,1
      ,13,0,11,7,4,9,1,10,14,3,5,12,2,15,8,6
      ,1,4,11,13,12,3,7,14,10,15,6,8,0,5,9,2
      ,6,11,13,8,1,4,10,7,9,5,0,15,14,2,3,12]

  S[7]=[13,2,8,4,6,15,11,1,10,9,3,14,5,0,12,7
      ,1,15,13,8,10,3,7,4,12,5,6,11,0,14,9,2
      ,7,11,4,1,9,12,14,2,0,6,10,13,15,3,5,8
      ,2,1,14,7,4,10,8,13,15,12,9,0,3,5,6,11]
  #====================Phép thế S(Box)======================
  #print("Dãy giá trị")
  B_ele_binary=[]
  B_binary=""
  for i in range(0,8):
    B_ele_binary.append(decimalToBinary(S[i][chiSoMang[i]]))
    B_ele_binary[i]=demChoDu(B_ele_binary[i],4)+B_ele_binary[i]
    B_binary+=B_ele_binary[i]
    #print(B_ele_binary[i])
  #print("KQ phép thế A",B_binary)
  B_binary="x"+B_binary

  F=""
  P=[16,7,20,21,29,12,28,17,
    1,15,23,26,5,18,31,10,
    2,8,24,14,32,27,3,9,
    19,13,30,6,22,11,4,25]
  for i in range(0,32):
    F+=B_binary[P[i]]
  #print("F:",F)
  F_xor_L0=binToDeci(F)^binToDeci(L[q-1])
  F_xor_L0=decimalToBinary(F_xor_L0)
  F_xor_L0=demChoDu(F_xor_L0,32)+F_xor_L0 
  #Gán tham số cho vòng lặp tiếp
  L[q+1]=R[q]=F_xor_L0
  return F_xor_L0
  #print("KQ:",)
def hexToBinary(str_hex):
  # Đoạn code chuyển 
  n = int(str_hex, 16)
  bStr = ''
  while n > 0:
    bStr = str(n % 2) + bStr
    n = n >> 1
    res = bStr
  return res
def demChoDu(str_hex, soBit):
  padding=""  
  for i in range(0,soBit-len(str(str_hex))):
  #Khởi tạo đêm nhưng đệm thêm phát để nó loại đi vị trí 0 và bắt đầu từ vị trí 1
    padding+="0"
  return padding
  # Khởi tạo chuỗi nhị phân
def khoaK_PC1():
  print("Khóa đầu vào:", khoaKText)
  res=hexToBinary(khoaKText)
  # In kết quả
  print("Đưa khóa về dạng nhị phân:", str(res))
  #In chiều dài
  print ("Độ dài khóa", len(str(res)))
  #Đệm đủ đầu cho độ dài là 64bit
  binary_key="x"+demChoDu(res,64)+res

  PC1=[57,49,41,33,25,17,9,
  1,58,50,42,34,26,18,
  10,2,59,51,43,35,27,
  19,11,3,60,52,44,36,
  63,55,47,39,31,23,15,
  7,62,54,46,38,30,22,
  14,6,61,53,45,37,29,
  21,13,5,28,20,12,4]

  key_PC1_bin=""
  for i in range(0,56):
    key_PC1_bin+=binary_key[PC1[i]]
  #print("Khóa qua hộp thế PC1 dạng binary:",key_PC1_bin)

  binary_C[0]=key_PC1_bin[0:28]
  binary_D[0]=key_PC1_bin[28:56]
def khoaK_PC2(t):
  bitDich =[1,1,2,2,2,2,2,2,1,2,2,2,2,2,2,1]
  #Hộp thể PC1
  chuoiDichTrai_C1=dichBit(binary_C[t-1],"trai",bitDich[t-1])
  binary_C[t]=demChoDu(chuoiDichTrai_C1,28)+chuoiDichTrai_C1

  chuoiDichTrai_D1=dichBit(binary_D[t-1],"trai",bitDich[t-1])
  binary_D[t]=demChoDu(chuoiDichTrai_D1,28)+chuoiDichTrai_D1

  #Chuyển từ nhị phân sang hex viết hoa
  #print("C2 sau dịch trái:",chuoiDichTrai_D1)
  C1D1=(chuoiDichTrai_C1+chuoiDichTrai_D1)
  C1D1="x"+C1D1
  PC2=[14,17,11,24,1, 5,
    3, 28,15,6, 21,10,
    23,19,12,4, 26,8,
    16,7, 27,20,13,2,
    41,52,31,37,47,55,
    30,40,51,45,33,48,
    44,49,39,56,34,53,
    46,42,50,36,29,32]
  KEY[t]=""
  for i in range(0,48):
    KEY[t]+=C1D1[PC2[i]]
  return KEY[t]

def hoanViIPThongDiep():
  IP=[58,50,42,34,26,18,10,2,
  60,52,44,36,28,20,12,4,
  62,54,46,38,30,22, 14,6,
  64,56,48,40,32,24,16,8,
  57,49,41,33,25,17,9, 1,
  59,51,43,35,27,19,11,3,
  61,53,45,37,29,21,13,5,
  63,55,47,39,31,23,15,7]
  thongDiep_binary=hexToBinary(thongDiep)
  thongDiep_binary=demChoDu(thongDiep_binary,64)+thongDiep_binary
  thongDiep_binary="x"+thongDiep_binary
  thongDiep_IP_bin=""
  for i in range(0,64):
    thongDiep_IP_bin+=thongDiep_binary[IP[i]]
  thongDiep_IP_hex=binaryToHex(thongDiep_IP_bin)
  L[0]=thongDiep_IP_bin[0:32]
  L[1]=R[0]=thongDiep_IP_bin[32:64]
def daoViTri_R16_L16_HoanViIPNguocVaKetQua():
  IP_nguoc=[40,8,48,16,56,24,64,32,
  39,7,47,15,55,23,63,31,
  38,6,46,14,54,22,62,30,
  37,5,45,13,53,21,61,29,
  36,4,44,12,52,20,60,28,
  35,3,43,11,51,19,59,27,
  34,2,42,10,50,18,58,26,
  33,1,41,9,49,17,57,25]
  
  L16_R16="x"+R[16]+L[16]
  banMa_string=""
  for i in range(0,64):
    banMa_string+=L16_R16[IP_nguoc[i]]
  return binaryToHex(banMa_string) 
def daoKhoa():
  TEMPKEY=[i for i in range(1,18)]
  for i in range(1,17):
    TEMPKEY[i]=KEY[i]
  for i in range(1,17):
    KEY[i]=TEMPKEY[17-i]
#=====================Tìm 16 khóa=================================#
def maHoa():
  binary_C=[i for i in range(0,28)]
  binary_D=[i for i in range(0,28)]
  L=[i for i in range(0,20)]
  R=[i for i in range(0,20)]
  khoaK_PC1()
  for i in range(1,17):
    print("Khóa {}: {}".format(i,khoaK_PC2(i)))
#=====================Tìm 16 R=================================#

  hoanViIPThongDiep()
  for i in range(1,17):
    print("R{}: {}".format(i,MaHoa(i)))
  print("Kết quả mã hóa: ",daoViTri_R16_L16_HoanViIPNguocVaKetQua())

def giaiMa():
  binary_C=[i for i in range(0,28)]
  binary_D=[i for i in range(0,28)]
  L=[i for i in range(0,20)]
  R=[i for i in range(0,20)]

  khoaK_PC1()
  for i in range(1,17):
    print("Khóa {}: {}".format(i,khoaK_PC2(i)))
  daoKhoa()
  for i in range(1,17):
    print("Khóa đảo {}: {}".format(i,KEY[i]))
#=====================Tìm 16 R=================================#

  hoanViIPThongDiep()
  for i in range(1,17):
    print("R{}: {}".format(i,MaHoa(i)))
  print("Kết quả giải mã:",daoViTri_R16_L16_HoanViIPNguocVaKetQua())

#Mã hóa
#maHoa()
#Giải mã
giaiMa()
