package application;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class Editor {

	private TabPane editor;

	public Editor() {
	
		editor = new TabPane();
	}
	
	public TabPane getEditor() {

		editor.getTabs().addAll(generateTab("Tab 1"), generateTab("Tab 2"), generateTab("Tab 3"),
				generateTab("Tab N"));

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

}
