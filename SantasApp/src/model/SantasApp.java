package model;

import java.util.ArrayList;

public class SantasApp{

	private ArrayList <Child> whiteList;
	private ArrayList <Child> blackList;

	public SantasApp(){

		whiteList= new ArrayList <Child> ();
		blackList= new ArrayList <Child> ();
		
	}

	public void createChild(String name, String lastName, int age, String direction, String country, String wish){
		boolean finish = false;
		Child child = new  Child(name, lastName, age, direction, country, wish);
		if (foundPositionWhite()) {
			for (int i=0;i<whiteList.size() && !finish;i++ ){
				if (whiteList.get(i).compareTo(child)<0) {
					whiteList.add(i,child);
					finish=true;
				}
			}if (finish == false) {
				whiteList.add(child);
			}

		}else {
			whiteList.add(child);
		}
	}

	public void changeList(String name, String lastName){
		Child child;
		boolean finish = false;                                               
		int i = foundPositionForName(name, lastName);
		child = whiteList.get(i);
		if ((child.getName()).equalsIgnoreCase(name)) {
			child.setStatus(List.NAUGTHYCHILD);
			whiteList.remove(i);
			blackList.add(child);
		}else{
			child.setStatus(List.GOODCHILD);
			blackList.remove(i);
			whiteList.add(child);
		}
	}

	public void deleteChild(String name, String lastName){
		Child child;
		boolean finish = false;
		int i = foundPositionForName(name, lastName);
		child = whiteList.get(i);
		if ((child.getName()).equalsIgnoreCase(name) && (child.getLastName()).equalsIgnoreCase(lastName)) {
			whiteList.remove(i);
		}else{
			blackList.remove(i);
		}
	}

	public String showList(int list){
		String out = "";
		Child child;
		boolean finish = false;
		if (list == 1) {
			for (int i=0;i<whiteList.size() && !finish;i++ ){
				if (whiteList.get(i)!=null) {
					out+=whiteList.get(i);
				}
			}
		}else{
			for (int i=0;i<blackList.size() && !finish;i++ ){
				if (blackList.get(i)!=null) {
					out+=blackList.get(i);
				}
			}
		}
		return out;
	}

	public boolean foundPositionWhite(){
		boolean out = false;
		for (int i=0;i<whiteList.size() && !out;i++ ){
			if (whiteList.get(i)!=null) {
				out = true;
			}
		}
		return out;
	}
	public boolean foundPositionBlack(){
		boolean out = false;
		for (int i=0;i<whiteList.size() && !out;i++ ){
			if (whiteList.get(i)!=null) {
				out = true;
			}
		}
		return out;
	}
	public int foundPositionForName(String name, String lastName){
		int position = -1;
		Child child;
		boolean finish = false;
		for (int i=0;i<whiteList.size() && !finish;i++ ) {
			child = whiteList.get(i);
			if ((child.getName()).equalsIgnoreCase(name) && (child.getLastName()).equalsIgnoreCase(lastName)) {
					
					finish = true;
					position=i;

				}	
		}
		for (int i=0;i<blackList.size() && !finish;i++ ) {
			child = blackList.get(i);
			if ((child.getName()).equalsIgnoreCase(name) && (child.getLastName()).equalsIgnoreCase(lastName)) {
					
					finish = true;
					position=i;

				}	
		}

		return position;
	}

	public String showChild(String name, String lastName){
		Child child;
		boolean finish = false;
		String out = ""; 
		int i = foundPositionForName(name, lastName);
		child = whiteList.get(i);
		if ((child.getName()).equalsIgnoreCase(name)) {
			out+=whiteList.get(i);
		}else{
			out+=blackList.get(i);
		}

		return out;
	}

}