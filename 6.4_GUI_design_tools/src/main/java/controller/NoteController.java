package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Notebook;
import view.ProjectView;

public class NoteController {

    @FXML
    private ListView<String> noteList;

    private Notebook notebook;

    @FXML
    private TextArea note;

    @FXML
    private TextField title;

    @FXML
    private void updateNotebook(MouseEvent event) {
        if (notebook == null) {
            notebook = new Notebook();
            noteList.setItems(notebook.getNotes());
        }

        String titleText = title.getText();
        String noteText = note.getText();

        notebook.addNote(titleText, noteText);
    }

    @FXML
    private void deleteSelected(MouseEvent event) {
        System.out.println("Button DELETE");
        int selectedIndex = noteList.getSelectionModel().getSelectedIndex();
        notebook.removeNote(selectedIndex);
    }

    @FXML
    private void editSelected(MouseEvent event) {
        System.out.println("Button EDIT");
        int selectedIndex = noteList.getSelectionModel().getSelectedIndex();
        String item = noteList.getSelectionModel().getSelectedItem();

        // Tekstin jako : jälkeen
        if (item != null) {
            int separatorIndex = item.indexOf(": ");
            title.setText(item.substring(0, separatorIndex));
            note.setText(item.substring(separatorIndex + 2));
            notebook.removeNote(selectedIndex);
        }
    }

    public static void main(String[] args) {
        ProjectView.launch(ProjectView.class);
    }
}
