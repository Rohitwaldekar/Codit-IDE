package application;

import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class Variables {

	private Tab variables;
	
	final String WHITE = "-fx-background-color: #FFFFFF";
	
	public Variables() {

		variables = new Tab("Variables");
		variables.setStyle(WHITE);

	}
	public Tab getVariables() {

		variables.setClosable(false);

		BorderPane content2 = new BorderPane();
		TextArea text2 = new TextArea();
		content2.setCenter(text2);
		variables.setContent(content2);

		return variables;
	}
}
