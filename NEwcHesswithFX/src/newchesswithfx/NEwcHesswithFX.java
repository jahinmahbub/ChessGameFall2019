package newchesswithfx;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class NEwcHesswithFX extends Application {
  @Override
  public void init() {
	sp_mainlayout = new StackPane();
	cc_custom = new CustomControl();
	sp_mainlayout.getChildren().add(cc_custom);
  }
  @Override
  public void start(Stage primaryStage) {
	primaryStage.setTitle("Chess game");
	primaryStage.setScene(new Scene(sp_mainlayout, 600, 700));
	primaryStage.setMinWidth(300);
	primaryStage.setMinHeight(300);
	primaryStage.show();
  }
  @Override
  public void stop() {
  }
  public static void main(String[] args) {
	launch(args);
  }
  private StackPane sp_mainlayout;
  private CustomControl cc_custom;
}
