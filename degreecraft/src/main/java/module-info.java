module gitaddmoney {
    requires javafx.controls;
    requires javafx.fxml;

    opens gitaddmoney to javafx.fxml;
    exports gitaddmoney;

    opens controllers to javafx.fxml;
    exports controllers;

    opens model to javafx.html;
    exports model;
}
