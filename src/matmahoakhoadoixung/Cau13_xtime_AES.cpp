#include<iostream>
#include<math.h>
#include<string> 
#include<stdlib.h>
#include<string.h>
#include<conio.h>
#include <sstream>
using namespace std;
void chuoiSoMuChuyenThanhChuoiNhiPhan();
typedef struct tagnode
{
    int heso,somu;
    struct tagnode *next,*pre;
}node;
node *taonode(int heso,int somu)
{
    node *p=new node;
    if(p==NULL) exit(1);
    p->heso=heso;
    p->somu=somu;
    p->next=p->pre=NULL;
    return p;
}
typedef struct tagdathuc
{
    node*dau,*cuoi;
}dathuc;
void taodathuc(dathuc &l)
{
    l.dau=l.cuoi=NULL;
}
string numToString(int k) {  
  stringstream ss;  
  ss<<k;  
  string s;  
  ss>>s;  
  //cout<<"\n"<<"An integer value is : "<<k<<"\n";  
  return s;  
}  
void themcuoi(dathuc &l,node *p)
{
    if(l.dau==NULL) l.dau=l.cuoi=p;
    else
    {
        l.cuoi->next=p;
        p->pre=l.cuoi;
        l.cuoi=p;
    }
}
void nhap(dathuc &l)
{
    node *p;
    float heso,somu;
    cout<<"nhap so da thuc, ket thuc khi nhap he so = 0\n";
    do{
        cout<<"he so = ";cin>>heso;
        if(heso!=0)
        {
            cout<<"so mu = ";cin>>somu;
            p=taonode(heso,somu);
            themcuoi(l,p);
        }
        cout<<endl;
    }while(heso!=0);
}
void khoiTao();
string chuoiLuuSoMuCuaKetQuaNhan;
string chuoibindauvao1;
string chuoibindauvao2;
string chuoinhiphandathucbatquy,chuoiLuuSoMuCuaSoDu;
string chuoiNhiPhanBieuDienSoMuKetQuaNhan;
string chuoiNhiPhanBieuDienSoMuKetSoDu;
string chuoiLuuSoMuCuaKetQuaCong;
string chuoiNhiPhanBieuDienSoMuKetQuaCong;
dathuc l1,l2,lnhan,lbatkhaquy,du,lketquanhandarutgon,lcong,lketquacongdarutgon;
node *p1,*p2,*pbatquy,*pketquanhandarutgon,*pketquacongdarutgon;
void xuat(dathuc l)
{
    node *p=l.dau;
    if(p==NULL)
    {
        cout<<0;
        return;
    }
    while(p!=NULL)
    {
        if(p==l.dau)
        {
            if(p->somu==0) cout<<p->heso; 
            else if(fabs(p->heso)!=1 && p->somu!=1) cout<<p->heso<<"X^"<<p->somu;
            else if(fabs(p->heso)!=1 && p->somu==1) cout<<p->heso<<"X";
            else if(fabs(p->heso)==1 && p->somu!=1) cout<<(p->heso==1?"X^":"-X^")<<p->somu;
            else cout<<(p->heso==1?"X":"-X");
            
        }
        else
        {
            if(p->somu==0) cout<<(p->heso<0?" - ":" + ")<<fabs(p->heso);
            else if(fabs(p->heso)!=1 && p->somu!=1) cout<<(p->heso<0?" - ":" + ")<<fabs(p->heso)<<"X^"<<p->somu;
            else if(fabs(p->heso)!=1 && p->somu==1) cout<<(p->heso<0?" - ":" + ")<<fabs(p->heso)<<"X";
            else if(fabs(p->heso)==1 && p->somu!=1) cout<<(p->heso==1?" + X^":" - X^")<<p->somu;
            else cout<<(p->heso==1?" + X":" - X");
           
        }
        p=p->next;
    }
    
}
/*void luuSoMuCuaKetQuaNhan(dathuc l)
{
    node *p=l.dau;
    if(p==NULL)
    {
        cout<<0;
        return;
    }
    while(p!=NULL)
    {
        if(p==l.dau)
        {
            chuoiLuuSoMuCuaKetQuaNhan+=numToString(p->somu)+"#";
        }
        else
        {

            chuoiLuuSoMuCuaKetQuaNhan+=numToString(p->somu)+"#";
        }
        p=p->next;
    }
    cout<<"TEMP: "<<chuoiLuuSoMuCuaKetQuaNhan;
}*/
void luuKetQuaCuaPhepNhanLoaiBoSoDaThucCoHeSoLa2(dathuc l)
{
    node *p=l.dau;
    if(p==NULL)
    {
        cout<<0;
        return;
    }
    while(p!=NULL)
    {
        if(p==l.dau)
        {
            chuoiLuuSoMuCuaKetQuaNhan+=numToString(p->somu)+"#";
        }
        else
        {

            chuoiLuuSoMuCuaKetQuaNhan+=numToString(p->somu)+"#";
        }
        p=p->next;
    }
    //cout<<"TEMP: "<<chuoiLuuSoMuCuaKetQuaNhan;
}
void sapxep(dathuc &l)
{
    node *p1=l.dau,*p2;
    while(p1!=NULL)
    {
        p2=p1->next;
        while(p2!=NULL)
        {
            if(p2->somu>p1->somu)
            {
                swap(p1->heso,p2->heso);
                swap(p1->somu,p2->somu);
            }
            p2=p2->next;
        }
        p1=p1->next;
    }
}
void xoatruocQ(dathuc &l,node *Q)
{
    node *p;
    if(Q==NULL)
    {
        p=l.cuoi;
        if(l.dau==l.cuoi)
        {
            l.dau=l.cuoi=NULL;
            delete p;
        }
        else if(p!=NULL)
        {
            l.cuoi=l.cuoi->pre;
            l.cuoi->next=NULL;
            delete p;
        }
    }
    else
    {
        p=Q->pre;
        if(p!=NULL)
        {
            if(p==l.dau)
            {
                l.dau=l.dau->next;
                l.dau->pre=NULL;
                delete p;
            }
            else
            {
                p->pre->next=Q;
                Q->pre=p->pre;
                delete p;
            }
        }
    }
}
void rutgon(dathuc &l)
{
    node *p1=l.dau,*p2;
    while(p1!=NULL)
    {
        p2=p1->next;
        while(p2!=NULL)
        {
            if(p2->somu==p1->somu)
            {
                p1->heso+=p2->heso;
                p2=p2->next;
                xoatruocQ(l,p2);
            }
            else p2=p2->next;
        }
        p1=p1->next;
    }
}
void themtruocQ(dathuc &l,node *Q,node *p)
{
    if(Q==l.dau)
    {
        l.dau->pre=p;
        p->next=l.dau;
        l.dau=p;
    }
    else
    {
        p->pre=Q->pre;
        p->next=Q;
        Q->pre->next=p;
        Q->pre=p;
    }
}
void insert(dathuc &l,node *p)
{
    node *p1=l.dau;
    while(p1!=NULL && p1->somu > p->somu) p1=p1->next;
    if(p1!=NULL)
    {
        if(p1->somu == p->somu) p1->heso += p->heso;
        else themtruocQ(l,p1,p);
    }
    else themcuoi(l,p);
}
void xuly(dathuc &l)
{
    node *p=l.dau;
    while(p!=NULL)
    {
        if(p->heso==0)
        {
            p=p->next;
            xoatruocQ(l,p);
        }
        else p=p->next;
    }
}
int cong(dathuc l1,dathuc l2,dathuc &l)
{
    node *p=l1.dau,*a;
    while(p!=NULL)
    {
        a=taonode(p->heso,p->somu);
        themcuoi(l,a);
        p=p->next;
    }
    p=l2.dau;
    while(p!=NULL)
    {
        a=taonode(p->heso,p->somu);
        insert(l,a);
        xuly(l);
        p=p->next;
    }
    xuly(l);
    if(l.dau==NULL) return 0;
    return 1;
}
int tru(dathuc l1,dathuc l2,dathuc &l)
{
    node *p=l2.dau;
    while(p!=NULL)
    {
        p->heso=-p->heso;
        p=p->next;
    }
    cong(l1,l2,l);
    p=l2.dau;
    while(p!=NULL)
    {
        p->heso=-p->heso;
        p=p->next;
    }
    if(l.dau==NULL) return 0;
    return 1;
}
int nhan(dathuc l1,dathuc l2,dathuc &l)
{
    node *p,*p1,*p2;
    p2=l2.dau;
    while(p2!=NULL)
    {
        p1=l1.dau;
        while(p1!=NULL)
        {
            p=taonode(p2->heso*p1->heso,p2->somu+p1->somu);
            insert(l,p);
            p1=p1->next;
        }
        p2=p2->next;
    }
    xuly(l);
    if(l.dau==NULL) return 0;
    return 1;
}
void xoacuoi(dathuc &l)
{
    node *p=l.cuoi;
    if(p==NULL) exit(1);
    if(l.dau==l.cuoi)
    {
        l.dau=l.cuoi=NULL;
        delete p;
    }
    else
    {
        l.cuoi=p->pre;
        l.cuoi->next=NULL;
        delete p;
    }
}
void xoa(dathuc &l)
{
    while(l.dau!=NULL) xoacuoi(l);
}
void chia(dathuc l1,dathuc l2)
{
    node *p,*p1;
    dathuc a,b;
    taodathuc(a);taodathuc(b);taodathuc(du);
    p1=l1.dau;
    while(p1!=NULL)
    {
        p=taonode(p1->heso,p1->somu);
        themcuoi(du,p);
        p1=p1->next;
    }
    while(du.dau!=NULL && du.dau->somu >= l2.dau->somu)
    {
        p=taonode(du.dau->heso / l2.dau->heso,du.dau->somu - l2.dau->somu);
        themcuoi(a,p);
        xoa(b);
        if(nhan(l2,a,b)==0) break;
        xoa(du);
        if(tru(l1,b,du)==0) break;
    }
    cout<<"\nthuong: ";
    xuat(a);
    if(du.dau!=NULL)
    {
        cout<<"\ndu: ";
        xuat(du);
    }
}
string hexToBin(string hex)
{
	if(hex.compare("0")==0) return"0000";
	if(hex.compare("1")==0) return"0001";
	if(hex.compare("2")==0) return"0010";
	if(hex.compare("3")==0) return"0011";
	if(hex.compare("4")==0) return"0100";
	if(hex.compare("5")==0) return"0101";
	if(hex.compare("6")==0) return"0110";
	if(hex.compare("7")==0) return"0111";
	if(hex.compare("8")==0) return"1000";
	if(hex.compare("9")==0) return"1001";
	if(hex.compare("A")==0) return"1010";
	if(hex.compare("B")==0) return"1011";
	if(hex.compare("C")==0) return"1100";
	if(hex.compare("D")==0) return"1101";
	if(hex.compare("E")==0) return"1110";
	if(hex.compare("F")==0) return"1111";
}




