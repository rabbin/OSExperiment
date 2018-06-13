#include<unistd.h>
#include<iostream>
#include<sys/wait.h>

int main(int args,char** argv){

  pid_t pid = fork();
  wait(NULL);

  if(pid <0){

    cout<<"fork error!"<<endl;

  } else if(pid == 0){

    pid_t pid2 = fork();
    wait(NULL);
    
    if(pid2 ==0){

      cout<<"This is grandson process ,pid = "<<getpid()<<endl;
      exit(0);

    }else if(pid2 > 0){

      cout<<"This is son process, pid = "<<getpid()
          <<",my son process pid = "<<pid2<<endl;
      exit(0);

    }else{
      
      cout<<"fork error!"<<endl;

     }
  }else{

    cout<<"This is parent process,pid = "<<getpid()
        <<",my son process pid = "<<pid<<endl;

  }

  return 0;

}
