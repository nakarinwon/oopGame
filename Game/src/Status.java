interface healing
{
    public void heal(); 
}
 class Status {
    public  void updateHP(){};
    
}

class player extends Status implements healing
{   
     
    public int playerHP = 100;
    public int playeratk = 40;
    public int playerheal = 70;
    
    @Override
    public void updateHP() {
        slime s = new slime(); 
        this.playerHP -= s.slimeatk;
        
    }

    
    @Override
    public void heal() {
        
        if(playerHP+playerheal>100)
        {
            playerHP=100;
        }else{
            this.playerHP+=playerheal;
        }
    }

   

}
class slime extends Status implements healing
{

    
    public int slimeHP=150 ;
    public int slimeatk=40 ;
    public int slimeheal=30;
    
   
    @Override
    public void updateHP() {
        player pt = new player();
        slimeHP-= pt.playeratk;  
    }

    
    @Override
    public void heal() {
        this.slimeHP+=slimeheal;
        
    }

    

}