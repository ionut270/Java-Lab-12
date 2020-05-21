package com.company;

import javax.swing.*;
//import java.awt.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SavePanel extends JPanel implements java.io.Serializable  {
    MainFrame frame;
    JButton save_buton;
    JButton load_buton;

    JButton button;                                 // javax.swing.JButton
    JLabel label;                                   // javax.swing.JLabel
    JCheckBox check_box;                            // javax.swing.JCheckBox
    JRadioButton radio_button;                      // javax.swing.JRadioButton
    JMenuItem menu_item;                            // javax.swing.JMenuItem
    JCheckBoxMenuItem check_box_menu_item;          // javax.swing.JCheckBoxMenuItem
    JRadioButtonMenuItem radio_button_menu_item;    // javax.swing.JRadioButtonMenuItem
    JToggleButton toggle_button;                    // javax.swing.JToggleButton

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
            ArrayList< Component > components = new ArrayList<Component>();
            // Fist delete it's components
            for (Component c : this.frame.getDesign_panel().getComponents()) {
                this.frame.getDesign_panel().remove(c);
            }

            XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream("./Panel.xml"));
            components = (ArrayList< Component >) xmlDecoder.readObject();
            xmlDecoder.close();

            for (int i = 0; i < components.size(); i++) {
                System.out.println(components.get(i));
                this.frame.design_panel.add(components.get(i));

                if (components.get(i) instanceof JLabel) {
                    label = (JLabel) components.get(i);
                    //label.setText(name);
                    this.frame.design_panel.add(label);
                } else if (components.get(i) instanceof JButton) {
                    button = (JButton) components.get(i);
                    //button.setText(name);
                    this.frame.design_panel.add(button);
                } else if(components.get(i) instanceof JCheckBox){
                    check_box = (JCheckBox) components.get(i);
                    //check_box.setText(name);
                    this.frame.design_panel.add(check_box);
                } else if(components.get(i) instanceof JRadioButton){
                    radio_button = (JRadioButton) components.get(i);
                    //radio_button.setText(name);
                    this.frame.design_panel.add(radio_button);
                } else if(components.get(i) instanceof JMenuItem){
                    menu_item = (JMenuItem) components.get(i);
                    //menu_item.setText(name);
                    this.frame.design_panel.add(menu_item);
                } else if(components.get(i) instanceof JCheckBoxMenuItem){
                    check_box_menu_item = (JCheckBoxMenuItem) components.get(i);
                    //check_box_menu_item.setText(name);
                    this.frame.design_panel.add(check_box_menu_item);
                } else if(components.get(i) instanceof JRadioButtonMenuItem){
                    radio_button_menu_item = (JRadioButtonMenuItem) components.get(i);
                    //radio_button_menu_item.setText(name);
                    this.frame.design_panel.add(radio_button_menu_item);
                } else if(components.get(i) instanceof JToggleButton){
                    toggle_button = (JToggleButton) components.get(i);
                    //toggle_button.setText(name);
                    this.frame.design_panel.add(toggle_button);
                } else {
                    this.frame.design_panel.add(components.get(i));
                }

                this.repaint();
                this.revalidate();

                this.frame.design_panel.revalidate();
                this.frame.design_panel.repaint();

            }
            // then load the components on to the page

        } catch(IOException ex){
            ex.printStackTrace();
        }
    }

    private void save(ActionEvent actionEvent) {
        try {
            ArrayList< Component > components = new ArrayList<Component>();
            for (Component c : this.frame.getDesign_panel().getComponents()) {
                components.add(c);
            }

            FileOutputStream fos = new FileOutputStream(new File("./Panel.xml"));
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(components);
            encoder.close();
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}