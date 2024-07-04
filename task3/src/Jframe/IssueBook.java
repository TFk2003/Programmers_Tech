/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
    
    public void getBookDetails() {
        int book_id = Integer.parseInt(txt_bookId2.getText());
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from book_details where book_id = ?");
            ps.setInt(1, book_id);
            ResultSet rs= ps.executeQuery();
            
            if(rs.next()) {
                txt_bookId.setText(rs.getString("book_id"));
                txt_bookname.setText(rs.getString("book_name"));
                txt_author.setText(rs.getString("author"));
                txt_quantity.setText(rs.getString("quantity"));
                txt_bookError1.setText("");
            }
            else {
                txt_bookError1.setText("Invalid Book Id");
            }
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void getStudentDetails() {
        int student_id = Integer.parseInt(txt_studentId1.getText());
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from student_details where student_id = ?");
            ps.setInt(1, student_id);
            ResultSet rs= ps.executeQuery();
            
            if(rs.next()) {
                txt_studentId.setText(rs.getString("student_id"));
                txt_studentname.setText(rs.getString("student_name"));
                txt_department.setText(rs.getString("department"));
                txt_section.setText(rs.getString("section"));
                txt_StudentError.setText("");
            }
            else{
                txt_StudentError.setText("Invalid Student Id");
            }
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean issue_book() {
        boolean issue = false;
        int student_id = Integer.parseInt(txt_studentId1.getText());
        int book_id = Integer.parseInt(txt_bookId2.getText());
        String book_name = txt_bookname.getText();
        String student_name = txt_studentname.getText();
        Date issueDate = date_issue.getDatoFecha();
        Date dueDate = date_due.getDatoFecha();
        
        long lid = issueDate.getTime();
        long ldd = dueDate.getTime();
        
        java.sql.Date iDate = new java.sql.Date(lid);
        java.sql.Date dDate = new java.sql.Date(ldd);
        
        try{
            Connection con = DBConnection.getConnection();
            String sql = "insert into issue_book_details(book_id, book_name, student_id, student_name, issue_date, due_date, status) values (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, book_id);
            ps.setString(2, book_name);
            ps.setInt(3, student_id);
            ps.setString(4, student_name);
            ps.setDate(5, iDate);
            ps.setDate(6,dDate);
            ps.setString(7, "Pending");
            
            int rowCount = ps.executeUpdate();
            if(rowCount > 0) {
                issue = true;
            }
            else {
                issue = false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return issue;
    }
    
    public void updateCount() {
        int book_id = Integer.parseInt(txt_bookId2.getText());
        try{
            Connection con = DBConnection.getConnection();
            String sql = "Update book_details set quantity = quantity - 1 where book_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, book_id);
            
            int rowCount = ps.executeUpdate();
            if(rowCount > 0) {
                JOptionPane.showMessageDialog(this, "Book Count Updated");
                int count = Integer.parseInt(txt_quantity.getText());
                txt_quantity.setText(Integer.toString(count-1));
            }
            else {
                JOptionPane.showMessageDialog(this, "Book Count can not be Updated");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean IsDuplicate() {
        boolean duplicate = false;
        int student_id = Integer.parseInt(txt_studentId1.getText());
        int book_id = Integer.parseInt(txt_bookId2.getText());
        try{
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where book_id = ? and student_id = ? and status = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, book_id);
            ps.setInt(2, student_id);
            ps.setString(3, "Pending");
            
            ResultSet rowCount = ps.executeQuery();
            if(rowCount.next()){
                duplicate = true;
            }
            else{
                duplicate = false;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return duplicate;
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
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_studentname = new javax.swing.JLabel();
        txt_studentId = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_department = new javax.swing.JLabel();
        txt_section = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_StudentError = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_quantity = new javax.swing.JLabel();
        txt_author = new javax.swing.JLabel();
        txt_bookId = new javax.swing.JLabel();
        txt_bookname = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_bookError1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txt_studentId1 = new app.bolivia.swing.JCTextField();
        jLabel21 = new javax.swing.JLabel();
        txt_bookId2 = new app.bolivia.swing.JCTextField();
        date_due = new rojeru_san.componentes.RSDateChooser();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        date_issue = new rojeru_san.componentes.RSDateChooser();
        jPanel7 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 220, 310, 5));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Student Name :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Student Id :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Department :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Section :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, -1));

        txt_studentname.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        txt_studentname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txt_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 190, 30));

        txt_studentId.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        txt_studentId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 190, 30));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 190, 40));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 190, 40));

        txt_department.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        txt_department.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txt_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 190, 30));

        txt_section.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        txt_section.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txt_section, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, 190, 30));

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 25)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel17.setText("  Student Details");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 310, 140));

        txt_StudentError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        txt_StudentError.setForeground(new java.awt.Color(255, 204, 0));
        jPanel1.add(txt_StudentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 370, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 430, 730));

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(102, 102, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel11.setText("Back");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 50));

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 25)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel12.setText("  Book Details");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 280, 140));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 220, 290, 5));

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Book Name :");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Book Id :");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Author :");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));

        txt_quantity.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        txt_quantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, 190, 30));

        txt_author.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        txt_author.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 190, 30));

        txt_bookId.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        txt_bookId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 190, 30));

        txt_bookname.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        txt_bookname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 190, 30));

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Quantity :");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, -1));

        txt_bookError1.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        txt_bookError1.setForeground(new java.awt.Color(255, 204, 0));
        jPanel4.add(txt_bookError1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 370, 40));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 730));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 25)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel7.setText("  Student Details");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 310, 140));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 25)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel8.setText("  Student Details");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 310, 140));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel2.setText("Issue Book");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 110, 200, 90));

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 190, 220, 5));

        jLabel18.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 51, 51));
        jLabel18.setText("Student  Id :");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 260, 90, 30));

        txt_studentId1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txt_studentId1.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_studentId1.setPlaceholder("Enter Student Id...");
        txt_studentId1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentId1FocusLost(evt);
            }
        });
        txt_studentId1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentId1ActionPerformed(evt);
            }
        });
        getContentPane().add(txt_studentId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 260, 290, -1));

        jLabel21.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 51, 51));
        jLabel21.setText("Due Date :");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 440, 90, 30));

        txt_bookId2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txt_bookId2.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_bookId2.setPlaceholder("Enter Book Id...");
        txt_bookId2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookId2FocusLost(evt);
            }
        });
        txt_bookId2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookId2ActionPerformed(evt);
            }
        });
        getContentPane().add(txt_bookId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 320, 290, -1));

        date_due.setColorBackground(new java.awt.Color(255, 51, 51));
        date_due.setColorForeground(new java.awt.Color(255, 51, 51));
        date_due.setPlaceholder("Select Due Date");
        getContentPane().add(date_due, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 440, 300, -1));

        jLabel22.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 51, 51));
        jLabel22.setText("Book  Id :");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 320, 90, 30));

        jLabel23.setFont(new java.awt.Font("Urdu Typesetting", 0, 17)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 51, 51));
        jLabel23.setText("Issue Date :");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 380, 90, 30));

        date_issue.setColorBackground(new java.awt.Color(255, 51, 51));
        date_issue.setColorForeground(new java.awt.Color(255, 51, 51));
        date_issue.setPlaceholder("Select Issue Date");
        getContentPane().add(date_issue, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 380, 300, -1));

        jPanel7.setBackground(new java.awt.Color(102, 102, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setBackground(new java.awt.Color(102, 102, 255));
        jLabel24.setFont(new java.awt.Font("Verdana", 0, 30)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("X");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 0, 60, 50));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("Issue Book");
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
        getContentPane().add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 550, 350, 80));

        setSize(new java.awt.Dimension(1360, 730));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void txt_studentId1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentId1FocusLost
        // TODO add your handling code here:
        if(!txt_studentId1.getText().equals("")) {
            getStudentDetails();
        }
        
    }//GEN-LAST:event_txt_studentId1FocusLost

    private void txt_studentId1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentId1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentId1ActionPerformed

    private void txt_bookId2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookId2FocusLost
        // TODO add your handling code here:
        if(!txt_bookId2.getText().equals("")) {
            getBookDetails();
        }
    }//GEN-LAST:event_txt_bookId2FocusLost

    private void txt_bookId2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookId2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookId2ActionPerformed

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel24MouseClicked

    private void rSMaterialButtonCircle2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_rSMaterialButtonCircle2MouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        // TODO add your handling code here:
        if(txt_quantity.getText().equals("0")){
            JOptionPane.showMessageDialog(this, "Book is not Available");
        }
        else{
            if(!IsDuplicate()) {
                if(issue_book()) {
                    JOptionPane.showMessageDialog(this, "Book Issued Successfully");
                    updateCount();
                }
                else {
                    JOptionPane.showMessageDialog(this, "Book Can not be issued"); 
                }
            }
            else{
            JOptionPane.showMessageDialog(this, "Book Already Issued"); 
            }
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_due;
    private rojeru_san.componentes.RSDateChooser date_issue;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private javax.swing.JLabel txt_StudentError;
    private javax.swing.JLabel txt_author;
    private javax.swing.JLabel txt_bookError1;
    private javax.swing.JLabel txt_bookId;
    private app.bolivia.swing.JCTextField txt_bookId2;
    private javax.swing.JLabel txt_bookname;
    private javax.swing.JLabel txt_department;
    private javax.swing.JLabel txt_quantity;
    private javax.swing.JLabel txt_section;
    private javax.swing.JLabel txt_studentId;
    private app.bolivia.swing.JCTextField txt_studentId1;
    private javax.swing.JLabel txt_studentname;
    // End of variables declaration//GEN-END:variables
}
