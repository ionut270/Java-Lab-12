package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DesignPanel extends JPanel implements java.io.Serializable {
    final MainFrame frame;

    static int width, height;

    public DesignPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    public void init(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int) screenSize.getWidth() /2;
        height = (int) screenSize.getHeight() /2;
        setPreferredSize(new Dimension(width, height));
    }
}