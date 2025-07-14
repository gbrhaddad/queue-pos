

import javax.swing.DefaultListModel;

public class Store {
	public DefaultListModel <Customer> list;
	public Queue firstQueue,secondQueue;
	enum Line {
		first,
		second
	}
	
	public Store()
	{
		list = new DefaultListModel<Customer>();
		firstQueue = new Queue();
		secondQueue = new Queue();
	}
	
	public Queue getFirstQueue() {
		return firstQueue;
	}
	
	public void setFirstQueue(Queue firstQueue) {
		this.firstQueue = firstQueue;
	}
	
	public Queue getSecondQueue() {
		return secondQueue;
	}
	
	public void setSecondQueue(Queue secondQueue) {
		this.secondQueue = secondQueue;
	}
	
	int getListSize() {
		return list.getSize();
		}
	
	public DefaultListModel<Customer>list(){
		return list;
		}

	public void add_Customer(Customer customer)
	{
		list.addElement(customer);
	}
	
	public void Remove_Customer(int index)
	{
		list.remove(index);
	}
	
	public void moveToQueue(Line l, int index)
	{
		if(l == Line.first)
			firstQueue.Add_Customer(list.elementAt(index));
		else
			secondQueue.Add_Customer(list.elementAt(index));
	}
	public void checkout(Line l)
	{
		if (l== Line.first)
			firstQueue.remove();
		else
			secondQueue.remove();
		
	}
	
	

}