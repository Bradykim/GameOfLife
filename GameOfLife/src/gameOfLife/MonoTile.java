package gameOfLife;

import java.awt.Color;

public class MonoTile extends LifeTile
{
	public MonoTile(int initialAge)
	{
		super(initialAge);
	}
	public Color getColor()
	{
		Color r = null;
		if(getAge()==0)
		{
			r= Color.BLACK;
		}
		else
		{
			r= Color.WHITE;
		}
		return r;
	}
	public Tile getUpdatedTile(Tile[] neighbors)
	{
		int active= getNumActiveNeighbors(neighbors);
		if(getAge()>0)
		{
			if(active == 2 || active == 3)
			{
				return new MonoTile(getAge()+1);
			}
			else
			{
				return new MonoTile(0);
			}
		}else{
			if(active==3)
			{
				return new MonoTile (1);
			}
			
		}
		return new MonoTile(0);
	}
}
