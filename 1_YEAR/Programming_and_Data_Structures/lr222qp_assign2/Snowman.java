import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Snowman extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage snowM) throws Exception {
        //Big circle
        Circle BigC = new Circle(500, 600, 80);
        BigC.setFill(Color.WHITE);
        //Medium circle
        Circle MedC = new Circle(500, 475, 60);
        MedC.setFill(Color.WHITE);
        //Small
        Circle SmaC = new Circle(500, 380, 40);
        SmaC.setFill(Color.	WHITE);

        //buttons
        Circle B1 = new Circle(500, 500, 7);
        B1.setFill(Color.BLACK);
        Circle B2 = new Circle(500, 475, 7);
        B2.setFill(Color.BLACK);
        Circle B3 = new Circle(500, 450, 7);
        B3.setFill(Color.BLACK);

        //FACE
        //eyes
        Circle Eye1 = new Circle(485, 375, 5);
        Eye1.setFill(Color.BLACK);
        Circle Eye2 = new Circle(515, 375, 5);
        Eye1.setFill(Color.BLACK);
        //nose(carrot)
        Polygon nose = new Polygon();
        nose.getPoints().addAll(new Double[]{
                500.0, 385.0,
                495.0, 400.0,
                505.0, 400.0 });
        nose.setFill(Color.ORANGE);
        //mouth
        Line mouth = new Line();
        mouth.setStartX(485.0);
        mouth.setStartY(405.0);
        mouth.setEndX(515.0);
        mouth.setEndY(405.0);
        //SUN
        Circle Sun = new Circle(800, 200, 100);
        Sun.setFill(Color.YELLOW);


        Rectangle background = new Rectangle(1000,670,Color.LIGHTSKYBLUE);



        Group root = new Group();
        root.getChildren().addAll(background,BigC,MedC,SmaC,B1,B2,B3,Eye1,Eye2,nose,mouth,Sun);
        Scene scene = new Scene(root,1000,800 );
        scene.setFill(Color.WHITE);
        snowM.setScene(scene);
        snowM.setTitle("SnowMan");
        snowM.show();
    }

}