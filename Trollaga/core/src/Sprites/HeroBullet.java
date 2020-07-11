package Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import helpers.GameInfo;

public class HeroBullet extends Bullet{

    public float x, y;
    private static Texture texture;
    public boolean remove = false;
    public static final int WIDTH = 4;
    public static final int HEIGHT = 12;



    public HeroBullet(float x, float y){
        this.x = x;
        this.y = y;
        texture = new Texture("Sprites/Bullet/HeroBullet.png");

    }
    @Override
    public void updateBullet(float deltaTime){
        y += 500 * deltaTime;

        if(y> GameInfo.HEIGHT){
            remove = true;
        }


    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x ,y);

    }


}
