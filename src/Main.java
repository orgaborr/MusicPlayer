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
		
		listMySongs();
		
		
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
	
	public static boolean addSong(String album, String title) {
		
	}

}
