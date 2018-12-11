package gameOfLife;

import java.awt.Color;

public class ConstantTile implements Tile
{
	private int ageTile;
	public ConstantTile(int ageTile)
	{
		this.ageTile=ageTile;
	}
	public int getAge()
	{
		return this.ageTile;
	}
	public Color getColor()
	{
		Color r;
		if(ageTile==0)
		{
			r= Color.DARK_GRAY;
		}
		else
		{
			r= Color.LIGHT_GRAY;
		}
		return r;
	}
	public Tile getUpdatedTile(Tile[] neighbors)
	{
		ConstantTile  x= new ConstantTile(getAge());
		return x;
	}
}
