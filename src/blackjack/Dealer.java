/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Scanner;



/**
 *
 * @author gubotdev
 */
public class Dealer {
    
    private Hand dealerHand = new Hand();
    private Player[] myPlayers = new Player[0];
    private Deck myDeck = new Deck();
    private Scanner scan = new Scanner(System.in);
    
    
    public Dealer(int numOfPlayers){
        
        initMyPlayers(numOfPlayers);
    
    }
    
    public void playGame(){
        dealOutOpeningHand();
        takePlayerTurns();
        playOutDealerHand();
        DeclareWinners();
    }
    
    public void dealOutOpeningHand(){
        for(int i = 0; i < 2; i++){
            for(Player currPlayer : myPlayers){
                currPlayer.getMyHand().addCard(myDeck.dealCard());
            }
            dealerHand.addCard(myDeck.dealCard());
        }
        
    }
    public void playOutPlayerHands(){
        for(int i = 0; i < 2; i++){
            for(Player currPlayer : myPlayers){
                currPlayer.getMyHand().addCard(myDeck.dealCard());
            }
            dealerHand.addCard(myDeck.dealCard());
        }
    }
    
    public void takePlayerTurns(){
        for(Player currPlayer : myPlayers){
            System.out.println("\n" + currPlayer.getMyname() + "'s Hand");
            currPlayer.getMyHand().printHand();
            while (currPlayer.getMyHand().getNumOfCards() < 5 &&
                    currPlayer.getMyHand().getScore() < 21){
                System.out.println("Want a hit? (y/n)");
                char opt = scan.next().toLowerCase().charAt(0);
                System.out.print("\n");
                if (opt=='y'){
                    System.out.println("\n" + currPlayer.getMyname() + "'s Hand");
                    currPlayer.getMyHand().addCard(myDeck.dealCard());
                 
                }else{
                    break;
                }
                currPlayer.getMyHand().printHand();
            }
        }
        
    }
    
    public void playOutDealerHand(){
        while(dealerHand.getScore() < 16){
            dealerHand.addCard(myDeck.dealCard());
        }
        dealerHand.printHand();
    }
    
    public void DeclareWinners(){
        
        for(int i = 0; i < myPlayers.length; i++){
            Player currPlayer = myPlayers[i];
            if(dealerHand.getScore() > 21 ||
                    currPlayer.getMyHand().getScore() > 21){
                
                if(currPlayer.getMyHand().getScore() > 21){
                    System.out.println(currPlayer.getMyname() + " you busted");   
                }else{
                    System.out.println(currPlayer.getMyname() + " dealer busted, "
                    + "you win!!!");
                }
            }else if(dealerHand.getScore() == 21 ||
                    dealerHand.getNumOfCards() > 4){
                System.out.println(currPlayer.getMyname() + 
                        " The dealer is hot tonight... you lose!!!");
            }else if(currPlayer.getMyHand().getNumOfCards() > 4){
                System.out.println(currPlayer.getMyname() + " Five cards under.."
                        + "must be luck, you win!!!");
            }else if(currPlayer.getMyHand().getScore() > dealerHand.getScore()){
                System.out.println(currPlayer.getMyname() + "you win this time,"
                        + "but there will be another...");
            }else{
                System.out.println(currPlayer.getMyname() + " quit while you got "
                        + "enough for a cab ride home loser!!!");
            }
        }
    }
    
    private void initMyPlayers(int numOfPlayers){
        myPlayers = new Player[numOfPlayers];
        for(int i = 0; i < myPlayers.length; i++){
            System.out.println("player " + (i + 1) + ", what's your name?");
            String name = scan.next();
            if(name.equals("")){
                myPlayers[i] = new Player(i + 1);
            }else{
                myPlayers[i] = new Player(name);
            }
        }
    }
   
}
