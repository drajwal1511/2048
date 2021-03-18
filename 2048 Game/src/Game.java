import java.awt.*; //to setLayout,Grid
import javax.swing.*;  //to Use JFrame
import java.awt.event.*;//to use actionEvent,actionListener

public class Game implements ActionListener{
	public static int matrix[][]=new int[4][4];
	public static int numbers[]=new int[3];
	public static int count,i,j,max,framex,framey,width=400,height=400;
	JFrame f=new JFrame("WELCOME TO 2048");
	Game()
	{
		count=0;
		for (i=0;i<4;i++)
		{
			for(j=0;j<4;j++)
			{
				matrix[i][j]=0;
			}
		}
		max=0;
		JButton b1=new JButton("Start");
		JButton b2=new JButton("Exit");
		f.add(b1);
		f.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b1.setFont(new Font("Serif",Font.ITALIC,30));
		b1.setBackground(Color.GREEN);
		b2.setFont(new Font("Serif",Font.ITALIC,30));
		b2.setBackground(Color.red);
		f.setLayout(new GridLayout(4,4));
		f.setResizable(true);
		f.setSize(400,400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	Game(int a)
	{
		f.setTitle("Menu");
		JButton b1=new JButton("How to play");
		JButton b3=new JButton("Continue");
		f.add(b1);
		f.add(b3);
		b1.addActionListener(this);
		b3.addActionListener(this);
		f.setLayout(new GridLayout(4,4));
		b1.setFont(new Font("Serif",Font.ITALIC,30));
		b1.setBackground(Color.orange);
		b3.setFont(new Font("Serif",Font.ITALIC,30));
		b3.setBackground(Color.green);
		f.setBounds(framex, framey, width, height);
		f.setResizable(true);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	Game(int a,int b,int c)
	{
		f.setTitle("How To Play");
		JButton b1=new JButton("<html>1.Start with an initial board. The game will give you an initial 4x4 board, totaling 16 tiles. Two tiles will be placed at random positions on the board.</html>");
		JButton b2=new JButton("<html>2.Move tiles. Swipe up, down, left, and right to move the tiles across the board. The tiles will slide towards the other end, as long as there’s available space.</html>");
		JButton b3=new JButton("<html>3.Merge tiles. When tiles of the same number touch during a move, they will combine into one tile carrying sum of the two tiles.</html>");
		JButton b4=new JButton("<html>4.Get additional tile. On every move, whether you were able to merge 2 tiles or not, a new tile  will randomly appear on the board. This is how you get new tiles and numbers in play. </html>");
		JButton b5=new JButton("<html>5.Continue merging tiles. Continue moving the tiles across the board to increase the numbers on the tiles. The objective is to reach get a 2048 tile on the board.</html>");
		JButton b6=new JButton("<html>6.Finish the game. The game ends when the board is completely filled with numbered tiles and there’s no move available.</html>");
		JButton b7=new JButton("Back");
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		f.add(b7);
		b7.addActionListener(this);
		b1.setBackground(Color.DARK_GRAY);
		b2.setBackground(Color.DARK_GRAY);
		b3.setBackground(Color.DARK_GRAY);
		b4.setBackground(Color.DARK_GRAY);
		b5.setBackground(Color.DARK_GRAY);
		b6.setBackground(Color.DARK_GRAY);
		b1.setForeground(Color.white);
		b2.setForeground(Color.white);
		b3.setForeground(Color.white);
		b4.setForeground(Color.white);
		b5.setForeground(Color.white);
		b6.setForeground(Color.white);
		f.setLayout(new GridLayout(7,1));
		f.setResizable(true);
		f.setBounds(framex, framey, width, height);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	Game(String s)
	{
		for(i=0;i<4;i++)
		{
			for(j=0;j<4;j++)
			{
				if(matrix[i][j]>max)
					max=matrix[i][j];
			}
		}
		JButton b[]=new JButton[20];
		int index1,index2,num1,num2;
		int pos1[]=new int[2];
		int pos2[]=new int[2] ;
		numbers[0]=2;
		numbers[1]=4;
		numbers[2]=8;
		index1=(int)(Math.random()*(3))-0;				
		num1=numbers[index1];							
		do {
			pos1[0]=(int)(Math.random()*(4))-0;
			pos1[1]=(int)(Math.random()*(4))-0;
		}while(matrix[pos1[0]][pos1[1]]!=0);
		matrix[pos1[0]][pos1[1]]=num1;
		if(count==0)
		{
			index2=(int)(Math.random()*(3))-0;
			num2=numbers[index2];
			do
			{
				pos2[0]=(int)(Math.random()*(4))-0;
				pos2[1]=(int)(Math.random()*(4))-0;
			}while(matrix[pos2[0]] [pos2[1]]!=0 && (pos2[0]!=pos1[0]&&pos1[1]!=pos2[1]));
			matrix[pos2[0]][pos2[1]]=num2;
			count++;
		}	
		f.setTitle("2048 Maximum="+String.valueOf(max));
		for(i=0;i<4;i++)
		{
			for(j=0;j<4;j++)
			{
				s=String.valueOf(matrix[i][j]);
				b[(4*i)+j]=new JButton(s);
			}
		}
		b[16]=new JButton("LEFT");
		b[17]=new JButton("RIGHT");
		b[18]=new JButton("DOWN");
		b[19]=new JButton("UP");
		f.add(b[16]);
		f.add(b[17]);
		f.add(b[18]);
		f.add(b[19]);	
		for(i=0;i<16;i++)
		{
			f.add(b[i]);
			b[i].setFont(new Font("Serif",Font.BOLD,18));
			b[i].setBackground(Color.DARK_GRAY);
			b[i].setForeground(Color.white);
		}	
		b[16].addActionListener(this);
		b[17].addActionListener(this);
		b[18].addActionListener(this);
		b[19].addActionListener(this);
		f.setLayout(new GridLayout(5,4));
		f.setResizable(true);
		f.setBounds(framex, framey, width, height);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void rotate(int arr[][])
	{
		int i,j;
		int temp[][]=new int[4][4];
		temp[0][0]=arr[3][0];
		temp[0][1]=arr[2][0];
		temp[0][2]=arr[1][0];
		temp[0][3]=arr[0][0];
		
		temp[1][0]=arr[3][1];
		temp[1][1]=arr[2][1];
		temp[1][2]=arr[1][1];
		temp[1][3]=arr[0][1];
		
		temp[2][0]=arr[3][2];
		temp[2][1]=arr[2][2];
		temp[2][2]=arr[1][2];
		temp[2][3]=arr[0][2];
		
		temp[3][0]=arr[3][3];
		temp[3][1]=arr[2][3];
		temp[3][2]=arr[1][3];
		temp[3][3]=arr[0][3];
		
		for(i=0;i<4;i++)
			for(j=0;j<4;j++)
				arr[i][j]=temp[i][j];
	}
	public static void leftshift(int matrix[][])
	{
		int i;
		//column[1]
		for(i=0;i<4;i++)
		{
		if(matrix[i][1]!=0)
		{
			if(matrix[i][0]==matrix[i][1])
			{
				matrix[i][0]*=2;
				matrix[i][1]=0;
			}
			if(matrix[i][0]==0)
			{
				matrix[i][0]=matrix[i][1];
				matrix[i][1]=0;
			}
		}	
		}		
		//column[2]		
		for(i=0;i<4;i++)
		{
			if(matrix[i][2]!=0)
			{
				if(matrix[i][1]==matrix[i][2])
				{
					matrix[i][1]*=2;
					matrix[i][2]=0;
				}
				if(matrix[i][1]==0)
				{
					if(matrix[i][0]==0)
					{
						matrix[i][0]=matrix[i][2];
						matrix[i][2]=0;
					}
					else
					{
						if(matrix[i][2]==matrix[i][0])
						{
							matrix[i][0]*=2;
							matrix[i][2]=0;
						}
						else
						{
							matrix[i][1]=matrix[i][2];
							matrix[i][2]=0;
						}
					}
				}
			}
		}
		//column 3
		for(i=0;i<4;i++)
		{
			if(matrix[i][3]!=0)
			{
				if(matrix[i][2]==matrix[i][3])
				{
					matrix[i][2]*=2;
					matrix[i][3]=0;
				}
				if(matrix[i][2]==0)
				{
					if(matrix[i][1]==0)
					{
						if(matrix[i][0]==0)
						{
							matrix[i][0]=matrix[i][3];
							matrix[i][3]=0;
						}
						else 
						{
							if(matrix[i][0]==matrix[i][3])
							{
								matrix[i][0]*=2;
								matrix[i][3]=0;
							}
							else
							{
								matrix[i][1]=matrix[i][3];
								matrix[i][3]=0;
							}
						}
					}
					else 
					{
						if(matrix[i][1]==matrix[i][3])
						{
						matrix[i][1]*=2;
						matrix[i][3]=0;
						}
						else
						{
							matrix[i][2]=matrix[i][3];
							matrix[i][3]=0;
						}
					}
				}
			}
		}
	}
	public static void main(String args[]) {
		new Game();	
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("Start"))
		{
			framex=f.getX();
			framey=f.getY();
			width=f.getWidth();
			height=f.getHeight();
			f.dispose();
			new Game(5);
		}
		if(ae.getActionCommand().equals("Exit"))
		{
			framex=f.getX();
			framey=f.getY();
			width=f.getWidth();
			height=f.getHeight();
			f.dispose();
			System.exit(0);
		}
		if(ae.getActionCommand().equals("How to play"))
		{
			framex=f.getX();
			framey=f.getY();
			width=f.getWidth();
			height=f.getHeight();
			f.dispose();
			new Game(5,5,5);
		}
		if(ae.getActionCommand().equals("Continue"))
		{
			framex=f.getX();
			framey=f.getY();
			width=f.getWidth();
			height=f.getHeight();
			f.dispose();
			new Game("sad");
		}
		if(ae.getActionCommand().equals("Back"))
		{
			framex=f.getX();
			framey=f.getY();
			width=f.getWidth();
			height=f.getHeight();
			f.dispose();
			new Game(5);
		}
		if(ae.getActionCommand().equals("LEFT"))
		{
			framex=f.getX();
			framey=f.getY();
			width=f.getWidth();
			height=f.getHeight();
			f.dispose();
			leftshift(matrix);
			new Game("s");
		}
		if(ae.getActionCommand().equals("RIGHT"))
		{
			framex=f.getX();
			framey=f.getY();
			width=f.getWidth();
			height=f.getHeight();
			f.dispose();
			rotate(matrix);
			rotate(matrix);
			leftshift(matrix);
			rotate(matrix);
			rotate(matrix);
			new Game("s");
		}
		if(ae.getActionCommand().equals("UP"))
		{
			framex=f.getX();
			framey=f.getY();
			width=f.getWidth();
			height=f.getHeight();
			f.dispose();
			rotate(matrix);
			rotate(matrix);
			rotate(matrix);
			leftshift(matrix);
			rotate(matrix);
			new Game("s");
		}
		if(ae.getActionCommand().equals("DOWN"))
		{
			framex=f.getX();
			framey=f.getY();
			width=f.getWidth();
			height=f.getHeight();
			f.dispose();
			rotate(matrix);
			leftshift(matrix);
			rotate(matrix);
			rotate(matrix);
			rotate(matrix);
			new Game("s");
		}	
}
}

