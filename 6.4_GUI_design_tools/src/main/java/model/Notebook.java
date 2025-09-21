package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Notebook {
    private final ObservableList<String> notes = FXCollections.observableArrayList();

    public ObservableList<String> getNotes() {
        return notes;
    }

    public void addNote(String title, String note) {
        String finalNote = title + ": " + note;
        notes.add(finalNote);
    }

    public void removeNote(int index){
        notes.remove(index);
    }
}