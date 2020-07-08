package aliens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import helpers.GameInfo;


public class AlienController {

    private World world;

    private Array<Alien> aliens = new Array<Alien>();

    private final float DISTANCE_BETWEEN_ALIENS = 20f;
    public AlienController(World world){
        this.world = world;
        createAliens();
        positionAliens();
    }
    void createAliens(){
        for(int i = 0; i<6; i++){
            aliens.add(new Alien(world));
        }
    }

    public void positionAliens(){
        float positionX = GameInfo.WIDTH /2f;
        float tempY = GameInfo.WIDTH /2f;

        for(Alien a: aliens){
            a.setSpritePosition(positionX, tempY);

            positionX -= DISTANCE_BETWEEN_ALIENS;
        }

    }

    public void drawAliens(SpriteBatch batch){
        for(Alien a : aliens){
            batch.draw(a, a.getX() - a.getWidth() / 2f,a.getY() - a.getHeight() / 2f);
        }

    }

}
