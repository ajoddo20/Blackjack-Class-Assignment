import java.util.Random;
import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        Random generator = new Random();

        int score, dealerScore;

        System.out.println("Welcome to Blackjack");
        
        score = playPlayer(stdin, generator);
        System.out.println("Your final score = " + score);
        
        dealerScore = playComputer(generator);
        System.out.println("The dealer score = " + dealerScore);

        printWinner(score, dealerScore);
    }

    public static int playPlayer(Scanner stdin, Random r) {

        boolean hit = true;
        int numcards = 0; 
        int score = 0;

        while (hit) {

            int singlecard = 0; 
            
            while (numcards < 2 || singlecard < 1) {

                int rand = Math.abs(r.nextInt()) % 13; // next card.

               
                if (rand < 10) {
                    System.out.println("Your card value = " + (rand + 1));
                    score = score + rand + 1;
                } else {
                    System.out.println("Your card value = 10");
                    score = score + 10;
                }

                numcards++;
                singlecard++;
            }

          
            System.out.println("Your current score is = " + score);
            if (score <= 21) {

                System.out.println("Would you like to hit again?");
                char ans = (stdin.next()).charAt(0);

                if (ans != 'y' && ans != 'Y') {
                    hit = false;
                }
            } else {
                hit = false;
            }
        }

        return score;

    }

    public static int playComputer(Random r) {

        int computerscore = 0;

        while (computerscore < 17) {

            int rand = Math.abs(r.nextInt()) % 13; 
            int cardvalue; 

            if (rand == 0) {

                if (computerscore < 11) {
                    cardvalue = 11;
                } else {
                    cardvalue = 1;
                }
            } else if (rand < 10) {
                cardvalue = rand + 1;
            } else {
                cardvalue = 10;
            }

            computerscore = computerscore + cardvalue;
            System.out.println("Dealer card value = " + cardvalue);
        }

        return computerscore;
    }

    public static void printWinner(int playerscore, int computerscore) {

        if (playerscore > 21 && computerscore > 21) {
            System.out.println("We have both busted. No winners today.");
        } else if (playerscore > 21) {
            System.out.println("You have busted.");
        } else if (computerscore > 21) {
            System.out.println("Dealer bust");
        } else {

            if (playerscore > computerscore) {
                System.out.println("You win");
            } else if (playerscore < computerscore) {
                System.out.println("Dealer wins");
            } else {
                System.out.println("Push");
            }
        }

    }
    }
