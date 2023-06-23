package methods;

import containers.BigContainer;
import containers.SmallContainer;
import items.Item;
import methods.Calculation;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Calculation TestObj = new Calculation();
		
		// Adding products
		Item laptop = new Item("Laptop", 60, 50, 50, 6.5);
//        Item mouse = new Item("Mouse", 30, 30, 20, 0.2);
//        Item desktop = new Item("Desktop", 100, 150, 50, 20);
//        Item lcdScreen = new Item("LCD Screen", 120, 140, 80, 2.6);


        
        // Create containers
        SmallContainer smallContainer = new SmallContainer(259, 243, 606);
        BigContainer bigContainer = new BigContainer(259, 243, 1201);
        
     // Create calculation instance
        Calculation calculation = new Calculation();

        // Add items to calculation
        calculation.addItems(laptop);
//        calculation.addItems(mouse);
//        calculation.addItems(desktop);
//        calculation.addItems(lcdScreen);
        
     // Add order quantities
        calculation.addOrder(100);
//        calculation.addOrder(200);
//        calculation.addOrder(150);
//        calculation.addOrder(200);
        

        // Print item information
        System.out.println("Item Information:");
        calculation.PrintItem_Info();
        System.out.println();

        // Print order information
        System.out.println("Order Information:");
        calculation.printOrder();
        System.out.println();
        
        
     // Calculate best shipping method
        calculation.bestShipping();
	}

}
