// IMAGES AND TEXT FILES AREN'T RENDERING ON NETBEANS???
// FIX THE OVERALL STYLE/UI
package musicappfiles;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
  
import com.formdev.flatlaf.FlatLightLaf;

import musicappfiles.Song.uploadImg;

public class SongLyricsApp extends JFrame {
  // ================================== Variable Instantiation ===================================
  private static SongLyricsApp firstInstance = null;

  Song song1 = new always();
  Song song2 = new balisong();
  Song song3 = new just();
  Song song4 = new lover();
  Song song5 = new those();

  // Default Font Properties
  int fontStyle = 0; // plain is 0, bold is 1, italics is 2
  int fontSize = 14;
  Font font = new Font("Times New Roman", fontStyle, fontSize);

  // Panels of Main Frame
  JPanel songLyricsP, songListnDetailsP, songStyleP;

  // songLyrics Panel
  String lyrics;
  JTextArea songLyricsTF;

  // songListnDetails Panel
  JPanel songDetailsP, songListP; 

  JPanel songInfoP; 
  JLabel songNameL, songArtistL; 
  JPanel songPhotoP;
  uploadImg songPhoto;

  String [] songTitleStr; 
  JComboBox<String> songListCB;

  // songStyle Panel
  JPanel songPlaylistP, songStylingP; 

  JPanel playlistDetailsP;
  JLabel playlistName, playlistDesc;
  JLabel playlistImg;
  
  JPanel radioBoxP, checkBoxP;

  JLabel fontSizeL;
  ButtonGroup fontSizeGrp;
  JRadioButton smallButton, mediumButton, largeButton;

  JLabel fontStyleL; 
  JCheckBox normalButton, boldButton, italicButton;
  
