package com.quzzar.dominions.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.input.GestureDetector;
import com.quzzar.dominions.Addons.ToastController;
import com.quzzar.dominions.ClientProgram;
import com.quzzar.dominions.Game.WorldManager;
import com.quzzar.dominions.Misc.Utility;
import com.quzzar.dominions.Misc.WorldUtils;
import com.quzzar.dominions.UI.TouchListeners.GameAndroidListener;
import com.quzzar.dominions.UI.TouchListeners.GameDesktopListener;
import com.quzzar.dominions.Game.WorldRenderer;

public class GameScreen implements Screen {

    private final ClientProgram client;
    private final GameScreen gameScreen = this;

    private SpriteBatch batch;
    private ShapeRenderer renderer;

    private Sprite back;

    public GameScreen(final ClientProgram client){

        // Create world
        WorldRenderer.initialize();

        this.client = client;

        this.batch = new SpriteBatch();
        this.renderer = new ShapeRenderer();

        this.back = new Sprite(new Texture("misc/tes.jpg"));
        back.setSize(WorldUtils.getWorldPixelWidth(), WorldUtils.getWorldPixelHeight());

    }

    @Override
    public void show() {

        if(Utility.isDesktopApp()){
            Gdx.input.setInputProcessor(new GameDesktopListener());
        } else if (Utility.isAndroidApp()){
            Gdx.input.setInputProcessor(new GestureDetector(20, 0.4f,
                    0.28f, 0.15f, new GameAndroidListener()));
        }

    }

    @Override
    public void render(float delta) {

        if(Utility.isDesktopApp()){
            GameDesktopListener.checkKeyPressed();
        }

        Gdx.gl.glClearColor(Color.FOREST.r, Color.FOREST.g, Color.FOREST.b, Color.FOREST.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // To scale with game world
        renderer.setProjectionMatrix(WorldRenderer.getCamera().combined);
        batch.setProjectionMatrix(WorldRenderer.getCamera().combined);

        /*
        float w = 803.63f, h = 452.432f;
        Location tempLoc = WorldUtils.getLocation(w, h);
        Vector3 temp = WorldUtils.getWorldCoords(tempLoc.getX(), tempLoc.getY());
        Utility.print("DEBUG-COORDS",w+" and "+h+": "+temp.x+" "+temp.y);
        */

        batch.begin();

        //back.draw(batch);

        batch.end();

        renderer.begin(ShapeRenderer.ShapeType.Line);


        renderer.end();

        WorldRenderer.render(batch, renderer);

        ToastController.render();
    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {

    }

    @Override
    public void resize(int width, int height) {

        WorldRenderer.getGameCamera().resize(width, height);

    }

    @Override
    public void dispose() {
        WorldManager.dispose();
        batch.dispose();
        renderer.dispose();
        Gdx.input.setInputProcessor(null);
    }
}
