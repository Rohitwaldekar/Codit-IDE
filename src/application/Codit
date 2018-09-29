package application;

import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class Codit extends Application {

	private TabPane leftPane = new TabPane();
	private TabPane bottomPane = new TabPane();
	private SplitPane paneFree = new SplitPane();

	final String WHITE = "-fx-background-color: #FFFFFF";
	
	private BorderPane outer;

	private BorderPane inner;

	private Editor editor;

	private CreateToolBar toolBar;

	private FileSystem fileSystem;

	private Variables variables;
	
	private CreateMenuBar menuBar;

	private Console console;
	
	private Browser browser;
	

	public Codit() {

		outer = new BorderPane();
		outer.setStyle(WHITE);

		inner = new BorderPane();
		inner.setStyle(WHITE);
		
		editor = new Editor();

		toolBar = new CreateToolBar();
		
		fileSystem = new FileSystem();

		variables = new Variables();

		menuBar = new CreateMenuBar();

		console = new Console();

		browser = new Browser();
	}
	
	
	@Override
	public void start(Stage stage) {
//##Events handling	
		
//Create new Editor 		
		Button newBut = toolBar.getNewBut();
		newBut.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				editor.setEditor("New TAb !");
			}
		});

		
//Open new file
		MenuItem open = menuBar.getOpen();

		//BorderPane b = new BorderPane();
						
		
		open.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				DirectoryChooser directoryChooser = new DirectoryChooser();

				directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));

				// Stage stage = new Stage();
				File choice = directoryChooser.showDialog(stage);

				if (choice == null || !choice.isDirectory()) {

					Alert alert = new Alert(AlertType.ERROR);

					alert.setHeaderText("File Not Found.");

					alert.setContentText("Please Select file !");

					alert.showAndWait();
				} else {
					
					editor = fileSystem.setFileSystem(choice,editor);
				}
			}
		});


//Open file
 
		//editor = fileSystem.mouseClickEvent(editor);
		
		inner.setTop(toolBar.getToolBar());

		SplitPane root = new SplitPane();

		root.setOrientation(Orientation.VERTICAL);

		bottomPane.getTabs().addAll(console.getConsole(), browser.getBrowser());

		SplitPane.setResizableWithParent(bottomPane, Boolean.FALSE);

		leftPane.getTabs().addAll(fileSystem.getFileSystem(), variables.getVariables());

		paneFree.getItems().addAll(leftPane, editor.getEditor());

		root.getItems().addAll(paneFree, bottomPane);

		inner.setCenter(root);

		outer.setTop(menuBar.getMenuBar());

		outer.setCenter(inner);

		stage.getIcons().add(new Image("folder-open.png"));
		stage.setTitle("Codit IDE");
		stage.setScene(new Scene(outer, 1300, 700));
		stage.show();
	}

	public static void main(String[] args) {
		Codit.launch(args);
	}
	
}
