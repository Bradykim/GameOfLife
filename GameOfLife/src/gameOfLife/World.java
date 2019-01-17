package gameOfLife;
public class World implements TileGrid
{
	private int rows;
	private int columns;
	private Tile[][]x;
	private Tile[][]temp;

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
			// Loop -> all the tiles in a new grid
			
			// In loop
				// Call get ns
				// Put the value in to get update tilke
				// Put that tile in to the place of the array
			
			//Outside of loop
			//Draw
			String pause= s[2];
			int pauseMs= Integer.parseInt(pause);
			String steps1= s[1];
			int steps= Integer.parseInt(steps1);
			Tile[][] y = new Tile [rows][columns];
			for(int i=0;i<rows;i++)
			{
				for(int j=0; j<columns;j++)
				{
					Tile[] z = new Tile[8];
					int UpOne= (j+1)%columns;
					if((j+1)>(columns-1))
					{
						UpOne= (j+1)-columns;
					}
					int DownOne= (j-1)%columns;
					if((j-1)<0)
					{
						DownOne= (j-1)+columns;
					}
					int RightOne= (i+1)%rows;
					if((i+1)>(columns-1))
					{
						RightOne=(i+1)-rows;
					}
					int LeftOne= (i-1)%rows;
					if((i-1)<0)
					{
						LeftOne= (i-1)+rows;
					}
					
					//Code for Tile right above
					z[0]= y[i][UpOne];
					
					//Code for tile to the Right
					z[1]= y[RightOne][j];
					
					//Code for Tile right below
					z[2]= y[i][DownOne];
					
					//Code for Tile to the left
					z[3]= y[LeftOne][j];
					
					//code for Tile to the Upper left
					z[4]= y[LeftOne][UpOne];
					
					//Code for tile to the upper right
					z[5]= y[RightOne][UpOne];
					
					//code for tile to the bottom right
					z[6]= y[RightOne][DownOne];
					
					//code for tile to the bottom left
					z[7]= y[LeftOne][DownOne];
					
						for(int o=0; o<z.length;o++)
						{
							System.out.println(z[o]);
						}
						System.out.println("/n");
						
					Tile hi = x[i][j].getUpdatedTile(z);
					y[i][j] = hi;
				}
			}
			x = y;
			redraw(rows, columns, x);
			core.API.pause(pauseMs);
		}

	}
	public void redraw(int rows, int columns,Tile[][]y)
	{
		for(int i=0;i<rows;i++)
		{
			for(int j=0; j<columns;j++)
			{
				core.API.paintSolidColor(i, j,y[i][j].getColor());
			}
		}
	}

}
