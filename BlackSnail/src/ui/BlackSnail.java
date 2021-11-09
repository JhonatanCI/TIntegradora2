package ui;

import java.util.Scanner;
import model.Channel;
import model.Type;
import model.State;
import model.TypeFilm;


/**
 * Clase principal del proyecto candyShop.
 * Desarrollada para el 
 * @author JhonatanCastaño
 * @version 1.0
 * @since October 2021
 */
public class BlackSnail {

	/**
	 * cha es la conexiOn con la clase Channel en el paquete model
	 */
	private Channel cha;

	/**
	 * sc es el objeto que permite leer informaciOn digitada por el usuario
	 */
	private Scanner sc;

	/**
	 * Constructor de la clase, no recibe prametros.  
	 * El mEtodo inicializa el objeto lector 
	 */ 
	public BlackSnail() {
		// objeto de la clase Channel y Scanner
		sc= new Scanner(System.in);
		System.out.println("Digita la direccion del canal");
		String direction = sc.next();
		System.out.println("Digita la direccion website");
		String website = sc.next();
		cha= new Channel(direction,website);
	}

	public static void main (String[] a){
		BlackSnail pc= new BlackSnail();
		int option=1;
		do {
		    option = pc.showMenuAndGetOption();
		    pc.answerOption(option);
		}while (option !=0);
	}


	/**
	 * showMenuAndGetOption se encarga de mostrar todas las opciones al usuario y despues lee la selección del mismo 
	 * @return input, int es la opción elegida por el usuario
	 */
	public int showMenuAndGetOption() { 
		int input;
		System.out.println("\n\nMenu del canal, digite una opciOn\n"+ 
		                    "(1) Crear un suscriptor\n" +
		                    "(2) Desactivar o Activar un suscriptor\n" +
		                    "(3) Desplegar la cantidad de suscriptores activos por cada tipo de cliente\n"+
		                    "(4) Desplegar el nombre del suscriptor menor de edad que tenga el mayor número de horas dispuesto a consumir.\n"+
		                    "(5) Crear una pelicula o serie\n"+
		                    "(6) Desplegar info de una pelicula o serie\n"+
		                    "(7) Crear una temporada de una serie\n"+
		                    "(8) Desplegar info de acuerdo a la categoria de una pelicula\n"+
		                    "(9) Desplegar la lista de series disponibles\n"+
		                    "(0) Para salir"
	
		);
		input = sc.nextInt();
		sc.nextLine();
		return input;
	}

	/**
	 * Metodo que se encarga de llamar a los métodos que resuelven cada uno de los 
	 * requerimientos de la aplicaciOn 
	 * @param userOption, int es la opcion del usuario
	 */
	public void answerOption(int userOption) {
		switch(userOption) {
		case 0: 
			System.out.println("Finish...");
			break;
		case 1:
			addSuscript();
			break;
		case 2:
			activeOrInactive();
			break;
		case 3: 
			showSus();
			break;
		case 4:
			showNameSus();
			break;
		case 5:
			newProduct();
			break;
		case 6:
			showProduct();
			break;
		case 7:
			createNewSeason();
			break;
		case 8:
			showFilms();
			break;
		case 9:
			showSeries();
			break;
		}
	}

	/**
	 * Metodo que se encarga de pedir al usuario un id para luego llamar los metodos que se
	 * encargan de verificar si el id esta ya registrado y si no es el caso entonces llama al metodo
	 * que termina de crear al usuario (Tambien informa al usuario de las novedades sobre el registro del
	 * usuario)
	 */
	public void addSuscript(){
		if (cha.verifyLimit()) {
			System.out.println("Escribe la cedula");
			String id = sc.next();
			if (cha.verifyOneOrMoreSus()) {
				if (cha.verifyId(id)) {
					createSuscriptor(id);
					System.out.println("El suscriptor ha sido creado con exito");
				
				}else{
					System.out.println("La cedula ya esta registrada");
				}
			}else {
				createSuscriptor(id);
				System.out.println("El suscriptor ha sido creado con exito");
			}
			
		}else{
			System.out.println("Hemos llegado al limite de suscriptores");
		}
		
	}

