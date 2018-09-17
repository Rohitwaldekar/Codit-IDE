package application;

import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class Console {

	private Tab console;
	
	public Console() {
		
		console = new Tab("Console");
	}
	
	public Tab getConsole() {
		console.setClosable(false);

		BorderPane content1 = new BorderPane();
		TextArea text1 = new TextArea();
		content1.setCenter(text1);
		console.setContent(content1);
		return console;
	}
}
