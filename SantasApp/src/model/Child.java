package model;

public class Child implements Comparable<Child>{

	private String name;
	private String lastName;
	private int age;
	private String direction;
	private String country;
	private String wish;
	private List status;

	public Child(String name, String lastName, int age, String direction, String country, String wish){
		this.name = name;
		this.lastName = lastName;
		this.direction = direction;
		this.age = age;
		this.country = country;
		this.wish = wish;
		this.status = List.GOODCHILD;
	}
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge(){
		return age;
	}

	public void setAge(int age){
		this.age = age;
	}

	public String getDirection() {
		return this.direction;
	}


	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getWish() {
		return wish;

	}
	public void setWish(String wish) {
		this.wish = wish;
	}

	public List getStatus(){
		return status;
	}

	public void setStatus(List status) {
		this.status = status;
	}
	
	
	/**
	@param other, Child
	@return out, int es menor que cero cuando other es menor
	cero si es igual y `mayor a 0 si es mayor
	*/
	@Override
	public int compareTo(Child other){
		int out;
		if (this.age>other.getAge()) {
			out = -1;
		}else if (this.age<other.getAge()) {
			out = 1;
		}else{
			out = 0;
		}

		return out;
	}
	public String toString(){
		String status;
		String out = "Nombre : "+name+"\n"+
		"Apellido : "+lastName+"\n"+
		"Direccion : "+direction+"\n"+
		"Edad : "+age+"\n"+
		"Pais : "+country+"\n"+
		"Deseo : "+wish+"\n";
		if (this.status == List.GOODCHILD) {
			status = "Lista de los chicos buenos";
		}else{
			status = "Lista de los chicos malos";
		}
		out+="Lista: "+status+"\n"+"\n";

		return out; 
	}
}