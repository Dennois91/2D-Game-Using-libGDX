package Screen;

import Entitis.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.PlayerMovement;

public class WorldMap implements Screen {
    private static final int VIRTUAL_WIDTH = 320;
    private static final int VIRTUAL_HEIGHT = 240;
    private final Player player;
    private final TiledMap map;
    private final OrthogonalTiledMapRenderer renderer;
    private final OrthographicCamera camera;
    private final PlayerMovement playerMovement;
    private final ShapeRenderer shapeRenderer;

    public WorldMap(Player player) {
        this.player = player;
        shapeRenderer = new ShapeRenderer();

        map = new TmxMapLoader().load("worldMap.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();


        playerMovement = new PlayerMovement(player);
    }


    @Override
    public void show() {
        // initialize any necessary objects or resources
    }

    @Override
    public void render(float delta) {
        // clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // update the camera position to follow the player
        camera.position.set(player.getX(), player.getY(), 0);
        camera.update();

        // render the game world
        renderer.setView(camera);
        renderer.render();

        // handle player movement based on input
        playerMovement.update();

        // draw the player
        shapeRenderer.setProjectionMatrix(camera.combined);
        player.drawPlayer(shapeRenderer, camera);

        // Call the resize method to update the viewport
        resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }


    public void resize(int width, int height) {
        camera.setToOrtho(false, VIRTUAL_WIDTH, VIRTUAL_HEIGHT);
    }

    @Override
    public void pause() {
        // pause the game
    }

    @Override
    public void resume() {
        // resume the game
    }

    @Override
    public void hide() {
        // hide the screen
    }

    @Override
    public void dispose() {
        // dispose of any resources that were used
        map.dispose();
        renderer.dispose();
        shapeRenderer.dispose();
    }
}