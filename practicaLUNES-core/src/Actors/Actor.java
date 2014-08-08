package Actors;

import com.badlogic.gdx.math.Vector2;

public class Actor {
	private float posX, posY, widght, height;

	public Actor(float widght, float height, float posx, float posy) {
		this.widght = widght;
		this.height = height;
		this.posX = posx;
		this.posY = posy;
	}

	public void setPosition(float x, float y) {
		this.posX = x;
		this.posY = y;
	}

	public Vector2 getPosition() {
		return new Vector2(posX, posY);
	}
	
	public void setDimension(float widght, float height) {
		this.widght = widght;
		this.height = height;
	}
	public Vector2 getDimension() {
		return new Vector2(this.widght, this.height);
	}
	
}
