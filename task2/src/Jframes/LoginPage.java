/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form LoginPage
     */
    public LoginPage() {
        initComponents();
    }
    
    public boolean validateLogin() {
        String name = txt_username1.getText();
        String password = txt_password1.getText();
        
        if(name.equals("")) {
            JOptionPane.showMessageDialog(this, "Please Enter User Name");
            return false;
        }
        if(password.equals("")) {
            JOptionPane.showMessageDialog(this, "Please Enter Password");
            return false;
        }
        return true;
    }
    
    public void Login() {
        String name = txt_username1.getText();
        String password = txt_password1.getText();
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from users where name = ? and password = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, name);
            pst.setString(2, password);
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                String contact = "";
                int balance = 0;
                try{
                    con = DBConnection.getConnection();
                    sql = "select * from users where name='"+name+"' and password='"+password+"'";
                    Statement st = con.createStatement();
                    rs = st.executeQuery(sql);
                    if(rs.next()){
                        contact = rs.getString("contact");
                        balance = rs.getInt("balance");
                    }
                    
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
                CentralDataModel cdm = CentralDataModel.getInstance();
                cdm.setBalance(balance);
                cdm.setAccount(contact);
                cdm.setUsername(name);
                HomePage home = new HomePage();
                home.setVisible(true);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this, "Incorrect username or password");
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void insertSignupDetails() {
        String name = txt_username.getText();
        String password = txt_password.getText();
        String email = txt_email.getText();
        String contact = txt_contact.getText();
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into users(name,password,email,contact,balance) values(?,?,?,?,0)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, name);
            pst.setString(2, password);
            pst.setString(3, email);
            pst.setString(4, contact);
            
            int UpdatedRowCount = pst.executeUpdate();
            if(UpdatedRowCount > 0) {
                JOptionPane.showMessageDialog(this, "Record Inserted Successfully");
                try{
                    con = DBConnection.getConnection();
                    String tname = name+"_"+contact;
                    sql = "create table "+tname+"(Transaction_date date, Deposit_Amount int, Withdraw_Amount int, Transaction_Description varchar(100), PRIMARY KEY(Transaction_date, Transaction_Description))";
                    Statement st = con.createStatement();
                    st.execute(sql);
                    
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
                CentralDataModel cdm = CentralDataModel.getInstance();
                cdm.setBalance(0);
                cdm.setAccount(contact);
                cdm.setUsername(name);
                HomePage home = new HomePage();
                home.setVisible(true);
                this.dispose();
                
            }
            else {
                JOptionPane.showMessageDialog(this, "Record Insertion Failure");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean validationSignup() {
        String name = txt_username.getText();
        String password = txt_password.getText();
        String email = txt_email.getText();
        String contact = txt_contact.getText();
        
        if(name.equals("")) {
            JOptionPane.showMessageDialog(this, "please enter username");
            return false;
        }
        if(password.equals("")) {
            JOptionPane.showMessageDialog(this, "please enter password");
            return false;
        }
        if(email.equals("") || !email.matches("^.+@.+\\..+$")) {
            JOptionPane.showMessageDialog(this, "please enter valid email");
            return false;
        }
        if(contact.equals("")) {
            JOptionPane.showMessageDialog(this, "please enter Account Number");
            return false;
        }
        if(contact.length() < 10) {
            JOptionPane.showMessageDialog(this, "please enter correct Account Number");
            return false;
        }
        
        return true;
    }
    
    
    public boolean CheckDuplicateUser() {
        String name = txt_username.getText();
        boolean isExist = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking_system","root","talfAR03!");
            
            PreparedStatement pst = con.prepareStatement("select * from users where name = ?");
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                isExist = true;
            }
            else {
                isExist = false;
            }
        }
        catch(Exception e) {
            
        }
        return isExist;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_username = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_password = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_email = new app.bolivia.swing.JCTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_contact = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_username1 = new app.bolivia.swing.JCTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txt_password1 = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        jLabel23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setForeground(new java.awt.Color(102, 102, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(520, 730));
        jPanel2.setPreferredSize(new java.awt.Dimension(520, 730));
        jPanel2.setRequestFocusEnabled(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secure_50px.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 50, -1));

        jLabel7.setFont(new java.awt.Font("Sitka Text", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("X");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 5, 30, 30));

        jLabel8.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Create New Account Here");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 200, 30));

        txt_username.setBackground(new java.awt.Color(102, 102, 255));
        txt_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_username.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_username.setPlaceholder("Enter Username...");
        txt_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usernameFocusLost(evt);
            }
        });
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 270, -1));

        jLabel9.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Username");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 200, 30));

        jLabel10.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Password");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 200, 30));

        jLabel11.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secured_Letter_50px.png"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 50, -1));

        txt_password.setBackground(new java.awt.Color(102, 102, 255));
        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_password.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_password.setPlaceholder("Enter Password...");
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 270, -1));

        jLabel12.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Email");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 200, 30));

        jLabel13.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 50, -1));

        txt_email.setBackground(new java.awt.Color(102, 102, 255));
        txt_email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_email.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_email.setPlaceholder("Enter Email...");
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        jPanel2.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 270, -1));

        jLabel14.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Account Number");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 200, 30));

        jLabel15.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-bank-account-50.png"))); // NOI18N
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 50, -1));

        txt_contact.setBackground(new java.awt.Color(102, 102, 255));
        txt_contact.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_contact.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_contact.setPlaceholder("Enter Account Number...");
        txt_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contactActionPerformed(evt);
            }
        });
        jPanel2.add(txt_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 270, -1));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("Signup");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 300, 60));

        jLabel16.setFont(new java.awt.Font("Sitka Text", 1, 25)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Signup Page");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 160, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 400, 600));

        jPanel3.setBackground(new java.awt.Color(102, 153, 255));
        jPanel3.setForeground(new java.awt.Color(102, 102, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(520, 730));
        jPanel3.setPreferredSize(new java.awt.Dimension(520, 730));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 50, -1));

        jLabel19.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Welcome, Login To Your Account");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 250, 30));

        txt_username1.setBackground(new java.awt.Color(102, 102, 255));
        txt_username1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_username1.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_username1.setPlaceholder("Enter Username...");
        txt_username1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_username1FocusLost(evt);
            }
        });
        txt_username1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_username1ActionPerformed(evt);
            }
        });
        jPanel3.add(txt_username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 240, -1));

        jLabel20.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Username");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 200, 30));

        jLabel21.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Password");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 200, 30));

        jLabel22.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secure_50px.png"))); // NOI18N
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 50, -1));

        txt_password1.setBackground(new java.awt.Color(102, 102, 255));
        txt_password1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_password1.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_password1.setPlaceholder("Enter Password...");
        txt_password1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_password1ActionPerformed(evt);
            }
        });
        jPanel3.add(txt_password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 240, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle1.setText("Login");
        rSMaterialButtonCircle1.setToolTipText("");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel3.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 300, 60));

        jLabel23.setFont(new java.awt.Font("Sitka Text", 1, 25)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Login Page");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 140, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 600));

        setSize(new java.awt.Dimension(800, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void txt_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusLost
        // TODO add your handling code here:
        if(CheckDuplicateUser()) {
            JOptionPane.showMessageDialog(this, "Username already exist");
        }
    }//GEN-LAST:event_txt_usernameFocusLost

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        // TODO add your handling code here:
        if(validationSignup() && !CheckDuplicateUser()) {
            insertSignupDetails();
        }
        else {
            JOptionPane.showMessageDialog(this, "Username already exist");

        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void txt_username1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_username1FocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_username1FocusLost

    private void txt_username1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_username1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_username1ActionPerformed

    private void txt_password1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_password1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_password1ActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        // TODO add your handling code here:
        if(validateLogin()) {
            Login();
        }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField txt_contact;
    private app.bolivia.swing.JCTextField txt_email;
    private app.bolivia.swing.JCTextField txt_password;
    private app.bolivia.swing.JCTextField txt_password1;
    private app.bolivia.swing.JCTextField txt_username;
    private app.bolivia.swing.JCTextField txt_username1;
    // End of variables declaration//GEN-END:variables
}
