package file_management;

import java.util.LinkedList;

public class FileSystem {
    private static final int blockSize = 2;
    private static final int blockNum = 500;
    private static final int raw = 20;
    private static final int col = 25;
    private int[][] bitMap = new int[raw][col];

    private LinkedList<File> fileList = new LinkedList<>();

    public FileSystem() {
        for (int i = 0; i < raw; i++){
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
        for (int i = 0; i < raw; i++){
            for (int j = 0; j< col ;j++){
                System.out.print(bitMap[i][j]+"\t");
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

        int len = (int)((file.size+0.5)/blockSize);
        for (int i = 0; i < raw && len>0; i++){
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


