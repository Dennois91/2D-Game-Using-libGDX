package com.mygdx.game;

import Entitis.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class PlayerMovement {
    private final Player player;

    public PlayerMovement(Player player) {
        this.player = player;
    }

    public void update() {
        Vector2 direction = new Vector2();

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            direction.y += 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            direction.x -= 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            direction.y -= 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            direction.x += 1;
        }

        // Only move if there is input
        if (!direction.isZero()) {
            // Normalize the direction vector to ensure consistent speed in all directions
            direction.nor();
            player.move(direction);
        }
    }
}