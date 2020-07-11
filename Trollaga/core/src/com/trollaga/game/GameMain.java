package com.trollaga.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import scenes.GamePlay;

public class GameMain extends Game {
	SpriteBatch batch;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new GamePlay(this));


	}

	@Override
	public void render () { /* This is actually needed, From the docs on why: A common mistake is to forget to call super.render() with a Game implementation. Without this call, the Screen that you set in the create() method will not be rendered properly*/
	super.render();

	}
	
	@Override
	public void dispose () {

	}
	public SpriteBatch getBatch(){
		return this.batch;
	}
}
