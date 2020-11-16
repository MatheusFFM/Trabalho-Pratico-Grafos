import java.util.HashMap;
import java.util.Map;

public class SearchArea {
    private int code;
    private Map<Integer, Integer> dissimilarity;

    public SearchArea(int code) {
        this.code = code;
        dissimilarity = new HashMap<Integer, Integer>();
    }

    public Integer createDissimilarity(int code, int value){
        return dissimilarity.put(code, value);
    }

    @Override
    public String toString(){
        return "Search Area: " + code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Map<Integer, Integer> getDissimilarity() {
        return dissimilarity;
    }

}
