import controller.LottoController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.LottoModel;
import view.LottoView;

public class Lotto extends Application {
    LottoView view;
    LottoModel model;
    LottoController controller;
    public void start(Stage primaryStage){
        model = new LottoModel();
        view = new LottoView(primaryStage, model);
        controller = new LottoController(model, view);

    }
    public static void main(String[] args) { launch(); }
}
