package musicappfiles;

public class Song {
  // create the format/attributes common to each instance of the song
  private String songName;
  private String artistName;
  private int songImg; // figure out file type of img var
  private int songLyrics; // array per line or do a feature of word break? 
                      // or automate to word break on the text area??

  public Song(String song, String artist, int pic, int lyrics) {
    songName = song; 
    artistName = artist;
    songImg = pic; 
    songLyrics = lyrics; 

  }

  public String getSongName() {
    return songName;
  }

  public String getArtistName() {
    return artistName; 
  }

  public int getSongImg() {
    return songImg; 
  }

  public int getLyrics() {
    return songLyrics;
  }
}
