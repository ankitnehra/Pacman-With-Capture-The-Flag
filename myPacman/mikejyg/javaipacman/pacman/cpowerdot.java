/**
 * Copyright (C) 1997-2010 Junyang Gu <mikejyg@gmail.com>
 * 
 * This file is part of javaiPacman.
 *
 * javaiPacman is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * javaiPacman is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with javaiPacman.  If not, see <http://www.gnu.org/licenses/>.
 */

package mikejyg.javaipacman.pacman;

import java.awt.*;

public class cpowerdot
{
    int iX[]={1,19,1,19};
    int iY[]={2,2,13,13};
    
    final int iShowCount=32;
    final int iHideCount=16;

    int frameCount;
    int showStatus;

    int iValid[];

    // the applet this object is associated to
    Window applet;
    Graphics graphics;

    // the ghosts it controls
    cghost [] ghosts;

    // the power dot image
    Image imagePowerDot;

    // the blank image
    Image imageBlank;

    cpowerdot(Window a, Graphics g, cghost [] gh)
    {
        applet=a;
        graphics=g;
        ghosts=gh;
        
        // initialize power dot and image
        iValid = new int[4];

        imagePowerDot=applet.createImage(16,16);
        cimage.drawPowerDot(imagePowerDot);

        imageBlank=applet.createImage(16,16);
        Graphics imageG=imageBlank.getGraphics();
        imageG.setColor(Color.black);
        imageG.fillRect(0,0,16,16);

        frameCount=iShowCount;
        showStatus=1;   // show
    }

    public void start()
    {
        // all power dots available
        
        for (int i=0; i<4; i++) 
        {
            int tmpX = cuty.RandSelect(44);
            int tmpY = cuty.RandSelect(79);
            while (ctables.MazeDefine[tmpX].charAt(tmpY)!='.')
            {
                tmpX = cuty.RandSelect(44);
                tmpY = cuty.RandSelect(79);
            }
            if (ctables.MazeDefine[tmpX].charAt(tmpY)!='X')
            {
                iX[i] = tmpY;
                System.out.println(tmpX);
                iY[i] = tmpX;
                System.out.println(tmpY);
            }
        }
        for (int i=0; i<4; i++)
            iValid[i]=1;
    }

    void clear(int dot)
    {
        graphics.drawImage(imageBlank, iX[dot]*16, iY[dot]*16, applet);
    }

    void eat(int iCol, int iRow)
    {
        System.out.println("eats");
        for (int i=0; i<4; i++)
        {
            if (iX[i]==iCol && iY[i]==iRow)
            {
                iValid[i]=0;
                clear(i);
            }
        }
        for (int i=0; i<4; i++)
        {
            ghosts[i].blind();
        }
    }

    public void draw()
    {
        frameCount--;
        if (frameCount==0)
        {
            if (showStatus==1)
            {
                showStatus=0;
                frameCount=iHideCount;
            }
            else
            {
                showStatus=1;
                frameCount=iShowCount;
            }
        }
        for (int i=0; i<4; i++)
        {
            if (iValid[i]==1 && showStatus==1)
                graphics.drawImage(imagePowerDot,iX[i]*16, iY[i]*16, applet);
            else
                graphics.drawImage(imageBlank, iX[i]*16, iY[i]*16, applet);
        }
    } 
    
    public int[] getX()
    {
        return iX;
    }
    
    public int[] getY()
    {
        return iY;
    }
    
    public int[] getValid()
    {
        return iValid;
    }

    public boolean allEaten()
    {
        int x = 0;
        for (int i=0; i<4; i++)
        {
            x += iValid[i];
        }
        if (x==0)
            return true;
        else
            return false;
    }
}
