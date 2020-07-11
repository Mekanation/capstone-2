package Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;


public class Aliens extends Rectangle {


    private long startTime;
    private Texture alienImage;
    private int direction;
    private Array<Rectangle> aliens;
    private boolean remove = false;
    float x, y;
    long alienShotTimer = 0;
    long shotDelay = 500;


    public Aliens() {
        alienImage = new Texture(Gdx.files.internal("Sprites/Alien/Enemy.png"));
        direction = 1;
        aliens = new Array<>();

    }

    public void updateAliens() {
        moveAliens();

        if (TimeUtils.timeSinceNanos(startTime) > 1000000000 && aliens.size == 0) {

            spawnMultipleAliens();
            startTime = TimeUtils.nanoTime();
        }
    }



    public void renderAliens(SpriteBatch batch){
        for(Rectangle alien : aliens) {
            batch.draw(alienImage, alien.x, alien.y);

        }
    }



    public void spawnMultipleAliens(){
        int width = 16, height = 800-32;
        int numberOfRows = 0;
        while(numberOfRows < 3) {
            for (int i = 0; i < 15; i++) {
                Rectangle alien = new Rectangle();
                alien.x = width;
                alien.y = height;
                alien.width = 16;
                alien.height = 16;
                aliens.add(alien);
                width += 30;

            }
            numberOfRows++;
            height -= 30;
            width = 16;
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

    public Array<Rectangle> getAliens(){

       return aliens;
    }

    public void removeAlien(Rectangle alien){
            aliens.removeValue(alien, true);
    }

    public void aliensShootBack(Array<AlienBullet> alienBullets, Sound alienPew){
        if(TimeUtils.nanosToMillis(TimeUtils.nanoTime()) - alienShotTimer > shotDelay && aliens.size > 0){
            Rectangle alienToShoot = aliens.random();
            if(alienToShoot != null){
                alienPew.play();
                alienBullets.add(new AlienBullet(alienToShoot.x, alienToShoot.y -10));
                alienShotTimer = TimeUtils.nanosToMillis(TimeUtils.nanoTime());
            }
        }
    }



    @Override
    public String toString() {
        return "Aliens{" +
                "aliens=" + aliens +
                '}';
    }
}




