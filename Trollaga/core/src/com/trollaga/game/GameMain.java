package com.trollaga.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import scenes.MainMenuScreen;

public class GameMain extends Game {
	private SpriteBatch batch;
	public BitmapFont font;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		this.setScreen(new MainMenuScreen(this));


	}

	@Override
	public void render () { /* This is actually needed, From the docs on why: A common mistake is to forget to call super.render() with a Game implementation. Without this call, the Screen that you set in the create() method will not be rendered properly*/
	super.render();
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			dispose();
		}

	}
	
	@Override
	public void dispose () {
	batch.dispose();
	font.dispose();
	System.exit(0);
	}
	public SpriteBatch getBatch(){
		return this.batch;
	}
}
