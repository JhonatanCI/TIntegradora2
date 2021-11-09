package model;

public class Serie extends Product{

	private boolean censure;
	private String protaNames;
	private final boolean censured = true;
	private final boolean uncensured = false;
	private String reason;
	private Seasons [] seasons = new Seasons[20];

	public Serie(String name,Date date, String directorName, String sinapsis, String protaNames, boolean censure, String reason){
		super(name, date, directorName, sinapsis);
		this.censure = censure;
		this.reason = reason;
		this.protaNames = protaNames;
	}
	public void createSeason(int num, int numEpisodesProgram, int numEpisodesPublic, Date datePublic, String trailer){
		boolean finish = false;
		for (int i=1;i<seasons.length && !finish ;i++) {
			if (seasons[i]==null) {
				seasons[i]= new Seasons( num,  numEpisodesProgram,  numEpisodesPublic, datePublic, trailer);
				finish=true;
			}
		}
	}
	public boolean getCensure(){
		return censure;
	}
	public void setCensure(boolean censure){
		this.censure=censure;
	}
	public String getProtaNames(){
		return protaNames;
	}
	public void setProtaNames(String protaNames){
		this.protaNames=protaNames;
	}
	public String getReason(){
		return reason;
	}
	public void setReason(String reason){
		this.reason=reason;
	}
	public Seasons getSeasons(int pos){
		return seasons[pos];
	}
	public void setSeasons(Seasons seasons, int pos){
		this.seasons[pos]=seasons;
	}
	public String allSeasonsString(){
		String out = "";
		for (int i=1;i<seasons.length ;i++) {
			if (seasons[i]!=null) {
				out+=seasons[i];
			}
		}
		return out;
	}
	public String lastSeasonsString(){
		String out = "";
		int last = 0;
		for (int i=0;i<seasons.length ;i++) {
			if (seasons[i]!=null) {
				if (seasons[i].getNum()>last) {
					out=seasons[i]+"";
				}
			}
		}
		return out;
	}
	public String toString(){
		String out = "Protagonistas : "+protaNames+"\n"+
		"Se estreno en : "+date+"\n"+
		"Director : "+directorName+"\n"+
		"Sinapsis : "+sinapsis+"\n"+
		"Censurado : "+censured+"\n"+
		"Razons : "+reason+"\n"+
		"Temporadas : "+allSeasonsString()+"\n";

		return out;
	}
	public String toStringWithJustLastSeason(){
		String out = "Protagonistas : "+protaNames+"\n"+
		"Se estreno en : "+date+"\n"+
		"Director : "+directorName+"\n"+
		"Sinapsis : "+sinapsis+"\n"+
		"Censurado : "+censured+"\n"+
		"Razons : "+reason+"\n"+
		"Temporadas : "+lastSeasonsString()+"\n";

		return out;
	}
}