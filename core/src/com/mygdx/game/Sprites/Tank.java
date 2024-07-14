package com.mygdx.game.Sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;

public class Tank extends Sprite {
    public World world;
    public Body body;
    public Body body2;

    public Tank(World world){
        this.world = world;
        defineTank();
    }

    public void defineTank(){
        /*BodyEditorLoader loader = new BodyEditorLoader(Gdx.files.internal("img.png"));

        BodyDef bd = new BodyDef();
        bd.position.set(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
        bd.type = BodyDef.BodyType.KinematicBody;
        bd.position.x = this.getX();
        bd.position.y = this.getY();
        body = world.createBody(bd);
        FixtureDef fd = new FixtureDef();
        float scale = this.getWidth();
        loader.attachFixture(body, "gear", fd, scale);*/


        BodyDef b_def = new BodyDef();
        b_def.position.set(130,34);
        b_def.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(b_def);
        FixtureDef f_def = new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(5,3);

        f_def.shape = shape;
        body.createFixture(f_def);
        shape.dispose();

        BodyDef b_def2 = new BodyDef();
        b_def2.position.set(342,54);
        b_def2.type = BodyDef.BodyType.DynamicBody;
        body2 = world.createBody(b_def2);
        FixtureDef f_def2 = new FixtureDef();
        PolygonShape shape2 = new PolygonShape();
        shape2.setAsBox(5,3);

        f_def2.shape = shape2;
        body2.createFixture(f_def2);
        shape2.dispose();
    }

}
