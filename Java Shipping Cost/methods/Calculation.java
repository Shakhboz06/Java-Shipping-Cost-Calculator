package methods;

import java.util.List;
import java.util.ArrayList;

// importing is a more effective way it makes code more readable and easier to understand
import containers.BigContainer;
import containers.Container;
import containers.SmallContainer;
import items.Item;

public class Calculation{
	

	// FYI: we can use this method also to call a class from another package
	items.Item obj = new items.Item(); 
	
	private List<Item> products;
	private List<Integer> orders;
	
	public Calculation() {
		this.products = new ArrayList<>();
		this.orders = new ArrayList<>();
		
	}
	
	
	// In order for List of Items to be added I create Item list objects later to add them with their quantity
	// so this function adds an item with necessary name, width, length, etc with number/how many I want to ship
	public void addItems(Item prod) {
		products.add(prod);
	}
	
	public void addOrder(int quantity) {
		orders.add(quantity);
	}
	
	public double totalVolume() {
		
		double total_volume = 0;
		
		for(int i = 0; i <  products.size(); i++) {
			total_volume += products.get(i).Calculate_Volume() * orders.get(i);
		}
		System.out.println("Total volume: " + (long)total_volume + " cm3");
		return total_volume;
	}
	
	public double totalWeight() {
		
		double total_weight = 0;
		
		for(int i = 0; i < products.size(); i++ ) {
			Item prod = products.get(i);
			total_weight += prod.getWeight() * orders.get(i);
		}
		System.out.println("Total weight: " + total_weight + " kg");
		return total_weight;
	}
	
	public void printOrder() {
		for(int i = 0; i < products.size(); i++) {
			Item prod = products.get(i);
			System.out.println("Order: " + orders.get(i) + " " + prod.getProduct_name());
//			System.out.println();
		}
		
	}
	public String GUIprintOrder() {
		String res = null;
		for(int i = 0; i < products.size(); i++) {
			Item prod = products.get(i);
			res = "Order: " + orders.get(i) + " " + prod.getProduct_name();
		}
		return res;
	}
	
	public void PrintItem_Info() {
		for(Item temp: products) {
			temp.PrintItem_Info();
			System.out.println();
		}
	}
	
	public void bestShipping() {
		 
        double totalVolume = totalVolume();
        double totalWeight = totalWeight();

        double smallContainersNeeded = totalVolume / new SmallContainer(259, 243, 606).Container_Volume();
        double bigContainersNeeded = totalVolume / new BigContainer(259, 243, 1201).Container_Volume();
        
        double bigContainerPrice = 1800;
        double smallContainerPrice;
        
        if(totalWeight <= 500) {
        	smallContainerPrice = 1000;
        }else {
        	smallContainerPrice = 1200;
        }
        
        
        if (smallContainersNeeded == 0) {
            System.out.println("Best shipping method: " + bigContainersNeeded + " big container(s)");
            System.out.println("Total cost: " + (bigContainersNeeded * bigContainerPrice) + " Euro");
        } else if (bigContainersNeeded == 0) {
            System.out.println("Best shipping method: " + smallContainersNeeded + " small container(s)");
            System.out.println("Total cost: " + (smallContainersNeeded * smallContainerPrice) + " Euro");
        } else {
            
        	double costWithBigContainers;
            double costWithSmallContainers = Math.floor(smallContainersNeeded) * smallContainerPrice;

            if(bigContainersNeeded % 2 == 0) {
            	costWithBigContainers = Math.floor(bigContainersNeeded) * bigContainerPrice;
            }else {
            	Math.floor(bigContainersNeeded % 2);
            	costWithBigContainers = (Math.floor(bigContainersNeeded) * bigContainerPrice) + (Math.ceil(bigContainersNeeded % 2) * smallContainerPrice);
            
            }
	        		
            if (costWithSmallContainers < costWithBigContainers || bigContainersNeeded % 2 != 0) {
            	smallContainersNeeded = Math.ceil(bigContainersNeeded % 2);            		
            	System.out.println("Best shipping method: " + Math.floor(bigContainersNeeded) +  " big container(s)" + " and " + smallContainersNeeded + " small container(s)");
                System.out.println("Total cost: " + costWithBigContainers + " Euro");
                } else if(costWithSmallContainers > costWithBigContainers || bigContainersNeeded % 2 == 0){
            	System.out.println("Best shipping method: " + smallContainersNeeded + " small container(s)");
            	System.out.println("Total cost: " + costWithSmallContainers + " Euro");
            
            }
        }
    }
	
	public String GUIbestShipping() {
        double totalVolume = totalVolume();
        double totalWeight = totalWeight();

        double smallContainersNeeded = totalVolume / new SmallContainer(259, 243, 606).Container_Volume();
        double bigContainersNeeded = totalVolume / new BigContainer(259, 243, 1201).Container_Volume();
        
        double bigContainerPrice = 1800;
        double smallContainerPrice;
        
        if(totalWeight <= 500) {
        	smallContainerPrice = 1000;
        }else {
        	smallContainerPrice = 1200;
        }
        
        
        if (smallContainersNeeded == 0) {
            return "Best shipping method: " + bigContainersNeeded + " big container(s)" + 
            "\nTotal cost: " + (bigContainersNeeded * bigContainerPrice) + " Euro";
        } else if (bigContainersNeeded == 0) {
            return "Best shipping method: " + smallContainersNeeded + " small container(s)" + 
            "\nTotal cost: " + (smallContainersNeeded * smallContainerPrice) + " Euro";
        } else {
            
        	double costWithBigContainers;
            double costWithSmallContainers = Math.floor(smallContainersNeeded) * smallContainerPrice;

            if(bigContainersNeeded % 2 == 0) {
            	costWithBigContainers = Math.floor(bigContainersNeeded) * bigContainerPrice;
            }else {
            	Math.floor(bigContainersNeeded % 2);
        			costWithBigContainers = (Math.floor(bigContainersNeeded) * bigContainerPrice) + (Math.ceil(bigContainersNeeded % 2) * smallContainerPrice);
            	}	        		
            if (costWithSmallContainers < costWithBigContainers || bigContainersNeeded % 2 != 0) { 
           		smallContainersNeeded = Math.ceil(bigContainersNeeded % 2);            		
            	return "Best shipping method: " + Math.floor(bigContainersNeeded) +  " big container(s)" + " and " + smallContainersNeeded + " small container(s)" + 
                "\nTotal cost: " + costWithBigContainers + " Euro";
                } else if(costWithSmallContainers > costWithBigContainers || bigContainersNeeded % 2 == 0){
            	return "Best shipping method: " + smallContainersNeeded + " small container(s)" + 
            	"\nTotal cost: " + costWithSmallContainers + " Euro";
            
            }
        }
        return null;
        
	}
}