string dangDaThucCuaChuoiBit(string chuoiBit)
{
	string chuoidathuc;
	for(int i=chuoiBit.length();i>=0;i--)
	{
		if(chuoiBit[chuoiBit.length()-i-1]=='1')
		{
	    if(i==0) chuoidathuc=chuoidathuc+"1";
	    else  chuoidathuc=chuoidathuc+"x^"+numToString(i);
		if(i!=0) chuoidathuc+="+";
		}
		//cout<<chuoiBit[i];
	}
	return chuoidathuc;
}

void nhap2DauVaoHexa()
{
  string hex;
  printf("Nhap bo hexa 1: ");cin >> hex;
  string bin1 = hexToBin(hex.substr(0,1));
  string bin2 = hexToBin(hex.substr(1,1));
  chuoibindauvao1=bin1+bin2;
  cout << (chuoibindauvao1) <<endl;
  cout<<dangDaThucCuaChuoiBit(chuoibindauvao1)<<endl;
  
  
  printf("Nhap bo hexa 2: ");cin >> hex;
  string bin3 = hexToBin(hex.substr(0,1));
  string bin4 = hexToBin(hex.substr(1,1));
  chuoibindauvao2=bin3+bin4;
  cout << (chuoibindauvao2) <<endl;
  cout<<dangDaThucCuaChuoiBit(chuoibindauvao2)<<endl;
}

