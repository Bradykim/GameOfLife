package gameOfLife;

import java.awt.Color;

public class CopycatTile implements Tile
{
	private int row;
	private int column;
	private World x;
	public CopycatTile(int row, int column, World x)
	{
		this.row=row;
		this.column=column;
		this.x=x;
		
	}
	
	public int getAge()
	{
		return x.getTile(row, column).getAge();
	}
	
	public Color getColor()
	{
		return x.getTile(row, column).getColor();
	}
	
	public Tile getUpdatedTile(Tile[] neighbors)
	{
		Tile til= x.getTile(row, column);
		Tile ti= til;
		return ti;
	}


}
