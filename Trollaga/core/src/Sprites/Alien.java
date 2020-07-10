package Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import helpers.CollisionRectangle;


public class Alien extends Sprite {


    private long startTime;
    private Texture alienImage;
    private int direction;
    float x, y;
    CollisionRectangle rectangle;
    public boolean remove = false;


    public Alien(float x, float y) {
        this.x = x;
        this.y = y;
        this.rectangle = new CollisionRectangle(x, y, 16, 16);
        if (alienImage == null) {
            alienImage = new Texture(Gdx.files.internal("Sprites/Alien/Enemy.png"));

        }

        direction = 1;
    }

    public void updateAliens() {
        if (x > 460) {
            direction = -1;
            y -= 20;
        } else if (x < 20) {
            direction = 1;
            y -=20;
        }
            rectangle.move((x += direction * 10 * Gdx.graphics.getDeltaTime()), y);

//        if(TimeUtils.timeSinceNanos(startTime)>1000000000 && aliens.size< 0)
//        {
//            startTime = TimeUtils.nanoTime();
//        }

        if(y < -16){
            remove = true;
        }

        }

    public void renderAliens(SpriteBatch batch){
        batch.draw(alienImage, x,y,16, 16);

        }

    public CollisionRectangle checkCollision() {
        return rectangle;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }


}




