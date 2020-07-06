package com.mygdx.trollaga;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class TrollagaGame extends ApplicationAdapter {
	Sprite hero;
	SpriteBatch batch;
	TextureAtlas textureAtlas;
	
	@Override
	public void create () {
		textureAtlas = new TextureAtlas("sprites.txt");
		hero = textureAtlas.createSprite("sprite7");
		batch= new SpriteBatch();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		hero.draw(batch);
		batch.end();


	}
	
	@Override
	public void dispose () {

		textureAtlas.dispose();
	}
}
