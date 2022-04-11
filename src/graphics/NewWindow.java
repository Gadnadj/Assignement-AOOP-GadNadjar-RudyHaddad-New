package graphics;

import javax.swing.*;

public class NewWindow
{
    JFrame frame;
    JLabel label;

    NewWindow()
    {
      label = new JLabel();
      frame = new JFrame();
      label.setBounds(0,0,150,50);
      frame.add(label);
      //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(800,600);
      frame.setLayout(null);
      frame.setVisible(true);
    }
}
