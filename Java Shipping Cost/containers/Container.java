package containers;

public abstract class Container {
	
	private double width;
	private double height;
	private double length;
	
	public Container() {
		super();
	}
	
	public Container( double width, double height, double length) {
		super();
		this.width = width;
		this.height = height;
		this.length = length;
	}


	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
	public abstract double Container_Volume();
	
	public void Print_Container_Info() {
		System.out.println("Container: " + getClass().getSimpleName());
        System.out.println("Dimensions: " + width + "x" + height + "x" + length + " cm");
        System.out.println("Volume: " + Container_Volume() + " cm3");
        System.out.println();
	}
	
}
