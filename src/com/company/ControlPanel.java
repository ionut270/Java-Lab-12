package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.*;
import java.io.*;
import java.util.ArrayList;

public class ControlPanel extends JPanel implements java.io.Serializable {

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
        int width = (int) screenSize.getWidth() /4;
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
                Object self = this;
                label.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent evt){
                        ((ControlPanel) self).frame.component_editor.selectComponent(label);
                    }
                    public void mouseEntered(MouseEvent evt) {
                        //                            BeanInfo info = Introspector.getBeanInfo( label.getClass() );
//                            //System.out.println(info.getPropertyDescriptors());
//                            for ( PropertyDescriptor pd : info.getPropertyDescriptors() ) {
//                                    System.out.printf("%s : %s\n", pd.getDisplayName()); // javax.swing.JLabel //returns null !
//                            }
                        ArrayList<String> data = new ArrayList<String>();
                        data.add(label.getUIClassID());
                        data.add(label.getText());
                        data.add(Integer.toString(label.getX()));
                        data.add(Integer.toString(label.getY()));
                        ((ControlPanel) self).frame.component_editor.setRec(data);

                    }
                    public void mouseExited(MouseEvent evt) {
                        ((ControlPanel) self).frame.component_editor.reset();
                    }
                });
            } else if (component instanceof JButton) {
                button = (JButton) component;
                button.setText(name);
                this.frame.design_panel.add(button);

                Object self = this;
                button.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent evt){
                        ((ControlPanel) self).frame.component_editor.selectComponent(button);
                    }
                    public void mouseEntered(MouseEvent evt) {
                        //                            BeanInfo info = Introspector.getBeanInfo( label.getClass() );
//                            //System.out.println(info.getPropertyDescriptors());
//                            for ( PropertyDescriptor pd : info.getPropertyDescriptors() ) {
//                                    System.out.printf("%s : %s\n", pd.getDisplayName()); // javax.swing.JLabel //returns null !
//                            }
                        ArrayList<String> data = new ArrayList<String>();
                        data.add(button.getUIClassID());
                        data.add(button.getText());
                        data.add(Integer.toString(button.getX()));
                        data.add(Integer.toString(button.getY()));
                        ((ControlPanel) self).frame.component_editor.setRec(data);

                    }
                    public void mouseExited(MouseEvent evt) {
                        ((ControlPanel) self).frame.component_editor.reset();
                    }
                });

            } else if(component instanceof JCheckBox){
                check_box = (JCheckBox) component;
                check_box.setText(name);
                this.frame.design_panel.add(check_box);

                Object self = this;
                check_box.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent evt){
                        ((ControlPanel) self).frame.component_editor.selectComponent(check_box);
                    }
                    public void mouseEntered(MouseEvent evt) {
                        //                            BeanInfo info = Introspector.getBeanInfo( label.getClass() );
//                            //System.out.println(info.getPropertyDescriptors());
//                            for ( PropertyDescriptor pd : info.getPropertyDescriptors() ) {
//                                    System.out.printf("%s : %s\n", pd.getDisplayName()); // javax.swing.JLabel //returns null !
//                            }
                        ArrayList<String> data = new ArrayList<String>();
                        data.add(check_box.getUIClassID());
                        data.add(check_box.getText());
                        data.add(Integer.toString(check_box.getX()));
                        data.add(Integer.toString(check_box.getY()));
                        ((ControlPanel) self).frame.component_editor.setRec(data);

                    }
                    public void mouseExited(MouseEvent evt) {
                        ((ControlPanel) self).frame.component_editor.reset();
                    }
                });

            } else if(component instanceof JRadioButton){
                radio_button = (JRadioButton) component;
                radio_button.setText(name);
                this.frame.design_panel.add(radio_button);

                Object self = this;
                radio_button.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent evt){
                        ((ControlPanel) self).frame.component_editor.selectComponent(radio_button);
                    }
                    public void mouseEntered(MouseEvent evt) {
                        //                            BeanInfo info = Introspector.getBeanInfo( label.getClass() );
//                            //System.out.println(info.getPropertyDescriptors());
//                            for ( PropertyDescriptor pd : info.getPropertyDescriptors() ) {
//                                    System.out.printf("%s : %s\n", pd.getDisplayName()); // javax.swing.JLabel //returns null !
//                            }
                        ArrayList<String> data = new ArrayList<String>();
                        data.add(radio_button.getUIClassID());
                        data.add(radio_button.getText());
                        data.add(Integer.toString(radio_button.getX()));
                        data.add(Integer.toString(radio_button.getY()));
                        ((ControlPanel) self).frame.component_editor.setRec(data);

                    }
                    public void mouseExited(MouseEvent evt) {
                        ((ControlPanel) self).frame.component_editor.reset();
                    }
                });
            } else if(component instanceof JMenuItem){
                menu_item = (JMenuItem) component;
                menu_item.setText(name);
                this.frame.design_panel.add(menu_item);

                Object self = this;
                menu_item.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent evt){
                        ((ControlPanel) self).frame.component_editor.selectComponent(menu_item);
                    }
                    public void mouseEntered(MouseEvent evt) {
                        //                            BeanInfo info = Introspector.getBeanInfo( label.getClass() );
//                            //System.out.println(info.getPropertyDescriptors());
//                            for ( PropertyDescriptor pd : info.getPropertyDescriptors() ) {
//                                    System.out.printf("%s : %s\n", pd.getDisplayName()); // javax.swing.JLabel //returns null !
//                            }
                        ArrayList<String> data = new ArrayList<String>();
                        data.add(menu_item.getUIClassID());
                        data.add(menu_item.getText());
                        data.add(Integer.toString(menu_item.getX()));
                        data.add(Integer.toString(menu_item.getY()));
                        ((ControlPanel) self).frame.component_editor.setRec(data);

                    }
                    public void mouseExited(MouseEvent evt) {
                        ((ControlPanel) self).frame.component_editor.reset();
                    }
                });
            } else if(component instanceof JCheckBoxMenuItem){
                check_box_menu_item = (JCheckBoxMenuItem) component;
                check_box_menu_item.setText(name);
                this.frame.design_panel.add(check_box_menu_item);

                Object self = this;
                check_box_menu_item.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent evt){
                        ((ControlPanel) self).frame.component_editor.selectComponent(check_box_menu_item);
                    }
                    public void mouseEntered(MouseEvent evt) {
                        //                            BeanInfo info = Introspector.getBeanInfo( label.getClass() );
//                            //System.out.println(info.getPropertyDescriptors());
//                            for ( PropertyDescriptor pd : info.getPropertyDescriptors() ) {
//                                    System.out.printf("%s : %s\n", pd.getDisplayName()); // javax.swing.JLabel //returns null !
//                            }
                        ArrayList<String> data = new ArrayList<String>();
                        data.add(check_box_menu_item.getUIClassID());
                        data.add(check_box_menu_item.getText());
                        data.add(Integer.toString(check_box_menu_item.getX()));
                        data.add(Integer.toString(check_box_menu_item.getY()));
                        ((ControlPanel) self).frame.component_editor.setRec(data);

                    }
                    public void mouseExited(MouseEvent evt) {
                        ((ControlPanel) self).frame.component_editor.reset();
                    }
                });
            } else if(component instanceof JRadioButtonMenuItem){
                radio_button_menu_item = (JRadioButtonMenuItem) component;
                radio_button_menu_item.setText(name);
                this.frame.design_panel.add(radio_button_menu_item);

                Object self = this;
                radio_button_menu_item.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent evt){
                        ((ControlPanel) self).frame.component_editor.selectComponent(radio_button_menu_item);
                    }
                    public void mouseEntered(MouseEvent evt) {
                        //                            BeanInfo info = Introspector.getBeanInfo( label.getClass() );
//                            //System.out.println(info.getPropertyDescriptors());
//                            for ( PropertyDescriptor pd : info.getPropertyDescriptors() ) {
//                                    System.out.printf("%s : %s\n", pd.getDisplayName()); // javax.swing.JLabel //returns null !
//                            }
                        ArrayList<String> data = new ArrayList<String>();
                        data.add(radio_button_menu_item.getUIClassID());
                        data.add(radio_button_menu_item.getText());
                        data.add(Integer.toString(radio_button_menu_item.getX()));
                        data.add(Integer.toString(radio_button_menu_item.getY()));
                        ((ControlPanel) self).frame.component_editor.setRec(data);

                    }
                    public void mouseExited(MouseEvent evt) {
                        ((ControlPanel) self).frame.component_editor.reset();
                    }
                });
            } else if(component instanceof JToggleButton){
                toggle_button = (JToggleButton) component;
                toggle_button.setText(name);
                this.frame.design_panel.add(toggle_button);

                Object self = this;
                toggle_button.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent evt){
                        ((ControlPanel) self).frame.component_editor.selectComponent(toggle_button);
                    }
                    public void mouseEntered(MouseEvent evt) {
                        //                            BeanInfo info = Introspector.getBeanInfo( label.getClass() );
//                            //System.out.println(info.getPropertyDescriptors());
//                            for ( PropertyDescriptor pd : info.getPropertyDescriptors() ) {
//                                    System.out.printf("%s : %s\n", pd.getDisplayName()); // javax.swing.JLabel //returns null !
//                            }
                        ArrayList<String> data = new ArrayList<String>();
                        data.add(toggle_button.getUIClassID());
                        data.add(toggle_button.getText());
                        data.add(Integer.toString(toggle_button.getX()));
                        data.add(Integer.toString(toggle_button.getY()));
                        ((ControlPanel) self).frame.component_editor.setRec(data);

                    }
                    public void mouseExited(MouseEvent evt) {
                        ((ControlPanel) self).frame.component_editor.reset();
                    }
                });
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
