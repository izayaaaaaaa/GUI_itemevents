package musicappfiles;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class Song {
  private String songName;
  private String artistName;
  public uploadImg songImage;
  public String songLyrics; 

  public String getSongName() {
    return songName;
  }
  public void setSongName(String newSong) {
    songName = newSong;
  }

  public String getArtistName() {
    return artistName;
  }
  public void setArtistName(String newArtist) {
    artistName = newArtist;
  }

  public uploadImg getSongImage() {
    return songImage;
  }  

  public String getSongLyrics() {
    return songLyrics;
  }  

  class uploadImg extends Component {  
    BufferedImage img;

    // place the image on the panel
    public void paint(Graphics p) {  
      p.drawImage(img, 0, 0, null);  
    }

    // gets the image that will be placed on panel
    public uploadImg(String pathfile) {  
      try {  
        img = ImageIO.read(new File(pathfile));  
      }   
      catch (IOException ex) {  
        ex.printStackTrace();  
      }  
    }
  
    // sets the dimension of the image regardless if there is an actual image
    public Dimension getPreferredSize() {
      if (img == null) {
            return new Dimension(100,100);
      } else {
          return new Dimension(img.getWidth(null), img.getHeight(null));
      }
    }
  } // uploadImg class

  public class uploadFile {
    String str;
    
    public uploadFile(String pathfile) {
      try {
        Path fileName = Path.of(pathfile);
        str = Files.readString(fileName);
      } 
      catch (IOException ex) {  
        ex.printStackTrace();  
      }  
    }
    
    public String returnStr(){
      return str;
    }
  } // uploadFile class
} // song abstract class