	/**
	 * Metodo que se encarga de llamar y pasar por parametros los datos del usuario
	 * al metodo que registrara al suscriptor
	 * @param id, String es el id que el usuario registro en el metodo addSuscript
	 */
	public void createSuscriptor(String id){
		System.out.println("Escribe el nombre");
		String name = sc.next();
		System.out.println("Digita la edad en numeros");
		int age = sc.nextInt();
		System.out.println("Digita la cantidad de horas a consumir");
		int hours = sc.nextInt();
		System.out.println("Digita el estado del suscriptor 1 = Activo 2 = Inactivo");
		int state = sc.nextInt();

		while(state>2 || state<1){
			System.out.println("No es un numero valido");
			 state = sc.nextInt();
		}//validamos que la opcion este entre 1 y 2

		System.out.println("Digita 1=NORMAL, 2=PLATINO, 3=ORO, 4=DIAMANTE");
		int type = sc.nextInt();

		while(type>4 || type<1){
			System.out.println("No es un numero valido");
			 type = sc.nextInt();
		}//validamos que la opcion este entre 1, 2, 3 y 4

		cha.createSus(id, name, age, hours, state, type);
	}

	/**
	 * Metodo que se encarga de llamar al menu para que pueda seleccionar que usuario desea activar o desactivar
	 * para luego leer su opcion y pasarla por parametro al metodo que la activara o desactivara
	 */
	public void activeOrInactive(){
		System.out.println("Selecciona el suscriptor que quieres activar o desactivar");
		cha.menu();
		int option = sc.nextInt();
		cha.setActiveOrInactive(option);
	}

	/**
	 * Metodo que verifica si hay mas de un suscriptor para poder llamar al metodo
	 * que nos mostrará la cantidad de suscriptores que hay por cada tipo
	 */
	public void showSus(){
		if (cha.verifyOneOrMoreSus()) {
			cha.showSuscribers();
		}else {
			System.out.println("No hay suscriptores creados");
		}
	}

	/**
	 * Metodo que verifica si hay mas de un suscriptor para poder llamar al metodo
	 * que nos mostrará el nombre del susctiptor menor de edad que tiene la mayor
	 * cantidad de horas dispuestas a consumir
	 */
	public void showNameSus(){
		if (cha.verifyOneOrMoreSus()) {
			cha.showSus();
		}else {
			System.out.println("No hay suscriptores creados");
		}
	}

