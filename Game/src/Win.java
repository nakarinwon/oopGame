import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

import javax.swing.ImageIcon;



public class Win extends JPanel{
    private ImageIcon bg = new ImageIcon(this.getClass().getResource("bg01.jpg"));
    
    Win()
    {
        setLayout(null);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg.getImage(),0, 0, 1000, 800,this);
        g.setColor(Color.orange);
        g.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,90));	
        g.drawString("You Win", 310, 200);
    }
}
