package application;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;

public class CreateMenuBar {

	// --- Menu File
	private MenuItem new1;
	private MenuItem open;
	private MenuItem save;
	private MenuItem saveAs;

	// --- Menu Edit
	private MenuItem undo;
	private MenuItem redo;
	private MenuItem copy;
	private MenuItem paste;
	private MenuItem cute;
	private MenuItem selectAll;

	private MenuBar menuBar;
	
	private Menu menuFile;
	private Menu menuEdit;
	private Menu menuView;
	
	public CreateMenuBar() {

		// --- Menu File
		new1 = new MenuItem("New");
		open = new MenuItem("Open");
		save = new MenuItem("Save");
		saveAs = new MenuItem("Save As");

		// --- Menu Edit
		undo = new MenuItem("Undo");
		redo = new MenuItem("Redo");
		copy = new MenuItem("Copy");
		paste = new MenuItem("Paste");
		cute = new MenuItem("Cute");
		selectAll = new MenuItem("Select All");

		menuBar = new MenuBar();
//
		menuFile = new Menu("File");

		open.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));

		menuFile.getItems().addAll(new1, open, save, saveAs);

		menuEdit = new Menu("Edit");
		menuEdit.getItems().addAll(undo, redo, copy, paste, cute, selectAll);

// --- Menu View
		menuView = new Menu("View");
		
		menuBar.getMenus().addAll(menuFile, menuEdit, menuView);

	}

	public MenuItem getOpen() {
		return open;
	}

	public MenuBar getMenuBar() {
		return menuBar;
	}

}
