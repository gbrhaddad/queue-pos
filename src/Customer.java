public class Customer {
	private String name;
	private int article;


		public Customer(String name, int article) {
			this.name = name;
			this.article = article;}
					  
	  	  	public int getarticle(){
	  	  		return article;}	
	  		
	  		public String getname(){
			return name;}	
	  		

			public void setArticle(int article) {
				this.article = article;
			}
	  
      		public String toString(){ 
      		return this.getname()+(Integer.toString(article));}

      		

}
