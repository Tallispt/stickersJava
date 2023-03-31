import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
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

    int fontSize = 32;
    Font font = new Font(Font.SANS_SERIF, Font.BOLD, fontSize);
    graphics.setColor(Color.CYAN);
    FontMetrics metrics = graphics.getFontMetrics(font);
    while (metrics.stringWidth(text) + 240 < width) {   
      fontSize = fontSize + 2;
      font = new Font(Font.SANS_SERIF, Font.BOLD, fontSize);
      graphics.setColor(Color.CYAN);
      metrics = graphics.getFontMetrics(font);
    }

    int x = (width - metrics.stringWidth(text)) / 2;
    int y = height + (((newHeight - height) - metrics.getHeight()) / 2) + metrics.getAscent();

    graphics.setFont(font);
    graphics.drawString(text, x, y);

    ImageIO.write(newImage, "png", new File("asset/" + fileName));
  }
}
