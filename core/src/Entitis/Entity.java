package Entitis;

abstract class Entity {
    private String name;
    private int health;
    private int mana;
    private float x, y;  // position
    private float speed = 1.5f; // movement speed

    public Entity(String name, int health, int mana, float x, float y) {
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}