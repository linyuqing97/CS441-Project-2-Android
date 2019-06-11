package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;

import java.awt.Shape;

public class MyGdxGame extends Game {


	public SpriteBatch batch;
	private BitmapFont font;
	private OrthographicCamera camera;
	private ShapeRenderer sr;
	private Vector3 pos;

	Sprite sprite;
	Sprite img;
	float w,h,tw,th = 0;


	@Override
	public void create () {
		sr = new ShapeRenderer();
		camera = new OrthographicCamera();
		camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());


		pos = new Vector3(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2,0);


	}

	@Override
	public void render () {
		camera.update();


		if(Gdx.input.isTouched()){
			pos.set(Gdx.input.getX(),Gdx.input.getY(),0);
			camera.unproject(pos);


		}



		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setColor(Color.BLUE);
		sr.circle(pos.x,pos.y,64);
		sr.end();

	}
	
	@Override
	public void dispose () {
	sr.dispose();
	}
}
