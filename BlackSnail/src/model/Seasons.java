package model;

public class Seasons {

	private int num;
	private int episodesProgram;
	private int episodesPublic;
	private Date datePublic;
	private String trailer;

	public Seasons( int num, int episodesProgram, int episodesPublic, Date datepublic, String trailer){
		 this.num =num;
		 this.episodesProgram = episodesProgram;
		 this.episodesPublic =episodesPublic;
		 this.datePublic = datepublic;
		 this.trailer = trailer;
	}

	public int getNum(){
		return num;
	}
	public void setNum(int num){
		this.num=num;
	}
	public int getEpisodesProgram(){
		return episodesProgram;
	}
	public void setEpisodesProgram(int episodesProgram){
		this.episodesProgram=episodesProgram;
	}
	public int getEpisodesPublic(){
		return episodesPublic;
	}
	public void setEpisodesPublic(int episodesPublic){
		this.episodesPublic=episodesPublic;
	}
	public Date getDatePublic(){
		return datePublic;
	}
	public void setDatePublic(Date datePublic){
		this.datePublic=datePublic;
	}
	public String getTrailer(){
		return trailer;
	}
	public void setTrailer(String trailer){
		this.trailer=trailer;
	}
	public String toString(){
		String out = "Temporada : "+num+"\n"+
		"Episodios programados : "+episodesProgram+"\n"+
		"Episodios publicados : "+episodesPublic+"\n"+
		"Fecha de estreno : "+datePublic+"\n"+
		"Trailer : "+trailer+"\n";

		return out;
	}
}