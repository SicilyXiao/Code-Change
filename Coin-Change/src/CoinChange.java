import java.util.ArrayList;
import java.util.Scanner;

public class CoinChange {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the amount for change: $");
        int amount = input.nextInt();

        System.out.println("Enter the coin denominations, seperate them by comma:");  
        String coinDeString = input.next();
        String[] spCoinDeStrings = coinDeString.split(",");
        int size = spCoinDeStrings.length;
        int [] coinDenominations = new int [size];
        for(int i=0; i<size; i++) {
            coinDenominations[i] = Integer.parseInt(spCoinDeStrings[i]);
        }
        CoinChange coinC = new CoinChange(coinDenominations, amount);

        coinC.ChangeCoins();
        
    }

    int[] coinDenominations;
    int[] coinCount;
    int amount;

    public CoinChange(int[] coinDenominations, int amount){
        this.coinDenominations = coinDenominations;
        this.coinCount = new int[this.coinDenominations.length];
        this.amount = amount;
    }

    public void ChangeCoins(){

        for (int i = 0; i < coinDenominations.length; i++) {
            coinCount[i] = amount / coinDenominations[i];
            amount %= coinDenominations[i];
        }

        System.out.print("The minimum number of coins required for change: ");
        int totalCoins = 0;
        for (int i = 0; i < coinDenominations.length; i++) {
            if (coinCount[i] > 0) {
                totalCoins += coinCount[i];
                System.out.print(coinCount[i] + " x $" + coinDenominations[i] + " ");
            }
        }
        System.out.println("\nTotal number of coins: " + totalCoins);

    }
    
}
