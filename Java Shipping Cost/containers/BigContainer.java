package containers;

public class BigContainer extends Container {

	public BigContainer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	
	// we cannot access to a variable directly coz it is private so instead we choose getter methods
	//if it was public that would be possible but the instructions banned us to declare variables as public
	public double Container_Volume() {
		// TODO Auto-generated method stub
		return getWidth() * getLength() * getHeight();
	}
	
	public BigContainer(double width, double height, double length) {
		super(width, height, length);
	}
}
