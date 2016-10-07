package com.vanmxpx.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.vanmxpx.gameobjects.*;
import com.vanmxpx.tools.AssetLoader;

import static com.vanmxpx.tools.AssetLoader.birdAnimation;

public class GameRenderer {

    private Grass _grass;
    private Bird bird;
    private GameWorld _world;
    private OrthographicCamera _camera;
    private ShapeRenderer _shapeRenderer;

    private TextureRegion bg, grass;
    private Animation birdAnimation;
    private TextureRegion birdMid, birdDown, birdUp;
    private TextureRegion skullUp, skullDown, bar;

    private SpriteBatch _batcher;
    private int gameHeight, midPointY;
    private float runTime = 0;

    public GameRenderer(GameWorld _world, int gameHeight, int midPointY){
        this._world = _world;
        this.gameHeight = gameHeight;
        this.midPointY = midPointY;
        this._grass = _world.getGrass();

        _camera = new OrthographicCamera();
        _shapeRenderer = new ShapeRenderer();
        _batcher = new SpriteBatch();

        _camera.setToOrtho(true, 136, gameHeight);
        _batcher.setProjectionMatrix(_camera.combined);
        _shapeRenderer.setProjectionMatrix(_camera.combined);

        initAssets();
        initGameObjects();
    }

    public void render(float delta){
        runTime += delta;

        _world.update(delta);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        _shapeRenderer.begin(ShapeType.Filled);
        //Background
        _shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        _shapeRenderer.rect(0,0, 136, midPointY + 66);
        //Grass
        _shapeRenderer.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
        _shapeRenderer.rect(0, midPointY + 66, 136, 11);
        //Dirt
        _shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
        _shapeRenderer.rect(0, midPointY + 77, 136, 52);
        _shapeRenderer.end();

        _batcher.begin();
        //Enable full-fill
        _batcher.disableBlending();
        //Background
        _batcher.draw(bg, 0, midPointY + 23, 136, 43);
        //Grass
        _batcher.draw(grass,
                _grass.getPosition().x, _grass.getPosition().y, _grass.getSize().x, _grass.getSize().y);
        //Bird
        _batcher.enableBlending();
        if ( bird.shouldntFlap())
            _batcher.draw(birdMid, bird.getPosition().x, bird.getPosition().y,
                    bird.getSize().x / 2.0f, bird.getSize().y / 2.0f, bird.getSize().x,
                    bird.getSize().y, 1, 1, bird.getAngle());
        else
            _batcher.draw(birdAnimation.getKeyFrame(runTime),
                    bird.getPosition().x, bird.getPosition().y,
                    bird.getSize().x / 2.0f, bird.getSize().y / 2.0f, bird.getSize().x,
                    bird.getSize().y, 1, 1, bird.getAngle());
        _batcher.end();
    }

    private void initGameObjects() {
        bird = _world.getBird();
    }

    private void initAssets() {
        bg = AssetLoader.bg;
        grass = AssetLoader.grass;
        birdAnimation = AssetLoader.birdAnimation;
        birdMid = AssetLoader.bird;
        birdDown = AssetLoader.birdDown;
        birdUp = AssetLoader.birdUp;
        skullUp = AssetLoader.tubeUp;
        skullDown = AssetLoader.tubeDown;
        bar = AssetLoader.bar;
    }
}
