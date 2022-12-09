package musicappfiles;

public class balisong extends Song {
  public balisong(){
    setSongName("Balisong");
    setArtistName("Rivermaya");
    setImgFilepath("musicappfiles/images/editedBalisong.png");
    songImage = new balisong.uploadImg(getImgFilepath());
  }
}
