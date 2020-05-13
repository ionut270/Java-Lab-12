package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {

    final MainFrame frame;

    JTextField class_input;
    JTextField name_input;

    JButton button;                                 // javax.swing.JButton
    JLabel label;                                   // javax.swing.JLabel
    JCheckBox check_box;                            // javax.swing.JCheckBox
    JRadioButton radio_button;                      // javax.swing.JRadioButton
    JMenuItem menu_item;                            // javax.swing.JMenuItem
    JCheckBoxMenuItem check_box_menu_item;          // javax.swing.JCheckBoxMenuItem
    JRadioButtonMenuItem radio_button_menu_item;    // javax.swing.JRadioButtonMenuItem
    JToggleButton toggle_button;                    // javax.swing.JToggleButton

    JButton submit_button;
    JLabel class_label;
    JLabel name_label;
    //The ControlPanel will allow the user to specify any class name of a Swing component
    public ControlPanel(MainFrame frame) {
        this.frame = frame;

        //default is better
        //this.setLayout(new GridBagLayout());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth() /2;
        setPreferredSize(new Dimension(width, 50));

        //Create input fields
        class_input = new JTextField(20);
        name_input = new JTextField(20);

        class_label = new JLabel("Class");
        name_label = new JLabel("Component name");

        submit_button = new JButton("Submit");

        //name
        add(name_label);
        add(name_input);

        //class
        add(class_label);
        add(class_input);

        add(submit_button);

        //onClick run callback function
        submit_button.addActionListener(this::instantiate);

    }

    private void instantiate(ActionEvent actionEvent) {
        try {
            String name = this.name_input.getText();
            String type = this.class_input.getText();

            Class definition = Class.forName(type);
            Component component = (Component) definition.newInstance();
            component.setPreferredSize(new Dimension(100, 50));

            if (component instanceof JLabel) {
                label = (JLabel) component;
                label.setText(name);
                this.frame.design_panel.add(label);
            } else if (component instanceof JButton) {
                button = (JButton) component;
                button.setText(name);
                this.frame.design_panel.add(button);
            } else if(component instanceof JCheckBox){
                check_box = (JCheckBox) component;
                check_box.setText(name);
                this.frame.design_panel.add(check_box);
            } else if(component instanceof JRadioButton){
                radio_button = (JRadioButton) component;
                radio_button.setText(name);
                this.frame.design_panel.add(radio_button);
            } else if(component instanceof JMenuItem){
                menu_item = (JMenuItem) component;
                menu_item.setText(name);
                this.frame.design_panel.add(menu_item);
            } else if(component instanceof JCheckBoxMenuItem){
                check_box_menu_item = (JCheckBoxMenuItem) component;
                check_box_menu_item.setText(name);
                this.frame.design_panel.add(check_box_menu_item);
            } else if(component instanceof JRadioButtonMenuItem){
                radio_button_menu_item = (JRadioButtonMenuItem) component;
                radio_button_menu_item.setText(name);
                this.frame.design_panel.add(radio_button_menu_item);
            } else if(component instanceof JToggleButton){
                toggle_button = (JToggleButton) component;
                toggle_button.setText(name);
                this.frame.design_panel.add(toggle_button);
            } else {
                this.frame.design_panel.add(component);
            }

            this.repaint();
            this.revalidate();

            this.frame.design_panel.revalidate();
            this.frame.design_panel.repaint();
        } catch (IllegalAccessException | ClassNotFoundException | InstantiationException ex) {
            System.out.println(ex);
        }
    }
}
