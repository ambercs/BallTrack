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

 */
public class Main extends Application {

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
        paneRight.getChildren().add(firstValue);

        paneRight.getChildren().add(new Label("Blue Speed:"));
        TextField secondValue = new TextField();
        paneRight.getChildren().add(secondValue);

        paneRight.getChildren().add(new Label("Green Speed:"));
        TextField thirdValue = new TextField();
        paneRight.getChildren().add(thirdValue);

        paneRight.getChildren().add(new Label("Yellow Speed:"));
        TextField fourthValue = new TextField();
        paneRight.getChildren().add(fourthValue);

        //Now display
        root.setRight(paneRight);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    //Draws shape of the bowtie
    private void drawShapes(GraphicsContext gc) {
        //gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeLine(100, 125, 200, 125);
        gc.strokePolygon(new double[]{100,30,30}, new double[]{125,75,175},3);
        gc.strokePolygon(new double[]{200,270,270}, new double[]{125,75,175},3);
    }
}
