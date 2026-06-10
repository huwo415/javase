package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.List;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Product_Sale extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textSearch;
	private Product_Sale f;
	private PricSet framePricSet;
	private Sale_details frameSale_details;
	private CustomerUi frameCust;
	private Customer[] customer;
	private Customer objCust;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtDateTime;
	private Order[] order;
	private int sum;
	private int orderID;
	private JButton btnSale;
	private JTextField txt4KG;
	private JTextField txt10KG;
	private JTextField txt16KG;
	private JTextField txt20KG;
	private JTextField txt50KG;
	private JLabel labName;
	private JLabel labTel1, labTel2;
	private JLabel labAddress;
	private JLabel labSum;
	private JLabel labCustNum;
	private JList<String> listOrder;
	private JScrollPane scrollPane;

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Product_Sale frame = new Product_Sale();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Product_Sale() {

		

		f = this;
		customer = new Customer[100];
		order = new Order[100];
		orderID = 0;
        f.setResizable(false);
		
		
		frameCust = new CustomerUi(customer);
		frameCust.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frameCust.setResizable(false);
		setBounds(500, 200, 679, 507);

		framePricSet = new PricSet();
		framePricSet.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		framePricSet.setResizable(false);
		frameSale_details = new Sale_details();
		framePricSet.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		frameSale_details = new Sale_details();
		frameSale_details.setResizable(false);
		frameSale_details.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frameSale_details.txtOut
				.append("                                                                                 銷售明細\n");
		frameSale_details.txtOut.append(
				"----------------------------------------------------------------------------------------------------------\n");
		frameSale_details.txtOut
				.append(" 日 期  時  間\t客戶姓名\t電話(市話)\t手機\t" + String.format("%-4s %-4s %-4s %-4s %-8s %-12s", "4KG",
						"10KG", "16KG", "20KG", "50KG", "金           額") + "\n");

		// frameSale_details.txtOut.append(" 日 期 時
		// 間\t客戶姓名\t電話(市話)\t手機\t4KG\t10KG\t16KG\t20KG\t50KG 金 額\n");
		frameSale_details.txtOut.append("===================================================================+\n");
		setTitle("產品銷售");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 673, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 255));
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 10, 671, 460);
		contentPane.add(panel);

		// 1. 建立 DefaultListModel 來存放資料
		DefaultListModel<String> model = new DefaultListModel<>();

		// 2. 將 model 綁定到 JList 上
		listOrder = new JList<>(model);
		listOrder.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
			    
				String strList=listOrder.getSelectedValue();
			
			}
		});
		listOrder.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 14));
		listOrder.setForeground(new Color(0, 0, 255));

		// 3. 建立 JScrollPane 並將 JList 放入建構子中
		scrollPane = new JScrollPane(listOrder);
		scrollPane.setBounds(10, 79, 238, 300);
		panel.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		// scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		panel.setLayout(null);

		// ============================================

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(251, 20, 397, 176);
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_1);
		panel_1.setLayout(null);

		JRadioButton rdoNumber = new JRadioButton("編號");
		rdoNumber.setForeground(new Color(0, 0, 255));
		rdoNumber.setSelected(true);
		buttonGroup.add(rdoNumber);

		rdoNumber.setBounds(6, 6, 68, 22);
		panel_1.add(rdoNumber);

		JRadioButton rdoName = new JRadioButton("姓名");
		rdoName.setForeground(new Color(0, 0, 255));
		buttonGroup.add(rdoName);
		rdoName.setBounds(76, 6, 63, 22);
		panel_1.add(rdoName);
		rdoNumber.isFontSet();

		JRadioButton rdoTel1 = new JRadioButton("市話");
		rdoTel1.setForeground(new Color(0, 0, 255));
		buttonGroup.add(rdoTel1);
		rdoTel1.setBounds(141, 6, 55, 22);
		panel_1.add(rdoTel1);

		JRadioButton rdoTel2 = new JRadioButton("手機");
		rdoTel2.setForeground(new Color(0, 0, 255));
		buttonGroup.add(rdoTel2);
		rdoTel2.setBounds(198, 6, 63, 22);
		panel_1.add(rdoTel2);

		JLabel lblNewLabel_1 = new JLabel("客戶編號:");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("微軟正黑體 Light", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 70, 79, 26);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("市      話:");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體 Light", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 106, 66, 26);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("地      址:");
		lblNewLabel_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體 Light", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(10, 142, 72, 26);
		panel_1.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_3 = new JLabel("客戶姓名:");
		lblNewLabel_1_3.setForeground(Color.BLUE);
		lblNewLabel_1_3.setFont(new Font("微軟正黑體 Light", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(198, 70, 79, 26);
		panel_1.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_2 = new JLabel("手      機:");
		lblNewLabel_1_2.setForeground(Color.BLUE);
		lblNewLabel_1_2.setFont(new Font("微軟正黑體 Light", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(198, 106, 72, 26);
		panel_1.add(lblNewLabel_1_2);

		labCustNum = new JLabel("");
		labCustNum.setHorizontalAlignment(SwingConstants.LEFT);
		labCustNum.setForeground(Color.BLUE);
		labCustNum.setFont(new Font("微軟正黑體 Light", Font.BOLD, 16));
		labCustNum.setBounds(76, 106, 79, 26);
		panel_1.add(labCustNum);

		labTel1 = new JLabel("");
		labTel1.setHorizontalAlignment(SwingConstants.LEFT);
		labTel1.setForeground(Color.BLUE);
		labTel1.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 16));
		labTel1.setBounds(81, 106, 100, 26);
		panel_1.add(labTel1);

		labAddress = new JLabel("");
		labAddress.setHorizontalAlignment(SwingConstants.LEFT);
		labAddress.setForeground(Color.BLUE);
		labAddress.setFont(new Font("微軟正黑體 Light", Font.BOLD, 16));
		labAddress.setBounds(81, 142, 292, 26);
		panel_1.add(labAddress);

		labName = new JLabel("");
		labName.setHorizontalAlignment(SwingConstants.LEFT);
		labName.setForeground(Color.BLUE);
		labName.setFont(new Font("微軟正黑體 Light", Font.BOLD, 16));
		labName.setBounds(276, 70, 104, 26);
		panel_1.add(labName);

		labTel2 = new JLabel("");
		labTel2.setHorizontalAlignment(SwingConstants.LEFT);
		labTel2.setForeground(Color.BLUE);
		labTel2.setFont(new Font("微軟正黑體 Light", Font.BOLD, 16));
		labTel2.setBounds(276, 106, 104, 26);
		panel_1.add(labTel2);

		JLabel lblNewLabel_3 = new JLabel("請輸入搜尋客戶編號或姓名或電話");
		lblNewLabel_3.setForeground(new Color(0, 0, 255));
		lblNewLabel_3.setFont(new Font("微軟正黑體 Light", Font.BOLD, 16));
		lblNewLabel_3.setBounds(17, 209, 260, 23);
		panel_1.add(lblNewLabel_3);

		textSearch = new JTextField();
		textSearch.setForeground(new Color(0, 0, 255));
		textSearch.setHorizontalAlignment(SwingConstants.CENTER);
		textSearch.setFont(new Font("微軟正黑體 Light", Font.BOLD, 16));
		textSearch.setBounds(75, 32, 186, 28);
		panel_1.add(textSearch);
		textSearch.setColumns(10);

		JButton btnSearch = new JButton("搜尋");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setForeground(new Color(0, 0, 255));
		btnSearch.setBackground(new Color(255, 255, 255));
		btnSearch.setFont(new Font("微软雅黑 Light", Font.BOLD, 12));
		btnSearch.setBounds(6, 34, 66, 26);
		panel_1.add(btnSearch);

		JLabel labCustNum = new JLabel("");
		labCustNum.setHorizontalAlignment(SwingConstants.CENTER);
		labCustNum.setForeground(new Color(0, 0, 255));
		labCustNum.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 16));
		labCustNum.setBounds(85, 70, 96, 26);
		panel_1.add(labCustNum);

		JButton btnCustomer = new JButton("客戶資料設定");
		btnCustomer.setBounds(251, 389, 121, 39);
		btnCustomer.setForeground(new Color(0, 0, 255));
		btnCustomer.setBackground(new Color(255, 255, 255));
		btnCustomer.setFont(new Font("微软雅黑 Light", Font.BOLD, 14));

		panel.add(btnCustomer);

		JButton btnPricSet = new JButton("瓦斯價格設定");
		btnPricSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPricSet.setBounds(370, 389, 121, 39);
		btnPricSet.setBackground(new Color(255, 255, 255));

		JButton btnSaledtetails = new JButton("銷售明細");
		btnSaledtetails.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 14));
		btnSaledtetails.setForeground(new Color(0, 0, 255));
		btnSaledtetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnSaledtetails.setBounds(10, 389, 130, 38);
		panel.add(btnSaledtetails);

		btnPricSet.setForeground(new Color(0, 0, 255));
		btnPricSet.setFont(new Font("微软雅黑 Light", Font.BOLD, 14));
		panel.add(btnPricSet);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(251, 206, 397, 173);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(new Color(192, 192, 192));
		panel.add(panel_2);
		panel_2.setLayout(null);

		txt4KG = new JTextField();
		
		txt4KG.setHorizontalAlignment(SwingConstants.CENTER);
		txt4KG.setForeground(Color.BLUE);
		txt4KG.setFont(new Font("微软雅黑 Light", Font.BOLD, 16));
		txt4KG.setColumns(10);
		txt4KG.setBounds(81, 42, 55, 32);
		panel_2.add(txt4KG);

		txt10KG = new JTextField();
		
		txt10KG.setHorizontalAlignment(SwingConstants.CENTER);
		txt10KG.setForeground(Color.BLUE);
		txt10KG.setFont(new Font("微软雅黑 Light", Font.BOLD, 16));
		txt10KG.setColumns(10);
		txt10KG.setBounds(135, 42, 55, 32);
		panel_2.add(txt10KG);

		txt16KG = new JTextField();
		
		txt16KG.setHorizontalAlignment(SwingConstants.CENTER);
		txt16KG.setForeground(Color.BLUE);
		txt16KG.setFont(new Font("微软雅黑 Light", Font.BOLD, 16));
		txt16KG.setColumns(10);
		txt16KG.setBounds(189, 42, 55, 32);
		panel_2.add(txt16KG);

		txt20KG = new JTextField();
		
		txt20KG.setHorizontalAlignment(SwingConstants.CENTER);
		txt20KG.setForeground(Color.BLUE);
		txt20KG.setFont(new Font("微软雅黑 Light", Font.BOLD, 16));
		txt20KG.setColumns(10);
		txt20KG.setBounds(243, 42, 55, 32);
		panel_2.add(txt20KG);

		txt50KG = new JTextField();
		
		txt50KG.setHorizontalAlignment(SwingConstants.CENTER);
		txt50KG.setForeground(Color.BLUE);
		txt50KG.setFont(new Font("微软雅黑 Light", Font.BOLD, 16));
		txt50KG.setColumns(10);
		txt50KG.setBounds(297, 42, 55, 32);
		panel_2.add(txt50KG);

		JLabel lblNewLabel = new JLabel("4KG");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBackground(new Color(128, 128, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微软雅黑 Light", Font.BOLD, 14));
		lblNewLabel.setBounds(85, 10, 45, 32);
		panel_2.add(lblNewLabel);

		JLabel lblkg = new JLabel("10KG");
		lblkg.setForeground(new Color(0, 0, 255));
		lblkg.setHorizontalAlignment(SwingConstants.CENTER);
		lblkg.setFont(new Font("微软雅黑 Light", Font.BOLD, 14));
		lblkg.setBackground(new Color(128, 128, 128));
		lblkg.setBounds(139, 10, 45, 32);
		panel_2.add(lblkg);

		JLabel lblkg_1 = new JLabel("16KG");
		lblkg_1.setForeground(new Color(0, 0, 255));
		lblkg_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblkg_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 14));
		lblkg_1.setBackground(new Color(128, 128, 128));
		lblkg_1.setBounds(193, 10, 45, 32);
		panel_2.add(lblkg_1);

		JLabel lblkg_2 = new JLabel("20KG");
		lblkg_2.setForeground(new Color(0, 0, 255));
		lblkg_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblkg_2.setFont(new Font("微软雅黑 Light", Font.BOLD, 14));
		lblkg_2.setBackground(new Color(128, 128, 128));
		lblkg_2.setBounds(248, 10, 45, 32);
		panel_2.add(lblkg_2);

		JLabel lblkg_3 = new JLabel("50KG");
		lblkg_3.setForeground(new Color(0, 0, 255));
		lblkg_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblkg_3.setFont(new Font("微软雅黑 Light", Font.BOLD, 14));
		lblkg_3.setBackground(new Color(128, 128, 128));
		lblkg_3.setBounds(300, 10, 45, 32);
		panel_2.add(lblkg_3);

		JLabel lblNewLabel_2 = new JLabel("每桶");
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("微软雅黑 Light", Font.BOLD, 14));
		lblNewLabel_2.setBackground(new Color(128, 128, 128));
		lblNewLabel_2.setBounds(37, 10, 45, 32);
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("數量");
		lblNewLabel_4.setForeground(new Color(0, 0, 255));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("微软雅黑 Light", Font.BOLD, 14));
		lblNewLabel_4.setBackground(new Color(128, 128, 64));
		lblNewLabel_4.setBounds(37, 42, 45, 32);
		panel_2.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("合計:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setForeground(new Color(0, 0, 255));
		lblNewLabel_5.setBackground(new Color(240, 240, 240));
		lblNewLabel_5.setFont(new Font("微软雅黑 Light", Font.BOLD, 14));
		lblNewLabel_5.setBounds(37, 78, 40, 32);
		panel_2.add(lblNewLabel_5);

		labSum = new JLabel("");
		labSum.setHorizontalAlignment(SwingConstants.LEFT);
		labSum.setForeground(new Color(0, 0, 255));
		labSum.setFont(new Font("微軟正黑體 Light", Font.BOLD, 14));
		labSum.setBounds(77, 84, 275, 26);
		panel_2.add(labSum);

		JButton btnDel = new JButton("清除");
		
		
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDel.setForeground(new Color(0, 0, 255));
		btnDel.setFont(new Font("微软雅黑 Light", Font.BOLD, 14));
		btnDel.setBounds(175, 129, 105, 34);
		panel_2.add(btnDel);

		JLabel lblNewLabel_7 = new JLabel("時          間     姓     名   金    額");
		lblNewLabel_7.setBounds(10, 47, 231, 22);
		lblNewLabel_7.setToolTipText(" ");
		lblNewLabel_7.setBackground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 16));
		lblNewLabel_7.setForeground(new Color(0, 0, 255));
		panel.add(lblNewLabel_7);

		

		
		JLabel lblNewLabel_6 = new JLabel("產 品 消 費 記 錄");
		lblNewLabel_6.setBounds(28, 20, 192, 25);
		panel.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("微软雅黑 Light", Font.BOLD, 16));
		lblNewLabel_6.setBackground(new Color(255, 255, 255));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(new Color(0, 0, 255));
		
		
		JButton btnExit = new JButton("離開");
		btnExit.setForeground(Color.BLUE);
		btnExit.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 14));
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(527, 389, 121, 39);
		panel.add(btnExit);

		// ===================event========================

		txt4KG.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!txt4KG.getText().isBlank()) {

					
					if (!txt4KG.getText().matches("\\d+")) {

						JOptionPane.showMessageDialog(f,"4KG欄位必須輸入數字","ERROR", JOptionPane.ERROR_MESSAGE);
						txt4KG.setText("");
					}
				}
			
			}
		});
		
		txt10KG.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			
              if (!txt10KG.getText().isBlank()) {

					
					if (!txt10KG.getText().matches("\\d+")) {

						JOptionPane.showMessageDialog(f,"10KG欄位必須輸入數字","ERROR", JOptionPane.ERROR_MESSAGE);
						txt10KG.setText("");
					}
				}
			
			}
		});
		
		
		txt16KG.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			
                if (!txt16KG.getText().isBlank()) {

					
					if (!txt16KG.getText().matches("\\d+")) {

						JOptionPane.showMessageDialog(f,"16KG欄位必須輸入數字","ERROR", JOptionPane.ERROR_MESSAGE);
						txt16KG.setText("");
					}
				}
			
			
			}
		});
		
		txt20KG.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			
                if (!txt20KG.getText().isBlank()) {

					
					if (!txt20KG.getText().matches("\\d+")) {

						JOptionPane.showMessageDialog(f,"20KG欄位必須輸入數字","ERROR", JOptionPane.ERROR_MESSAGE);
						txt20KG.setText("");
					}
				}   
			
			}
		});
		
		
		txt50KG.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			
              if (!txt50KG.getText().isBlank()) {

					
					if (!txt50KG.getText().matches("\\d+")) {

						JOptionPane.showMessageDialog(f,"50KG欄位必須輸入數字","ERROR", JOptionPane.ERROR_MESSAGE);
						txt50KG.setText("");
					}
				}   
			
			}
		});
		
		
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				frameCust.setVisible(true);

			}
		});

		btnPricSet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				framePricSet.setVisible(true);
			}
		});

		btnSaledtetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				frameSale_details.setVisible(true);

			}

		});

		btnSale = new JButton("結帳");
		btnSale.setFont(new Font("新細明體", Font.BOLD, 14));
		btnSale.setForeground(new Color(0, 0, 255));
		btnSale.setBounds(279, 129, 108, 34);
		panel_2.add(btnSale);

		btnSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
			
				
		btnSale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String str;
				
				//labCustNum.setText("");
				
				if(!labCustNum.getText().isBlank()&&!labName.getText().isBlank()&&checkQuant()) {
					
					//labCustNum.setText("");
					
					sum = gas_sum();

					labSum.setText("" + sum);

					if (sum != 0) {

						str = order_rec(sum);
						model.addElement(str);
						
						//btnSale.setEnabled(false);
					}
				} else {

					labCustNum.setText("");
					JOptionPane.showMessageDialog(f, "數量欄位必須>0或不能空白及客戶姓名欄位不能空白", "瓦斯銷售資料", JOptionPane.WARNING_MESSAGE);
					delSaleInputData();
				}
			
					
			}
		});

		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				if (textSearch.getText().isBlank()) {

					JOptionPane.showMessageDialog(f, "搜尋欄位不能空白", "客戶資料搜尋", JOptionPane.WARNING_MESSAGE);
					delSaleInputData();
				} else if (rdoNumber.isSelected()) {
					if (!textSearch.getText().matches("\\d+")) {
						delSaleInputData();
						JOptionPane.showMessageDialog(f, "搜尋編號必須輸入數字", "客戶資料搜尋", JOptionPane.ERROR_MESSAGE);

					} else {
						objCust = customer[Integer.parseInt(textSearch.getText())];

						if (objCust != null) {
							labCustNum.setText(objCust.getCustNumber());
							labName.setText(objCust.getName());
							labTel1.setText(objCust.getTel1());
							labTel2.setText(objCust.getTel2());
							labAddress.setText(objCust.getAddress());
							btnSale.setEnabled(true);
							txt4KG.setText("");
							txt10KG.setText("");
							txt16KG.setText("");
							txt20KG.setText("");
							txt50KG.setText("");
							labSum.setText(""); 
							textSearch.setText("");
							txt4KG.requestFocus();
						} else {

							delSaleInputData();
							JOptionPane.showMessageDialog(f, "客戶資料未建立 ?", "客戶資料搜尋", JOptionPane.ERROR_MESSAGE);
						
						}
					}

				} else if (rdoName.isSelected()) {

					int intCust;

					intCust = f.Search(f.textSearch.getText(), 1);

					if (intCust != 0) {

						objCust = customer[intCust];

						labCustNum.setText(objCust.getCustNumber());
						labName.setText(objCust.getName());
						labTel1.setText(objCust.getTel1());
						labTel2.setText(objCust.getTel2());
						labAddress.setText(objCust.getAddress());
						btnSale.setEnabled(true);
						txt4KG.setText("");
						txt10KG.setText("");
						txt16KG.setText("");
						txt20KG.setText("");
						txt50KG.setText("");
						labSum.setText("");
						textSearch.setText("");
						txt4KG.requestFocus();
					} else {

						

						JOptionPane.showMessageDialog(f, "找不到" + textSearch.getText() + "的客戶資料 ?", "客戶資料搜尋",
									                  JOptionPane.ERROR_MESSAGE);
						delSaleInputData();										
					}

				} else if (rdoTel1.isSelected()) {

					int intCust;

					intCust = f.Search(f.textSearch.getText(), 2);

					if (intCust != 0) {

						objCust = customer[intCust];

						labCustNum.setText(objCust.getCustNumber());
						labName.setText(objCust.getName());
						labTel1.setText(objCust.getTel1());
						labTel2.setText(objCust.getTel2());
						labAddress.setText(objCust.getAddress());
						btnSale.setEnabled(true);
						txt4KG.setText("");
						txt10KG.setText("");
						txt16KG.setText("");
						txt20KG.setText("");
						txt50KG.setText("");
						labSum.setText("");
						textSearch.setText("");
						txt4KG.requestFocus();
					
					} else {

						

						JOptionPane.showMessageDialog(f, "找不到" + textSearch.getText() + "的客戶市話 ?", "客戶資料搜尋",
								JOptionPane.ERROR_MESSAGE);
						delSaleInputData(); 
					   
					}

				} else if (rdoTel2.isSelected()) {

					int intCust;

					intCust = f.Search(f.textSearch.getText(), 3);

					if (intCust != 0) {

						objCust = customer[intCust];

						labCustNum.setText(objCust.getCustNumber());
						labName.setText(objCust.getName());
						labTel1.setText(objCust.getTel1());
						labTel2.setText(objCust.getTel2());
						labAddress.setText(objCust.getAddress());
						btnSale.setEnabled(true);
						txt4KG.setText("");
						txt10KG.setText("");
						txt16KG.setText("");
						txt20KG.setText("");
						txt50KG.setText("");
						labSum.setText("");
						textSearch.setText("");
						txt4KG.requestFocus();
					} else {

						

						JOptionPane.showMessageDialog(f, "找不到" + textSearch.getText() + "的客戶手機 ?", "客戶資料搜尋",
								                    JOptionPane.ERROR_MESSAGE);
						delSaleInputData();
					
					}

				}

			}

		});

		
		btnDel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				labCustNum.setText("");
				delSaleInputData();
				//btnSale.setEnabled(false);
                
			}
		});
		
		
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			   
				   System.exit(0);
			
			
			}
		});
		
		
		
		/*
		 * textField = new JTextField(); textField.setBounds(287, 337, 166, 20);
		 * panel.add(textField); textField.setColumns(10); Order order=new Order();
		 * textField.setText(order.showDateTime());
		 * 
		 */
	}

	int Search(String s, int rdo) {

		int intCust = 0;

		for (int i = 1; i < customer.length; i++) {

			if (rdo == 1) {

				if (customer[i] != null && customer[i].getName().equals(s)) {
					intCust = i;
					break;
				}
			} else if (rdo == 2) {

				if (customer[i] != null && customer[i].getTel1().equals(s)) {
					intCust = i;
					break;
				}

			} else if (rdo == 3) {

				if (customer[i] != null && customer[i].getTel2().equals(s)) {
					intCust = i;
					break;
				}

			}
		}
		btnSale.setEnabled(true);
		return intCust;

	}

	

	int gas_sum() {

		int sum = 0;
		if (!txt4KG.getText().isBlank()) {

			sum += Integer.parseInt(txt4KG.getText()) * framePricSet.get4kG();

		}

		if (!txt10KG.getText().isBlank() ) {

			sum += Integer.parseInt(txt10KG.getText()) * framePricSet.get10kG();
		}
		if (!txt16KG.getText().isBlank() ) {

			sum += Integer.parseInt(txt16KG.getText()) * framePricSet.get16kG();
		}

		if (!txt20KG.getText().isBlank()) {

			sum += Integer.parseInt(txt20KG.getText()) * framePricSet.get20kG();
		}

		if (!txt50KG.getText().isBlank() ) {

			sum += Integer.parseInt(txt50KG.getText()) * framePricSet.get50kG();
		}

		return sum;
	}

	String order_rec(int sum) {
		//String str4KG, str10KG, str16KG, str20KG, str50KG;
		//str16KG = "%-8s";
		String strFormat = "%-6s";
		String s = "";
		String strMessage = "";
		String strDate = showDateTime();
		
		if(labName.getText().matches("\\W+") )
		{   
			strFormat = "%-6s";
		
		}else {
			
			strFormat = "%-10s";
			
		}
		order[orderID] = new Order();
	
		order[orderID].setStrDateTime(strDate);// 日期時間
		order[orderID].setStrCustName(labName.getText());
		order[orderID].setStrTel1(labTel1.getText());
		order[orderID].setStrTel2(labTel2.getText());
		order[orderID].setNumber(orderID);
		order[orderID].setStrAddress(labAddress.getText());

		if (!txt4KG.getText().isBlank()) {

			order[orderID].setInt4kG(Integer.parseInt(txt4KG.getText()));

		}

		if (!txt10KG.getText().isBlank()) {

			order[orderID].setInt10kG(Integer.parseInt(txt10KG.getText()));
		}
		if (!txt16KG.getText().isBlank()) {

			order[orderID].setInt16kG(Integer.parseInt(txt16KG.getText()));

		} 

		if (!txt20KG.getText().isBlank()) {

			order[orderID].setInt20kG(Integer.parseInt(txt20KG.getText()));
		}

		if (!txt50KG.getText().isBlank()) {

			order[orderID].setInt50KG(Integer.parseInt(txt50KG.getText()));
		}

		order[orderID].setSum(sum);

		orderID++;
		
		
		
		s=String.format("%-8s%-5s%-6s"+strFormat+"%4s%12s",strDate,"",labName.getText(),"",	labSum.getText(),"",":"+ orderID);
		//s = strDate + "     " + labName.getText() + "       " + labSum.getText() + "         " + ":" + orderID;
        //s=String.format("%-8s%-8s%-10s%-2s%-10s%-8s",strDate,"",labName.getText(),"",labSum.getText(),":"+ orderID);
		
        		strMessage = strDate + "\t" + labName.getText() + "\t" + labTel1.getText() + "\t" + labTel2.getText() +
		
				"\t   " + String.format("%-9s%-9s%-9s%-9s%-6s%-6s%-8d", txt4KG.getText(), txt10KG.getText(),
						txt16KG.getText(), txt20KG.getText(), txt50KG.getText(), "", sum)
				+ "\n";
		/*
		 * // "\t "+String.format(str16KG+str16KG+str20KG+str16KG+"%-18s"+"%-20d",
		 * "\t   "+String.format("%-8s%-8s"+str16KG+"%-8s%-14s%-10d",
		 * txt4KG.getText(),txt10KG.getText(), txt16KG.getText(),txt20KG.getText(),
		 * txt50KG.getText(),sum)+"\n";
		 */

		// txt16KG.getText()

		frameSale_details.txtOut.append(strMessage);

		return s;

	}

	String showDateTime() {

		/*
		 * 字串轉 LocalDateTime String str="2026-5-31" DateTimeFormatter
		 * formatter=DateTimeFormatter.ofPattern("y-M-d H:m:s"); LocalDateTime
		 * dateTime=LocalDateTime.parse(str,formatter);
		 *
		 */

		int year;

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		year = calendar.get(calendar.YEAR) - 1911;

		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(year + "-M-d H:mm");
		String strDateTime = dateTime.format(formatter);

		// DateTimeFormatter formatter=DateTimeFormatter.ofPattern("y年M月d日H時m分s秒");
		// DateTimeFormatter formatter=DateTimeFormatter.ofPattern("y-M-d H:m");
		// String strDateTime=dateTime.format(formatter);

		/*
		 * //MinguoDate migroDate=MinguoDate.from(dateTime); //DateTimeFormatter
		 * formatter=DateTimeFormatter.ofPattern("yyy年MM月dd日 HH:mm:ss"); //String
		 * miguoStr=migroDate.format(formatter); //return miguoStr;
		 */

		return strDateTime;
	}

	
	boolean checkQuant() {
   	 
   	 boolean b=false;
   	 if(
   		
   		!txt4KG.getText().isBlank()&&Integer.parseInt(txt4KG.getText())>0||
   		!txt10KG.getText().isBlank()&&Integer.parseInt(txt10KG.getText())>0||
   		!txt16KG.getText().isBlank()&&Integer.parseInt(txt16KG.getText())>0||
   		!txt20KG.getText().isBlank()&&Integer.parseInt(txt20KG.getText())>0||
   	    !txt50KG.getText().isBlank()&&Integer.parseInt(txt50KG.getText())>0)
   	   {
   	    
   		 b=true;
   			 
   	    }	 
   	 
   		 
   	 return b;
    }	
    
void delSaleInputData() {
		
		textSearch.setText("");
		labCustNum.setText("");
		labName.setText("");
		labTel1.setText("");
		labTel2.setText("");
		labAddress.setText("");
		txt4KG.setText("");
		txt10KG.setText("");
		txt16KG.setText("");
		txt20KG.setText("");
		txt50KG.setText("");
		labSum.setText("");
		textSearch.setText("");
		//btnSale.setEnabled(false);

	}
}
