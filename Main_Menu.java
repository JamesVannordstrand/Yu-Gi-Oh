import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.Icon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Main_Menu extends JFrame {

	private JPanel contentPane;

	//Buttons
	private JButton custom_deck_1, custom_deck_2, custom_deck_3, 
	                      custom_deck_4, yugiBtn, kiabaBtn, 
	                      marikBtn, joeyBtn, pegasusBtn, 
	                      weevilBtn, rexBtn, randomBtn,
	                      volumeUp, volumeDown, mute;
   
   //Labels
	private JLabel label, label1, lblcustomdeck, label2, lblOr,
	                     label3, label4, label5, label6, label7,
	                     label8, label9, label10, lblNewLabel;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataState.dataStateInitialize();
					DataState.setupWindowFramesInitial();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Main_Menu() {
		super("Yu-Gi-Oh");

		System.out.println("MainMenu");

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 125, 1284, 819);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	 	contentPane.setLayout(null);

		//Inner Class//////////////////////////////////////////////////////////////////////////////

		final class ChangeWindowListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == custom_deck_1 || e.getSource() == custom_deck_2 || 
					e.getSource() == custom_deck_3 || e.getSource() == custom_deck_4){
					if(e.getSource() == custom_deck_1){DataState.setPlayerDeck("Custom1");}
				   else if(e.getSource() == custom_deck_2){DataState.setPlayerDeck("Custom2");}
				   else if(e.getSource() == custom_deck_3){DataState.setPlayerDeck("Custom3");}
				   else if(e.getSource() == custom_deck_4){DataState.setPlayerDeck("Custom4");}
					DataState.setupPlayerMenuScreenFrame(DataState.getMainMenuFrame());
				}else{
				  if(e.getSource() == marikBtn){DataState.setPlayerDeck("Marik");}
				  else if(e.getSource() == yugiBtn){DataState.setPlayerDeck("Yugi");}
				  else if(e.getSource() == kiabaBtn){DataState.setPlayerDeck("Kiaba");}
				  else if(e.getSource() == joeyBtn){DataState.setPlayerDeck("Joey");}
				  else if(e.getSource() == pegasusBtn){DataState.setPlayerDeck("Pegasus");}
				  else if(e.getSource() == rexBtn){DataState.setPlayerDeck("Rex");}
				  else if(e.getSource() == weevilBtn){DataState.setPlayerDeck("Weevil");}
				  else if(e.getSource() == randomBtn){DataState.setPlayerDeck("Random");}
					DataState.setComputerToRandomDeck();
          DataState.setupDualScreenFrame(DataState.getMainMenuFrame());
				}
			}
		}

		final class VolumeListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == volumeUp && !DataState.getMute()){
					DataState.turnUpVolume();
				}else if(e.getSource() == volumeDown && !DataState.getMute()){
					DataState.turnDownVolume();
				}else if(e.getSource() == mute && !DataState.getMute()){
					DataState.muteVolume();
				}else if(e.getSource() == mute && DataState.getMute()){
					DataState.resumeVolume();
				}
			}
		}
		//End of Inner Class//////////////////////////////////////////////////////////////////////////////
		
		volumeDown = new JButton("Volume Down");
		volumeDown.addActionListener(new VolumeListener());
		volumeDown.setBounds(1143, 25, 125, 25);
		contentPane.add(volumeDown);

		volumeUp = new JButton("Volume Up");
		volumeUp.addActionListener(new VolumeListener());
		volumeUp.setBounds(1143, 0, 125, 25);
		contentPane.add(volumeUp);

		mute = new JButton("Mute");
		mute.addActionListener(new VolumeListener());
		mute.setBounds(1143, 50, 125, 25);
		contentPane.add(mute);

		yugiBtn = new JButton(new ImageIcon("images\\Yugi.png"));
		yugiBtn.addActionListener(new ChangeWindowListener());
		yugiBtn.setBounds(56, 170, 78, 74);
		contentPane.add(yugiBtn);
		
		kiabaBtn = new JButton(new ImageIcon("images\\Kiaba.png"));
		kiabaBtn.addActionListener(new ChangeWindowListener());
		kiabaBtn.setBounds(258, 208, 78, 74);
		contentPane.add(kiabaBtn);
		
		marikBtn = new JButton(new ImageIcon("images\\Marik.png"));
		marikBtn.addActionListener(new ChangeWindowListener());
		marikBtn.setBounds(56, 310, 78, 74);
		contentPane.add(marikBtn);
		
		joeyBtn = new JButton(new ImageIcon("images\\Joey.png"));
		joeyBtn.addActionListener(new ChangeWindowListener());
		joeyBtn.setBounds(258, 345, 78, 74);
		contentPane.add(joeyBtn);
		
		pegasusBtn = new JButton(new ImageIcon("images\\Pegasus.png"));
		pegasusBtn.addActionListener(new ChangeWindowListener());
		pegasusBtn.setBounds(56, 439, 78, 74);
		contentPane.add(pegasusBtn);
		
		weevilBtn = new JButton(new ImageIcon("images\\Weevil.png"));
		weevilBtn.addActionListener(new ChangeWindowListener());
		weevilBtn.setBounds(258, 471, 78, 74);
		contentPane.add(weevilBtn);
		
		rexBtn = new JButton(new ImageIcon("images\\Rex.png"));
		rexBtn.addActionListener(new ChangeWindowListener());
		rexBtn.setBounds(56, 560, 78, 74);
		contentPane.add(rexBtn);
		
		randomBtn = new JButton(new ImageIcon("images\\Random.png"));
		randomBtn.addActionListener(new ChangeWindowListener());
		randomBtn.setBounds(258, 596, 78, 74);
		contentPane.add(randomBtn);
		
		custom_deck_1 = new JButton(DataState.getCustomName(0));
		custom_deck_1.addActionListener(new ChangeWindowListener());
		custom_deck_1.setForeground(Color.BLACK);
		custom_deck_1.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 45));
		custom_deck_1.setBounds(741, 218, 267, 81);
		contentPane.add(custom_deck_1);
		
		custom_deck_2 = new JButton(DataState.getCustomName(1));
		custom_deck_2.addActionListener(new ChangeWindowListener());
		custom_deck_2.setForeground(Color.BLACK);
		custom_deck_2.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 45));
		custom_deck_2.setBounds(856, 345, 267, 81);
		contentPane.add(custom_deck_2);
		
		custom_deck_3 = new JButton(DataState.getCustomName(2));
		custom_deck_3.addActionListener(new ChangeWindowListener());
		custom_deck_3.setForeground(Color.BLACK);
		custom_deck_3.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 45));
		custom_deck_3.setBounds(741, 471, 267, 81);
		contentPane.add(custom_deck_3);
		
		custom_deck_4 = new JButton(DataState.getCustomName(3));
		custom_deck_4.addActionListener(new ChangeWindowListener());
		custom_deck_4.setForeground(Color.BLACK);
		custom_deck_4.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 45));
		custom_deck_4.setBounds(856, 596, 267, 81);
		contentPane.add(custom_deck_4);

		lblcustomdeck = new JLabel("custom deck!");
		lblcustomdeck.setForeground(Color.WHITE);
		lblcustomdeck.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 45));
		lblcustomdeck.setBounds(772, 62, 330, 81);
		contentPane.add(lblcustomdeck);
		
		label = new JLabel("Quick Duel!");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 45));
		label.setBounds(81, 30, 267, 81);
		contentPane.add(label);
		
		label1 = new JLabel("_________________________");
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 45));
		label1.setBounds(22, 62, 559, 81);
		contentPane.add(label1);
		
		label2 = new JLabel("_________________________");
		label2.setForeground(Color.WHITE);
		label2.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 45));
		label2.setBounds(727, 88, 559, 81);
		contentPane.add(label2);

		label3 = new JLabel("______");
		label3.setForeground(Color.WHITE);
		label3.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 45));
		label3.setBounds(544, 110, 173, 81);
		contentPane.add(label3);
		
		label4 = new JLabel("____");
		label4.setForeground(Color.WHITE);
		label4.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 45));
		label4.setBounds(544, 179, 173, 81);
		contentPane.add(label4);
		
		label5 = new JLabel("__");
		label5.setForeground(Color.WHITE);
		label5.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 45));
		label5.setBounds(544, 264, 173, 81);
		contentPane.add(label5);
		
		label6 = new JLabel("____");
		label6.setForeground(Color.WHITE);
		label6.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 45));
		label6.setBounds(544, 345, 173, 81);
		contentPane.add(label6);
		
		label7 = new JLabel("______");
		label7.setForeground(Color.WHITE);
		label7.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 45));
		label7.setBounds(544, 432, 173, 81);
		contentPane.add(label7);
		
		label8 = new JLabel("____");
		label8.setForeground(Color.WHITE);
		label8.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 45));
		label8.setBounds(544, 517, 173, 81);
		contentPane.add(label8);
		
		label9 = new JLabel("__");
		label9.setForeground(Color.WHITE);
		label9.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 45));
		label9.setBounds(544, 596, 173, 81);
		contentPane.add(label9);
		
		label10 = new JLabel("____");
		label10.setForeground(Color.WHITE);
		label10.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 45));
		label10.setBounds(544, 671, 173, 81);
		contentPane.add(label10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("images\\Background.png"));
		lblNewLabel.setBounds(0, 0, 1268, 780);
		contentPane.add(lblNewLabel);

	  lblOr = new JLabel("OR");
		lblOr.setForeground(Color.WHITE);
		lblOr.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 45));
		lblOr.setBounds(562, 74, 111, 81);
		contentPane.add(lblOr);
	}



}
