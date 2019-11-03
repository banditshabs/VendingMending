import java.util.ArrayList;

/**
   A vending machine.
*/
public class VendingMachine
{  
   private ArrayList<Product> products;
   public CoinSet coins;
   public CoinSet currentCoins;

   /**
      Constructs a VendingMachine object.
   */
   public VendingMachine()
   { 
      products = new ArrayList<Product>();
      coins = new CoinSet();
      currentCoins = new CoinSet();
   }
   //ADD REMAINING CODE HERE
   
   public void addCoin(Coin coin) {
	   currentCoins.addCoin(coin);
	   coins.addCoin(coin);
   }
   
   public double removeMoney() {
	   double removed = coins.removeCoin();
	   return removed;
   }

  
/**
public void buyProduct(Product p) {
	if(products.contains(p)) {
		products.remove(p);
	} else {
		System.out.println("Product is out of stock");
	}
	
	
}
*/

public void buyProduct(Product product){
    if(!products.isEmpty()) {
        if (currentCoins.totalCoin() >= product.getPrice()) {
            products.remove(product);
            removeMoney();
        } else {
            throw new VendingException("INSUFFICIENT MONEY");
        }
    } else {
        throw new VendingException("OUT OF STOCK!");
    }
}

public void addProduct(Product product, int quantity) {
	for(int i=0;i<quantity;i++) {
		products.add(product); 
	}
	
	
}

public Product[] getProductTypes(){
    ArrayList<Product> temp = new ArrayList<Product>();
    for (int i = 0; i < products.size(); i++) {
        if (!temp.contains(products.get(i))) {
            temp.add(products.get(i));
        }
    }
    Product[] productMenu = new Product[temp.size()];
    int count = 0;
    for (Product p : temp) {
        productMenu[count] = p;
        count++;
    }
    if (products.isEmpty()){
        Product[] noProducts = new Product[1];
        noProducts[0] = new Product("EMPTY", 0);
        productMenu = noProducts;
    }
    return productMenu;
}

     
}