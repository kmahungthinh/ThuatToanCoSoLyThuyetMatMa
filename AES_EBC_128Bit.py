RoundKeyValue=[i for i in range(1,13)]
#Round_Key_Value=[i for i in range(1,12)]	
After_Subyte=[i for i in range(1,13)]
After_ShiftRows=[i for i in range(1,13)]
After_MixColumns=[i for i in range(1,13)]
Start_of_Round=[i for i in range(1,13)]
After_AddRoundKey=[i for i in range(1,13)]
After_InverseShiftRows=[i for i in range(1,13)]
After_InverseMixColumns=[i for i in range(1,13)]



#Start_of_Round[0]="00112233445566778899aabbccddeeff".upper()
#RoundKeyValue[0]="000102030405060708090a0b0c0d0e0f".upper()


#Start_of_Round[0]="54776F204F6E65204E696E652054776F".upper()
#RoundKeyValue[0]="5468617473206D79204B756E67204675".upper()

#Start_of_Round[0]="a3c5080878a4ffd300ff3636285f0102".upper()
#RoundKeyValue[0]="368ac0f4edcf76a608a3b6783131276e".upper()

#Start_of_Round[0]="3243f6a8885a308d313198a2e0370734".upper()
#RoundKeyValue[0]="2b7e151628aed2a6abf7158809cf4f3c".upper()

RoundKeyValue[0]="2b7e151628aed2a6abf7158809cf4f3c".upper()
Start_of_Round[0]="3AD77BB40D7A3660A89ECAF32466EF97".upper()




w=[i for i in range(0,48)]

import numpy,itertools

#1)*********************************************Begin General*************************************************************
#1.1)===================Chuẩn hóa list========================
def demChoDuBinary(str_bit, soBit):
  padding=""  
  for i in range(0,soBit-len(str(str_bit))):
    padding+="0"
  return padding
def demChoDuHex(str_hex, soKyTuHex):
  padding=""  
  for i in range(0,soKyTuHex-len(str(str_hex))):
    padding+="0"
  return padding
#InOut: List-> return: List, khi đầu vào và 1 list các phần tử có thể gồm 0,1,2,3... thì trả về list chỉ gồm 0 hoặc 1
def chuanHoaListVeListGom0va1(listx):
  listTemp=[]
  for i in listx:
    if int(abs(i))%2==0:
      listTemp.append(0)
    else:
      listTemp.append(1)
  #print("Chuẩn hóa",listTemp)
  return listTemp
def list_To_String(List):
  chuoi=""
  for i in List:
    chuoi+=str(i)
  return chuoi
def string_To_List_Int(Str,soKyTuTai1PhanTuList):
  listTemp=[]
  x=0
  for i in range(0,int(len(Str)/soKyTuTai1PhanTuList)):
    listTemp.append(int(Str[x:x+soKyTuTai1PhanTuList]))
    x=x+soKyTuTai1PhanTuList
  return listTemp
#1.2)=============Chuyển cơ số=============================
def binaryToHex(Input):
  if Input=="0":
    return "00"
  Output=hex(int(Input, 2))[2:len(Input)].upper()
  if len(Output)==1:
  	return "0"+Output
  else:
  	return Output
def hexToBinary(str_hex):
  # Đoạn code chuyển
  res=""
  if str_hex=="00":
    return "00000000" 
  n = int(str_hex, 16)
  bStr = ''
  while n > 0:
    bStr = str(n % 2) + bStr
    n = n >> 1
    res = bStr
  return res
def binToDecimal(binary_num):
  dec_num = int(binary_num, 2)
  return dec_num
def decimalToBinary(n):
  return bin(n).replace("0b", "")
def hexToDecimal(strHex):
	return int(strHex, 16)
def deciToHex(deci):
	kqHex= hex(deci)
	kqHex = kqHex[2:len(kqHex)].upper()
	return kqHex
#1.3)=============Phép tính đa thức=============================  
def chiaDaThuc_para(dathucchia_list,dathucbichia_list):
  #print("=============Chia đa thức=============")
  dathucbichia =   numpy.array(dathucbichia_list)
  dathucchia = numpy.array(dathucchia_list)
  thuong, du = numpy.polydiv(dathucchia, dathucbichia)
  #print("Thương: ", thuong)
  #print("Dư : ", du)
  return du
