import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import java.awt.List;
import java.awt.Scrollbar;
import java.util.HashMap;
import java.util.Map;


public class ShopScreen extends JFrame {

	private JPanel contentPane;
	private JLabel wallpaper;
	private JButton goBackBtn;

	public ShopScreen() {
		super("Yu-Gi-Oh");

	   System.out.println("ShopMenu");


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
				if(e.getSource() == goBackBtn)
				{
					DataState.setupPlayerMenuScreenFrame(DataState.getShopScreenFrame());
				}
			}
		}
		//End of Inner Class//////////////////////////////////////////////////////////////////////////////
		
		goBackBtn = new JButton("Go Back");
		goBackBtn.addActionListener(new ChangeWindowListener());
		goBackBtn.setToolTipText("Saves and brings back to title screen");
		goBackBtn.setFont(new Font("Segoe Print", Font.BOLD, 45));
		goBackBtn.setBounds(959, 675, 267, 68);
		contentPane.add(goBackBtn);
		
		wallpaper = new JLabel("");
		wallpaper.setIcon(new ImageIcon("images\\Shop_Background.png.jpg"));
		wallpaper.setBounds(0, 0, 1268, 780);
		contentPane.add(wallpaper);
	}

}
