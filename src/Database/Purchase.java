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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.*;
        
/**
 *
 * @author Citrine
 */
public class Purchase extends javax.swing.JFrame {
    
    private int CurPersID = 0;
    boolean AdminPerms = true;
    private ArrayList<String> PurchaseStms = new ArrayList<String>();
    private ArrayList<String> InventoryStms = new ArrayList<String>();
    private int rowToDel = 0;
    private int total = 0;

    private Purchase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }
        
    private void Center() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    
    private void EmptyForm() {
        ItemIDField.setText("ID");
        SubtotalField.setText("No. Terjual");
        NameField.setText("Nama Barang");
        TotalField.setText("0");
        ItemIDField.setForeground(new Color(204, 204, 204));
        NameField.setForeground(new Color(204, 204, 204));
        SubtotalField.setForeground(new Color(204, 204, 204));
    }
    
    private void Show_Data(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama Barang");
        model.addColumn("Harga");
        model.addColumn("Stock");
        InventoryTable.setModel(model);
        
        try {
            String SelStm = "SELECT * FROM Inventory";
            java.sql.Connection conn = Config.ConfigDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(SelStm);
            
            while(res.next()) {
                model.addRow(new Object[]{res.getString(1), res.getString(2),
                        res.getString(3), res.getString(4)});
            }
            
            InventoryTable.setModel(model);
            
        } catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void Show_DataStm(String SelStm){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama Barang");
        model.addColumn("Harga");
        model.addColumn("Stock");
        InventoryTable.setModel(model);
        
        try {
            java.sql.Connection conn = Config.ConfigDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(SelStm);
            
            while(res.next()) {
                model.addRow(new Object[]{res.getString(1), res.getString(2),
                        res.getString(3), res.getString(4)});
            }
            
            InventoryTable.setModel(model);
            
        } catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void QueryDataInit() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama Barang");
        model.addColumn("No. Terjual");
        model.addColumn("Harga");
        model.addColumn("Subtotal");
        PurchasesTable.setModel(model);
    }
    
    private void QueryDataInsert(String ID, String Name, String Qty, String Price, String Subtotal) {
        DefaultTableModel model = (DefaultTableModel)PurchasesTable.getModel();
        model.addRow(new Object[]{ID, Name, Qty, Price, Subtotal});
        PurchasesTable.setModel(model);
    }
    
    private void QueryDataDel() {
        DefaultTableModel model = (DefaultTableModel)PurchasesTable.getModel();
        model.removeRow(this.rowToDel);
        PurchasesTable.setModel(model);
    }
    
    public Purchase(int PersID) {
        initComponents();
        Center();
        QueryDataInit();
        Show_Data();
        EmptyForm();
        this.CurPersID = PersID;
    }
    
    public Purchase(boolean Perms, int PersID) {
        initComponents();
        Center();
        QueryDataInit();
        Show_Data();
        EmptyForm();
        this.AdminPerms = Perms;
        this.CurPersID = PersID;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        ItemID = new javax.swing.JLabel();
        ItemName = new javax.swing.JLabel();
        NoPurchased = new javax.swing.JLabel();
        TablePane = new javax.swing.JScrollPane();
        InventoryTable = new javax.swing.JTable();
        ItemIDField = new javax.swing.JTextField();
        NameField = new javax.swing.JTextField();
        SubtotalField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        ASMRSign = new javax.swing.JLabel();
        Rollback = new javax.swing.JButton();
        Edit = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        AddData = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        ASMRLogo = new javax.swing.JLabel();
        Search = new javax.swing.JButton();
        QtySpinner = new javax.swing.JSpinner();
        SubtotalLabel = new javax.swing.JLabel();
        PriceLabel = new javax.swing.JLabel();
        PriceField = new javax.swing.JTextField();
        AddQuery = new javax.swing.JButton();
        TablePane2 = new javax.swing.JScrollPane();
        PurchasesTable = new javax.swing.JTable();
        TotalField = new javax.swing.JTextField();
        RevertTable = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(950, 750));
        setPreferredSize(new java.awt.Dimension(950, 756));
        setResizable(false);
        getContentPane().setLayout(null);

        Title.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        Title.setText("Point of Sales");
        getContentPane().add(Title);
        Title.setBounds(380, 20, 180, 34);

        ItemID.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        ItemID.setText("ID");
        ItemID.setMaximumSize(new java.awt.Dimension(118, 26));
        ItemID.setMinimumSize(new java.awt.Dimension(118, 26));
        ItemID.setPreferredSize(new java.awt.Dimension(118, 26));
        getContentPane().add(ItemID);
        ItemID.setBounds(110, 70, 30, 26);

        ItemName.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        ItemName.setText("Nama Barang");
        ItemName.setMaximumSize(new java.awt.Dimension(118, 26));
        ItemName.setMinimumSize(new java.awt.Dimension(118, 26));
        ItemName.setPreferredSize(new java.awt.Dimension(118, 26));
        getContentPane().add(ItemName);
        ItemName.setBounds(200, 70, 183, 26);

        NoPurchased.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        NoPurchased.setText("No. Terjual");
        getContentPane().add(NoPurchased);
        NoPurchased.setBounds(400, 70, 90, 26);

        InventoryTable.setModel(new javax.swing.table.DefaultTableModel(
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
        InventoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InventoryTableMouseClicked(evt);
            }
        });
        TablePane.setViewportView(InventoryTable);

        getContentPane().add(TablePane);
        TablePane.setBounds(50, 200, 840, 150);

        ItemIDField.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        ItemIDField.setForeground(new java.awt.Color(204, 204, 204));
        ItemIDField.setText("ID");
        ItemIDField.setEnabled(false);
        ItemIDField.setFocusable(false);
        ItemIDField.setMaximumSize(new java.awt.Dimension(125, 26));
        ItemIDField.setMinimumSize(new java.awt.Dimension(125, 26));
        ItemIDField.setPreferredSize(new java.awt.Dimension(125, 26));
        getContentPane().add(ItemIDField);
        ItemIDField.setBounds(100, 100, 40, 30);

        NameField.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        NameField.setForeground(new java.awt.Color(204, 204, 204));
        NameField.setText("Nama Barang");
        NameField.setMaximumSize(new java.awt.Dimension(125, 26));
        NameField.setMinimumSize(new java.awt.Dimension(125, 26));
        NameField.setPreferredSize(new java.awt.Dimension(125, 26));
        NameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                NameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                NameFieldFocusLost(evt);
            }
        });
        getContentPane().add(NameField);
        NameField.setBounds(190, 100, 160, 30);

        SubtotalField.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        SubtotalField.setForeground(new java.awt.Color(204, 204, 204));
        SubtotalField.setText("Subtotal");
        SubtotalField.setEnabled(false);
        SubtotalField.setFocusable(false);
        SubtotalField.setMaximumSize(new java.awt.Dimension(125, 26));
        SubtotalField.setMinimumSize(new java.awt.Dimension(125, 26));
        SubtotalField.setPreferredSize(new java.awt.Dimension(125, 26));
        SubtotalField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SubtotalFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SubtotalFieldFocusLost(evt);
            }
        });
        getContentPane().add(SubtotalField);
        SubtotalField.setBounds(730, 100, 110, 30);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparator1.setPreferredSize(new java.awt.Dimension(20000, 2));
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 606, 20000, 2);

        ASMRSign.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        ASMRSign.setText("A.S.M.R Advanced Store Management Repository by Goomers Inc. 1993 TM");
        getContentPane().add(ASMRSign);
        ASMRSign.setBounds(270, 680, 553, 34);

        Rollback.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        Rollback.setText("Bersihkan");
        Rollback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RollbackActionPerformed(evt);
            }
        });
        getContentPane().add(Rollback);
        Rollback.setBounds(800, 560, 110, 29);

        Edit.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        Edit.setText("Edit");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });
        getContentPane().add(Edit);
        Edit.setBounds(780, 430, 80, 29);

        Delete.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        Delete.setText("Hapus");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        getContentPane().add(Delete);
        Delete.setBounds(780, 380, 80, 29);

        AddData.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        AddData.setText("Commit");
        AddData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddDataActionPerformed(evt);
            }
        });
        getContentPane().add(AddData);
        AddData.setBounds(630, 560, 140, 29);

        Exit.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        Exit.setText("Kembali");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        getContentPane().add(Exit);
        Exit.setBounds(820, 20, 90, 29);

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
        Search.setBounds(420, 150, 61, 29);

        QtySpinner.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        QtySpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        QtySpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                QtySpinnerStateChanged(evt);
            }
        });
        getContentPane().add(QtySpinner);
        QtySpinner.setBounds(400, 100, 100, 30);

        SubtotalLabel.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        SubtotalLabel.setText("Subtotal");
        getContentPane().add(SubtotalLabel);
        SubtotalLabel.setBounds(730, 70, 70, 20);

        PriceLabel.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        PriceLabel.setText("Harga");
        getContentPane().add(PriceLabel);
        PriceLabel.setBounds(570, 70, 70, 20);

        PriceField.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        PriceField.setForeground(new java.awt.Color(204, 204, 204));
        PriceField.setText("Harga");
        PriceField.setEnabled(false);
        PriceField.setFocusable(false);
        PriceField.setMaximumSize(new java.awt.Dimension(125, 26));
        PriceField.setMinimumSize(new java.awt.Dimension(125, 26));
        PriceField.setPreferredSize(new java.awt.Dimension(125, 26));
        getContentPane().add(PriceField);
        PriceField.setBounds(560, 100, 110, 30);

        AddQuery.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        AddQuery.setText("Tambah");
        AddQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddQueryActionPerformed(evt);
            }
        });
        getContentPane().add(AddQuery);
        AddQuery.setBounds(300, 150, 90, 29);

        PurchasesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        PurchasesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PurchasesTableMouseClicked(evt);
            }
        });
        TablePane2.setViewportView(PurchasesTable);

        getContentPane().add(TablePane2);
        TablePane2.setBounds(50, 380, 700, 160);

        TotalField.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        TotalField.setText("Total");
        TotalField.setFocusable(false);
        TotalField.setMaximumSize(new java.awt.Dimension(125, 26));
        TotalField.setMinimumSize(new java.awt.Dimension(125, 26));
        TotalField.setPreferredSize(new java.awt.Dimension(125, 26));
        getContentPane().add(TotalField);
        TotalField.setBounds(760, 510, 140, 30);

        RevertTable.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        RevertTable.setText("Cancel Cari");
        RevertTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RevertTableActionPerformed(evt);
            }
        });
        getContentPane().add(RevertTable);
        RevertTable.setBounds(510, 150, 120, 29);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NameFieldFocusLost
        if(NameField.getText().equals("")) {
            NameField.setText("Nama Barang");
            NameField.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_NameFieldFocusLost

    private void NameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NameFieldFocusGained
        if(NameField.getText().equals("Nama Barang")) {
            NameField.setText("");
            NameField.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_NameFieldFocusGained

    private void SubtotalFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SubtotalFieldFocusGained
        if(SubtotalField.getText().equals("No. Terjual")) {
            SubtotalField.setText("");
            SubtotalField.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_SubtotalFieldFocusGained

    private void SubtotalFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SubtotalFieldFocusLost
        if(SubtotalField.getText().equals("")) {
            SubtotalField.setText("No. Terjual");
            SubtotalField.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_SubtotalFieldFocusLost

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

    private void RollbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RollbackActionPerformed
        EmptyForm();
        this.PurchaseStms = new ArrayList<String>();
        QueryDataInit();
        this.total = 0;
    }//GEN-LAST:event_RollbackActionPerformed

    private void AddDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddDataActionPerformed
        String User = "";
        try {
            String SelStm = "SELECT * FROM Personnel";
            java.sql.Connection conn = Config.ConfigDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(SelStm);
            
            while(res.next()) {
                if(res.getString(1).equals(Integer.toString(this.CurPersID))){
                    User = res.getString(2);
                }
            }
            
        } catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            java.sql.Connection conn = Config.ConfigDB();
            String TransHistoryEntry = "INSERT INTO Transaction VALUES (NULL, '" + this.CurPersID + "', '" + User + "', '" + this.total + "', '" + getCurrentTimeStamp() + "');";
            java.sql.PreparedStatement pstm = conn.prepareStatement(TransHistoryEntry);
            pstm.execute();
            java.sql.Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            conn.setAutoCommit(false);
            for(String Stm : PurchaseStms) {
                stmt.addBatch(Stm);
                System.out.println(Stm);
            }
            for(String Stm: InventoryStms) {
                stmt.addBatch(Stm);
                System.out.println(Stm);
            }
            stmt.executeBatch();
            conn.commit();
            JOptionPane.showMessageDialog(null, "Changes have been saved");
            Show_Data();
            EmptyForm();
            this.PurchaseStms = new ArrayList<String>();
            QueryDataInit();
            this.total = 0;
        } catch(HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_AddDataActionPerformed

    private void InventoryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InventoryTableMouseClicked
        int row = InventoryTable.rowAtPoint(evt.getPoint());
        int Subtotal = (Integer)QtySpinner.getValue()* Integer.valueOf(InventoryTable.getValueAt(row, 2).toString());
        ItemIDField.setText(InventoryTable.getValueAt(row, 0).toString());
        NameField.setText(InventoryTable.getValueAt(row, 1).toString());
        PriceField.setText(InventoryTable.getValueAt(row, 2).toString());
        PriceField.setForeground(new Color(0, 0, 0));
        NameField.setForeground(new Color(0, 0, 0));
        SubtotalField.setForeground(new Color(0, 0, 0));
        SubtotalField.setText(String.valueOf(Subtotal));
    }//GEN-LAST:event_InventoryTableMouseClicked

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        int TransID = 1;
        int ItemQty = 0;
        int InitialSub = Integer.valueOf(PurchasesTable.getValueAt(this.rowToDel, 4).toString());
        
        try {
            QtySpinner.commitEdit();
        } catch (ParseException ex) {
            Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            String SelStm = "SELECT MAX(TransactionID) AS NewestID FROM Transaction";
            java.sql.Connection conn = Config.ConfigDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(SelStm);
            
            if(res.next()) {
                TransID += res.getInt(1);
            }
        } catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        String Stm  = "INSERT INTO Purchase VALUES (NULL, '" +
                    String.valueOf(TransID) + "', '" + ItemIDField.getText() + "', '" +
                    QtySpinner.getValue() +  "', '" + PriceField.getText() + "', '" +
                    SubtotalField.getText() + "');";
        
        try {
            String SelStm = "SELECT * FROM Inventory WHERE ItemID='" + ItemIDField.getText() + "'";
            java.sql.Connection conn = Config.ConfigDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(SelStm);
            
            if(res.next()) {
                ItemQty = res.getInt(4) - Integer.parseInt(QtySpinner.getValue().toString());
            }
            System.out.println(TransID);
        } catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        String InvStm = "UPDATE Inventory SET ItemQty='" + ItemQty + "' WHERE ItemID='" + ItemIDField.getText() + "'";
        this.InventoryStms.set(this.rowToDel, InvStm);
        this.PurchaseStms.set(this.rowToDel, Stm);
        QueryDataInsert(ItemIDField.getText(), NameField.getText(), QtySpinner.getValue().toString(), PriceField.getText(), SubtotalField.getText());
        QueryDataDel();
        
        this.total -= InitialSub;
        this.total += Integer.valueOf(SubtotalField.getText());
        TotalField.setText(String.valueOf(this.total));
    }//GEN-LAST:event_EditActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        this.PurchaseStms.remove(this.rowToDel);
        this.InventoryStms.remove(this.rowToDel);
        QueryDataDel();
        this.total -= Integer.valueOf(SubtotalField.getText());
    }//GEN-LAST:event_DeleteActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        try {
            String stm = "SELECT * FROM Inventory WHERE ItemName LIKE '%" + NameField.getText() + "%'";
                
            java.sql.Connection conn = Config.ConfigDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(stm);
            pstm.execute();
            Show_DataStm(stm);
            EmptyForm();
            
            } catch(HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
    }//GEN-LAST:event_SearchActionPerformed

    private void AddQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddQueryActionPerformed
        int TransID = 1;
        int ItemQty = 0;
        
        try {
            QtySpinner.commitEdit();
        } catch (ParseException ex) {
            Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            String SelStm = "SELECT MAX(TransactionID) FROM Transaction";
            java.sql.Connection conn = Config.ConfigDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(SelStm);
            
            if(res.next()) {
                TransID += res.getInt(1);
            }
            System.out.println(TransID);
        } catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        String Stm  = "INSERT INTO Purchase VALUES (NULL, '" +
                    String.valueOf(TransID) + "', '" + ItemIDField.getText() + "', '" + PriceField.getText() +
                    "', '" + QtySpinner.getValue() + "', '" +  SubtotalField.getText() + "');";

        try {
            String SelStm = "SELECT * FROM Inventory WHERE ItemID='" + ItemIDField.getText() + "'";
            java.sql.Connection conn = Config.ConfigDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(SelStm);
            
            if(res.next()) {
                ItemQty = res.getInt(4) - Integer.parseInt(QtySpinner.getValue().toString());
            }
            System.out.println(TransID);
        } catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        String InvStm = "UPDATE Inventory SET ItemQty='" + ItemQty + "' WHERE ItemID='" + ItemIDField.getText() + "'";
        this.InventoryStms.add(InvStm);
        this.PurchaseStms.add(Stm);
        
        QueryDataInsert(ItemIDField.getText(), NameField.getText(), QtySpinner.getValue().toString(), PriceField.getText(), SubtotalField.getText());
        this.total += Integer.valueOf(SubtotalField.getText());
        TotalField.setText(String.valueOf(this.total));
    }//GEN-LAST:event_AddQueryActionPerformed

    private void PurchasesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PurchasesTableMouseClicked
        int row = PurchasesTable.rowAtPoint(evt.getPoint());
        ItemIDField.setText(PurchasesTable.getValueAt(row, 0).toString());
        NameField.setText(PurchasesTable.getValueAt(row, 1).toString());
        PriceField.setText(PurchasesTable.getValueAt(row, 3).toString());
        PriceField.setForeground(new Color(0, 0, 0));
        NameField.setForeground(new Color(0, 0, 0));
        SubtotalField.setForeground(new Color(0, 0, 0));
        SubtotalField.setText(PurchasesTable.getValueAt(row, 4).toString());
        QtySpinner.setValue(Integer.valueOf(PurchasesTable.getValueAt(row, 2).toString()));
        this.rowToDel = row;
    }//GEN-LAST:event_PurchasesTableMouseClicked

    private void QtySpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_QtySpinnerStateChanged
        try {
            QtySpinner.commitEdit();
        } catch (ParseException ex) {
            Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int qty = Integer.parseInt(QtySpinner.getValue().toString());
        int price = Integer.parseInt(PriceField.getText());
        
        SubtotalField.setText(String.valueOf(qty*price));
    }//GEN-LAST:event_QtySpinnerStateChanged

    private void RevertTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RevertTableActionPerformed
        Show_Data();
    }//GEN-LAST:event_RevertTableActionPerformed

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
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Purchase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ASMRLogo;
    private javax.swing.JLabel ASMRSign;
    private javax.swing.JButton AddData;
    private javax.swing.JButton AddQuery;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Edit;
    private javax.swing.JButton Exit;
    private javax.swing.JTable InventoryTable;
    private javax.swing.JLabel ItemID;
    private javax.swing.JTextField ItemIDField;
    private javax.swing.JLabel ItemName;
    private javax.swing.JTextField NameField;
    private javax.swing.JLabel NoPurchased;
    private javax.swing.JTextField PriceField;
    private javax.swing.JLabel PriceLabel;
    private javax.swing.JTable PurchasesTable;
    private javax.swing.JSpinner QtySpinner;
    private javax.swing.JButton RevertTable;
    private javax.swing.JButton Rollback;
    private javax.swing.JButton Search;
    private javax.swing.JTextField SubtotalField;
    private javax.swing.JLabel SubtotalLabel;
    private javax.swing.JScrollPane TablePane;
    private javax.swing.JScrollPane TablePane2;
    private javax.swing.JLabel Title;
    private javax.swing.JTextField TotalField;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
