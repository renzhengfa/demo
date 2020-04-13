package com.ren.frame;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class FirstFram {
//中软国际
    public static void main(String[] args) {
        JComboBox combo = new JComboBox();
        combo.setEditable(true);
        for (int i = 0; i < 10; i++) {
            combo.addItem(i);
        }
        JLabel tip = new JLabel();
        tip.setText("Outside combobox");
        JPanel panel = new JPanel();
        panel.add(combo);
        panel.add(tip);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                tip.setText("Outside combobox");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                Component c = SwingUtilities.getDeepestComponentAt(e.getComponent(),
                        e.getX(), e.getY());
                tip.setText(c != null && SwingUtilities.isDescendingFrom(c, combo) ? "Inside combo box"
                        : "Outside combobox");
            }
        });
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

}
