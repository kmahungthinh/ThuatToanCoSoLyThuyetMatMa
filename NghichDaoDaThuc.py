
import numpy
import numpy,itertools
#************************************************Begin General*****************************************************
def chuanHoaListVeListGom0va1(listx):
  listTemp=[]
  for i in listx:
    if int(abs(i))%2==0:
      listTemp.append(0)
    else:
      listTemp.append(1)
  #print("Chuẩn hóa",listTemp)
  return listTemp
def chiaDaThucLayNguyen_para(dathucchia_list,dathucbichia_list):
  #print("=============Chia đa thức=============")
  dathucbichia =   numpy.array(dathucbichia_list)
  dathucchia = numpy.array(dathucchia_list)
  thuong, du = numpy.polydiv(dathucchia, dathucbichia)
  #print("Thương: ", thuong)
  #print("Dư : ", du)
  return thuong
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
def congDaThuc_para(dathuc1,dathuc2):
  #print("=============Cộng đa thức=============")
  dathuc1 = numpy.array(dathuc1)
  dathuc2 = numpy.array(dathuc2)
  tong= numpy.polyadd(dathuc1, dathuc2)
  return tong
def duaListIntVeListIntChiGom0Va1BatDauLaSo1(Input):
  gapSo1LanDau=False
  while True:
    if Input[0]==1:
      break
    Input.pop(0)
  return Input
def rBang0(Input):
  for i in Input:
    if i==1:
      return False
  return True
#************************************************End General*****************************************************


#************************************************Begin Programing*****************************************************

def daThucNghichDaoG28_Algorithm(a,p):
  t=[i for i in range(0,10)]
  r=[i for i in range(0,10)]
  t[0]=0
  t[1]=1
  r[0]=p
  r[1]=a
  i=1
  while rBang0(r[i])==False:
    print("===============Vòng",i,"===============")
    r[i]=duaListIntVeListIntChiGom0Va1BatDauLaSo1(r[i])
    quotient=chuanHoaListVeListGom0va1(chiaDaThucLayNguyen_para(r[i-1],r[i]))
    print("q",i,quotient)
    r[i+1]= chuanHoaListVeListGom0va1(congDaThuc_para(chuanHoaListVeListGom0va1(nhanDaThuc_para(quotient,r[i])),r[i-1]))
    print("r[i+1]",r[i+1])
    #print(r[i+1])
    t[i+1]= chuanHoaListVeListGom0va1(congDaThuc_para(chuanHoaListVeListGom0va1(nhanDaThuc_para(quotient,t[i])),t[i-1]))
    print("t[i+1]",t[i+1])
    i=i+1; 

  print("Kết quả nghịch đảo đa thức",t[i-1])
#************************************************End Programing*****************************************************

#================================Begin Chạy====================================================
daThucNghichDaoG28_Algorithm([0,1,0,1,0,0,1,1],[1,0,0,0,1,1,0,1,1])
#================================End Chạy====================================================


