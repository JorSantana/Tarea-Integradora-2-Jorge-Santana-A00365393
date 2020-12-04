package model;

import java.util.ArrayList;

public class MCS {


	private String name;
	private ArrayList<Playlist> playlists;
	private ArrayList<User> user;
	private ArrayList<Song> pool;

	public MCS(String name) {
		this.name = name;
		this.pool = new ArrayList<Song>();
		this.playlists = new ArrayList<Playlist>();
		this.user = new ArrayList<User>();
	}


	/*
	 * This method is to register a user in the program
	 * @param name
	 * @param password
	 * @param age
	 */

	public String newUser(String name, String password, int age) {
		String message = "";
		if(user.size() < 10) {
			User a = new User(name, password, age);
			user.add(a);
			message = "Registered succesfull";
		}else {
			message = "Cant add more than 10";
		}

		return message;

	}

	/*
	 * This method is to list a user in the program
	 * @param empty
	 * @return String
	 */

	public String userList() {
		String message = "";

		for (int i = 0; i < user.size(); i++) {
			message += "  User: " + i + " " + "\n"
					 + "  UserName: " + user.get(i).getUserName() + "\n"
					 + "  Age: " + user.get(i).getAge() + "\n"
					 + "  Category: " + user.get(i).selectCategory() + "\n"
					 + "" + "\n" ;
		}

		return message;
	}

	/*
	 * This method is to create a song and add in the pool
	 * @param User owner
	 * @param title
	 * @param artist
	 * @param releaseDate
	 * @param duration
	 * @param genre
	 * @return String
	 */

	public String newSong(User owner, String title, String artist, String releaseDate, String duration, int genre) {

		String message = "";


		if(pool.size() < 30) {
			Song a = new Song(title, artist, releaseDate, duration, genre);
			owner.addContribution();
			pool.add(a);
			message = "Add succesfull";
		}else {
			message = "Cant add more than 10";
		}

		return message;


	}

	/*
	 * This method is to search a user in the program
	 * @param number
	 * @return User
	 */

	public User searchUser(int number) {
		User searched = null;
		for (int i = 0; i < user.size(); i++) {
			if(i == number) {
				searched = user.get(i);
			}

		}
		return searched;
	}

	/*
	 * This method is to list a song that there are in the program
	 * @param empty
	 * @return String
	 */



	public String songList() {
		String message = "";

		for (int i = 0; i < pool.size(); i++) {
			message += "  Song: " + i +"" + "\n"
					+  "  Title: " + pool.get(i).getTitle() + "\n"
					+  "  Artist: " + pool.get(i).getArtist() + "\n"
					+  "  Duration: " + pool.get(i).getDuration() + "\n"
					+  "  Genre: " + pool.get(i).selectGenre() + "\n"
					+  "" + "\n";
		}

		return message;
	}


	/*
	 * This method is to create a playlist in the program
	 * @param option
	 * @param name
	 * @param User permissions
	 * @return String
	 */

	public String newPlaylist(int option, String name, User permissions) {
		String message = "";
		String a = "";

		if(playlists.size() < 20) {
			if(option == 0) {
				Playlist playlist0 = new Playlist(name);
				playlist0.getAccess().add(permissions);
				playlists.add(playlist0);
			}else if(option == 1) {
				Playlist playlist1 = new Private(name);
				Private private1 = (Private) playlist1;
				private1.setAccess1(permissions);
				playlists.add(playlist1);

			}else if(option == 2) {
				Playlist playlist2 = new Restricted(name);
				Restricted restricted1 = (Restricted) playlist2;
				a = restricted1.addtoArray(permissions);
				playlists.add(playlist2);
			}else if(option == 3) {
				Playlist playlist3 = new Public(name);
				Public public1 = (Public) playlist3;
				public1.getAccess0().add(permissions);
				playlists.add(playlist3);

			}else {
				message = "The option is incorrect ";
			}

		}


		return message + a;
	}

	/*
	 * This method is to add songs in the playlist
	 * @param Song toAdd
	 * @param Paylist where
	 * @return String
	 */

	public String addsongstoPlaylist(Song toAdd, Playlist where) {
		where.getSongp().add(toAdd);
		where.updateCategory();
		where.calculahora();
		return "Succesfull add and update";
	}

	/*
	 * This method is to search a song in the program
	 * @param number
	 * @return Song
	 */
	public Song searchSong(int number) {
		Song searched = null;
		for (int i = 0; i < pool.size(); i++) {
			if(i == number) {
				searched = pool.get(i);
			}

		}
		return searched;
	}

	/*
	 * This method is to search a playlist in the program
	 * @param number
	 * @return Playlist
	 */


		public Playlist searchPlaylist(int number) {
			Playlist searched = null;
			for (int i = 0; i < playlists.size(); i++) {
				if(i == number) {
					searched = playlists.get(i);
				}

			}
			return searched;
		}

		/*
		 * This method is to add permission in a playlist
		 * @param Playlist where
		 * @param User toPermission
		 * @return String
		 */

