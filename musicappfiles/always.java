package musicappfiles;

public class always extends Song {
  public always(){
    setSongName("Always");
    setArtistName("Tim Halperin");
    setImgFilepath("musicappfiles/images/editedAlways.png");
    songImage = new always.uploadImg(getImgFilepath());
  }
}
