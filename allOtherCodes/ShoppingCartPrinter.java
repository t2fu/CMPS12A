import java.util.*;
public class ShoppingCartPrinter{
  static Scanner scnr=new Scanner(System.in);
  public static void main(String[]args){
    System.out.println("Item 1");
    System.out.println("Enter the item name:");
    String name1=scnr.nextLine();
    System.out.println("Enter the item price:");
    int pri=scnr.nextInt();
    System.out.println("Enter the item quantity:");
    int quanti=scnr.nextInt();
    ItemToPurchase item1=new ItemToPurchase(name1,pri,quanti);
    System.out.println("");
    System.out.println("Item 2");
    System.out.println("Enter the item name:");
    String name2=scnr.nextLine();
    name2=scnr.nextLine();
    System.out.println("Enter the item price:");
    int pri2=scnr.nextInt();
    System.out.println("Enter the item quantity:");
    int quanti2=scnr.nextInt();
    ItemToPurchase item2=new ItemToPurchase(name2,pri2,quanti2);
    System.out.println("");
    System.out.println("TOTAL COST");
    System.out.println(item1.getName()+" "+item1.getQuantity()+" @ $"+item1.getPrice()+" = $"+(item1.getQuantity()*item1.getPrice()));
    System.out.println(item2.getName()+" "+item2.getQuantity()+" @ $"+item2.getPrice()+" = $"+(item2.getQuantity()*item2.getPrice()));
    System.out.println("");
    int TC=(item1.getQuantity()*item1.getPrice())+(item2.getQuantity()*item2.getPrice());
    System.out.println("Total: $"+TC);
  
  
  
  
  
  
  
  
  
  
  }
  
  
  
}