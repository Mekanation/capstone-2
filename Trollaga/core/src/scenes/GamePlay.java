package scenes;


import Sprites.AlienBullet;
import Sprites.Aliens;
import Sprites.Hero;
import Sprites.HeroBullet;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.trollaga.game.GameMain;
import helpers.GameData;
import helpers.GameInfo;

public class GamePlay implements Screen {

    private GameMain game;
    private OrthographicCamera mainCamera;
    private Viewport gameViewport;
    private Sprite bgs;
    private Hero hero = new Hero();
    private Aliens aliens = new Aliens();
    private Array<HeroBullet> heroBullets = new Array<>();
    private Array<AlienBullet> alienBullets = new Array<>();
    private Music hardmode;
    private Sound alienPew, heroPew, deathSound, finalDeathSound, explosion;




    public GamePlay(GameMain game) {
        this.game = game;
        mainCamera = new OrthographicCamera(GameInfo.WIDTH, GameInfo.HEIGHT);
        mainCamera.position.set(GameInfo.WIDTH / 2f, GameInfo.HEIGHT / 2f, 0);
        gameViewport = new StretchViewport(GameInfo.WIDTH, GameInfo.HEIGHT, mainCamera);
        alienPew = Gdx.audio.newSound(Gdx.files.internal("sounds/alienPew.mp3"));
        heroPew = Gdx.audio.newSound(Gdx.files.internal("sounds/pew.mp3"));
        deathSound = Gdx.audio.newSound(Gdx.files.internal("sounds/deathsound.mp3"));
        finalDeathSound = Gdx.audio.newSound(Gdx.files.internal("sounds/finaldeath.mp3"));
        explosion = Gdx.audio.newSound(Gdx.files.internal("sounds/explosion.mp3"));

        hardmode = Gdx.audio.newMusic(Gdx.files.internal("sounds/Headhunterz - The Sacrifice (HQ).mp3"));
        hardmode.setLooping(true);
        hardmode.play();
        hero.spawn(heroBullets);
        createBackground();
        aliens.spawnMultipleAliens();







    }

    void createBackground() {
        bgs = new Sprite(new Texture("backgrounds/spacebackground.jpg"));
        bgs.setPosition(0, 0);
    }

    void drawBackground() {
        game.getBatch().draw(bgs, bgs.getX(), bgs.getY());
    }


    @Override
    public void show() {

    }


    @Override
    public void render(float delta) { /*The render method in libgdx also behaves similar to an update method in other game engines. Therefor render actually means update AND render.  */

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();

        drawBackground();
        hero.drawHero(game.getBatch());
        aliens.renderAliens(game.getBatch());
        for(HeroBullet heroBullet : heroBullets){
            heroBullet.render(game.getBatch());
        }
        for(AlienBullet alienBullet : alienBullets){
            alienBullet.render(game.getBatch());
        }

        game.getBatch().end();
        game.getBatch().setProjectionMatrix(mainCamera.combined);

        //updates
        mainCamera.update();
        hero.heroControls(heroPew);
        aliens.updateAliens();
        aliens.aliensShootBack(alienBullets, alienPew);

        for(AlienBullet alienBullet: alienBullets){
            UpdateAlienBullets(alienBullet);
            if(hero.getLives() == 0){
                finalDeathSound.play();
            }
            if(alienBullet.overlaps(hero.getHero())){
                deathSound.play();
                alienBullets.removeValue(alienBullet, true);
                hero.setLives(hero.getLives() -1);
            }
        }
        for (HeroBullet heroBullet : heroBullets) {
            UpdateHeroBullets(heroBullet);
            for (Rectangle alien : aliens.getAliens()) {
                if (heroBullet.overlaps(alien)) {
                    aliens.removeAlien(alien);
                    explosion.play();
                    heroBullets.removeValue(heroBullet, true);
                    GameData.score +=100;
                }
            }


        }

    }




    @Override
    public void resize(int width, int height) {
        //this method is not needed for my simple game. This is mainly used for different display resolutions for desktop or android games.
    }

    @Override
    public void pause() {
        //this method is not needed for my simple game. It is used if the user exits the app on their phone and pauses the state until they return. This can be extended to allow for custom pause and unpause functionality.
    }

    @Override
    public void resume() {
        //this method is not needed for my simple game. It is used if the user exits the app on their phone and pauses the state until they return. This can be extended to allow for custom pause and unpause functionality.

    }

    @Override
    public void hide() {
        //this method is to hide the android buttons on the mobile phone. We do not need as I am not making for mobile.

    }

    @Override
    public void dispose() {
        hardmode.dispose();
        alienPew.dispose();
        heroPew.dispose();
        deathSound.dispose();
        finalDeathSound.dispose();
        explosion.dispose();
        game.getBatch().dispose();
    }

    //begin update logic
    private void UpdateHeroBullets(HeroBullet heroBullet) {
        heroBullet.updateBullet(Gdx.graphics.getDeltaTime());
        heroBullet.setPosition(heroBullet.x,heroBullet.y);
        if(heroBullet.y > GameInfo.HEIGHT){
            heroBullets.removeValue(heroBullet, true);
        }
    }

    private void UpdateAlienBullets(AlienBullet alienBullet){
        alienBullet.updateBullet(Gdx.graphics.getDeltaTime());
        alienBullet.setPosition(alienBullet.x,alienBullet.y);
        if(alienBullet.y < GameInfo.SPRITE_HEIGHT){
            alienBullets.removeValue(alienBullet, true);
        }
    }

}



