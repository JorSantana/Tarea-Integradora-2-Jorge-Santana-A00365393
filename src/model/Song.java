package model;

public class Song {

	private String title;
	private String artist;
	private String releaseDate;
	private String duration;
	private int genre;
	public static int ROCK = 0;
	public static int HIP_HOP = 1;
	public static int MUSICA_CLASICA = 2;
	public static int REGGAE = 3;
	public static int SALSA = 4;
	public static int METAL = 5;

	public Song(String title, String artist, String releaseDate, String duration, int genre) {
		this.title = title;
		this.artist = artist;
		this.releaseDate = releaseDate;
		this.duration = duration;
		this.genre = genre;
	}

	/*
	 * This method is to select a genre dependence of int genre
	 * @param empty
	 * @return String
	 */

	public String selectGenre() {
		String message = "";
		if(genre == 0) {
			message = "ROCK";
		}else if(genre == 1) {
			message = "HIP_HOP";
		}else if(genre == 2) {
			message = "MUSICA_CLASICA";
		}else if(genre == 3) {
			message = "REGGAE";
		}else if(genre == 4) {
			message = "SALSA";
		}else if(genre == 5) {
			message = "METAL";
		}else {
			message = "Dont have genre";
		}
		return message;
	}

	/*
	 * This method is to get a title of song
	 * @param empty
	 * @return title
	 */


	public String getTitle() {
		return title;
	}

	/*
	 * This method is to set a title of song
	 * @param title
	 * @return void
	 */

	public void setTitle(String title) {
		this.title = title;
	}

	/*
	 * This method is to get a Artist of song
	 * @param empty
	 * @return artist
	 */

	public String getArtist() {
		return artist;
	}

	/*
	 * This method is to set a Artist of song
	 * @param artist
	 * @return void
	 */

	public void setArtist(String artist) {
		this.artist = artist;
	}

	/*
	 * This method is to get a release date of song
	 * @param empty
	 * @return release date
	 */

	public String getReleaseDate() {
		return releaseDate;
	}

	/*
	 * This method is to set a release date of song
	 * @param release date
	 * @return void
	 */

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	/*
	 * This method is to get a duration of song
	 * @param empty
	 * @return duration
	 */

	public String getDuration() {
		return duration;
	}

	/*
	 * This method is to set a duration of song
	 * @param duration
	 * @return void
	 */

	public void setDuration(String duration) {
		this.duration = duration;
	}

	/*
	 * This method is to get a genre of song
	 * @param empty
	 * @return genre
	 */

	public int getGenre() {
		return genre;
	}

	/*
	 * This method is to set a genre of song
	 * @param genre
	 * @return void
	 */

	public void setGenre(int genre) {
		this.genre = genre;
	}


}
