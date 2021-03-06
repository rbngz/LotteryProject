package view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Ball extends StackPane {
    public static boolean isLuckyNum = false;
    public Ball(int num){
        super();
        Label ball = new Label();
        Label number = new Label(Integer.toString(num));
        number.setStyle("-fx-font-size: 50px");
        this.setWidth(112);
        String source;
        if(isLuckyNum){
            source ="images/luckyball.png";
        }else {
            source ="images/greyball-hi.png";
        }
        Image image = new Image(this.getClass().getClassLoader().getResourceAsStream(source));
        ImageView imv = new ImageView(image);
        imv.fitWidthProperty().bind(this.widthProperty());
        imv.fitHeightProperty().bind(this.heightProperty());
        imv.setPreserveRatio(true);
        ball.setGraphic(imv);
        this.getChildren().addAll(ball,number);

        this.getStyleClass().add("ball");
    }
}
