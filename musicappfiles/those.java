package musicappfiles;

public class those extends Song {
  public those() {
    setSongName("Those Eyes");
    setArtistName("New West");
    songImage = new uploadImg("musicappfiles/images/editedThose.png");
    songLyrics = new uploadFile("musicappfiles/lyrics/those.txt").returnStr();

  }  
}
