import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import java.util.ArrayList;
import java.util.Random;

public class Yahtzee extends Application {
    private int CountRD=3;

    public Yahtzee(){

    }
    public int getCountRD(){return CountRD;}
    public void minusCountRD(){CountRD--;}
    public static void main(String[] args) {
        launch(args);
    }

    public boolean isLargeStraight(ArrayList<Integer> arr){
        int count1 =0;
        int count2=0;
        for (int i=0;i<arr.size()-1;i++){
            if(arr.get(i)>=1)
                count1++;
        }
        for(int j=1;j<arr.size();j++){
            if (arr.get(j)>=1)
                count2++;
        }
        if (count1==5||count2==5)
            return true;
        else
            return false;
    }

    public boolean isSmallStraight(ArrayList<Integer> arr){
        int count1=0;
        int count2=0;
        int count3=0;
        for(int i=0;i<=3;i++){
            if(arr.get(i)>=1)
                count1++;
        }
        for(int j=1;j<=4;j++){
            if(arr.get(j)>=1){
                count2++;
            }
        }
        for(int k=2;k<arr.size();k++){
            if(arr.get(k)>=1){
                count3++;
            }
        }
        if (count1==4 || count2==4 || count3==4)
            return true;
        else
            return false;
    }




    @Override
    public void start(Stage primaryStage) {



        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(2,2,2,2));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        //Group root = new Group();


        Image D1 = new Image(getClass().getResource("dice1.png").toExternalForm());
        ImageView D1view = new ImageView(D1);
        D1view.setPreserveRatio(true);
        D1view.setFitHeight(80);
        pane.add(D1view,0,1);

        Image D2 = new Image(getClass().getResource("dice2.png").toExternalForm());
        ImageView D2view = new ImageView(D2);
        D2view.setPreserveRatio(true);
        D2view.setFitHeight(80);
        pane.add(D2view,1,1);

        Image D3 = new Image(getClass().getResource("dice3.png").toExternalForm());
        ImageView D3view = new ImageView(D3);
        D3view.setPreserveRatio(true);
        D3view.setFitHeight(80);
        pane.add(D3view,2,1);

        Image D4 = new Image(getClass().getResource("dice4.png").toExternalForm());
        ImageView D4view = new ImageView(D4);
        D4view.setPreserveRatio(true);
        D4view.setFitHeight(80);
        pane.add(D4view,3,1);

        Image D5 = new Image(getClass().getResource("dice5.png").toExternalForm());
        ImageView D5view = new ImageView(D5);
        D5view.setPreserveRatio(true);
        D5view.setFitHeight(80);
        pane.add(D5view,4,1);

        Image D6 = new Image(getClass().getResource("dice6.png").toExternalForm());
        ImageView D6view = new ImageView(D6);
        D6view.setPreserveRatio(true);
        D6view.setFitHeight(80);

        ImageView[] AllDicesView= {D1view,D2view,D3view,D4view,D5view,D6view};
        Image[] AllDImage = {D1,D2,D3,D4,D5,D6};

        Label Yahtzee = new Label("Yahtzee");
        Yahtzee.setFont(Font.font(40));
        pane.add(Yahtzee,0,0,5,1);

        CheckBox pos1 = new CheckBox();
        pos1.setDisable(true);
        GridPane.setHalignment(pos1, HPos.CENTER);
        pane.add(pos1,0,2);

        CheckBox pos2 = new CheckBox();
        pos2.setDisable(true);
        GridPane.setHalignment(pos2,HPos.CENTER);
        pane.add(pos2,1,2);

        CheckBox pos3 = new CheckBox();
        pos3.setDisable(true);
        GridPane.setHalignment(pos3,HPos.CENTER);
        pane.add(pos3,2,2);

        CheckBox pos4 = new CheckBox();
        pos4.setDisable(true);
        GridPane.setHalignment(pos4,HPos.CENTER);
        pane.add(pos4,3,2);

        CheckBox pos5 = new CheckBox();
        pos5.setDisable(true);
        GridPane.setHalignment(pos5,HPos.CENTER);
        pane.add(pos5,4,2);

        Button RollDice = new Button("Roll the Dice!");
        pane.add(RollDice,0,3,2,1);
        Label text = new Label("You have 3 rolls left.");
        pane.add(text,2,3,3,1);
        CheckBox[] checkbox = {pos1,pos2,pos3,pos4,pos5};
        RollDice.setOnAction(e-> {
            Random rd = new Random();
            if (getCountRD()==1){
                minusCountRD();

                for (int i = 0; i < checkbox.length; i++) {
                    checkbox[i].setDisable(true);
                    int rand = rd.nextInt(6);
                    if (checkbox[i].isSelected()){
                    }else
                        AllDicesView[i].setImage(AllDImage[rand]);
                }


                ArrayList<Integer> CountPerFace = new ArrayList<>();
                for (int i=0;i<6;i++)
                    CountPerFace.add(0);

                //To fix
                for (int q=0;q<AllDicesView.length-1;q++){
                    for (int l=0;l<AllDImage.length;l++) {
                        if (AllDicesView[q].getImage().equals(AllDImage[l])) {
                            CountPerFace.set(l,(CountPerFace.get(l)+1));
                            break;
                        }
                    }
                }

                if (CountPerFace.contains(5))
                    text.setText("Yahtzee");
                else if (CountPerFace.contains(4))
                    text.setText("Four of a kind");
                else if(CountPerFace.contains(3)&&CountPerFace.contains(2))
                    text.setText("Full House");
                else if (CountPerFace.contains(3))
                    text.setText("Three of a kind");
                else if(isLargeStraight(CountPerFace))
                    text.setText("Large Straight");
                else if(isSmallStraight(CountPerFace))
                    text.setText("Small Straight");
                else
                    text.setText("Pair");

            }
            else if (getCountRD()<1){

            }else {
                minusCountRD();

                for (int k = 0; k < checkbox.length; k++)
                    checkbox[k].setDisable(false);


                text.setText((CountRD) + " rolls left.");
                for (int j = 0; j < checkbox.length; j++) {
                    if (checkbox[j].isSelected()) {
                    } else {
                        int help = rd.nextInt(6);
                        AllDicesView[j].setImage(AllDImage[help]);

                    }
                }

            }
        });
        Scene scene = new Scene(pane,600,400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Yahtzee");
        primaryStage.show();

    }
}
