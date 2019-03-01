package gameOfLife;

import java.awt.Color;

public class ImmigrationTile extends LifeTile
{
	private Color currentcolor;
	public ImmigrationTile(int initialAge)
	{
		super(initialAge);
		if(initialAge==0)
		{
			currentcolor= Color.BLACK;
		}
		else if(getAge()==1)
		{
			currentcolor= Color.GREEN;
		}
		else if(getAge()==2)
		{
			currentcolor= Color.BLUE;
		}
	}
	public ImmigrationTile(int initialAge,Color c)
	{
		super(initialAge);
		currentcolor=c;
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
