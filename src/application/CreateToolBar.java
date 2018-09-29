package application;

import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CreateToolBar {

	private ToolBar toolBar;
	
	private Button newBut;
	private ImageView newImg;
	

	private Button openBut;
	private ImageView openImg;
	
	private Button saveBut;
	private ImageView saveImg;
	
	private Button undoBut;
	private ImageView undoImg;
	

	private Button redoBut;
	private ImageView redoImg;
	

	private Button cutBut;
	private ImageView cutImg;
	

	private Button copyBut;
	private ImageView copyImg;
	
	private Button pasteBut;
	private ImageView pasteImg;

	private Button excBut;
	private ImageView excImg;

	private Button runBut;
	private ImageView runImg;

	private Button nextBut;
	private ImageView nextImg;

	private Button pauseBut;
	private ImageView pauseImg;
	
	private Button stopBut;
	private ImageView stopImg;
	
	private Separator seperat1;
	private Separator seperat2;
	private Separator seperat3;
	private Separator seperat4;

	final String IDLE_BUTTON_STYLE = "-fx-background-color: transparent; ";
	final String HOVERED_BUTTON_STYLE = "-fx-background-color: -fx-shadow-highlight-color, -fx-outer-border, -fx-inner-border, -fx-body-color;";
	final String WHITE = "-fx-background-color: #FFFFFF";
	
	public CreateToolBar() {

		newImg = new ImageView(new Image("filenew.png"));
		openImg = new ImageView(new Image("fileopen.png"));
		saveImg = new ImageView(new Image("filesave.png"));
		undoImg = new ImageView(new Image("undo.png"));
		redoImg = new ImageView(new Image("redo.png"));
		cutImg = new ImageView(new Image("editcut.png"));
		copyImg = new ImageView(new Image("editcopy.png"));
		pasteImg = new ImageView(new Image("editpaste.png"));
		excImg = new ImageView(new Image("run_exc.png"));
		runImg = new ImageView(new Image("dbgrun.png"));
		nextImg = new ImageView(new Image("dbgnext.png"));
		pauseImg = new ImageView(new Image("dbgpause.png"));
		stopImg = new ImageView(new Image("dbgstop.png"));

		
		seperat1 = new Separator();
		seperat2 = new Separator();
		seperat3 = new Separator();
		seperat4 = new Separator();

		toolBar = new ToolBar();
		
		newBut = new Button(null, newImg);
		newBut.setStyle(IDLE_BUTTON_STYLE);
		newBut.setOnMouseEntered(e -> newBut.setStyle(HOVERED_BUTTON_STYLE));
		newBut.setOnMouseExited(e -> newBut.setStyle(IDLE_BUTTON_STYLE));

		openBut = new Button(null, openImg);
		openBut.setStyle(IDLE_BUTTON_STYLE);
		openBut.setOnMouseEntered(e -> openBut.setStyle(HOVERED_BUTTON_STYLE));
		openBut.setOnMouseExited(e -> openBut.setStyle(IDLE_BUTTON_STYLE));

		saveBut = new Button(null,saveImg);
		saveBut.setStyle(IDLE_BUTTON_STYLE);
		saveBut.setOnMouseEntered(e -> saveBut.setStyle(HOVERED_BUTTON_STYLE));
		saveBut.setOnMouseExited(e -> saveBut.setStyle(IDLE_BUTTON_STYLE));

		undoBut = new Button(null,undoImg);
		undoBut.setStyle(IDLE_BUTTON_STYLE);
		undoBut.setOnMouseEntered(e -> undoBut.setStyle(HOVERED_BUTTON_STYLE));
		undoBut.setOnMouseExited(e -> undoBut.setStyle(IDLE_BUTTON_STYLE));

		redoBut = new Button(null,redoImg);
		redoBut.setStyle(IDLE_BUTTON_STYLE);
		redoBut.setOnMouseEntered(e -> redoBut.setStyle(HOVERED_BUTTON_STYLE));
		redoBut.setOnMouseExited(e -> redoBut.setStyle(IDLE_BUTTON_STYLE));
		
		cutBut = new Button(null,cutImg);
		cutBut.setStyle(IDLE_BUTTON_STYLE);
		cutBut.setOnMouseEntered(e -> cutBut.setStyle(HOVERED_BUTTON_STYLE));
		cutBut.setOnMouseExited(e -> cutBut.setStyle(IDLE_BUTTON_STYLE));
		
		copyBut = new Button(null,copyImg);
		copyBut.setStyle(IDLE_BUTTON_STYLE);
		copyBut.setOnMouseEntered(e -> copyBut.setStyle(HOVERED_BUTTON_STYLE));
		copyBut.setOnMouseExited(e -> copyBut.setStyle(IDLE_BUTTON_STYLE));
		
		pasteBut = new Button(null,pasteImg);
		pasteBut.setStyle(IDLE_BUTTON_STYLE);
		pasteBut.setOnMouseEntered(e -> pasteBut.setStyle(HOVERED_BUTTON_STYLE));
		pasteBut.setOnMouseExited(e -> pasteBut.setStyle(IDLE_BUTTON_STYLE));
		

		excBut = new Button(null,excImg);
		excBut.setStyle(IDLE_BUTTON_STYLE);
		excBut.setOnMouseEntered(e -> excBut.setStyle(HOVERED_BUTTON_STYLE));
		excBut.setOnMouseExited(e -> excBut.setStyle(IDLE_BUTTON_STYLE));

		runBut = new Button(null,runImg);
		runBut.setStyle(IDLE_BUTTON_STYLE);
		runBut.setOnMouseEntered(e -> runBut.setStyle(HOVERED_BUTTON_STYLE));
		runBut.setOnMouseExited(e -> runBut.setStyle(IDLE_BUTTON_STYLE));

		nextBut = new Button(null,nextImg);
		nextBut.setStyle(IDLE_BUTTON_STYLE);
		nextBut.setOnMouseEntered(e -> nextBut.setStyle(HOVERED_BUTTON_STYLE));
		nextBut.setOnMouseExited(e -> nextBut.setStyle(IDLE_BUTTON_STYLE));

		pauseBut = new Button(null,pauseImg);
		pauseBut.setStyle(IDLE_BUTTON_STYLE);
		pauseBut.setOnMouseEntered(e -> pauseBut.setStyle(HOVERED_BUTTON_STYLE));
		pauseBut.setOnMouseExited(e -> pauseBut.setStyle(IDLE_BUTTON_STYLE));

		stopBut = new Button(null,stopImg);
		stopBut.setStyle(IDLE_BUTTON_STYLE);
		stopBut.setOnMouseEntered(e -> stopBut.setStyle(HOVERED_BUTTON_STYLE));
		stopBut.setOnMouseExited(e -> stopBut.setStyle(IDLE_BUTTON_STYLE));


		toolBar.getItems().addAll(newBut,openBut,saveBut,seperat1,undoBut,redoBut,seperat2,cutBut,copyBut,pasteBut,seperat3,excBut,seperat4,runBut,nextBut,pauseBut,stopBut);

	}

	public Button getNewBut() {

		return newBut;
	}

	public ToolBar getToolBar() {

		return toolBar;
	}
}
