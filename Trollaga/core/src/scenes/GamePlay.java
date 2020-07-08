package scenes;


import aliens.AlienController;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.trollaga.game.GameMain;
import helpers.GameInfo;

public class GamePlay implements Screen {

    private GameMain game;
    private OrthographicCamera mainCamera;
    private Viewport gameViewport;

    private OrthographicCamera box2DCamera;
    private Box2DDebugRenderer debugRenderer;

    private World world;

    private Sprite bgs;
    private AlienController alienController;

    public GamePlay(GameMain game){
        this.game = game;
        mainCamera = new OrthographicCamera(GameInfo.WIDTH, GameInfo.HEIGHT);
        mainCamera.position.set(GameInfo.WIDTH /2f,GameInfo.HEIGHT / 2f,0);

        gameViewport = new StretchViewport(GameInfo.WIDTH, GameInfo.HEIGHT,mainCamera);

        box2DCamera = new OrthographicCamera();
        box2DCamera.setToOrtho(false, GameInfo.WIDTH / GameInfo.PPM, GameInfo.HEIGHT / GameInfo.PPM);
        box2DCamera.position.set(GameInfo.WIDTH/2f, GameInfo.HEIGHT /2f, 0);

        debugRenderer = new Box2DDebugRenderer();
        world = new World(new Vector2(0, 0), true);

        alienController = new AlienController(world);



        createBackground();
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
        alienController.drawAliens((game.getBatch()));

        game.getBatch().end();

        debugRenderer.render(world,box2DCamera.combined);

        game.getBatch().setProjectionMatrix(mainCamera.combined);
        mainCamera.update();
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