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

/**
 * the tables are used to speed up computation
 */
public class ctables
{
    // for direction computation
    public static final int[] iXDirection={1,0,-1,0};
    public static final int[] iYDirection={0,-1,0,1};
    public static final int[] iDirection=
        {
            -1,	// 0:
            1,	// 1: X=0, y=-1
            -1,	// 2:
            -1,	// 3:
            2,	// 4: X=-1, y=0
            -1,	// 5:
            0,	// 6: X=1, y=0
            -1,	// 7
            -1,     // 8
            3     	// 9: X=0, y=1
        };

    // backward direction
    public static final int[] iBack={2,3,0,1};

    // direction code
    public static final int RIGHT=0;
    public static final int UP=1;
    public static final int LEFT=2;
    public static final int DOWN=3;
//direction for 2
    public static final int D=0;
    public static final int W=1;
    public static final int A=2;
    public static final int S=3;

    // the maze difinition string
    public static final String[] MazeDefine=
        {    
            "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",	
            "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",	
            "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",	
            "XXXXXXXXXXXXXX.........X.......XX....X......XXXX...........XXX......X.....XXXXXX",
            "XXXXXXXXXXXXXX.XX.XXXX.X.XX.XX.X..XX...XXXX.XXXX.XXX.XXXXX.XXX.XXXX.X.XXX.XXXXXX",	
            "XXXXXXXXXXXXXX.XX......X.XX.X..X.XXX.X.XXX....XX.XXX.....X.XXX......X.....XXXXXX",
            "XXX     XXXXXX....X.X.XX.XX.X.XX.XXX.X...X.XX.XX.....XXX.X.XXX.XXXXXXXX.X.XXXXXX",	
            "XXX     XXXXXXX.XXX.X.XX....X........XXX.X.XX.XXXX.XXXXX.......XXXXXXXX.X.XXXXXX",	
            "XXXXXX.XXXXXXXX.XXX.X....XX.XXX.XXXX..XX.X.........XXXXXXXXXXX..........X.XXXXXX",	
            "XXXXXX.XXXXXX.......XXX.XXX...X...XXX.XX.XXXXXXXXX........XXXXXXX.XXXXXXX.XXXXXX",	
            "XXXXXX.XXXXXX.XXX.XXXXX.XXXXX.XXX.XXX.XX.XXXXXXXXXXX.XXXX.XXXXXXX.XXXXXXX.XXXXXX",	
            "XXXXXX.....................................................................XXXXX",
            "XXXXXXXX.XXX.XXXXXXXXXXXXXXXXXXXXXXX.XXXXXXX.XXX.XXXXXXX.XXXXXXXXXXXX.XXXX.XXXXX",
            "XXXXXXXX.XXX.XXXXXXXXXXXXXXXXXXXXXXX.XXXXXXX.XXX.XXXXXXX.XXXXXXXXXXXX.XXXX.XXXXX",
            "XXXXXXXX.XXX.XXXXXXXX.........XXXXXX.XXXXXXX.XXX.XXXXXXX.XXXXXXXXXXXX.XXXX.XXXXX",
            "XXXXXXXX.....XXXXXXXX.XXXXXXX...........XXXX.XXX..................XXX.XXXX.XXXXX",
            "XXXXXXXX.XXX.XXXXXXXX.XXXXXXX.XX.XXXXXX.XXXX.XXX.XXXX.XXXXXXX.XXX.XX.......XXXXX",
            "XXXXXXXX.XXX.XXXXXXXX.XXXXXXX.XX.XXXXXX.XXXX.XXX.XXXX.XXXXXXX.XXX.XX.XXX.X.XXXXX",
            "XXXXXXXX.XXX.XXXXXXXX.........XX........XXXX.....XXXX.XXXXXXX.XXX.XX.XXX...XXXXX",
            "XXX...................XXXXXXX.XXXXX.XXX.XXXXXXXX.XXXX.......X.XXX.XX.XXXXX.XXXXX",
            "XXX.XX.X.XXX.XX.XXXXX.XXXXXXX.XXXXX.XXX.XXXXXXXX.XXXXXXXXXX.X.....XX.......XXXXX",
            "XXX.XX.X.XXX.XX.XXXXX.XXXXXX..................................XXX.XXXXXXXX.XXXXX",
            "XXX.XX.X..XX.XX.XXXXX.XXXXXX.XXXX.XXXXXXXXXXX.XXXXX.XXXX.XXX.XXXX.XXXXXXXX.XXXXX",
            "XXX.XX.XX.XX.XX.XXXXX.XXXXXX.XXXX.XXXXXXXXXXX.XXXXX.XXXX.XXX...............XXXXX",
            "XXX.XX.XX.XX.XX.XXXXX.XXXXXX.XXXX.XXXXXXXXXXX.XXXXX.XXXX.XXX.XXXXXX.XXX.XXXXXXXX",
            "XXX..........XX.XXXXX.XXXXXX.XXXX.XXXXXXXXXXX.XXXXX.XXXX.XXX.XX.....XXX.XXXXXXXX",	
            "XXX.XXXXXXXX.XX.......XXXXXX.............................XXX.XX.XXX.XXX.XXXXXXXX",	
            "XXX.XXXXXXXX.XXXX.XXX.XXXXXX.XXXX.XXXXXXX.XXX.XXXXXXXX.XXXXX.XX.XXX.....XXXXXXXX",	
            "XXX..........XXXX.XXX.............XXXXXXX.XXX.XXXXXXXX.......XX.XXX.XXX.XXXXXXXX",	
            "XXXXXXXX.XXX.XXXX.XXXXX.XXXXXXXXX.X.......XXX.......XX.XXXXX........XXX.XXXXXXXX",	
            "XXXXXXXX.XXX............XXXXXXXXX.X.XXXXX.XXX.XXXXX.XX.XXXXXXXXXXXX.....XXXXXXXX",	
            "XXXXXXXX.XXXXXXXXX.XXXX.XXXXXXXXX.X.XXXXX.XXX.XXXXX.XX.XXXXXXXXXXXX.XXX.XXXXXXXX",	
            "XXXXXXXX.XXXXXXXXX.XXXX.XXXXXXXXX.X.XXXXX.XXX.XXXXX.XX.XXXXXXXXXXXX.XXX.XXXXXXXX",	
            "XXXXXXXX................................................................XXXXXXXX",
            "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX     XXXXXXXX",
            "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX     XXXXXXXX",
            "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
            "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
            "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
            "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
            "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
            "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
            "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
            "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
            "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
            "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
            "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
        };

}