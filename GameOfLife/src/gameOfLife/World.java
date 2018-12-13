package gameOfLife;
public class World implements TileGrid
{
	private int rows;
	private int columns;
	private Tile[][]x;
	private ConstantTile tile;
			
	public World(int rows, int columns)
	{
		this.rows=rows;
		this.columns=columns;
		core.API.initialize(rows, columns);
		x= new Tile[rows][columns];
		for(int z=1;z<=rows;z++)
		{
			for(int y=1; y<=columns;y++)
			{
				x[z][y]=new ConstantTile(0);
			}
		}
		for(int z=1;z<=rows;z++)
		{
			for(int y=1; y<=columns;y++)
			{
				core.API.paintSolidColor(rows, columns, x[z][y].getColor());
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