	/**
	 * Metodo que crea un nuevo producto enviando todos los datos digitados a Channel
	 */
	public void newProduct(){
		System.out.println("Digita 1 si quieres agregar una serie y 2 una pelicula");
		int answer = sc.nextInt();
		while(answer!=1 && answer!=2){
				answer= sc. nextInt();
			}
		System.out.println("Escribe el nombre");
		String name = sc.next();
		while(cha.verifyName(name)){
			System.out.println("El nombre ya esta registrado");
			name= sc.next();
		}
		System.out.println("Digita el dia de estreno");
		int day = sc.nextInt();
		System.out.println("Digita el mes de estreno");
		int month = sc.nextInt();
		System.out.println("Digita el aNo de estreno");
		int year = sc.nextInt();
		System.out.println("Digita el nombre del director");
		String directorName = sc.next();
		System.out.println("Digita sinapsis");
		String sinapsis = sc.next();
		if (answer==1) {
			System.out.println("Digita el nombre del protagonista");
			String protaNames = sc.next();
			System.out.println("Escribe 1 si fue censurada y 2 si no");
			int cen= sc. nextInt();
			while(cen!=1 && cen!=2){
				cen= sc. nextInt();
			}
			boolean censure;
			String reason;
			if (cen==1) {
				 censure=true;	
				System.out.println("Escribe el motivo");
				reason = sc.next();
			}else{
				censure=false;
				reason = "";
			}
			cha.newSerie(name, day,  month, year,  directorName,  sinapsis, protaNames, censure,  reason);
			System.out.println("Creando la primera temporada de la serie");
			System.out.println("Digita el numero de episodios programados");
			int numEpisodesProgram = sc.nextInt(); 
			System.out.println("Digita el numero de episodios publicados");
			int numEpisodesPublic = sc.nextInt();
			System.out.println("Digita el link trailer");
			String trailer = sc.next();
			cha.newSeason( name, 1,  numEpisodesProgram,  numEpisodesPublic, day, month, year, trailer);
			System.out.println("La serie se ha creado correctamente");
		}
		if (answer==2) {
			System.out.println("Digita el nombre original de la pelicula");
			String realName = sc.next();
			System.out.println("Digita el nombre del productor");
			String productor = sc.next();
			System.out.println("Digita si la pelicula es "+ 
				"1=ROMANTICA, 2=ACCION, 3=SUSPENSO, 4=TERROR, 5=COMEDIA, 6=TRAILER");
			int option = sc.nextInt();
			while(option<1&&option>6){
				option = sc.nextInt();
			}
			TypeFilm typeFilm = switchTypeFilm(option);
			System.out.println("Escribe la edad minima");
			int age = sc.nextInt();
			cha.newFilm( name,day, month, year, directorName, sinapsis,realName, productor, typeFilm, age);
			System.out.println("La pelicula se ha creado correctamente");
			
		}
		
	}
	/**
	 * Metodo que retorna un tipo de pelicula segun lo que el usuario elija
	 * @param option, int es la option que el usuario digito
	 *@return typeFilm, TypeFilm es la categoria elegida por el usuario
	 */
	public TypeFilm switchTypeFilm(int option){
		TypeFilm typeFilm=TypeFilm.ROMANTICA;
			switch(option){
				case 1:
					typeFilm= TypeFilm.ROMANTICA;
				break;
				case 2:
					typeFilm= TypeFilm.ACCION;
				break;
				case 3:
					typeFilm= TypeFilm.SUSPENSO;
				break;
				case 4:
					typeFilm= TypeFilm.TERROR;
				break;
				case 5:
					typeFilm= TypeFilm.COMEDIA;
				break;
				case 6:
					typeFilm= TypeFilm.TRAILER;
				break;
			}
		return typeFilm;
	}
	/**
	 * Metodo que muestra los datos de un producto segun el nombre digitado por el usuario
	 */
	public void showProduct(){
		System.out.println("Digita el nombre de la serie o pelicula");
		String name = sc.next();
		while(!cha.verifyName(name) && !name.equals("0")){
			System.out.println("La serie o pelicula no existe vuelve a escribir el nombre o escribe 0 si deseas salir");
			name= sc.next();
		}
		if (!name.equals("0")) {
			System.out.println(cha.showProduct(name));
		}
	}
	/**
	 * Metodo que crea una nueva temporada para una serie
	 */
	public void createNewSeason(){
		System.out.println("Digita el nombre de la serie");
		String name = sc.next();
		while(!cha.verifyName(name) && !name.equals("0")){
			System.out.println("La serie no existe vuelve a escribir el nombre o escribe 0 si deseas salir");
			name= sc.next();

		}
		if (!name.equals("0")) {
			System.out.println("Digita el numero de temporada");
			int num= sc.nextInt();
			System.out.println("Digita el numero de episodios programados");
			int numEpisodesProgram = sc.nextInt(); 
			System.out.println("Digita el numero de episodios publicados");
			int numEpisodesPublic = sc.nextInt();
			System.out.println("Digita el dia de la fecha de estreno");
			int dayPublic = sc.nextInt();
			System.out.println("Digita el mes de la fecha de estreno");
			int monthPublic = sc.nextInt();
			System.out.println("Digita el dia aNo la fecha de estreno");
			int yearPublic = sc.nextInt();
			System.out.println("Digita el link trailer");
			String trailer = sc.next();
			cha.newSeason( name, num,  numEpisodesProgram,  numEpisodesPublic, dayPublic, monthPublic, yearPublic, trailer);
			System.out.println("La temporada se ha creado correctamente");
		}
	}
	/**
	 * Metodo que muestra los datos de un pelicula segun la categoria digitado por el usuario
	 */
	public void showFilms(){
		if (cha.existFilm()) {
			System.out.println("Digita si la pelicula es "+ 
					"1=ROMANTICA, 2=ACCION, 3=SUSPENSO, 4=TERROR, 5=COMEDIA, 6=TRAILER");
			int option = sc.nextInt();
			while(option<1&&option>6){
				option = sc.nextInt();
			}
			TypeFilm typeFilm = switchTypeFilm(option);
			System.out.println(cha.showFilm(typeFilm));
		}else {
			System.out.println("No existe ninguna pelicula");
		}
	}
	/**
	 * Metodo que muestra todos los datos de las series con la ultima temporada
	 */
	public void showSeries(){
		if (cha.existSerie()) {
			System.out.println(cha.showSerie());
		}else{
			System.out.println("No existe ninguna serie");
		}
		
	}
}