package com.quzzar.dominions.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.quzzar.dominions.Addons.ToastController;
import com.quzzar.dominions.Cameras.MenuCamera;
import com.quzzar.dominions.ClientProgram;
import com.quzzar.dominions.DominionsMain;
import com.quzzar.dominions.Misc.GraphicsTools;
import com.quzzar.dominions.Misc.Input;

public class MenuScreen implements Screen{

    private final ClientProgram client;
    private final MenuScreen menuScreen = this;

    private final int MENU_WIDTH = GraphicsTools.getScreenWidth();
    private final int MENU_HEIGHT = GraphicsTools.getScreenHeight();

    private MenuCamera menuCamera;

    private SpriteBatch batch;
    private ShapeRenderer renderer;

    private final Sprite playBtn;
    private final Sprite settingsBtn;

    private final Sprite logo;

    private Sprite mainBackground;


    public MenuScreen(final ClientProgram client){

        this.client = client;

        this.menuCamera = new MenuCamera(MENU_WIDTH, MENU_HEIGHT);

        this.batch = new SpriteBatch();
        this.renderer = new ShapeRenderer();

        mainBackground = new Sprite(new Texture("menu/menuBackground.png"));
        mainBackground.setSize(MENU_WIDTH, MENU_HEIGHT);

        logo = new Sprite(new Texture("menu/game_logo.png"));
        logo.setCenter(MENU_WIDTH*0.5f, MENU_HEIGHT*0.86f);

        playBtn = new Sprite(new Texture("menu/connectBtn.png"));
        GraphicsTools.scaleSprite(playBtn, 0.7f);
        playBtn.setCenter(MENU_WIDTH*0.5f, MENU_HEIGHT*0.65f);

        settingsBtn = new Sprite(new Texture("menu/settingsBtn.png"));
        GraphicsTools.scaleSprite(settingsBtn, 0.7f);
        settingsBtn.setCenter(MENU_WIDTH*0.5f, MENU_HEIGHT*0.4f);

    }

    @Override
    public void show() {

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {

                //Play game button
                if (Input.isSpritePressed(menuCamera.getCamera(),playBtn)){

                    //LoadData.load();

                    client.connect();

                    if(client.isConnected()){
                        menuScreen.dispose();
                        DominionsMain.getInstance().setScreen(new GameScreen(client));
                        ToastController.displayLong("Connected");
                    } else {
                        ToastController.displayLong("Failed to connect");
                    }
                }

                //Settings game button
                if (Input.isSpritePressed(menuCamera.getCamera(),settingsBtn)){
                    DominionsMain.setStaticScreen(new SettingsScreen(client, menuScreen));
                }


                return super.touchUp(screenX, screenY, pointer, button);
            }
        });

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(255, 255, 255, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        menuCamera.update();

        batch.begin();

        mainBackground.draw(batch);

        logo.draw(batch);

        playBtn.draw(batch);
        settingsBtn.draw(batch);

        batch.end();

        // To scale with menu (if needed)
        renderer.setProjectionMatrix(menuCamera.getCamera().combined);
        batch.setProjectionMatrix(menuCamera.getCamera().combined);

        Vector3 inputLoc = Input.getWorldLocation(menuCamera.getCamera());

        renderer.begin(ShapeRenderer.ShapeType.Line);

        //GraphicsTools.drawCircle(renderer, inputLoc.x, inputLoc.y, 5);

        GraphicsTools.drawRectangle(renderer, playBtn.getBoundingRectangle());

        GraphicsTools.drawRectangle(renderer, settingsBtn.getBoundingRectangle());

        GraphicsTools.drawCircle(renderer, playBtn.getX(), playBtn.getY(), 5);
        GraphicsTools.drawCircle(renderer, settingsBtn.getX(), settingsBtn.getY(), 5);

        GraphicsTools.drawCircle(renderer,
                playBtn.getX()+playBtn.getWidth(), playBtn.getY()+playBtn.getHeight(), 5);
        GraphicsTools.drawCircle(renderer,
                settingsBtn.getX()+settingsBtn.getWidth(), settingsBtn.getY()+settingsBtn.getHeight(), 5);

        renderer.end();

        ToastController.render();
    }

    @Override
    public void resize(int width, int height) {

        menuCamera.resize(width, height);

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
        renderer.dispose();
        Gdx.input.setInputProcessor(null);
    }


}