def nhanDaThuc_para(dathuc1_list,dathuc2_list):
  #print("=============Nhân đa thức=============")
  #t6 + t4 + t + 1
  dathuc1 =  numpy.array(dathuc1_list)
  #t7 + t6 + t3 + t
  dathuc2 =  numpy.array(dathuc2_list)
  #print("Da thuc 2",dathuc2)
  ketqua  =  numpy.polymul(dathuc1, dathuc2)
  #print("Kết quả nhân",ketqua)
  return ketqua
def nhanDaThucModuloG28_para(dathuc1_list,dathuc2_list):
  temp=chuanHoaListVeListGom0va1(chiaDaThuc_para(chuanHoaListVeListGom0va1(nhanDaThuc_para(dathuc1_list,dathuc2_list)),[1,0,0,0,1,1,0,1,1]))
  temp=list_To_String(temp)
  temp=demChoDuBinary(temp,8)+temp
  return string_To_List_Int(temp,1)
def congDaThuc_para(dathuc1,dathuc2):
  #print("=============Cộng đa thức=============")
  dathuc1 = numpy.array(dathuc1)
  dathuc2 = numpy.array(dathuc2)
  tong= numpy.polyadd(dathuc1, dathuc2)
  return tong
#1.4)==================Đa thức nghịch đảo===============================
def listCuaSoDuLaDu1(listcheck):
  listx=list(listcheck)
  count=0
  for i in listx:
    if abs(int(i))%2==1:
      count=count+1
  if count>1: 
    return False
  giaTriPhanTuCuoi=listx[len(listx)-1]
  if (int(giaTriPhanTuCuoi)%2==1 or giaTriPhanTuCuoi==-1.0):
    return True
  else:
    return False 
def danhSachList():
    listTangDanDapAnTrong1Truong=[0,1]
    #3) Lấy Danh sách chỉnh hợp lặp của 1,2 xếp mỗi bản ghi 3 vị trí số kết quả là 2^3
    listx=[]
    listy=[]
    for i in range(1,9):
        chinhHopLapChapKCuaN = list(itertools.product(listTangDanDapAnTrong1Truong, repeat=i))
        listx.append(chinhHopLapChapKCuaN)
    for i in range (0,len(listx)):
        for j in range (0,len(listx[i])):
            listy.append(listx[i][j])
    #print("Danh sách chỉnh hợp lặp")
    #print(listy)
    #print(len(listy))
    return listy
def daThucNghichDaoG28(daThuc):
  a=danhSachList()
  for i in a:
    du=chiaDaThuc_para(chuanHoaListVeListGom0va1(nhanDaThuc_para(daThuc,i)),[1,0,0,0,1,1,0,1,1]) 
    if listCuaSoDuLaDu1(du) == True:
      #print("i",i)
      temp=list_To_String(i)
      temp=demChoDuBinary(temp,8)+temp
      temp=string_To_List_Int(temp,1)
      return temp
#1.5)==================Phép toán Ma trận===============================
def maTranNghichDao(A):
  m = numpy.matrix(A)
  #print(m.I)
  array1=numpy.array(m.I,ndmin=8)
  return array1
def nhan2MaTran(maTran1_List,maTran2_List,ndminMatran1,ndminMatran2):
  array1=numpy.array(maTran1_List,ndmin=ndminMatran1)  
  array2=numpy.array(maTran2_List,ndmin=ndminMatran2)  
  result=numpy.dot(array1,array2)
  #print("Kết quả",result)
  return result

#************************************************End General*******************************************************************************************************************	

