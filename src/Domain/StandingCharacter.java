package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class StandingCharacter extends Character {

    public StandingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }
    
    public void setSprite() throws FileNotFoundException{
        ArrayList<Image> sprite = super.getSprite();
        
            sprite.add(new Image(new FileInputStream("src/Assets/Standing0.png")));
            super.setSprite(sprite);
            
            sprite.add(new Image(new FileInputStream("src/Assets/Standing1.png")));
            super.setSprite(sprite);
            
            sprite.add(new Image(new FileInputStream("src/Assets/Standing2.png")));
            super.setSprite(sprite);
            
            sprite.add(new Image(new FileInputStream("src/Assets/Standing3.png")));
            super.setSprite(sprite);
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        
        while (true) {
            try {
                for (int i = 0; i <4 ; i++) {
                  super.setImage(sprite.get(i));
                  Thread.sleep(550);
                }
                
            } 
            catch (InterruptedException ex) { }
        }
    }
}
