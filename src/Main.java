import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static final String FILE_DIRECTORY_NAME = "bin/";
    public static final String FILE_NAME_STUDENTS = FILE_DIRECTORY_NAME + "students.txt";
    public static final String FILE_NAME_AREA = FILE_DIRECTORY_NAME + "dissimilarity.txt";

    public static void main(String[] args) throws IOException {
        StudentFileReader sfr = new StudentFileReader(FILE_NAME_STUDENTS);
        List<Student> lst = sfr.returnAllContent();
        AreaFileReader afr = new AreaFileReader(FILE_NAME_AREA);
        List<SearchArea> lsa = afr.returnAllContent();
        List<StudentEdge> edges = Student.relation(lsa, lst);
        Collections.sort(edges);
        System.out.println(edges);

        int V = lst.size();
        int E = edges.size();
        Graph graph = new Graph(V, E);

        graph.edge = edges.stream().map(o -> new Graph.Edge(o.getStudent1().getCode() - 1, o.getStudent2().getCode() - 1, o.getWeight())).collect(Collectors.toList());
        
        graph.KruskalMST();
    }
}
