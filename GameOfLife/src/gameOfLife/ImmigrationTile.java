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
		this.currentcolor=c;
	}
	public Color getColor()
	{
		return currentcolor;
	}


	
	public Tile getUpdatedTile(Tile[] neighbors)
	{
		int active= getNumActiveNeighbors(neighbors);
		int totalblue=0;
		int totalgreen=0;
		for(int i= 0; i<neighbors.length;i++)
		{
			int age=  neighbors[i].getAge();
			Color c= neighbors[i].getColor();
			if(c == Color.BLUE)
			{
				totalblue++;
			}
			else if(c== Color.GREEN)
			{
				totalgreen++;
			}
		}
		if(getAge()>0)
		{
			if(active==2||active==3)
			{
				return new ImmigrationTile(getAge()+1,currentcolor);
			}
			else
			{
				return new ImmigrationTile(0,Color.BLACK);
			}
		}
		else
		{
			if(active==3 && totalgreen>totalblue)
			{
				return new ImmigrationTile(1,Color.GREEN);
			}
			else if(active==3 && totalblue>totalgreen)
			{
				return new ImmigrationTile(1,Color.BLUE);
			}
			
				
		}
		return new ImmigrationTile(0,Color.BLACK);
		
		
	}
	
}
