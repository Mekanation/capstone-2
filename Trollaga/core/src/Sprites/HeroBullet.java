package Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import helpers.CollisionRectangle;
import helpers.GameInfo;

public class HeroBullet extends Bullet{

    private float x, y;
    private static Texture texture;
    public boolean remove = false;

    CollisionRectangle rectangle;

    public HeroBullet(float x, float y){
        this.x =x;
        this.y = y;
        this.rectangle = new CollisionRectangle(x,y, 4,8);
        if(texture == null){
            texture = new Texture("Sprites/Bullet/HeroBullet.png");
        }

    }
    @Override
    public void updateBullet(){
        y += 10;
        if(y> GameInfo.HEIGHT){
            remove = true;
        }
        rectangle.move(x, y);
    }


    public void render(SpriteBatch batch) {
        batch.draw(texture, x ,y);

    }

    public CollisionRectangle checkCollision(){
        return rectangle;
    }
}
