/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author gubotdev
 */
public class BlackJack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Dealer micheal = new Dealer(2);
        micheal.playGame();
        // TODO code application logic here
//        Deck myDeck = new Deck();
//        Hand myHand = new Hand();
//        myDeck.printDeck();
//        for(int i = 0; i < 6; i++){
//            myHand.addCard(myDeck.dealCard());
//            System.out.println("numOfCards: " + myHand.getNumOfCards() + " | ");
//            
//        }
//        
//        for(int i = 0; i < 54; i++){
//            Card temp = myDeck.dealCard();
//            System.out.println(temp.RANK + "-of-" + temp.SUIT);
        }
 }
