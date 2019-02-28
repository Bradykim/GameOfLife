package gameOfLife;

import java.awt.Color;

public class ImmigrationTile extends LifeTile
{
	private Color currentcolor;
	public ImmigrationTile(int initialAge)
	{
		super(initialAge);
	}
	public Color getColor()
	{
		Color r=null;
		if(getAge()==0)
		{
			r= Color.BLACK;
		}
		else if(getAge()==1)
		{
			r= Color.GREEN;
		}
		else if(getAge()==2)
		{
			r= Color.BLUE;
		}
		return r;
	}

	
	public Tile getUpdatedTile(Tile[] neighbors)
	{
		int active= getNumActiveNeighbors(neighbors);
		if(getAge()>0)
		{
			if(active==2||active==3)
			{
				return new ImmigrationTile(getAge()+1);
			}
			else
			{
				return new ImmigrationTile(0);
			}
		}
		else
		{
			if(active==3)
			{
				return new ImmigrationTile(1);
			}
			
		}
		return new ImmigrationTile(0);
	}
	
}
