package Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;


public class Alien extends Sprite {

    private Array<Rectangle> aliens;
    private long startTime;
    private Texture alienImage;
    private Array<Array<Rectangle>> rows;
    private int direction;


    public Alien(){
        alienImage = new Texture(Gdx.files.internal("Sprites/Alien/Enemy.png"));
        aliens = new Array<>();
        rows = new Array<>();
        rows.add(new Array<Rectangle>());
        rows.add(new Array<Rectangle>());
        rows.add(new Array<Rectangle>());
        direction = 1;
    }

    public void updateAliens(){
        moveAliens();
        if (TimeUtils.timeSinceNanos(startTime) > 1000000000 && aliens.size < 0) {
            rows.add(new Array<Rectangle>());
            spawn();
            startTime = TimeUtils.nanoTime();
        }
    }

    public void spawn(){
        int width = 16, height = 800-32;
        for(Array<Rectangle> row: rows) {
            for (int i = 0; i < 15; i++) {
                Rectangle alien = new Rectangle();
                alien.x = width;
                alien.y = height;
                alien.width = 16;
                alien.height = 16;
                aliens.add(alien);
                width += 30;

            }
            height -= 30;
            width = 16;
        }
        }

    public void renderAliens(SpriteBatch batch){
        for(Rectangle alien: aliens){
                batch.draw(alienImage, alien.x,alien.y);
            }

        }

    void moveAliens(){
        for(Rectangle alien: aliens){
            if(alien.getX() > 460){
                direction = -1;
            }else if(alien.getX() < 20){
                direction = 1;
            }
            alien.setPosition((alien.x += direction * 5 * Gdx.graphics.getDeltaTime()), alien.y);
            }

        }



    }




