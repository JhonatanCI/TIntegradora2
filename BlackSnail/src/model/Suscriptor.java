package model;

public class Suscriptor{
	private String id;
	private	String name;
	private	int age;
	private	int hours;
	private	State state;
	private	Type type;

	public Suscriptor(String id, String name, int age, int hours, int state, int type){
		 this.id=id;
		 this.name=name;
		 this.age= age;  
		 this.hours=hours;
		 switch (state) {
		  	case 1:
		  	this.state=State.ACTIVE;
		  	break;
		  	case 2:
		  	this.state=State.DISABLE;
		  	break;
		  }
		  switch (type) {
		  	case 1:
		  	this.type=Type.NORMAL;
		  	break;
		  	case 2:
		  	this.type=Type.PLATINO;
		  	break;
		  	case 3:
		  	this.type=Type.ORO;
		  	break;
		  	case 4:
		  	this.type=Type.DIAMANTE;
		  	break;
		  } 
	}
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	public int getHours(){
		return hours;
	}
	public void setHours(int hours){
		this.hours = hours;
	}
	public State getState(){
		return state;
	}
	public void setState(State state){
		this.state = state;
	}
	public Type getType(){
		return type;
	}
	public void setType(Type type){
		this.type = type;
	}
	
}