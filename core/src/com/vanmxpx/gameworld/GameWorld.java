package com.vanmxpx.gameworld;

import com.badlogic.gdx.Gdx;
import com.vanmxpx.gameobjects.Bird;
import com.vanmxpx.gameobjects.Grass;

public class GameWorld {

    private Bird _bird;
    private Grass _grass;

    public GameWorld(int midPointY){
        _bird = new Bird(33, midPointY - 5, 17, 12);
        _grass = new Grass(0, midPointY + 66, 143, 11);
    }

    public void update(float delta) {
        _bird.update(delta);
        _grass.update(delta);
    }

    public Bird getBird(){
        return _bird;
    }

    public Grass getGrass(){
        return _grass;
    }
}
