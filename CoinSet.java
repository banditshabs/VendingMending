import java.util.ArrayList;

/**
   A set of coins.
*/
public class CoinSet
{  
   private ArrayList<Coin> set;

   /**
      Constructs a CoinSet object.
   */
   public CoinSet()
   {  
      set = new ArrayList<Coin>();
   }
   //ADD REMAINING CODE HERE
    
   public void addCoin(Coin coin) {
	   set.add(coin);
   }
   
   public double totalCoin() {
	   double total = 0;
	   for(int i=0; i<set.size(); i++) {
		   total = total + set.get(i).getValue();
	   }
	   return total;
   }
   
   public double removeCoin() {
	   double total = this.totalCoin();
	   set.clear();
	   return total;
   }
   
}