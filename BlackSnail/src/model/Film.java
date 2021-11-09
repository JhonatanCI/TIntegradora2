package model;

public class Film extends Product{

	private String realName;
	private String productor;
	private int age;
	private TypeFilm typeFilm;

	public Film(String name,Date date, String directorName, String sinapsis,String realName, String productor, TypeFilm typeFilm,int age){
		super( name, date,  directorName,  sinapsis);
		this.realName = realName;
		this.productor = productor;
		this.typeFilm = typeFilm;
		this.age=age;
	}
	public String getRealName(){
		return realName;
	}
	public void setRealName(String realName){
		this.realName=realName;
	}
	public String getProductor(){
		return productor;
	}
	public void setProductor(String productor){
		this.productor=productor;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age=age;
	}
	public TypeFilm getTypeFilm(){
		return typeFilm;
	}
	public void setTypeFilm(TypeFilm typeFilm){
		this.typeFilm=typeFilm;
	}
	public String toString(){
		String out = name+"\n"+
		"Nombre real : "+realName+"\n"+
		"Se estreno en : "+date+"\n"+
		"Director : "+directorName+"\n"+
		"Sinapsis : "+sinapsis+"\n"+
		"Productor : "+productor+"\n"+
		"Tipo de pelicula : "+typeFilm+"\n"+
		"Edad minima : "+age+"\n";

		return out;
	}
}