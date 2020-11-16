import java.io.IOException;

public class Main {
    public static final String FILE_DIRECTORY_NAME = "bin/";
    public static final String FILE_NAME = FILE_DIRECTORY_NAME + "students.txt";

    public static void main(String[] args) throws IOException {
        StudentFileReader sfr = new StudentFileReader(FILE_NAME);
        String result = sfr.returnAllContent();
        System.out.println(result);
    }
}
