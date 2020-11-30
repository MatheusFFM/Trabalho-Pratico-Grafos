import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Main {
    public static final String FILE_DIRECTORY_NAME = "bin/";
    public static final String FILE_NAME_STUDENTS = FILE_DIRECTORY_NAME + "students.txt";
    public static final String FILE_NAME_AREA = FILE_DIRECTORY_NAME + "dissimilarity.txt";

    public static void main(String[] args) throws IOException {
        StudentFileReader sfr = new StudentFileReader(FILE_NAME_STUDENTS);
        List<Student> lst = sfr.returnAllContent();
        AreaFileReader afr = new AreaFileReader(FILE_NAME_AREA);
        List<SearchArea> lsa = afr.returnAllContent();
        // Uncomment for see the dissimilarity matrix
//        for(SearchArea sa : lsa){
//            System.out.println(sa + " - " + sa.getDissimilarity());
//        }
        List<StudentEdge> edges = Student.relation(lsa, lst);
        Collections.sort(edges);
        System.out.println(edges);
    }
}
