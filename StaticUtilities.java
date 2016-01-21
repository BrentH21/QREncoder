import java.io.*;
import java.util.Base64;

public class StaticUtilities{

public static byte[] filetobyte(String pathname){

        FileInputStream fileInputStream = null;
        File file = new File(pathname);
        byte[] bFile = new byte[(int) file.length()];

        try{
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return bFile;
    }

    public static void byteToFile(byte[] bFile, String path){
            FileOutputStream stream = null;
            try{
                stream = new FileOutputStream(new File(path));
                stream.write(bFile);
            }
            catch(FileNotFoundException e){
                //do nothing
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    public static String byteToString(byte[] bFile){

        return Base64.getEncoder().encodeToString(bFile);
    }

    public static byte[] stringToByte(String str){
        return Base64.getDecoder().decode(str);
    }

   


}