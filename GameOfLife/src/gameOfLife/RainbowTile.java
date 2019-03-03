package gameOfLife;

import java.awt.Color;

public class RainbowTile implements Tile
{
	private int ageTile;
	public RainbowTile(int ageTile)
	{
		this.ageTile=ageTile;
	}
	public int getAge()
	{
		return this.ageTile;
	}
	public Color getColor()
	{
		Color c= Color.RED;
		if(ageTile%6==0)
		{
			c=Color.RED;
		}
		else if(ageTile%6==1)
		{
			c=Color.ORANGE;
		}
		else if(ageTile%6==2)
		{
			c=Color.YELLOW;
		}
		else if(ageTile%6==3)
		{
			c=Color.GREEN;
		}
		else if(ageTile%6==4)
		{
			c=Color.BLUE;
		}
		else if(ageTile%6==5)
		{
			c=Color.MAGENTA;
		}
		return c;
	}
	public Tile getUpdatedTile(Tile[] neighbors)
	{
		RainbowTile  x= new RainbowTile(getAge()+1);
		return x;
	}
}
