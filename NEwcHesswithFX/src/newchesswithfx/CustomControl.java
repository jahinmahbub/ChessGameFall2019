package newchesswithfx;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Control;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
public class CustomControl extends Control {
  public CustomControl() {
	setSkin(new CustomControlSkin(this));
	statusBar = new StatusBar();
	chessBoard = new ChessBoard(statusBar);
	getChildren().addAll(statusBar, chessBoard);
	setOnMouseClicked(new EventHandler<MouseEvent>() {
	  @Override
	  public void handle(MouseEvent event) {
		chessBoard.selectPiece(event.getX(), event.getY() - (statusBarSize / 2));
	  }

	});
	// Add a key listener that will reset the game
	setOnKeyPressed(new EventHandler<KeyEvent>() {
	  @Override
	  public void handle(KeyEvent event) {
		if (event.getCode() == KeyCode.SPACE) {
		  chessBoard.resetGame();
		}
	  }
	});
	statusBar.getResetButton().setOnAction(new EventHandler<ActionEvent>() {
	  @Override
	  public void handle(ActionEvent event) {
		chessBoard.resetGame();
	  }

	});

  }
  public void resize(double width, double height) {
	super.resize(width, height - statusBarSize);
	chessBoard.setTranslateY(statusBarSize / 2);
	chessBoard.resize(width, height - statusBarSize);
	statusBar.resize(width, statusBarSize);
	statusBar.setTranslateY(-(statusBarSize / 2));
  }
  private ChessBoard chessBoard;
  private StatusBar statusBar;
  private int statusBarSize = 100;
}
