package view;



import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import ConnectSQL.Connect;

import java.awt.event.*;
import java.beans.JavaBean;
import java.sql.*;

import java.util.Vector;


public class Search extends JFrame {

    // private JPanel pnSearch = new JPanel();
    private JPanel pnMain = new JPanel();
    private JPanel pnData = new JPanel();

    private JComboBox cbb = new JComboBox<>();






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






    public  Search()
    {
        setLayout(new GridLayout(2,1));

        pnMain.setLayout(new BorderLayout());
        pnMain.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        pnMain.setBorder(new TitledBorder("Tìm kiếm"));

        pnData.setLayout(new BorderLayout());
        pnData.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        pnMain.add(cbb);

        Bottom();
        add(pnMain);
        add(pnData);
        setSize(840,480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
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
                    tfSoLoai.setText(table.getValueAt(table.getSelectedRow(),3)+"");
                    tfMauSon.setText(table.getValueAt(table.getSelectedRow(),4)+"");
                    tfSoMay.setText(table.getValueAt(table.getSelectedRow(),5)+"");
                    tfSoKhung.setText(table.getValueAt(table.getSelectedRow(),6)+"");
                    tfBienSo.setText(table.getValueAt(table.getSelectedRow(),7)+"");
                    tfDungTich.setText(table.getValueAt(table.getSelectedRow(),8)+"");
                    tfNgayDK.setText(table.getValueAt(table.getSelectedRow(),9)+"");
                }
            }
        });


    }








    public static void main(String[] args) {
        new Search();
    }
}
