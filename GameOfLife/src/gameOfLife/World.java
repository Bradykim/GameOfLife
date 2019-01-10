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
						redraw(rows,columns,x);
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
						redraw(rows,columns,x);
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
		}
		if (f.equals("evolve"))
		{
			Tile[][] y = new Tile [rows][columns];
			for(int i=0;i<rows;i++)
			{
				for(int j=0; j<columns;j++)
				{
					Tile hi = x[i][j].getUpdatedTile(null);
					y[i][j] = hi;
				}
			}
			x=y;
			redraw(rows,columns,x);
			
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

