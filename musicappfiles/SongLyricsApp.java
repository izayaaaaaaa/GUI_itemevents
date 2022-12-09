package musicappfiles;

import java.awt.*;
// import java.awt.image.BufferedImage;

import javax.swing.*;
// import javax.imageio.ImageIO; 
  
// import java.io.*;  

// import musicappfiles.Song;
 
// WHY IS THE ADDED THING EMPY COMPONENT ??? WHY

import com.formdev.flatlaf.FlatLightLaf;

public class SongLyricsApp extends JFrame {
  private static SongLyricsApp firstInstance = null;

  private SongLyricsApp() {
    FlatLightLaf.setup();

    // =======================Song Object Instantiation========================
    Song song1 = new always();
    Song song2 = new balisong();
    Song song3 = new just();
    Song song4 = new lover();
    Song song5 = new those(); 

    // ============================= MAIN LAYOUT ==============================
    JPanel songLyricsP = new JPanel();
    JPanel songListnDetailsP = new JPanel(new BorderLayout());
    JPanel songStyleP = new JPanel(new BorderLayout());

    // ============================Song Lyrics Panel============================
    JTextArea songLyricsTF = new JTextArea("test", 35, 50);

    // set fixed size of panel
    // transparent song lyrics bg?
    // variable based display text of text area

    songLyricsP.add(songLyricsTF);

    // =======================Song List and Detail Panel========================
    // song details panel (CENTER)
    JPanel songDetailsP = new JPanel(new BorderLayout());

    JPanel songInfoP = new JPanel(new BorderLayout());
    JLabel songNameL = new JLabel("tester name");
    JLabel songArtistL = new JLabel("tester artist");

    songInfoP.add(songNameL, BorderLayout.CENTER);
    songInfoP.add(songArtistL, BorderLayout.SOUTH);

    JPanel songPhotoP = new JPanel();
    // songPhotoP.add("tester image");

    songDetailsP.add(songInfoP, BorderLayout.CENTER);
    songDetailsP.add(songPhotoP, BorderLayout.WEST);

    JPanel songListP = new JPanel();
    String[] songTitleS = new String[] {song1.getSongName(), song2.getSongName(), song3.getSongName(), song4.getSongName(), song5.getSongName()};

    JComboBox<String> songListCB = new JComboBox<>(songTitleS);

    songListP.add(songListCB);

    songListnDetailsP.add(songDetailsP, BorderLayout.CENTER);
    songListnDetailsP.add(songListP, BorderLayout.NORTH);

    // ========================Additional Styling Panel========================
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
    // ============================ Setup the Frame ============================
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

  // ensures that only one instance of the songlyricsapp will ever be created
  public static SongLyricsApp getInstance() {
    if(firstInstance == null) {
      firstInstance = new SongLyricsApp();
    }

    return firstInstance;
  }

  public static void main(String[] args) {
    SongLyricsApp.getInstance();
    
    
  }
}

