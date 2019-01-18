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
	
	public abstract Tile getUpdatedTile(Tile [] neighbors);
	
	 public int getNumActiveNeighbors (Tile[] neighbors)
	 {
		 int active =0;
		 for (Tile tile : neighbors){
			 if(tile.getAge() > 0){
				 active++;
			 }
		 }
		 
		 return active;
		 
	 }
}
