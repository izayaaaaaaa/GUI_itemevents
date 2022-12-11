package musicappfiles;

public class just extends Song {
  public just(){
    setSongName("Just the Same");
    setArtistName("Bruno Major");
    songImage = new uploadImg("musicappfiles/images/editedJust.png");
    songLyrics = new uploadFile("musicappfiles/lyrics/just.txt").returnStr();
  }
}
