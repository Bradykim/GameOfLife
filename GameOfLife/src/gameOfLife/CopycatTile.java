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
		Tile til= x.getTile(row, column);
		int age= til.getAge();
		return age;
	}
	
	public Color getColor()
	{
		Tile til= x.getTile(row, column);
		Color c= til.getColor();
		return c;
	}
	
	public Tile getUpdatedTile(Tile[] neighbors)
	{
		Tile til= x.getTile(row, column);
		Tile ti= til;
		return ti;
	}


}
