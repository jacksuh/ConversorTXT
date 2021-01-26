package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.TextArea;

public class ViewGerarPDF extends JFrame {
	
	File file;

	private JPanel contentPane;
	private JTextField Text1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewGerarPDF frame = new ViewGerarPDF();
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
	public ViewGerarPDF() {
		setResizable(false);
		setBackground(Color.GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewGerarPDF.class.getResource("/images/PDFg.png")));
		setFont(null);
		setTitle("GerarPDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 321);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton jButton1 = new JButton("Gerar");
		jButton1.setForeground(Color.ORANGE);
		jButton1.setBackground(Color.BLACK);
		jButton1.setIcon(new ImageIcon(ViewGerarPDF.class.getResource("/images/icon-pdf.png")));
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
				
				try 
				  { 
				   FileReader reader = new FileReader(new File(Text1.getText().trim()));
				   BufferedReader leitor = new BufferedReader(reader);
				   
				   //criação do pdf                         //  (Es, Dir,Sup,Inf)
				   Document document = new Document(PageSize.A4, 10, 10, 10, 10);
				   PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Public\\novo.pdf"));
				   
				   document.open(); 
				   
				   //Ler txt linha a linha 
				   while(leitor.ready())
				    document.add(new Paragraph(leitor.readLine()));
				       
				   leitor.close(); 
				   document.close(); 
				   Desktop.getDesktop().open(new File("C:\\Users\\Public\\novo.pdf"));
				  } catch (Exception ex) 
				  {
				   ex.printStackTrace();
				   
				  } 
					
			}
		});
		jButton1.setBounds(151, 125, 141, 55);
		contentPane.add(jButton1);
		
		Text1 = new JTextField();
		Text1.setBounds(56, 53, 211, 20);
		contentPane.add(Text1);
		Text1.setColumns(10);
		
		JButton btnArquivo = new JButton("Arquivo");
		btnArquivo.setBackground(Color.BLACK);
		btnArquivo.setForeground(Color.ORANGE);
		btnArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser filechooser = new JFileChooser();
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Selecionar Arquvio","txt");
				
				filechooser.setFileFilter(filter);
				
				int retorno = filechooser.showOpenDialog(null);
				
				if (retorno == JFileChooser.APPROVE_OPTION) {
					
					File file = filechooser.getSelectedFile();
					Text1.setText(file.toString().trim());
					
				
				}
			}
		});
		btnArquivo.setBounds(277, 52, 89, 23);
		contentPane.add(btnArquivo);
		
		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setText("Gerador de PDF.\r\nPrecisa ter Instalado o Adobe\r\nApos abrir o pdf salvar o arquivo onde desejar. :)\r\nCaminho onde salva o pdf \r\nC:\\Users\\Public\\novo.pdf");
		textArea.setBounds(203, 186, 276, 96);
		contentPane.add(textArea);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(56, 84, 211, 20);
		contentPane.add(textField);
		
		JButton button = new JButton("Arquivo");
		button.setForeground(Color.ORANGE);
		button.setBackground(Color.BLACK);
		button.setBounds(277, 86, 89, 23);
		contentPane.add(button);
	}
}
