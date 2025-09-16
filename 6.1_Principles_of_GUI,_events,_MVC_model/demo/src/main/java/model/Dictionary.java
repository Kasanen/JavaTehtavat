package model;
import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> dictionary;

    public Dictionary(){
        this.dictionary = new HashMap<>();
        addWord("apple", "A fruit that is red or green.");
        addWord("banana", "A long yellow fruit.");
        addWord("cat", "A small domesticated carnivorous mammal.");

    }
    
    public void addWord(String word, String meaning){
        dictionary.put(word, meaning);
    }

    public String getMeaning(String word) {
        String meaning = dictionary.get(word);
        if (meaning == null) {
            return "Word not found.";
        }
        return meaning;
    }

    public java.util.Set<String> getWords() {
        return dictionary.keySet();
    }
}
