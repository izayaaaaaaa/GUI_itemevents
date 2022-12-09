package musicappfiles;

public class lover extends Song {
  public lover() {
    setSongName("Lover");
    setArtistName("Taylor Swift");
    setImgFilepath("musicappfiles/images/editedLover.png");
    songImage = new lover.uploadImg(getImgFilepath());
  }
}
