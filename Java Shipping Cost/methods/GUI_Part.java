package methods;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

import methods.Calculation;
import items.Item;


public class GUI_Part extends JFrame {

	private static JPanel panel = new JPanel();
	private JTextField[] dimenInp = new JTextField[6];
	private String[] placeholder = {"order name:", "width", "height", "length", "weight", "quantity"};
	private JButton[] Buttons = new JButton[3];
	private String orderName;
    private double width, height, length, weight;
	private int quantity;
	private JTextArea DisRes = new JTextArea();
	
	public GUI_Part() {
		super("Shipping Cost Calculator");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DisRes.setEditable(false);
		DisRes.setPreferredSize(new Dimension(400, 200));
		for(int i = 0; i < dimenInp.length; i++) {
			dimenInp[i] = new JTextField();// to give how many characters can fit inside an input
			JTextField dimenInps = new JTextField();
			dimenInps.setPreferredSize(new Dimension(200,45));
			final int track = i;
            
            // Set the placeholder text initially
            setPlaceholder(dimenInps, track);
         // Add focus listener to handle placeholder behavior
            dimenInps.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    removePlaceholder(dimenInp[track]);                    
                }
                @Override
                public void focusLost(FocusEvent e) {
                	if(dimenInps.getText().isEmpty()) {
                		setPlaceholder(dimenInp[track], track);  
                	}
                }
            });

         // Add key listener to remove placeholder on typing
            dimenInps.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    if (dimenInps.getText().isEmpty()) {
                        setPlaceholder(dimenInps, track);
                    }
                }
            });
            

            
            dimenInp[i] = dimenInps;
            getContentPane().add(dimenInps);
            panel.add(dimenInps);
            
		}
		
		for(int i = 0; i < Buttons.length; i++) {
			final String[] info = {"Add Order", "Order Info","Best Shipping"}; 
			Buttons[i] = new JButton(info[i]);
			Buttons[i].setPreferredSize(new Dimension(200,45));
			panel.add(Buttons[i]);

		}
		Buttons[0].addActionListener(new BtnAdd());
		Buttons[1].addActionListener(new BtnInfo());
		Buttons[2].addActionListener(new BtnBest());
		
		
		panel.add(DisRes);
		add(panel);	
		setVisible(true);
			
	}
	
	private void setPlaceholder(JTextField dimInps, int track) {
        String placeholder1 = placeholder[track];
        dimInps.setForeground(Color.GRAY);
        dimInps.setText(placeholder1);
    }

    private void removePlaceholder(JTextField dimInps) {
    	dimInps.setText("");
    	dimInps.setForeground(Color.BLACK);
    }
    

    private class BtnAdd implements ActionListener {
    	
        public void actionPerformed(ActionEvent e) {
        	
        	for(int i = 0; i < dimenInp.length;){
        		String check = dimenInp[i].getText();
        		if (check.equals(placeholder[i]) || check.isEmpty()) {
        			JOptionPane.showMessageDialog(null, "Please fill in the correct data!");
        			break;
        		}
        		try {
        			orderName = dimenInp[0].getText();
        			width = Double.parseDouble(dimenInp[1].getText());
        			height = Double.parseDouble(dimenInp[2].getText());
        			length = Double.parseDouble(dimenInp[3].getText());
        			weight = Double.parseDouble(dimenInp[4].getText());
        			quantity = Integer.parseInt(dimenInp[5].getText());
        			
        			  
        			Item send = new Item(orderName, width, height, length, weight);
        			Calculation calculation = new Calculation();
        			calculation.addItems(send);
        			JOptionPane.showMessageDialog(null, "Done!");
        			
        			
    			} catch (NumberFormatException ex) {
    				// Handle the case when the text cannot be parsed as a double
    			}
        		
          		break;
            }
        	
        }
    }
    private class BtnInfo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Perform specific actions for the "Order Info" button
     	
        	for(int i = 0; i < dimenInp.length;){
        		String check = dimenInp[i].getText();
        		if (check.equals(placeholder[i]) || check.isEmpty()) {
        			JOptionPane.showMessageDialog(null, "Please enter the correct data!");
        			break;
        		}
        		
        		try {
        			orderName = dimenInp[0].getText();
        			width = Double.parseDouble(dimenInp[1].getText());
        			height = Double.parseDouble(dimenInp[2].getText());
        			length = Double.parseDouble(dimenInp[3].getText());
        			weight = Double.parseDouble(dimenInp[4].getText());
        			quantity = Integer.parseInt(dimenInp[5].getText());
        			
        			Item send = new Item(orderName, width, height, length, weight);
        			Calculation calculation = new Calculation();
        			calculation.addOrder(quantity);
        			calculation.addItems(send);
        			
            		DisRes.setText(calculation.GUIprintOrder() + "\n" + "Item: " + send.getProduct_name() + "\nDimensions: " + 
            				 send.getWidth() + "x" + send.getHeight() + "x" + send.getLength() + " cm" + "\nTotal Volume: " + 
            				 calculation.totalVolume() + " cm3" + "\nTotal weight: " + calculation.totalWeight() + " kg"
            				);
            		
    			} catch (NumberFormatException ex) {
    				// Handle the case when the text cannot be parsed as a double
    				JOptionPane.showMessageDialog(null, "Please enter the correct data type!");
    			}
        		break;
            }    
       }
    }

    private class BtnBest implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Perform specific actions for the "Best Shipping" button
        	
        	for(int i = 0; i < dimenInp.length;){
        		String check = dimenInp[i].getText();
        		if (check.equals(placeholder[i]) || check.isEmpty()) {
        			JOptionPane.showMessageDialog(null, "Please enter the correct data!");
        			break;
        		}

        		try {
        			orderName = dimenInp[0].getText();
        			width = Double.parseDouble(dimenInp[1].getText());
        			height = Double.parseDouble(dimenInp[2].getText());
        			length = Double.parseDouble(dimenInp[3].getText());
        			weight = Double.parseDouble(dimenInp[4].getText());
        			quantity = Integer.parseInt(dimenInp[5].getText());
        			     			  
        			Item send = new Item(orderName, width, height, length, weight);
        			Calculation calculation = new Calculation();
        			calculation.addOrder(quantity);
        			calculation.addItems(send);
        			DisRes.setText(DisRes.getText() + "\n----------------------\n" + calculation.GUIbestShipping());
        			
        			
    			} catch (NumberFormatException ex) {
    				// Handle the case when the text cannot be parsed as a double
    			}
        		
          		break;
            }
    
        	
        }
    }
    
	
	private static void MakeAtry() {
		
		try {
             UIManager.setLookAndFeel(
		         "javax.swing.plaf.nimbus.NimbusLookAndFeel"
		       );
        }catch (Exception exc) { 
        	System.out.println(exc.getMessage());
		}
	}
	
	
	public static void main(String[] arguments) {
		
		MakeAtry();         
		GUI_Part gui = new GUI_Part(); 
		SwingUtilities.invokeLater(() -> {
			panel.requestFocusInWindow(); // Transfer focus to the panel
		});
		}
}

