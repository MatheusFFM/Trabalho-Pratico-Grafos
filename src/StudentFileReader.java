import java.io.*;

public class StudentFileReader {
    private String fileName;

    StudentFileReader(String fileName){
        this.fileName = fileName;
    }

    public String returnAllContent() throws IOException {
        File file = new File(fileName);
        StringBuilder resultSB = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String aux;

        while ((aux = br.readLine()) != null){
            resultSB.append(aux);
        }

        return resultSB.toString();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
