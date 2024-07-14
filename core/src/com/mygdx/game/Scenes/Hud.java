package com.mygdx.game.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.TankStars;


public class Hud {
    public Stage stage;
    private Viewport viewport;
    Texture texture;
    private Image pause;
    private Image health1;
    private Image health2;
    private Image vs;

    public Hud(SpriteBatch sb){
        texture = new Texture("pause_menu-modified.png");
        pause = new Image(texture);
        pause.setSize(20,20);
        pause.setPosition(10,175);

        texture = new Texture("health1.png");
        health1 = new Image(texture);
        health1.setSize(110,40);
        health1.setPosition(85,168);

        texture = new Texture("health2.png");
        health2 = new Image(texture);
        health2.setSize(90,17);
        health2.setPosition(220,177);

        texture = new Texture("img.png");
        vs = new Image(texture);
        vs.setSize(15,15);
        vs.setPosition(192,178);

        viewport = new FitViewport(TankStars.WIDTH,TankStars.HEIGHT,new OrthographicCamera());
        stage = new Stage(viewport,sb);

        stage.addActor(pause);
        stage.addActor(health1);
        stage.addActor(health2);
        stage.addActor(vs);





    }
}
