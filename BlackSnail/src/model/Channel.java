package model;

public class Channel{
	// arreglo de suscriptores
	private Suscriptor []suscriptors;
	//arrego de producots
	private Product [] products = new Product[85];
	//direccion
	private String direction;
	//website
	private String website;


	public Channel(String direction, String website){
		//definimos un limite para los suscriptores
		suscriptors= new Suscriptor[50];
		this.direction=direction;
		this.website=website;
	}

	/**
	 * Metodo donde verificamos un espacio vacio en el arreglo de suscriptores para luego
	 * guardar el suscriptor con los datos ingresados anteriormente por el usuario
	 * @param id, String el id unico para el suscriptor
	 * @param name, String el nombre para el suscriptor
	 * @param age, int es la edad del suscriptor
     * @param hours, int Cantidad de horas dispuestas a consumir
     * @param state, int el estado activo o inactivo (es int porque posteriormente se convertira en State)
     * @param type,	int el tipo (es int porque posteriormente se convertira en Type)
	 */
	public void createSus(String id, String name, int age, int hours, int state, int type){
		boolean finish = false; /* variable bandera que nos permitira terminar la repetitiva cuando 
		hallemos un espacio donde guardar */
		for (int i=0;i<suscriptors.length && !finish ;i++ ){
			if (suscriptors[i]==null) {
				suscriptors[i]= new Suscriptor(id,name,age,hours,state,type);
				finish= true;
			}
		}
	}

	/**
	 * Metodo que se encarga de validar si el id esta ya registrado
	 * @param id, String es el id que el usuario registro en el metodo addSuscript
	  * @return out, boolean es la respuesta a si el id existe o no ya
	 */
	public boolean verifyId(String id){
		boolean out = true;
		boolean finish = false;
		for (int i=0;i<suscriptors.length&&!finish ;i++){
			if (suscriptors[i]!=null){
				if ( (suscriptors[i].getId()).equals(id) ) {
					out = false;
					finish= true;
				}
			}
		}
		return out;
	}
	/**
	 * Metodo que se encarga de verificar si no se pueden crear mas suscriptores 
	 *por falta de espacio en el arreglo
	 * @return out, boolean es la respuesta a si se llego al limite de suscriptores
	 */
	public boolean verifyLimit(){
		boolean out = false;
		int i = 0;
		do{
			if (suscriptors[i]==null) {
				out=true;
			}
			i++;
		}while(out==false && i<suscriptors.length);
		return out;
	}

	/**
	 * Metodo que se encarga de verificar si hay uno o mas de un suscriptores creado
	 * @return out, boolean es la respuesta a si hay uno o mas suscriptores
	 */
	public boolean verifyOneOrMoreSus(){
		boolean out = false;
		int i = 0;
		do{
			if (suscriptors[i]!=null) {
				out=true;
			}else{
				i++;
			}
		}while(out==false && i<suscriptors.length);

		return out;
	}

	/**
	 * Metodo que se encarga de mostrar la lista de la cantidad de suscriptores por tipo
	 */
	public void menu(){
		
		for (int i=1;i<suscriptors.length ;i++) {
			if (suscriptors[i-1]!=null) {
				System.out.println("("+i+")"+suscriptors[i-1].getName()+" Estado: "+suscriptors[i-1].getState()+"\n");
			}
		}System.out.println("(0) Para volver");
		
	}

	/**
	 * Metodo que se encarga de cambiar de activo a descativado y de desactivado a activado,
	 * tambien si se desactiva el tipo cambia automaticamente a Normal
	 */
	public void setActiveOrInactive(int option){
		if (option!=0) {
			if (suscriptors[option-1]!=null) {
				if (suscriptors[option-1].getState()==State.ACTIVE) {
					suscriptors[option-1].setState(State.DISABLE);
				}else{
					suscriptors[option-1].setState(State.ACTIVE);
					suscriptors[option-1].setType(Type.NORMAL);
				}
				System.out.println("Se han guardado los cambios al suscriptor");
			}else{
				System.out.println("El suscriptor no esta definido");
			}
		}
	}

