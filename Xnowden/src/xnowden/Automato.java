package xnowden;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Automato {
    
    Robot rob;
    
    public Automato() throws AWTException{
        rob = new Robot();
    }
    
    public void takePicture() throws AWTException, IOException{
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        
        ImageIO.write(image, "jpg", new File("C:/Users/Henrique/Documents/NetBeansProjects/Xnowden/Xnowden/screenshot.jpg"));
    }
    
}
