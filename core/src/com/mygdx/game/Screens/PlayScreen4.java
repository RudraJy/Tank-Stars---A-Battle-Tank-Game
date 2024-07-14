package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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

public class PlayScreen4 implements Screen {
    private TankStars game;
    private Skin skin;
    private Stage stage;
    private Viewport gamePort;
    private OrthographicCamera gamecam;


    private Texture texture;
    private Image bg_img;
    private Image tank;
    private Image logo;
    private Image exp1;
    private Image exp2;

    public PlayScreen4(TankStars game) {
        this.game = game;
        gamecam = new OrthographicCamera(TankStars.WIDTH,TankStars.HEIGHT);
        gamePort = new ExtendViewport(TankStars.WIDTH,TankStars.HEIGHT,gamecam);
        skin = new Skin(Gdx.files.internal("skin3/clean-crispy-ui.json"));
        stage = new Stage(gamePort);

        texture = new Texture("homescreen.png");
        bg_img = new Image(texture);
        bg_img.setBounds(0,0, gamePort.getScreenWidth()/2 - 40, gamePort.getScreenHeight()/2 + 20);
        stage.addActor(bg_img);

        texture = new Texture ("explosion.png");
        exp1 = new Image(texture);
        exp1.setSize(220,170);
        exp1.setPosition(5,40);
        stage.addActor(exp1);

        texture = new Texture ("explosion.png");
        exp2 = new Image(texture);
        exp2.setSize(220,170);
        exp2.setPosition(60,40);
        stage.addActor(exp2);


        texture = new Texture("tank_glow.png");
        tank = new Image(texture);
        tank.setSize(120,180);
        tank.setPosition(95,7);
        stage.addActor(tank);


        texture = new Texture ("tank_stars.png");
        logo = new Image(texture);
        logo.setSize(130,100);
        logo.setPosition(80,170);
        stage.addActor(logo);

        TextButton layout = new TextButton("",skin,"default");
        layout.setColor( 0,(float)0.39373153,(float)0.4333333,1);
        layout.setSize(127,215);
        layout.setPosition(277,42);
        stage.addActor(layout);

        TextButton but1 = new TextButton("VS COMPUTER",skin,"toggle");
        but1.getLabel().setFontScale((float) 0.6);
        but1.setColor(1,1,0,1);
        but1.setSize(88,30);
        but1.setPosition(301,221);
        stage.addActor(but1);

        TextButton but2 = new TextButton("VS FRIEND",skin,"toggle");
        but2.getLabel().setFontScale((float) 0.6);
        but2.setColor(1,1,0,1);
        but2.setSize(88,30);
        but2.setPosition(301,186);
        stage.addActor(but2);

        TextButton but3 = new TextButton("LOAD GAME",skin,"toggle");
        but3.getLabel().setFontScale((float) 0.6);
        but3.setColor(1,1,0,1);
        but3.setSize(88,30);
        but3.setPosition(301,151);
        stage.addActor(but3);

        TextButton but4 = new TextButton("CHOOSE TANK",skin,"toggle");
        but4.getLabel().setFontScale((float) 0.6);
        but4.setColor(1,1,0,1);
        but4.setSize(88,30);
        but4.setPosition(301,116);
        stage.addActor(but4);

        TextButton but5 = new TextButton("CHOOSE TERRAIN",skin,"toggle");
        but5.getLabel().setFontScale((float) 0.6);
        but5.setColor(1,1,0,1);
        but5.setSize(88,30);
        but5.setPosition(301,81);
        stage.addActor(but5);

        TextButton but6 = new TextButton("QUIT",skin,"toggle");
        but6.getLabel().setFontScale((float) 0.6);
        but6.setColor(1,1,0,1);
        but6.setSize(88,30);
        but6.setPosition(301,47);
        stage.addActor(but6);





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
        stage.getViewport().update(width, height);
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
