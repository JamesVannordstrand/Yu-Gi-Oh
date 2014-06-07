import java.util.*;
import java.io.*;
import javax.swing.*;

//This class holds all the data that needs to be saved while the game is running, On startup decks are loaded on exit custom decks are saved

public class Data {

   //Windows/////////////////
   private Main_Menu mainMenuScreen;
   private PlayerMenuScreen playerMenuScreen;
   private BrowseDeckScreen browseDeckScreen;
   private ShopScreen shopScreen;
   private DualScreen dualScreen;
   //Windows/////////////////

   private Card[] allCards;
   private Card[] kiabaDeck;
   private Card[] yugiDeck;
   private Card[] joeyDeck;
   private Card[] pegasusDeck;                                     //all of the decks are loaded in on startup
   private Card[] marikDeck;
   private Card[] rexDeck;
   private Card[] weevilDeck;
   private Card[] randomDeck;
   private Card[][] allDecks; 

   private Player player1;
   private Player player2;
   private Player player3;
   private Player player4;
   private Player currentPlayer;                                  //this is the custom deck that the player choose at the beginning
   private Player computer = new Player(); 

   private String customDeck1File = "Custom_Deck_1.txt";
   private String customDeck2File = "Custom_Deck_2.txt";
   private String customDeck3File = "Custom_Deck_3.txt";
   private String customDeck4File = "Custom_Deck_4.txt";
   private String currentFile;                                     //the file that the user is currently using the deck to

   private static Formatter cardFormatter;

   private Random r = new Random();


  public Data(){

     System.out.println("DataMenu");

     allCards = Card.getCardArray("All_Cards_Text.txt");
     kiabaDeck = Card.getPrebuiltDeck("Kiaba_Deck.txt");
     yugiDeck = Card.getPrebuiltDeck("Yugi_Deck.txt");
     joeyDeck = Card.getPrebuiltDeck("Joey_Deck.txt");     
     pegasusDeck = Card.getPrebuiltDeck("Pegasus_Deck.txt");
     marikDeck = Card.getPrebuiltDeck("Marik_Deck.txt");
     rexDeck = Card.getPrebuiltDeck("Rex_Deck.txt");
     weevilDeck = Card.getPrebuiltDeck("Weevil_Deck.txt");
     randomDeck = Card.getPrebuiltDeck("Random_Deck.txt");

     allDecks = new Card[][]{kiabaDeck, yugiDeck, joeyDeck, pegasusDeck, marikDeck, rexDeck, weevilDeck, randomDeck};

     player1 = Card.getCustomDeck(customDeck1File);
     player2 = Card.getCustomDeck(customDeck2File);
     player3 = Card.getCustomDeck(customDeck3File);
     player4 = Card.getCustomDeck(customDeck4File);
  }

  //used to get a frame//////////////////////////////////////////////////////////////////
  public JFrame getMainMenuFrame(){return mainMenuScreen;}

  public JFrame getDualScreenFrame(){return dualScreen;}

  public JFrame getBrowseDeckScreenFrame(){return browseDeckScreen;}

  public JFrame getShopScreenFrame(){return shopScreen;}

  public JFrame getPlayerMenuScreenFrame(){return playerMenuScreen;}
  ///////////////////////////////////////////////////////////////////////////////////////

  //Observers////////////////////////////////////////////////////////////////////////////
  public String getCustomNames(int number){
    String[] names = new String[]{player1.getName(), player2.getName(), player3.getName(), player4.getName()};
    return names[number];
  }

  public int getCustomWins(){return currentPlayer.getWins();}

  public int getCustomLosses(){return currentPlayer.getLosses();}

  public int getCustomMoney(){return currentPlayer.getMoney();}

  public  boolean getIsCustomDeck(){return currentPlayer.isCustom();}

  public Card getCardWithIndex(int index){return allCards[index];}   
  //End of Observers////////////////////////////////////////////////////////////////////////////


