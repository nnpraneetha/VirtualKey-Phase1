import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class subFileMenu {
	
	String path = "directory/";
	Scanner in=new Scanner(System.in);
	
	public void showMenu() {
		
		System.out.println("\nFile Options:");
		System.out.println("1. Add a file");
		System.out.println("2. Delete a file");
		System.out.println("3. Search a file");
		System.out.println("4. Back");
		
		int choice=0;
		choice=in.nextInt();
		
		switch(choice) {
		case 1:
            addfile();
            this.showMenu();
            break;
            
        case 2:
        	deletefile();
            this.showMenu();
            break;
        
        case 3:
        	searchfile();
        	this.showMenu();
        	break;
        case 4:
        	new FileMenu().showMenu();
        	break;
        default:
            System.out.println("Invalid choice. Please choose valid option.");
            this.showMenu();
            break;
		}
		
	}

	private void searchfile() {
		
		Boolean resultFile = false;
		String fileName;
		
    	System.out.println("Enter the Filename:");
        fileName=in.next();
        
        System.out.println("Searching for a file : " + fileName);
        
        File f=new File(path);
        
        ArrayList<String> files = new ArrayList<String>(Arrays.asList(f.list()));
        
        for(String s:files) {
        	if(s.equals(fileName)) {
        		System.out.println("Found :" + fileName);
				resultFile = true;
        	}
        }
        
        /*ArrayList<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));
        
          for(int i = 0; i < files.size(); i++) {
			if(files.get(i).getName().equals(fileName+".txt")) {
				System.out.println("Found " + fileName);
				resultFile = true;
			}
        }*/
        
        if (resultFile == false) {
        	System.out.println("File not found");
        }
		
	}
	
	private void deletefile() {
		
		System.out.println("Enter the Filename:");

        String fileName;
        fileName=in.next();
        
        System.out.println("Deleting file: " + fileName);
        File file = new File(path+fileName);
        if (file.delete()) {
	    	  System.out.println("Deleted File: " + file.getName());

	      } else {
	        System.out.println("Failed to delete file:" + fileName + "\n File Not Found.");
	      }
		
	}
	
	private void addfile() {
		
		System.out.println("Enter the Filename:");

        String fileName;
        fileName=in.next();
        
        System.out.println("You are adding a file named: " + fileName);
        File file = new File(path+fileName);
        
		try {
			
		      if (file.createNewFile()) {
		    	  System.out.println("File created: " + file.getName());
		    	   
		      } else {
		        System.out.println("This File Already Exits. ");
		      }
		}catch (IOException e){
			System.out.println(e);
		}
		
	}
}
