package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Screens.*;

public class TankStars extends Game {
	public static final int WIDTH = 400;
	public static final int HEIGHT = 200;
	public SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new PlayScreen1(this));
		//setScreen(new PlayScreen2(this));
		//setScreen(new PlayScreen3(this));
		//setScreen(new PlayScreen4(this));
		//setScreen(new PlayScreen5(this));
		//setScreen(new PlayScreen6(this));


	}

	@Override
	public void render () {
		super.render();
	}
	

}