void chuanHoaDaThucLuuTruHeSoOConTro()
{
	for(int i=0;i<8;i++)
	{
	if(chuoibindauvao1[i]=='1')	
	{
    //cout << 7-i;
	p1=taonode(1,7-i);
    themcuoi(l1,p1);
	}	
	}
	cout <<endl;
	for(int i=0;i<8;i++)
	{
	if(chuoibindauvao2[i]=='1')	
	{
	//cout << 7-i;	
	p2=taonode(1,7-i);
    themcuoi(l2,p2);
	}	
	}
}
void chuanHoaDaThucBatQuyLuuTruHeSoOConTro()
{
	//cout<<dangDaThucCuaChuoiBit(chuoinhiphandathucbatquy)<<endl;
	for(int i=0;i<9;i++)
	{
	if(chuoinhiphandathucbatquy[i]=='1')	
	{
	pbatquy=taonode(1,9-i-1);
    themcuoi(lbatkhaquy,pbatquy);
	}	
	}
}
int chuThanhSo(string chu)
{

    // object from the class stringstream
    stringstream geek(chu);
 
    // The object has the value 12345 and stream
    // it to the integer x
    int x = 0;
    geek >> x;
 
    // Now the variable x holds the value 12345
    //cout << "Value of x : " << x+5;
 
    return x;
}
  
