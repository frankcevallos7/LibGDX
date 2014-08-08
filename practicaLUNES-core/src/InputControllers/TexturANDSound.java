package InputControllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TexturANDSound {

	public Music music, campeon;
	public TextureRegion background;
	public Texture tbackground, pes, tiburon, pez_malo;

	public void load() {
		tbackground = new Texture(
				Gdx.files.internal("ocean.jpg"));
		pes = new Texture(Gdx.files.internal("pez.png"));
		pez_malo = new Texture(Gdx.files.internal("pez_malo.png"));
		tiburon = new Texture(Gdx.files.internal("tiburon.png"));
		background = new TextureRegion(tbackground, 0, 0, 800, 480);
		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		campeon = Gdx.audio.newMusic(Gdx.files.internal("ganador.mp3"));
	}


	public void end() {
		tbackground.dispose();
		music.dispose();
		pes.dispose();
		tiburon.dispose();

	}
}
