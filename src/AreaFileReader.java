import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AreaFileReader {
    private String fileName;

    public AreaFileReader(String fileName) {
        this.fileName = fileName;
    }

    public List<SearchArea>     returnAllContent() throws IOException {
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<SearchArea> saList = new ArrayList<SearchArea>();
        String aux;
        int code = 1;

        while ((aux = br.readLine()) != null){
            String[] numbers = aux.split(" ");
            SearchArea sa = new SearchArea(code);
            int connectionCode = code;
            //Make file connections
            for(String number : numbers){
                if(!number.equals("")){
                    int connectionValue = Integer.parseInt(number);
                    sa.connectWith(connectionCode, connectionValue);
                    connectionCode++;
                }
            }
            //Make past connections
            for(SearchArea area : saList){
                if(area.isConnected(code)){
                    sa.connectWith(area.getCode(), area.getConnectionValue(code));
                }
            }
            saList.add(sa);
            code++;
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