void splitNhan(string str, string delimiter){
    size_t pos1 = 0;
    string token;
    while ((pos1 = str.find(delimiter)) != string::npos) {
        token = str.substr(0, pos1);
       // cout << chuThanhSo(token) << endl;
        pketquanhandarutgon=taonode(1,chuThanhSo(token));
        themcuoi(lketquanhandarutgon,pketquanhandarutgon);
        str.erase(0, pos1 + delimiter.length());
    }
}   
void splitCong(string str, string delimiter){
    size_t pos2 = 0;
    string token;
    while ((pos2 = str.find(delimiter)) != string::npos) {
        token = str.substr(0, pos2);
       // cout << chuThanhSo(token) << endl;
        pketquacongdarutgon=taonode(1,chuThanhSo(token));
        themcuoi(lketquacongdarutgon,pketquacongdarutgon);
        str.erase(0, pos2 + delimiter.length());
    }
}     

void layChuoiLuuSoMuCuaKetQuaNhanDaLoaiBoDaThucCoHeSoLa2()
{
	node *p=lnhan.dau;
    if(p==NULL)
    {
        cout<<0;
        return ;
    }
    while(p!=NULL)
    {
        if(p==lnhan.dau&&p->heso!=2)
        {
            chuoiLuuSoMuCuaKetQuaNhan+=numToString(p->somu)+"#";
        }
        else if(p->heso!=2)
        {
            
            chuoiLuuSoMuCuaKetQuaNhan+=numToString(p->somu)+"#";
        }
        p=p->next;
    }
    cout<<endl;
}
void layChuoiLuuSoMuCuaKetQuaCongDaLoaiBoDaThucCoHeSoLa2()
{
	node *p=lcong.dau;
    if(p==NULL)
    {
        cout<<0;
        return ;
    }
    while(p!=NULL)
    {
        if(p==lcong.dau&&p->heso!=2)
        {
            chuoiLuuSoMuCuaKetQuaCong+=numToString(p->somu)+"#";
        }
        else if(p->heso!=2)
        {
            
            chuoiLuuSoMuCuaKetQuaCong+=numToString(p->somu)+"#";
        }
        p=p->next;
    }
    cout<<endl;
}

