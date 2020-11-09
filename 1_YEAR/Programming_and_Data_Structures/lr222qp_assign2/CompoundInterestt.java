


import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class CompoundInterestt extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage compI) {
        compI.setTitle("Compound Interest");

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.4));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        Label title = new Label("Compound Interest");
        title.setFont(Font.font(25.0));
        pane.add(title, 0, 0, 2, 1);// column row

        pane.add(new Label("Start amount:"), 0, 1);
        final TextField SA = new TextField();
        pane.add(SA, 1, 1);

        pane.add(new Label("Interest:"), 0, 2);
        final TextField Interest = new TextField();
        pane.add(Interest, 1, 2);

        pane.add(new Label("Number of Years:"), 0, 3);
        final TextField NY = new TextField();
        pane.add(NY, 1, 3);

        Button testCal = new Button("Calculate");
        pane.add(testCal, 0, 4);
        GridPane.setHalignment(testCal, HPos.LEFT);

        Label print = new Label();
        pane.add(print, 0, 5,2,1);

        testCal.setOnAction(e -> {
            if (SA.getText().isEmpty() || Interest.getText().isEmpty() || NY.getText().isEmpty()) {
                print.setText("Make sure every blank space is furfilled");
            } else {
                try {
                    double StartA = Double.valueOf(SA.getText());
                    double Inte = Double.valueOf(Interest.getText()) / 100;
                    double NumbY = Double.valueOf(NY.getText());
                    double result = StartA * Math.pow((1 + Inte), NumbY);
                    print.setText("In total will be " + result);
                } catch (NumberFormatException nfe) {
                    print.setText("Please enter numbers");
                }
            }
        });
        Scene scene = new Scene(pane);
        compI.setScene(scene);
        compI.show();
    }
}
