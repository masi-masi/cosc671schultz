package edu.ncsu.monopoly;

public interface IOwnable {

	public abstract Player getTheOwner();

	public abstract void setTheOwner(Player owner);

}