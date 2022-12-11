package musicappfiles;

public class lover extends Song {
  public lover() {
    setSongName("Lover");
    setArtistName("Taylor Swift");
    songImage = new uploadImg("musicappfiles/images/editedLover.png");
    songLyrics = new uploadFile("musicappfiles/lyrics/lover.txt").returnStr();
  }
}
