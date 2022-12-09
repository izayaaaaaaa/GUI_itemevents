package musicappfiles;

public class just extends Song {
  public just(){
    setSongName("Just the Same");
    setArtistName("Bruno Major");
    setImgFilepath("musicappfiles/images/editedJust.png");
    songImage = new just.uploadImg(getImgFilepath());
  }
}
