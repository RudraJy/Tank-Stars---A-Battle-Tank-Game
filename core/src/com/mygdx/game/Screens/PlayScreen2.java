package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.CircleMapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Scenes.Hud;
import com.mygdx.game.Sprites.DropBox;
import com.mygdx.game.Sprites.Tank;
import com.mygdx.game.TankStars;

public class PlayScreen2 implements Screen {
    private TankStars game;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private Hud hud;

    private TmxMapLoader loader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    private World world;
    private Box2DDebugRenderer b2dr;

    private Tank player;
    private DropBox box;

    private SpriteBatch batch;
    private Texture tex;
    private Texture tex2;
    private  Texture tex3;

    public PlayScreen2(TankStars game){
        this.game = game;
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(TankStars.WIDTH,TankStars.HEIGHT,gamecam);
        hud = new Hud(game.batch);

        loader = new TmxMapLoader();
        map = loader.load("gameWorld.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        gamecam.position.set(gamePort.getWorldWidth()/2, gamePort.getWorldHeight()/2, 0);

        world = new World(new Vector2(0,-8), true);
        b2dr = new Box2DDebugRenderer();
        player = new Tank(world);
        box = new DropBox(world);

        batch = new SpriteBatch();
        tex = new Texture("tank-edited2.png");
        tex2 = new Texture("tank-edited1.png");
        tex3 = new Texture("dropbox-edited.png");

        BodyDef b_def = new BodyDef();
        //PolygonShape shape = new PolygonShape();
        FixtureDef f_def = new FixtureDef();
        Body body;

        /*for (MapObject obj : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) obj).getRectangle();
            b_def.type = BodyDef.BodyType.StaticBody;
            b_def.position.set(rect.getX() + rect.getWidth()/2, rect.getY() + rect.getHeight()/2);
            body = world.createBody(b_def);
            shape.setAsBox(rect.getWidth()/2, rect.getHeight()/2);
            f_def.shape = shape;
            body.createFixture(f_def);
        }*/


        for (MapObject object : map.getLayers().get(2).getObjects()){
            Shape shape = new PolygonShape();
            if (object instanceof RectangleMapObject) {
                shape = getRectangle((RectangleMapObject)object);
            }
            else if (object instanceof PolygonMapObject) {
                shape = getPolygon((PolygonMapObject)object);
            }
            else {
                continue;
            }
            b_def.type = BodyDef.BodyType.StaticBody;
            body = world.createBody(b_def);
            f_def.shape = shape;
            body.createFixture(f_def);
        }


    }

    private static PolygonShape getRectangle(RectangleMapObject rectangle){
        Rectangle rect = rectangle.getRectangle();
        PolygonShape polygon = new PolygonShape();
        Vector2 size = new Vector2((rect.x + rect.width * 0.5f), (rect.y + rect.height * 0.5f ));
        polygon.setAsBox(rect.width * 0.5f, rect.height * 0.5f, size, 0.0f);
        return polygon;
    }

    private static PolygonShape getPolygon(PolygonMapObject polygonObject) {
        PolygonShape polygon = new PolygonShape();
        float[] vertices = polygonObject.getPolygon().getTransformedVertices();

        float[] worldVertices = new float[vertices.length];

        for (int i = 0; i < vertices.length; ++i) {
            worldVertices[i] = vertices[i];
        }

        polygon.set(worldVertices);
        return polygon;

    }


    @Override
    public void show() {

    }

    public void handleInput(float q){
        if (player.body.getPosition().x <192){
            player.body.setLinearVelocity(0f,0f);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player.body.getLinearVelocity().x <= 2){
            player.body.applyLinearImpulse(new Vector2(20f, 0), player.body.getWorldCenter(), true);

        }
        else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && player.body.getLinearVelocity().x >= -2 && player.body.getPosition().x >= 193){
            player.body.applyLinearImpulse(new Vector2(-20f, 0), player.body.getWorldCenter(), true);

        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) == Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            player.body.setLinearVelocity(0f,0f);
        }


    }

    public void update(float p){
        handleInput(p);
        world.step(1/60f, 6,2);

        gamecam.update();
        batch.setProjectionMatrix(gamecam.combined);
        renderer.setView(gamecam);
    }


    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render();

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();

        batch.begin();
        batch.draw(tex, player.body.getPosition().x - 8, player.body.getPosition().y - 10, 20, 20);
        batch.draw(tex2,player.body2.getPosition().x -12 ,player.body2.getPosition().y - 3,20,6);
        batch.draw(tex3,box.body.getPosition().x - 5 ,box.body.getPosition().y - 5,10,10);
        batch.end();





    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width,height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
