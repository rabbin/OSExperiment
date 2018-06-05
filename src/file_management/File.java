package file_management;

import java.util.LinkedList;

public class File {
    String name;
    double size;

    public File(String name, double size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return ""+name+
                "\t"+size+"\t";
    }

    LinkedList<Integer> blockList = new LinkedList<>();
}
