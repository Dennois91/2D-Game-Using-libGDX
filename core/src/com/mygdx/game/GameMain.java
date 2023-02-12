package com.mygdx.game;

import Entitis.Player;
import Screen.WorldMap;
import com.badlogic.gdx.Game;


public class GameMain extends Game {

	private Player player;
	private WorldMap worldMap;

	@Override
	public void create() {
		player = new Player("Dennis", 10, 0, 2800, 180);
		worldMap = new WorldMap(player);
		setScreen(worldMap);

	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		worldMap.resize(width, height);

	}

	@Override
	public void dispose() {
		worldMap.dispose();
	}
}