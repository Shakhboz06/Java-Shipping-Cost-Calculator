package items;


public class Item {
	
	private String product_name;
	private double width;
	private double length;
	private double height;
	private double weight;
	
	public Item() {
		super();
	}
	
	public Item(String product_name, double width, double length, double height, double weight) {
		super();
		this.product_name = product_name;
		this.width = width;
		this.length = length;
		this.height = height;
		this.weight = weight;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double Calculate_Volume() {
		return width * length * height;
	}
	
	
	public void PrintItem_Info() {
		
		System.out.println("Item: " + product_name);
        System.out.println("Dimensions: " + width + "x" + height + "x" + length + " cm");
        System.out.println("Weight: " + weight + "kg");
        System.out.println("Volume: " + Calculate_Volume() + " cm3");
        System.out.println("-------------------------------");
	}


	
}