	public String addPermision(Playlist where, User toPermission) {
		String message = "";
		if(where instanceof Private) {
			Private a = (Private) where;
			if(a.isFulltoP() == true) {
				message = "The playlist have the amount of permission";
			}else {
				a.setAccess1(toPermission);
			}
		}else if(where instanceof Restricted) {
			Restricted b = (Restricted) where;
			if(b.isFulltoP() == true) {
				message = "The playlist have the amount of permission";
			}else {
				b.addtoArray(toPermission);
			}
		}else if(where instanceof Public) {
			Public c = (Public) where;
			c.getAccess0().add(toPermission);
			message = "Succesful add";
		}else if(where instanceof Playlist) {
			where.getAccess().add(toPermission);
			message = "Succesful add";
		}
		return message;
	}

	/*
	 * This method is to check the permission in the playlist
	 * @param User toPermission
	 * @param Playlist toCheck
	 * @return boolean
	 */

	public boolean checkPermission(User toPermission, Playlist toCheck) {
		boolean isAccepted = false;

		if(toCheck instanceof Private) {
			Private a = (Private) toCheck;
			if(a.getAccess1().getUserName().equals(toPermission.getUserName())) {
				isAccepted = true;
			}
		}else if(toCheck instanceof Restricted) {
			Restricted b = (Restricted) toCheck;
			for (int i = 0; i < b.getAccess5().length; i++) {
				if(b.getAccess5()[i] == null){

				}else if(b.getAccess5()[i].getUserName().equals(toPermission.getUserName())){
					isAccepted = true;
					break;
				}
			}
		}else if(toCheck instanceof Public) {
			isAccepted = true;
		}else if(toCheck instanceof Playlist) {
			isAccepted = true;
		}
		return isAccepted;
	}

	/*
	 * This method is to list a Playlist
	 * @param empty
	 * @return String
	 */

	public String listofPlaylist() {
		String message = "";

		for (int i = 0; i < playlists.size(); i++) {
			if(playlists.get(i) instanceof Private) {
				Private a = (Private) playlists.get(i);
				message += "  Private Playlist: " + i + " " + "\n"
						 + "  Access: " + a.getAccess1().getUserName() + "\n"
						 + "  Title: " + a.getName() + "\n"
						 + "  Duration: " + a.getDuration() + "\n"
						 + "  Genre: " + a.getTotalGenre() + "\n"
						 + "" + "\n" ;
			}else if(playlists.get(i) instanceof Restricted) {
				Restricted b = (Restricted) playlists.get(i);
				message += "  Restricted Playlist: " + i + " " + "\n"
						 + "  Access: " + b.getNameofAllAccess() + "\n"
						 + "  Title: " + b.getName() + "\n"
						 + "  Duration: " + b.getDuration() + "\n"
						 + "  Genre: " + b.getTotalGenre() + "\n"
						 + "" + "\n" ;
			}else if(playlists.get(i) instanceof Public) {
				Public c = (Public) playlists.get(i);
				message += "  Public Playlist: " + i + " " + "\n"
						 + "  Grade: " + c.getAverageMark() + "\n"
						 + "  Title: " + c.getName() + "\n"
						 + "  Duration: " + c.getDuration() + "\n"
						 + "  Genre: " + c.getTotalGenre() + "\n"
						 + "" + "\n" ;
			}else {
				message += "  Playlist: " + i + " " + "\n"
						 + "  Title: " + playlists.get(i).getName() + "\n"
						 + "  Duration: " + playlists.get(i).getDuration() + "\n"
						 + "  Genre: " + playlists.get(i).getTotalGenre() + "\n"
						 + "" + "\n" ;
			}

		}
		return message;
	}

	/*
	 * This method is to get a name of App
	 * @param empty
	 * @return A String name
	 */


	public String getName() {
		return name;
	}

	/*
	 * This method is to set a name of App
	 * @param name
	 * @return void
	 */

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * This method is to get a pool of song
	 * @param empty
	 * @return A Arraylist of songs
	 */

	public ArrayList<Song> getPool() {
		return pool;
	}

	/*
	 * This method is to set a pool of song
	 * @param ArrayList<Song>
	 * @param pool
	 * @return void
	 */



	public void setPool(ArrayList<Song> pool) {
		this.pool = pool;
	}

	/*
	 * This method is to get a playlists
	 * @param empty
	 * @return A Arraylist of playlist
	 */

	public ArrayList<Playlist> getPlaylists() {
		return playlists;
	}

	/*
	 * This method is to set a playlists
	 * @param ArrayList<Playlist>
	 * @param playlists
	 * @return void
	 */

	public void setPlaylists(ArrayList<Playlist> playlists) {
		this.playlists = playlists;
	}

	/*
	 * This method is to get a users
	 * @param empty
	 * @return A Arraylist of user
	 */

	public ArrayList<User> getUserR() {
		return user;
	}

	/*
	 * This method is to set a users
	 * @param ArrayList<User>
	 * @param user
	 * @return void
	 */

	public void setUserR(ArrayList<User> user) {
		this.user = user;
	}


}
