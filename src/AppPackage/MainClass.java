package AppPackage;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.ImageIcon;
import javazoom.jl.player.Player;
import javazoom.jl.decoder.JavaLayerException;



public class MainClass 
{
    FileInputStream FIS;
    BufferedInputStream BIS;
    
    public Player player;
    public long pauseLocation;
    public long songTotalLength;
    public String fileLocation;
    int STL;
    int SCL;
    
    public void stop()
    {
        if(player != null)
        {
            
            player.close();
            pauseLocation=0;
            songTotalLength=0;
            AudioPlayerGUI.ProgressSlider.setValue(0);
            AudioPlayerGUI.seekPositionD=0;

        }
    }
    
    public void pause()
    {
        if(player != null)
        {
            
            try {
               pauseLocation = FIS.available();
            } 
            catch (IOException ex) {

            }
            player.close();
        }
    }
    
    public void resume()
    {
        try {
            FIS = new FileInputStream(fileLocation);
            BIS = new BufferedInputStream(FIS);
            
            player = new Player(BIS);
            FIS.skip(songTotalLength - pauseLocation);
        } catch (FileNotFoundException | JavaLayerException ex) {

        } catch (IOException ex) {

        }
        
        new Thread()
        {
            @Override
            public void run()
            {
                try {
                    player.play();
                    if(player.isComplete() && AudioPlayerGUI.count==1)
                    {
                        play(fileLocation);
                        AudioPlayerGUI.seekPositionD=0;
                                    

                    }
                    if(player.isComplete())
                    {
                        AudioPlayerGUI.seekPositionD=0;
                                    
                        AudioPlayerGUI.Display.setText("");
                        AudioPlayerGUI.imageName = "Playbt1.png";
AudioPlayerGUI.icon = new ImageIcon(getClass().getResource(AudioPlayerGUI.imageName));
AudioPlayerGUI.icon.getImage().flush();
AudioPlayerGUI.Play.setIcon( AudioPlayerGUI.icon );
AudioPlayerGUI.imageName = "Pausebt1.png";
AudioPlayerGUI.icon = new ImageIcon(getClass().getResource(AudioPlayerGUI.imageName));
AudioPlayerGUI.icon.getImage().flush();
AudioPlayerGUI.Pause.setIcon( AudioPlayerGUI.icon );
AudioPlayerGUI.imageName = "Stopbt1.png";
AudioPlayerGUI.icon = new ImageIcon(getClass().getResource(AudioPlayerGUI.imageName));
AudioPlayerGUI.icon.getImage().flush();
AudioPlayerGUI.Stop.setIcon( AudioPlayerGUI.icon );
AudioPlayerGUI.FlagPlay=0;

        {
            
            player.close();
            pauseLocation=0;
            songTotalLength=0;
        }
                    }
                } catch (JavaLayerException ex) {

                }
            }
        }.start();
                
        new Thread()
                     {

            @Override
            public void run() {
                try
                {
                    for(int i=0;i<STL;i++)
                    {
                 SCL = Integer.parseInt(FIS.available()+ "");
                    AudioPlayerGUI.ProgressSlider.setValue(STL-SCL);
                    Thread.sleep(1);
                    }
                   
                    
                }
                catch (IOException | InterruptedException ex)
                {
                    
                }
            }
                         
                     }.start();
        
    }
    
    public void play(String path)
    {
        try {
            FIS = new FileInputStream(path);
            BIS = new BufferedInputStream(FIS);
            
            player = new Player(BIS);
            songTotalLength = FIS.available();
            STL = Integer.parseInt(songTotalLength + "");
            AudioPlayerGUI.ProgressSlider.setMaximum(STL);
            AudioPlayerGUI.ProgressSlider.setEnabled(true);
            fileLocation = path + "";
        } catch (FileNotFoundException | JavaLayerException ex) {

        } catch (IOException ex) {

        }
        
        new Thread()
        {
            @Override
            public void run()
            {
                try {
                    
                   
                    player.play();
                    
                    if(player.isComplete() && AudioPlayerGUI.count==1)
                    {
                        play(fileLocation);
                        AudioPlayerGUI.seekPositionD=0;

                        
                    }
                    if(player.isComplete())
                    {
                        AudioPlayerGUI.seekPositionD=0;

                        AudioPlayerGUI.Display.setText("");
                        AudioPlayerGUI.imageName = "Playbt2.png";
AudioPlayerGUI.icon = new ImageIcon(getClass().getResource(AudioPlayerGUI.imageName));
AudioPlayerGUI.icon.getImage().flush();
AudioPlayerGUI.Play.setIcon( AudioPlayerGUI.icon );
AudioPlayerGUI.imageName = "Pausebt2.png";
AudioPlayerGUI.icon = new ImageIcon(getClass().getResource(AudioPlayerGUI.imageName));
AudioPlayerGUI.icon.getImage().flush();
AudioPlayerGUI.Pause.setIcon( AudioPlayerGUI.icon );
AudioPlayerGUI.imageName = "Stopbt2.png";
AudioPlayerGUI.icon = new ImageIcon(getClass().getResource(AudioPlayerGUI.imageName));
AudioPlayerGUI.icon.getImage().flush();
AudioPlayerGUI.Stop.setIcon( AudioPlayerGUI.icon );
AudioPlayerGUI.FlagPlay=0;


        {
            
            player.close();
            pauseLocation=0;
            songTotalLength=0;
        }
                    }
                } catch (JavaLayerException ex) {

                }
            }
        }.start();
        
             new Thread()
                     {

            @Override
            public void run() {
                try
                {
                    for(int i=0;i<STL;i++)
                    {
                 SCL = Integer.parseInt(FIS.available()+ "");
                   AudioPlayerGUI.ProgressSlider.setValue(STL - SCL);
                        

                    Thread.sleep(1);
                    }
                   
                    
                }
                catch (IOException | InterruptedException ex)
                {
                    
                }
            }
                         
                     }.start();
    }
}
