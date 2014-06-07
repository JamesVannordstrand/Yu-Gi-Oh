public class Player {

	private boolean custom;               							  //if this is a custom deck
	private int lifePoints = 8000;               				  //lifePoints of this player
	private String name;                  							  //name of this player 
	private int totalCardsDrawn = 0;        							  //Total cards this player currently has drawn

	private int totalCardsOwned;        				           //Total cards owned by this player
  private int numberOfCardsInDeck;
	private int money;                    				  			  //money this player has 
	private int wins;                     				  			  //wins this player has
	private int losses;                   				  			  //losses this player has
	
	private Card[] deck;                   				        //deck of the player
	
	private Card[] hand   = new Card[8];                         //hand array
	private int handCount = 0;                                 //hand array size
	 
	private Card[] monsterField   = new Card[5];                 //Monster array
	private int monsterFieldCount = 0;                         //Monster array size
	
	private Card[] magicField   = new Card[5];                   //Magic array
	private int magicFieldCount = 0;                           //Magic array size
	
	private Card[] grave;                                      //grave array 
	private int graveCount = 0;                                //grave array size 

  private int currentSacrificed = 0;                          //Amount of monsters sacrificed this turn
  private boolean monstersLaid  = false;                       //If a monster has been laid down this turn

  public Player(String name, Card[] deck, int numberOfCardsInDeck,
                int totalCardsOwned, int money, int wins,
                int losses, boolean custom){
    this.name = name;
    this.deck = deck;
    this.numberOfCardsInDeck = numberOfCardsInDeck;
    this.totalCardsOwned     = totalCardsOwned;
    this.money  = money;
    this.wins   = wins;
    this.losses = losses;
    this.custom = custom;
  }

  //for being able to save data
  public String getName(){return name;}
  public int getTotalCardsOwned(){return totalCardsOwned;}
  public int getNumberOfCardsInDeck(){return numberOfCardsInDeck;}
  public int getWins(){return wins;}
  public int getLosses(){return losses;}
  public int getMoney(){return money;}
  public int getLifePoints(){return lifePoints;}
  public Card[] getDeck(){return deck;}
  public boolean isCustom(){return custom;}
  public Card[] getHand(){return hand;} 
  public int getHandCount(){return handCount;} 
  public int getTotalCardsDrawn(){return totalCardsDrawn;}

  public void reset(){
  	for(int i = 0; i<handCount; i++)
  		hand[i] = null;

  	for(int i = 0; i<monsterFieldCount; i++)
  		monsterField[i] = null;

  	for(int i = 0; i<magicFieldCount; i++)
  		magicField[i] = null;

  	lifePoints = 8000;
  	handCount = 0;
  	monsterFieldCount = 0;
  	magicFieldCount = 0;
  	graveCount = 0;
  	currentSacrificed = 0;
  	totalCardsDrawn = 0;
  }

  public Card draw(){
  	totalCardsDrawn++;
  	return deck[totalCardsDrawn - 1];
  }

	public void addToHand(Card card){
		hand[handCount] = card;
		handCount++;
	}

	public void removeFromHand(){
		hand[handCount] = null;
		handCount--;
	}
}
