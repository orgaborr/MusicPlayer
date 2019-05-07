import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	
	public static ArrayList<Album> myAlbums = new ArrayList<Album>();
	public static LinkedList<Song> playList = new LinkedList<Song>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Album awesome1 = new Album("Awesome Mix Vol.1");
		Album awesome2 = new Album("Awesome Mix Vol.2");
		myAlbums.add(awesome1);
		myAlbums.add(awesome2);
		
		awesome1.songs.add(new Song("Hooked On A Feeling", 2.05));
		awesome1.songs.add(new Song("Walking On Sunshine", 3.10));
		awesome1.songs.add(new Song("Thunderstruck", 3.24));
		
		awesome2.songs.add(new Song("Satisfaction", 2.13));
		awesome2.songs.add(new Song("Polly", 1.54));
		awesome2.songs.add(new Song("Black Dog", 4.11));
		
		ListIterator<Song> listIt = playList.listIterator();
		boolean forward = true;
		boolean quit = false;
		boolean flag = true;
		
		displayInstructions();
		
		while(!quit) {
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 0:
				quit = true;
				break;
			case 1:
				displayInstructions();
				break;
			case 2:
				listMySongs();
				break;
			case 3:
				if(playList.isEmpty()) {
					System.out.println("No tracks in the playlist");
					break;
				}
				listPlayList();
				break;
			case 4:
				System.out.println("Type song's title to add: ");
				String title = sc.nextLine();
				addSong(title);
				break;
			case 5:
				if(playList.isEmpty()) {
					System.out.println("No tracks in the playlist");
					break;
				}
				if(flag == true) {
					listIt = playList.listIterator(0);
					flag = false;
				}
				if(!forward) {
					if(listIt.hasNext()) {
						listIt.next();
					}
					forward = true;
				}
				if(listIt.hasNext()) {
					Song current = listIt.next();
					System.out.println("Now playing Track " + (playList.indexOf(current)+1)+ ": "+
							current.getTitle());
				} else {
					System.out.println("Reached the end of the tracklist");
					forward = false;
				}
				break;
			case 6:
				if(playList.isEmpty()) {
					System.out.println("No tracks in the playlist");
					break;
				}
				if(forward) {
					if(listIt.hasPrevious()) {
						listIt.previous();
					}
					forward = false;
				}
				if(listIt.hasPrevious()) {
					Song current = listIt.previous();
					System.out.println("Now playing Track " + (playList.indexOf(current)+1)+ ": "+
							current.getTitle());
				} else {
					System.out.println("Reached start of the tracklist");
					forward = true;
				}
				break;
			case 7:
				if(playList.isEmpty()) {
					System.out.println("No tracks in the playlist");
					break;
				}
				if(flag == true) {
					listIt = playList.listIterator(0);
					flag = false;
				}
				if(!forward) {
					if(listIt.hasNext()) {
						listIt.next();
					}
					forward = true;
				}
				if(listIt.hasPrevious()) {
					Song current = listIt.previous();
					System.out.println("Replaying Track " + (playList.indexOf(current)+1)+ ": "+
							current.getTitle());
					listIt.next();
					
				} else {
					System.out.println("No song played previously");
				}
				break;
			case 8:
				System.out.println("Type song's title to remove: ");
				String removeTitle = sc.nextLine();
				removeSong(removeTitle);
				break;
			case 9:
				addAll();
				System.out.println("All songs added to playlist");
				break;
			}
		}


		sc.close();
	}
	
	public static void displayInstructions() {
		System.out.println("Choose from the following actions: \n"
				+ "0 - Quit\n"
				+ "1 - Display instructions\n"
				+ "2 - List my songs\n"
				+ "3 - Show playlist\n"
				+ "4 - Add song to playlist\n"
				+ "5 - Play next song\n"
				+ "6 - Play previous song\n"
				+ "7 - Replay song\n"
				+ "8 - Remove song from playlist\n"
				+ "9 - Add all songs to playlist");
	}
	
	public static void listMySongs() {
		Iterator<Album> it = myAlbums.iterator();
		while(it.hasNext()) {
			Album nextAlbum = it.next();
			System.out.println("Album: " + nextAlbum.getAlbumTitle());
			
			for(int i=0; i<nextAlbum.songs.size(); i++) {
				System.out.println((i+1) + ". " + nextAlbum.songs.get(i).getTitle() +
						", " + nextAlbum.songs.get(i).getDuration());
			}
		}
	}
	
	public static boolean addSong(String title) {
		if(songIsInList(title)) {
			System.out.println("Song is already in the playlist");
			return false;
		}
				
		Iterator<Album> it = myAlbums.iterator();
		while(it.hasNext()) {
			Album nextAlbum = it.next();
			
			if(nextAlbum.findSong(title) >= 0) {
				int songNumber = nextAlbum.findSong(title);
				playList.add(nextAlbum.songs.get(songNumber));
				
				System.out.println(nextAlbum.songs.get(songNumber).getTitle() +
						" added to playlist");
				return true;
			}
		}

		System.out.println("Song not found");
		return false;
	}
	
	public static boolean removeSong(String title) {
		if(songIsInList(title)) {
			Iterator<Song> it = playList.iterator();
			while(it.hasNext()) {
				Song next = it.next();
				
				if(next.getTitle().equalsIgnoreCase(title)) {
					playList.remove(next);
					System.out.println(title + " removed from list");
					return true;
				}
			}
		}
		
		System.out.println("Song is not in the list");
		return false;
	}
	
	public static boolean songIsInList(String title) {
		Iterator<Song> songIt = playList.iterator();
		while(songIt.hasNext()) {
			if(songIt.next().getTitle().equalsIgnoreCase(title)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void listPlayList() {
		Iterator<Song> it = playList.iterator();
		int number = 1;
		while(it.hasNext()) {
			Song nextSong = it.next();
			System.out.println(number + ". " + nextSong.getTitle() + ", " +
			nextSong.getDuration());
			number++;
		}	
	}
	
	public static void addAll() {
		Iterator<Album> it = myAlbums.iterator();
		while(it.hasNext()) {
			Album nextAlbum = it.next();
			for(int i=0; i<nextAlbum.songs.size(); i++) {
				if(!songIsInList(nextAlbum.songs.get(i).getTitle()))
				playList.add(nextAlbum.songs.get(i));
			}
		}
	}
	
}
