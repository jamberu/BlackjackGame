package gamba;

import deck.*;
import player.*;
import java.util.Scanner;

public class Main {
    private static void displayCards(Hand player) {
        System.out.println(player.name + " Total Cards: " + player.getTotalValue());
        String playerCards = "";

        for (Card card: player.getHeldCards()) {
            playerCards = playerCards.concat("[" + card.getValue() +  card.getSuit() + "] ");
        }
        System.out.println(playerCards);
    }

    private static void playerTurn(Pool deck, Hand player, char move) {
        if (move == 'H' || move == '1') {
            Card playerCard = deck.drawCard();
            player.addCard(playerCard);

            if (player.getTotalValue() < 10 && playerCard.getValue() == 1) {
                playerCard.setValue(1);
            }
            else if (player.getTotalValue() == 10 && playerCard.getValue() == 1) {
                playerCard.setValue(11);
            }
        }
        displayCards(player);
    }

    public static void dealerTurn(Pool deck, Dealer dealer, char move) {
        if (move == 'H' || move == '1') {
            Card dealerCard = deck.drawCard();
            dealer.addCard(dealerCard);

            if (dealer.getTotalValue() < 10 && dealerCard.getValue() == 1) {
                dealerCard.setValue(1);
            }
            else if (dealer.getTotalValue() == 10 && dealerCard.getValue() == 1) {
                dealerCard.setValue(11);
            }
        }
        displayCards(dealer);
    }

    public static int checkForWin(Hand player, Dealer dealer) {
        int playerTotal = player.getTotalValue();
        int dealerTotal = dealer.getTotalValue();


        if (playerTotal > 21 && dealerTotal < 21) {
            System.out.println("\nPlayer's cards busted. Dealer wins.");
            return 0;
        }
        else if (dealerTotal > 21 && playerTotal < 21) {
            System.out.println("\nDealer's cards busted. Player wins.");
            return 0;
        }
        else if (playerTotal == 21 && dealerTotal < 21) {
            System.out.println("\nPlayer got a blackjack. Player wins.");
            return 0;
        }
        else if (dealerTotal == 21 && playerTotal < 21) {
            System.out.println("\nDealer got a blackjack. Dealer wins.");
            return 0;
        }
        else if (dealerTotal == playerTotal) {
            System.out.println("\nIt's a draw. Tie game.");
            return 0;
        }

        return 1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pool deck = new Pool(52);
        Hand player = new Hand("Player");
        Dealer dealer = new Dealer("AI Dealer");

        System.out.println("\tWELCOME TO BLACKJACK GAME");
        System.out.println("--------------------------------\n");

        System.out.print("Shuffling the deck of cards...\n");

        deck.shufflePool();

        playerTurn(deck, player, '1');
        dealerTurn(deck, dealer, '1');

        int winner = checkForWin(player, dealer);

        while (winner == 1) {
            winner = checkForWin(player, dealer);

            if (winner == 0) {
                break;
            }

            System.out.println("\nAVAILABLE MOVES: H for [HIT] | S for [STAND]");
            System.out.print("Input: ");
            char playerMove = input.next().charAt(0);
            char dealerMove = dealer.move();

            if (playerMove == 'S' && dealerMove == 'S') {
                if (player.getTotalValue() < dealer.getTotalValue()) {
                    System.out.println("\nThe dealer got a higher score than the player. The Dealer wins.");
                }
                else {
                    System.out.println("\nThe player got a higher score than the dealer. The Player wins.");
                }
                break;
            }
            System.out.println();
            playerTurn(deck, player, playerMove);
            dealerTurn(deck, dealer, dealerMove);
        }
    }
}