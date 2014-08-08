package gameScreens;

import InputControllers.TexturANDSound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.MyGdxGame;

public class GameScreen implements Screen {

	private OrthographicCamera camera;
	private MyGdxGame game;
	private SpriteBatch batch;
	private ShapeRenderer renderer;
	private Rectangle pes, tiburon, pez_malo;
	private TexturANDSound TaS;
	private BitmapFont font;
	private int puntaje = 0;

	public GameScreen(MyGdxGame game) {
		this.game = game;
		this.TaS = new TexturANDSound();
		this.TaS.load();
		this.pes = new Rectangle(30, Gdx.graphics.getWidth(), 30, 30);
		this.tiburon = new Rectangle(Gdx.graphics.getHeight() - 20,
				Gdx.graphics.getHeight() / 2 - 10, 40, 40);
		this.pez_malo = new Rectangle(Gdx.graphics.getHeight() / 2,
				Gdx.graphics.getHeight() / 2 - 10, 45, 45);
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		this.batch = new SpriteBatch();
		this.renderer = new ShapeRenderer();
		this.font = new BitmapFont();
		this.TaS.music.play();
		this.batch.setProjectionMatrix(camera.combined);
	}

	@Override
	public void render(float delta) {
		Gdx.gl20.glClearColor(1, 1, 1, 1);
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

		poscicion();

		batch.begin();
		batch.draw(TaS.background, 0, 0);
		batch.draw(TaS.pes, pes.x, pes.y);
		font.draw(batch, Integer.toString(puntaje), 50,
				Gdx.graphics.getHeight() - 10);
		batch.draw(TaS.tiburon, tiburon.x, tiburon.y);
		batch.draw(TaS.pez_malo, pez_malo.x, pez_malo.y);
		batch.end();

		if (puntaje == 4) {
			game.setScreen(new WinScreen(game));
			TaS.music.stop();
			TaS.campeon.play();
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		batch.dispose();
		renderer.dispose();
		TaS.end();
	}

	public void poscicion() {

		pes.y = pes.y - 3;

		if (pes.y < 0) {
			pes.y = Gdx.graphics.getWidth();
		}
		pez_malo.y = pez_malo.y - 11;

		if (pez_malo.y < 0) {
			pez_malo.y = Gdx.graphics.getWidth();
		}

		tiburon.x += Gdx.input.getAccelerometerY();
		tiburon.y -= Gdx.input.getAccelerometerX();

		if ((tiburon.x + Gdx.input.getAccelerometerY()) < -5) {
			tiburon.x -= Gdx.input.getAccelerometerY();
		}
		if ((tiburon.x + Gdx.input.getAccelerometerY()) > 480 - 50) {
			tiburon.x -= Gdx.input.getAccelerometerY();
		}
		if ((tiburon.y - Gdx.input.getAccelerometerX()) < 0) {
			tiburon.y += Gdx.input.getAccelerometerX();
		}

		if (tiburon.overlaps(pes)) {
			tiburon.x = Gdx.graphics.getHeight() - 20;
			tiburon.y = Gdx.graphics.getHeight() / 2 - 10;
			pes.y = Gdx.graphics.getWidth();
			puntaje++;

		}

		if (tiburon.overlaps(pez_malo)) {
			tiburon.x = Gdx.graphics.getHeight() - 20;
			tiburon.y = Gdx.graphics.getHeight() / 2 - 10;
			puntaje--;

		}

	}

}
