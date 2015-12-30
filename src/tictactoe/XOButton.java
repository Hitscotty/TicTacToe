package tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class XOButton extends JButton{
	
	ImageIcon X;
	
	String player   = "E";
	boolean pressed = false;
	
	/**
	 * 0: nothing
	 * 1: X
	 * 2: 0
	 */
	
	public XOButton(){
	}

	public void setPlayer(String player){
		
		if(player == "X"){
			X = new ImageIcon(this.getClass().getResource("X.png"));
		} else{
			X = new ImageIcon(this.getClass().getResource("O.png"));
		}
	
		setIcon(X);
		
		this.player = player;
	}
	
	public String getPlayer(){
		return player;
	}
	
	public void setPressed(boolean p){
		this.pressed = p;
	}
	
	public boolean getPressed(){
		return pressed;
	}
	
	public void setNull(){
		setIcon(null);
	}
	


		
}
