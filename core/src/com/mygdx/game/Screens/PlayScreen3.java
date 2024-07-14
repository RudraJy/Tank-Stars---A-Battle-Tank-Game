package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.TankStars;

public class PlayScreen3 implements Screen {
    private TankStars game;
    private Skin skin;
    private Stage stage;
    private Viewport gamePort;
    private OrthographicCamera gamecam;


    Texture texture;
    private Image bg_img;

    public PlayScreen3(TankStars game) {
        this.game = game;
        gamecam = new OrthographicCamera(TankStars.WIDTH,TankStars.HEIGHT);
        gamePort = new FitViewport(TankStars.WIDTH,TankStars.HEIGHT,gamecam);
        skin = new Skin(Gdx.files.internal("skin3/clean-crispy-ui.json"));
        stage = new Stage(gamePort);

        texture = new Texture("background.png");
        bg_img = new Image(texture);
        bg_img.setBounds(0,0, gamePort.getScreenWidth()/2 + 80, gamePort.getScreenHeight()/2 + 40);
        stage.addActor(bg_img);

        TextButton layout = new TextButton("",skin,"default");
        layout.setColor( 0,(float)0.39373153,(float)0.4333333,1);
        layout.setSize(150,120);
        layout.setPosition(126,50);
        stage.addActor(layout);

        TextButton but1 = new TextButton("Resume",skin,"toggle");
        but1.getLabel().setFontScale((float) 0.6);
        but1.setColor(1,1,0,1);
        but1.setSize(70,30);
        but1.setPosition(165,130);
        stage.addActor(but1);

        TextButton but2 = new TextButton("Save Game",skin,"toggle");
        but2.getLabel().setFontScale((float) 0.6);
        but2.setColor(1,1,0,1);
        but2.setSize(70,30);
        but2.setPosition(165,95);
        stage.addActor(but2);

        TextButton but3 = new TextButton("Main Menu",skin,"toggle");
        but3.getLabel().setFontScale((float) 0.6);
        but3.setColor(1,1,0,1);
        but3.setSize(70,30);
        but3.setPosition(165,60);
        stage.addActor(but3);



}


    @Override
    public void show() {

    }

    public void handleInput(float q) {
    }

    public void update(float p) {
    }


    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();






    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height,true);
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
