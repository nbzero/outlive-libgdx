package net.nbzero.outlive.positon;

public class PositionHandler {
	private float x;
	private float y;
	
	// Constructors
	public PositionHandler() {
		this(0, 0);
	}
	
	public PositionHandler(float x, float y){
		setX(x);
		setY(y);
	}
	
	public PositionHandler(PositionHandler pos){
		this(pos.getX(), pos.getY());
	}
	
	// Methods
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public void setX(float x){
		this.x = x;
	}
	
	public void setY(float y){
		this.y = y;
	}
	
	public void set(float x, float y){
		setX(x);
		setY(y);
	}
	
	public void set(float n){
		set(n, n);
	}
}
