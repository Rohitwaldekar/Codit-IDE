package application;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CreateToolBar {

	private ToolBar toolBar;
	private Button newBut;
	private ImageView newImg;
	
	public CreateToolBar() {

		newImg = new ImageView(new Image("filenew.png"));

		toolBar = new ToolBar();
		
		newBut = new Button(null, newImg);

		toolBar.getItems().add(newBut);

	}

	public Button getNewBut() {

		return newBut;
	}

	public ToolBar getToolBar() {

		return toolBar;
	}
}
