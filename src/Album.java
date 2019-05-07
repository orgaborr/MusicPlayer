import java.util.ArrayList;

public class Album {
	private String albumTitle;
	ArrayList<Song> songs = new ArrayList<Song>();
	
	public Album(String albumTitle) {
		this.albumTitle = albumTitle;
	}

	public String getAlbumTitle() {
		return albumTitle;
	}
	
	public int findSong(String title) {
		for(int i=0; i<songs.size(); i++) {
			if(songs.get(i).getTitle().equalsIgnoreCase(title)) {
				return i;
			}
		}
		return -1;
	}
}
