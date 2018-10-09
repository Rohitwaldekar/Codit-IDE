package application;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javafx.scene.control.Tab;

public class Run extends Thread{

	private File file;
	private String name;
	private Tab test;
	
	public Run(File file,Tab test,String name) {
		this.file = file;
		this.test = test;
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("Inside Thread in run"); 
 
    	StringTokenizer token=new StringTokenizer(name,".");
    
    	System.out.println(file.toString().substring(0,2));
    	System.out.println(file);
    	System.out.println(name);
    	System.out.println(token.nextToken());

    	String drive = file.toString().substring(0,2);
    	String spli = token.nextToken();
		 String s = null;
		 String parent = file.getParentFile().toString();
		 System.out.println(parent);
	        try {
	    	ProcessBuilder builder = new ProcessBuilder();
//Command 
	    	System.out.println("Before Execution !");
			//builder.command("cmd.exe", "/c",drive+" && cd "+file.toString().substring(3));
			builder.command("cmd.exe", "/c",drive+" && cd "+parent+" && javac "+name+" && java "+spli);

			System.out.println("After Execution !");

	    	Process p = builder.start();
	    	
	    	
	    	BufferedOutputStream stdOutput = new BufferedOutputStream(p.getOutputStream());
	    	System.out.println(stdOutput.toString());
	        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

	        BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

	        // read the output from the command
	        System.out.println("Here is the standard output of the command:\n");
	        while ((s = stdInput.readLine()) != null) {
	            System.out.println(s);
	        }
	        
	        // read any errors from the attempted command
	        System.out.println("Here is the standard error of the command (if any):\n");
	        while ((s = stdError.readLine()) != null) {
	            System.out.println(s);
	        }
	    }
	    catch (IOException e) {
	        System.out.println("exception happened - here's what I know: ");
	        e.printStackTrace();
	        System.exit(-1);
	    }
	
	}
	
}