#************************************************Begin Programing**************************************************************************************************************
S_Box=[
["63","7c","77","7b","f2","6b","6f","c5","30","01","67","2b","fe","d7","ab","76"],
["ca","82","c9","7d","fa","59","47","f0","ad","d4","a2","af","9c","a4","72","c0"],
["b7","fd","93","26","36","3f","f7","cc","34","a5","e5","f1","71","d8","31","15"],
["04","c7","23","c3","18","96","05","9a","07","12","80","e2","eb","27","b2","75"],
["09","83","2c","1a","1b","6e","5a","a0","52","3b","d6","b3","29","e3","2f","84"],
["53","d1","00","ed","20","fc","b1","5b","6a","cb","be","39","4a","4c","58","cf"],
["d0","ef","aa","fb","43","4d","33","85","45","f9","02","7f","50","3c","9f","a8"],
["51","a3","40","8f","92","9d","38","f5","bc","b6","da","21","10","ff","f3","d2"],
["cd","0c","13","ec","5f","97","44","17","c4","a7","7e","3d","64","5d","19","73"],
["60","81","4f","dc","22","2a","90","88","46","ee","b8","14","de","5e","0b","db"],
["e0","32","3a","0a","49","06","24","5c","c2","d3","ac","62","91","95","e4","79"],
["e7","c8","37","6d","8d","d5","4e","a9","6c","56","f4","ea","65","7a","ae","08"],
["ba","78","25","2e","1c","a6","b4","c6","e8","dd","74","1f","4b","bd","8b","8a"],
["70","3e","b5","66","48","03","f6","0e","61","35","57","b9","86","c1","1d","9e"],
["e1","f8","98","11","69","d9","8e","94","9b","1e","87","e9","ce","55","28","df"],
["8c","a1","89","0d","bf","e6","42","68","41","99","2d","0f","b0","54","bb","16"]
]
inverse_S_Box=[
["52","09","6a","d5","30","36","a5","38","bf","40","a3","9e","81","f3","d7","fb"],
["7c","e3","39","82","9b","2f","ff","87","34","8e","43","44","c4","de","e9","cb"],
["54","7b","94","32","a6","c2","23","3d","ee","4c","95","0b","42","fa","c3","4e"],
["08","2e","a1","66","28","d9","24","b2","76","5b","a2","49","6d","8b","d1","25"],
["72","f8","f6","64","86","68","98","16","d4","a4","5c","cc","5d","65","b6","92"],
["6c","70","48","50","fd","ed","b9","da","5e","15","46","57","a7","8d","9d","84"],
["90","d8","ab","00","8c","bc","d3","0a","f7","e4","58","05","b8","b3","45","06"],
["d0","2c","1e","8f","ca","3f","0f","02","c1","af","bd","03","01","13","8a","6b"],
["3a","91","11","41","4f","67","dc","ea","97","f2","cf","ce","f0","b4","e6","73"],
["96","ac","74","22","e7","ad","35","85","e2","f9","37","e8","1c","75","df","6e"],
["47","f1","1a","71","1d","29","c5","89","6f","b7","62","0e","aa","18","be","1b"],
["fc","56","3e","4b","c6","d2","79","20","9a","db","c0","fe","78","cd","5a","f4"],
["1f","dd","a8","33","88","07","c7","31","b1","12","10","59","27","80","ec","5f"],
["60","51","7f","a9","19","b5","4a","0d","2d","e5","7a","9f","93","c9","9c","ef"],
["a0","e0","3b","4d","ae","2a","f5","b0","c8","eb","bb","3c","83","53","99","61"],
["17","2b","04","7e","ba","77","d6","26","e1","69","14","63","55","21","0c","7d"]
]
R_Con=["01","02","04","08","10","20","40","80","1B","36"]

def strhangThanh_ListCotCuaMaTranVuongCap(capMaTran,chuoiMaTran):
	listTemp=[]
	x=0
	for i in range(0,capMaTran**2):
		listTemp.append(chuoiMaTran[x:x+2])
		x=x+2
	j=0
	chuoi=[]
	for i in range(0,capMaTran**2):
		if i%capMaTran == 0 and j>0:
			j=j-((capMaTran**2)-1)
		chuoi.append(listTemp[j])
		j+=capMaTran
	return chuoi

def strhangThanhMaTranVuongCap(capMaTran,Input):
	Output=[]
	x=0
	for i in range(0,capMaTran):
		Output.append([Input[x:x+2],Input[x+2:x+4],Input[x+4:x+6],Input[x+6:x+8]])
		x=x+8
	return Output
def list_To_String(List):
	chuoi=""
	for i in List:
		chuoi+=str(i)
	return chuoi
def string_To_List(Str,soKyTuTai1PhanTuList):
	listTemp=[]
	x=0
	for i in range(0,int(len(Str)/soKyTuTai1PhanTuList)):
		listTemp.append(Str[x:x+soKyTuTai1PhanTuList])
		x=x+soKyTuTai1PhanTuList
	return listTemp
