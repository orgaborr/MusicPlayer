import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

public class Main {
	
	public static ArrayList<Album> myAlbums = new ArrayList<Album>();
	public static LinkedList<Song> playList = new LinkedList<Song>();

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
		
//		listMySongs();
		
		addSong("thunderstruck");
		addSong("Thunderstruck");
		addSong("Polly");
		addSong("Pretender");
		
//		removeSong("Polly");
//		removeSong("Pretender");
		
		listPlayList();
		
		displayInstructions();
		
		
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
				+ "8 - Remove song from playlist");
	}
	
	public static void listMySongs() {
		Iterator<Album> it = myAlbums.iterator();
		while(it.hasNext()) {
			Album nextAlbum = it.next();
			System.out.println("Album: " + nextAlbum.getAlbumTitle());
			
			for(int j=0; j<nextAlbum.songs.size(); j++) {
				System.out.println((j+1) + ". " + nextAlbum.songs.get(j).getTitle() +
						", " + nextAlbum.songs.get(j).getDuration());
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

}
