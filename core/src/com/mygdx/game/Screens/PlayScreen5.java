package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.ScreenUtils;

import com.mygdx.game.TankStars;


public class PlayScreen5 implements Screen{
    private Texture t1;
    private TankStars game;

    private Rectangle window;

    private OrthographicCamera pov;

    public PlayScreen5(TankStars game){
        this.game = game;
        this.t1 = new Texture(Gdx.files.internal("blazzer_screen.png"));
        pov = new OrthographicCamera();
        pov.setToOrtho(false, 700, 480);
        window = new Rectangle();
        window.x = 0;
        window.y = 0;
        window.width = 700;
        window.height = 480;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float input){
        ScreenUtils.clear(0,0.2902f,0.6784f,1);
        pov.update();
        game.batch.setProjectionMatrix(pov.combined);

        game.batch.begin();
        game.batch.draw(t1,window.x,window.y, window.width, window.height);
        game.batch.end();
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
