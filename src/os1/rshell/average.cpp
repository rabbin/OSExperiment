#include<iostream>
#include<cstdlib>
#include<string>

using namespace std;

int main(int args,char *argv[]){
   if(args != 4){
     cout<<"wrong number of parameters!"<<endl;
     return 0;
   }
   string a = argv[1];
   string b = argv[2]; 
   string c = argv[3];

   double average = (atoi(a.data())+atoi(b.data())+atoi(c.data()))/3.0;
   cout<<average<<endl;
   return 0;
}
