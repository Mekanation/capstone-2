package scenes;


import Sprites.Alien;
import Sprites.Hero;
import Sprites.HeroBullet;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.trollaga.game.GameMain;
import helpers.GameInfo;

public class GamePlay implements Screen {

    private GameMain game;
    private OrthographicCamera mainCamera;
    private Viewport gameViewport;
    private Sprite bgs;
    private HeroBullet heroBullet;
    private Hero hero;
    private Alien alien;
    private Array<HeroBullet> heroBullets;
    private Array<Rectangle> aliens;




    public GamePlay(GameMain game){
        this.game = game;
        mainCamera = new OrthographicCamera(GameInfo.WIDTH, GameInfo.HEIGHT);
        mainCamera.position.set(GameInfo.WIDTH /2f,GameInfo.HEIGHT / 2f,0);

        gameViewport = new StretchViewport(GameInfo.WIDTH, GameInfo.HEIGHT,mainCamera);

        createBackground();
        alien = new Alien(GameInfo.WIDTH/2f,GameInfo.HEIGHT - 16);
        hero = new Hero(GameInfo.WIDTH/2f , 16f);








    }

    void createBackground(){
            bgs = new Sprite(new Texture("backgrounds/spacebackground.jpg"));
            bgs.setPosition(0,0);
    }
    void drawBackground(){
        game.getBatch().draw(bgs,bgs.getX(),bgs.getY());
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();

        drawBackground();
        hero.drawHero(game.getBatch());
        alien.renderAliens(game.getBatch());
        alien.updateAliens();

        game.getBatch().end();

        game.getBatch().setProjectionMatrix(mainCamera.combined);
        mainCamera.update();
        hero.heroControls();




    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }




}



