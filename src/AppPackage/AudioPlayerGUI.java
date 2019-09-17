/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AppPackage;



import java.awt.Toolkit;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.Mixer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JSlider;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Raju
 */
public class AudioPlayerGUI extends javax.swing.JDialog {

    MainClass MC = new MainClass();
    
    public static int count;
    int xMouse;
    int yMouse;
    public static String imageName;
    public static ImageIcon icon;
    String NAME;
    int width = Toolkit.getDefaultToolkit().getScreenSize().width-350;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height-800 ;
    String SONG = null;
    public static int FlagPlay=0;
    int FlagStop=0;
    int OneTimeFlag = 0;
    public static double seekPositionD = 0;
    
    private FloatControl getVolumeControl() throws Exception {
    try {
        Mixer.Info mixers[] = AudioSystem.getMixerInfo();
        for (Mixer.Info mixerInfo : mixers) {
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            mixer.open();

            //we check only target type lines, because we are looking for "SPEAKER target port"
            for (Line.Info info : mixer.getTargetLineInfo()) {
                if (info.toString().contains("SPEAKER")|| info.toString().contains("HEADPHONE")) {
                    
                    Line line = mixer.getLine(info);
                    try {
                        line.open();
                    } catch (IllegalArgumentException iae) {}
                    return (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                }
            }
        }
    } catch (Exception ex) {
        System.out.println("problem creating volume control object:"+ex);
        throw ex;
    }
    throw new Exception("unknown problem creating volume control object");
}
    public AudioPlayerGUI(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
        
        this.setLocation(width, height);
        ProgressSlider.setValue(ProgressSlider.getMinimum());
        ProgressSlider.setEnabled(false);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ProgressSlider = new javax.swing.JProgressBar();
        VolumeSlider = new javax.swing.JSlider();
        Loop = new javax.swing.JLabel();
        Select = new javax.swing.JLabel();
        Stop = new javax.swing.JLabel();
        Pause = new javax.swing.JLabel();
        Play = new javax.swing.JLabel();
        Display = new javax.swing.JTextField();
        Close = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(350, 110));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 80, 20, 20));
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 44, 20, 20));
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 80, 20, 20));
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 46, 20, 20));
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 15, 20));
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 45, 15, 20));
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 50, 19, 20));
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 80, 19, 20));
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 20, 20));
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 20, 20));
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 80, 20, 20));
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 50, 20, 20));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 42, 10, 60));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 41, 13, 65));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 42, 9, 60));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 42, 10, 60));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 42, 10, 60));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 42, 10, 60));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 130, 20));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 41, 130, 20));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 97, 130, 10));
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 97, 130, 10));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/Background.jpg"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 30, 2, 10));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/Background.jpg"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 30, 2, 10));

        ProgressSlider.setBackground(new java.awt.Color(0, 204, 0));
        ProgressSlider.setForeground(new java.awt.Color(255, 153, 0));
        ProgressSlider.setToolTipText("");
        ProgressSlider.setAlignmentX(0.0F);
        ProgressSlider.setAlignmentY(0.0F);
        ProgressSlider.setBorderPainted(false);
        ProgressSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ProgressSlider.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        ProgressSlider.setString(" ");
        ProgressSlider.setStringPainted(true);
        ProgressSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ProgressSliderMousePressed(evt);
            }
        });
        getContentPane().add(ProgressSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 30, 290, 8));

        VolumeSlider.setBackground(new java.awt.Color(51, 255, 51));
        VolumeSlider.setForeground(new java.awt.Color(51, 153, 255));
        VolumeSlider.setOrientation(javax.swing.JSlider.VERTICAL);
        VolumeSlider.setToolTipText("Volume");
        VolumeSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VolumeSlider.setFocusable(false);
        VolumeSlider.setOpaque(false);
        VolumeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                VolumeSliderStateChanged(evt);
            }
        });
        getContentPane().add(VolumeSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 40, 20, 65));

        Loop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/Loopbt2.png"))); // NOI18N
        Loop.setToolTipText("Repeat Song");
        Loop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Loop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                LoopMouseReleased(evt);
            }
        });
        getContentPane().add(Loop, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 50, 50));

        Select.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/Playlistbt2.png"))); // NOI18N
        Select.setToolTipText("Playlist");
        Select.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Select.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SelectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SelectMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SelectMouseReleased(evt);
            }
        });
        getContentPane().add(Select, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 50, 50, 50));

        Stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/Stopbt2.png"))); // NOI18N
        Stop.setToolTipText("Stop");
        Stop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Stop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                StopMouseReleased(evt);
            }
        });
        getContentPane().add(Stop, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 50, 50));

        Pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/Pausebt2.png"))); // NOI18N
        Pause.setToolTipText("Pause");
        Pause.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Pause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PauseMouseReleased(evt);
            }
        });
        getContentPane().add(Pause, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 50, 50, 50));

        Play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/Playbt2.png"))); // NOI18N
        Play.setToolTipText("Play");
        Play.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PlayMouseReleased(evt);
            }
        });
        getContentPane().add(Play, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 37, 75, 75));

        Display.setEditable(false);
        Display.setBackground(new java.awt.Color(255, 255, 255));
        Display.setFont(new java.awt.Font("Constantia", 2, 14)); // NOI18N
        Display.setForeground(new java.awt.Color(255, 255, 255));
        Display.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Display.setBorder(null);
        Display.setOpaque(false);
        getContentPane().add(Display, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 7, 280, 21));

        Close.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        Close.setToolTipText("Close");
        Close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                CloseMouseReleased(evt);
            }
        });
        getContentPane().add(Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 8, 14, 14));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppPackage/Background.jpg"))); // NOI18N
        Background.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BackgroundMousePressed(evt);
            }
        });
        Background.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BackgroundMouseDragged(evt);
            }
        });
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 110));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PlayMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayMouseReleased
        if(OneTimeFlag==1)
        {
        imageName = "Playbt1.png";
icon = new ImageIcon(getClass().getResource(imageName));
icon.getImage().flush();
Play.setIcon( icon );
imageName = "Pausebt2.png";
icon = new ImageIcon(getClass().getResource(imageName));
icon.getImage().flush();
Pause.setIcon( icon );
imageName = "Stopbt2.png";
icon = new ImageIcon(getClass().getResource(imageName));
icon.getImage().flush();
Stop.setIcon( icon );
if(FlagPlay==0)
       {
           FlagPlay = 1;
           
        if(MC.songTotalLength==0)
        {
             MC.play(SONG);
        }
          
       else
        {
            MC.resume();

        }
       }
        Display.setText(NAME);
FlagStop = 0;
        }
        else
        {
            
            FileFilter filter = new FileNameExtensionFilter("MP3 Files", "mp3", "mpeg3");
        
        JFileChooser chooser = new JFileChooser("D:\\Mixed");
        chooser.addChoosableFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION)
        {
            OneTimeFlag=1;
            MC.stop();
            File myFile = chooser.getSelectedFile();
            String song = myFile +"";
            String name = chooser.getSelectedFile().getName();
            NAME = name;
            Display.setText(name);
            SONG = song;
            MC.play(song);
            FlagPlay=1;
            FlagStop = 0;
            imageName = "Playbt1.png";
icon = new ImageIcon(getClass().getResource(imageName));
icon.getImage().flush();
Play.setIcon( icon );

imageName = "Pausebt2.png";
icon = new ImageIcon(getClass().getResource(AudioPlayerGUI.imageName));
icon.getImage().flush();
Pause.setIcon( AudioPlayerGUI.icon );
imageName = "Stopbt2.png";
icon = new ImageIcon(getClass().getResource(AudioPlayerGUI.imageName));
icon.getImage().flush();
Stop.setIcon( AudioPlayerGUI.icon );
            
        }
        }
    }//GEN-LAST:event_PlayMouseReleased

    private void StopMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StopMouseReleased

        if(FlagPlay !=0)
        {
imageName = "Playbt2.png";
icon = new ImageIcon(getClass().getResource(imageName));
icon.getImage().flush();
Play.setIcon( icon );
imageName = "Stopbt1.png";
icon = new ImageIcon(getClass().getResource(imageName));
icon.getImage().flush();
Stop.setIcon( icon );
imageName = "Pausebt2.png";
icon = new ImageIcon(getClass().getResource(imageName));
icon.getImage().flush();
Pause.setIcon( icon );
        MC.stop();
        AudioPlayerGUI.Display.setText("");
        FlagPlay = 0;
        FlagStop = 1;
        }
    }//GEN-LAST:event_StopMouseReleased

    private void PauseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PauseMouseReleased

        if(FlagStop==0 && FlagPlay==1)
        {
        imageName = "Playbt2.png";
icon = new ImageIcon(getClass().getResource(imageName));
icon.getImage().flush();
Play.setIcon( icon );
imageName = "Pausebt1.png";
icon = new ImageIcon(getClass().getResource(imageName));
icon.getImage().flush();
Pause.setIcon( icon );
MC.pause();
        FlagPlay = 0;        
        }
    }//GEN-LAST:event_PauseMouseReleased

    private void LoopMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoopMouseReleased
    
        switch(count)
        {
            case 0:
                count=1;
imageName = "Loopbt1.png";
icon = new ImageIcon(getClass().getResource(imageName));
icon.getImage().flush();
Loop.setIcon( icon );
                break;
            case 1:
                count=0;
imageName = "Loopbt2.png";
icon = new ImageIcon(getClass().getResource(imageName));
icon.getImage().flush();
Loop.setIcon( icon );
                break;
        }
    }//GEN-LAST:event_LoopMouseReleased

    private void SelectMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectMouseReleased
        
        FileFilter filter = new FileNameExtensionFilter("MP3 Files", "mp3", "mpeg3");
        
        JFileChooser chooser = new JFileChooser("D:\\Mixed");
        chooser.addChoosableFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION)
        {
            OneTimeFlag = 1;
            MC.stop();
            File myFile = chooser.getSelectedFile();
            String song = myFile +"";
            String name = chooser.getSelectedFile().getName();
            NAME = name;
            Display.setText(name);
            SONG = song;
            MC.play(song);
            FlagPlay=1;
            FlagStop = 0;
            imageName = "Playbt1.png";
icon = new ImageIcon(getClass().getResource(imageName));
icon.getImage().flush();
Play.setIcon( icon );

imageName = "Pausebt2.png";
icon = new ImageIcon(getClass().getResource(AudioPlayerGUI.imageName));
icon.getImage().flush();
Pause.setIcon( AudioPlayerGUI.icon );
imageName = "Stopbt2.png";
icon = new ImageIcon(getClass().getResource(AudioPlayerGUI.imageName));
icon.getImage().flush();
Stop.setIcon( AudioPlayerGUI.icon );
            
        }
    }//GEN-LAST:event_SelectMouseReleased

    private void BackgroundMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackgroundMouseDragged
