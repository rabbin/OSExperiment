package file_management;

public class Main {
    public static void main(String[] args){

        FileSystem fileSystem = new FileSystem();


        System.out.println("创建50个文件：");
        for(int i = 0 ;i< 50 ;i++){
            int size = (int)(Math.random()*8)+2;
            fileSystem.saveFile(new File(String.valueOf(i)+".txt", size));
        }
        fileSystem.printBitMapInfo();

        System.out.println("删除奇数文件：");
        for(int i =1 ;i < 50; i+=2){
            fileSystem.deleteFile(String.valueOf(i)+".txt");
        }
        fileSystem.printBitMapInfo();


        System.out.println("创建ABCDE文件：");
        fileSystem.saveFile(new File("A.txt",7));
        fileSystem.saveFile(new File("B.txt",5));
        fileSystem.saveFile(new File("C.txt",2));
        fileSystem.saveFile(new File("D.txt",7));
        fileSystem.saveFile(new File("E.txt",3.5));

        fileSystem.getFileInfo("A.txt");
        fileSystem.getFileInfo("B.txt");
        fileSystem.getFileInfo("C.txt");
        fileSystem.getFileInfo("D.txt");
        fileSystem.getFileInfo("E.txt");

        fileSystem.printBitMapInfo();

        fileSystem.listFiles();
    }
}
