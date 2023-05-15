package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuMain extends JFrame  {

    private JLabel label, labelTop;
    private JButton bt1, bt2;
    private JTextField tf;


    public MenuMain() {

        Container cont = this.getContentPane();

        label = new JLabel();

        Color ogange = new Color(251, 234, 235);
        Color blue = new Color(47, 60, 126);
        Color blue2 = new Color(204, 212, 255);
        cont.add(label);
        label.setLayout(new BorderLayout());
        this.getContentPane().setBackground(ogange);

        labelTop = new JLabel("Quản lý đăng ký ", SwingConstants.CENTER);
        label.add(labelTop, "North");
        labelTop.setForeground(blue);
        labelTop.setFont(new Font("NewellsHand", Font.PLAIN + Font.BOLD, 28));
        labelTop.setPreferredSize(new Dimension(0, 80));


        JLabel labelBot = new JLabel();

        label.add(labelBot);
        labelBot.setLayout(new GridLayout(2, 5));


        Dimension d = new Dimension(100, 40);
        bt1 = new JButton("Ôtô");
        bt1.setActionCommand("oto");
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if("oto".equals(e.getActionCommand()))
                {
                    dispose();

                    new Oto();
                }
            }
        });
        bt1.setBackground(blue2);
        bt1.setForeground(Color.black);
        bt1.setPreferredSize(d);

        bt2 = new JButton("Xe máy");
        bt2.setActionCommand("may");
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if("may".equals(e.getActionCommand()))
                {
                    dispose();
                    new Xemay();

                }
            }
        });
        bt2.setBackground(blue2);
        bt2.setForeground(Color.black);
        bt2.setPreferredSize(d);

        JPanel pn = new JPanel();
        labelBot.add(pn);


        pn.setBackground(ogange);

        pn.add(bt1);
        pn.add(bt2);


        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 215);
        setLocationRelativeTo(null);


    }


    public static void main(String[] args) {
        new MenuMain();

    }
};