	/**
	 * Metodo que se encarga de calcular la cantidad de suscriptores por tipo activos
	 */
	public void showSuscribers(){
		int normales = 0;
		int platinos = 0;
		int oros = 0;
		int diamantes = 0;
		for (int i=1;i<suscriptors.length ;i++) {
			if (suscriptors[i-1]!=null) {
				if (suscriptors[i-1].getState()==State.ACTIVE && suscriptors[i-1].getType()==Type.NORMAL) {
					normales++;
				}
				else if (suscriptors[i-1].getState()==State.ACTIVE && suscriptors[i-1].getType()==Type.PLATINO) {
					platinos++;
				}
				else if (suscriptors[i-1].getState()==State.ACTIVE && suscriptors[i-1].getType()==Type.ORO) {
					oros++;
				}else if (suscriptors[i-1].getState()==State.ACTIVE && suscriptors[i-1].getType()==Type.DIAMANTE){
					diamantes++;
				}	
			}
		}

		System.out.println(toString( normales ,  platinos ,  oros ,  diamantes));
	}

	/**
	 * Metodo que se encarga de mostrar la cantidad de suscriptores por tipo activos
	 * @return out, String es la cadena que mostrara el programa como respuesta a la lista de suscriptores
	 * de cada tipo
	 */
	public String toString(int normales , int platinos , int oros , int diamantes ){
		int total = normales+ platinos+oros+diamantes;
		String out = "La cantidad de suscriptores activos son: "+total+", distribuidos de la siguiente manera:"+"\n";
		if (normales!=0) {
				out+= "NORMAL: "+normales+"\n";
			}
			if (platinos!=0) {
				out+= "PLATINO: "+platinos+"\n";
			}
			if (oros!=0) {
				out+= "ORO: "+oros+"\n";
			}
			if (diamantes!=0) {
				out+= "DIAMANTE: "+diamantes+"\n";
			}

		return out;
	}