def xuLyKhoa(vongLap):
	byteCuoiAfterRotWord=w[vongLap*4-1][2:8]+w[vongLap*4-1][0:2]
	hex_byteCuoiAfterSubWord=""
	j=0
	for i in range(0,4):
		hex_byteCuoiAfterSubWord+=S_Box[hexToDecimal(byteCuoiAfterRotWord[j])][hexToDecimal(byteCuoiAfterRotWord[j+1])]
		j=j+2
	deci_byteCuoiAfterSubWord=hexToDecimal(hex_byteCuoiAfterSubWord)
	deci_R_con=hexToDecimal(R_Con[vongLap-1]+"000000")
	hex_AfterXorRcon=deciToHex(deci_byteCuoiAfterSubWord^deci_R_con)
	w[vongLap*4-4]=RoundKeyValue[vongLap-1][0:8]
	w[vongLap*4]=deciToHex(hexToDecimal(hex_AfterXorRcon)^hexToDecimal(w[vongLap*4-4])) 
	for i in range(vongLap*4+1,vongLap*4+4):
		w[i]=deciToHex(hexToDecimal(w[i-4]) ^ hexToDecimal(w[i-1]))
	RoundKeyValue[vongLap]=""
	t=0
	for i in range(vongLap*4,vongLap*4+4):
		if len(w[i])!=8:
			w[i]=demChoDuHex(w[i],8)+w[i]
		RoundKeyValue[vongLap]=RoundKeyValue[vongLap]+w[i]
		t+=1
	#Round_Key_Value[vongLap]=RoundKeyValue[vongLap]
	#print("Khóa {}: {}".format(vongLap,RoundKeyValue[vongLap]))
	#print("Round_Key_Value {}: {}".format(vongLap,Round_Key_Value[vongLap]))
#-------------------------------------------------------------Mã hóa----------------------------------------------------------------------------------------
def subByte(Input):
	j=0
	Input=Input.lower()
	Output=""
	for i in range(0,16):
		Output=Output+S_Box[hexToDecimal(Input[j])][hexToDecimal(Input[j+1])]
		#print(hex_InputAfterSubWord)
		j=j+2
	return Output.upper()
	
def shiftRows(Input):
	Input_ele_old=[i for i in range(1,6)]
	Input_ele_new=[i for i in range(1,6)]
	index=0
	for i in range(1,5):
		Input_ele_old[i]=Input[index:index+8]
		index+=8
	Input_ele_new[1]=Input_ele_old[1]
	Input_ele_new[2]=Input_ele_old[2][2]+Input_ele_old[2][3]+Input_ele_old[2][4]+Input_ele_old[2][5]+Input_ele_old[2][6]+Input_ele_old[2][7]+Input_ele_old[2][0]+Input_ele_old[2][1]
	Input_ele_new[3]=Input_ele_old[3][4]+Input_ele_old[3][5]+Input_ele_old[3][6]+Input_ele_old[3][7]+Input_ele_old[3][0]+Input_ele_old[3][1]+Input_ele_old[3][2]+Input_ele_old[3][3]
	Input_ele_new[4]=Input_ele_old[4][6]+Input_ele_old[4][7]+Input_ele_old[4][0]+Input_ele_old[4][1]+Input_ele_old[4][2]+Input_ele_old[4][3]+Input_ele_old[4][4]+Input_ele_old[4][5]
	Output=""
	for i in range(1,5):
		Output=Output+Input_ele_new[i]
	return Output

def mixColumns(Input):
	#print("ABC",Input)
	matrix1=[['02','03','01','01'],['01','02','03','01'],['01','01','02','03'],['03','01','01','02']]
	matrix2=Input
	Output=""
	res = [[0 for x in range(4)] for y in range(4)]
	count=0
	for i in range(len(matrix1)):
		for j in range(len(matrix2[0])):
			for k in range(len(matrix2)):
				count=count+1
				temp1=hexToBinary(matrix1[i][k])
				temp1=demChoDuBinary(temp1,8)+temp1
				ele_A_List=string_To_List_Int(temp1,1)

				temp2=hexToBinary(matrix2[k][j])
				temp2=demChoDuBinary(temp2,8)+temp2
				ele_B_List=string_To_List_Int(temp2,1)
				res[i][j] = chuanHoaListVeListGom0va1(congDaThuc_para(res[i][j],chuanHoaListVeListGom0va1((nhanDaThucModuloG28_para(ele_A_List,ele_B_List))))) 
				if count%4==0:
					Output=Output+binaryToHex(list_To_String(res[i][j]))
	return Output
