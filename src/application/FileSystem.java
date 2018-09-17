package application;

import java.io.File;
import java.util.HashMap;

import javafx.scene.control.Tab;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class FileSystem {

	private Tab fileSystem;
	private BorderPane b;
	private HashMap<String,String> pathName;
	private TreeView<String> fileTree;
	
	
	public FileSystem() {
		
		fileSystem = new Tab("File System");
		fileSystem.setClosable(false);
		b = new BorderPane();
		pathName = new HashMap<String, String>();
		fileTree = null;
	}
	
	public TreeView<String> getFileTree() {
		
		return fileTree;
	}
	
	public Tab getFileSystem() {

		return fileSystem;
	}


	public void setFileSystem(File directory) {
		fileTree = null;
		fileTree = new TreeView<String>(getNodesForDirectory(directory));
		//fileTree.setRoot(getNodesForDirectory(directory));
		b.setCenter(fileTree);
		fileSystem.setContent(b);
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
				pathName.put(f.getName(), directory+"\\"+f);
				root.getChildren().add(new TreeItem<String>(f.getName(), new ImageView(fileImg)));
			}
		}
		if (directory.isDirectory()) {
			root.setGraphic(new ImageView(folderImg));
		}
		return root;
	}
	

}
