package data.management.lab2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentController {
    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, String> idColumn;
    @FXML
    private TableColumn<Student, String> nameColumn;
    @FXML
    private TableColumn<Student, String> majorColumn;
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField majorField;

    private ObservableList<Student> studentList;

    @FXML
    private void addStudent(ActionEvent event) {
        String id = idField.getText();
        String name = nameField.getText();
        String major = majorField.getText();

        if (id.isEmpty() || name.isEmpty() || major.isEmpty()) {
            // Handle the error (e.g., show an alert)
            return;
        }

        Student newStudent = new Student(id, name, major);
        studentList.add(newStudent);

        idField.clear();
        nameField.clear();
        majorField.clear();
    }

    @FXML
    private void deleteStudent(ActionEvent event) {
        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            studentList.remove(selectedStudent);
        }
    }

    @FXML
    public void initialize() {
        studentList = FXCollections.observableArrayList();

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        majorColumn.setCellValueFactory(new PropertyValueFactory<>("major"));

        studentTable.setItems(studentList);
    }
}
