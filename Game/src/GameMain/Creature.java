package GameMain;

public abstract class Creature extends Entity{

	protected int health;
	protected float speed;
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_WIDTH = 40;
	public static final int DEFAULT_HEIGHT = 40;
	Creature(float x, float y, int width, int height) {
		super(x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		}

	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
}
