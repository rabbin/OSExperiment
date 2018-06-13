#include<unistd.h>
#include<iostream>
#include<sys/wait.h>

int main(int args,char** argv){

  pid_t pid = fork();

  wait(NULL);
  if(pid <0){

    cout<<"fork error!"<<endl;

  } else if(pid == 0){

      cout<<"This is son process 1 ,pid = "<<getpid()<<endl;
      return 0;

  }else{


      pid_t pid2= fork();
      wait(NULL);
      if(pid2 <0){

        cout<<"fork error!"<<endl;

      } else if(pid2 == 0){

        cout<<"This is son process 2 ,pid = "<<getpid()<<endl;
        return 0;
      }else{

        cout<<"This is parrent process,pid = "<<getpid()
          <<",my son process 1 pid = "<<pid
          <<",my son process 2 pid = "<<pid2<<endl;
      }

  }



  return 0;

}
