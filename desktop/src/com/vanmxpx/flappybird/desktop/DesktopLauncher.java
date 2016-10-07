package com.vanmxpx.flappybird.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.vanmxpx.flappybird.FlappyBirdGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Flappy Bird";
		config.height = 816;
		config.width = 544;
		new LwjglApplication(new FlappyBirdGame(), config);
	}
}
