package ui;

import java.util.Scanner;
import model.SantasApp;
/*public static final String ANSI_RESET = "\u001B[0m";
public static final String ANSI_BLACK = "\u001B[30m";
public static final String ANSI_RED = "\u001B[31m";
public static final String ANSI_GREEN = "\u001B[32m";
public static final String ANSI_YELLOW = "\u001B[33m";
public static final String ANSI_BLUE = "\u001B[34m";
public static final String ANSI_PURPLE = "\u001B[35m";
public static final String ANSI_CYAN = "\u001B[36m";
public static final String ANSI_WHITE = "\u001B[37m";*/

public class Main{
	private Scanner sc;
	private SantasApp app;

	public Main(){
		sc= new Scanner(System.in);

		app = new SantasApp();

	}

	public static void main(String[] args) {
		Main pc = new Main();
		int option;
		do {
		    option = pc.showMenu();
		    pc.switchAns(option);
		}while (option !=0);		
	}

	public int showMenu(){

		System.out.println(" BIENVENIDO A LA APP DE SANTA \n"+"(1) Add new child\n"+
			"(2) Edit child list\n"+
			"(3) Delete child\n"+
			"(4) Show a list\n"+
			"(5) Show a specific child\n"+
			"(0) Exit");
		int op = sc.nextInt();

		return op;
	}

	public void switchAns(int option){
		switch(option){
			case 0:
				System.out.println("Finish...");
				break;
			case 1:
				addChild();
				break;
			case 2:
				editChild();
				break;
			case 3:
				deleteChild();
				break;
			case 4:
				showList();
				break;
			case 5:
				showSpecificChild();
				break;
		}
	}

	public void addChild(){
		sc.nextLine();
		System.out.println("Escribe el nombre");
		String name = sc.nextLine();
		System.out.println("Escribe el apellido");
		String lastName = sc.nextLine();
		System.out.println("Escribe la edad");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("Escribe tu direccion con ciudad");
		String direction = sc.nextLine();
		System.out.println("Escribe su pais");
		String country = sc.nextLine();
		System.out.println("Escribe el deseo del niño");
		String wish = sc.nextLine();

		app.createChild(name, lastName, age, direction, country, wish);

		System.out.println("\nSe agrego correctamente a "+name+"\n");
	}

	public void editChild(){
		String name = "";
		String lastName = "";
		boolean finish = false;
		if (app.foundPositionWhite() || app.foundPositionBlack()) {
			sc.nextLine();
			System.out.println("Escribe el nombre y apellido del chich@ que vas a cambiar");
			System.out.println("Nombre\n");
			name = sc.nextLine();
			System.out.println("Apellido\n");
			lastName = sc.nextLine();
			do{
				if (app.foundPositionForName(name, lastName)>-1) {
					app.changeList(name, lastName);
					finish = true;
				}else{
					System.out.println("\nEl chico no se encuentra, vuelve a digitar los datos o escribe 0 para salir\n");
					name=sc.nextLine();
					if (!name.equals("0")) {
						System.out.println("\nEscribe el apellido\n");
						lastName = sc.nextLine();
					}
					
				}
			}while(name.equals("0")!=true && finish==false);
		}else {

			System.out.println("\nParece que todavia no hay chicos!\n");

		}
		
	}

	public void showList(){
		sc.nextLine();
		System.out.println("Digita la lista que quieres mostrar 1:buenos , 2:malos");
		int list = sc.nextInt();
		if (list==1) {
			if (app.foundPositionWhite()){
				System.out.println(app.showList(list));
			}else{
				System.out.println("\nAun no hay chicos en esta lista\n");
			}
		}else{
			if (app.foundPositionBlack()){
				System.out.println(app.showList(list));
			}else{
				System.out.println("\nAun no hay chicos en esta lista\n");
			}
		}

	}

	public void deleteChild(){
		String name = "";
		String lastName = "";
		boolean finish = false;
		if (app.foundPositionWhite() || app.foundPositionBlack()) {
			sc.nextLine();
			
				System.out.println("Escribe el nombre y apellido del chich@ que vas a borrar");
				System.out.println("Nombre\n");
				name = sc.nextLine();
				System.out.println("Apellido\n");
				lastName = sc.nextLine();
			do{
				if (app.foundPositionForName(name, lastName)>-1) {

					app.deleteChild(name, lastName);
					finish = true;

				}else{
					System.out.println("\nEl chico no se encuentra, vuelve a digitar los datos o escribe 0 para salir\n");
					name=sc.nextLine();
					if (!name.equals("0")) {
						System.out.println("\nEscribe el apellido\n");
						lastName = sc.nextLine();
					}
					
				}
			}while(name.equals("0")!=true && finish==false);
		}else{

			System.out.println("\nParece que todavia no hay chicos!\n");

		}		
	}

	public void showSpecificChild(){

		String name = "";
		String lastName = "";
		boolean finish = false;
		if (app.foundPositionWhite() || app.foundPositionBlack()) {
			sc.nextLine();
			
				System.out.println("Escribe el nombre y apellido del chich@ que quieres mostrar");
				System.out.println("Nombre\n");
				name = sc.nextLine();
				System.out.println("Apellido\n");
				lastName = sc.nextLine();
			do{
				if (app.foundPositionForName(name, lastName)>-1) {

					System.out.println(app.showChild(name, lastName));
					finish = true;

				}else{
					System.out.println("\nEl chico no se encuentra, vuelve a digitar los datos o escribe 0 para salir\n");
					name=sc.nextLine();
					if (!name.equals("0")) {
						System.out.println("\nEscribe el apellido\n");
						lastName = sc.nextLine();
					}
					
				}
			}while(name.equals("0")!=true && finish==false);
		}else{

			System.out.println("\nParece que todavia no hay chicos!\n");

		}		

	}
}