package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

public class Browser {

	private Tab browser;
	private BorderPane content;
	private ToolBar tool;
	private Button previous;
	private Button next;
	private Button go;
	private TextField tf;
	private WebView webview;
	
	public Browser() {

		browser = new Tab("Browser");
		content = new BorderPane();
		tool = new ToolBar();
		previous = new Button("Previous");
		next = new Button("Next");
		go = new Button("Go");
		tf = new TextField();
		webview = new WebView();
	}
	
	public Tab getBrowser() {

		browser.setClosable(false);

		tool.getItems().add(previous);

		tool.getItems().add(next);

		tool.getItems().add(go);

		tf.setPrefHeight(25.0);
		tf.setPrefWidth(600.0);

		tool.getItems().add(tf);

		WebEngine engine = webview.getEngine();

		String htLink = "http://";

		engine.load(htLink + "www.google.com");

		WebHistory history = engine.getHistory();

		previous.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				history.go(-1);
			}
		});

		go.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				String addLink = tf.getText().toString();
				engine.load(htLink + addLink);
			}

		});

		next.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				history.go(1);
			}

		});

		content.setCenter(webview);
		content.setTop(tool);
		browser.setContent(content);

		return browser;
	}
}
