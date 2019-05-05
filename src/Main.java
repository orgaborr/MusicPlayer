import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {
		Album awesome1 = new Album("Awesome Mix Vol.1");
		Album awesome2 = new Album("Awesome Mix Vol.2");
		
		awesome1.songs.add(new Song("Hooked On A Feeling", 2.05));
		awesome1.songs.add(new Song("Walking On Sunshine", 3.10));
		awesome1.songs.add(new Song("Thunderstruck", 3.24));
		
		awesome2.songs.add(new Song("Satisfaction", 2.13));
		awesome2.songs.add(new Song("Polly", 1.54));
		awesome2.songs.add(new Song("Black Dog", 4.11));
		
		listSongs(awesome1);
		listSongs(awesome2);
	}
	
	public static void listSongs(Album album) {
		System.out.println("Album: " + album.getAlbumTitle());
		for(int i=0; i<album.songs.size(); i++) {
			System.out.println((i+1) + ". " + album.songs.get(i).getTitle());
		}
	}

}
