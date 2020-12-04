package model;

import java.util.ArrayList;

public class Playlist {

	private String duration;
	private String name;
	private String totalGenre;
	private ArrayList<Song> songp;
	private ArrayList<User> acccess;

	public Playlist(String name) {
		this.name = name;
		this.duration = "";
		this.totalGenre = "";
		this.songp = new ArrayList<Song>();
		this.acccess = new ArrayList<User>();
	}

	/*
	 * This method is to update the category
	 * @param empty
	 * @return void
	 */

	public void updateCategory() {
		String message = "";
		boolean rock = false;
		boolean hiphop = false;
		boolean reggae = false;
		boolean salsa = false;
		boolean mclasica = false;
		boolean metal = false;

		for (int i = 0; i < songp.size(); i++) {
			if(songp.get(i).getGenre() == 0) {
				if(rock == false) {
					rock = true;
					message += "Rock-";

				}else {

				}
			}else if(songp.get(i).getGenre()== 1) {
				if(hiphop == false) {
					hiphop = true;
					message += "HipHop";
				}else {

				}
			}else if(songp.get(i).getGenre() == 2) {
				if(mclasica == false) {
					mclasica = true;
					message += "Clasica";
				}else {

				}
			}else if(songp.get(i).getGenre() == 3) {
				if(reggae == false) {
					reggae = true;
					message += "Reggae";
				}else {

				}
			}else if(songp.get(i).getGenre() == 4) {
				if(salsa == false) {
					salsa = true;
					message += "Salsa";
				}else {

				}
			}else if(songp.get(i).getGenre() == 5) {
				if(metal == false) {
					metal = true;
					message += "Metal";
				}else {

				}
			}else {
				message += "";
			}

			setTotalGenre(message);
		}
	}

	/*
	 * This method is to list the songs of playlist
	 * @param empty
	 * @return String
	 */

	public String songsPlaylist() {
		String message = "";

		for (int i = 0; i < songp.size(); i++) {
			message += "  Song: " + i +"" + "\n"
					+  "  Title: " + songp.get(i).getTitle() + "\n"
					+  "  Artist: " + songp.get(i).getArtist() + "\n"
					+  "  Duration: " + songp.get(i).getDuration() + "\n"
					+  "  Genre: " + songp.get(i).selectGenre() + "\n"
					+  "" + "\n";
		}

		return message;
	}

	/*
	 * This method is to calculate the duration
	 * @param empty
	 * @return void
	 */

	public void calculahora() {
		String duration = "";
		int horas = 0;
		int minutos = 0;
		int segundos = 0;
		for (int i = 0; i < songp.size(); i++) {
			String time = songp.get(i).getDuration();
			String minutosS = time.substring(0,2);
			String segundosS = time.substring(3,5);
			segundos += Integer.parseInt(segundosS);
			minutos += Integer.parseInt(minutosS);
			if(segundos >= 60) {
				segundos = segundos - 60;
				minutos++;
				if(minutos >= 60) {
					minutos = minutos - 60;
					horas++;
				}
			}
		}
		duration = horas + ":" + minutos + ":" + segundos;
		setDuration(duration);
	}

	/*
	 * This method is to get a songp of playlist
	 * @param empty
	 * @return A ArrayList<Song> songp
	 */

	public ArrayList<Song> getSongp() {
		return songp;
	}

	/*
	 * This method is to set a songp of playlist
	 * @param ArrayList<Song>
	 * @param songp
	 * @return void
	 */

	public void setSongp(ArrayList<Song> songp) {
		this.songp = songp;
	}

	/*
	 * This method is to get a user that have access of playlist
	 * @param empty
	 * @return A ArrayList<User> access
	 */

	public ArrayList<User> getAccess() {
		return acccess;
	}

	/*
	 * This method is to set a user that have access of playlist
	 * @param ArrayList<User>
	 * @param access
	 * @return void
	 */

	public void setAccess(ArrayList<User> acccess) {
		this.acccess = acccess;
	}

	/*
	 * This method is to get a name of playlist
	 * @param empty
	 * @return A String name
	 */

	public String getName() {
		return name;
	}

	/*
	 * This method is to set a name of playlist
	 * @param String
	 * @param name
	 * @return: void
	 */

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * This method is to get a duration of playlist
	 * @param empty
	 * @return A String duration
	 */

	public String getDuration() {
		return duration;
	}

	/*
	 * This method is to set a duration of playlist
	 * @param String
	 * @param duration
	 * @return void
	 */

	public void setDuration(String duration) {
		this.duration = duration;
	}

	/*
	 * This method is to get a total genre of playlist
	 * @param empty
	 * @return A String totalGenre
	 */

	public String getTotalGenre() {
		return totalGenre;
	}

	/*
	 * This method is to set a total genre of playlist
	 * @param String
	 * @param totalGenre
	 * @return void
	 */

	public void setTotalGenre(String totalGenre) {
		this.totalGenre = totalGenre;
	}






}
