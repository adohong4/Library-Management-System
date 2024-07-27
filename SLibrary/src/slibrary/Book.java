    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package slibrary;

import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author pc
 */
public class Book extends javax.swing.JFrame {

    /**
     * Creates new form Category
     */
    public Book() {
        initComponents();
        Connect();
        Category();
        Author();
        Publisher();
        Book_Load();
    }
    
    public class CategoryItem
    {
        int id;
        String name;
        
        public CategoryItem(int id, String name)
        {
            this.id=id;
            this.name=name;
        }
        
        public String toString()
        {
            return name;
        }
    }
    
     public class AuthorItem
    {
        int id;
        String name;
        
        public AuthorItem(int id, String name)
        {
            this.id=id;
            this.name=name;
        }
        
        public String toString()
        {
            return name;
        }
    }
    
     public class PublisherItem
    {
        int id;
        String name;
        
        public PublisherItem(int id, String name)
        {
            this.id=id;
            this.name=name;
        }
        
        public String toString()
        {
            return name;
        }
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    
    public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost/SLibrary","root","");
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void Category()
    {
        try {
            pst =  con.prepareStatement("select * from category");
            rs = pst.executeQuery();
            txtcategory.removeAllItems();
            
            while(rs.next())
            {
                txtcategory.addItem(new CategoryItem (rs.getInt(1), rs.getString(2)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void Author()
    {
        try {
            pst =  con.prepareStatement("select * from author");
            rs = pst.executeQuery();
            txtauthor.removeAllItems();
            
            while(rs.next())
            {
                txtauthor.addItem(new AuthorItem (rs.getInt(1), rs.getString(2)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void Publisher()
    {
        try {
            pst =  con.prepareStatement("select * from publisher");
            rs = pst.executeQuery();
            txtpub.removeAllItems();
            
            while(rs.next())
            {
                txtpub.addItem(new PublisherItem (rs.getInt(1), rs.getString(2)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void Publisher_Load()
    {
        int c;
        
        try {
            pst = con.prepareStatement("select * from publisher");
            rs = pst.executeQuery();    
            
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2 = new Vector();
                
                for(int i=1; i<= c; i++)
                {
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("name"));
                    v2.add(rs.getString("address"));
                    v2.add(rs.getString("phone"));
                }
                
                d.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Book_Load()
    {
        int c;
        
        try {
            pst = con.prepareStatement("select b.id, b.bname, c.catname, a.name, p.name, b.language, b.quantity, b.price, b.edition from book b JOIN category c On b.category =c.id JOIN author a On b.author = a.id JOIN publisher p On b.publisher = p.id");
            rs = pst.executeQuery();    
            
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2 = new Vector();
                
                for(int i=1; i<= c; i++)
                {
                    v2.add(rs.getString("b.id"));
                    v2.add(rs.getString("b.bname"));
                    v2.add(rs.getString("c.catname"));
                    v2.add(rs.getString("a.name"));
                    v2.add(rs.getString("p.name"));
                    v2.add(rs.getString("b.language"));
                    v2.add(rs.getString("b.quantity"));
                    v2.add(rs.getString("b.price"));
                    v2.add(rs.getString("b.edition"));
                }
                
                d.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtname = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtcategory = new javax.swing.JComboBox();
        txtauthor = new javax.swing.JComboBox();
        txtpub = new javax.swing.JComboBox();
        txtquan = new javax.swing.JTextField();
        txtlan = new javax.swing.JTextField();
        txtedition = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtsearch = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jScrollPane3.setViewportView(jTextPane2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("THÔNG TIN SÁCH");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel2.setText("Tên Sách");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel3.setText("Thể Loại");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cập nhật");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Hủy");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Sách", "Thể Loại", "Tác Giả", "Nhà Xuất Bản", "Ngôn Ngữ", "Số Lượng", "Giá", "Phiên Bản"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(35);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(35);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(35);
        }

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel4.setText("Tác Giả");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel5.setText("Nhà Xuất Bản");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel6.setText("Ngôn ngữ");

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel7.setText("Số Lượng");

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel8.setText("Phiên Bản");

        txtcategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcategoryActionPerformed(evt);
            }
        });

        txtlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlanActionPerformed(evt);
            }
        });

        txtedition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txteditionActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel9.setText("Giá");

        txtprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpriceActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 255, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtsearch.setBackground(new java.awt.Color(204, 255, 153));
        txtsearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Tìm Kiếm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Làm mới");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsearch, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(80, 80, 80)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel6)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtlan)
                                            .addComponent(txtauthor, 0, 264, Short.MAX_VALUE)
                                            .addComponent(txtname)
                                            .addComponent(txtquan)))
                                    .addGap(80, 80, 80)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel8)
                                                    .addComponent(txtedition)
                                                    .addComponent(txtprice)
                                                    .addComponent(txtpub, 0, 274, Short.MAX_VALUE))
                                                .addComponent(txtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(70, 70, 70))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jLabel1)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtauthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtquan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtedition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        String bname = txtname.getText();
        CategoryItem citem = (CategoryItem)txtcategory.getSelectedItem();
        AuthorItem aitem = (AuthorItem)txtauthor.getSelectedItem();
        PublisherItem pitem = (PublisherItem)txtpub.getSelectedItem();
        
        String language = txtlan.getText();
        String quantity = txtquan.getText();
        String price = txtprice.getText();
        String edition = txtedition.getText();
        
        
        
        
        
        try {
            pst = con.prepareStatement("insert into book(bname, category, author, publisher, language, quantity, price, edition) values(?,?,?,?,?,?,?,?)");
            pst.setString(1, bname);
            pst.setInt(2, citem.id);
            pst.setInt(3, aitem.id);
            pst.setInt(4, pitem.id);
            pst.setString(5, language);
            pst.setString(6, quantity);
            pst.setString(7, price);
            pst.setString(8, edition);
            
            int k = pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this, "Sách đã được thêm");
                
                txtname.setText("");
                txtcategory.setSelectedIndex(-1);
                txtauthor.setSelectedIndex(-1);
                txtpub.setSelectedIndex(-1);
                txtlan.setText("");
                txtquan.setText("");
                txtprice.setText("");
                txtedition.setText("");
                txtname.requestFocus();
                Book_Load();

                //Publisher_Load();
                
                
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Error");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();
        
        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
        txtname.setText(d1.getValueAt(selectIndex, 1).toString());
        txtcategory.setSelectedItem(d1.getValueAt(selectIndex, 2).toString());
        txtauthor.setSelectedItem(d1.getValueAt(selectIndex, 3).toString());
        txtpub.setSelectedItem(d1.getValueAt(selectIndex, 4).toString());
        txtlan.setText(d1.getValueAt(selectIndex, 5).toString());
        txtquan.setText(d1.getValueAt(selectIndex, 6).toString());
        txtprice.setText(d1.getValueAt(selectIndex, 7).toString());
        txtedition.setText(d1.getValueAt(selectIndex, 8).toString());
        
        jButton1.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();
        
        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
        
        
        String bname = txtname.getText();
        CategoryItem citem = (CategoryItem)txtcategory.getSelectedItem();
        AuthorItem aitem = (AuthorItem)txtauthor.getSelectedItem();
        PublisherItem pitem = (PublisherItem)txtpub.getSelectedItem();
        
        String language = txtlan.getText();
        String quantity = txtquan.getText();
        String price = txtprice.getText();
        String edition = txtedition.getText();
        
        
        
        
        
        try {
            pst = con.prepareStatement("update book set bname =?, category=?, author=?, publisher=?, language=?, quantity=?, price=?, edition =? where id = ? ");
            pst.setString(1, bname);
            pst.setInt(2, citem.id);
            pst.setInt(3, aitem.id);
            pst.setInt(4, pitem.id);
            pst.setString(5, language);
            pst.setString(6, quantity);
            pst.setString(7, price);
            pst.setString(8, edition);
            pst.setInt(9,id);
            
            int k = pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this, "Sách đã được cập nhật!");
                
                txtname.setText("");
                txtcategory.setSelectedIndex(-1);
                txtauthor.setSelectedIndex(-1);
                txtpub.setSelectedIndex(-1);
                txtlan.setText("");
                txtquan.setText("");
                txtprice.setText("");
                txtedition.setText("");
                txtname.requestFocus();
                Book_Load();
                jButton1.setEnabled(true);
                //Publisher_Load();
                
                
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Error");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();
        
        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
        
        
        
        String bname = txtname.getText();
        CategoryItem citem = (CategoryItem)txtcategory.getSelectedItem();
        AuthorItem aitem = (AuthorItem)txtauthor.getSelectedItem();
        PublisherItem pitem = (PublisherItem)txtpub.getSelectedItem();
        
        String language = txtlan.getText();
        String quantity = txtquan.getText();
        String price = txtprice.getText();
        String edition = txtedition.getText();
        
        
        
        
        
        try {
            pst = con.prepareStatement("delete from book where id =?");
            
            pst.setInt(1,id);
            
            int k = pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this, "Sách đã bị xóa");
                
                txtname.setText("");
                txtcategory.setSelectedIndex(-1);
                txtauthor.setSelectedIndex(-1);
                txtpub.setSelectedIndex(-1);
                txtlan.setText("");
                txtquan.setText("");
                txtprice.setText("");
                txtedition.setText("");
                txtname.requestFocus();
                Book_Load();
                jButton1.setEnabled(true);
                //Publisher_Load();
                
                
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Error");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtcategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcategoryActionPerformed

    private void txteditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txteditionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txteditionActionPerformed

    private void txtlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlanActionPerformed

    private void txtpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpriceActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String searchKeyword = txtsearch.getText();
        int c;
        
        try {
            pst = con.prepareStatement("select b.id, b.bname, c.catname, a.name, p.name, b.language, b.quantity, b.price, b.edition from book b JOIN category c On b.category =c.id JOIN author a On b.author = a.id JOIN publisher p On b.publisher = p.id "
                    + "where b.id LIKE ? OR b.bname LIKE ? OR c.catname LIKE ? OR a.name LIKE ? OR p.name LIKE ? OR b.language LIKE ? OR b.quantity LIKE ? OR b.price LIKE ? OR b.edition LIKE ?");
            
            for (int i = 1; i <= 9; i++) {
                pst.setString(i, "%" + searchKeyword + "%");
            }
            rs = pst.executeQuery();    
            
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2 = new Vector();
                
                for(int i=1; i<= c; i++)
                {
                    v2.add(rs.getString("b.id"));
                    v2.add(rs.getString("b.bname"));
                    v2.add(rs.getString("c.catname"));
                    v2.add(rs.getString("a.name"));
                    v2.add(rs.getString("p.name"));
                    v2.add(rs.getString("b.language"));
                    v2.add(rs.getString("b.quantity"));
                    v2.add(rs.getString("b.price"));
                    v2.add(rs.getString("b.edition"));
                }
                
                d.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Book_Load();
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Book().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JComboBox txtauthor;
    private javax.swing.JComboBox txtcategory;
    private javax.swing.JTextField txtedition;
    private javax.swing.JTextField txtlan;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtprice;
    private javax.swing.JComboBox txtpub;
    private javax.swing.JTextField txtquan;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
