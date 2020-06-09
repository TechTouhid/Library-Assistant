module Library.Assistant {
    requires javafx.fxml;
    requires javafx.controls;
    opens library.assistant.ui.addbook;
    requires com.jfoenix;
    requires java.sql;
    requires java.desktop;
//    to solve the problem: Caused by: java.lang.IllegalAccessException
    exports library.assistant.ui.listbook to javafx.graphics, javafx.fxml;
    opens library.assistant.ui.listbook to javafx.fxml, javafx.base;

    exports library.assistant.ui.addmember to javafx.graphics, javafx.fxml;
    opens library.assistant.ui.addmember to javafx.fxml, javafx.base;
}