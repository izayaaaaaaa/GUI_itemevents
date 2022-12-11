package musicappfiles;

public class always extends Song {
  public always(){
    setSongName("Always");
    setArtistName("Tim Halperin");
    songImage = new uploadImg("musicappfiles/images/editedAlways.png");
    songLyrics = new uploadFile("musicappfiles/lyrics/always.txt").returnStr();
  }
}
