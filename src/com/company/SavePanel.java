package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SavePanel extends JPanel {
    final MainFrame frame;
    JButton save_buton;
    JButton load_buton;

    public SavePanel(MainFrame frame) {
        this.frame = frame;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth() /2;
        setPreferredSize(new Dimension(width, 50));

        save_buton = new JButton("Save");
        load_buton = new JButton("Load");

        add(save_buton);
        add(load_buton);
        
        save_buton.addActionListener(this::save);
        load_buton.addActionListener(this::load);
    }

    private void load(ActionEvent actionEvent) {
        try{
            throw new Throwable("The button is not yet defined to handle any actions");
        } catch(Throwable exception) {
            System.out.println(exception);
        }
    }

    private void save(ActionEvent actionEvent) {
        try{
            throw new Throwable("The button is not yet defined to handle any actions");
        } catch(Throwable exception) {
            System.out.println(exception);
        }
    }
}
