public class ItemToPurchase{
  
  private String itemName="none";
  private int itemPrice=0;
  private int itemQuantity=0;
  
  public ItemToPurchase(String n,int p,int q){
  itemName=n;
  itemPrice=p;
  itemQuantity=q;
  }
  public ItemToPurchase(){
  itemName="none";
  itemPrice=0;
  itemQuantity=0;  
    
  }
  public String getName(){
   
   return itemName;
  }
  
  public void setName(String NN){
    
   itemName=NN; 
  }
  
  public int getPrice(){
   
   return itemPrice;
  }
  
  public void setPrice(int NN){
    
   itemPrice=NN; 
  }
  public int getQuantity(){
   
   return itemQuantity;
  }
  
  public void setQuantity(int NN){
    
   itemQuantity=NN; 
  }
  
  
  
  
  
}