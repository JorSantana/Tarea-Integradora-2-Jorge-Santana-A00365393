package ui;

import java.util.Scanner;

import model.*;

public class Main {

	private Scanner entrie1;
	private Scanner entrie2;

	private MCS control;

	public static void main(String[] args) {
		Main c = new Main();
		c.start();

	}

	/*
	 * This method is to start the program and initialize cases of Main
	 * @param empty
	 * @return void
	 */

	public void start() {
		entrie1 = new Scanner(System.in);
		entrie2 = new Scanner(System.in);
		control = new MCS("MCS");
		menu();

	}

	/*
	 * This method is to start the menu
	 * @param empty
	 * @return void
	 */


	public void menu() {

		System.out.println("Welcome to MCS " + control.getName() + "\n");
		System.out.println("What operation do you want to do?");
		System.out.println("1. Create a new user");
		System.out.println("2. List of users");
		System.out.println("3. Add song to the pool");
		System.out.println("4. List of songs in the pool");
		System.out.println("5. Create a new Playlist");
		System.out.println("6. List of the Playlist");
		System.out.println("7. Add song to a playlist");
		System.out.println("8. Enter to a Playlist");
		System.out.println("9. Add access to the playlist");
		System.out.println("10. List of the song added into the playlist");

		int option = entrie2.nextInt();

		option(option);
	}

	/*
	 * This method is to select the option
	 * @param A int option
	 * @return void
	 */

	public void option(int option) {
		if(option == 1) {
			option1();
		}else if(option == 2) {
			option2();
		}else if(option == 3) {
			option3();
		}else if(option == 4) {
			option4();
		}else if(option == 5) {
			option5();
		}else if(option == 6) {
			option6();
		}else if(option == 7) {
			option7();
		}else if(option == 8) {
			option8();
		}else if(option == 9) {
			option9();
		}else if(option == 10) {
			option10();
		}else {
			System.out.println("Incorrect option");
			menu();
		}
	}

	/*
	 * This method is to start the option1
	 * @param empty
	 * @return void
	 */

	public void option1() {
		System.out.println("New user");
		System.out.println("");
		System.out.println("What is the name?");
		String name = entrie1.nextLine();
		System.out.println("What is the password?");
		String pass = entrie1.nextLine();
		System.out.println("What is the age?");
		int age = entrie2.nextInt();
		System.out.println(control.newUser(name, pass, age));
		menu();
	}

	/*
	 * This method is to start the option2
	 * @param empty
	 * @return void
	 */

	public void option2() {
		System.out.println("List of user");
		System.out.println("");
		System.out.println(control.userList());
		menu();
	}

	/*
	 * This method is to start the option3
	 * @param empty
	 * @return void
	 */

	public void option3() {
		System.out.println("New song");
		System.out.println("");
		System.out.println("Who is going to add the song? Write the number of the user");
		System.out.println(control.userList());
		int user = entrie2.nextInt();
		User owner = control.searchUser(user);
		System.out.println("What is the song title");
		String title = entrie1.nextLine();
		System.out.println("What is the song artist?");
		String artist = entrie1.nextLine();
		System.out.println("What is the release date of the song? Use the format YY/MM/DD");
		String releaseDate = entrie1.nextLine();
		System.out.println("What is the song duration? Use the format MM:SS)");
		String duration = entrie1.nextLine();
		System.out.println("What is the song genre? Write the following option");
		System.out.println("0. ROCK");
		System.out.println("1. HIP HOP");
		System.out.println("2. MUSICA CLASICA");
		System.out.println("3. REGGAE");
		System.out.println("4. SALSA");
		System.out.println("5. METAL");

		int genre = entrie2.nextInt();
		System.out.println(control.newSong(owner, title, artist, releaseDate, duration, genre));
		menu();
	}

	/*
	 * This method is to start the option4
	 * @param empty
	 * @return void
	 */

	public void option4() {
		System.out.println("Shared Song");
		System.out.println("");
		System.out.println(control.songList());
		menu();

	}