  private SongLyricsApp() { // SongLyricsApp Constructor
    FlatLightLaf.setup();

    songLyricsP = new JPanel();
    songListnDetailsP = new JPanel(new BorderLayout());
    songStyleP = new JPanel(new BorderLayout());

    // ======================================== songLyrics Panel =========================================
    lyrics = song1.getSongLyrics();
    songLyricsTF = new JTextArea(lyrics, 35, 50);
    songLyricsTF.setFont(font);

    // set fixed size of panel
    // transparent song lyrics bg?
    // variable based display text of text area
    // SHOULD NOT BE EDITABLE

    songLyricsP.add(songLyricsTF);

    // ======================================== songListnDetails Panel =========================================
    songDetailsP = new JPanel(new BorderLayout());

    songInfoP = new JPanel(new BorderLayout());
    songNameL = new JLabel(song1.getSongName());
    songArtistL = new JLabel(song1.getArtistName());

    songPhotoP = new JPanel();
    songPhoto = song1.songImage;
    
    songListP = new JPanel();
    songTitleStr = new String[] {song1.getSongName(), song2.getSongName(), song3.getSongName(), song4.getSongName(), song5.getSongName()};

    songListCB = new JComboBox<>(songTitleStr);
    
    songListCB.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {
          if(songListCB.getSelectedItem() == song2.getSongName()) {
            songNameL.setText(song2.getSongName());
            songArtistL.setText(song2.getArtistName());
            songLyricsTF.setText(song2.getSongLyrics());
            changeSongPic(song2.songImage);
          }
          else if(songListCB.getSelectedItem() == song3.getSongName()) {
            songNameL.setText(song3.getSongName());
            songArtistL.setText(song3.getArtistName());
            songLyricsTF.setText(song3.getSongLyrics());
            changeSongPic(song3.songImage);
          }
          else if(songListCB.getSelectedItem() == song4.getSongName()) {
            songNameL.setText(song4.getSongName());
            songArtistL.setText(song4.getArtistName());
            songLyricsTF.setText(song4.getSongLyrics());
            changeSongPic(song4.songImage);
          }
          else if(songListCB.getSelectedItem() == song5.getSongName()) {
            songNameL.setText(song5.getSongName());
            songArtistL.setText(song5.getArtistName());
            songLyricsTF.setText(song5.getSongLyrics());
            changeSongPic(song5.songImage);
          }
          else {
            songNameL.setText(song1.getSongName());
            songArtistL.setText(song1.getArtistName());
            songLyricsTF.setText(song1.getSongLyrics());
            changeSongPic(song1.songImage);
          }
        } 
      }
    }); // songListCB itemlistener

    songInfoP.add(songNameL, BorderLayout.CENTER);
    songInfoP.add(songArtistL, BorderLayout.SOUTH);
    songPhotoP.add(songPhoto);
    songDetailsP.add(songInfoP, BorderLayout.CENTER);
    songDetailsP.add(songPhotoP, BorderLayout.WEST);
    
    songListP.add(songListCB);

    songListnDetailsP.add(songDetailsP, BorderLayout.CENTER);
    songListnDetailsP.add(songListP, BorderLayout.NORTH);

    // ======================================== songStyle Panel =========================================
    songPlaylistP = new JPanel(new BorderLayout());
    
    playlistDetailsP = new JPanel(new BorderLayout());
    playlistName = new JLabel("Always");
    playlistDesc = new JLabel("Created by: Francyn Macadangdang");
    
    playlistImg = new JLabel("tester playlist img"); // use the icon component?

    songStylingP = new JPanel();
    // ADD THE STUPID BUTTON EVENT LISTENERS
    radioBoxP = new JPanel(new GridLayout(0, 1));
    fontSizeL = new JLabel("Font Size"); 
    fontSizeGrp = new ButtonGroup();
    smallButton = new JRadioButton("Small");
    smallButton.setSelected(true);
    mediumButton = new JRadioButton("Medium");
    largeButton = new JRadioButton("Large");

    fontSizeGrp.add(smallButton);
    fontSizeGrp.add(mediumButton);
    fontSizeGrp.add(largeButton);
    
    ActionListener fontSizeListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if(e.getSource() == smallButton) {
          changeFont(14);
        }
        else if(e.getSource() == mediumButton) {
          changeFont(16);
        }
        else if (e.getSource() == largeButton) {
          changeFont(18);
        }
      }
    };

    smallButton.addActionListener(fontSizeListener);
    mediumButton.addActionListener(fontSizeListener);
    largeButton.addActionListener(fontSizeListener);

    checkBoxP = new JPanel(new GridLayout(0, 1)); 
    fontStyleL = new JLabel("Font Style");
    normalButton = new JCheckBox("Normal");
    normalButton.setSelected(true);
    boldButton = new JCheckBox("Bold");
    italicButton = new JCheckBox("Italic");

    ItemListener fontStyleListener = new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {
          if(e.getSource() == normalButton) {
            boldButton.setSelected(false);
            italicButton.setSelected(false);
            changeFont(0);
          }
          if(e.getSource() == boldButton) {
            normalButton.setSelected(false);
            changeFont(1);
          }
          if(e.getSource() == italicButton) {
            normalButton.setSelected(false);
            changeFont(2);
          }
        }

        if(boldButton.isSelected() == true && italicButton.isSelected() == true) {
          fontStyle = 1 | 2; // two styles are applied at the same time
          font = new Font("Times New Roman", fontStyle, fontSize);
          songLyricsTF.setFont(font); 
        }

        if(e.getStateChange() == ItemEvent.DESELECTED) {
          if(e.getSource() == boldButton) {
            if(italicButton.isSelected() == true) {
              changeFont(2);
            } else {
              changeFont(0);
            }
            
          }
          if(e.getSource() == italicButton) {
            if(boldButton.isSelected() == true) {
              changeFont(1);
            } else {
              changeFont(0);
            }
          }

          if(normalButton.isSelected() == false && boldButton.isSelected() == false && italicButton.isSelected() == false) {
            normalButton.setSelected(true);
          }
        }
      }
    }; // fontStyleListener

    normalButton.addItemListener(fontStyleListener);
    boldButton.addItemListener(fontStyleListener);
    italicButton.addItemListener(fontStyleListener);
    
    playlistDetailsP.add(playlistName, BorderLayout.CENTER);
    playlistDetailsP.add(playlistDesc, BorderLayout.SOUTH);
    songPlaylistP.add(playlistDetailsP, BorderLayout.CENTER);
    songPlaylistP.add(playlistImg, BorderLayout.WEST);

    radioBoxP.add(fontSizeL);
    radioBoxP.add(smallButton);
    radioBoxP.add(mediumButton);
    radioBoxP.add(largeButton); 
    checkBoxP.add(fontStyleL);
    checkBoxP.add(normalButton);
    checkBoxP.add(boldButton);
    checkBoxP.add(italicButton);
    songStylingP.add(radioBoxP);
    songStylingP.add(checkBoxP);

    songStyleP.add(songPlaylistP, BorderLayout.CENTER);
    songStyleP.add(songStylingP, BorderLayout.EAST);
    
    // ======================================== SETUP THE FRAME =========================================
    add(songLyricsP, BorderLayout.CENTER);
    add(songListnDetailsP, BorderLayout.NORTH);
    add(songStyleP, BorderLayout.SOUTH);

    pack();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // setResizable(false);
    setVisible(true);
  } // SongLyricsApp constructor

  // ensures that only one instance of the songlyricsapp will ever be created
  public static SongLyricsApp getInstance() {
    if(firstInstance == null) {
      firstInstance = new SongLyricsApp();
    }

    return firstInstance;
  }

  public void changeFont(int change) {
    if(change == 14) {
      fontSize = 14; 
    } else if (change == 16) {
      fontSize = 16; 
    } else if (change == 18) {
      fontSize = 18;
    } 

    else if (change == 0) {
      fontStyle = 0;
    } else if (change == 1) {
      fontStyle = 1; 
    } else if (change == 2) {
      fontStyle = 2; 
    }

    font = new Font("Times New Roman", fontStyle, fontSize);
    songLyricsTF.setFont(font);
  }

  public void changeSongPic(uploadImg songVer) {
    songPhotoP.remove(songPhoto);
    songPhoto = songVer;
    songPhotoP.add(songPhoto);
  }

  public static void main(String[] args) {
    SongLyricsApp.getInstance();
  }
} // SongLyricsApp Constructor

