package controller;

public abstract class HasValidTimeController extends ParentController{
	public abstract boolean checkTimeValidity();
	public abstract void getInStation(String stselect);
	public abstract void getOutStation(String stselect);
}