	/**
	 * Metodo que se encarga de obtener el id del suscriptor menor de edad que tenga la mayor cantidad de horas dispuestas
	 * a consumir
	 * @return out, boolean es la respuesta a si hay uno o mas suscriptores
	 */
	public String getId(){
		int age=18;
		String id="";
		int hours=0;
		for (int i=1;i<suscriptors.length ;i++) {
			if (suscriptors[i-1]!=null) {
				if (suscriptors[i-1].getAge()<age && suscriptors[i-1].getHours()>hours) {
					id=suscriptors[i-1].getId();
				}
			}
		}return id;
	}
	/**
	 * Metodo que se encarga de mostrar el nombre del suscriptor menor de edad que tenga la mayor cantidad de horas dispuestas
	 * a consumir
	 */
	public void showSus(){
		int hours;
		String id=getId();
		for (int i=1;i<suscriptors.length ;i++) {
			if (suscriptors[i-1]!=null) {
				if (suscriptors[i-1].getId()==id) {
						System.out.println(suscriptors[i-1].getName());
				}
			}
		}
	}
	/**
	 * Metodo que se encarga de validar si el nombre esta ya registrado
	 * @param name, String es el nombre que el usuario registro en el metodo addSuscript
	  * @return out, boolean es la respuesta a si el nombre existe o no ya
	 */
	public boolean verifyName(String name){
		boolean out=false;
		for (int i=0;i<products.length;i++) {
			if (products[i]!=null) {
				if ((products[i].getName()).equalsIgnoreCase(name)) {
					out = true;	
				}
			}
		}
		return out;
	}
	/**
	 * Crea una nueva pelicula y crea la fecha
	 *@param day, int el dia de la fecha
	 *@param month, int el mes de la fecha
	 *@param year, int el año de la fecha
	 *@param directorName, String nombre del director
	 *@param sinapsis, String sinapsis de la pelicula
	 *@param name, String nombre del film
	 *@param productor, String nombre del productor
	 *@param typeFilm, TypeFilm tipo de pelicula
	 *@param age, int edad minima
	 */
	public void newFilm(String name,int day, int month,int year, String directorName, String sinapsis,
	 String realName, String productor, TypeFilm typeFilm, int age){
	 	Date date = new Date(day,month,year);
	 	boolean finish = false;
		for (int i=0;i<products.length && !finish ;i++) {
			if (products[i]==null) {
				products[i]= new Film(name,date,  directorName, sinapsis, realName, productor, typeFilm, age);
				finish=true;
			}
		}
	}
	/**
	 * Crea una nueva serie y la fecha
	 *@param day, int el dia de la fecha
	 *@param month, int el mes de la fecha
	 *@param year, int el año de la fecha
	 *@param directorName, String nombre del director
	 *@param sinapsis, String sinapsis de la serie
	 *@param censure, boolean nos dice si la serie fue censurada
	 *@param reason, String razon por la cual fue censurada
	 */
	public void newSerie(String name,int day, int month,int year, String directorName, String sinapsis, 
		String protaNames, boolean censure, String reason){
		Date date = new Date(day,month,year);
		boolean finish = false;
		for (int i=0;i<products.length && !finish ;i++) {
			if (products[i]==null) {
				products[i]= new Serie(name,date,  directorName, sinapsis, protaNames, censure, reason);
				finish=true;
			}
		}
	}
	/**
	 * Crea una nueva temporada y la fecha
	 *@param day, int el dia de la fecha
	 *@param month, int el mes de la fecha
	 *@param year, int el año de la fecha
	 *@param nameSerie, String nombre de la serie
	 *@param num, int numero de la serie
	 *@param episodesProgram, int numero de episodios programados
	 *@param episodesPublic, int numero de episodios publicados
	 *@param trailer, String el link del trailer
	 */
	public void newSeason( String nameSerie, int num, int episodesProgram, int episodesPublic, int day, 
		int month, int year, String trailer){
		Date date = new Date(day,month,year);
		Serie serie;
		for (int i=0;i<products.length;i++) {
			if (products[i]!=null) {
				if ((products[i].getName()).equals(nameSerie)) {
					serie = (Serie)products[i];
					serie.createSeason( num,  episodesProgram,  episodesPublic,  date,  trailer);
				}
			}
		}
	}
	/**
	 * Metodo que crea el String con los datos de un producto segun el nombre digitado por el usuario
	  * @param name, String es el nombre del producto que se quiere imprimir
	  * @return out, String es el string que guarda todos los datos del producto
	 */
	public String showProduct(String name){
		String out= "";
		for (int i=0;i<products.length;i++) {
			if (products[i]!=null) {
				if ((products[i].getName()).equals(name)) {
					out=products[i].toString();
				}
			}
		}
		return out;
	}
	/**
	 * Metodo que crea el String con los datos de la pelicula segun la categoria digitado por el usuario
	  * @param typeFilm, TypeFilm es la categoria de la pelicula que se quiere imprimir
	  * @return out, String es el string que guarda todos los datos de la pelicula
	 */
	public String showFilm(TypeFilm typeFilm){
		String out= "";
		Film film;
		for (int i=0;i<products.length;i++) {
			if (products[i]!=null && products[i] instanceof Film){
				film = (Film)products[i];
				if (film.getTypeFilm()==typeFilm) {
					out=products[i].toString();
				}
			}
		}
		return out;
	}
	/**
	 * Metodo que crea el String con los datos de las series
	  * @return out, String es el string que guarda todos los datos de las series
	 */
	public String showSerie(){
		String out= "";
		Serie serie;
		for (int i=0;i<products.length;i++) {
			if (products[i]!=null && products[i] instanceof Serie){
				serie=(Serie)products[i] ;
				out+=serie.toStringWithJustLastSeason()+"";
			}
		}
		return out;
	}
	/**
	 * Metodo que se encarga de validar si el hay almenos una serie registrada
	  * @return out, boolean es la respuesta a si existe o no
	 */
	public boolean existSerie(){
		boolean out = false;
		for (int i=0;i<products.length;i++) {
			if (products[i]!=null && products[i] instanceof Serie){
				out=true;
			}
		}
		return out;
	}
	/**
	 * Metodo que se encarga de validar si el hay almenos una pelicula registrada
	  * @return out, boolean es la respuesta a si existe o no
	 */
	public boolean existFilm(){
		boolean out = false;
		for (int i=0;i<products.length;i++) {
			if (products[i]!=null && products[i] instanceof Film){
				out=true;
			}
		}
		return out;
	}
}