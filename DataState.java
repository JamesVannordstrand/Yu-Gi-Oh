import java.util.*;
import java.io.*;
import javax.swing.*;
import java.util.Scanner;
import java.io.File;
// import javax.sound.sampled.AudioInputStream;
// import javax.sound.sampled.AudioSystem;
// import javax.sound.sampled.Clip;
import javax.sound.sampled.*;

public class DataState {   //Singleton class

  //Windows/////////////////
  private static Main_Menu mainMenuScreen;
  private static PlayerMenuScreen playerMenuScreen;
  private static BrowseDeckScreen browseDeckScreen;
  private static ShopScreen shopScreen;
  private static DualScreen dualScreen;
  //Windows/////////////////

  private static Card[] allCards;
  private static Player kiaba;
  private static Player yugi;
  private static Player joey;
  private static Player pegasus;                            
  private static Player marik;
  private static Player rex;
  private static Player weevil;
  private static Player random;
  private static Player human;
  private static Player computer;                                  
  private static Player[] allPlayers; 

  private static String[] customNames;

  private static String[] customDeckFiles = new String[]{"Custom_Deck_1.txt", "Custom_Deck_2.txt",
                                                         "Custom_Deck_3.txt", "Custom_Deck_4.txt"};
  
  private static String soundName = "Yu-Gi-Oh_Original_Theme_song_Full_.wav";    

  private static String currentFile; //the file that the user is currently using the deck to

  //utilities
  private static Formatter cardFormatter;
  private static Scanner cardFile;
  private static Random r = new Random();
  private static AudioInputStream audioInputStream;
  private static Clip clip; 
  private static FloatControl gainControl;
  private static float volume = 3.0f;
  private static boolean mute = false;

  public static void dataStateInitialize(){
    System.out.println("DataMenu");

    try{
      audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
      clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
      clip.start();
    }catch(Exception e){
      e.printStackTrace();
    }

    allCards    = getAllCards("All_Cards_Text.txt");
    kiaba       = getPrebuiltPlayer("Kiaba_Deck.txt");
    yugi        = getPrebuiltPlayer("Yugi_Deck.txt");
    joey        = getPrebuiltPlayer("Joey_Deck.txt");     
    pegasus     = getPrebuiltPlayer("Pegasus_Deck.txt");
    marik       = getPrebuiltPlayer("Marik_Deck.txt");
    rex         = getPrebuiltPlayer("Rex_Deck.txt");
    weevil      = getPrebuiltPlayer("Weevil_Deck.txt");
    random      = getPrebuiltPlayer("Random_Deck.txt");

    allPlayers = new Player[]{kiaba, yugi, joey, pegasus, marik, rex, weevil, random};
    customNames = setCustomNames();
  }

/////volume///// 
  public static void turnUpVolume(){
    volume++;
    gainControl.setValue(volume);
  }

  public static void turnDownVolume(){
    volume--;
    gainControl.setValue(volume);
  }

  public static void muteVolume(){
    mute = true;
    gainControl.setValue(-80.0f);
  }

  public static void resumeVolume(){
    mute = false;
    gainControl.setValue(volume);
  }

  public static boolean getMute(){
    return mute;
  }
////////

  //used to get a frame//////////////////////////////////////////////////////////////////
  public static JFrame getMainMenuFrame(){return mainMenuScreen;}

  public static JFrame getDualScreenFrame(){return dualScreen;}

  public static JFrame getBrowseDeckScreenFrame(){return browseDeckScreen;}

  public static JFrame getShopScreenFrame(){return shopScreen;}

  public static JFrame getPlayerMenuScreenFrame(){return playerMenuScreen;}
  ///////////////////////////////////////////////////////////////////////////////////////
  
  public static String[] setCustomNames(){
    String[] names = new String[4];
    for(int i = 0; i<names.length; i++){
      try{
         cardFile = new Scanner(new File(customDeckFiles[i]));
      }
      catch(Exception e){
         System.out.print("That file doesn't exist");
      }
      names[i] = cardFile.nextLine();
      cardFile.close();
    }

    return names;
  }
  public static String getCustomName(int position){return customNames[position];}

  //Call anytime you go to dualScreen
  public static void setComputerToRandomDeck(){
     computer = allPlayers[r.nextInt(allPlayers.length - 1)];
  }

  //called when the User chooses a prebuilt or custom deck
  public static void setPlayerDeck(String deckName){
      if(deckName.equals("Yugi")){human = yugi;}          //TODO could be making and alias 
      else if(deckName.equals("Kiaba")){human = kiaba;}
      else if(deckName.equals("Joey")){human = joey;}
      else if(deckName.equals("Pegasus")){human = pegasus;}
      else if(deckName.equals("Marik")){human = marik;}
      else if(deckName.equals("Weevil")){human = weevil;}
      else if(deckName.equals("Rex")){human = rex;}
      else if(deckName.equals("Random")){human = random;}
      else if(deckName.equals("Custom1")){
        human       = getCustomPlayer(customDeckFiles[0]);
        currentFile = customDeckFiles[0];
      }else if(deckName.equals("Custom2")){
        human       = getCustomPlayer(customDeckFiles[1]);
        currentFile = customDeckFiles[1];
      }else if(deckName.equals("Custom3")){
        human       = getCustomPlayer(customDeckFiles[2]);
        currentFile = customDeckFiles[2];
      }else if(deckName.equals("Custom4")){
        human       = getCustomPlayer(customDeckFiles[3]);
        currentFile = customDeckFiles[3];
      }
   }
  //////////////////////////////////////////////////////////////////////////

