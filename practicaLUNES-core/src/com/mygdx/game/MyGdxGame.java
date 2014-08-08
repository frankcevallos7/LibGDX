package com.mygdx.game;

import gameScreens.GameScreen;

import com.badlogic.gdx.Game;

public class MyGdxGame extends Game {

	@Override
	public void create() {
		setScreen(new GameScreen(this));
	}

}
