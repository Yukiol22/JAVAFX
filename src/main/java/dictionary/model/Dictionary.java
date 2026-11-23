package dictionary.model;
import java.util.*;

public class Dictionary {
        private HashMap<String, String> words = new HashMap<>();

        public void addWord(String word, String meaning) {
            words.put(word.trim().toLowerCase(), meaning);
        }

        public String search(String word) {
            return words.get(word.trim().toLowerCase());
        }
}
