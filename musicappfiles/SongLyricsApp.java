package musicappfiles;

import java.awt.*;
import javax.swing.*;

public class SongLyricsApp extends JFrame {
  public SongLyricsApp() {
    JPanel songLyricsP = new JPanel(); 
    JPanel songListnDetailsP = new JPanel(new BorderLayout());
    JPanel songStyleP = new JPanel(new BorderLayout());  

    // Songs
    String test = "tester song lyrics";

    // LEARN HOW TO CONSTRUCT THE LYRICS CHANGER 

    //============================Song Lyrics Panel============================
    JTextArea songLyricsTF = new JTextArea(test, 35, 50);
    
    // set fixed size of panel
    // transparent song lyrics bg?
    // variable based display text of text area

    songLyricsP.add(songLyricsTF);

    //=======================Song List and Detail Panel========================
      // song details panel (CENTER) 
    JPanel songDetailsP = new JPanel(new BorderLayout());
      
      JPanel songInfoP = new JPanel(new BorderLayout());
        JLabel songNameL = new JLabel("tester song name");
        JLabel songArtistL = new JLabel("tester song artist");

        songInfoP.add(songNameL, BorderLayout.CENTER);
        songInfoP.add(songArtistL, BorderLayout.SOUTH);

      JPanel songPhotoP = new JPanel();
        JLabel songImg = new JLabel("tester song image");
        // https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel

        songPhotoP.add(songImg);

      songDetailsP.add(songInfoP, BorderLayout.CENTER);
      songDetailsP.add(songPhotoP, BorderLayout.WEST);
      
    JPanel songListP = new JPanel();

      JComboBox songListCB = new JComboBox<>();

      songListP.add(songListCB);
    
    songListnDetailsP.add(songDetailsP, BorderLayout.CENTER);
    songListnDetailsP.add(songListP, BorderLayout.NORTH); 

    //========================Additional Styling Panel========================
    JPanel songPlaylistP = new JPanel(new BorderLayout());
      JLabel playlistName = new JLabel("tester playlist name");
      JLabel playlistImg = new JLabel("tester playlist img");
      // include a song playlist title with picture 

      songPlaylistP.add(playlistName, BorderLayout.CENTER);
      songPlaylistP.add(playlistImg, BorderLayout.WEST);

    JPanel songStylingP = new JPanel();
      JButton fontSize = new JButton("tester font size");
      JButton fontStyle = new JButton("tester font style");
      // pop up box through an icon/button 
      // figure out this part!!!
      
      songStylingP.add(fontSize);
      songStylingP.add(fontStyle);

    songStyleP.add(songPlaylistP, BorderLayout.CENTER);
    songStyleP.add(songStylingP, BorderLayout.EAST);
    //============================ Setup the Frame ============================
    
    // ============================ test visibilty of panels 
    setBackground(Color.black); 
    songLyricsP.setBackground(Color.red);

    songListnDetailsP.setBackground(Color.yellow);
    songDetailsP.setBackground(Color.pink);
    songListP.setBackground(Color.black);

    songStyleP.setBackground(Color.green);

    // test visibilty of panels ============================

    add(songLyricsP, BorderLayout.CENTER);
    add(songListnDetailsP, BorderLayout.NORTH);
    add(songStyleP, BorderLayout.SOUTH);

    pack();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    // setResizable(false);
    setVisible(true);
  }
  
  public static void main(String[] args) {
    // Song alexandra = new Song("test", "test", 0, 1);
    // RESUME HERE... modify the line below; put into a var
    new SongLyricsApp();
  }
}