def addRoundKey(maTran1,maTran2):

	#print("matran1",maTran1)
	#print("matran2",maTran2)
	maTran1=string_To_List(maTran1,2)
	maTran2=strhangThanh_ListCotCuaMaTranVuongCap(4,maTran2)
	Output=""
	for i in range(0,16):  
			temp1=hexToBinary(maTran1[i])
			temp1=demChoDuBinary(temp1,8)+temp1
			ele_A_List=string_To_List_Int(temp1,1)

			temp2=hexToBinary(maTran2[i])
			temp2=demChoDuBinary(temp2,8)+temp2
			ele_B_List=string_To_List_Int(temp2,1)

			#print(ele_A_List,"cong",ele_B_List)
			Output=Output+binaryToHex(list_To_String(chuanHoaListVeListGom0va1(congDaThuc_para(ele_A_List,ele_B_List)))) 
	#print(Output)
	return Output

def maHoa():
	print("Round Number\t\t\tStart_of_Round\t\t\tAfter_Subyte\t\t\tAfter_ShiftRows\t\t\tAfter_MixColumns\t\t\tRoundKeyValue")
	print(0,end='\t')
	Start_of_Round[0]=strhangThanh_ListCotCuaMaTranVuongCap(4,Start_of_Round[0])
	Start_of_Round[0]=list_To_String(Start_of_Round[0])
	print(Start_of_Round[0],end="																												")
	#print("Khóa K Hex 0:",RoundKeyValue[0])

	print(RoundKeyValue[0])
	Start_of_Round[1]=addRoundKey(Start_of_Round[0],RoundKeyValue[0])
	#print(Start_of_Round[0])
	for i in range(1,11):
		print(i,end='\t')
		#print("Round Input {}:".format(i),Start_of_Round[i])
		print(Start_of_Round[i],end='\t')
		After_Subyte[i]=subByte(Start_of_Round[i])
		#print("After_Subyte {}:".format(i),After_Subyte[i])
		print(After_Subyte[i],end='\t')

		After_ShiftRows[i]=shiftRows(After_Subyte[i])
		#print("After_ShiftRows {}:".format(i),After_ShiftRows[i])
		print(After_ShiftRows[i],end='\t')

		
		if i!=10:
			After_ShiftRows[i]=strhangThanhMaTranVuongCap(4,After_ShiftRows[i])
			After_MixColumns[i]=mixColumns(After_ShiftRows[i])
			#print("After_MixColumns {}:".format(i),After_MixColumns[i])
			print(After_MixColumns[i],end='\t')
			
			Start_of_Round[i+1]=addRoundKey(After_MixColumns[i],RoundKeyValue[i])
			print(RoundKeyValue[i],end='\n')
		else:
			Start_of_Round[i]=addRoundKey(After_ShiftRows[i],RoundKeyValue[i])
			print("								",end='\t')
			print(RoundKeyValue[i],end='\n')
			print("Output :",Start_of_Round[i])

			Start_of_Round[i]=strhangThanh_ListCotCuaMaTranVuongCap(4,Start_of_Round[i])
			Start_of_Round[i]=list_To_String(Start_of_Round[i])
			print("Kết quả mã hóa thu được bản mã:",Start_of_Round[i])

#-------------------------------------------------------------Giải mã----------------------------------------------------------------------------------------
def inverseSubByte(Input):
	j=0
	Input=Input.lower()
	Output=""
	for i in range(0,16):
		Output=Output+inverse_S_Box[hexToDecimal(Input[j])][hexToDecimal(Input[j+1])]
		#print(hex_InputAfterSubWord)
		j=j+2
	return Output.upper()
	
def inverseShiftRows(Input):
	Input_ele_old=[i for i in range(1,6)]
	Input_ele_new=[i for i in range(1,6)]
	index=0
	for i in range(1,5):
		Input_ele_old[i]=Input[index:index+8]
		index+=8
	Input_ele_new[1]=Input_ele_old[1]
	Input_ele_new[2]=Input_ele_old[2][6]+Input_ele_old[2][7]+Input_ele_old[2][0]+Input_ele_old[2][1]+Input_ele_old[2][2]+Input_ele_old[2][3]+Input_ele_old[2][4]+Input_ele_old[2][5]
	Input_ele_new[3]=Input_ele_old[3][4]+Input_ele_old[3][5]+Input_ele_old[3][6]+Input_ele_old[3][7]+Input_ele_old[3][0]+Input_ele_old[3][1]+Input_ele_old[3][2]+Input_ele_old[3][3]
	Input_ele_new[4]=Input_ele_old[4][2]+Input_ele_old[4][3]+Input_ele_old[4][4]+Input_ele_old[4][5]+Input_ele_old[4][6]+Input_ele_old[4][7]+Input_ele_old[4][0]+Input_ele_old[4][1]
	Output=""
	for i in range(1,5):
		Output=Output+Input_ele_new[i]
	return Output

