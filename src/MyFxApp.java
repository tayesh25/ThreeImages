import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.ArrayList;

public class MyFxApp extends Application {

    Image image1;
    Image image2;
    Image image3;

    ArrayList<Image> images;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("black men kissing");
        Label label = new Label("ImagePicker");
        images = new ArrayList<Image>();
        // Load program's data
        FileInputStream input1 = new FileInputStream("src/cb.jpg");
        image1 = new Image(input1);
        images.add(image1);
        FileInputStream input2 = new FileInputStream("src/etower.jpg");
        image2 = new Image(input2);
        images.add(image2);
        FileInputStream input3 = new FileInputStream("src/SamDog.jpg");
        image3 = new Image(input3);
        images.add(image3);

        ImageView imageView1  = new ImageView();
        imageView1.setImage(image3);
        imageView1.setFitHeight(600);
        imageView1.setFitWidth(540);

        ChoiceBox choiceBox = new ChoiceBox();
        choiceBox.getItems().add("CatB 1");
        choiceBox.getItems().add("ETower 2");
        choiceBox.getItems().add("SamDog 3");

        ComboBox comboBox = new ComboBox();
        comboBox.getItems().add("CatB 1");
        comboBox.getItems().add("Etower 2");
        comboBox.getItems().add("SamDog 3");

        ToggleButton toggleButton1 = new ToggleButton("CatB 1");
        ToggleButton toggleButton2 = new ToggleButton("ETower 2 ");
        ToggleButton toggleButton3 = new ToggleButton("SamDog 3 ");

        ToggleGroup toggleGroup = new ToggleGroup();

        toggleButton1.setToggleGroup(toggleGroup);
        toggleButton2.setToggleGroup(toggleGroup);
        toggleButton3.setToggleGroup(toggleGroup);

        toggleButton1.setOnAction((event) -> {
                   //Toggle toggle = toggleButton1.getToggleGroup().getSelectedToggle();
                  // if (toggle == toggleButton1) {
                    imageView1.setImage(image1);
      //  }
        });
            toggleButton2.setOnAction(event -> {
                imageView1.setImage(image2);
                    }
                    );

        toggleButton3.setOnAction(event -> {
                    imageView1.setImage(image3);
                }
        );
        comboBox.setOnAction((event) -> {
            int selectedChoice = choiceBox.getSelectionModel().getSelectedIndex();
            imageView1.setImage(images.get(selectedChoice));

        });








        choiceBox.setOnAction((event) -> {
            int selectedChoice = choiceBox.getSelectionModel().getSelectedIndex();
            imageView1.setImage(images.get(selectedChoice));
            comboBox.getSelectionModel().getSelectedIndex();
            imageView1.setImage(images.get(selectedChoice));

        });


        // Construct layouts to organize the Controls in the window
        HBox hbox1 = new HBox(choiceBox, comboBox,label,toggleButton1, toggleButton2, toggleButton3);
        VBox vbox1 = new VBox(imageView1, hbox1);
        Scene myScene1 = new Scene(vbox1,1920,1080);
        primaryStage.setTitle("ImageView");
        primaryStage.setScene(myScene1);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}