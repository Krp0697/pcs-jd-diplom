import java.util.List;

public interface SearchEngine {

    List<PageEntry> search(String word);

    String listToJson(List<PageEntry> list);
}
