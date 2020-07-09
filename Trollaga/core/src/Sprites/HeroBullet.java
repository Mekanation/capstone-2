package Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import helpers.GameInfo;

public class HeroBullet extends Bullet{

    private float x, y;
    private static Texture texture;
    public boolean remove = false;
    private Rectangle heroBullet;

    public HeroBullet(float x, float y){
        this.x =x;
        this.y = y;
        if(texture == null){
            texture = new Texture("Sprites/Bullet/HeroBullet.png");
        }
        heroBullet = new Rectangle();
        heroBullet.x = x;
        heroBullet.y = y;
        heroBullet.width = 4;
        heroBullet.height = 8;

    }

    public void updateHeroBullet(){
        heroBullet.y += 10;
        if(heroBullet.y> GameInfo.HEIGHT){
            remove = true;
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(texture, heroBullet.x ,heroBullet.y);

    }
}
