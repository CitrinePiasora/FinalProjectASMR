/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;
import com.sun.jdi.connect.spi.Connection;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.table.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
        
/**
 *
 * @author Citrine
 */
public class Inventory extends javax.swing.JFrame {
    
    private int CurPersID = 0;
    boolean AdminPerms = true;

    Inventory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void Center() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    
    private void DropDownChoices() {
        ArrayList<String> ar = new ArrayList<String>();
        try {
            String SelStm = "SELECT * FROM Supplier";
            java.sql.Connection conn = Config.ConfigDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(SelStm);
            

            while(res.next()) {
                ar.add(res.getString(2));
            }
            
            Dropdown.setModel(new DefaultComboBoxModel(ar.toArray()));
        } catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void EmptyForm() {
        PriceField.setText("Harga");
        ItemField.setText("Nama Barang");
        StockField.setText("Stock");
        IIDField.setText("ID Barang");
        IIDField.setForeground(new Color(204, 204, 204));
        ItemField.setForeground(new Color(204, 204, 204));
        PriceField.setForeground(new Color(204, 204, 204));
        StockField.setForeground(new Color(204, 204, 204));
    }
    
    private void Show_Data(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Harga");
        model.addColumn("Stock");
        model.addColumn("ID Supplier");
        model.addColumn("Nama Supplier");
        Table.setModel(model);
        
        try {
            String SelStm = "SELECT Inventory.ItemID , Inventory.ItemName , Inventory.ItemPrice, Inventory.ItemQty, Inventory.SupplierID, Supplier.SupplierName FROM Supplier RIGHT JOIN Inventory ON Supplier.SupplierID = Inventory.SupplierID";
            java.sql.Connection conn = Config.ConfigDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(SelStm);
            

            while(res.next()) {
                model.addRow(new Object[]{res.getString(1), res.getString(2),res.getString(3), res.getString(4), res.getString(5), res.getString(6)});
            }
            
            Table.setModel(model);
            
        } catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void Show_DataStm(String SelStm){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Harga");
        model.addColumn("Stock");
        model.addColumn("ID Supplier");
        model.addColumn("Nama Supplier");
        Table.setModel(model);
        
        try {
            java.sql.Connection conn = Config.ConfigDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(SelStm);
            
            while(res.next()) {
                model.addRow(new Object[]{res.getString(1), res.getString(2),res.getString(3), res.getString(4), res.getString(5), res.getString(6)});
            }
            
            Table.setModel(model);
            
        } catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public Inventory(int PersID) {
        initComponents();
        Center();
        DropDownChoices();
        Show_Data();
        EmptyForm();
        this.CurPersID = PersID;
    }
    
    public Inventory(boolean Perms, int PersID) {
        initComponents();
        Center();
        Show_Data();
        EmptyForm();
        DropDownChoices();
        this.AdminPerms = Perms;
        this.CurPersID = PersID;
        
        if(Perms) {
            
        } else {
            PriceField.setFocusable(false);
            ItemField.setFocusable(false);
            Dropdown.setFocusable(false);
            StockField.setFocusable(false);
            IIDField.setFocusable(false);
            PriceField.setEnabled(false);
            ItemField.setEnabled(false);
            Dropdown.setEnabled(false);
            StockField.setEnabled(false);
            IIDField.setEnabled(false);
            AddData.setEnabled(false);
            Delete.setEnabled(false);
            Edit.setEnabled(false);
            Cancel.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ItemID = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        Price = new javax.swing.JLabel();
        ItemName = new javax.swing.JLabel();
        Stock = new javax.swing.JLabel();
        SupplierID = new javax.swing.JLabel();
        TablePane = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        IIDField = new javax.swing.JTextField();
        ItemField = new javax.swing.JTextField();
        PriceField = new javax.swing.JTextField();
        StockField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        ASMRSign = new javax.swing.JLabel();
        Cancel = new javax.swing.JButton();
        Edit = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        AddData = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        ASMRLogo = new javax.swing.JLabel();
        Search = new javax.swing.JButton();
        SearchBox = new javax.swing.JCheckBox();
        Dropdown = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(950, 750));
        setResizable(false);
        getContentPane().setLayout(null);

        ItemID.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        ItemID.setText("ID Barang");
        ItemID.setPreferredSize(new java.awt.Dimension(118, 26));
        getContentPane().add(ItemID);
        ItemID.setBounds(80, 80, 155, 26);

        Title.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        Title.setText("Inventory");
        getContentPane().add(Title);
        Title.setBounds(380, 20, 180, 34);

        Price.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        Price.setText("Harga");
        Price.setMaximumSize(new java.awt.Dimension(118, 26));
        Price.setMinimumSize(new java.awt.Dimension(118, 26));
        Price.setPreferredSize(new java.awt.Dimension(118, 26));
        getContentPane().add(Price);
        Price.setBounds(80, 190, 155, 26);

        ItemName.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        ItemName.setText("Nama Barang");
        ItemName.setMaximumSize(new java.awt.Dimension(118, 26));
        ItemName.setMinimumSize(new java.awt.Dimension(118, 26));
        ItemName.setPreferredSize(new java.awt.Dimension(118, 26));
        getContentPane().add(ItemName);
        ItemName.setBounds(80, 130, 155, 26);

        Stock.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        Stock.setText("Stock");
        Stock.setMaximumSize(new java.awt.Dimension(118, 26));
        Stock.setMinimumSize(new java.awt.Dimension(118, 26));
        Stock.setPreferredSize(new java.awt.Dimension(118, 26));
        getContentPane().add(Stock);
        Stock.setBounds(80, 250, 183, 26);

        SupplierID.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        SupplierID.setText("Supplier");
        getContentPane().add(SupplierID);
        SupplierID.setBounds(80, 310, 183, 26);

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        TablePane.setViewportView(Table);

        getContentPane().add(TablePane);
        TablePane.setBounds(84, 420, 769, 168);

        IIDField.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        IIDField.setForeground(new java.awt.Color(204, 204, 204));
        IIDField.setText("ID Barang");
        IIDField.setEnabled(false);
        IIDField.setFocusable(false);
        IIDField.setMaximumSize(new java.awt.Dimension(125, 26));
        IIDField.setMinimumSize(new java.awt.Dimension(125, 26));
        IIDField.setPreferredSize(new java.awt.Dimension(125, 26));
        IIDField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                IIDFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                IIDFieldFocusLost(evt);
            }
        });
        getContentPane().add(IIDField);
        IIDField.setBounds(280, 80, 570, 26);

        ItemField.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        ItemField.setForeground(new java.awt.Color(204, 204, 204));
        ItemField.setText("Nama Barang");
        ItemField.setMaximumSize(new java.awt.Dimension(125, 26));
        ItemField.setMinimumSize(new java.awt.Dimension(125, 26));
        ItemField.setName(""); // NOI18N
        ItemField.setPreferredSize(new java.awt.Dimension(125, 26));
        ItemField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ItemFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ItemFieldFocusLost(evt);
            }
        });
        getContentPane().add(ItemField);
        ItemField.setBounds(280, 130, 570, 26);

        PriceField.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        PriceField.setForeground(new java.awt.Color(204, 204, 204));
        PriceField.setText("Harga");
        PriceField.setMaximumSize(new java.awt.Dimension(125, 26));
        PriceField.setMinimumSize(new java.awt.Dimension(125, 26));
        PriceField.setPreferredSize(new java.awt.Dimension(125, 26));
        PriceField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PriceFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PriceFieldFocusLost(evt);
            }
        });
        getContentPane().add(PriceField);
        PriceField.setBounds(280, 190, 570, 26);

        StockField.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        StockField.setForeground(new java.awt.Color(204, 204, 204));
        StockField.setText("Stock");
        StockField.setMaximumSize(new java.awt.Dimension(125, 26));
        StockField.setMinimumSize(new java.awt.Dimension(125, 26));
        StockField.setPreferredSize(new java.awt.Dimension(125, 26));
        StockField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                StockFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                StockFieldFocusLost(evt);
            }
        });
        getContentPane().add(StockField);
        StockField.setBounds(280, 250, 570, 26);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparator1.setPreferredSize(new java.awt.Dimension(20000, 2));
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 606, 20000, 2);

        ASMRSign.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        ASMRSign.setText("A.S.M.R Advanced Store Management Repository by Goomers Inc. 1993 TM");
        getContentPane().add(ASMRSign);
        ASMRSign.setBounds(270, 680, 553, 34);

        Cancel.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });
        getContentPane().add(Cancel);
        Cancel.setBounds(280, 370, 110, 29);

        Edit.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        Edit.setText("Edit");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });
        getContentPane().add(Edit);
        Edit.setBounds(550, 370, 61, 29);

        Delete.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        Delete.setText("Hapus");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        getContentPane().add(Delete);
        Delete.setBounds(430, 370, 80, 29);

        AddData.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        AddData.setText("Tambah");
        AddData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddDataActionPerformed(evt);
            }
        });
        getContentPane().add(AddData);
        AddData.setBounds(100, 370, 140, 29);

        Exit.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        Exit.setText("Kembali");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        getContentPane().add(Exit);
        Exit.setBounds(750, 370, 90, 29);

        ASMRLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo2.png"))); // NOI18N
        getContentPane().add(ASMRLogo);
        ASMRLogo.setBounds(10, 610, 230, 120);

        Search.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        Search.setText("Cari");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
        getContentPane().add(Search);
        Search.setBounds(650, 370, 61, 29);

        SearchBox.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        SearchBox.setText("Cari");
        SearchBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBoxActionPerformed(evt);
            }
        });
        getContentPane().add(SearchBox);
        SearchBox.setBounds(860, 80, 53, 29);
        getContentPane().add(Dropdown);
        Dropdown.setBounds(280, 310, 140, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IIDFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IIDFieldFocusGained
        if(IIDField.getText().equals("ID Barang")) {
            IIDField.setText("");
            IIDField.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_IIDFieldFocusGained

    private void IIDFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IIDFieldFocusLost
        if(IIDField.getText().equals("")) {
            IIDField.setText("ID Barang");
            IIDField.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_IIDFieldFocusLost

    private void ItemFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ItemFieldFocusGained
        if(ItemField.getText().equals("Nama Barang")) {
            ItemField.setText("");
            ItemField.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_ItemFieldFocusGained

    private void ItemFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ItemFieldFocusLost
        if(ItemField.getText().equals("")) {
            ItemField.setText("Nama Barang");
            ItemField.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_ItemFieldFocusLost

    private void PriceFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PriceFieldFocusGained
        if(PriceField.getText().equals("Harga")) {
            PriceField.setText("");
            PriceField.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_PriceFieldFocusGained

    private void PriceFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PriceFieldFocusLost
        if(PriceField.getText().equals("")) {
            PriceField.setText("Harga");
            PriceField.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_PriceFieldFocusLost

    private void StockFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_StockFieldFocusLost
        if(StockField.getText().equals("")) {
            StockField.setText("Stock");
            StockField.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_StockFieldFocusLost

    private void StockFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_StockFieldFocusGained
        if(StockField.getText().equals("Stock")) {
            StockField.setText("");
            StockField.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_StockFieldFocusGained

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        if(this.AdminPerms == true) {
            this.setVisible(false);
            AdminMM Admin = new AdminMM(this.CurPersID);
            Admin.setVisible(true);
        } else {
            this.setVisible(false);
            UserMM User = new UserMM(this.CurPersID);
            User.setVisible(true);
        }
    }//GEN-LAST:event_ExitActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        EmptyForm();
        Show_Data();
    }//GEN-LAST:event_CancelActionPerformed

    private void AddDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddDataActionPerformed
        if(ItemField.getText().equals("Nama Barang") ||
                PriceField.getText().equals("Harga") || StockField.getText().equals("Stock")) {
            
            JOptionPane.showMessageDialog(null, "Please fill in all fields before proceeding");
        } else {
            String SupID = "";
                try {
                    String SelStm = "SELECT * FROM Supplier";
                    java.sql.Connection conn = Config.ConfigDB();
                    java.sql.Statement stm = conn.createStatement();
                    java.sql.ResultSet res = stm.executeQuery(SelStm);


                while(res.next()) {
                    if(res.getString(2).equals(Dropdown.getSelectedItem())) {
                        SupID = res.getString(1);
                    }
                }
            } catch(SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        
            try {
                String stm = "";
                if(IIDField.getText().equals("ID Barang")) {
                    stm = "INSERT INTO Inventory VALUES (NULL, '" +
                    ItemField.getText() + "', '" + PriceField.getText() + "', '" +
                    StockField.getText() + "', '" + SupID + "');";
                } else {
                    stm = "INSERT INTO Inventory VALUES ('" + IIDField.getText() + "', '" +
                    ItemField.getText() + "', '" + PriceField.getText() + "', '" +
                    StockField.getText() + "', '" + SupID + "');";
                }
                
                java.sql.Connection conn = Config.ConfigDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(stm);
                pstm.execute();
                JOptionPane.showMessageDialog(null, "Changes have been saved");
                Show_Data();
                EmptyForm();
            } catch(HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_AddDataActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        int row = Table.rowAtPoint(evt.getPoint());
        IIDField.setText(Table.getValueAt(row, 0).toString());
        ItemField.setText(Table.getValueAt(row, 1).toString());
        PriceField.setText(Table.getValueAt(row, 2).toString());
        StockField.setText(Table.getValueAt(row, 3).toString());
        Dropdown.getModel().setSelectedItem(Table.getValueAt(row, 5).toString());
        IIDField.setForeground(new Color(0, 0, 0));
        ItemField.setForeground(new Color(0, 0, 0));
        PriceField.setForeground(new Color(0, 0, 0));
        StockField.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_TableMouseClicked

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        if(IIDField.getText().equals("ID Barang") || ItemField.getText().equals("Nama Barang") ||
                PriceField.getText().equals("Harga") || StockField.getText().equals("Stock")) {
            
            JOptionPane.showMessageDialog(null, "Please fill in all fields before proceeding");
        } else {
            String SupID = "";
                try {
                    String SelStm = "SELECT * FROM Supplier";
                    java.sql.Connection conn = Config.ConfigDB();
                    java.sql.Statement stm = conn.createStatement();
                    java.sql.ResultSet res = stm.executeQuery(SelStm);


                while(res.next()) {
                    if(res.getString(2).equals(Dropdown.getSelectedItem())) {
                        SupID = res.getString(1);
                    }
                }
            } catch(SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
                
            try {
                String stm = "UPDATE Inventory SET ItemID='" + IIDField.getText() + "', ItemName='" +
                    ItemField.getText() + "', ItemPrice='" + PriceField.getText() + "', ItemQty='" +
                    StockField.getText() + "', SupplierID='" + SupID + "' WHERE ItemID='" + IIDField.getText() + "';";
                
                java.sql.Connection conn = Config.ConfigDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(stm);
                pstm.execute();
                JOptionPane.showMessageDialog(null, "Edit successful");
                Show_Data();
                EmptyForm();
            } catch(HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_EditActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        if(IIDField.getText().equals("ID Barang") || ItemField.getText().equals("Nama Barang") ||
                PriceField.getText().equals("Harga") || StockField.getText().equals("Stock")) {
            
            JOptionPane.showMessageDialog(null, "Please fill in all fields before proceeding");
        } else {
        try {
            String stm = "DELETE FROM Inventory WHERE ItemID='" + IIDField.getText() + "'";
                
            java.sql.Connection conn = Config.ConfigDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(stm);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Delete successful");
            Show_Data();
            EmptyForm();
            
            } catch(HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        int FieldsFilled = 0;
        
        List<String> Stms = new ArrayList<>(Arrays.asList(" AND ItemID LIKE '%"+ IIDField.getText() + "%'",
                " AND ItemName LIKE '%"+ ItemField.getText() + "%'", " AND ItemPriceAtSale LIKE '%"+ PriceField.getText() + "%'",
                " AND ItemQty LIKE '%" + StockField.getText() + "%'"));
        List<String> Checks = List.of("ID Barang", "Nama Barang", "Harga", "Stock", "ID Supplier");
        List<javax.swing.JTextField> Fields = List.of(IIDField, ItemField, PriceField, StockField);
        
        for(int i = 0; i < Fields.size(); i++) {
            if(Fields.get(i).getText().equals(Checks.get(i))) {
                Stms.set(i, "");
            } else{
                FieldsFilled++;
            }
        }
        
        if(FieldsFilled <= 0) {
            JOptionPane.showMessageDialog(null, "Please fill in at least one field");
        
        } else {
            try {
                String stm = "SELECT Inventory.ItemID , Inventory.ItemName , Inventory.ItemPrice, Inventory.ItemQty, Inventory.SupplierID, Supplier.SupplierName FROM Supplier, Inventory WHERE Supplier.SupplierID = Inventory.SupplierID";                    
                stm = Stms.stream().map((i) -> i).reduce(stm, String::concat);
                stm += ";";
                
                System.out.println(stm);

                java.sql.Connection conn = Config.ConfigDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(stm);
                pstm.execute();
                Show_DataStm(stm);;
                EmptyForm();

                } catch(HeadlessException | SQLException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_SearchActionPerformed

    private void SearchBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBoxActionPerformed
        if(SearchBox.isSelected() && !this.AdminPerms) {
            IIDField.setEnabled(true);
            PriceField.setEnabled(true);
            ItemField.setEnabled(true);
            Dropdown.setEnabled(true);
            StockField.setEnabled(true);
            IIDField.setFocusable(true);
            PriceField.setFocusable(true);
            ItemField.setFocusable(true);
            Dropdown.setFocusable(true);
            StockField.setFocusable(true);
            
        } else if(!SearchBox.isSelected() && !this.AdminPerms){
            IIDField.setEnabled(false);
            PriceField.setEnabled(false);
            ItemField.setEnabled(false);
            Dropdown.setEnabled(false);
            StockField.setEnabled(false);
            IIDField.setFocusable(false);
            PriceField.setFocusable(false);
            ItemField.setFocusable(false);
            Dropdown.setFocusable(false);
            StockField.setFocusable(false);
        } else if(SearchBox.isSelected() && this.AdminPerms) {
            IIDField.setEnabled(true);
            IIDField.setFocusable(true);
        } else {
            IIDField.setEnabled(false);
            IIDField.setFocusable(false);
        }
    }//GEN-LAST:event_SearchBoxActionPerformed
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserMM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventory().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ASMRLogo;
    private javax.swing.JLabel ASMRSign;
    private javax.swing.JButton AddData;
    private javax.swing.JButton Cancel;
    private javax.swing.JButton Delete;
    private javax.swing.JComboBox<String> Dropdown;
    private javax.swing.JButton Edit;
    private javax.swing.JButton Exit;
    private javax.swing.JTextField IIDField;
    private javax.swing.JTextField ItemField;
    private javax.swing.JLabel ItemID;
    private javax.swing.JLabel ItemName;
    private javax.swing.JLabel Price;
    private javax.swing.JTextField PriceField;
    private javax.swing.JButton Search;
    private javax.swing.JCheckBox SearchBox;
    private javax.swing.JLabel Stock;
    private javax.swing.JTextField StockField;
    private javax.swing.JLabel SupplierID;
    private javax.swing.JTable Table;
    private javax.swing.JScrollPane TablePane;
    private javax.swing.JLabel Title;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
