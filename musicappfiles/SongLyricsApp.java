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

    // ============================= MAIN LAYOUT ==============================
    JPanel songLyricsP = new JPanel();
    JPanel songListnDetailsP = new JPanel(new BorderLayout());
    JPanel songStyleP = new JPanel(new BorderLayout());

    // ============================Song Lyrics Panel============================
    String lyrics = song1.getSongLyrics();
    JTextArea songLyricsTF = new JTextArea(lyrics, 35, 50);

    // set fixed size of panel
    // transparent song lyrics bg?
    // variable based display text of text area
    // SHOULD NOT BE EDITABLE

    songLyricsP.add(songLyricsTF);

    // =======================Song List and Detail Panel========================
    // song details panel (CENTER)
    JPanel songDetailsP = new JPanel(new BorderLayout());

    JPanel songInfoP = new JPanel(new BorderLayout());
    JLabel songNameL = new JLabel(song1.getSongName());
    JLabel songArtistL = new JLabel(song1.getArtistName());

    songInfoP.add(songNameL, BorderLayout.CENTER);
    songInfoP.add(songArtistL, BorderLayout.SOUTH);

    JPanel songPhotoP = new JPanel();
    songPhotoP.add(song1.songImage);
    // how to change the image dependent on combobox selected
    // resume here!!
    // change the parameter for the uploadimg instantiation???
    //  orrr use only one variable (perhaps static) for the songimage var of Song abstract class 
    //      then change the filepath dependent on the combobox item selected

    songDetailsP.add(songInfoP, BorderLayout.CENTER);
    songDetailsP.add(songPhotoP, BorderLayout.WEST);

    JPanel songListP = new JPanel();
    String [] songTitleStr = new String[] {song1.getSongName(), song2.getSongName(), song3.getSongName(), song4.getSongName(), song5.getSongName()};

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
    JPanel songPlaylistP = new JPanel(new BorderLayout());
    // create panel for desc and playlist name with name as center and desc as south
    JLabel playlistName = new JLabel("Always");
    JLabel playlistImg = new JLabel("tester playlist img"); // use the icon component?
    // JLabel playlistDesc = new JLabel("Created by: Francyn Macadangdang");

    songPlaylistP.add(playlistName, BorderLayout.CENTER);
    songPlaylistP.add(playlistImg, BorderLayout.WEST);
    // songPlaylistP.add(playlistDesc, BorderLayout.SOUTH);

    JPanel songStylingP = new JPanel();
    // ADD THE STUPID BUTTON EVENT LISTENERS

    JPanel radioBoxP = new JPanel(new GridLayout(0, 1));
    JLabel fontSizeL = new JLabel("Font Size"); 
    ButtonGroup fontSizeGrp = new ButtonGroup();
    JRadioButton smallButton = new JRadioButton("Small");
    JRadioButton mediumButton = new JRadioButton("Medium");
    JRadioButton largeButton = new JRadioButton("Large");
    
    fontSizeGrp.add(smallButton);
    fontSizeGrp.add(mediumButton);
    fontSizeGrp.add(largeButton);
    radioBoxP.add(fontSizeL);
    radioBoxP.add(smallButton);
    radioBoxP.add(mediumButton);
    radioBoxP.add(largeButton); 

    JPanel checkBoxP = new JPanel(new GridLayout(0, 1)); 
    JLabel fontStyleL = new JLabel("Font Style");
    JCheckBox normalButton = new JCheckBox("Normal");
    JCheckBox boldButton = new JCheckBox("Bold");
    JCheckBox italicButton = new JCheckBox("Italic");

    checkBoxP.add(fontStyleL);
    checkBoxP.add(normalButton);
    checkBoxP.add(boldButton);
    checkBoxP.add(italicButton);

    songStylingP.add(radioBoxP);
    songStylingP.add(checkBoxP);

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

