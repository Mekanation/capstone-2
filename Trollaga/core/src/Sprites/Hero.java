package Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import helpers.GameInfo;

public class Hero extends Sprite {

    private Texture heroImage;
    private Rectangle hero;
    private int lives;
    private Array<HeroBullet> heroBullets;


    public Hero(){
       heroImage = new Texture(Gdx.files.internal("Sprites/Hero/Hero.png"));
       lives = 3;
       heroBullets = new Array<>();

   }


   public void spawn(){
       hero = new Rectangle();
       hero.x = GameInfo.WIDTH/2f;
       hero.y = 20;
       hero.width = 16;
       hero.height = 16;
   }

   public void drawHero(SpriteBatch batch){
       batch.draw(heroImage, hero.x, hero.y);
       for (HeroBullet heroBullet : heroBullets) {

           heroBullet.render(batch);
           heroBullet.updateHeroBullet();
       }
   }

   public void heroControls(){
       if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) hero.x -= 150 * Gdx.graphics.getDeltaTime();
       if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) hero.x += 150 * Gdx.graphics.getDeltaTime();
       if(Gdx.input.isKeyPressed(Input.Keys.UP)) hero.y += 150 * Gdx.graphics.getDeltaTime();
       if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) hero.y -= 150 * Gdx.graphics.getDeltaTime();
       if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {


           heroBullets.add(new HeroBullet(hero.x, hero.y + 16));
       }

       if(hero.x < 0) hero.x =0;
       if(hero.x > 480 - 16) hero.x = 480 - 16;
       if(hero.y < 16) hero.y = 16;
       if(hero.y > 400) hero.y = 400;




   }

    public int getLives() {
        return lives;
    }
    public float getPosition(){
       return this.hero.getX();
    }

}
