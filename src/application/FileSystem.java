package application;

import java.io.File;
import java.util.HashMap;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Tab;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class FileSystem {

	private Tab fileSystem;
	private HashMap<String, File> pathName;
	private TreeView<String> fileTree;
	
	final String WHITE = "-fx-background-color: #FFFFFF";
	
	public FileSystem() {
		
		fileSystem = new Tab("File System");
		fileSystem.setClosable(false);
		fileSystem.setStyle(WHITE);
		
		BorderPane br = new BorderPane();
		br.setStyle(WHITE);
		fileSystem.setContent(br);
		pathName = new HashMap<String, File>();
		fileTree = null;
	}
	
	public TreeView<String> getFileTree() {

		return fileTree;
	}
	
	public Tab getFileSystem() {
	
		return fileSystem;
	}


	public Editor setFileSystem(File directory,Editor editor) {
		fileTree = null;
		fileTree = new TreeView<String>(getNodesForDirectory(directory));
		//fileTree.setRoot(getNodesForDirectory(directory));
		//b.setCenter(fileTree);
		mouseClickEvent(editor);
		fileSystem.setContent(fileTree);
		return editor;
	}
	

	public Editor mouseClickEvent(Editor editor) {
		fileTree.getSelectionModel().selectedItemProperty().addListener( new ChangeListener() {
			
	        public void changed(ObservableValue observable, Object oldValue, Object newValue) {

		        	TreeItem<String> selectedItem = (TreeItem<String>) newValue;
		            //System.out.println("Selected Text : " + selectedItem.getValue());
		            // do what ever you want 
		            String key = selectedItem.getValue();
		            File path = pathName.get(key);
		            
		            //Editor editor = new Editor();
		            editor.readFile(path, key);
	        	}

			});
		return editor;
	}
	
	public TreeItem<String> getNodesForDirectory(File directory) { // Returns a TreeItem representation of the specified
																	// directory

		Image folderImg = new Image(ClassLoader.getSystemResourceAsStream("folder-open.png"));
		Image fileImg = new Image(ClassLoader.getSystemResourceAsStream("text-x-generic.png"));

		TreeItem<String> root = new TreeItem<String>(directory.getName());

		for (File f : directory.listFiles()) {
			 //System.out.println("Loading " + f.getName());
			if (f.isDirectory()) { // Then we call the function recursively
				root.getChildren().add(getNodesForDirectory(f));
			} else {
				//System.out.println(directory+"\\"+f);
				pathName.put(f.getName(),f);
				root.getChildren().add(new TreeItem<String>(f.getName(), new ImageView(fileImg)));
			}
		}
		if (directory.isDirectory()) {
			root.setGraphic(new ImageView(folderImg));
		}
		return root;
	}
	

}
