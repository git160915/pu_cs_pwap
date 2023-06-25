public class CardDeckArray {
    public static void main (String[] args) {
        String[] arrsCards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] arrsSuits = {"\u2660", "\u2663", "\u2666", "\u2665"};
        String[] arrsCardDeck = new String[52];

        for (int i = 0; i < arrsSuits.length; i++) {
            for (int j = 0; j < arrsCards.length; j++) {
                arrsCardDeck[j+13*i] = arrsCards[j] + arrsSuits[i];
            }
        }

        for (int i = 0; i < arrsCardDeck.length; i++) {
            System.out.print(arrsCardDeck[i] + " ");

            if ((i + 1) % 13 == 0) {
                System.out.println();
            }
        }
    }
}