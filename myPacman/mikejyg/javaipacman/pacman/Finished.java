package mikejyg.javaipacman.pacman;


import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class Finished{


    public void run() {
   

        final JFrame frame = new JFrame();
        frame.setSize(600, 400);
        frame.getContentPane().setLayout(new GridLayout(3, 1, 20, 20));
        final JPanel[] panels = new JPanel[3];
        for (int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel();
            panels[i].setOpaque(true);
            frame.getContentPane().add(panels[i]);
        }
        JLabel label = new JLabel("THE FLAG HAS BEEN CAPTURED!!!!!");
        label.setFont(new Font("Congrats", Font.PLAIN, 17));
        JLabel labelBottom = new JLabel("This has been a Henry, Ankit, Kassi & Sam Production");
        labelBottom.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        panels[1].add(new Label("You Beat the Game!"));
        panels[1].add(label);
        panels[2].add(labelBottom);

        frame.setVisible(true);
        ActionListener action = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Random gen = new Random();

                Color color = new Color(gen.nextInt(256), gen.nextInt(256),
                        gen.nextInt(256));
                frame.getContentPane().setBackground(color);

                for (int i = 0; i < panels.length; i++) {
                    color = new Color(gen.nextInt(256), gen.nextInt(256),
                            gen.nextInt(256));
                    panels[i].setBackground(color);
                }
            }
        };

        Timer t = new Timer(100, action);
        t.setRepeats(true);
        t.start();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 3, dim.height / 3);
    }
    public Finished(){
        run();
    }
    
}
