package controller;

import model.Dictionary;
import view.DictionaryView;

public class DictionaryController {
    private DictionaryView view;
    private Dictionary dictionary = new Dictionary();

    public DictionaryController(DictionaryView view){
        this.view = view;
    }

    public void search(String word){
        String result = dictionary.getMeaning(word);
        view.setResult(result);
    }

    public String words(){
        String wordsString = String.join(", ", dictionary.getWords());
        return wordsString;
    }
}
