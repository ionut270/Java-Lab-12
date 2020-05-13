package com.company;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainFrame extends JFrame  {
    //The frame will contain a ControlPanel in the north and a DesignPanel in the center.
    ControlPanel control_panel;
    DesignPanel design_panel;
    SavePanel save_panel;
    public MainFrame() {
        //refer immediate parent class object
        super("Layout editor");

        //close the app when we are done
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        control_panel = new ControlPanel(this);
        design_panel = new DesignPanel(this);
        save_panel = new SavePanel(this);

        //Create a nice border effect for our screen
        Border blackline = BorderFactory.createLineBorder(Color.black);
        Border margin = new EmptyBorder(0,10,10,10);
        design_panel.setBorder(new CompoundBorder(margin, blackline));

        add(control_panel, BorderLayout.NORTH);
        add(design_panel, BorderLayout.CENTER);
        add(save_panel, BorderLayout.SOUTH);

        pack();
    }
}
