package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;


/*
EDITS:
1/31/18 AMBER   adjusted sizing, added fields and buttons
                on separate pane
                help from https://stackoverflow.com/questions/27758214/javafx-button-doesnt-work
2/01/18 AMBER   received data from fields
                help from https://stackoverflow.com/questions/32219536/javafx-getting-input-from-textfield
 */
public class Main extends Application {

    private static int redSpeed = 45;
    private static int blueSpeed = 45;
    private static int greenSpeed = 45;
    private static int yellowSpeed = 45;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        Pane paneCenter= new Pane();

        //Draws the bowtie
        Canvas canvas = new Canvas(400, 300);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        drawBall(gc, "red");
        drawBall(gc, "blue");
        drawBall(gc, "green");
        drawBall(gc, "yellow");

        //Adds the bowtie to center pane
        paneCenter.getChildren().add(canvas);
        root.setCenter(paneCenter);

        //Sets up side pane for buttons
        VBox paneRight = new VBox();
        paneRight.setPrefSize(200, 300);
        paneRight.setPadding(new Insets(20));
        paneRight.setAlignment(Pos.TOP_LEFT);

        //Add buttons, start and end buttons
        Button startButton = new Button("Start");
        paneRight.getChildren().add(startButton);

        Button stopButton = new Button("Stop");
        paneRight.getChildren().add(stopButton);

        //Buttons with fields for speed of nodes
        paneRight.getChildren().add(new Label("Red Speed:"));
        TextField firstValue = new TextField();
        firstValue.setText(""+redSpeed);
        paneRight.getChildren().add(firstValue);


        paneRight.getChildren().add(new Label("Blue Speed:"));
        TextField secondValue = new TextField();
        secondValue.setText(""+blueSpeed);
        paneRight.getChildren().add(secondValue);

        paneRight.getChildren().add(new Label("Green Speed:"));
        TextField thirdValue = new TextField();
        thirdValue.setText(""+greenSpeed);
        paneRight.getChildren().add(thirdValue);

        paneRight.getChildren().add(new Label("Yellow Speed:"));
        TextField fourthValue = new TextField();
        fourthValue.setText(""+yellowSpeed);
        paneRight.getChildren().add(fourthValue);

        //Button to change the default speeds
        Button reconfigButton = new Button("Change Speed");
        paneRight.getChildren().add(reconfigButton);

        //Receive new fields on Change Speed button press
        reconfigButton.setOnAction(e -> {
            redSpeed = Integer.valueOf(firstValue.getText());
            blueSpeed = Integer.valueOf(secondValue.getText());
            greenSpeed = Integer.valueOf(thirdValue.getText());
            yellowSpeed = Integer.valueOf(fourthValue.getText());

            System.out.println(redSpeed+" "+blueSpeed+" "+greenSpeed+" "+yellowSpeed);
        });

        //Now display
        root.setRight(paneRight);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    //Set the four balls for the simulation
    private void drawBall(GraphicsContext gc, String color) {
        if(color.equals("red")){
            gc.setFill(Color.RED);
            gc.setStroke(Color.RED);
            gc.fillOval(28,74,5,5);
        }
        else if(color.equals("blue")){
            gc.setFill(Color.BLUE);
            gc.setStroke(Color.BLUE);
            gc.fillOval(28,172,5,5);
        }
        else if(color.equals("green")){
            gc.setFill(Color.GREEN);
            gc.setStroke(Color.GREEN);
            gc.fillOval(268,74,5,5);
        }
        else if(color.equals("yellow")){
            gc.setFill(Color.YELLOW);
            gc.setStroke(Color.YELLOW);
            gc.fillOval(268,172,5,5);
        }


    }

    //Draws shape of the bowtie
    private void drawShapes(GraphicsContext gc) {
        //gc.setFill(Color.GREEN);
        gc.setStroke(Color.ORANGE);
        gc.setLineWidth(2);
        gc.strokeLine(100, 125, 200, 125);
        gc.setStroke(Color.BLACK);
        gc.strokePolygon(new double[]{100,30,30}, new double[]{125,75,175},3);
        gc.strokePolygon(new double[]{200,270,270}, new double[]{125,75,175},3);
    }
}
