package com.vanmxpx.gameobjects;

import com.badlogic.gdx.math.Vector2;

public class Bird {
    private Vector2 _position;      //Postion in space
    private Vector2 _velocity;      //V - speed
    private Vector2 _acceleration;  //W - speed-up

    private float _angle = 0;
    private int _width;
    private int _height;

    public Bird(float x, float y, int _width, int _height){
        this._width = _width;
        this._height = _height;
        _position = new Vector2(x,y);
        _velocity = new Vector2(0, 0);
        _acceleration = new Vector2(0, 460);
    }

    public void update(float delta) {
        _velocity.add(_acceleration.cpy().scl(delta));
        if (_velocity.y > 200)
            _velocity.y = 200;
        if (_angle > 10)
            _angle = 10;
        else if(_angle < -15)
            _angle = -15;
        _angle += 4 * delta * _velocity.y;
        _position.add(_velocity.cpy().scl(delta));
    }

    public void onClick(){
        _velocity.y = -140;
        _angle = -10;
    }
    public boolean isFalling() {
        return _angle > 0;
    }

    public boolean shouldntFlap() {
        return _angle > 0;
    }
    public Vector2 getPosition(){
        return _position;
    }

    public Vector2 getSize(){
        return new Vector2(_width, _height);
    }

    public float getAngle(){
        return _angle;
    }
}
