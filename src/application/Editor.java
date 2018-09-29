package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class Editor {

	private TabPane editor;

	final String WHITE = "-fx-background-color: #FFFFFF";

	public Editor() {

		editor = new TabPane();
		editor.setStyle(WHITE);
	}

	public TabPane getEditor() {

		// editor.getTabs().addAll(generateTab("Tab 1"), generateTab("Tab 2"),
		// generateTab("Tab 3"),
		// generateTab("Tab N"));

		editor.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);

		return editor;
	}

	public Tab generateTab(String name) {
		Tab result = new Tab(name);

		BorderPane content = new BorderPane();
		TextArea text = new TextArea();
		content.setCenter(text);
		result.setContent(content);
		return result;
	}

	public TabPane setEditor(String name) {

		editor.getTabs().add(generateTab(name));
		return editor;
	}

	public TabPane readFile(File file, String name) {
		
		//File file = new File(path);
		StringBuilder stringBuffer = new StringBuilder();
		BufferedReader bufferedReader = null;
		
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			String text;
			
			while ((text = bufferedReader.readLine()) != null) {
				stringBuffer.append(text+"\n");
			}

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		finally {

			try {
				bufferedReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		// return stringBuffer.toString();

		Tab result = new Tab(name);
		BorderPane content = new BorderPane();
		TextArea text = new TextArea();
		text.setText(stringBuffer.toString());                         
		content.setCenter(text);
		result.setContent(content);

		editor.getTabs().add(result);
		return editor;
	}

}
