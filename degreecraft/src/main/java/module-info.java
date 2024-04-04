module gitaddmoney {
    requires javafx.controls;
    requires javafx.fxml;

    opens gitaddmoney to javafx.fxml;
    exports gitaddmoney;
}
