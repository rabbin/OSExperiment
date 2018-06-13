package file_management;

import java.util.LinkedList;

public class FileSystem {
    private static final int blockSize = 2;
    private static final int blockNum = 500;
    private static final int row = 20;
    private static final int col = 25;
    private int[][] bitMap = new int[row][col];

    private LinkedList<File> fileList = new LinkedList<>();

    public FileSystem() {
        for (int i = 0; i < row; i++){
            for (int j = 0; j< col ;j++){
                bitMap[i][j] = 0;
            }
        }
    }


    void getFileInfo(String fileName){
        System.out.println("name\tsize\tblock info");

        int flag = 0;
        for(File file : fileList){
            if (file.name.equals(fileName)){
                flag = 1;
                System.out.print(file+"\t");
                for(Integer integer:file.blockList){
                    System.out.print(integer+" ");
                }
                break;
            }
        }
        System.out.println();
        if (flag==0){
            System.out.println("file not exists!");
        }

    }
    void listFiles(){
        System.out.println("name\tsize\tblock info");
        for(File file : fileList){
            System.out.print(file+"\t");
            for(Integer integer:file.blockList){
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }

    void printBitMapInfo() {

        int bitMapCopy[][] = new int[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j< col ;j++){
                bitMapCopy[i][j] = 0;
            }
        }

        int size = fileList.size();

        for (int m = 0, flag = 0;m<size;m++){
            File file = fileList.get(m);
            for(Integer integer:file.blockList){
                int i = integer/col;
                int j = integer%col;
                bitMapCopy[i][j] = flag;
            }
            flag= (flag+1)%2;
        }


        for (int i = 0; i < row; i++){
            for (int j = 0; j< col ;j++){
                if(bitMap[i][j]==0){
                    System.out.printf("\033[1;32m%d\033[0m\t",0);
                }else{
                    System.out.printf("\033[1;%dm1\033[0m\t",35+bitMapCopy[i][j]);
                }
            }
            System.out.println();
        }
    }

    void deleteFile(String fileName){
        int flag = 0;
        for(File file : fileList){
            if (file.name.equals(fileName)){
                fileList.remove(file);
                flag = 1;
                for(Integer integer:file.blockList){
                    int i = integer/col;
                    int j = integer%col;
                    bitMap[i][j] = 0;
                }
                break;
            }
        }
        if (flag==0){
            System.out.println("file not exists!");
        }

    }

    void  saveFile(File file){
        fileList.add(file);

        int len = (int)((file.size+0.5)/blockSize+1);
        for (int i = 0; i < row && len>0; i++){
            for (int j = 0; j< col && len >0 ;j++){
                if(bitMap[i][j] == 0){
                    file.blockList.add(i*col+j);
                    bitMap[i][j] = 1;
                    len--;

                }
            }
        }
        if(len >0 ){
            System.out.println("空间不足！");
        }

    }
}


