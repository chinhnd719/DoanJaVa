/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.CTHDBUS;
import BUS.HoaDonBUS;
import BUS.MenuBUS;
import BUS.TaiKhoanBUS;
import DTO.CTHDDTO;
import DTO.HoaDonDTO;
import DTO.MenuDTO;
import DTO.TaiKhoanDTO;
import java.awt.Image;
import java.awt.Menu;
import java.util.Date;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CHINH
 */
public class TrangChu_Form extends javax.swing.JFrame {
    DefaultTableModel model;
    ArrayList<HoaDonDTO> list1;
    ArrayList<CTHDDTO> list2;
    ArrayList<MenuDTO> list;
    String MaHD="";
    String MaCTHD="";
    int[][] mang=new int[100][4];
    int thanhtien=0;
    int stt=0;
    int max=-2000;
    SimpleDateFormat ft = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy ");
    SimpleDateFormat ftime = new SimpleDateFormat("HH:mm:ss");
    SimpleDateFormat fdate = new SimpleDateFormat("dd/MM/yyyy");
    public TrangChu_Form(String User) {
        initComponents();
        clock();
        showmenu();
        tbMenu.setShowGrid(true);
        this.setResizable(false); 
        ImageIcon img = new ImageIcon("src//Image//coffee-tea.png");
        this.setIconImage(img.getImage());
        String username=User;
        this.setLocationRelativeTo(null);
        list = new MenuBUS().getListMenu();
        model = (DefaultTableModel) tbMenu.getModel();
        model.setColumnIdentifiers(new Object[]{
            "STT", "Tên Món","Số Lượng", "Đơn Giá"
        });
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tbMenu.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        list1= new HoaDonBUS().getListHoaDon();
        list2= new CTHDBUS().getListCTHD();
        txtUser.setText(User);
        tbMenu.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbMenu.getColumnModel().getColumn(1).setPreferredWidth(150);
        tbMenu.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbMenu.getColumnModel().getColumn(3).setPreferredWidth(80);
        
        clearTable();
        mang[0][0]=0;
        for (int i=1;i<100;i++) mang[i][0]=0;
        mang[0][1]=0;
        mang[0][2]=0;
        mang[0][3]=0;

        txtMaHD.setText(getMaHoaDon());        
    }
    public String getTime(){
        Date x= new Date();
        return ftime.format(x);
    }
    public String getDate(){
        Date x= new Date();
        return fdate.format(x);
    }
    public String getText()    {
        return txtThanhTien.getText();
    }
    public void showTable() {
        int i=1;
        for (CTHDDTO s : list2) {
            model.addRow(new Object[]{
                i++, s.getTenMon(),s.getSoLuong(),s.getGia()
            });
        }
     }
    public void setThanhTien(int u) {
        this.thanhtien = u;
    }
    public Integer getThanhTien() {
        return thanhtien;
    }
    public void clock() {
        Thread clock = new Thread() {
            public void run() {
                try {
                    while (true) {
                        Date t = new Date();
                        lbTime.setText(ft.format(t));
                        sleep(1000);
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        clock.start();
    }
    public void clearTable() {
        for( int i = model.getRowCount() - 1; i >= 0; i-- ) {
            model.removeRow(i);
        }
    }
    public String getMaHoaDon(){
        String x=list1.get(list1.size()-1).getMaHoaDon().toString();
        String xx=x.substring(4);
        int ma=Integer.valueOf(xx);
        ma++;
        x=x.replaceFirst(xx,String.valueOf(ma)); 
        return x;
    }
     public String getMaCTHD(){
        String x=list2.get(list2.size()-1).getMaCTHD().toString();
        String xx=x.substring(4);
        int ma=Integer.valueOf(xx);
        ma++;
        x=x.replaceFirst(xx,String.valueOf(ma)); 
        return x;
    }
   
    public void showmenu(){
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("src//Image//coffee.jpg").getImage().getScaledInstance(300, 190, Image.SCALE_DEFAULT));
        lbBia.setIcon(imageIcon);
        ImageIcon imageIcon1 = new ImageIcon(new ImageIcon("src//Image//coffee-da.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        lb1.setIcon(imageIcon1);
        ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("src//Image//bacxiu.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        lb2.setIcon(imageIcon2);
        ImageIcon imageIcon3 = new ImageIcon(new ImageIcon("src//Image//coffee-suada.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        lb3.setIcon(imageIcon3);
        ImageIcon imageIcon4 = new ImageIcon(new ImageIcon("src//Image//cacao.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        lb4.setIcon(imageIcon4);
        ImageIcon imageIcon5 = new ImageIcon(new ImageIcon("src//Image//cacaonong.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        lb5.setIcon(imageIcon5);
        ImageIcon imageIcon6 = new ImageIcon(new ImageIcon("src//Image//camep.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        lb6.setIcon(imageIcon6);
        ImageIcon imageIcon7 = new ImageIcon(new ImageIcon("src//Image//carrot.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        lb7.setIcon(imageIcon7);
        ImageIcon imageIcon8 = new ImageIcon(new ImageIcon("src//Image//nuocngot.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        lb8.setIcon(imageIcon8);
        ImageIcon imageIcon9 = new ImageIcon(new ImageIcon("src//Image//nuocsuoi.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        lb9.setIcon(imageIcon9);
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
        jPanel4 = new javax.swing.JPanel();
        lb1 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lb6 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lb9 = new javax.swing.JLabel();
        lb7 = new javax.swing.JLabel();
        lb8 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        lbTime = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMenu = new javax.swing.JTable();
        txtThanhTien = new javax.swing.JTextField();
        btThanhToan = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbBia = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Gọi Món");
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(809, 488));

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 1, new java.awt.Color(51, 153, 255)));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/menu.png"))); // NOI18N
        jLabel1.setText("Thực Đơn");

        lb1.setForeground(new java.awt.Color(153, 255, 51));
        lb1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)));
        lb1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb1MouseClicked(evt);
            }
        });

        lb3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)));
        lb3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb3MouseClicked(evt);
            }
        });

        lb2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)));
        lb2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb2MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Coffee Đá");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("20.000Đ");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Bạc Xỉu");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("25.000Đ");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Coffee Sữa Đá");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("25.000Đ");

        lb6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)));
        lb6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb6MouseClicked(evt);
            }
        });

        lb4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)));
        lb4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb4MouseClicked(evt);
            }
        });

        lb5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)));
        lb5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb5MouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Ca Cao Đá");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("25.000Đ");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Ca Cao Nóng");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("20.000Đ");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Cam Vắt");
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("25.000Đ");

        lb9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)));
        lb9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb9MouseClicked(evt);
            }
        });

        lb7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)));
        lb7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb7MouseClicked(evt);
            }
        });

        lb8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)));
        lb8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb8MouseClicked(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Carrot Ép");
        jLabel26.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("15.000Đ");

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("25.000Đ");

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Nước Ngọt");
        jLabel29.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Nước Suối");
        jLabel30.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("10.000Đ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb4, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(60, 60, 60)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lb1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(lb2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18)
                                .addComponent(jLabel20))
                            .addComponent(jLabel22)))
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Phục vụ:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 1, 2, 2, new java.awt.Color(51, 153, 255)));

        jLabel5.setText("Mã HĐ");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Thành Tiền:");

        tbMenu.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbMenu);

        btThanhToan.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/thanhtoan.png"))); // NOI18N
        btThanhToan.setText("Thanh Toán");
        btThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThanhToanActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setText("Thời Gian:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbBia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbBia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/refresh.png"))); // NOI18N
        jButton1.setText("Tạo Mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btThanhToan)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenuBar1.setMinimumSize(new java.awt.Dimension(56, 30));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(56, 30));

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/taikhoan.png"))); // NOI18N
        jMenu2.setText("Tài Khoản");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Information.png"))); // NOI18N
        jMenuItem2.setText("Thông Tin Tài Khoản");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/change_pass.png"))); // NOI18N
        jMenuItem1.setText("Đổi Mật Khẩu");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/dangxuat.png"))); // NOI18N
        jMenuItem3.setText("Đăng Xuất");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem3MouseClicked(evt);
            }
        });
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Information.png"))); // NOI18N
        jMenu1.setText("Giới Thiệu");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sanpham.png"))); // NOI18N
        jMenu3.setText("Quản Lý Hóa Đơn");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb1MouseClicked
        // TODO add your handling code here:
        boolean kt= false;
        Object[] row= new Object[4];
         for (int j=0;j<=mang[stt][0];j++)
            if (mang[j][1]==1){
                stt=mang[j][0];
                kt=true;
                break;
            }
            else {
                for (int i=0;i<100;i++){
                    if (max<mang[i][0]) max=mang[i][0];
                }
                stt=max;
            }
        if (kt==false){
                for (int i=0;i<list.size();i++)
                if (list.get(i).getTenMon().equals("Coffee Ðá"))
                {   
                  stt++;
                  mang[stt][0]=stt;
                  mang[stt][1]=1;
                  mang[stt][2]=mang[stt][2]+1;
                  mang[stt][3]=list.get(i).getDonGia();
                  row[0]=stt;        
                  row[1]=list.get(i).getTenMon();
                  row[2]=mang[stt][2];
                  row[3]=list.get(i).getDonGia()*mang[stt][2];  
                  thanhtien+=list.get(i).getDonGia()*mang[stt][2];
                  model.addRow(row);  
                }
            }
        else{
           for( int i = model.getRowCount() - 1; i >= 0; i-- ){
                    if (model.getValueAt(stt-1,1).toString().equals("Coffee Ðá")){
                       mang[stt][2]=mang[stt][2]+1;
                       model.setValueAt(stt,stt-1,0);
                       model.setValueAt("Coffee Ðá",stt-1,1);
                       model.setValueAt(mang[stt][2],stt-1,2);
                       thanhtien+=mang[stt][3];
                       model.setValueAt(mang[stt][3]*mang[stt][2],stt-1,3);
                        break;
                    }
                }
        }
        
        txtThanhTien.setText(String.valueOf(thanhtien));
        setThanhTien(thanhtien);
    }//GEN-LAST:event_lb1MouseClicked

    private void lb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb2MouseClicked
       boolean kt= false;
        Object[] row= new Object[4];
         for (int j=0;j<=mang[stt][0];j++)
            if (mang[j][1]==2){
                stt=mang[j][0];
                kt=true;
                break;
            }
            else {
                for (int i=0;i<100;i++){
                    if (max<mang[i][0]) max=mang[i][0];
                }
                stt=max;
            }
        if (kt==false){
                for (int i=0;i<list.size();i++)
                if (list.get(i).getTenMon().equals("Bạc Xỉu"))
                {   
                  stt++;
                  mang[stt][0]=stt;
                  mang[stt][1]=2;
                  mang[stt][2]=mang[stt][2]+1;
                  mang[stt][3]=list.get(i).getDonGia();
                  row[0]=stt;        
                  row[1]=list.get(i).getTenMon();
                  row[2]=mang[stt][2];
                  row[3]=list.get(i).getDonGia()*mang[stt][2];      
                  model.addRow(row);  
                  thanhtien+=list.get(i).getDonGia()*mang[stt][2];
                }
            }
        else{
           for( int i = model.getRowCount() - 1; i >= 0; i-- ){
                    if (model.getValueAt(stt-1,1).toString().equals("Bạc Xỉu")){
                       mang[stt][2]=mang[stt][2]+1;
                       model.setValueAt(stt,stt-1,0);
                       model.setValueAt("Bạc Xỉu",stt-1,1);
                       model.setValueAt(mang[stt][2],stt-1,2);
                       model.setValueAt(mang[stt][3]*mang[stt][2],stt-1,3);
                       thanhtien+=mang[stt][3];
                       break;
                    }
                }
        }
         txtThanhTien.setText(String.valueOf(thanhtien));
         setThanhTien(thanhtien);
    }//GEN-LAST:event_lb2MouseClicked

    private void lb3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb3MouseClicked
        boolean kt= false;
        Object[] row= new Object[4];
         for (int j=0;j<=mang[stt][0];j++)
            if (mang[j][1]==3){
                stt=mang[j][0];
                kt=true;
                break;
            }
            else {
                for (int i=0;i<100;i++){
                    if (max<mang[i][0]) max=mang[i][0];
                }
                stt=max;
            }
        if (kt==false){
                for (int i=0;i<list.size();i++)
                if (list.get(i).getTenMon().equals("Coffee Sữa Đá"))
                {   
                  stt++;
                  mang[stt][0]=stt;
                  mang[stt][1]=3;
                  mang[stt][2]=mang[stt][2]+1;
                  mang[stt][3]=list.get(i).getDonGia();
                  row[0]=stt;        
                  row[1]=list.get(i).getTenMon();
                  row[2]=mang[stt][2];
                  row[3]=list.get(i).getDonGia()*mang[stt][2];      
                  model.addRow(row);  
                  thanhtien+=list.get(i).getDonGia()*mang[stt][2];
                }
            }
        else{
           for( int i = model.getRowCount() - 1; i >= 0; i-- ){
                    if (model.getValueAt(stt-1,1).toString().equals("Coffee Sữa Đá")){
                       mang[stt][2]=mang[stt][2]+1;
                       model.setValueAt(stt,stt-1,0);
                       model.setValueAt("Coffee Sữa Đá",stt-1,1);
                       model.setValueAt(mang[stt][2],stt-1,2);
                       model.setValueAt(mang[stt][3]*mang[stt][2],stt-1,3);
                       thanhtien+=mang[stt][3];
                       break;
                    }
                }
        }
        txtThanhTien.setText(String.valueOf(thanhtien));
        setThanhTien(thanhtien);
    }//GEN-LAST:event_lb3MouseClicked

    private void lb4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb4MouseClicked
      boolean kt= false;
        Object[] row= new Object[4];
         for (int j=0;j<=mang[stt][0];j++)
            if (mang[j][1]==4){
                stt=mang[j][0];
                kt=true;
                break;
            }
            else {
                for (int i=0;i<100;i++){
                    if (max<mang[i][0]) max=mang[i][0];
                }
                stt=max;
            }
        if (kt==false){
                for (int i=0;i<list.size();i++)
                if (list.get(i).getTenMon().equals("Ca Cao Đá"))
                {   
                  stt++;
                  mang[stt][0]=stt;
                  mang[stt][1]=4;
                  mang[stt][2]=mang[stt][2]+1;
                  mang[stt][3]=list.get(i).getDonGia();
                  row[0]=stt;        
                  row[1]=list.get(i).getTenMon();
                  row[2]=mang[stt][2];
                  row[3]=list.get(i).getDonGia()*mang[stt][2];      
                  model.addRow(row);  
                  thanhtien+=list.get(i).getDonGia()*mang[stt][2];
                }
            }
        else{
           for( int i = model.getRowCount() - 1; i >= 0; i-- ){
                    if (model.getValueAt(stt-1,1).toString().equals("Ca Cao Đá")){
                       mang[stt][2]=mang[stt][2]+1;
                       model.setValueAt(stt,stt-1,0);
                       model.setValueAt("Ca Cao Đá",stt-1,1);
                       model.setValueAt(mang[stt][2],stt-1,2);
                       model.setValueAt(mang[stt][3]*mang[stt][2],stt-1,3);
                       thanhtien+=mang[stt][3];
                       break;
                    }
                }
        }
         txtThanhTien.setText(String.valueOf(thanhtien));
         setThanhTien(thanhtien);
    }//GEN-LAST:event_lb4MouseClicked

    private void lb5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb5MouseClicked
       boolean kt= false;
        Object[] row= new Object[4];
         for (int j=0;j<=mang[stt][0];j++)
            if (mang[j][1]==5){
                stt=mang[j][0];
                kt=true;
                break;
            }
            else {
                for (int i=0;i<100;i++){
                    if (max<mang[i][0]) max=mang[i][0];
                }
                stt=max;
            }
        if (kt==false){
                for (int i=0;i<list.size();i++)
                if (list.get(i).getTenMon().equals("Ca Cao Nóng"))
                {   
                  stt++;
                  mang[stt][0]=stt;
                  mang[stt][1]=5;
                  mang[stt][2]=mang[stt][2]+1;
                  mang[stt][3]=list.get(i).getDonGia();
                  row[0]=stt;        
                  row[1]=list.get(i).getTenMon();
                  row[2]=mang[stt][2];
                  row[3]=list.get(i).getDonGia()*mang[stt][2];      
                  model.addRow(row); 
                  thanhtien+=list.get(i).getDonGia()*mang[stt][2];
                }
            }
        else{
           for( int i = model.getRowCount() - 1; i >= 0; i-- ){
                    if (model.getValueAt(stt-1,1).toString().equals("Ca Cao Nóng")){
                       mang[stt][2]=mang[stt][2]+1;
                       model.setValueAt(stt,stt-1,0);
                       model.setValueAt("Ca Cao Nóng",stt-1,1);
                       model.setValueAt(mang[stt][2],stt-1,2);
                       model.setValueAt(mang[stt][3]*mang[stt][2],stt-1,3);
                       thanhtien+=mang[stt][3];
                       break;
                    }
                }
        }
         txtThanhTien.setText(String.valueOf(thanhtien));
         setThanhTien(thanhtien);
    }//GEN-LAST:event_lb5MouseClicked

    private void lb6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb6MouseClicked
        boolean kt= false;
        Object[] row= new Object[4];
         for (int j=0;j<=mang[stt][0];j++)
            if (mang[j][1]==6){
                stt=mang[j][0];
                kt=true;
                break;
            }
            else {
                for (int i=0;i<100;i++){
                    if (max<mang[i][0]) max=mang[i][0];
                }
                stt=max;
            }
        if (kt==false){
                for (int i=0;i<list.size();i++)
                if (list.get(i).getTenMon().equals("Cam Vắt"))
                {   
                  stt++;
                  mang[stt][0]=stt;
                  mang[stt][1]=6;
                  mang[stt][2]=mang[stt][2]+1;
                  mang[stt][3]=list.get(i).getDonGia();
                  row[0]=stt;        
                  row[1]=list.get(i).getTenMon();
                  row[2]=mang[stt][2];
                  row[3]=list.get(i).getDonGia()*mang[stt][2];      
                  model.addRow(row);  
                  thanhtien+=list.get(i).getDonGia()*mang[stt][2];
                }
            }
        else{
           for( int i = model.getRowCount() - 1; i >= 0; i-- ){
                    if (model.getValueAt(stt-1,1).toString().equals("Cam Vắt")){
                       mang[stt][2]=mang[stt][2]+1;
                       model.setValueAt(stt,stt-1,0);
                       model.setValueAt("Cam Vắt",stt-1,1);
                       model.setValueAt(mang[stt][2],stt-1,2);
                       model.setValueAt(mang[stt][3]*mang[stt][2],stt-1,3);
                       thanhtien+=mang[stt][3];
                       break;
                    }
                }
        }
        txtThanhTien.setText(String.valueOf(thanhtien));
        setThanhTien(thanhtien);
    }//GEN-LAST:event_lb6MouseClicked

    private void lb7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb7MouseClicked
        boolean kt= false;
        Object[] row= new Object[4];
         for (int j=0;j<=mang[stt][0];j++)
            if (mang[j][1]==7){
                stt=mang[j][0];
                kt=true;
                break;
            }
            else {
                for (int i=0;i<100;i++){
                    if (max<mang[i][0]) max=mang[i][0];
                }
                stt=max;
            }
        if (kt==false){
                for (int i=0;i<list.size();i++)
                if (list.get(i).getTenMon().equals("Carrot Ép"))
                {   
                  stt++;
                  mang[stt][0]=stt;
                  mang[stt][1]=7;
                  mang[stt][2]=mang[stt][2]+1;
                  mang[stt][3]=list.get(i).getDonGia();
                  row[0]=stt;        
                  row[1]=list.get(i).getTenMon();
                  row[2]=mang[stt][2];
                  row[3]=list.get(i).getDonGia()*mang[stt][2];      
                  model.addRow(row);  
                  thanhtien+=list.get(i).getDonGia()*mang[stt][2];
                }
            }
        else{
           for( int i = model.getRowCount() - 1; i >= 0; i-- ){
                    if (model.getValueAt(stt-1,1).toString().equals("Carrot Ép")){
                       mang[stt][2]=mang[stt][2]+1;
                       model.setValueAt(stt,stt-1,0);
                       model.setValueAt("Carrot Ép",stt-1,1);
                       model.setValueAt(mang[stt][2],stt-1,2);
                       model.setValueAt(mang[stt][3]*mang[stt][2],stt-1,3);
                       thanhtien+=mang[stt][3];
                       break;
                    }
                }
        }
        txtThanhTien.setText(String.valueOf(thanhtien));
        setThanhTien(thanhtien);
    }//GEN-LAST:event_lb7MouseClicked

    private void lb8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb8MouseClicked
     
        boolean kt= false;
        Object[] row= new Object[4];
         for (int j=0;j<=mang[stt][0];j++)
            if (mang[j][1]==8){
                stt=mang[j][0];
                kt=true;
                break;
            }
            else {
                for (int i=0;i<100;i++){
                    if (max<mang[i][0]) max=mang[i][0];
                }
                stt=max;
            }
        if (kt==false){
                for (int i=0;i<list.size();i++)
                if (list.get(i).getTenMon().equals("Nước Ngọt"))
                {   
                  stt++;
                  mang[stt][0]=stt;
                  mang[stt][1]=8;
                  mang[stt][2]=mang[stt][2]+1;
                  mang[stt][3]=list.get(i).getDonGia();
                  row[0]=stt;        
                  row[1]=list.get(i).getTenMon();
                  row[2]=mang[stt][2];
                  row[3]=list.get(i).getDonGia()*mang[stt][2];      
                  model.addRow(row);
                  thanhtien+=list.get(i).getDonGia()*mang[stt][2];
                }
            }
        else{
           for( int i = model.getRowCount() - 1; i >= 0; i-- ){
                    if (model.getValueAt(stt-1,1).toString().equals("Nước Ngọt")){
                       mang[stt][2]=mang[stt][2]+1;
                       model.setValueAt(stt,stt-1,0);
                       model.setValueAt("Nước Ngọt",stt-1,1);
                       model.setValueAt(mang[stt][2],stt-1,2);
                       model.setValueAt(mang[stt][3]*mang[stt][2],stt-1,3);
                       thanhtien+=mang[stt][3];
                       break;
                    }
                }
        }
         txtThanhTien.setText(String.valueOf(thanhtien));
         setThanhTien(thanhtien);
    }//GEN-LAST:event_lb8MouseClicked

    private void lb9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb9MouseClicked
         boolean kt= false;
        Object[] row= new Object[4];
         for (int j=0;j<=mang[stt][0];j++)
            if (mang[j][1]==9){
                stt=mang[j][0];
                kt=true;
                break;
            }
            else {
                for (int i=0;i<100;i++){
                    if (max<mang[i][0]) max=mang[i][0];
                }
                stt=max;
            }
        if (kt==false){
                for (int i=0;i<list.size();i++)
                if (list.get(i).getTenMon().equals("Nước Suối"))
                {   
                  stt++;
                  mang[stt][0]=stt;
                  mang[stt][1]=9;
                  mang[stt][2]=mang[stt][2]+1;
                  mang[stt][3]=list.get(i).getDonGia();
                  row[0]=stt;        
                  row[1]=list.get(i).getTenMon();
                  row[2]=mang[stt][2];
                  row[3]=list.get(i).getDonGia()*mang[stt][2];      
                  model.addRow(row);  
                  thanhtien+=list.get(i).getDonGia()*mang[stt][2];
                }
            }
        else{
           for( int i = model.getRowCount() - 1; i >= 0; i-- ){
                    if (model.getValueAt(stt-1,1).toString().equals("Nước Suối")){
                       mang[stt][2]=mang[stt][2]+1;
                       model.setValueAt(stt,stt-1,0);
                       model.setValueAt("Nước Suối",stt-1,1);
                       model.setValueAt(mang[stt][2],stt-1,2);
                       model.setValueAt(mang[stt][3]*mang[stt][2],stt-1,3);
                       thanhtien+=mang[stt][3];
                       break;
                    }
                }
        }
         txtThanhTien.setText(String.valueOf(thanhtien));
         setThanhTien(thanhtien);
    }//GEN-LAST:event_lb9MouseClicked

    private void btThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThanhToanActionPerformed
        // TODO add your handling code here:
        CTHDDTO cthd= new CTHDDTO();
        HoaDonDTO hoadon=new HoaDonDTO();
        MenuDTO menu= new MenuDTO();
        int soluong=0;
        for( int i = model.getRowCount() - 1; i >= 0; i-- ){
            soluong+=Integer.valueOf(model.getValueAt(i,2).toString());
        }
        hoadon.setMaHoaDon(txtMaHD.getText());
        hoadon.setNgayLapHD(getDate());
        hoadon.setThoiGian(getTime());
        hoadon.setSoLuong(soluong);
        hoadon.setMaNV(txtUser.getText());
        if (new HoaDonBUS().addHoaDon(hoadon)) {
                list1.add(hoadon);
                } else {
                    JOptionPane.showMessageDialog(null, "Lỗi.");
                }
            
        for( int i = model.getRowCount() - 1; i >= 0; i-- ){
            cthd.setMaHoaDon(txtMaHD.getText());
            for (int j=0;j<list.size();j++){
                if (list.get(j).getTenMon().toString().equals(model.getValueAt(i,1).toString())){
                    cthd.setMaMon(list.get(j).getMaMon());
                    cthd.setTenMon(list.get(j).getTenMon());
                    cthd.setGia(Integer.valueOf(model.getValueAt(i,3).toString()));
                    cthd.setSoLuong(Integer.valueOf(model.getValueAt(i,2).toString()));
                    break;
                }    
            }
            if (new CTHDBUS().addCTHD(cthd)) {
                list2.add(cthd);
                } else {
                    JOptionPane.showMessageDialog(null, "Lỗi.");
                }
            
        }
        int soluongton=0;
        int soluongton1=0;
        for( int i = model.getRowCount() - 1; i >= 0; i-- ){
            for (int j=0;j<list.size();j++){
                if (list.get(j).getTenMon().toString().equals(model.getValueAt(i,1).toString())){
                    menu.setMaMon(list.get(j).getMaMon().toString());
                    menu.setTenMon(list.get(j).getTenMon().toString());
                    menu.setDonGia(Integer.valueOf(list.get(j).getDonGia().toString()));
                    soluongton= Integer.valueOf(list.get(j).getSoLuongTon());
                    soluongton1=Integer.valueOf(model.getValueAt(i,2).toString());
                    menu.setSoLuongTon(soluongton-soluongton1);
                    System.out.println(soluongton);
                    System.out.println(soluongton1);
                    if (new MenuBUS().updateMenu(menu)){
                        System.out.println("...");
                    }
                    break;
                }
            }
        }
        ThanhToan_Form s= new ThanhToan_Form(getThanhTien().toString());
        s.setVisible(true);
        s.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       
    }//GEN-LAST:event_btThanhToanActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        new TaiKhoanNV_Form(txtUser.getText()).setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
         new MatKhauNV_Form(txtUser.getText()).setVisible(true);
         this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        GioiThieu_Form s=new GioiThieu_Form();
        s.setVisible(true);
        s.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenuItem3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenuItem3MouseClicked
    public void showExit(){
            int kQ = JOptionPane.showConfirmDialog(null,
                    "Bạn có muốn đăng xuất không ?","Đăng Xuất",JOptionPane.YES_NO_OPTION);
            if(kQ == 0){
               DangNhap_Form s=new DangNhap_Form();
               s.setVisible(true);
               this.dispose();
            }
        }
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        showExit();
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:
        HoaDon_Form s=new HoaDon_Form();
        s.setVisible(true);
        s.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // TODO add your handling code here:
          HoaDon_Form s=new HoaDon_Form();
        s.setVisible(true);
        s.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        clearTable(); 
        stt=0;
        max=-2000;
        txtMaHD.setText(getMaHoaDon());
    
        thanhtien=0;
        txtThanhTien.setText("");
        for (int i=0;i<100;i++)
            for (int j=0;j<4;j++) mang[i][j]=0;
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TrangChu_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChu_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChu_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChu_Form("MaNV003").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btThanhToan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb7;
    private javax.swing.JLabel lb8;
    private javax.swing.JLabel lb9;
    private javax.swing.JLabel lbBia;
    private javax.swing.JLabel lbTime;
    private javax.swing.JTable tbMenu;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}