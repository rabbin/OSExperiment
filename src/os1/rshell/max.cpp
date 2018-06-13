#include<iostream>
#include<cstdlib>
#include<string>

using namespace std;

int main(int args,char *argv[]){
   if(args != 3){
     cout<<"wrong number of parameters!"<<endl;
     return 0;
   }
   string a = argv[1];
   string b = argv[2]; 
   if(atoi(a.data()) > atoi(b.data())){
     cout<<atoi(a.data())<<endl;
   }else{
     cout<<atoi(b.data())<<endl;
   } 
   //cout<<"exit()"<<endl;
   return 0;
}
