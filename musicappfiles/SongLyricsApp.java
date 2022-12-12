// IMAGES AND TEXT FILES AREN'T RENDERING ON NETBEANS???
// ADD SCROLL BAR; SETTLE FOR A FIXED SIZE FOR THE TEXT AREA, 
package musicappfiles;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.*;

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
  int fontSize = 12;
  Font textArea = new Font("Arial", fontStyle, fontSize);

  // Panels of Main Frame
  JPanel songLyricsP, songListnDetailsP, songStyleP;

  // songLyrics Panel
  String lyrics;
  JTextArea songLyricsTF;
  JScrollPane songScroll;

  // songListnDetails Panel
  JPanel songDetailsP, songListP; 

  JPanel songInfoP; 
  JLabel songNameL, songArtistL; 
  JPanel songPhotoP;
  uploadImg songPhoto;

  String [] songTitleStr; 
  JComboBox<String> songListCB;

  // songStyle Panel
  JPanel songStylingP; 
  
  JPanel radioBoxP, checkBoxP;

  JLabel fontSizeL;
  ButtonGroup fontSizeGrp;
  JRadioButton smallButton, mediumButton, largeButton;

  JLabel fontStyleL; 
  JCheckBox normalButton, boldButton, italicButton;
  
  private SongLyricsApp() { // SongLyricsApp Constructor
    FlatGitHubDarkContrastIJTheme.setup();

    songLyricsP = new JPanel(new BorderLayout());
    songListnDetailsP = new JPanel(new BorderLayout());
    songStyleP = new JPanel(new BorderLayout());

    songLyricsP.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 50));
    songLyricsP.setPreferredSize(new Dimension(600, 700));

    songListnDetailsP.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
    songStyleP.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

    // ======================================== songLyrics Panel =========================================
    lyrics = song1.getSongLyrics();
    songLyricsTF = new JTextArea(lyrics);

    songLyricsTF.setFont(textArea);
    songLyricsTF.setEditable(false);
    // scroll pane should have size that adjusts; transparent vertical scroll; no horizontal scroll
    // songScroll = new JScrollPane(songLyricsTF);
    // songScroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
    // text spacing?

    // songLyricsP.add(songScroll, BorderLayout.EAST);
    songLyricsP.add(songLyricsTF, BorderLayout.EAST);
    // ======================================== songListnDetails Panel =========================================
    // =========== definition
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

    // =========== customization
    songNameL.setFont(new Font("Verdana", 1, 16));
    songArtistL.setFont(new Font("Verdana", 0, 12));

    songNameL.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
    songArtistL.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
    songPhotoP.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));


    songInfoP.add(songNameL, BorderLayout.CENTER);
    songInfoP.add(songArtistL, BorderLayout.SOUTH);
    songPhotoP.add(songPhoto);
    songDetailsP.add(songInfoP, BorderLayout.CENTER);
    songDetailsP.add(songPhotoP, BorderLayout.WEST);
    
    songListP.add(songListCB);

    songListnDetailsP.add(songDetailsP, BorderLayout.CENTER);
    songListnDetailsP.add(songListP, BorderLayout.NORTH);

    // ======================================== songStyle Panel =========================================
    songStylingP = new JPanel();
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
          changeFont(12);
        }
        else if(e.getSource() == mediumButton) {
          changeFont(14);
        }
        else if (e.getSource() == largeButton) {
          changeFont(16);
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
          textArea = new Font("Times New Roman", fontStyle, fontSize);
          songLyricsTF.setFont(textArea); 
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

    songStyleP.add(songStylingP, BorderLayout.WEST);
    
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

  private void changeFont(int change) {
    if(change == 12) {
      fontSize = 12; 
    } else if (change == 14) {
      fontSize = 14; 
    } else if (change == 16) {
      fontSize = 16;
    } 

    else if (change == 0) {
      fontStyle = 0;
    } else if (change == 1) {
      fontStyle = 1; 
    } else if (change == 2) {
      fontStyle = 2; 
    }

    textArea = new Font("Times New Roman", fontStyle, fontSize);
    songLyricsTF.setFont(textArea);
  }

  private void changeSongPic(uploadImg songVer) {
    songPhotoP.remove(songPhoto);
    songPhoto = songVer;
    songPhotoP.add(songPhoto);
  }

  public static void main(String[] args) {
    SongLyricsApp.getInstance();
  }
} // SongLyricsApp Constructor

class uploadPic extends Component {  
  BufferedImage img;

  // place the image on the panel
  public void paint(Graphics p) {  
    p.drawImage(img, 0, 0, null);  
  }

  // gets the image that will be placed on panel
  public uploadPic(String pathfile) {  
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
}