def inverseMixColumns(Input):
	matrix1=[['0E','0B','0D','09'],['09','0E','0B','0D'],['0D','09','0E','0B'],['0B','0D','09','0E']]
	#matrix1=[['02','03','01','01'],['01','02','03','01'],['01','01','02','03'],['03','01','01','02']]
	matrix2=Input
	Output=""
	res = [[0 for x in range(4)] for y in range(4)]
	count=0
	for i in range(len(matrix1)):
		for j in range(len(matrix2[0])):
			for k in range(len(matrix2)):
				#print("hello")
				count=count+1
				temp1=hexToBinary(matrix1[i][k])
				temp1=demChoDuBinary(temp1,8)+temp1
				ele_A_List=string_To_List_Int(temp1,1)

				temp2=hexToBinary(matrix2[k][j])
				temp2=demChoDuBinary(temp2,8)+temp2
				ele_B_List=string_To_List_Int(temp2,1)
				res[i][j] = chuanHoaListVeListGom0va1(congDaThuc_para(res[i][j],chuanHoaListVeListGom0va1((nhanDaThucModuloG28_para(ele_A_List,ele_B_List))))) 
				if count%4==0:
					Output=Output+binaryToHex(list_To_String(res[i][j]))
	return Output
def giaiMa():
	print("Round Number\t\t\tStart_of_Round\t\t\tAfter_InverseAddRoundKey\t\t\tAfter_InverseMixColumns\t\t\tAfter_InverseShiftRows\t\t\tAfter_InverseSubyte")
	print(0,end='\t')
	#print("aaa",Start_of_Round[0])
	Start_of_Round[0]=list_To_String(strhangThanh_ListCotCuaMaTranVuongCap(4,Start_of_Round[0]))
	print(Start_of_Round[0],end="\t")
	
	#Vòng 0 chỉ có add roundkey, shift row, subbyte
	After_AddRoundKey[0]=addRoundKey(Start_of_Round[0],RoundKeyValue[10])
	print(After_AddRoundKey[0],end='                                        ')
	After_InverseShiftRows[0]=inverseShiftRows(After_AddRoundKey[0])
	print(After_InverseShiftRows[0],end='\t')
	Start_of_Round[1]=inverseSubByte(After_InverseShiftRows[0])
	print(Start_of_Round[1])

	for i in range(1,10):
		#InverseAddRoundKey
		print(i,end='\t')
		print(Start_of_Round[i],end='\t')
		After_AddRoundKey[i]=addRoundKey(Start_of_Round[i],RoundKeyValue[10-i])
		print(After_AddRoundKey[i],end='\t')

		#InverseMixColumns
		After_AddRoundKey[i]=strhangThanhMaTranVuongCap(4,After_AddRoundKey[i])
		After_InverseMixColumns[i]=inverseMixColumns(After_AddRoundKey[i])
		print(After_InverseMixColumns[i],end='\t')

		#InverseShiftRows
		After_InverseShiftRows[i]=inverseShiftRows(After_InverseMixColumns[i])
		print(After_InverseShiftRows[i],end='\t')
		Start_of_Round[i+1]=inverseSubByte(After_InverseShiftRows[i])
		print(Start_of_Round[i+1])
	print("   ",Start_of_Round[10],end='\t')
	After_AddRoundKey[10]=addRoundKey(Start_of_Round[10],RoundKeyValue[0])
	print("                                                                                                           ",After_AddRoundKey[10])
	After_AddRoundKey[10]=strhangThanh_ListCotCuaMaTranVuongCap(4,After_AddRoundKey[10])
	After_AddRoundKey[10]=list_To_String(After_AddRoundKey[10])
	print("Kết quả giải mã thu được bản rõ:",After_AddRoundKey[10])


def taoVaMoRongKhoa():
	x=0
	for i in range(0,4):
		w[i]=RoundKeyValue[0][x:x+8]
		x+=8
	for i in range(1,11):
		xuLyKhoa(i)
	for i in range(0,11):
		print("Round_Key_Value {}: {}".format(i,RoundKeyValue[i]))
#************************************************End Programing********************************************************************************************************************
#************************************************Begin Chạy chương trình***********************************************************************************************************	
taoVaMoRongKhoa()
#maHoa()
giaiMa()
#************************************************End Chạy chương trình**************************************************************************************************************	

