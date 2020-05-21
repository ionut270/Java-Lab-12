package com.company;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ComponentEditor extends JPanel implements java.io.Serializable  {
    final MainFrame frame;
    static int width, height;

    JTextField value;
    JTextField pos_x;
    JTextField pos_y;

    JLabel value_label;
    JLabel pos_x_label;
    JLabel pos_y_label;

    JButton button;                                 // javax.swing.JButton
    JLabel label;                                   // javax.swing.JLabel
    JCheckBox check_box;                            // javax.swing.JCheckBox
    JRadioButton radio_button;                      // javax.swing.JRadioButton
    JMenuItem menu_item;                            // javax.swing.JMenuItem
    JCheckBoxMenuItem check_box_menu_item;          // javax.swing.JCheckBoxMenuItem
    JRadioButtonMenuItem radio_button_menu_item;    // javax.swing.JRadioButtonMenuItem
    JToggleButton toggle_button;                    // javax.swing.JToggleButton

    JButton submit;

    Component selected = null;

    String[][] rec = {
            { "Component", "" },
            { "Value", "" },
            { "POS X" , ""},
            { "POS Y", ""},
    };
    String[] header = { "Field", "Value" };
    JTable table = new JTable(rec, header);

    public void setRec(ArrayList<String> props){
        for(int i=0; i< props.size(); i++){
            rec[i][1] = props.get(i);
        }
        table = new JTable(rec, header);

        this.repaint();
        this.revalidate();
    }

    public void reset() {
        String[][] rec = {
                {"Component", ""},
                {"Value", ""},
                {"POS X", ""},
                {"POS Y", ""},
        };

        table = new JTable(rec, header);
        this.repaint();
        this.revalidate();
    }

    public void selectComponent(Component c){
        selected = c;
        value_label = new JLabel(selected.getName());

        this.repaint();
        this.revalidate();
    }



    public ComponentEditor(MainFrame frame) {
        this.frame = frame;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int) 180;
        height = (int) screenSize.getHeight() /2;
        setPreferredSize(new Dimension(width, height));

        JScrollPane sp=new JScrollPane(table);
        table.setBounds(10,10,width,height);
        add(table);

        value = new JTextField(13);
        pos_x = new JTextField(13);
        pos_y = new JTextField(13);

        value_label = new JLabel("value");
        pos_x_label = new JLabel("pos_x");
        pos_y_label = new JLabel("pos_x");

        submit = new JButton("Submit");

        add(value_label);
        add(value);

//        add(pos_x_label);
//        add(pos_x);
//        //These don't work
//        add(pos_y_label);
//        add(pos_y);

        add(submit);

        submit.addActionListener(this::edit);

        this.repaint();
        this.revalidate();
    }

    private void edit(ActionEvent actionEvent) {
        if(selected != null){
            if (selected instanceof JLabel) {
                label = (JLabel) selected;
                if(value.getText().length() > 0){
                    label.setText(value.getText());
                }

                this.frame.design_panel.add(label);
            } else if (selected instanceof JButton) {
                button = (JButton) selected;
                //button.setText(name);
                if(value.getText().length() > 0){
                    button.setText(value.getText());
                }
                this.frame.design_panel.add(button);
            } else if(selected instanceof JCheckBox){
                check_box = (JCheckBox) selected;
                //check_box.setText(name);
                if(value.getText().length() > 0){
                    button.setText(value.getText());
                }
                this.frame.design_panel.add(check_box);
            } else if(selected instanceof JRadioButton){
                radio_button = (JRadioButton) selected;
                //radio_button.setText(name);
                if(value.getText().length() > 0){
                    button.setText(value.getText());
                }
                this.frame.design_panel.add(radio_button);
            } else if(selected instanceof JMenuItem){
                menu_item = (JMenuItem) selected;
                //menu_item.setText(name);
                if(value.getText().length() > 0){
                    button.setText(value.getText());
                }
                this.frame.design_panel.add(menu_item);
            } else if(selected instanceof JCheckBoxMenuItem){
                check_box_menu_item = (JCheckBoxMenuItem) selected;
                //check_box_menu_item.setText(name);
                if(value.getText().length() > 0){
                    button.setText(value.getText());
                }
                this.frame.design_panel.add(check_box_menu_item);
            } else if(selected instanceof JRadioButtonMenuItem){
                radio_button_menu_item = (JRadioButtonMenuItem) selected;
                //radio_button_menu_item.setText(name);
                if(value.getText().length() > 0){
                    button.setText(value.getText());
                }
                this.frame.design_panel.add(radio_button_menu_item);
            } else if(selected instanceof JToggleButton){
                toggle_button = (JToggleButton) selected;
                //toggle_button.setText(name);
                if(value.getText().length() > 0){
                    button.setText(value.getText());
                }
                this.frame.design_panel.add(toggle_button);
            } else {
                this.frame.design_panel.add(selected);
            }

            this.repaint();
            this.revalidate();

            this.frame.design_panel.revalidate();
            this.frame.design_panel.repaint();

            selected = null;
            value_label = new JLabel("Value");

            this.repaint();
            this.revalidate();
        }
    }
}
