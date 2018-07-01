package com.quzzar.dominions;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.quzzar.dominions.Addons.ToastController;
import com.quzzar.dominions.Screens.MenuScreen;

public class DominionsMain extends Game {

	private static DominionsMain instance;

	private ClientProgram client;

	@Override
	public void create() {
		instance = this;

        ToastController.initialize();

		client = new ClientProgram();
		this.setScreen(new MenuScreen(client));
	}

	public static DominionsMain getInstance(){
		return instance;
	}

    public static Screen getStaticScreen() {
        return instance.screen;
    }

    public static void setStaticScreen(Screen screen) {
        instance.setScreen(screen);
    }


}
