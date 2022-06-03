package controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class Helper {
    private Stage stage;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public abstract void back(ActionEvent event) throws IOException;
}
