import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickersGenerator {
  
  public void Create(InputStream inputStream, String fileName, String text) throws Exception {

    BufferedImage originalImage = ImageIO.read(inputStream);
    int width = originalImage.getWidth();
    int height = originalImage.getHeight();
    int newHeight = (int) Math.round(1.2 * height);

    BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

    Graphics2D graphics = (Graphics2D) newImage.getGraphics();
    graphics.drawImage(originalImage, 0, 0, null);

    int fontSize = 100;
    int textWidth = text.length() * (fontSize / 2);
    Font font = new Font(Font.SANS_SERIF, Font.BOLD, fontSize);
    graphics.setColor(Color.BLUE);
    graphics.setFont(font);
    int stringHeigth = (int) Math.round(newHeight - (height * 0.1));
    int stringWidth = (int) Math.round((width - textWidth) /2);
    graphics.drawString(text, stringWidth, stringHeigth);

    ImageIO.write(newImage, "png", new File("asset/" + fileName));
  }
}
