package gameOfLife;

import java.awt.Color;

public abstract class LifeTile implements Tile
{
	private int ageTile;
	public LifeTile(int ageTile)
	{
		this.ageTile=ageTile;
	}
	public int getAge()
	{
		return this.ageTile;
	}
	
	public abstract Color getColor();
	
	public abstract Tile getUpdatedtile(Tile [] neighbors);
	
	 public int getNumActiveNeighbors (Tile[] neighbors)
	 {
		 int active =0;
		 int spaces= neighbors.length;
		 for(int x=0; x<spaces;x++)
		 {
			 if(neighbors[x].getAge()>0)
			 {
				 active++;
			 }
		 }
		 return active;
		 
	 }
}
