import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AreaFileReader {
    private String fileName;

    public AreaFileReader(String fileName) {
        this.fileName = fileName;
    }

    public List<SearchArea> returnAllContent() throws IOException {
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<SearchArea> saList = new ArrayList<SearchArea>();
        String aux;

        while ((aux = br.readLine()) != null){
            System.out.println(aux);
            SearchArea sa = new SearchArea(1);
            saList.add(sa);
        }

        return saList;
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
