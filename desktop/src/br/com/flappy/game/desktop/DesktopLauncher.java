package br.com.flappy.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import br.com.flappy.game.FlappyLearningGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = FlappyLearningGame.WIDTH;
		config.height = FlappyLearningGame.HEIGHT;
		config.title = FlappyLearningGame.TITLE;
		new LwjglApplication(new FlappyLearningGame(), config);
	}
}
