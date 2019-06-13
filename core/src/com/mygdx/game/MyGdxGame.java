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
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.awt.Shape;

public class MyGdxGame extends ApplicationAdapter implements GestureDetector.GestureListener {


	public SpriteBatch batch;
	public Sprite sprite;
	private Texture img;
	OrthographicCamera camera;
	GestureDetector gestureDetector;



	@Override
	public void create () {
		batch = new SpriteBatch();

		sprite = new Sprite(new Texture(Gdx.files.internal("badlogic.jpg")));
		sprite.setPosition(-sprite.getWidth()/2,-sprite.getHeight()/2);
		sprite.setCenter(0.5f,0.5f);
		camera = new OrthographicCamera(1280,720);
		camera.update();
		gestureDetector = new GestureDetector(this);
		Gdx.input.setInputProcessor(gestureDetector);

	}

	@Override
	public void render () {

		camera.update();


		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		sprite.draw(batch);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();

	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		if(count >1){
			sprite.setPosition(-sprite.getWidth()/2,-sprite.getHeight()/2);
			sprite.setSize(256f,256f);
			sprite.setRotation(0f);

		}
		else {
	    Vector3 touchPosition = new Vector3 (x,y,0);
	    camera.unproject(touchPosition);
	    sprite.setPosition(touchPosition.x-sprite.getWidth()/2,touchPosition.y-sprite.getHeight()/2);}

		return false;
	}

	@Override
	public boolean longPress(float x, float y) {


		float alpha = sprite.getColor().a;
		if(alpha >= 0.f){
			sprite.setAlpha(alpha-0.25f);
		}
		else{
			sprite.setAlpha(1f);
		}

		return true;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		Vector3 touchPos = new Vector3(x,y,0);
		camera.unproject(touchPos);

		sprite.setPosition(touchPos.x-sprite.getWidth()/2,touchPos.y-sprite.getHeight()/2);


		return true;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		sprite.setSize(distance,distance);

		return true;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {

		float dx = pointer2.x - pointer1.x;
		float dy = pointer2.y - pointer1.y;

		float angle = (float)Math.atan2((double)dy,(double)dx)* MathUtils.radiansToDegrees;

		angle += 90f;

		if(angle<0){
			angle = 360f-(-angle);
		}
		sprite.setRotation(-angle);

		return true;
	}

	@Override
	public void pinchStop() {

	}
}
