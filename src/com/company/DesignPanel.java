package com.company;
import javax.swing.*;
import java.awt.*;

public class DesignPanel extends JPanel {
    final MainFrame frame;
    static int width, height;

    public DesignPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    //on the click of a component change it's proprieties
    public void change_component(){

    }

    public void init(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int) screenSize.getWidth() /2;
        height = (int) screenSize.getHeight() /2;
        setPreferredSize(new Dimension(width, height));
    }
}