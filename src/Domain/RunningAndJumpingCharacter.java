package Domain;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;

//import javafx.scene.image.ImageView;
public class RunningAndJumpingCharacter extends Character {

    private PixelReader pixel;
    private Image image;

    public RunningAndJumpingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        //Hacia la derecha
        sprite.add(new Image(new FileInputStream("src/Assets/Running0.png")));
        super.setSprite(sprite);
        sprite.add(new Image(new FileInputStream("src/Assets/Running1.png")));
        super.setSprite(sprite);
        sprite.add(new Image(new FileInputStream("src/Assets/Running2.png")));
        super.setSprite(sprite);
        sprite.add(new Image(new FileInputStream("src/Assets/Running3.png")));
        super.setSprite(sprite);
        sprite.add(new Image(new FileInputStream("src/Assets/Running4.png")));
        super.setSprite(sprite);

        //saltos
        sprite.add(new Image(new FileInputStream("src/Assets/Jumping0.png")));
        super.setSprite(sprite);
        sprite.add(new Image(new FileInputStream("src/Assets/Jumping1.png")));
        super.setSprite(sprite);
        sprite.add(new Image(new FileInputStream("src/Assets/Jumping2.png")));
        super.setSprite(sprite);

        sprite.add(new Image(new FileInputStream("src/Assets/Running0.1.png")));
        super.setSprite(sprite);
        sprite.add(new Image(new FileInputStream("src/Assets/Running1.1.png")));
        super.setSprite(sprite);
        sprite.add(new Image(new FileInputStream("src/Assets/Running2.1.png")));
        super.setSprite(sprite);
        sprite.add(new Image(new FileInputStream("src/Assets/Running3.1.png")));
        super.setSprite(sprite);
        sprite.add(new Image(new FileInputStream("src/Assets/Running4.1.png")));
        super.setSprite(sprite);

        sprite.add(new Image(new FileInputStream("src/Assets/Standing0.1.png")));
        super.setSprite(sprite);

        this.image = new Image(new FileInputStream("src/Assets/Running0.1.png"));
        this.pixel = this.image.getPixelReader();

    }

    @Override
    public void run() {
        boolean run = true;
        int x = 0;
        int y = 500;

        ArrayList<Image> sprite = super.getSprite();
        while (run) {
            try {
                if (x < 225) {
                    for (int i = 0; i < 5; i++) {
                        super.setImage(sprite.get(i));
                        super.setX(x);
                        Thread.sleep(150);
                        x += 15;
                    }
                }

                while (x > 200 && y > 270 && x < 425 || x > 440 && y > 120 && x < 600) {
                    super.setImage(sprite.get(5));
                    super.setY(y);
                    super.setX(x);
                    Thread.sleep(150);
                    y -= 20;
                    x += 10;
                }

                while (x < 470 && y < 370 || x > 450 && y < 250) {
                    super.setImage(sprite.get(6));
                    super.setY(y);
                    super.setX(x);
                    Thread.sleep(150);
                    y += 15;
                    x += 13;
                }

                if (y >= 370 && x > 420) {
                    this.setY(370);
                    super.setImage(sprite.get(0));
                    Thread.sleep(350);
                }

                if (y <= 370 && x > 420) {
                    this.setY(240);
                    super.setImage(sprite.get(0));
                    Thread.sleep(350);
                }

                if (x > 600) {
                    for (int i = 8; i < sprite.size() - 1; i++) {
                        super.setImage(sprite.get(i));
                        super.setX(x);
                        Thread.sleep(210);
                        if (i < sprite.size()) {
                            x -= 25;
                        }
                    }

                    //Recortar imagen
                    int w = 0;
                    int h = 0;
                    int h1 = 50;
                    int w1 = 50;

                    for (int i = 0; i < 6; i++) {

                        WritableImage subImage = new WritableImage(this.pixel, w, h, w1, h1); //Lee los pixeles (imagen, xInicio, yInicio, xFin, yFin)
                        w += 10;
                        w1 -= 5;
                        x -= 2;
                        super.setX(x + 25);
                        super.setImage(subImage);
                        Thread.sleep(210);
                    }
                    WritableImage subImage = new WritableImage(this.pixel, 1, 1, 1, 1); //Lee los pixeles (imagen, xInicio, yInicio, xFin, yFin)
                    super.setImage(subImage);
                    run = false;
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(RunningAndJumpingCharacter.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
