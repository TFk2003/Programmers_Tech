/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframe;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author HP
 */
public class ManageStudent extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    public ManageStudent() {
        initComponents();
        setStudentDetailsToTable();
    }
    
    String student_name, department, section;
    int student_id;
    DefaultTableModel model;
    
    public void setStudentDetailsToTable() {
        try{
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","talfAR03!");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from student_details");
        while(rs.next()) {
            String student_id = rs.getString("student_id");
            String student_name = rs.getString("student_name");
            String department = rs.getString("department");
            String section = rs.getString("section");
            
            Object[] obj = {student_id, student_name, department, section};
            model = (DefaultTableModel) rSTableMetro2.getModel();
            model.addRow(obj);
        }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public boolean addStudent() {
        student_id = Integer.parseInt(txt_studentId.getText());
        student_name = txt_studentname.getText();
        department = combo_dep.getSelectedItem().toString();
        section = combo_section.getSelectedItem().toString();
        boolean isAdded = false;
        try{
            Connection con = DBConnection.getConnection();
            String sql = "Insert into student_details values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, student_id);
            ps.setString(2, student_name);
            ps.setString(3, department);
            ps.setString(4, section);
            
            int RowCount = ps.executeUpdate();
            if(RowCount > 0) {
               isAdded = true;
                
            }
            else {
                isAdded = false;
            }
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return isAdded;
    }
    
    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) rSTableMetro2.getModel();
        model.setRowCount(0);
    }
    
    public boolean DeleteStudent() {
        student_id = Integer.parseInt(txt_studentId.getText());
        student_name = txt_studentname.getText();
        department = combo_dep.getSelectedItem().toString();
        section = combo_section.getSelectedItem().toString();
        boolean isDeleted = false;
        try{
            Connection con = DBConnection.getConnection();
            String sql = "delete from student_details where student_id=?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, student_id);
            
            int RowCount = ps.executeUpdate();
            if(RowCount > 0) {
               isDeleted = true;
                
            }
            else {
                isDeleted = false;
            }
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return isDeleted;
    }
    public boolean UpdateStudent() {
        student_id = Integer.parseInt(txt_studentId.getText());
        student_name = txt_studentname.getText();
        department = combo_dep.getSelectedItem().toString();
        section = combo_section.getSelectedItem().toString();
        boolean isUpdated = false;
        try{
            Connection con = DBConnection.getConnection();
            String sql = "update student_details set values student_name=?, department=?, section=? where student_id=?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(4, student_id);
            ps.setString(1, student_name);
            ps.setString(2, department);
            ps.setString(3, section);
            
            int RowCount = ps.executeUpdate();
            if(RowCount > 0) {
               isUpdated = true;
                
            }
            else {
                isUpdated = false;
            }
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_studentname = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        combo_section = new javax.swing.JComboBox<>();
        combo_dep = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rSTableMetro2 = new rojerusan.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 50));

        jLabel9.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Enter Student  Id");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 200, 30));

        jLabel6.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 50, -1));

        txt_studentId.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentId.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_studentId.setPlaceholder("Enter Student Id...");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 300, -1));

        jLabel7.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 50, -1));

        jLabel10.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Enter Student  Name");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 200, 30));

        txt_studentname.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentname.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_studentname.setPlaceholder("Enter Student Name...");
        txt_studentname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentnameFocusLost(evt);
            }
        });
        txt_studentname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentnameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 300, -1));

        jLabel11.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Enter Department");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 200, 30));

        jLabel8.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 50, -1));

        jLabel12.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 50, -1));

        jLabel13.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Enter Section");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 200, 30));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle1.setText("Delete");
        rSMaterialButtonCircle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle1MouseClicked(evt);
            }
        });
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 580, 100, 80));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("Add");
        rSMaterialButtonCircle2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle2MouseClicked(evt);
            }
        });
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, 100, 80));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle3.setText("Update");
        rSMaterialButtonCircle3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle3MouseClicked(evt);
            }
        });
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 580, 100, 80));

        combo_section.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        combo_section.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E" }));
        combo_section.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_sectionActionPerformed(evt);
            }
        });
        jPanel1.add(combo_section, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, 300, -1));

        combo_dep.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        combo_dep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BS CS", "BS SE", "BS AI", "BS CY" }));
        combo_dep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_depActionPerformed(evt);
            }
        });
        jPanel1.add(combo_dep, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 300, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 730));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(102, 102, 255));
        jLabel2.setFont(new java.awt.Font("Verdana", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 60, 50));

        rSTableMetro2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Name", "Depratment", "Section"
            }
        ));
        rSTableMetro2.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        rSTableMetro2.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        rSTableMetro2.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        rSTableMetro2.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        rSTableMetro2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        rSTableMetro2.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        rSTableMetro2.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        rSTableMetro2.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        rSTableMetro2.setRowHeight(30);
        rSTableMetro2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSTableMetro2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(rSTableMetro2);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 520, 300));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel3.setText(" Manage Students");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 360, 5));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 760, 730));

        setSize(new java.awt.Dimension(1360, 730));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void txt_studentnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentnameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentnameFocusLost

    private void txt_studentnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentnameActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSTableMetro2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSTableMetro2MouseClicked
        // TODO add your handling code here:
        
        int rowNo = rSTableMetro2.getSelectedRow();
        TableModel model = rSTableMetro2.getModel();
        
        txt_studentId.setText(model.getValueAt(rowNo, 0).toString());
        txt_studentname.setText(model.getValueAt(rowNo, 1).toString());
        combo_dep.setSelectedItem(model.getValueAt(rowNo, 2).toString());
        combo_section.setSelectedItem(model.getValueAt(rowNo, 3).toString());
    }//GEN-LAST:event_rSTableMetro2MouseClicked

    private void rSMaterialButtonCircle2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2MouseClicked
        // TODO add your handling code here:
        if(addStudent()){
            JOptionPane.showMessageDialog(this, "Student Added");
            clearTable();
            setStudentDetailsToTable();
        }
        else{
            JOptionPane.showMessageDialog(this, "Student Not Added");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2MouseClicked

    private void rSMaterialButtonCircle3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3MouseClicked
        // TODO add your handling code here:
        if(UpdateStudent()){
            JOptionPane.showMessageDialog(this, "Student Updated");
            clearTable();
            setStudentDetailsToTable();
        }
        else{
            JOptionPane.showMessageDialog(this, "Student Not Updated");
        } 
    }//GEN-LAST:event_rSMaterialButtonCircle3MouseClicked

    private void rSMaterialButtonCircle1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1MouseClicked
        // TODO add your handling code here:
        if(DeleteStudent()){
            JOptionPane.showMessageDialog(this, "Student Deleted");
            clearTable();
            setStudentDetailsToTable();
        }
        else{
            JOptionPane.showMessageDialog(this, "Student Not Deleted");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle1MouseClicked

    private void combo_sectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_sectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_sectionActionPerformed

    private void combo_depActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_depActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_depActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_dep;
    private javax.swing.JComboBox<String> combo_section;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSTableMetro rSTableMetro2;
    private app.bolivia.swing.JCTextField txt_studentId;
    private app.bolivia.swing.JCTextField txt_studentname;
    // End of variables declaration//GEN-END:variables
}
