package view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ball extends Label {
    public Ball(){
        super();
        //this.setPadding(new Insets(20));
        this.setWidth(120);
        Image image = new Image(this.getClass().getClassLoader().getResourceAsStream("images/greyball-hi.png"));
        ImageView imv = new ImageView(image);
        imv.fitWidthProperty().bind(this.widthProperty());
        imv.fitHeightProperty().bind(this.heightProperty());
        imv.setPreserveRatio(true);
        this.setGraphic(imv);
        this.getStyleClass().add("ball");
    }
}
