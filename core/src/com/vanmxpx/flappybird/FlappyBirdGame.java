package com.vanmxpx.flappybird;

import com.badlogic.gdx.*;
import com.vanmxpx.screens.GameScreen;
import com.vanmxpx.tools.AssetLoader;

public class FlappyBirdGame extends Game {

	@Override
	public void create() {
		Gdx.app.log("FlappyBirdGame", "created");

		AssetLoader.load();
		setScreen(new GameScreen());
	}

	@Override
	public void dispose(){
		AssetLoader.dispose();
		super.dispose();
	}
}
