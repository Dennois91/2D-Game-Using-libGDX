package Entitis;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Player extends Entity {
    private int experience;
    private int strength;
    private int vitality;
    private int stamina;

    public Player(String name, int health, int mana, float x, float y) {
        super(name, health, mana, x, y);
    }

    public void move(Vector2 direction) {
        setX(getX() + direction.x * getSpeed());
        setY(getY() + direction.y * getSpeed());
    }

    public void drawPlayer(ShapeRenderer shapeRenderer, OrthographicCamera camera) {
        shapeRenderer.setProjectionMatrix(camera.combined);
       shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(getX() - 16, getY() - 16, 32, 32);
       shapeRenderer.end();
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
}