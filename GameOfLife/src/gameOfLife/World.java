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
		core.API.initialize(rows+1, columns+1);
		x= new Tile[rows][columns];
		for(int z=0;z<rows;z++)
		{
			for(int y=0; y<columns;y++)
			{
				x[z][y]=new ConstantTile(0);
			}
		}
		for(int z=0;z<rows;z++)
		{
			for(int y=0; y<columns;y++)
			{
				core.API.paintSolidColor(rows, columns,x[z][y].getColor());
			}
		}
	}
	public Tile getTile(int rows,int columns)
	{
		Tile y= x[rows][columns];
		return y;
	}
	public void setTile(int row, int column, Tile tile)
	{
		
	}
	public void processCommand(String command)
	{
		
	}
}

