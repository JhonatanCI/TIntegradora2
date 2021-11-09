package model;

public abstract class Product{
	protected String name;
	protected Date date;
	protected String directorName;
	protected String sinapsis;
	

	public Product(String name,Date date, String directorName, String sinapsis){
		this.name=name;
		this.date = date;
		this.directorName = directorName;
		this.sinapsis = sinapsis;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public Date getDate(){
		return date;
	}
	public void setDate(Date date){
		this.date = date;
	}
	public String getDirectorName(){
		return directorName;
	}
	public void setDirectorName(String directorName){
		this.directorName = directorName;
	}
	public String getSinapsis(){
		return sinapsis;
	}
	public void setAge(String sinapsis){
		this.sinapsis = sinapsis;
	}
}