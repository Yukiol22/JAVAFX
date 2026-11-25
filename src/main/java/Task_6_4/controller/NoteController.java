package Task_6_4.controller;

import Task_6_4.model.Note;
import Task_6_4.model.Notebook;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NoteController {

    @FXML
    private TextField titleField;

    @FXML
    private TextArea contentArea;

    @FXML
    private ListView<Note> notesList;

    @FXML
    private Label messageLabel;

    private Notebook notebook = new Notebook();

    @FXML
    private void addNote() {
        String title = titleField.getText();
        String content = contentArea.getText();

        if (title.isEmpty() || content.isEmpty()) {
            messageLabel.setText("Please write a title and a note first.");
            return;
        }

        notebook.addNote(new Note(title, content));
        showNotes();
        clearFields();
        messageLabel.setText("Note added.");
    }

    @FXML
    private void selectNote() {
        Note selected = notesList.getSelectionModel().getSelectedItem();

        if (selected != null) {
            titleField.setText(selected.getTitle());
            contentArea.setText(selected.getContent());
        }
    }

    @FXML
    private void updateNote() {
        Note selected = notesList.getSelectionModel().getSelectedItem();

        if (selected == null) {
            messageLabel.setText("Select a note from the list first.");
            return;
        }

        selected.setTitle(titleField.getText());
        selected.setContent(contentArea.getText());
        showNotes();
        clearFields();
        messageLabel.setText("Note updated.");
    }

    @FXML
    private void deleteNote() {
        Note selected = notesList.getSelectionModel().getSelectedItem();

        if (selected == null) {
            messageLabel.setText("Select a note from the list first.");
            return;
        }

        notebook.removeNote(selected);
        showNotes();
        clearFields();
        messageLabel.setText("Note deleted.");
    }

    private void showNotes() {
        notesList.getItems().setAll(notebook.getNotes());
    }

    private void clearFields() {
        titleField.setText("");
        contentArea.setText("");
    }
}