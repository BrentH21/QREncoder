// get QR file from text using defaults
import java.io.*;
import net.glxn.qrgen.*;
import net.glxn.qrgen.image.*;

import javax.media.MediaLocator;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Vector;

//import com.google.zxing.qrcode.*;
public class qr {


    public static void main(String[] args) {

        //riage returns do count. With regard to those spaces, note that if you typically type a double-space at the end of a sentence as I do before beginning a new sentence in the same paragraph, the second space will be deleted automatically, i.e., all but the first space will be ignored. The total number of words in this paragraph is 733 and the average word length is 4.4 characters. The average number of words per sentence is 22. At the end of this paragraph is simply the alphabet starting with the letter A and ending with the letter H, in bold, to make it come out to exactly 4,000 characters and so you'll know when to stop scrolling down in order to see how big 4,000 character is if you want to add a message to the guestbook. Whew. This paragraph begins to repeat at this point, so you can stop reading now if you want to, which I would suggest, or you can choose to read it all again. This rather long paragraph consists of exactly 4,000 characters. Spaces, punctuation marks and carriage returns do count. With regard to those spaces, note that if you typically type a double-space at the end of a sentence as I do before beginning a new sentence in the same paragraph, the second space will be deleted automatically, i.e., all but the first space will be ignored. The total number of words in this paragraph is 733 and the average word length is 4.4 characters. The average number of words per sentence is 22. At the end of this paragraph is simply the alphabet starting with the letter A and ending with the letter H, in bold, to make it come out to exactly 4,000 characters and so you'll know when to stop scrolling down in order to see how big 4,000 character is if you want to add a message to the guestbook. Whew. This paragraph begins to repeat at this point, so you can stop reading now if you want to, which I would suggest, or you can choose to read it all again. This rather long paragraph consists of exactly 4,000 characters. Spaces, punctuation marks and carriage returns do count. With regard to those spaces, note that if you typically type a double-space at the end of a sentence as I do before beginning a new sentence in the same paragraph, the ").file();
// get QR stream from text using defaults
ByteArrayOutputStream out = QRCode.from("test.png").to(ImageType.JPG).stream();
//File f = new File("D:\\beanman.jpg");
        //  f = QRCode.from("beanstock").to(ImageType.PNG).file();
        //System.out.println("success");



    try {
        FileOutputStream fout = new FileOutputStream(new File(
                "D:\\resolution.jpg"));

        fout.write(out.toByteArray());

        fout.flush();
        fout.close();
        System.out.println("gotit");
    } catch (FileNotFoundException e) {
        // Do Logging
        System.out.println("ger");
    } catch (IOException e) {
        // Do Logging
    }

    }


}
