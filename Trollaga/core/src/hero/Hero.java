package hero;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;
import helpers.GameInfo;

public class Hero extends Sprite {

    private World world;
    private Body body;

    public Hero(World world, float x, float y){
        super(new Texture("Sprites/Hero/Hero.png"));
        this.world = world;
        setPosition(x, y);
        createBody();
    }

    void createBody(){
        BodyDef bodyDef = new BodyDef();

        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(getX()/ GameInfo.PPM, getY() /GameInfo.PPM);

        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox((getWidth()/2f) / GameInfo.PPM, (getHeight()/2f) / GameInfo.PPM);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;

        Fixture fixture = body.createFixture((fixtureDef));

        shape.dispose();
    }
    public void drawHero(SpriteBatch batch){
        batch.draw(this, getX() - getWidth() /2f, getY() - getHeight() /2f);
    }
    public void updateHero(){
        setPosition(body.getPosition().x *GameInfo.PPM, body.getPosition().y * GameInfo.PPM);
    }

}
