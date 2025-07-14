import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;
public class ControlPanel extends JPanel {	
	enum Line{
		first,
		second
	}
	public ControlPanel(Store store){			 
		 
		this.setBackground(Color.BLACK);
		
		JLabel label1= new JLabel();		
		label1= new JLabel("Add Customer");
		label1.setForeground(Color.WHITE);
		
		JLabel label2= new JLabel();		
		label2= new JLabel("Add items");
		label2.setForeground(Color.WHITE);
		
		JTextField name = new JTextField(20);  
		name.setBackground(Color.white);
		
		JTextField items= new JTextField(15);
		items.setBackground(Color.white);
		
		JButton add=new JButton("add");
		JButton AddFirst=new JButton("add to line 1");
		JButton AddSec= new JButton("add to line 2");
		JButton ServeFirst = new JButton("pay in line 1");
		JButton ServeSec= new JButton ("pay in line 2");
		
		
		JList<Customer> _list = new JList<Customer>(store.list());		
		_list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		_list.setBackground(Color.lightGray);
		_list.setSelectionBackground(Color.YELLOW);		
		
		JList<Customer>  _list2 = new JList<Customer>(store.getFirstQueue().list());
		_list2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		_list2.setBackground(Color.lightGray);
		_list2.setSelectionBackground(Color.YELLOW);
		_list2.setVisibleRowCount(4);
		
		JList<Customer>  _list3= new JList<Customer>(store.getSecondQueue().list());
		_list3.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		_list3.setBackground(Color.lightGray);
		_list3.setSelectionBackground(Color.YELLOW);
		
		
		
		GridBagConstraints fix = new GridBagConstraints();
		fix.fill = (GridBagConstraints.CENTER);
		setLayout(new GridBagLayout()); 	
		fix.fill = GridBagConstraints.BOTH;
		fix.weightx = 20;
		fix.weighty = 20;
		fix.gridx = 4;
		fix.gridy = 6;
		this.add(_list,fix);
		
		fix.weightx = 20;
		fix.weighty = 20;
		fix.gridx = 6;
		fix.gridy = 6;
		this.add(_list2,fix);
		
		fix.weightx = 20;
		fix.weighty = 20;
		fix.gridx = 8;
		fix.gridy = 6;
		this.add(_list3, fix);
	
		//Display all labels and buttons on the JPanel
	    this.add(label1);
		this.add(name);
		this.add(label2);
		this.add(items);
		this.add(add);		
		this.add(AddFirst);
		this.add(ServeFirst);
		this.add(AddSec);
		this.add(ServeSec);	
		
	
		//Adding the customer to the list
		add.addActionListener(new ActionListener(){		
		public void actionPerformed(ActionEvent a) {
			
		 if	(Integer.parseInt(items.getText())!=0) {			  
			 store.add_Customer(new Customer(name.getText(),Integer.parseInt(items.getText())));
			 }
		 else {
			 showMessageDialog(null, "Please entre right information :)");
		 }
		 }});
		
	
		//Adding the selected customer to the first line and remove it from the selection list
		AddFirst.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent b){
			
			if(store.getListSize() == 0){
				showMessageDialog(null, "No Customers in the store");}
			
			else if(store.getListSize()> 0 && _list.getSelectedIndex() >= 0){
				
				store.moveToQueue(Store.Line.first, _list.getSelectedIndex());
				store.Remove_Customer(_list.getSelectedIndex());
				}
					
			else {showMessageDialog(null,"Please select the Customer");}
			}});
		
		
		
		//Adding the selected customer to the second line and remove it from the selection list
		AddSec.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent c) {
			
			if(store.getListSize() == 0){
				showMessageDialog(null, "No Customers in the store");}
			
			else if(store.getListSize()> 0 && _list.getSelectedIndex() >= 0){
				
				store.moveToQueue(Store.Line.second, _list.getSelectedIndex());
				store.Remove_Customer(_list.getSelectedIndex());
				}
					
			else {showMessageDialog(null,"Please select the Customer");}
			}});
		
		
		//Remove the first Customer in the queue from Line1 
		ServeFirst.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent d) {
		
			if(store.getFirstQueue().getSize() == 0) {
				showMessageDialog(null,"No customers in the queue");}
			
			else {
			store.checkout(Store.Line.first);	    
		    	showMessageDialog(null, "Payed Successfully");}
		}});
		
		
		
		//Remove the first Customer in the queue from Line2.
		ServeSec.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
		
			if(store.getSecondQueue().getSize() == 0) {
				showMessageDialog(null,"No customers in the queue");}
		
			else{
				store.checkout(Store.Line.second);	    
				showMessageDialog(null, "Payed Successfully");}
		}});
				 					
				
	
	}
	
	
}

