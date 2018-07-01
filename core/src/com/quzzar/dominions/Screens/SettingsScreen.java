package com.quzzar.dominions.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.dominions.ClientProgram;
import com.quzzar.dominions.Misc.Utility;

public class SettingsScreen implements Screen {

    private final ClientProgram client;
    private final SettingsScreen settingsScreen = this;
    private final Screen returningScreen;

    private SpriteBatch batch;

    private Sprite backBtn;

    private Sprite background;

    public SettingsScreen(final ClientProgram client, final Screen returningScreen) {

        this.client = client;
        this.returningScreen = returningScreen;

        this.batch = new SpriteBatch();

        this.background = new Sprite(new Texture("misc/stone_2.jpg"));

        this.backBtn = new Sprite(new Texture("misc/back_1.png"));

    }

    @Override
    public void show() {

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {

                /*
                if (Input.isImagePressed(backBtn)){
                    settingsScreen.dispose();
                    DominionsMain.setStaticScreen(returningScreen);
                }
                */

                return super.touchUp(screenX, screenY, pointer, button);
            }
        });

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(255, 255, 255, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        background.draw(batch);

        backBtn.draw(batch);

        batch.end();

    }

    @Override
    public void resize(int width, int height) {

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
        batch.dispose();
        Gdx.input.setInputProcessor(null);
    }
}