  //Access File
  public static Card[] getAllCards(String fileName){
    String name, image, type, field, effect;
    int attack, defense, stars, price;
    boolean ritual, fusion;
    
    try{
       cardFile = new Scanner(new File(fileName));
    }
    catch(Exception e){
       System.out.print("That file doesn't exist");
    }
    
    Card[] deck = new Card[cardFile.nextInt()];
    cardFile.nextLine();
    
    for(int count = 0;count < deck.length;count++){
      name    = cardFile.nextLine();
      image   = cardFile.nextLine();
      type    = cardFile.nextLine();
      field   = cardFile.nextLine();
      effect  = cardFile.nextLine();
      attack  = cardFile.nextInt();
      defense = cardFile.nextInt();
      stars   = cardFile.nextInt();
      price   = cardFile.nextInt();
      cardFile.nextLine();
      ritual  = cardFile.nextBoolean();
      fusion  = cardFile.nextBoolean();
      cardFile.nextBoolean();
      cardFile.nextBoolean();

      if(cardFile.hasNext())
        cardFile.nextLine();

      deck[count] = new Card(name, image, type, field, effect, attack, 
                             defense, stars, price, ritual, fusion);
    }
    cardFile.close();
    return deck;
   }


   //Made this to speed up game and loading decks (indexes all cards and assigns from there)
  public static Player getCustomPlayer(String fileName){
    String name;
    Card[] deck;
    int numberOfCardsInDeck, totalCardsOwned, money, wins, losses;
    boolean custom = true;

    try{
       cardFile = new Scanner(new File(fileName));
    }
    catch(Exception e){
       System.out.print("That file doesn't exist");
    }

    name                = cardFile.nextLine();    
    totalCardsOwned     = cardFile.nextInt();
    numberOfCardsInDeck = cardFile.nextInt();
    wins                = cardFile.nextInt();
    losses              = cardFile.nextInt();
    money               = cardFile.nextInt();

    deck = new Card[totalCardsOwned];
     
    for(int count = 0; count < deck.length; count++){
      int index      = cardFile.nextInt();
      boolean inDeck = cardFile.nextBoolean();
      deck[count]    = new Card(index, inDeck);
    } 

    cardFile.close();
    return (new Player(name, deck, numberOfCardsInDeck, 
                       totalCardsOwned, money, wins, losses, custom));
  }
   
  public static Player getPrebuiltPlayer(String fileName){
    String name = fileName.split("_")[0];
    int numberOfCardsInDeck, totalCardsOwned, money, wins, losses;
    boolean custom = false;
    Card[] deck;

    try{
       cardFile = new Scanner(new File(fileName));
    }
    catch(Exception e){
       System.out.print("That file doesn't exist");
    }
    
    totalCardsOwned     = cardFile.nextInt();
    numberOfCardsInDeck = totalCardsOwned;
    wins                = 0;
    losses              = 0;
    money               = 0;

    deck = new Card[totalCardsOwned];
    
    for(int count = 0; count < deck.length; count++){
       int index      = cardFile.nextInt();
       boolean inDeck = true;
       deck[count]    = new Card(index, inDeck);
    } 
     
    cardFile.close();
    return (new Player(name, deck, numberOfCardsInDeck, totalCardsOwned,
                       money, wins, losses, custom));
  }

   public static void saveFile(){
      try{
         cardFormatter = new Formatter(currentFile);
      }
      catch(Exception e){
         System.out.print("That File doesn't exist");
      }

      cardFormatter.format("%s%n", human.getName());
      cardFormatter.format("%d%n", human.getTotalCardsOwned());
      cardFormatter.format("%d%n", human.getNumberOfCardsInDeck());
      cardFormatter.format("%d%n", human.getWins());
      cardFormatter.format("%d%n", human.getLosses());
      cardFormatter.format("%d%n", human.getMoney());

      Card[] deck = human.getDeck();

      for(int count = 0; count < deck.length; count++){
         cardFormatter.format("%d%n", deck[count].getCardIndex());
         cardFormatter.format("%b%n", deck[count].getInDeck());
      }

      cardFormatter.close();
   }
//////////////////////////////////////////////////

  public static Player getPlayer(){return human;}

  public static Player getComputer(){return computer;}

  public static Card getCardWithIndex(int index){
    return allCards[index];
  }

  //Loads main menu window because you can't load all the windows right away
  public static void setupWindowFramesInitial(){
    mainMenuScreen = new Main_Menu();
    mainMenuScreen.setVisible(true);
  }

  //Call these when ever you need open a new window
  public static void setupPlayerMenuScreenFrame(JFrame currentFrame){
    currentFrame.dispose();
    playerMenuScreen = new PlayerMenuScreen();
    playerMenuScreen.setVisible(true);
  }

  public static void setupShopScreenFrame(JFrame currentFrame){
    currentFrame.dispose();
    shopScreen = new ShopScreen();
    shopScreen.setVisible(true);
  }

  public static void setupBrowseDeckScreenFrame(JFrame currentFrame){
    currentFrame.dispose();
    browseDeckScreen = new BrowseDeckScreen();
    browseDeckScreen.setVisible(true);
  }

  public static void setupDualScreenFrame(JFrame currentFrame){
    currentFrame.dispose();
    dualScreen = new DualScreen();
    dualScreen.setVisible(true);
  }

  public static void setupMainMenuFrame(JFrame currentFrame){
    currentFrame.dispose();
    mainMenuScreen = new Main_Menu();
    mainMenuScreen.setVisible(true);
  }

}
