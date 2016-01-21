
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Driver {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        boolean quit = false;
        System.out.println("Choose one of the following operations by entering provided letter:");
        System.out.println("e - Encode a file into a qr video");
        System.out.println("d - Decode a qr video back into a file");
        System.out.println("q - Quit the program");

        do{
            switch(scan.nextLine().toLowerCase().charAt(0)){
                case 'q':
                    quit = true;
                    System.out.println("Quitting");
                    break;
                    
                case 'e':
                    System.out.println("Enter the path & name of the file you want to encode(ex. C://test//testdoc.txt)");
                    String filePath = scan.nextLine();
                    System.out.println("Enter the path & name of the name of the qr vide output(ex. C://test//output)");
                    String videoPath = scan.nextLine();
            
                    try {
                        Processing.createVideo(filePath,videoPath+".avi");
                        System.out.println(videoPath+" created successfully");
                    }
                    catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                    
                case 'd':
                    System.out.println("Enter the path & name of the video you want to decode back into a file (ex. C://output.avi)");
                    String videoP = scan.nextLine();
                    System.out.println("Enter the path & name of the file you want to create (ex. C://original.txt)");
                    String fileP = scan.nextLine();
                    
            {
                try {
                    Processing.videoToFile(videoP, fileP);
                    System.out.println(fileP+" created successfully");
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
                    
                    
                    break;
                    
                default:
                    System.out.println("ERROR: Invalid choice");
                    break;         
            }
            
        }while(!quit);
        scan.close();
    }
}