int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_BackgroundMouseDragged

    private void BackgroundMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackgroundMousePressed
xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_BackgroundMousePressed

    private void CloseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseReleased
System.exit(0);
    }//GEN-LAST:event_CloseMouseReleased

    private void SelectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectMouseEntered
imageName = "Playlistbt1.png";
icon = new ImageIcon(getClass().getResource(AudioPlayerGUI.imageName));
icon.getImage().flush();
Select.setIcon( AudioPlayerGUI.icon );
    }//GEN-LAST:event_SelectMouseEntered

    private void SelectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectMouseExited
imageName = "Playlistbt2.png";
icon = new ImageIcon(getClass().getResource(AudioPlayerGUI.imageName));
icon.getImage().flush();
Select.setIcon( AudioPlayerGUI.icon );
    }//GEN-LAST:event_SelectMouseExited

    private void VolumeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_VolumeSliderStateChanged

        JSlider src = (JSlider)evt.getSource();
                //if (src.getValueIsAdjusting()) return; //optional
                if (src.getValue() % 5 !=0) return;
                float value = src.getValue() / 100.0f;
                try {
                    getVolumeControl().setValue(value);
                    //you can put a click play code here to have nice feedback when moving slider
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            
    }//GEN-LAST:event_VolumeSliderStateChanged

    private void ProgressSliderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProgressSliderMousePressed

        
        int x=0;
        x = evt.getX();
        double X = x;
        seekPositionD = (X/289) * MC.songTotalLength ;
        int seekPositionI = (int)((Math.round(seekPositionD)));
        try
        {   
            System.out.println("x= "+ X +"\nseekPositionD= "+ seekPositionD + "\nseekPositionI= "+ seekPositionI);
        MC.FIS.skip(-(MC.songTotalLength-MC.FIS.available()));
            MC.FIS.skip(seekPositionI);
            System.out.println("Success");
        }
        catch(Exception e)
        {
            System.out.println("Error");
        }
        System.out.println(x);
    }//GEN-LAST:event_ProgressSliderMousePressed
                              
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AudioPlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(3000);
                   
                }
                catch(Exception e)
                {
                    
                }
                AudioPlayerGUI dialog = new AudioPlayerGUI(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Close;
    public static javax.swing.JTextField Display;
    private javax.swing.JLabel Loop;
    public static javax.swing.JLabel Pause;
    public static javax.swing.JLabel Play;
    public static javax.swing.JProgressBar ProgressSlider;
    private javax.swing.JLabel Select;
    public static javax.swing.JLabel Stop;
    public static javax.swing.JSlider VolumeSlider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
