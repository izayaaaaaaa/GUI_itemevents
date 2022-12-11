package musicappfiles;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
  
import com.formdev.flatlaf.FlatLightLaf;

public class SongLyricsApp extends JFrame {
  private static SongLyricsApp firstInstance = null;
  


  private SongLyricsApp() {
    FlatLightLaf.setup();

    // =============================Instantiation==============================
    Song song1 = new always();
    Song song2 = new balisong();
    Song song3 = new just();
    Song song4 = new lover();
    Song song5 = new those(); 

    JPanel songLyricsP, songListnDetailsP, songStyleP;

    JTextArea songLyricsTF;
    // default lyrics is the first song
    String lyrics = song1.getSongLyrics();

    JPanel songDetailsP, songInfoP, songPhotoP, songListP;
    JLabel songNameL, songArtistL;
    String [] songTitleStr;

    JPanel songPlaylistP, songStylingP;
    JLabel playlistName, playlistImg;
    JButton fontSize, fontStyle;

    // ============================= MAIN LAYOUT ==============================
    songLyricsP = new JPanel();
    songListnDetailsP = new JPanel(new BorderLayout());
    songStyleP = new JPanel(new BorderLayout());

    // ============================Song Lyrics Panel============================
    songLyricsTF = new JTextArea(lyrics, 35, 50);

    // set fixed size of panel
    // transparent song lyrics bg?
    // variable based display text of text area

    songLyricsP.add(songLyricsTF);

    // =======================Song List and Detail Panel========================
    // song details panel (CENTER)
    songDetailsP = new JPanel(new BorderLayout());

    songInfoP = new JPanel(new BorderLayout());
    songNameL = new JLabel(song1.getSongName());
    songArtistL = new JLabel(song1.getArtistName());

    songInfoP.add(songNameL, BorderLayout.CENTER);
    songInfoP.add(songArtistL, BorderLayout.SOUTH);

    songPhotoP = new JPanel();

    songDetailsP.add(songInfoP, BorderLayout.CENTER);
    songDetailsP.add(songPhotoP, BorderLayout.WEST);

    songListP = new JPanel();
    songTitleStr = new String[] {song1.getSongName(), song2.getSongName(), song3.getSongName(), song4.getSongName(), song5.getSongName()};

    JComboBox<String> songListCB = new JComboBox<>(songTitleStr);

    songListP.add(songListCB);

    songListCB.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {
          if(songListCB.getSelectedItem() == song2.getSongName()) {
            songNameL.setText(song2.getSongName());
            songArtistL.setText(song2.getArtistName());
            songLyricsTF.setText(song2.getSongLyrics());
          }
          else if(songListCB.getSelectedItem() == song3.getSongName()) {
            songNameL.setText(song3.getSongName());
            songArtistL.setText(song3.getArtistName());
            songLyricsTF.setText(song3.getSongLyrics());
          }
          else if(songListCB.getSelectedItem() == song4.getSongName()) {
            songNameL.setText(song4.getSongName());
            songArtistL.setText(song4.getArtistName());
            songLyricsTF.setText(song4.getSongLyrics());
          }
          else if(songListCB.getSelectedItem() == song5.getSongName()) {
            songNameL.setText(song5.getSongName());
            songArtistL.setText(song5.getArtistName());
            songLyricsTF.setText(song5.getSongLyrics());
          }
          else {
            songNameL.setText(song1.getSongName());
            songArtistL.setText(song1.getArtistName());
            songLyricsTF.setText(song1.getSongLyrics());
          }
        } 
      }
    });

    songListnDetailsP.add(songDetailsP, BorderLayout.CENTER);
    songListnDetailsP.add(songListP, BorderLayout.NORTH);

    // ========================Additional Styling Panel========================
    songPlaylistP = new JPanel(new BorderLayout());
    playlistName = new JLabel("tester playlist name");
    playlistImg = new JLabel("tester playlist img");
    // include a song playlist title with picture

    songPlaylistP.add(playlistName, BorderLayout.CENTER);
    songPlaylistP.add(playlistImg, BorderLayout.WEST);

    songStylingP = new JPanel();
    fontSize = new JButton("tester font size");
    fontStyle = new JButton("tester font style");
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

