#include<unistd.h>
#include<iostream>
#include<vector>
#include<string>
#include<sys/wait.h>

using namespace std;
int main() {

  vector<string> argv;
  string line;

  cout << "rabbin@rshell$:";
  while (getline(cin, line)) {

    int length = line.length();
    string arg;
    arg = "";

    for (int i = 0; i< length; i++) {
      if (line[i] != ' ') {
        arg += line[i];
      }else {

        argv.push_back(arg);
        arg = "";

      }//if
    }//for

    argv.push_back(arg);
    arg = "";

    if (argv.size()== 3 && argv[0] == "max") {

      cout << "max(" << argv[1] << "," << argv[2]<<")= ";

      pid_t pid = fork();
      wait(NULL);
      if(pid ==0 ){

        execlp("/home/rabbin/os1/rshell/max.exe", "./max.exe", argv[1].data(), argv[2].data(), NULL);
      
      }


    }else if (argv.size() == 3 && argv[0] == "min") {

      cout << "min(" << argv[1] << "," << argv[2] << ")= ";

      pid_t pid = fork();
      wait(NULL);
      if(pid ==0 ){

        execlp("/home/rabbin/os1/rshell/min.exe", "./mix.exe", argv[1].data(), argv[2].data(), NULL);
      
      }

    }else if (argv.size() == 4 && argv[0] == "average") {

      cout << "average(" << argv[1] << " " << argv[2] << " " << argv[3] << ")= ";

      pid_t pid = fork();
      wait(NULL);
      if(pid ==0 ){

        execlp("/home/rabbin/os1/rshell/average.exe", "./average.exe",
             argv[1].data(), argv[2].data(),argv[3].data(), NULL);
      
      }

    }else if (argv.size() == 1 && argv[0] == "q") {

      return 0;

    }else if(argv.size() == 1 && argv[0] ==""){

    }else{

      cout << "error command!" << endl;

    }

    argv.clear();
    cout << "rabbin@rshell$:";

  }//while

}//main
