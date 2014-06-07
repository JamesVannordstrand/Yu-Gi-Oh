import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PlayerMenuScreen extends JFrame {

	private JPanel contentPane;
	final private JButton shopBtn, goBackBtn, browseDeckBtn, dualBtn;
	final private JLabel deckStatsLbl, winsLbl, lossesLbl, moneyLbl, wallpaperLbl;
	private JLabel numberOfWinsLbl, numberOfLossesLbl, amountOfMoneyLbl;
	private Player human;

	public PlayerMenuScreen() {
		super("Yu-Gi-Oh");

		System.out.println("PlayerMenu");
		human = DataState.getPlayer();

		setResizable(false);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 125, 1284, 819);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		shopBtn = new JButton("Shop!");
		shopBtn.addActionListener(new ChangeWindowListener());
		shopBtn.setFont(new Font("Segoe Print", Font.BOLD, 45));
		shopBtn.setBounds(40, 45, 210, 68);
		contentPane.add(shopBtn);
		
		browseDeckBtn = new JButton("Browse Cards");
		browseDeckBtn.addActionListener(new ChangeWindowListener());
		browseDeckBtn.setFont(new Font("Segoe Print", Font.BOLD, 45));
		browseDeckBtn.setBounds(122, 158, 366, 68);
		contentPane.add(browseDeckBtn);
		
		dualBtn = new JButton("Duel!");
		dualBtn.addActionListener(new ChangeWindowListener());
		dualBtn.setFont(new Font("Segoe Print", Font.BOLD, 45));
		dualBtn.setBounds(359, 45, 210, 68);
		contentPane.add(dualBtn);

		goBackBtn = new JButton("Go Back");
		goBackBtn.addActionListener(new ChangeWindowListener());
		goBackBtn.setToolTipText("Saves and brings back to title screen");
		goBackBtn.setFont(new Font("Segoe Print", Font.BOLD, 45));
		goBackBtn.setBounds(974, 45, 267, 68);
		contentPane.add(goBackBtn);
		
		deckStatsLbl = new JLabel("deck Stats");
		deckStatsLbl.setForeground(Color.WHITE);
		deckStatsLbl.setFont(new Font("Segoe Print", Font.BOLD, 45));
		deckStatsLbl.setBounds(29, 338, 285, 68);
		contentPane.add(deckStatsLbl);
		
		winsLbl = new JLabel("wins :");
		winsLbl.setForeground(Color.WHITE);
		winsLbl.setFont(new Font("Segoe Print", Font.BOLD, 45));
		winsLbl.setBounds(48, 450, 152, 68);
		contentPane.add(winsLbl);
		
		lossesLbl = new JLabel("losses :");
		lossesLbl.setForeground(Color.WHITE);
		lossesLbl.setFont(new Font("Segoe Print", Font.BOLD, 45));
		lossesLbl.setBounds(36, 552, 164, 68);
		contentPane.add(lossesLbl);
		
		moneyLbl = new JLabel("money :");
		moneyLbl.setForeground(Color.WHITE);
		moneyLbl.setFont(new Font("Segoe Print", Font.BOLD, 45));
		moneyLbl.setBounds(21, 649, 253, 68);
		contentPane.add(moneyLbl);
		
		numberOfWinsLbl = new JLabel(Integer.toString(human.getWins()));
		numberOfWinsLbl.setForeground(Color.WHITE);
		numberOfWinsLbl.setFont(new Font("Segoe Print", Font.BOLD, 45));
		numberOfWinsLbl.setBounds(235, 450, 285, 68);
		contentPane.add(numberOfWinsLbl);
		
		numberOfLossesLbl = new JLabel(Integer.toString(human.getLosses()));
		numberOfLossesLbl.setForeground(Color.WHITE);
		numberOfLossesLbl.setFont(new Font("Segoe Print", Font.BOLD, 45));
		numberOfLossesLbl.setBounds(235, 552, 285, 68);
		contentPane.add(numberOfLossesLbl);
		
		amountOfMoneyLbl = new JLabel(Integer.toString(human.getMoney()));
		amountOfMoneyLbl.setForeground(Color.WHITE);
		amountOfMoneyLbl.setFont(new Font("Segoe Print", Font.BOLD, 45));
		amountOfMoneyLbl.setBounds(235, 649, 285, 68);
		contentPane.add(amountOfMoneyLbl);
		
		wallpaperLbl = new JLabel("");
		wallpaperLbl.setIcon(new ImageIcon("images\\Background_2.png"));
		wallpaperLbl.setBounds(0, 0, 1268, 780);
		contentPane.add(wallpaperLbl);

	}  //end of constructor for PlayerMenuScreen class

			//Inner Class//////////////////////////////////////////////////////////////////////////////

		final class ChangeWindowListener implements ActionListener{
	
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == goBackBtn)
				{
					DataState.saveFile();
					DataState.setupMainMenuFrame(DataState.getPlayerMenuScreenFrame());
				}else if(e.getSource() == shopBtn){
					DataState.setupShopScreenFrame(DataState.getPlayerMenuScreenFrame());
				}else if(e.getSource() == browseDeckBtn){
					DataState.setupBrowseDeckScreenFrame(DataState.getPlayerMenuScreenFrame());
				}else if(e.getSource() == dualBtn){
					DataState.setComputerToRandomDeck();
					DataState.setupDualScreenFrame(DataState.getPlayerMenuScreenFrame());
				}
			}
		}
		//End of Inner Class//////////////////////////////////////////////////////////////////////////////

}
