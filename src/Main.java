import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static final String FILE_DIRECTORY_NAME = "bin/";
    public static final String FILE_NAME_STUDENTS = FILE_DIRECTORY_NAME + "students.txt";
    public static final String FILE_NAME_AREA = FILE_DIRECTORY_NAME + "dissimilarity.txt";
    private static final Scanner read = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        StudentFileReader sfr = new StudentFileReader(FILE_NAME_STUDENTS);
        List<Student> lst = sfr.returnAllContent();
        AreaFileReader afr = new AreaFileReader(FILE_NAME_AREA);
        List<SearchArea> lsa = afr.returnAllContent();
        List<StudentEdge> edges = Student.relation(lsa, lst);
        Collections.sort(edges);

        int V = lst.size();
        int E = edges.size();
        List<Edge> mapedEdges = edges.stream().map(o -> new Edge(o.getStudent1().getCode() - 1, o.getStudent2().getCode() - 1, o.getWeight())).collect(Collectors.toList());
        Graph graph = new Graph(V, E,mapedEdges);

        graph.KruskalMST();

        int quantProf = 0;
        while (quantProf > V || quantProf <= 0) {
            System.out.print("Insira a quantidade de professores disponiveis -> ");
            quantProf = read.nextInt();
        }

        System.out.println("Arestas da AGM = " + Arrays.toString(graph.getMst()));
        System.out.println("Resultado da divisão do grupo = " + graph.getGroups(quantProf).stream().map(a -> a.stream().map(b -> b + 1).collect(Collectors.toList())).collect(Collectors.toList()));
    }
}
