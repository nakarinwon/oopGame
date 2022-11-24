import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Home extends JPanel {
    private ImageIcon bg = new ImageIcon(this.getClass().getResource("bg01.jpg"));
    private ImageIcon start = new ImageIcon(this.getClass().getResource("StartButton.jpg")); 
    public JButton startB = new JButton(start);
    Home()
    {
        setLayout(null);
        add(startB);
        startB.setBounds(400,500,170,90);
        add(startB);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg.getImage(),0, 0, 1000, 800,this);
        g.setColor(Color.orange);
        g.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,90));	
        g.drawString("Adventure", 250, 200);
        
    }
}
