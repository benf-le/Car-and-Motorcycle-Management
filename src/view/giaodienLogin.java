package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.ImageIcon;
import ConnectSQL.LoginControl;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;


public class giaodienLogin extends JFrame {

    private JLabel label, labelNorth, labelSouth, labelWest, labelEast;
    private JLabel lbCenter = new JLabel();
    private JButton btDangNhap, btThoat;
    private JTextField tfTK = new JTextField();
    private JPasswordField tfMK = new JPasswordField();
    private JLabel lbTK = new JLabel("Tài khoản: ");
    private JLabel lbMK = new JLabel("Mật khẩu: ");

    public giaodienLogin() {
        Container cont = this.getContentPane();
        label = new JLabel();
        //label.setIcon(new ImageIcon(getClass().getResource("/Images/login.png" )));
        labelNorth = new JLabel("ĐĂNG NHẬP HỆ THỐNG", SwingConstants.CENTER);
        labelNorth.setForeground(Color.RED);
        labelNorth.setFont(new Font("NewellsHand", Font.PLAIN + Font.BOLD, 28));
        labelSouth = new JLabel();
        labelEast = new JLabel();
        labelWest = new JLabel();


        cont.add(label);
        label.setLayout(new BorderLayout());

        label.add(labelEast, "East");
        labelEast.setPreferredSize(new Dimension(110, 0));

        label.add(labelSouth, "South");
        labelSouth.setPreferredSize(new Dimension(0, 80));

        label.add(labelWest, "West");
        labelWest.setPreferredSize(new Dimension(110, 0));

        label.add(labelNorth, "North");
        labelNorth.setPreferredSize(new Dimension(0, 80));


        LabelCenter();

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650, 450);
        setLocationRelativeTo(null);

    }
    public boolean checkValidateForm() {
        if (tfTK.getText().isEmpty() || tfMK.getText().isEmpty()) {
            return false;
        }
        return true;
    }

public void LabelCenter() {

        label.add(lbCenter);
        lbCenter.setLayout(new BorderLayout(0, 7));

        JLabel labelunp = new JLabel();
        JPanel pnSouth = new JPanel();

        btDangNhap = new JButton("Đăng nhập");
        btDangNhap.setActionCommand("dn");
        btDangNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = tfTK.getText();
                String pass = String.valueOf(tfMK.getPassword());
                StringBuilder stb = new StringBuilder();

                if(user.equals("")){
                    stb.append("Vui lòng nhập Số tài khoản\n");
                }
                if(pass.equals("")){
                    stb.append("Vui lòng nhập Mật khẩu");
                }
                if(stb.length() > 0){
                    JOptionPane.showMessageDialog(btDangNhap,stb.toString());
                }
                else {
                    try {
                        LoginControl lc = new LoginControl();
                        if (lc.checkLogin(user, pass)) {
                            JOptionPane.showMessageDialog(rootPane, "Đăng nhập thành công");
                            dispose();
                           // new ViewMain();
                            new MenuMain();
                        }
                        else {
                            JOptionPane.showMessageDialog(rootPane, "Tài khoản hoặc mật khẩu không đúng");}

                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            }
        });
        Dimension d = new Dimension(100, 30);
        btDangNhap.setPreferredSize(d);
        btThoat = new JButton("Thoát");
        btThoat.setActionCommand("exit");
        btThoat.addActionListener(new ActionListener() {
                                      public void actionPerformed(ActionEvent e) {
                                          if ("exit".equals(e.getActionCommand())) {
                                              int anw = JOptionPane.showConfirmDialog(rootPane, "Bạn thật sự có muốn thoát?", "Cảnh báo!", JOptionPane.YES_NO_OPTION);
                                              if (anw == 0) {
                                                  System.exit(0);
                                              }
                                          }

                                      }
                                  });
        btThoat.setPreferredSize(d);

        lbTK.setIcon(new ImageIcon(getClass().getResource("/Images/userlogin.png") ));
        lbMK.setIcon(new ImageIcon(getClass().getResource("/Images/password.png") ));

        lbCenter.add(labelunp);
        lbCenter.add(pnSouth, "South");
        pnSouth.setLayout(new FlowLayout());

        pnSouth.add(btDangNhap);
        pnSouth.add(btThoat);


        labelunp.setLayout(new GridLayout(5, 1, 0, 1));

        labelunp.add(lbTK);
        labelunp.add(tfTK);
        labelunp.add(lbMK);
        labelunp.add(tfMK);


    }


    public static void main(String[] args) {
        new giaodienLogin();
    }


}


