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
		else if(initialAge==1)
		{
			currentcolor= Color.GREEN;
		}
		else if(initialAge==2)
		{
			currentcolor= Color.BLUE;
		}
	}
	public ImmigrationTile(int initialAge,Color c)
	{
		super(initialAge);
		currentcolor=c;
	}
	public Color getColor()
	{
		Color c=null;
		if(super.getAge()==0)
		{
			c= Color.BLACK;
		}
		else if(super.getAge()==1)
		{
			c= Color.GREEN;
		}
		else if(super.getAge()==2)
		{
			c= Color.BLUE;
		}
		return c;
	}


	
	public Tile getUpdatedTile(Tile[] neighbors)
	{
		int active= getNumActiveNeighbors(neighbors);
		Color curcolor= currentcolor;
		if(getAge()>0)
		{
			if(active==2||active==3)
			{
				return new ImmigrationTile(getAge()+1,curcolor);
			}
			else
			{
				curcolor= Color.BLACK;
				return new ImmigrationTile(0,curcolor);
			}
		}
		else
		{
			if(active==3)
			{
				return new ImmigrationTile(1);
			}
			
		}
		curcolor=Color.BLACK;
		return new ImmigrationTile(0,curcolor);
	}
	
}
