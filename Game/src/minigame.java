import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

public class minigame extends JFrame {
    JFrame jf =new JFrame();
    JProgressBar r1 = new JProgressBar(0,100);
    JProgressBar r2 = new JProgressBar(0,100);
    JLabel jl = new JLabel("");
    public int winner ;
    boolean ButtonPress = false;
    String winnername;
    boolean hasWinner  = false;
    
    public  void finish()
    {
        jl.setVisible(true);
        if(winner==1)
        {
            winnername="rabbit";
        }else
        {
            winnername="turtle";
        }
        jl.setText("Winner is "+winnername);
        jf.getContentPane().add(jl);
    }
    
    minigame()
    {   
        
        race();
        
    }
    public void race()
    {   
        
        jf.setBounds(100,100,600,400);
        jf.getContentPane().setLayout(null);
        
        r1.setString("rabbit");
        r1.setStringPainted(true);
        r1.setBounds(150, 150, 300, 20);
        jf.getContentPane().add(r1);

        r2.setString("turtle");
        r2.setStringPainted(true);
        r2.setBounds(150, 200, 300, 20);
        jf.getContentPane().add(r2);
         
        jl.setBounds(150,100,410,14);
        jl.setVisible(true);
        jf.getContentPane().add(jl);



        JButton r1Button = new JButton("rabbit");
        r1Button.addActionListener(new runRace());
        r1Button.setBounds(100,300 ,150, 40);
        jf.getContentPane().add(r1Button);

        JButton r2Button = new JButton("turtle");
        r2Button.addActionListener(new runRace());
        r2Button.setBounds(300,300 , 150, 40);
        jf.getContentPane().add(r2Button);
    }
    class runRace implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!ButtonPress)
            {
                ButtonPress = true; 
                jl.setVisible(false);
                R1 r1 = new R1();
                r1.start();
                R2 r2 = new R2();
                r2.start(); 
            }
                  
        }

    }
    class R1 extends  Thread 
    {
        public void run()
        {
            for(int i=0;i<101;i++)
            {
                if(hasWinner)
                {
                    break;
                }
                r1.setValue(i);
                r1.repaint();
                if(i==100)
                {
                    hasWinner = true;
                    winner = 1;
                    finish();
                }
                try
                {
                    int time = ThreadLocalRandom.current().nextInt(5,20);
                    Thread.sleep(time);
                }catch(InterruptedException err){
                    err.printStackTrace();
                }
            }
        }
    }
    class R2 extends Thread
    {
        public void run()
        {
            for(int i=0;i<101;i++)
            {
                if(hasWinner)
                {
                    break;
                }
                r2.setValue(i);
                r2.repaint();
                if(i==100)
                {
                    winner = 2;
                    hasWinner = true;
                    finish();
                }
                try
                {
                    
                    int time = ThreadLocalRandom.current().nextInt(5,20);
                    Thread.sleep(time);
                }catch(InterruptedException err){
                    err.printStackTrace();
                }
            }
        }
    }
     
}
