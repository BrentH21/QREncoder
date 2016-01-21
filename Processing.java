import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;


public  class Processing{    
    public static void videoToFile(String videoPath, String filePath) throws IOException{
        
        VideoSource video = new VideoSource("file://"+videoPath);

        video.initialize();
        while (video.getState()==VideoSource.NOT_READY) { 
            try { Thread.sleep(100); } catch (Exception e) { } 
        } 
        StringBuilder r = new StringBuilder();
        BufferedImage temp;
        BinaryBitmap binaryBitmap;
        Result result = null;
        ByteArrayOutputStream os;
        InputStream is;
       
       File f1;

       for (int x=0; x<video.getFrameCount(); x++){
                temp = video.getFrame(x);
                os = new ByteArrayOutputStream();
                ImageIO.write(temp, "jpg", os);
                is = new ByteArrayInputStream(os.toByteArray());
                binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(is))));
                try{
                    result = new MultiFormatReader().decode(binaryBitmap);
                    r.append(result.getText());
                }
                catch(Exception e){
                    
                    continue;
                }
                       
       }   
        byte[] finalbyte = StaticUtilities.stringToByte(r.toString());
        StaticUtilities.byteToFile(finalbyte, filePath);
        System.out.println("Done");
       
    }
    
    //creates a video of qr codes from a specified filePath        
    public static void createVideo(String filePath, String videoPath) throws Exception{
        byte[] bFile = StaticUtilities.filetobyte(filePath);
        //st = string of bytes of input file
        String st = StaticUtilities.byteToString(bFile);
        
        StringBuilder strB = new StringBuilder(st);
  
        int qrnum = strB.length()/900;    
        File file = new File(videoPath);
        MJPEGGenerator video = new MJPEGGenerator(file, 250,250,10,qrnum+1);
        ByteArrayOutputStream out;
        ByteArrayInputStream in;
        BufferedImage frame;
        BufferedImage finalFrame;
        long startTime = System.nanoTime();
 
        for (int i=0;i<qrnum;i++ ){

            String temp = strB.substring(0,900);
            strB.delete(0,900);
            out = QRCode.from(temp).to(ImageType.JPG).stream();
            byte[] data = out.toByteArray();
            in = new ByteArrayInputStream(data);
            frame = ImageIO.read(in);
         
            video.addImage(frame);
        }     
        out = QRCode.from(strB.toString()).to(ImageType.JPG).stream();
        byte[] data = out.toByteArray();
        in = new ByteArrayInputStream(data);
        frame = ImageIO.read(in);
            
        video.addImage(frame);
        
        
        
        video.finishAVI();
    }

}
