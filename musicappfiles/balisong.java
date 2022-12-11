package musicappfiles;

public class balisong extends Song {
  public balisong(){
    setSongName("Balisong");
    setArtistName("Rivermaya");
    songImage = new uploadImg("musicappfiles/images/editedBalisong.png");
    songLyrics = new uploadFile("musicappfiles/lyrics/balisong.txt").returnStr();
  }
}
