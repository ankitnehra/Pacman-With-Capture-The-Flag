package mikejyg.javaipacman.pacman;

import java.awt.*;

public class cflag
{
    //coordinates of 
    int xCord;
    int yCord;
    
    final int iShowCount=32;
    final int iHideCount=16;
    
    //check if pacman or ghost captured the flag
    boolean onGround;
    
    //times for flashing
    int frameCount;
    int showStatus;

    
    // the applet this object is associated to
    Window applet;
    Graphics graphics;
    
    //ghosts that can pick up flag
    cghost [] ghosts;
    
    //pacman that can pick up flag
    cpac pacman;

    //flag image
    Image imageFlag;
    
    //blank image
    Image imageBlank;

    /**
     * Constructor for objects of class cflag
     */
    cflag(Window a, Graphics g)
    {
        applet=a;
        graphics=g;
        onGround=true;
        
        // initialise instance variables
        //draw flag
        imageFlag=applet.createImage(16,16);
        cimage.drawFlag(imageFlag);
        
        imageBlank=applet.createImage(16,16);
        Graphics imageG=imageBlank.getGraphics();
        imageG.setColor(Color.black);
        imageG.fillRect(0,0,16,16);

        //blinking
        frameCount = iShowCount;
        showStatus=1; //show
    }
     
     void start(){
        do{
            xCord=(int)((Math.random()*79));
            yCord=(int)((Math.random()*44));
        }while (ctables.MazeDefine[yCord].charAt(xCord)!='.');
    }
    
    void clear(){
        //I forgot what iX and iY are...
        graphics.drawImage(imageBlank, xCord*16, yCord*16, applet);
    }
    
    void eat(int iCol, int iRow){
        if (xCord==iCol && yCord==iRow){
            onGround=false;
            clear();
            //no longer on ground
            
        }
    }
    
    public void draw(){
        frameCount--;
        if (frameCount==0){
            if(showStatus==1){
                showStatus=0;
                frameCount=iHideCount;
            }
            else{
                showStatus=1;
                frameCount=iShowCount;
            }
        }
        if (onGround && showStatus==1)
            graphics.drawImage(imageFlag,xCord*16, yCord*16, applet);
		else
			graphics.drawImage(imageBlank, xCord*16, yCord*16, applet);
        
    }
    
    int getX(){
        return xCord;
    }
    int getY(){
        return yCord;
    }
}
