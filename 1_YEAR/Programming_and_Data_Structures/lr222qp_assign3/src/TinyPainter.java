
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class TinyPainter extends Application {

    @Override
    public void start(Stage primaryStage) {

        BorderPane bP = new BorderPane();
        HBox hB = new HBox();
        //SHAPE MENU
        VBox layout1 = new VBox();
        layout1.setPadding(new Insets(5,5,5,5));
        ComboBox<String> shape = new ComboBox<>();
        shape.getItems().addAll("Line", "Dot","Rectangle","Circle");
        shape.setValue("Choose");
        layout1.getChildren().addAll(shape);

        //SIZE MENU
        VBox layout2 = new VBox();
        layout2.setPadding(new Insets(5,5,5,5));
        layout2.setLayoutX(120);
        ComboBox<Double> size = new ComboBox<>();
        size.getItems().addAll(1.0,5.0,10.0,15.0,20.0,25.0,30.0,35.0,40.0);
        size.setValue(1.0);//Default value
        layout2.getChildren().add(size);

        //COLOR MENU
        VBox layout3 = new VBox();
        layout3.setPadding(new Insets(5,5,5,5));
        layout3.setLayoutX(210);
        ColorPicker cP = new ColorPicker(Color.BLACK);//Default color Black
        layout3.getChildren().add(cP);

        hB.getChildren().addAll(layout1,layout2,layout3);
        bP.setTop(hB);
        BorderPane.setMargin(hB,new Insets(5,5,5,5));

        Circle c = new Circle();
        Rectangle r = new Rectangle();
        Rectangle cube = new Rectangle();
        Line l = new Line();

        //DISPLAY
        Group root = new Group();
        root.getChildren().addAll(bP,c,r,l,cube);
        Scene scene = new Scene(root,600,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TinyPainter");
        primaryStage.setResizable(false);
        primaryStage.show();

        shape.setOnAction(event -> {
            if(shape.getValue().equals("Circle")){
                scene.setOnMousePressed(event1 -> {
                    c.setCenterY(event1.getY());
                    c.setCenterX(event1.getX());
                    c.setFill(cP.getValue());
                    //c.setRadius(100);
                    //System.out.println(event1.getX() + " " + event1.getY()+" "+c.getRadius());
                });
                scene.setOnMouseDragged(event1 -> {
                    if(!shape.getValue().equals("Circle")){
                        return;
                    } else {
                        c.setRadius(Math.sqrt(Math.pow(event1.getX() - c.getCenterX(),2) + Math.pow(event1.getY() - c.getCenterY(),2)));
                    }
                    event1.consume();
                });
                scene.setOnMouseClicked(event1 -> {
                    Circle c1 = new Circle(c.getCenterX(),c.getCenterY(),c.getRadius());
                    c1.setFill(cP.getValue());
                    root.getChildren().add(c1);
                });

            } else if (shape.getValue().equals("Rectangle")){
                scene.setOnMousePressed(event1 -> {
                    r.setX(event1.getX());
                    r.setY(event1.getY());
                    r.setFill(cP.getValue());
                });
                scene.setOnMouseDragged(event1 -> {
                    //System.out.println(shape.getValue());
                    if(!shape.getValue().equals("Rectangle")){
                        return;
                    } else {
                        r.setWidth(event1.getX()-r.getX());
                        r.setHeight(event1.getY()-r.getY());
                    }
                });

                scene.setOnMouseClicked(event1 -> {
                    Rectangle r1 = new Rectangle(r.getX(),r.getY(),r.getWidth(),r.getHeight());
                    r1.setFill(cP.getValue());
                    root.getChildren().add(r1);
                });

            } else if(shape.getValue().equals("Dot")){
                scene.setOnMousePressed(event1 -> {
                    cube.setX(event1.getX());
                    cube.setY(event1.getY());
                    //System.out.println(shape.getValue());
                    cube.setFill(cP.getValue());
                    cube.setWidth(size.getValue());
                    cube.setHeight(size.getValue());
                });
                scene.setOnMouseClicked(event1 -> {
                    //System.out.println(shape.getValue());
                    Rectangle cube1 = new Rectangle(cube.getX(),cube.getY(),cube.getWidth(),cube.getHeight());
                    cube1.setFill(cP.getValue());
                    root.getChildren().add(cube1);
                });

            } else if(shape.getValue().equals("Line")){
                scene.setOnMousePressed(event1 -> {
                    l.setStroke(cP.getValue());
                    l.setStrokeWidth(size.getValue());
                    l.setStartX(event1.getX());
                    l.setStartY(event1.getY());
                    l.setEndX(event1.getX());
                    l.setEndY(event1.getY());
                });
                scene.setOnMouseDragged(event1 -> {

                    if(!shape.getValue().equals("Line")){
                        return;
                    }
                    l.setEndX(event1.getX());
                    l.setEndY(event1.getY());
                });
                /*scene.setOnMouseReleased(event1 -> {
                    l.setEndX(event1.getX());
                    l.setEndY(event1.getY());
                });*/
                scene.setOnMouseClicked(event1 -> {
                    l.setEndX(event1.getX());
                    l.setEndY(event1.getY());
                    //System.out.println(shape.getValue());
                    Line l1 = new Line(l.getStartX(), l.getStartY(), l.getEndX(), l.getEndY());
                    l1.setStroke(cP.getValue());
                    l1.setStrokeWidth(size.getValue());
                    root.getChildren().add(l1);

                });
            }

        });


    }


    /*private static ComboBox<String> menu(String str){
        ComboBox<String> menuC = new ComboBox<>();
        menuC.getItems().addAll(str);
        return menuC;
    }*/


    public static void main(String[] args) {
        launch(args);
    }
}
