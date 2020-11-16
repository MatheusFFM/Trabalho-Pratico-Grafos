import java.io.IOException;
import java.util.List;

public class Main {
    public static final String FILE_DIRECTORY_NAME = "bin/";
    public static final String FILE_NAME_STUDENTS = FILE_DIRECTORY_NAME + "students.txt";
    public static final String FILE_NAME_AREA = FILE_DIRECTORY_NAME + "dissimilarity.txt";

    public static void main(String[] args) throws IOException {
        StudentFileReader sfr = new StudentFileReader(FILE_NAME_STUDENTS);
        AreaFileReader afr = new AreaFileReader(FILE_NAME_AREA);
        List<SearchArea> lsa = afr.returnAllContent();
    }
}
