package gameOfLife;
public class World
{
	private int rows;
	private int columns;
	private Tile[][]x;
	
	public World(int rows, int columns)
	{
		this.rows=rows;
		this.columns=columns;
		x= new Tile[rows][columns];
		core.API.initialize(rows, columns);
	}
	public Tile getTile(int rows,int columns)
	{
		Tile y= x[rows][columns];
		return y;
	}
	public void setTile()
	{
		
	}
	public void processCommand()
	{
		
	}
}

