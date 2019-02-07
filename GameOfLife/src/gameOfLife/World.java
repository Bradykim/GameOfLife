package gameOfLife;
public class World implements TileGrid
{
	private int rows;
	private int columns;
	private Tile[][]x;

	public World(int rows, int columns)
	{
		this.rows=rows;
		this.columns=columns;
		core.API.initialize(rows, columns);
		x= new Tile[rows][columns];
		for(int z=0;z<rows;z++)
		{
			for(int y=0; y<columns;y++)
			{
				x[z][y]=new ConstantTile(0);
			}
		}
		redraw(rows,columns,x);
	}
	public Tile getTile(int rows,int columns)
	{
		Tile y= x[rows][columns];
		return y;
	}
	public void setTile(int row, int column, Tile tile)
	{
		x[row][column]= tile;
		redraw(rows,columns,x);

	}

	public void processCommand(String command)
	{
		String []s= command.split(" ");
		String f= s[0];
		while(f.equals("setCopycats"))
		{
			String pattern= s[1];
			if(pattern.equals("mirror"))
			{
				Tile[][] z = new Tile [rows][columns];
				for(int r=0;r<x.length;r++)
				{
					for(int c=x[0].length/2; c<x[0].length;c++)
					{
						if(x[r][c] != null)
						{
							z[r][columns-1-c]= new CopycatTile(r,c,this);
						}
					}
				}
				x = z;
				redraw(rows, columns, x);
						
			}
		}
		if(f.equals("fill"))
		{
			String t= s[1];
			String num=s[2];
			int num2= Integer.parseInt(num);
			if(t.equals("rainbow"))
			{
				for(int i=0;i<rows;i++)
				{
					for(int j=0; j<columns;j++)
					{
						x[i][j]= new RainbowTile(num2);
						core.API.paintSolidColor(i, j,x[i][j].getColor());
					}
				}
			}
			if(t.equals("constant"))
			{
				for(int i=0;i<rows;i++)
				{
					for(int j=0; j<columns;j++)
					{
						x[i][j]= new ConstantTile(num2);
						core.API.paintSolidColor(i, j,x[i][j].getColor());
					}
				}
			}
			if(t.equals("mono"))
			{
				for(int i=0;i<rows;i++)
				{
					for(int j=0; j<columns;j++)
					{
						x[i][j]= new MonoTile(num2);
						core.API.paintSolidColor(i, j,x[i][j].getColor());
					}
				}
			}
		}
		if(f.equals("set"))
		{
			String type= s[1];
			String age=s[2];
			int age2= Integer.parseInt(age);
			String r=s[3];
			int r2= Integer.parseInt(r);
			String c=s[4];
			int c2= Integer.parseInt(c);
			if(type.equals("rainbow"))
			{
				RainbowTile y= new RainbowTile(age2);
				this.x[r2][c2]= y;
				redraw(r2,c2,x);

			}
			if(type.equals("constant"))
			{
				ConstantTile y= new ConstantTile(age2);
				x[r2][c2]= y;
				redraw(r2,c2,x);
			}
			if(type.equals("mono"))
			{
				MonoTile y= new MonoTile(age2);
				x[r2][c2]= y;
				redraw(r2,c2,x);
			}
		}
		if (f.equals("evolve"))
		{
			
			String pause= s[2];
			int pauseMs= Integer.parseInt(pause);
			String steps1= s[1];
			int steps= Integer.parseInt(steps1);
			for(int i=0; i<steps;i++)
			{

				Tile[][] y = new Tile [rows][columns];
				for(int r=0;r<x.length;r++)
				{
					for(int c=0; c<x[0].length;c++)
					{
						Tile[] z = new Tile[8];
						int UpOne= (r-1)%rows;
						int DownOne= (r+1)%rows;
						int RightOne=(c+1)%columns;
						int LeftOne= (c-1)%columns;
						
						if(UpOne < 0)
						{
							UpOne = rows-1;
						}
						if (LeftOne < 0)
						{
							LeftOne = columns-1;
						}
						
						//Code for Tile right above
						z[0]= x[UpOne][c];
						
						//Code for tile to the Right
						z[1]= x[r][RightOne];
						
						//Code for Tile right below
						z[2]= x[DownOne][c];
						
						//Code for Tile to the left
						z[3]= x[r][LeftOne];
						
						//code for Tile to the Upper left
						z[4]= x[UpOne][LeftOne];
						
						//Code for tile to the upper right
						z[5]= x[UpOne][RightOne];
						
						//code for tile to the bottom right
						z[6]= x[DownOne][RightOne];
						
						//code for tile to the bottom left
						z[7]= x[DownOne][LeftOne];
						
						y[r][c]= x[r][c].getUpdatedTile(z);
						 
					}
				}
				x = y;
				redraw(rows, columns, x);
				core.API.pause(pauseMs);
			}
			
			
		}
		
		if(f.equals("setShape"))
		{
			String shape = s[1];
			String row1= s[2];
			int row= Integer.parseInt(row1);
			String column1= s[3];
			int col= Integer.parseInt(column1);
			if(shape.equals("glider"))
			{
				MonoTile g= new MonoTile(1);
				x[row][col+1]= g;
				
				MonoTile g1= new MonoTile(1);
				x[row+1][col+2]= g1;
				
				MonoTile g2= new MonoTile(1);
				x[row+2][col]= g2;
				
				MonoTile g3= new MonoTile(1);
				x[row+2][col+1]=g3;
				
				MonoTile g4= new MonoTile(1);
				x[row+2][col+2]= g4;
				
				
			}
			if(shape.equals("oscillator"))
			{
				MonoTile o= new MonoTile(1);
				x[row][col]= o;
				MonoTile o1= new MonoTile(1);
				x[row][col+1]= o1;
				MonoTile o2= new MonoTile(1);
				x[row][col+2]= o2;
				redraw(rows,columns,x);
				
			}
		}
		

	}
	public void redraw(int rows, int columns,Tile[][]y)
	{
		for(int i=0;i<y.length;i++)
		{
			for(int j=0; j<y[0].length;j++)
			{
				core.API.paintSolidColor(i, j,y[i][j].getColor());
			}
		}
	}

}
