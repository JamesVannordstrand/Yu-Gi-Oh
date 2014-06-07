public class Card {

	private String name, image, type, field, effect;                   
	
	private int attack, defense, stars, price, cardIndex;                             
	
	private boolean ritual, fusion;                        
	
	private boolean onField = false;                //is the card on the field
	private boolean attackStatus = false;           //Has it attacked this turn

	private boolean inDeck;                         //is it in the deck

	private boolean face = true;                    //face up or face down
	private boolean position = true;                //attack or defense mode
   
	
  public Card(String name, String image, String type, String field, String effect,
              int attack, int defense, int stars, int price, boolean ritual, 
              boolean fusion){
    this.name    = name;
    this.image   = image;
    this.type    = type;
    this.field   = field;
    this.effect  = effect;
    this.attack  = attack;
    this.defense = defense;
    this.stars   = stars;
    this.price   = price;
    this.ritual  = ritual;
    this.fusion  = fusion;
  }

  public Card(int index, boolean inDeck){
    cardIndex = index;
    this.inDeck = inDeck;
  } 

  //for saving game data
  public int getCardIndex(){return cardIndex;}   
  public boolean getInDeck(){return inDeck;}
  public String getField(){return field;}
  public String getImage(){return image;}

  public String getCardInfo(String type)
  {
    if(type.equalsIgnoreCase("Magic")| type.equalsIgnoreCase("Trap")){
      String info = "<html>" + name + "<br>" + effect + "</html>";
      return info;
    }else {
      String info = "<html>" + name + "<br>Attack : " + Integer.toString(attack) + "<br>Defense : " + Integer.toString(defense) 
                     + "<br>Stars : " + Integer.toString(stars) + "<br>Effect : " + effect + "</html>";
      return info;
    }
  }

}
