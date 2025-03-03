import java.util.*;
class Card{
    String symbol;
    String value;
    public Card(String symbol, String value){
        this.symbol = symbol;
        this.value = value;
    }
    public void print(){
        System.out.println("Symbol: " + symbol + " Value: " + value);
    }
}
public class CardCollection{
    public static void main(String[] args){
        Map<String, List<Card>> cardCollection = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("..........Card Collection System..........");
            System.out.print("1- Add Card:\n2- Search Cards by symbol:\n3- Display all cards:\n4- Exit!!!\n");
            System.out.print("Enter the choice: ");
            int ch = sc.nextInt();
            switch(ch){
                case 1:
                    System.out.print("Enter the symbol of the card: ");
                    String symbol = sc.next();
                    System.out.print("Enter the value of the card: ");
                    String value = sc.next();
                    Card card = new Card(symbol, value);
                    if(cardCollection.containsKey(symbol)){
                        System.out.println("Card already exists.");
                        System.out.println(cardCollection.get(symbol).add(card));
                    }
                    else{
                        List<Card> cards = new ArrayList<>();
                        cards.add(card);
                        cardCollection.put(symbol, cards);
                        System.out.println("Card added successfully!");
                    }
                    break;
                case 2:
                    System.out.print("Enter the symbol of the card to be searched: ");
                    String symbolToSearch = sc.next();
                    if(cardCollection.containsKey(symbolToSearch)) {
                        System.out.println("Cards found.");
                        for (Card c : cardCollection.get(symbolToSearch)) {
                            c.print();
                        }
                    }
                    else{
                        System.out.println("No cards are found for this symbol.");
                    }
                    break;
                case 3:
                    System.out.println("All cards in Collection.");
                    for(String s : cardCollection.keySet()){
                        //System.out.println("Symbol: " + s);
                        for(Card c : cardCollection.get(s)){
                            c.print();
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting....");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice done!!");
            }
        }
    }
}