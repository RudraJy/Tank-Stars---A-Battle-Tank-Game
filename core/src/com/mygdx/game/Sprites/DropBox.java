package com.mygdx.game.Sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;

public class DropBox {
    public World world;
    public Body body;

    public DropBox(World world){
        this.world = world;
        defineBox();
    }

    public void defineBox(){
        BodyDef b_def = new BodyDef();
        b_def.position.set(280,160);
        b_def.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(b_def);
        FixtureDef f_def = new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(3,3);

        f_def.shape = shape;
        body.createFixture(f_def);
        shape.dispose();


    }

}

