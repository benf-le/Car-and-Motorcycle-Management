package view;



import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import ConnectSQL.Connect;

import java.awt.event.*;
import java.sql.*;

import java.util.Vector;


public class Xemay extends JFrame {

    // private JPanel pnSearch = new JPanel();
    private JPanel pnMain = new JPanel();
    private JPanel pnData = new JPanel();

    private JTable tab = new JTable();



    JLabel lbID = new JLabel("                                        Mã định danh:");
    JLabel lbTen = new JLabel("                                        Tên chủ xe:");
    JLabel lbSoMay = new JLabel("                                        Số máy:");
    JLabel lbSoKhung = new JLabel("                                        Số Khung:");
    JLabel lbNgayDK = new JLabel("                                        Ngày đăng ký:");
    JLabel lbNhanHieu = new JLabel("                                        Nhãn hiệu:");
    JLabel lbMauSon = new JLabel("                                        Màu sơn:");
    JLabel lbSoLoai = new JLabel("                                        Số loại");
    JLabel lbDungTich = new JLabel("                                        Dung tích:");
    JLabel lbBienSo = new JLabel("                                        Biển số đăng ký:");
    JLabel lbkiem = new JLabel("Tim kiem");






    JTextField tfID = new JTextField();
    JTextField tfTen = new JTextField();
    JTextField tfSoMay = new JTextField();
    JTextField tfSoKhung = new JTextField();
    JTextField tfNgayDK = new JTextField();
    JTextField tfNhanHieu = new JTextField();
    JTextField tfMauSon= new JTextField();
    JTextField tfSoLoai = new JTextField();
    JTextField tfDungTich = new JTextField();
    JTextField tfBienSo = new JTextField();









    Vector vdata = new Vector();
    Vector vtile = new Vector();

    DefaultTableModel tableModel=new DefaultTableModel(vdata,vtile);






