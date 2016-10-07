package com.vanmxpx.gameobjects;

import com.badlogic.gdx.math.Vector2;

public class Grass {
    private Vector2 _position;      //Postion in space
    private Vector2 _velocity;      //V - speed

    private int _width;
    private int _height;

    public Grass(float x, float y, int _width, int _height){
        this._width = _width;
        this._height = _height;
        _position = new Vector2(x,y);
        _velocity = new Vector2(-20, 0);
    }

    public void update(float delta){
        if ( _position.x < -7)
            _position.x = 0;
        _position.add(_velocity.cpy().scl(delta));
    }

    public Vector2 getPosition(){
        return _position;
    }

    public Vector2 getSize(){
        return new Vector2(_width, _height);
    }

}
