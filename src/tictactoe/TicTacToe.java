package tictactoe;
/**
 * @author Jonathan Portorreal
 * Tic Tac Toe game using swing 
 */

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToe extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//GUI variables
	JPanel      p          = new JPanel();
	XOButton [] buttons    = new XOButton[9];
	String player          = "X";
	
	//Logic variables
	String [][] tictactoe  = new String [3][3];
	int    [][] grid        = new int   [9][2];
	int count              = 0;
	String p1              = "X";
	String p2              = "O";
	
	
	
	public TicTacToe(){
		super("TicTacToe");
		setUpGUI();
		
	}
	
	public void setUpGUI(){
		setSize(400, 400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		p.setLayout(new GridLayout(3,3));
		
		for(int i = 0; i < 9; i++){
			buttons[i] = new XOButton();
			buttons[i].addActionListener(this);
			p.add(buttons[i]);
			}
		
		add(p);
		
		setVisible(true);
		
		fill();
		gridFill();

	}
		
	public void actionPerformed(ActionEvent e){
		for(int i = 0; i < 9; i++){
			if(e.getSource() == buttons[i] && buttons[i].pressed == false){
				//System.out.println("The button pressed is: " + i);
				buttons[i].setPlayer(player);
				buttons[i].setPressed(true);
				toggle();
				refill(i);

			}
		}
	
	
		if(check() == true){
			endGame();
		}
				
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Fills an array with values of GUI
	 */
	
	public void fill(){
		for(int i  = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
					tictactoe[i][j] = "E";
				
				}
		}
	}
	
	/**
	 * fills a hashtable with corresponding [][] locations for buttons
	 */
	public void gridFill(){
		int key = 0;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				int [] value = {i,j};
				grid[key]    = value;
				key++;
			}
		}
	}
	
	/**
	 * Fills an array with values of GUI
	 */
	
	public void refill(int position){
		int b            = 0;
		int X = grid[position][0];
		int Y = grid[position][1];
		
		for(int i  = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(i == X && j == Y){
					tictactoe[i][j] = buttons[position].player;
				}
				
			//	System.out.printf("the Grid is: %s at %d,%d \n", tictactoe[i][j], i, j);
			//	System.out.println(b);
				
				b++;
				
			}
		}
	}
	
	public void toggle(){
		if(player == "X"){
			player = "O";
			return;
		}
		
		player = "X";
	}
	
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Calls row, column, and diagonal checker. loss is set to their returns. If loss == true immediately return true, someone has won the game
	 * @return
	 */
	public boolean check(){
		boolean loss = checkRows();
		
	
		if(loss == false){
			loss = checkColumns();
		}
		
		if(loss == false){
			loss = checkDiagL();
		}
		
		if(loss == false){
			loss = checkDiagR();
		}
		
		return loss;
	}
	
	/**
	 * Checks every row from left to right. Counts occurrences of the equality. If count is equal to 3 this means
	 * someone achieved a 3 in a row and a loss. Returns true if count == 3, false if count < 3
	 * @return
	 */
	
	public boolean checkRows(){
		count = 0;

		//check player 1's status
	for(int i = 0; i < 3; i++){
		for(int j = 0; j< 3; j++){	
			if((p1.compareTo(tictactoe[i][j])) == 0){
				if(tictactoe[i][j]!= null) count++;
					
			}	
		}
		if(count == 3) return true;
		count = 0;
	}
	
	count = 0;
	
	//check player 2's status
	for(int i = 0; i < 3; i++){
		for(int j = 0; j< 3; j++){	
			if((p2.compareTo(tictactoe[i][j])) == 0){
				if(tictactoe[i][j]!= null) count++;
					
			}	
		}
		if(count == 3) return true;
		count = 0;
	}
	return false;
	}
	
	
	/**
	 * Checks columns from the top down. Counts occurrences of quality. If count is equal to 3 this means 
	 * someone achieved a 3 in a row and a loss. Returns true if count == 3, false if count < 3
	 * @return
	 */
	public boolean checkColumns(){
		count = 0;
		
		//check player 1's status
		for(int i = 0; i < 3; i++){
			for(int j = 0; j< 3; j++){	
				if((p1.compareTo(tictactoe[j][i])) == 0){
					if(tictactoe[j][i]!= null) count++;
				}	
			}
			if(count == 3) return true;
			count = 0;
		}
		
		count = 0;
		
		//check player 2's status
		for(int i = 0; i < 3; i++){
			for(int j = 0; j< 3; j++){	
				if((p2.compareTo(tictactoe[j][i])) == 0){
					if(tictactoe[j][i]!= null) count++;
				}	
			}
			if(count == 3) return true;
			count = 0;
		}
		return false;
	}
	
	
	/**
	 * Checks diagonal from left to right. Counts occurrences of quality. If count is equal to 3 this means 
	 * someone achieved a 3 in a row and a loss. Returns true if count == 3, false if count < 3
	 * @return
	 */
	public boolean checkDiagL(){
		count = 0;
		
		//check players 1's status
			for(int j = 0; j< 3; j++){	
				if((p1.compareTo(tictactoe[j][j])) == 0){
					if(tictactoe[j][j] != null) count++;
				}	
			
			if(count == 3 ) return true;
		}
			
			count = 0;

			//check player 2's status
			for(int j = 0; j< 3; j++){	
				if((p2.compareTo(tictactoe[j][j])) == 0){
					if(tictactoe[j][j] != null) count++;
				}	
			
			if(count == 3 ) return true;
		}
		return false;
	}
	
	
	/**
	 * Checks diagonal from right to left.Counts occurrences of quality. If count is equal to 3 this means 
	 * someone achieved a 3 in a row and a loss. Returns true if count == 3, false if count < 3
	 * @return
	 */
	public boolean checkDiagR(){
		count = 0;
		
		String a = tictactoe[0][2];
		String b = tictactoe[1][1];
		String c = tictactoe[2][0];
		
		//check player 1 status
		if(p1.compareTo(a) == 0) count++;
		if(p1.compareTo(b) == 0) count++;
		if(p1.compareTo(c) == 0) count++;
		
		if(count == 3){
			return true;
		}
		
		count = 0;
		
		//check player 2 status
		
		if(p2.compareTo(a) == 0) count++;
		if(p2.compareTo(b) == 0) count++;
		if(p2.compareTo(c) == 0) count++;
		
		if(count == 3){
			return true;
		}
		

		return false;	
	}
	
	public void clean(){
		for(int i = 0; i < 9; i++){
			buttons[i].setIcon(null);
			buttons[i].setPressed(false);
		}
	}
	
	/**
	 * If loss == true end the game by setting all TextField to "not editable". Change colors of the the field to grey
	 * to distinguish that the game is over
	 */
	public void endGame(){
		JOptionPane.showMessageDialog(null, "Play Again", "GAME OVER", 3);
		newGame();
	}
	
	public void newGame(){
		fill();
		clean();
		
	}
	
	/**
	 * compares one object preferably a String to another String. If Equal return 0, if not equal return 1, and if null return -1
	 */
	public int compareTo(Object o){
		return this.compareTo(o);
	}
	
	//-----------------------------------------------------------------------------------------------



	public static void main(String args[]){
		new TicTacToe();
	}
	

}
