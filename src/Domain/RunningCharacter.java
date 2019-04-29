package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

//import javafx.scene.image.ImageView;
public class RunningCharacter extends Character {

    public RunningCharacter(int x, int y, int imgNum) throws FileNotFoundException {
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
        sprite.add(new Image(new FileInputStream("src/Assets/Running5.png")));
        super.setSprite(sprite);
        sprite.add(new Image(new FileInputStream("src/Assets/Running6.png")));
        super.setSprite(sprite);
        sprite.add(new Image(new FileInputStream("src/Assets/Running7.png")));
        super.setSprite(sprite);

        //Hacia la Izquierda
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
        sprite.add(new Image(new FileInputStream("src/Assets/Running5.1.png")));
        super.setSprite(sprite);
        sprite.add(new Image(new FileInputStream("src/Assets/Running6.1.png")));
        super.setSprite(sprite);
        sprite.add(new Image(new FileInputStream("src/Assets/Running7.1.png")));
        super.setSprite(sprite);

    }

    @Override
    public void run() {

        int x = 0;
        
        ArrayList<Image> sprite = super.getSprite();
        while (true) {
            try {
                
                if ( x <= 500) {
                    for (int i = 0; i < 8; i++) {
                          
                        super.setImage(sprite.get(i));
                        super.setX(x);
                        Thread.sleep(150);
                        x += 25; 
                        

                    }
                }else while(x>=100){
                    for (int i = 9; i < sprite.size(); i++) {
                        super.setImage(sprite.get(i));
                        super.setX(x);
                        Thread.sleep(150);
                        x -= 25;
                    }
                }
                
                
            }
            catch (InterruptedException ex) {}

        }

    }
}
