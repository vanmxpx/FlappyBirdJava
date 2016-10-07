package com.vanmxpx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.vanmxpx.gameworld.*;
import com.vanmxpx.tools.InputHandler;

public class GameScreen implements Screen {

    private GameWorld _world;
    private GameRenderer _renderer;

    public GameScreen(){
        Gdx.app.log("GameScreen", "Attached.");

        float screenWidth = Gdx.graphics.getWidth();            //Calculate midPoint
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        int midPointY = (int) gameHeight / 2;

        _world = new GameWorld(midPointY);
        _renderer = new GameRenderer(_world, (int) gameHeight, midPointY);
        Gdx.input.setInputProcessor(new InputHandler(_world.getBird()));

    }
    @Override
    public void show() {
        Gdx.app.log("GameScreen", "Showed.");
    }

    @Override
    public void render(float delta) {
        _renderer.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "Resizing.");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "Paused.");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "Resumed.");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen","Hided.");
    }

    @Override
    public void dispose() {

    }
}
