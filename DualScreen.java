import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.awt.*;


public class DualScreen extends JFrame {

	private JPanel contentPane;
    
   //these variables are for positioning method
   private int x, y, width, height;
	
	//aliases of player and computer so I don't need to go through data class
   private Player human, computer;

	//All buttons
	private JButton computerDeckBtn, computerFusionBtn, computerGraveBtn, computerFieldBtn;
	private JButton[] computerSpellBtns = new JButton[5];
	private JButton[] computerMonsterBtns = new JButton[5];
	private JButton[] computerHandBtns = new JButton[8];

  private JButton playerDeckBtn,playerFusionBtn, playerGraveBtn, playerFieldBtn;
  private JButton[] playerSpellBtns = new JButton[5];
  private JButton[] playerMonsterBtns = new JButton[5];
	private JButton[] playerHandBtns = new JButton[8];

	private JButton largeCardBtn, activateBtn, positionBtn, attackBtn,
	                flipBtn, placeBtn, goBackBtn, endTurnBtn;


	private JLabel currentCardLbl, computerLifePointsLbl, playerLifePointsLbl, duelBackgrund;

	private boolean endTurn = false;

	public DualScreen(){

		System.out.println("DualMenu");

		//this is so i can easliy use observers and transformers in player class
		human = DataState.getPlayer();
		computer = DataState.getComputer();


		//Inner Classes//////////////////////////////////////////////////////////////////////////////

		final class ChangeWindowListener implements ActionListener{
	
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == goBackBtn && human.isCustom()){
					human.reset();
					computer.reset();
					DataState.setupPlayerMenuScreenFrame(DataState.getDualScreenFrame());
				}else{
					human.reset();
					computer.reset();
					DataState.setupMainMenuFrame(DataState.getDualScreenFrame());				}
			}
		}

		// final class AttackListener implements ActionListener{

		// 	public void actionPerformed(ActionListener e){
		// 		if(e.getSource() == attackBtn){
		// 			System.out.println("");
		// 		}
		// 	}
		// }
		//End of Inner Classes//////////////////////////////////////////////////////////////////////////////
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 125, 1284, 819);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		playerLifePointsLbl = new JLabel(Integer.toString(human.getLifePoints()));
		playerLifePointsLbl.setForeground(Color.WHITE);
		playerLifePointsLbl.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 45));
		playerLifePointsLbl.setBounds(24, 624, 314, 81);
		contentPane.add(playerLifePointsLbl);
		
		computerLifePointsLbl = new JLabel(Integer.toString(computer.getLifePoints()));
		computerLifePointsLbl.setForeground(Color.WHITE);
		computerLifePointsLbl.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 45));
		computerLifePointsLbl.setBounds(32, 159, 314, 81);
		contentPane.add(computerLifePointsLbl);
		
		computerDeckBtn = new JButton("");
		computerDeckBtn.setIcon(new ImageIcon("Images\\Monster_Field.png"));
		computerDeckBtn.setBounds(373, 173, 62, 88);
		contentPane.add(computerDeckBtn);
		
		computerSpellBtns[0] = new JButton("");
		computerSpellBtns[0].setIcon(new ImageIcon("Images\\Magic_Trap_field.png"));
		computerSpellBtns[0].setBounds(456, 173, 62, 88);
		contentPane.add(computerSpellBtns[0]);
		
		computerSpellBtns[1] = new JButton("");
		computerSpellBtns[1].setIcon(new ImageIcon("Images\\Magic_Trap_field.png"));
		computerSpellBtns[1].setBounds(539, 173, 62, 88);
		contentPane.add(computerSpellBtns[1]);
		
		computerSpellBtns[2] = new JButton("");
		computerSpellBtns[2].setIcon(new ImageIcon("Images\\Magic_Trap_field.png"));
		computerSpellBtns[2].setBounds(619, 173, 62, 88);
		contentPane.add(computerSpellBtns[2]);
		
		computerFusionBtn = new JButton("");
		computerFusionBtn.setIcon(new ImageIcon("Images\\Fuzion_Field.png"));
		computerFusionBtn.setBounds(871, 173, 62, 88);
		contentPane.add(computerFusionBtn);
		
		computerSpellBtns[3] = new JButton("");
		computerSpellBtns[3].setIcon(new ImageIcon("Images\\Magic_Trap_field.png"));
		computerSpellBtns[3].setBounds(705, 173, 62, 88);
		contentPane.add(computerSpellBtns[3]);
		
		computerSpellBtns[4] = new JButton("");
		computerSpellBtns[4].setIcon(new ImageIcon("Images\\Magic_Trap_field.png"));
		computerSpellBtns[4].setBounds(788, 173, 62, 88);
		contentPane.add(computerSpellBtns[4]);
		
		computerGraveBtn = new JButton("");
		computerGraveBtn.setIcon(new ImageIcon("Images\\graveyard_field.png"));
		computerGraveBtn.setBounds(373, 263, 62, 88);
		contentPane.add(computerGraveBtn);
		
		computerMonsterBtns[2] = new JButton("");
		computerMonsterBtns[2].setIcon(new ImageIcon("Images\\Monster_Field.png"));
		computerMonsterBtns[2].setBounds(619, 263, 62, 88);
		contentPane.add(computerMonsterBtns[2]);
		
		computerMonsterBtns[0] = new JButton("");
		computerMonsterBtns[0].setIcon(new ImageIcon("Images\\Monster_Field.png"));
		computerMonsterBtns[0].setBounds(456, 263, 62, 88);
		contentPane.add(computerMonsterBtns[0]);
		
		computerMonsterBtns[1] = new JButton("");
		computerMonsterBtns[1].setIcon(new ImageIcon("Images\\Monster_Field.png"));
		computerMonsterBtns[1].setBounds(539, 263, 62, 88);
		contentPane.add(computerMonsterBtns[1]);
		
		computerMonsterBtns[3] = new JButton("");
		computerMonsterBtns[3].setIcon(new ImageIcon("Images\\Monster_Field.png"));
		computerMonsterBtns[3].setBounds(705, 263, 62, 88);
		contentPane.add(computerMonsterBtns[3]);
		
		computerMonsterBtns[4] = new JButton("");
		computerMonsterBtns[4].setIcon(new ImageIcon("Images\\Monster_Field.png"));
		computerMonsterBtns[4].setBounds(788, 263, 62, 88);
		contentPane.add(computerMonsterBtns[4]);
		
		computerFieldBtn = new JButton("");
		computerFieldBtn.setIcon(new ImageIcon("Images\\field_field.png"));
		computerFieldBtn.setBounds(871, 263, 62, 88);
		contentPane.add(computerFieldBtn);
		
		playerFieldBtn = new JButton("");
		playerFieldBtn.setIcon(new ImageIcon("Images\\field_field.png"));
		playerFieldBtn.setBounds(373, 426, 62, 88);
		contentPane.add(playerFieldBtn);
		
		playerMonsterBtns[0] = new JButton(""); 
    playerMonsterBtns[0].setIcon(new ImageIcon("Images\\Monster_Field.png"));
		playerMonsterBtns[0].setBounds(456, 426, 62, 88);
		contentPane.add(playerMonsterBtns[0]);
		
		playerMonsterBtns[1] = new JButton("");
		playerMonsterBtns[1].setIcon(new ImageIcon("Images\\Monster_Field.png"));
		playerMonsterBtns[1].setBounds(539, 426, 62, 88);
		contentPane.add(playerMonsterBtns[1]);
		
		playerMonsterBtns[2] = new JButton("");
		playerMonsterBtns[2].setIcon(new ImageIcon("Images\\Monster_Field.png"));
		playerMonsterBtns[2].setBounds(622, 426, 62, 88);
		contentPane.add(playerMonsterBtns[2]);
		
		playerMonsterBtns[3] = new JButton("");
		playerMonsterBtns[3].setIcon(new ImageIcon("Images\\Monster_Field.png"));
		playerMonsterBtns[3].setBounds(705, 426, 62, 88);
		contentPane.add(playerMonsterBtns[3]);
		
		playerMonsterBtns[4] = new JButton("");
		playerMonsterBtns[4].setIcon(new ImageIcon("Images\\Monster_Field.png"));
		playerMonsterBtns[4].setBounds(788, 426, 62, 88);
		contentPane.add(playerMonsterBtns[4]);
		
		playerGraveBtn = new JButton("");
		playerGraveBtn.setIcon(new ImageIcon("images\\graveyard_field.png"));
		playerGraveBtn.setBounds(871, 426, 62, 88);
		contentPane.add(playerGraveBtn);
		
		playerFusionBtn = new JButton("");
		playerFusionBtn.setIcon(new ImageIcon("images\\Fuzion_Field.png"));
		playerFusionBtn.setBounds(373, 516, 62, 88);
		contentPane.add(playerFusionBtn);
		
		playerSpellBtns[0] = new JButton("");
		playerSpellBtns[0].setIcon(new ImageIcon("Images\\Magic_Trap_field.png"));
		playerSpellBtns[0].setBounds(456, 516, 62, 88);
		contentPane.add(playerSpellBtns[0]);
		
		playerSpellBtns[1] = new JButton("");
		playerSpellBtns[1].setIcon(new ImageIcon("Images\\Magic_Trap_field.png"));
		playerSpellBtns[1].setBounds(539, 516, 62, 88);
		contentPane.add(playerSpellBtns[1]);
		
		playerSpellBtns[2] = new JButton("");
	  playerSpellBtns[2].setIcon(new ImageIcon("Images\\Magic_Trap_field.png"));
		playerSpellBtns[2].setBounds(622, 516, 62, 88);
		contentPane.add(playerSpellBtns[2]);
		
		playerSpellBtns[3] = new JButton("");
		playerSpellBtns[3].setIcon(new ImageIcon("Images\\Magic_Trap_field.png"));
		playerSpellBtns[3].setBounds(705, 516, 62, 88);
		contentPane.add(playerSpellBtns[3]);
		
		playerSpellBtns[4] = new JButton("");
		playerSpellBtns[4].setIcon(new ImageIcon("Images\\Magic_Trap_field.png"));
		playerSpellBtns[4].setBounds(788, 516, 62, 88);
		contentPane.add(playerSpellBtns[4]);
		
		playerDeckBtn = new JButton("");
		playerDeckBtn.setIcon(new ImageIcon("images\\Monster_Field.png"));
		playerDeckBtn.setBounds(871, 516, 62, 88);
		contentPane.add(playerDeckBtn);
		
		computerHandBtns[0] = new JButton("");
		computerHandBtns[0].setBounds(373, 34, 62, 88);
		computerHandBtns[0].setVisible(false);
		contentPane.add(computerHandBtns[0]);
		
		computerHandBtns[1] = new JButton("");
		computerHandBtns[1].setBounds(445, 34, 62, 88);
		computerHandBtns[1].setVisible(false);
		contentPane.add(computerHandBtns[1]);
		
		computerHandBtns[2] = new JButton("");
		computerHandBtns[2].setBounds(517, 34, 62, 88);
		computerHandBtns[2].setVisible(false);
		contentPane.add(computerHandBtns[2]);
		
		computerHandBtns[3] = new JButton("");
		computerHandBtns[3].setBounds(589, 34, 62, 88);
		computerHandBtns[3].setVisible(false);
		contentPane.add(computerHandBtns[3]);
		
		computerHandBtns[4] = new JButton("");
		computerHandBtns[4].setBounds(661, 34, 62, 88);
		computerHandBtns[4].setVisible(false);
		contentPane.add(computerHandBtns[4]);
		
		computerHandBtns[5] = new JButton("");
		computerHandBtns[5].setBounds(733, 34, 62, 88);
		computerHandBtns[5].setVisible(false);
		contentPane.add(computerHandBtns[5]);
		
		computerHandBtns[6] = new JButton("");
		computerHandBtns[6].setBounds(805, 34, 62, 88);
		computerHandBtns[6].setVisible(false);
		contentPane.add(computerHandBtns[6]);

		computerHandBtns[7] = new JButton("");
		computerHandBtns[7].setBounds(877, 34, 62, 88);
		computerHandBtns[7].setVisible(false);
		contentPane.add(computerHandBtns[7]);
		
		playerHandBtns[0] = new JButton("");
		playerHandBtns[0].setBounds(373, 655, 62, 88);
		playerHandBtns[0].setVisible(false);
		contentPane.add(playerHandBtns[0]);
		
		playerHandBtns[1] = new JButton("");
		playerHandBtns[1].setBounds(445, 655, 62, 88);
	  playerHandBtns[1].setVisible(false);
		contentPane.add(playerHandBtns[1]);
		
		playerHandBtns[2] = new JButton("");
		playerHandBtns[2].setBounds(517, 655, 62, 88);
		playerHandBtns[2].setVisible(false);
		contentPane.add(playerHandBtns[2]);
		
		playerHandBtns[3] = new JButton("");
		playerHandBtns[3].setBounds(589, 655, 62, 88);
		playerHandBtns[3].setVisible(false);
		contentPane.add(playerHandBtns[3]);
		
		playerHandBtns[4] = new JButton("");
		playerHandBtns[4].setBounds(661, 655, 62, 88);
		playerHandBtns[4].setVisible(false);
		contentPane.add(playerHandBtns[4]);
		
		playerHandBtns[5] = new JButton("");
		playerHandBtns[5].setBounds(733, 655, 62, 88);
		playerHandBtns[5].setVisible(false);
		contentPane.add(playerHandBtns[5]);
		
		playerHandBtns[6] = new JButton("");
		playerHandBtns[6].setBounds(805, 655, 62, 88);
		playerHandBtns[6].setVisible(false);
		contentPane.add(playerHandBtns[6]);

		playerHandBtns[7] = new JButton("");
		playerHandBtns[7].setBounds(877, 655, 62, 88);
		playerHandBtns[7].setVisible(false);
		contentPane.add(playerHandBtns[7]);
		
		JLabel lblOpponants = new JLabel("Opponants");
		lblOpponants.setForeground(Color.WHITE);
		lblOpponants.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 45));
		lblOpponants.setBounds(34, 11, 267, 81);
		contentPane.add(lblOpponants);
		
		JLabel lblMylifePoints = new JLabel("My lifePoints");
		lblMylifePoints.setForeground(Color.WHITE);
		lblMylifePoints.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 45));
		lblMylifePoints.setBounds(24, 532, 322, 81);
		contentPane.add(lblMylifePoints);
		
		JLabel lbllifePoints = new JLabel("lifePoints");
		lbllifePoints.setForeground(Color.WHITE);
		lbllifePoints.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 45));
		lbllifePoints.setBounds(34, 67, 267, 81);
		contentPane.add(lbllifePoints);
		
		JLabel label = new JLabel("____________");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 45));
		label.setBounds(32, 89, 314, 81);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("_______________");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 45));
		label_1.setBounds(24, 551, 314, 81);
		contentPane.add(label_1);
		
		endTurnBtn = new JButton("End Turn");
		endTurnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {endTurn = true;}
		});
		endTurnBtn.setFont(new Font("Segoe Print", Font.BOLD, 45));
		endTurnBtn.setBounds(1001, 666, 267, 68);
		contentPane.add(endTurnBtn);
		
		largeCardBtn = new JButton("");
		largeCardBtn.setBounds(1021, 173, 234, 351);
		largeCardBtn.setVisible(false);
		contentPane.add(largeCardBtn);
		
		currentCardLbl = new JLabel("Current Card Chosen");
		currentCardLbl.setForeground(Color.WHITE);
		currentCardLbl.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		currentCardLbl.setBounds(1021, 141, 234, 29);
		currentCardLbl.setVisible(false);
		contentPane.add(currentCardLbl);
		
		placeBtn = new JButton();
		placeBtn.setFont(new Font("Segoe Print", Font.BOLD, 15));
		placeBtn.setBounds(1021, 535, 108, 29);
		placeBtn.setVisible(false);
		contentPane.add(placeBtn);
		
		activateBtn = new JButton("Activate");
		activateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		activateBtn.setFont(new Font("Segoe Print", Font.BOLD, 15));
		activateBtn.setBounds(1147, 535, 108, 29);
		activateBtn.setVisible(false);
		contentPane.add(activateBtn);
		
		positionBtn = new JButton("position");
		positionBtn.setFont(new Font("Segoe Print", Font.BOLD, 15));
		positionBtn.setBounds(1021, 575, 108, 29);
		positionBtn.setVisible(false);
		contentPane.add(positionBtn);
		
		attackBtn = new JButton("attack");
		attackBtn.setFont(new Font("Segoe Print", Font.BOLD, 15));
		attackBtn.setBounds(1147, 577, 108, 29);
		attackBtn.setVisible(false);
		contentPane.add(attackBtn);
		
		flipBtn = new JButton("Flip");
		flipBtn.setToolTipText("face UP.");
		flipBtn.setFont(new Font("Segoe Print", Font.BOLD, 15));
		flipBtn.setBounds(1083, 615, 108, 29);
		flipBtn.setVisible(false);
		contentPane.add(flipBtn);
		
		goBackBtn = new JButton("Exit Duel");
		goBackBtn.addActionListener(new ChangeWindowListener());
		goBackBtn.setFont(new Font("Segoe Print", Font.BOLD, 45));
		goBackBtn.setBounds(1001, 24, 267, 68);
		contentPane.add(goBackBtn);
		
		duelBackgrund = new JLabel("");
		duelBackgrund.setIcon(new ImageIcon("images\\Duel_Background.jpg"));
		duelBackgrund.setBounds(0, 0, 1280, 790);
		contentPane.add(duelBackgrund);

		drawNCards(human, 7, "Human");
		drawNCards(computer, 7, "Computer");
	}

	//sets JButton in hand to card
	public void setHandJButtonPlayer(Card card, JButton button){
		if(card != null){
			Card referenceCard = DataState.getCardWithIndex(card.getCardIndex());
			ImageIcon cardImage = new ImageIcon(referenceCard.getImage());
      Image image = cardImage.getImage().getScaledInstance(62, 88, Image.SCALE_SMOOTH);       //not setting hand images correctly?
      cardImage.setImage(image);
      button.setIcon(cardImage);

      button.setToolTipText(referenceCard.getCardInfo(referenceCard.getField()));
      button.setVisible(true);
    }else
      button.setVisible(false);
	}

	public void setHandJButtonComputer(Card card, JButton button){
		if(card != null){
			button.setIcon(new ImageIcon("Images\\Monster_Field.png"));
      	button.setVisible(true);
      }else
      	button.setVisible(false);
	}

	//Draws many cards 
	public void drawNCards(Player player, int n, String who){
		for (int i=0;i<n;i++) 
			player.addToHand(player.draw());
		
		if(who.equals("Human")){
			for(int i = 0; i<player.getHandCount(); i++)
				setHandJButtonPlayer(player.getHand()[i], playerHandBtns[i]);
		}else if(who.equals("Computer")){
			for(int i = 0; i<player.getHandCount(); i++)
				setHandJButtonComputer(player.getHand()[i], computerHandBtns[i]);
		}
	}
}
