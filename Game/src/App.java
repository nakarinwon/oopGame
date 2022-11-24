import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener{
    Home home = new Home();
    playerTurn pt = new playerTurn();
    Win win = new Win();
    Lose lose = new Lose();
    
    
    public App()
    {
        this.setSize(1000,800);
        this.add(home);
        home.startB.addActionListener(this);
        pt.bAttack.addActionListener(this);
        pt.bHeal.addActionListener(this);
        pt.b.addActionListener(this);
        
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==home.startB)
        {
            this.setLocationRelativeTo(null);
            this.remove(home);
            this.setSize(1000, 800);
            this.add(pt);
            pt.requestFocusInWindow();
            pt.setVisible(true);
            
        }
        else if(e.getSource()==pt.bAttack)
        {   
            pt.playerAttack();
                if(pt.getSlimeHP()>0)
                {
                    
                    pt.updatestat();
                    pt.slimeturn();
                    if(pt.getPlayerHp()<0)
                    {
                    this.remove(pt);
                    this.setSize(1000, 800);
                    this.add(lose);
                    }
                }else{
                    this.remove(pt);
                    this.setSize(1000, 800);
                    this.add(win);       
                }      
        }
        else if(e.getSource()==pt.bHeal)
        {
            pt.playerHeal();
            pt.updatestat();
            pt.slimeturn();
        }
        else if(e.getSource()==pt.b)
        {minigame mini = new minigame();
            mini.jf.setVisible(true);
        }
        this.validate();
        this.repaint();
    }
    public static void main(String[] args)throws Exception {
        JFrame jf = new App();
        jf.setSize(1000, 800);
        jf.setTitle("App");
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }
}
