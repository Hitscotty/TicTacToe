/**
 * @author Jonathan Portorreal
 * TicTacToe Program based of Applet
 */

package tictactoe;


import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logic extends Applet implements ActionListener, Comparable{
	
	public static int N           = 3;
	public static boolean entered = false;
	public static boolean loss    = false;
	
	//Rows of TicTac grid A to c
	/**
	TextField A1 = new TextField();
	TextField A2 = new TextField();
	TextField A3 = new TextField();
	
	TextField B1 = new TextField();
	TextField B2 = new TextField();
	TextField B3 = new TextField();
	
	TextField C1 = new TextField();
	TextField C2 = new TextField();
	TextField C3 = new TextField();
	
	TextField [] rows = {A1, A2, A3, B1, B2, B3, C1, C2, C3};
	*/
	TextField [] rows    = new TextField[9];
	Button       button  = new Button("Play Again");
	TextField [][] grid  = new TextField [N][N];
	Panel panel;
	int count            = 0;
	String p1            = "X";
	String p2            = "O";
	ActionListener [] A;
	ActionListener    B;

	
	public Logic(){
		
	}
	
	public void init(){
		setUpGui();
	}
	
	public void setUpGui(){
		this.setBackground(Color.red);
		setSize(230, 150);

		this.setName("Tic Tac Toe");
		//this.add(button);

		//game.addActionListener(B);
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				grid[i][j] = new TextField(5);
				add(grid[i][j]);
				grid[i][j].setBounds(10, 10, 50, 50);
				grid[i][j].addActionListener(this);
			}
		}
	}
		
	public void paint(Graphics g){
		g.setFont(new Font("default", Font.BOLD, 16));
		g.drawString("TIC TAC TOE", 60,  100);
	}
	
	/**
	 * displays TicTacToe game if game is to played as a LUI
	 */
	public void display(){
		System.out.printf("%s|%s|%s \n --|--|-- \n %s|%s|%s \n");
		
	/**	
	 * The grid should look like this
		System.out.printf("%s|%s|%s \n");
		System.out.printf("--|--|-- \n");
		System.out.printf("%s|%s|%s \n");
		System.out.printf("--|--|-- \n");
		System.out.printf("%s|%s|%s \n");
     */
			
	}
	
	public void run(){
			
	}
		
	
	/**
	 * a switch that toggles entered from false to true and vice versa
	 */
	public void toggle(){
		entered = false;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
			
	for(int i = 0; i < N; i++){
		for(int j = 0; j < N; j++){
			if(e.getSource().equals(grid[i][j])){
				grid[i][j].setText(grid[i][j].getText());
				grid[i][j].setBackground(Color.DARK_GRAY);
				grid[i][j].setEditable(false);
				}
			}
		}
	
	if(check() == true){
		endGame();
	}
	

	}
	
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
	for(int i = 0; i < N; i++){
		for(int j = 0; j< N; j++){	
			if(p1.compareTo(grid[i][j].getText()) == 0){
				if(grid[i][j].getText()!= null) count++;
					
			}	
		}
		if(count == 3) return true;
		count = 0;
	}
	
	count = 0;
	
	//check player 2's status
	for(int i = 0; i < N; i++){
		for(int j = 0; j< N; j++){	
			if(p2.compareTo(grid[i][j].getText()) == 0){
				if(grid[i][j].getText()!= null) count++;
					
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
		for(int i = 0; i < N; i++){
			for(int j = 0; j< N; j++){	
				if(p1.compareTo(grid[j][i].getText()) == 0){
					if(grid[j][i].getText()!= null) count++;
				}	
			}
			if(count == 3) return true;
			count = 0;
		}
		
		count = 0;
		
		//check player 2's status
		for(int i = 0; i < N; i++){
			for(int j = 0; j< N; j++){	
				if(p2.compareTo(grid[j][i].getText()) == 0){
					if(grid[j][i].getText()!= null) count++;
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
			for(int j = 0; j< N; j++){	
				if(p1.compareTo(grid[j][j].getText()) == 0){
					if(grid[j][j].getText()!= null) count++;
				}	
			
			if(count == 3 ) return true;
		}
			
			count = 0;

			//check player 2's status
			for(int j = 0; j< N; j++){	
				if(p2.compareTo(grid[j][j].getText()) == 0){
					if(grid[j][j].getText()!= null) count++;
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
		
		String a = grid[0][2].getText();
		String b = grid[1][1].getText();
		String c = grid[2][0].getText();
		
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
	
	/**
	 * If loss == true end the game by setting all TextField to "not editable". Change colors of the the field to grey
	 * to distinguish that the game is over
	 */
	public void endGame(){
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
			grid[i][j].setText(grid[i][j].getText());
			grid[i][j].setBackground(Color.DARK_GRAY);
			grid[i][j].setEditable(false);
			}
		}
	}
	
	/**
	 * compares one object preferably a String to another String. If Equal return 0, if not equal return 1, and if null return -1
	 */
	public int compareTo(Object o){
		return this.compareTo(o);
	}

}
