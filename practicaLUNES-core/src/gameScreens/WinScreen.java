package gameScreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.MyGdxGame;

public class WinScreen implements Screen {

	private BitmapFont font;
	private SpriteBatch batch;
	private MyGdxGame game;
	private TextureRegion regrobots;
	private TextureRegion[] frames;
	private Texture robots;

	private float i = 0;

	public WinScreen(MyGdxGame game) {
		font = new BitmapFont();
		this.game = game;
		batch = new SpriteBatch();
		robots = new Texture(Gdx.files.internal("robot.PNG"));
		regrobots = new TextureRegion(robots, 512, 128);
		TextureRegion[][] temp = regrobots.split(512 / 9, 128);
		frames = new TextureRegion[temp.length * temp[0].length];

		for (int i = 0; i < frames.length; i++) {
			frames[i] = temp[0][i];
		}

	}

	@Override
	public void render(float delta) {
		Gdx.gl20.glClearColor(1, 1, 1, 1);
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if (i > 8) {
			i = 0;
		}

		batch.begin();
		font.draw(batch, "GANASTE!!", 50, Gdx.graphics.getHeight() - 10);
		batch.draw(frames[(int)i], 30, 50);
		batch.end();
		i += 0.08;
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {

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
	public void dispose() {
		batch.dispose();
		font.dispose();
	}

}
