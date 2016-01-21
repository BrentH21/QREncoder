


import com.xuggle.mediatool.IMediaWriter;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.xuggler.ICodec;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class basictest {
    public static void main(String[] args) throws IOException {
        
        byte[] bFile = StaticUtilities.filetobyte("E:\\test\\pretty.jpg");
        String st = StaticUtilities.byteToString(bFile);
        byte[] newByte = StaticUtilities.stringToByte(st);
        StaticUtilities.byteToFile(newByte, "E://test//output.jpg");
    }
}
