package gameOfLife;

import java.awt.Color;

public class CopycatTile implements Tile
{
	private int row;
	private int column;
	private World x;
	private Tile t;
	public CopycatTile(int row, int column, World x)
	{
		this.row=row;
		this.column=column;
		this.x=x;
		t= x.getTile(row, column);
	}
	
	public int getAge()
	{
		int age= t.getAge();
		return age;
	}
	
	public Color getColor()
	{
		Color c= t.getColor();
		return c;
	}
	
	public Tile getUpdatedTile(Tile[] neighbors)
	{
		Tile ti= t;
		return ti;
	}


}