  //Call anytime you go to dualScreen
  public void setComputerToRandomDeck(){
     computer = Card.addPrebuiltDeckToPlayerClass(allDecks[r.nextInt(allDecks.length - 1)]);
  }

  //called when the User chooses a prebuilt or custom deck
  public void setPlayerDeck(String deckName){
      if(deckName.equals("Yugi")){currentPlayer = Card.addPrebuiltDeckToPlayerClass(yugiDeck);}
      else if(deckName.equals("Kiaba")){currentPlayer = Card.addPrebuiltDeckToPlayerClass(kiabaDeck);}
      else if(deckName.equals("Joey")){currentPlayer = Card.addPrebuiltDeckToPlayerClass(joeyDeck);}
      else if(deckName.equals("Pegasus")){currentPlayer = Card.addPrebuiltDeckToPlayerClass(pegasusDeck);}
      else if(deckName.equals("Marik")){currentPlayer = Card.addPrebuiltDeckToPlayerClass(marikDeck);}
      else if(deckName.equals("Weevil")){currentPlayer = Card.addPrebuiltDeckToPlayerClass(weevilDeck);}
      else if(deckName.equals("Rex")){currentPlayer = Card.addPrebuiltDeckToPlayerClass(rexDeck);}
      else if(deckName.equals("Random")){currentPlayer = Card.addPrebuiltDeckToPlayerClass(randomDeck);}
      else if(deckName.equals("Custom1")){currentPlayer = player1; currentFile = customDeck1File;} 
      else if(deckName.equals("Custom2")){currentPlayer = player2; currentFile = customDeck2File;} 
      else if(deckName.equals("Custom3")){currentPlayer = player3; currentFile = customDeck3File;} 
      else if(deckName.equals("Custom4")){currentPlayer = player4; currentFile = customDeck4File;}
   }
  //////////////////////////////////////////////////////////////////////////

   public void saveFile(){
      try
      {
         cardFormatter = new Formatter(currentFile);
      }
      catch(Exception e)
      {
         System.out.print("That File doesn't exist");
      }
      cardFormatter.format("%s%n", currentPlayer.getName());
      cardFormatter.format("%d%n", currentPlayer.getTotalCardsOwned());
      cardFormatter.format("%d%n", currentPlayer.getNumberOfCardsInDeck());
      cardFormatter.format("%d%n", currentPlayer.getWins());
      cardFormatter.format("%d%n", currentPlayer.getLosses());
      cardFormatter.format("%d%n", currentPlayer.getMoney());

      Card[] deck = currentPlayer.getDeck();

      for(int count = 0; count < deck.length; count++)
      {
         cardFormatter.format("%d%n", deck[count].getCardIndex());
         cardFormatter.format("%b%n", deck[count].getInDeck());
      
      }
      cardFormatter.close();
   }


   public Player getPlayer(){return currentPlayer;}

   public Player getComputer(){return computer;}

  //Loads main menu window because you can't load all the windows right away
  public void setupWindowFramesInitial(){
    mainMenuScreen = new Main_Menu();
    mainMenuScreen.setVisible(true);
  }

  //Call these when ever you need open a new window
  public void setupPlayerMenuScreenFrame(JFrame currentFrame){
    currentFrame.dispose();
    playerMenuScreen = new PlayerMenuScreen();
    playerMenuScreen.setVisible(true);
  }

  public void setupShopScreenFrame(JFrame currentFrame){
    currentFrame.dispose();
    shopScreen = new ShopScreen();
    shopScreen.setVisible(true);
  }

  public void setupBrowseDeckScreenFrame(JFrame currentFrame){
    currentFrame.dispose();
    browseDeckScreen = new BrowseDeckScreen();
    browseDeckScreen.setVisible(true);
  }

  public void setupDualScreenFrame(JFrame currentFrame){
    currentFrame.dispose();
    dualScreen = new DualScreen();
    dualScreen.setVisible(true);
  }

  public void setupMainMenuFrame(JFrame currentFrame){
    currentFrame.dispose();
    mainMenuScreen = new Main_Menu();
    mainMenuScreen.setVisible(true);
  }

}