    public  Xemay()
    {
        setLayout(new GridLayout(2,1));

        pnMain.setLayout(new BorderLayout());
        pnMain.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        pnMain.setBorder(new TitledBorder("Nhập thông tin xe"));

        pnData.setLayout(new BorderLayout());
        pnData.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        Top();
        Button();
        Bottom();
        add(pnMain);
        add(pnData);
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void Top()
    {


        JPanel pnIn4 = new JPanel();
        pnMain.add(pnIn4);
        pnIn4.setLayout(new GridLayout(5,2));







        pnIn4.add(lbID);
        pnIn4.add(tfID);
        pnIn4.add(lbSoMay);
        pnIn4.add(tfSoMay);
        pnIn4.add(lbTen);
        pnIn4.add(tfTen);
        pnIn4.add(lbSoKhung);
        pnIn4.add(tfSoKhung);
        pnIn4.add(lbNhanHieu);
        pnIn4.add(tfNhanHieu);


        pnIn4.add(lbMauSon);
        pnIn4.add(tfMauSon);
        pnIn4.add(lbSoLoai);
        pnIn4.add(tfSoLoai);
        pnIn4.add(lbDungTich);
        pnIn4.add(tfDungTich);
        pnIn4.add(lbBienSo);
        pnIn4.add(tfBienSo);
        pnIn4.add(lbNgayDK);
        pnIn4.add(tfNgayDK);








    }

    public void Button()
    {

        JPanel pnBt = new JPanel();
        pnMain.add(pnBt,"South");
        pnBt.setLayout(new FlowLayout());
        Dimension d = new Dimension(120,30);


        JButton btDky = new JButton("Thêm");
        btDky.setPreferredSize(d);
        btDky.setIcon(new ImageIcon(getClass().getResource("/Images/add-icon.png") ));
        btDky.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date Dky = Date.valueOf(tfNgayDK.getText());
                try{

                    Connection conn = Connect.getConnection();
                    String sql = "INSERT INTO dbo.Xemay" +
                            "(MaDinhDanh,TenChuXe,NhanHieu,SoLoai,MauSon,SoMay,SoKhung,BienSo,DungTich,NgayDangKy)" +
                            "VALUES(?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement prm = conn.prepareStatement(sql);
                    prm.setString(1,tfID.getText());
                    prm.setString(2,tfTen.getText());
                    prm.setString(3,tfNhanHieu.getText());
                    prm.setString(4,tfSoLoai.getText());
                    prm.setString(5,tfMauSon.getText());
                    prm.setString(6,tfSoMay.getText());
                    prm.setString(7,tfSoKhung.getText());
                    prm.setString(8,tfBienSo.getText());
                    prm.setInt(9,Integer.parseInt(tfDungTich.getText()));
                    prm.setString(10,String.valueOf(Dky));




                    int chk = prm.executeUpdate();
                    if(chk >= 0){
                        JOptionPane.showMessageDialog(rootPane,"Đã thêm mới dữ liệu!");
                        updateTable();
                    Datlai();}
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }



            }

        });

        //lam nut hien thi thong tin khi nhan chuot

        tab.setModel(tableModel);
        tab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DefaultTableModel tableModel=new DefaultTableModel(vdata,vtile);
                int selectedIndex = tab.getSelectedRow();
                tfID.setText(tableModel.getValueAt(selectedIndex,1).toString());
                tfTen.setText(tableModel.getValueAt(selectedIndex,2).toString());
                tfNhanHieu.setText(tableModel.getValueAt(selectedIndex,3).toString());
                tfSoLoai.setText(tableModel.getValueAt(selectedIndex,4).toString());
                tfMauSon.setText(tableModel.getValueAt(selectedIndex,5).toString());
                tfSoMay.setText(tableModel.getValueAt(selectedIndex,6).toString());
                tfSoKhung.setText(tableModel.getValueAt(selectedIndex,7).toString());
                tfBienSo.setText(tableModel.getValueAt(selectedIndex,8).toString());
                tfDungTich.setText(tableModel.getValueAt(selectedIndex,9).toString());
                tfNgayDK.setText(tableModel.getValueAt(selectedIndex,10).toString());

            }
        });

        JButton btSua = new JButton("Sửa");
        btSua.setPreferredSize(d);
        btSua.setIcon(new ImageIcon(getClass().getResource("/Images/edit.png") ));
        btSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Date Dky = Date.valueOf(tfNgayDK.getText());

                try
                {
                    Connection conn = Connect.getConnection();
                    String sql = "UPDATE dbo.Xemay SET TenChuXe = ? ,NhanHieu = ? ,SoLoai = ? ,MauSon = ? ,SoMay = ?" +
                            " ,SoKhung = ? ,BienSo = ? ,DungTich = ? ,NgayDangKy = ?  WHERE MaDinhDanh = ? " ;
                    PreparedStatement prm = conn.prepareStatement(sql);

                    prm.setString(1,tfTen.getText());
                    prm.setString(2,tfNhanHieu.getText());
                    prm.setString(3,tfSoLoai.getText());
                    prm.setString(4,tfMauSon.getText());
                    prm.setString(5,tfSoMay.getText());
                    prm.setString(6,tfSoKhung.getText());
                    prm.setString(7,tfBienSo.getText());
                    prm.setInt(8,Integer.parseInt(tfDungTich.getText()));
                    prm.setString(9,String.valueOf(Dky));
                    prm.setString(10,tfID.getText());

                    int chk = prm.executeUpdate();
                    if(chk > 0){
                        JOptionPane.showMessageDialog(rootPane,"Đã chỉnh sửa dữ liệu!");
                        updateTable();
                        Datlai();
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton btXoa = new JButton("Xóa");
        btXoa.setPreferredSize(d);
        btXoa.setIcon(new ImageIcon(getClass().getResource("/Images/delete.png") ));
        btXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date Dky = Date.valueOf(tfNgayDK.getText());

                try
                {
                    Connection conn = Connect.getConnection();
                    String sql = "DELETE FROM Xemay  WHERE MaDinhDanh = ? " ;
                    PreparedStatement prm = conn.prepareStatement(sql);

                    prm.setString(1,tfID.getText());

                    int chk = prm.executeUpdate();
                    if(chk > 0){
                        JOptionPane.showMessageDialog(rootPane,"Đã xóa dữ liệu!");
                        updateTable();
                        Datlai();
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        JButton btRefesh = new JButton("Làm mới");
        btRefesh.setPreferredSize(d);
        btRefesh.setIcon(new ImageIcon(getClass().getResource("/Images/reload.png") ));
        btRefesh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {


                    updateTable();
                    Datlai();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });
        JButton btKiem = new JButton("Tìm kiếm");
        btKiem.setPreferredSize(d);
        btKiem.setIcon(new ImageIcon(getClass().getResource("/Images/search.png") ));
        btKiem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
              /* super.keyTyped(e);
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    try {
                        vdata.clear();
                        vtile.clear();
                        Connection conn = Connect.getConnection();
                        String sql = ("SELECT TenChuXe,NhanHieu,SoLoai,MauSon,SoMay,SoKhung,BienSo,DungTich,NgayDangKy" +
                                "FROM Xemay" +
                                "WHERE MaDinhDanh AND (name LIKE ('%'+?+'%') or title LIKE ('%'+?+'%'))");
                        String name = btKiem.getText();
                        String title = .getText();
                        insert.setNString(1,name);
                        insert.setString(2,title);
                        ResultSet rs = insert.executeQuery();
                        ResultSetMetaData rstmeta=rs.getMetaData();
                        int num_column =rstmeta.getColumnCount();
                        //System.out.println(num_column);
                        for (int i=1;i<=num_column;i++)
                            vtile.add(rstmeta.getColumnLabel(i));
                        while (rs.next()) {
                            Vector row = new Vector();
                            for (int i = 1; i <=num_column; i++) {
                                row.add(rs.getString(i));
                            }
                            vdata.add(row);
                        }
                        tableModel.setDataVector(vdata,vtile);
                    }
                    catch (SQLException | IllegalArgumentException ex)
                    {
                        JOptionPane.showMessageDialog(rootPane,ex);
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    tfID.setText("");
                }*/
            }
        });

        JButton btBack = new JButton("Trở về");
        btBack.setPreferredSize(d);
        btBack.setIcon(new ImageIcon(getClass().getResource("/Images/back.png") ));
        btBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuMain();
                dispose();
            }
        });




        pnBt.add(btDky);
        pnBt.add(btSua);
        pnBt.add(btXoa);
        pnBt.add(btRefesh);
        pnBt.add(btKiem);
        pnBt.add(btBack);
    }

    public void Bottom()
    {

        JTable table = new JTable();
        try{
            Connection conn = Connect.getConnection();

            int number;
            Vector row,clumn;
            clumn = new Vector();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM dbo.Xemay" +
                    " ORDER BY MaDinhDanh ASC");
            ResultSetMetaData metaData = rs.getMetaData();
            number = metaData.getColumnCount();

            for(int i = 1;i<= number;i++){
                clumn.add(metaData.getColumnName(i));
            }
            tableModel.setColumnIdentifiers(clumn);
            while (rs.next()){
                row = new Vector();
                for(int i = 1;i<= number;i++){
                    row.addElement(rs.getString(i));
                }
                tableModel.addRow(row);
                table.setModel(tableModel);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }




        JScrollPane tableResult = new JScrollPane(table);
        pnData.add(tableResult);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(table.getSelectedRow()>= 0){
                    tfID.setText(table.getValueAt(table.getSelectedRow(),0)+"");
                    tfTen.setText(table.getValueAt(table.getSelectedRow(),1)+"");
                    tfNhanHieu.setText(table.getValueAt(table.getSelectedRow(),2)+"");
                    tfSoMay.setText(table.getValueAt(table.getSelectedRow(),3)+"");
                    tfSoKhung.setText(table.getValueAt(table.getSelectedRow(),4)+"");
                    tfSoLoai.setText(table.getValueAt(table.getSelectedRow(),5)+"");
                    tfMauSon.setText(table.getValueAt(table.getSelectedRow(),6)+"");
                    tfBienSo.setText(table.getValueAt(table.getSelectedRow(),7)+"");
                    tfDungTich.setText(table.getValueAt(table.getSelectedRow(),8)+"");
                    tfNgayDK.setText(table.getValueAt(table.getSelectedRow(),9)+"");
                }
            }
        });


    }







    public void updateTable(){
        try {
            vdata.clear();
            vtile.clear();
            Connection conn = Connect.getConnection();
            Statement st ;
            String sqlf="\n" +
                    "SELECT MaDinhDanh,TenChuXe,MauSon,SoMay,SoKhung,NhanHieu,SoLoai,BienSo,DungTich,NgayDangKy   FROM Xemay";
            ResultSet rs ;
            st = conn.createStatement();
            rs = st.executeQuery(sqlf);
            ResultSetMetaData rstmeta=rs.getMetaData();
            int num_column =rstmeta.getColumnCount();

            for (int i=1;i<=num_column;i++)
                vtile.add(rstmeta.getColumnLabel(i));

            while (rs.next()) {
                Vector row = new Vector();
                for (int i = 1; i <=num_column; i++) {
                    row.add(rs.getString(i));
                }
                vdata.add(row);
            }
            tableModel.setDataVector(vdata,vtile);

        }
        catch(SQLException | IllegalArgumentException ex){
            JOptionPane.showMessageDialog(rootPane,ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void Datlai()
    {
        tfID.setText(" ");
        tfTen.setText(" ");
        tfNgayDK.setText(" ");
        tfBienSo.setText(" ");
        tfDungTich.setText(" ");
        tfMauSon.setText(" ");
        tfNhanHieu.setText(" ");
        tfSoKhung.setText(" ");
        tfSoLoai.setText(" ");
        tfSoMay.setText(" ");

    }


    public static void main(String[] args) {
        new Xemay();
    }
}
