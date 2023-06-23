package containers;

public class SmallContainer extends Container {

	public SmallContainer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public double Container_Volume() {
		// TODO Auto-generated method stub
		return getWidth() * getHeight() * getLength();
	}
	
	public SmallContainer(double width, double height, double length) {
		super(width, height, length);
	}
}
