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
	
	final String IDLE_BUTTON_STYLE = "-fx-background-color: transparent; ";
	final String HOVERED_BUTTON_STYLE = "-fx-background-color: -fx-shadow-highlight-color, -fx-outer-border, -fx-inner-border, -fx-body-color;";
	final String WHITE = "-fx-background-color: #FFFFFF";
	
	public Browser() {

		browser = new Tab("Browser");
		browser.setStyle(WHITE);

		content = new BorderPane();
		tool = new ToolBar();
		tool.setStyle(WHITE);
		
		previous = new Button("Previous");
		previous.setStyle(IDLE_BUTTON_STYLE);
		previous.setOnMouseEntered(e -> previous.setStyle(HOVERED_BUTTON_STYLE));
		previous.setOnMouseExited(e -> previous.setStyle(IDLE_BUTTON_STYLE));
		
		next = new Button("Next");
		next.setStyle(IDLE_BUTTON_STYLE);
		next.setOnMouseEntered(e -> next.setStyle(HOVERED_BUTTON_STYLE));
		next.setOnMouseExited(e -> next.setStyle(IDLE_BUTTON_STYLE));
		
		go = new Button("Go");
		go.setStyle(IDLE_BUTTON_STYLE);
		go.setOnMouseEntered(e -> go.setStyle(HOVERED_BUTTON_STYLE));
		go.setOnMouseExited(e -> go.setStyle(IDLE_BUTTON_STYLE));
		
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
