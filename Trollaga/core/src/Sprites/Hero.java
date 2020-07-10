package Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import helpers.CollisionRectangle;
import helpers.GameInfo;

public class Hero extends Sprite {

    private Texture heroImage;
    private int lives;
    CollisionRectangle hero;
    public boolean hit = true;
    float x,y;


    public Hero(float x, float y){
        lives = 3;
        this.x = x;
        this.y = y;
        this.hero = new CollisionRectangle(GameInfo.WIDTH/2f, y, 16, 16);
        if (heroImage == null) {
            heroImage = new Texture(Gdx.files.internal("Sprites/Hero/Hero.png"));

        }

    }

   public void drawHero(SpriteBatch batch){
       batch.draw(heroImage, x, y);

   }

   public void heroControls(){
       if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) x -= 150 * Gdx.graphics.getDeltaTime();
       if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) x += 150 * Gdx.graphics.getDeltaTime();
       if(Gdx.input.isKeyPressed(Input.Keys.UP)) y += 150 * Gdx.graphics.getDeltaTime();
       if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) y -= 150 * Gdx.graphics.getDeltaTime();
       if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {

       }

       if(x < 0) x =0;
       if(x > 480 - 16) x = 480 - 16;
       if(y < 16) y = 16;
       if(y > 400) y = 400;




   }

    public int getLives() {
        return lives;
    }


}
