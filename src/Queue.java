import javax.swing.DefaultListModel;

	public class Queue{
	public DefaultListModel <Customer> list;
	
	public Queue() {
	list= new DefaultListModel<Customer>();
	}

	DefaultListModel<Customer>list(){
		return list;}
	
	 void Add_Customer(Customer customer){				
		 list.addElement(customer);}
	
	 int getSize() {
		return list.getSize();}
	
	 Customer remove(){				
		 return list.remove(0);}
	
	
	

	
	


	
}