void layChuoiLuuSoMuCuaSoDu()
{
	node *p=du.dau;
    if(p==NULL)
    {
        cout<<0;
        return ;
    }
    while(p!=NULL)
    {
        if(p==lnhan.dau&&p->heso!=2)
        {
            chuoiLuuSoMuCuaSoDu+=numToString(p->somu)+"#";
        }
        else if(p->heso!=2)
        {
            
            chuoiLuuSoMuCuaSoDu+=numToString(p->somu)+"#";
        }
        p=p->next;
    }
    cout<<endl;
    
    
}

string chuyenChuoiLuuSoMuThanhChuoiNhiPhan(string str,string delimiter)
{
	string chuoiNhiPhan="00000000";
	size_t pos = 0;
    string token;
    while ((pos = str.find(delimiter)) != string::npos) {
        token = str.substr(0, pos);
       // cout << chuThanhSo(token) << endl;
       chuoiNhiPhan[7-chuThanhSo(token)]='1';
        str.erase(0, pos + delimiter.length());
    }
    return chuoiNhiPhan;
}
void khoiTao()
{
chuoinhiphandathucbatquy="100011011";
chuanHoaDaThucBatQuyLuuTruHeSoOConTro();
cout<<"Da thuc bat kha quy"<<endl;
xuat(lbatkhaquy);cout<<"(1)"<<endl;
chuanHoaDaThucLuuTruHeSoOConTro();	
}
void nhan2DaThuc()
{

nhan(l1,l2,lnhan);
cout<<"Chuoi Nhan 2 da thuc dau vao: "<<endl;
xuat(lnhan);
layChuoiLuuSoMuCuaKetQuaNhanDaLoaiBoDaThucCoHeSoLa2();
cout<<"Chuoi Luu Rut Gon Ket Qua Nhan: "<<endl;
splitNhan(chuoiLuuSoMuCuaKetQuaNhan,"#");
xuat(lketquanhandarutgon);cout<<"(2)"<<endl;
cout<<endl;
cout<<"Ket qua phep chia da thuc: (2) cho (1)"<<endl;
chia(lketquanhandarutgon,lbatkhaquy);
layChuoiLuuSoMuCuaSoDu();
splitCong(chuoiLuuSoMuCuaSoDu,"#");
cout<<"Chuoi Luu So Mu Ket Qua So Du: "<<chuoiLuuSoMuCuaSoDu<<endl;
chuoiNhiPhanBieuDienSoMuKetSoDu=chuyenChuoiLuuSoMuThanhChuoiNhiPhan(chuoiLuuSoMuCuaSoDu,"#");
cout<<"\n\nChuoi Ket Qua Nhi Phan Thuc Hien Nhan 2 Hex Dau Vao "<<endl;
cout<<"=>"<<chuoiNhiPhanBieuDienSoMuKetSoDu<<endl;
}
void cong2DaThuc()
{
cong(l1,l2,lcong);
cout<<"Chuoi cong 2 da thuc dau vao: "<<endl;
xuat(lcong);
layChuoiLuuSoMuCuaKetQuaCongDaLoaiBoDaThucCoHeSoLa2();
cout<<"Chuoi Luu Rut Gon Ket Qua Cong: "<<endl;
cout<<chuoiLuuSoMuCuaKetQuaCong<<endl;
splitCong(chuoiLuuSoMuCuaKetQuaCong,"#");
xuat(lketquacongdarutgon);cout<<"(3)"<<endl;
chuoiNhiPhanBieuDienSoMuKetQuaCong=chuyenChuoiLuuSoMuThanhChuoiNhiPhan(chuoiLuuSoMuCuaKetQuaCong,"#");
cout<<"Chuoi Ket Qua Nhi Phan Thuc Hien Cong 2 Hex Dau Vao "<<endl;
cout<<"=>"<<chuoiNhiPhanBieuDienSoMuKetQuaCong<<endl;

}
int main()
{
	nhap2DauVaoHexa();
	khoiTao();
	cong2DaThuc();
	cout<<"\n\n";
    nhan2DaThuc();

}