	/*
	 * This method is to start the option5
	 * @param empty
	 * @return void
	 */

	public void option5() {
		System.out.println("New Playlist");
		System.out.println("");
		System.out.println("What is the type of Playlist that you like create? Select the number");
		System.out.println("0. Playlist without any type");
		System.out.println("1. Private playlist");
		System.out.println("2. Restricted playlist");
		System.out.println("3. Public playlist");
		int option = entrie2.nextInt();
		System.out.println("What is the user that like to create a playlist? Select the number of user like option)");
		System.out.println(control.userList());
		int owner = entrie2.nextInt();
		User permissions = control.searchUser(owner);
		System.out.println("What is the name of playlist? ");
		String name = entrie1.nextLine();

		System.out.println(control.newPlaylist(option, name, permissions));
		menu();


	}

	/*
	 * This method is to start the option6
	 * @param empty
	 * @return void
	 */

	public void option6() {
		System.out.println("List of Playlist");
		System.out.println("");
		System.out.println(control.listofPlaylist());
		menu();
	}

	/*
	 * This method is to start the option7
	 * @param empty
	 * @return void
	 */

	public void option7() {
		System.out.println("Adding a song to playlist");
		System.out.println("");
		System.out.println("What is the song that you like add? Write the number of the song");
		System.out.println(control.songList());
		int song = entrie2.nextInt();
		Song toAdd = control.searchSong(song);
		System.out.println("What is the playlist that you like add the song? Write the number of the playlist");
		System.out.println(control.listofPlaylist());
		int playlist = entrie2.nextInt();
		Playlist where = control.searchPlaylist(playlist);
		System.out.println(control.addsongstoPlaylist(toAdd, where));
		menu();
	}

	/*
	 * This method is to start the option8
	 * @param empty
	 * @return void
	 */

	public void option8() {
		System.out.println("Enter to playlist");
		System.out.println("");
		System.out.println("What paylist do you like enter? Write the number of playlist");
		System.out.println(control.listofPlaylist());
		int playlist = entrie2.nextInt();
		Playlist playlistS = control.searchPlaylist(playlist);
		System.out.println("Who person do you like enter? Write the number of the user");
		System.out.println(control.userList());
		int user = entrie2.nextInt();
		User userS = control.searchUser(user);
		if(control.checkPermission(userS, playlistS) == true) {
			System.out.println("The user: " + userS.getUserName() + " have access to the playlist: " + playlistS.getName());
			System.out.println(playlistS.songsPlaylist());
			if(playlistS instanceof Public) {
				Public a = (Public) playlistS;
				System.out.println("What is your valoration for that playlist?");
				double grade = Double.parseDouble(entrie1.nextLine());
				a.getGrades().add(grade);
				a.calculateAverage();
			}
		}else {
			System.out.println("The user: " + userS.getUserName() + " dont have access to the playlist: " + playlistS.getName());
		}
		menu();



	}

	/*
	 * This method is to start the option9
	 * @param empty
	 * @return void
	 */

	public void option9() {
		System.out.println("Add access to playlist");
		System.out.println("");
		System.out.println("What playlist do you like access?");
		System.out.println(control.listofPlaylist());
		int playlist = entrie2.nextInt();
		Playlist playlistS = control.searchPlaylist(playlist);
		System.out.println("Who person do you like access? Write the number of the user");
		System.out.println(control.userList());
		int user = entrie2.nextInt();
		User userS = control.searchUser(user);
		System.out.println(control.addPermision(playlistS, userS));
		menu();

	}

	/*
	 * This method is to start the option10
	 * @param empty
	 * @return void
	 */

	public void option10() {
		System.out.println("List of the songs in the playlis");
		System.out.println("");
		System.out.println("What playlist do you like?");
		System.out.println(control.listofPlaylist());
		int playlist = entrie2.nextInt();
		Playlist playlistS = control.searchPlaylist(playlist);
		System.out.println(playlistS.songsPlaylist());
		menu();
	}

}
