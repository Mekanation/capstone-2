package scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.trollaga.game.GameMain;
import helpers.GameData;

public class MainMenuScreen implements Screen {
    private GameMain game;
    OrthographicCamera camera;
    private Sprite background;
    public MainMenuScreen(GameMain game){
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false,480,800);
        background = new Sprite(new Texture("backgrounds/TrollegaMainMenu.png"));
        background.setPosition(0, 0);

    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);

        game.getBatch().begin();
        game.getBatch().draw(background, background.getX(), background.getY());


        game.getBatch().end();

        if (Gdx.input.isKeyPressed(Input.Keys.T)) {
            game.setScreen(new GamePlay(game));
            dispose();
        }else if(Gdx.input.isKeyPressed(Input.Keys.Z)){
            GameData.zenMode = true;
            game.setScreen(new ZenMode(game));
            dispose();
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
        //this method is to hide the android buttons on the mobile phone. We do not need as I am not making for mobile. example
        /*
         * View.SYSTEM_UI_FLAG_IMMERSIVE  - With this option, all buttons and the system bar are hidden.
         * When them are shown again, they keep on the screen until we explicitly hide them.
         * */

    }

    @Override
    public void dispose() {
        //I cannot dispose of anything here or the next screens will not render due to the assets being trashed and not existing.
    }
}
