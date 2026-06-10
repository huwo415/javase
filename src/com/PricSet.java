package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PricSet extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtkg;
	private JTextField txtkg_1;
	private JTextField txtkg_2;
	private JTextField txtkg_3;
	private JTextField txtkg_4;
	private JTextField txt4KG;
	private JTextField txt10KG;
	private JTextField txt16KG;
	private JTextField txt20KG;
	private JTextField txt50KG;
	private JTextField textField_10;
	private JButton btnExit;
	private PricSet framePricSet;
	private int int4kG=260;//260
	private int int10kG=400;//400
	private int int16kG=700;//700
	private int int20kG=850;//850
	private int int50KG=2000;  
	private JButton btnCancel;
	private JButton btnEdit;
	
	
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public PricSet() {
		
		
		framePricSet=this;
		
		 
		
		setTitle("瓦斯價格設定");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 679, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(128, 255, 255));
		panel.setBounds(0, 10, 647, 418);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtkg = new JTextField();
		txtkg.setFont(new Font("微软雅黑 Light", Font.BOLD, 16));
		txtkg.setText("4KG");
		txtkg.setBackground(new Color(255, 255, 255));
		txtkg.setHorizontalAlignment(SwingConstants.CENTER);
		txtkg.setForeground(new Color(0, 0, 255));
		txtkg.setBounds(189, 171, 55, 32);
		panel.add(txtkg);
		txtkg.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("瓦斯價格設定");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("微软雅黑 Light", Font.BOLD, 18));
		lblNewLabel.setBounds(253, 97, 153, 32);
		panel.add(lblNewLabel);
		
		txtkg_1 = new JTextField();
		txtkg_1.setBackground(new Color(255, 255, 255));
		txtkg_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 16));
		txtkg_1.setText("10KG");
		txtkg_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtkg_1.setForeground(new Color(0, 0, 255));
		txtkg_1.setColumns(10);
		txtkg_1.setBounds(243, 171, 55, 32);
		panel.add(txtkg_1);
		
		txtkg_2 = new JTextField();
		txtkg_2.setBackground(new Color(255, 255, 255));
		txtkg_2.setText("16KG");
		txtkg_2.setFont(new Font("微软雅黑 Light", Font.BOLD, 16));
		txtkg_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtkg_2.setForeground(new Color(0, 0, 255));
		txtkg_2.setColumns(10);
		txtkg_2.setBounds(297, 171, 55, 32);
		panel.add(txtkg_2);
		
		txtkg_3 = new JTextField();
		txtkg_3.setBackground(new Color(255, 255, 255));
		txtkg_3.setText("20KG");
		txtkg_3.setFont(new Font("微软雅黑 Light", Font.BOLD, 16));
		txtkg_3.setHorizontalAlignment(SwingConstants.CENTER);
		txtkg_3.setForeground(new Color(0, 0, 255));
		txtkg_3.setColumns(10);
		txtkg_3.setBounds(351, 171, 55, 32);
		panel.add(txtkg_3);
		
		txtkg_4 = new JTextField();
		txtkg_4.setBackground(new Color(255, 255, 255));
		txtkg_4.setText("50KG");
		txtkg_4.setFont(new Font("微软雅黑 Light", Font.BOLD, 16));
		txtkg_4.setHorizontalAlignment(SwingConstants.CENTER);
		txtkg_4.setForeground(new Color(0, 0, 255));
		txtkg_4.setColumns(10);
		txtkg_4.setBounds(405, 171, 55, 32);
		panel.add(txtkg_4);
		
		txt4KG = new JTextField();
		txt4KG.setEnabled(false);
		txt4KG.setFont(new Font("微软雅黑 Light", Font.BOLD, 16));
		txt4KG.setText("260");
		txt4KG.setHorizontalAlignment(SwingConstants.CENTER);
		txt4KG.setForeground(new Color(0, 0, 255));
		txt4KG.setColumns(10);
		txt4KG.setBounds(189, 202, 55, 32);
		panel.add(txt4KG);
		
		txt10KG = new JTextField();
		txt10KG.setEnabled(false);
		txt10KG.setText("400");
		txt10KG.setFont(new Font("微软雅黑 Light", Font.BOLD, 16));
		txt10KG.setHorizontalAlignment(SwingConstants.CENTER);
		txt10KG.setForeground(new Color(0, 0, 255));
		txt10KG.setColumns(10);
		txt10KG.setBounds(243, 202, 55, 32);
		panel.add(txt10KG);
		
		txt16KG = new JTextField();
		txt16KG.setEnabled(false);
		txt16KG.setText("700");
		txt16KG.setFont(new Font("微软雅黑 Light", Font.BOLD, 16));
		txt16KG.setHorizontalAlignment(SwingConstants.CENTER);
		txt16KG.setForeground(new Color(0, 0, 255));
		txt16KG.setColumns(10);
		txt16KG.setBounds(297, 202, 55, 32);
		panel.add(txt16KG);
		
		txt20KG = new JTextField();
		txt20KG.setEnabled(false);
		txt20KG.setText("850");
		txt20KG.setFont(new Font("微软雅黑 Light", Font.BOLD, 16));
		txt20KG.setHorizontalAlignment(SwingConstants.CENTER);
		txt20KG.setForeground(new Color(0, 0, 255));
		txt20KG.setColumns(10);
		txt20KG.setBounds(351, 202, 55, 32);
		panel.add(txt20KG);
		
		txt50KG = new JTextField();
		txt50KG.setEnabled(false);
		txt50KG.setText("2000");
		txt50KG.setFont(new Font("微软雅黑 Light", Font.BOLD, 16));
		txt50KG.setHorizontalAlignment(SwingConstants.CENTER);
		txt50KG.setForeground(new Color(0, 0, 255));
		txt50KG.setColumns(10);
		txt50KG.setBounds(405, 202, 55, 32);
		panel.add(txt50KG);
		
		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setText("瓦斯每桶價格");
		textField_10.setFont(new Font("微软雅黑 Light", Font.BOLD, 16));
		textField_10.setForeground(new Color(0, 0, 255));
		textField_10.setBackground(new Color(255, 255, 255));
		textField_10.setBounds(189, 139, 272, 32);
		panel.add(textField_10);
		textField_10.setColumns(10);
		
		
		
	//===============================even======================================	
		
		JButton btnOK = new JButton("確定");
		btnOK.setEnabled(false);
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				 
			
			}});
		
		btnOK.setForeground(new Color(0, 0, 255));
		btnOK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    

				 btnEdit.setEnabled(true);
				 btnOK.setEnabled(false);
				 btnCancel.setEnabled(false);
				 
				 int4kG=Integer.parseInt(txt4KG.getText());
			     int10kG=Integer.parseInt(txt10KG.getText());
				 int16kG=Integer.parseInt(txt16KG.getText());
				 int20kG=Integer.parseInt(txt20KG.getText());
			     int50KG=Integer.parseInt(txt50KG.getText());
			     
			     txt4KG.setEnabled(false);
				 txt10KG.setEnabled(false);
				 txt16KG.setEnabled(false);
				 txt20KG.setEnabled(false);
				 txt50KG.setEnabled(false);
		 	
			
			}
		});
		
		btnOK.setBounds(395, 260, 76, 32);
		panel.add(btnOK);
		
		btnEdit = new JButton("修改");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txt4KG.setEnabled(true);
				txt10KG.setEnabled(true);
				txt16KG.setEnabled(true);
				txt20KG.setEnabled(true);
				txt50KG.setEnabled(true);
				
				
				btnEdit.setEnabled(false);
				btnOK.setEnabled(true);
				btnCancel.setEnabled(true);
				
				//txt50KG.getText();
				
			
			}
		});
		
		btnCancel = new JButton("取消");
		btnCancel.setEnabled(false);
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				btnEdit.setEnabled(true);
				btnOK.setEnabled(false);
				btnCancel.setEnabled(false);
				
				txt4KG.setText(""+ int4kG);
				txt10KG.setText(""+ int10kG);
			    txt16KG.setText(""+ int16kG);
				txt20KG.setText(""+ int20kG);
			    txt50KG.setText(""+ int50KG);
			
			}
		});
		btnCancel.setForeground(Color.BLUE);
		btnCancel.setBounds(321, 260, 76, 32);
		panel.add(btnCancel);
		
		
		
		
		
		btnEdit.setForeground(Color.BLUE);
		btnEdit.setBounds(251, 260, 76, 32);
		panel.add(btnEdit);
		
		
		btnExit = new JButton("離開");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				framePricSet.setVisible(false);
			
			}
		});
		
		btnExit.setForeground(new Color(0, 0, 255));
		btnExit.setBounds(184, 260, 76, 32);
		panel.add(btnExit);
		
		JButton btnNewButton = new JButton("離開");
		btnNewButton.setBounds(571, 428, 84, 32);
		contentPane.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				framePricSet.setVisible(false);
			
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 255));
		
		
		
		 txt4KG.requestFocusInWindow();
	
	}

    public int get4kG() {
   
      return int4kG;
    }	
    
    public int get10kG() {
    	   
		return int10kG;
    }		
    
    public int get16kG() {
 	   
		return int16kG;
    }		
    
    public int get20kG() {
 	   
		return int20kG;
    }		
    
    public int get50kG() {
 	   
		return int50KG;
    }		
}
