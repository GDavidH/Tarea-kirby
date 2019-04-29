package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class JumpingCharacter extends Character {

    public JumpingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        sprite.add(new Image(new FileInputStream("src/Assets/Jumping0.png")));
        super.setSprite(sprite);
        sprite.add(new Image(new FileInputStream("src/Assets/Jumping1.png")));
        super.setSprite(sprite);
        sprite.add(new Image(new FileInputStream("src/Assets/Jumping2.png")));
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        int y = 370;
        while (true) {
            try {
                
                while (y > 195) {
                    this.setY(y);
                    super.setImage(sprite.get(0));
                    Thread.sleep(200);
                    y -= 25;
                }
                
                while ( y < 370) {
                    this.setY(y);
                    super.setImage(sprite.get(1));
                    Thread.sleep(150);
                    y += 25;
                }

                this.setY(370);
                super.setImage(sprite.get(2));
                Thread.sleep(300);

            } catch (InterruptedException ex) {
            }
        }

    }
}
