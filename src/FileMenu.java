import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileMenu {
	subFileMenu sm=new subFileMenu();
	public void showMenu() {
		System.out.println("\nMain Menu.");
		System.out.println("1. List Files");
		System.out.println("2. File options");
		System.out.println("3. Exit");
		Scanner in=new Scanner(System.in);
		int choice=0;
		choice=in.nextInt();
		switch(choice) {
		case 1:
            this.showFiles();
            this.showMenu();
            break;
            
        case 2:
        	sm.showMenu();
            break;
        case 3:
        	System.exit(0);
        default:
            System.out.println("Invalid choice. Please choose valid option.");
            this.showMenu();
            break;
		}
		in.close();
	}

	private void showFiles() {
		String path="directory/";
		System.out.println("List of files:");
		
		File f = new File(path);
        ArrayList<String> files = new ArrayList<String>(Arrays.asList(f.list()));
        
        for(String s:files) {
			System.out.println(s);
		}
		
/*		File f=new File(path);
        ArrayList<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));
		for(int i = 0; i < files.size(); i++) {
			System.out.println(files.get(i).getName());
				
        }*/
        
        
		
	}

	
}
