import java.util.*;
import java.util.regex.Pattern;

public class MyMiniSearchEngine {
    private static Pattern text = Pattern.compile("[^\\p{Alnum}]");
    private Map<String, List<List<Integer>>> indexes= new HashMap<>();

    private MyMiniSearchEngine() {}

    public MyMiniSearchEngine(List<String> documents) {
        index(documents);
    }

    private void index(List<String> texts) {

        for (int i = 0; i < texts.size(); i++) {
            String[] words = text.split(texts.get(i));

            for (int j = 0; j < words.length; j++)
                indexes.computeIfAbsent(words[j].toLowerCase(), key -> getLOfLWithSize(texts.size())).get(i).add(j);
        }
    }

    private static List<List<Integer>> getLOfLWithSize(int size) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < size; i++)
            list.add(new ArrayList<>());
        return list;
    }

    public List<Integer> search(String keyPhrase) {
        List<List<List<Integer>>> res = new ArrayList<>();
        Set<Integer> matchingDocuments = new TreeSet<>();
        String[] words = text.split(keyPhrase);
        for (String word : words) res.add(indexes.get(word.toLowerCase()));
        if(res.get(0) == null) return new ArrayList<>();

        for (int i = 0; i < res.get(0).size(); i++) {
            List<List<Integer>> resultByDocument = new ArrayList<>();
            for (List<List<Integer>> result :res) resultByDocument.add(result.get(i));
            if(checkConsecutive(resultByDocument)) matchingDocuments.add(i);
        }
        return new ArrayList<>(matchingDocuments);
    }

    private boolean checkConsecutive(List<List<Integer>> lists) {
        List<Integer> list = lists.get(0);
        for (int a : list) {
            boolean consecutive = true;
            for (int j = 1; j < lists.size(); j++) {
                a++;
                if (!lists.get(j).contains(a)) consecutive = false;
            }
            if (consecutive) return true;
        }
        return false;
    }
}