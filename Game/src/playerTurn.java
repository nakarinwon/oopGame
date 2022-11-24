import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class playerTurn extends JPanel implements ActionListener {
    
    JButton bAttack = new JButton("attack");
    JButton bHeal = new JButton("heal");
    JButton b = new JButton("Want to Relax?");
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    
    Win win =new Win();
    JTextArea stat = new JTextArea();
    JTextArea log = new JTextArea();
    player player = new player();
    slime slime = new slime();
    minigame mini = new minigame();
    //Graphics g ;
    ImageIcon playerPic = new ImageIcon(this.getClass().getResource("Knight.png"));
    ImageIcon monsterPic = new ImageIcon(this.getClass().getResource("slime.png"));
    
    
    playerTurn() 
    {
        p1.setLayout(new GridLayout(1,3));
        p1.add(stat);
        p2.setLayout(new GridLayout(2,1));
        p1.add(p2);
        p2.add(bAttack);
        p2.add(bHeal);
        this.add(p1);
        this.add(b);
        p1.add(log);
        stat.setText("HP : "+player.playerHP+"\nAttack : "+player.playeratk+"\nHeal : "+player.playerheal);
        stat.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,50));
        log.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,20));
        log.setText("player log");
        log.setText("monster log");
        bAttack.addActionListener(this);
        bHeal.addActionListener(this);
        b.addActionListener(this);
    }
    public void updatestat()
    {
        stat.setText("HP : "+player.playerHP+"\nAttack : "+player.playeratk+"\nHeal : "+player.playerheal);
    }  
    public void updatelog2(String s)
    {
        log.setText(""+s);
    }  
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
            g.drawImage(playerPic.getImage(),100, 300, 300, 300,this);
            g.drawImage(monsterPic.getImage(),600, 400, 300, 200,this);
            g.setColor(Color.orange);
            g.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,50));	
            g.drawString("Slime HP : "+slime.slimeHP, 600, 300);
    }
    public void playerAttack()
    {
        
        slime.updateHP();
    }
    public void playerHeal()
    {
        player.heal();
    }
    public void slimeturn()
    {
        if(slime.slimeHP<20)
        {   
            slime.heal();
            System.out.println("slime heal up to "+slime.slimeHP+" HP");
            updatelog2("slime heal up to "+slime.slimeHP+" HP");
        }
        else
        {
            player.updateHP();
            System.out.println("slime deal "+slime.slimeatk+" dmg");
            updatestat();
            updatelog2("slime deal "+slime.slimeatk+" dmg");
        }
    }
    public int getSlimeHP()
    {
        return slime.slimeHP;
    }
    public int getPlayerAtk()
    {
        return player.playeratk;
    }
    public int getPlayerHp()
    {
        return player.playerHP;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
    }
    
}
