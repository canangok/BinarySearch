package ikiliArama;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue; 


public class ikiliArama extends JFrame{

	 JFrame pencere;
	 JLabel label;
	 JLabel uyari;
	 JLabel [] labeller;
	 JTextField diziboyut;
	 JTextField [] textDizisi;
	 JButton buton1,buton2;
	 JButton [] butonDizisi;
	 JTextField aranan;
	public ikiliArama(){
	     odevim();
           }
         private void odevim(){
        	 pencere=new JFrame();
        	 pencere.setLayout(null);
     		 pencere.setTitle("Ýkili Arama");
     		 pencere.setSize(10000,10000);   
     		 
     		 pencere.setVisible(true);
    		 pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		 pencere.setBackground(Color.blue);
    		
    		 label=new JLabel("Dizi boyutunu giriniz:");
    		 label.setBounds(0, 0, 120, 40);
    		 pencere.add(label);
    		 
    		 uyari=new JLabel(" ");
    		 uyari.setBounds(600, 10, 200, 40);
    		 pencere.add(uyari);
    		 
    		 diziboyut=new JTextField();
    		 diziboyut.setBounds(120, 10, 80, 20);
    		 pencere.add(diziboyut);
    		 
    		 buton1=new JButton("Dizi boyutunu belirle");
    		 buton1.setBounds(205, 10, 160, 20);
    		 pencere.add(buton1);
    		 
    		 buton2=new JButton("Sayýlarý Belirle");
    		 buton2.setBounds(370, 10, 120, 20);
    		 pencere.add(buton2);
    		
    		
    		 buton1.addActionListener(new ActionListener(){
    			 
    			 public void actionPerformed(ActionEvent e)
    			 {
    				 	buton1.setEnabled(false);
    				    JLabel label;
    					JTextField sayi;
    					
    					textDizisi = new JTextField[Integer.parseInt(diziboyut.getText().toString())];
    					
    					int x1=10,y1=50,w1=120,h1=30;
    					int x3=107,y3=55,w3=40,h3=20;
    					for(int j=0;j<textDizisi.length;j++){
    						label=new JLabel();
    						label.setBounds(x1, y1, w1, h1);
    						label.setText((j+1)+" .Sayýyý giriniz:");
    						pencere.getContentPane().add(label);
    						y1=y1+h1+1;
    						
    						
    						sayi=new JTextField();
    						sayi.setBounds(x3, y3,w3, h3);
    						textDizisi[j]=sayi;
    						//textDizisi[j].setText(Integer.toString(j)); // 
    						pencere.getContentPane().add(sayi);
    						y3=y3+h3+11;
    						pencere.revalidate();
    						pencere.repaint();
    			 }
    				
    			 }
    		 });
    		
    		 buton2.addActionListener(new ActionListener(){
    			 public void actionPerformed(ActionEvent e)
    			 {
    				 JLabel label1;
    				 buton2.setEnabled(false);
    				 JButton butonlar;
    				 final JButton buton3;
    				
    					
    					butonDizisi= new JButton[Integer.parseInt(diziboyut.getText().toString())];
    					
    					int x3=100,y3=55,w3=40,h3=20;
    					int x2=270,y2=200,w2=70,h2=45;
    					int x1=10,y1=50,w1=120,h1=30;
    					int deger=0;
    					
    					for(int i=0;i<butonDizisi.length;i++){
    						
    						y1=y1+36;
							y3=36+y3;
    						
    				        butonlar = new JButton();
    						butonlar.setBounds(x2,y2,w2,h2);
    						butonlar.setText(""+textDizisi[i]);
    						butonDizisi[i]=butonlar;
    						pencere.getContentPane().add(butonlar);
    						x2=x2+w2+10;
    						pencere.revalidate();
    						pencere.repaint();
    					
    			 
    					
							deger = Integer.parseInt(textDizisi[i].getText().toString());
							butonDizisi[i].setText(Integer.toString(deger));
							
							
    					}
						
    					label1=new JLabel();
        				label1.setBounds(x1, y1, 170, h1);
        				label1.setText("Aranacak sayýyý giriniz:");
        				pencere.add(label1);
        				
        				
        				aranan=new JTextField();
        				aranan.setBounds(145, y3, w3, h3);    
        				pencere.add(aranan);
        				
        				buton3=new JButton();
        				buton3.setBounds(189, y3, 65, h3);
        				buton3.setText("Ýlerle");
        				pencere.add(buton3);
        				
        				buton3.addActionListener(new ActionListener(){
        				
        					int diziBoyut=Integer.parseInt(diziboyut.getText().toString());
        					int bas=0;
        					int son=diziBoyut-1;
        					 public void actionPerformed(ActionEvent e)
        					 {
        							
         						
         						int aranansayi=Integer.parseInt(aranan.getText().toString());
         						
         						int orta=(bas+son)/2;
         						int ortadakisayi=Integer.parseInt(butonDizisi[orta].getText());
         						
         						if(aranansayi==ortadakisayi){
         							for(int i=0;i<diziBoyut;i++){
         								butonDizisi[i].setBackground(Color.red);
         								if(butonDizisi[i]==butonDizisi[orta]){
         									butonDizisi[orta].setBackground(Color.cyan);
         								}
         							}      							
         							buton3.setEnabled(false);
         						}
         						else if(ortadakisayi>aranansayi){
         							for(int i=orta;i<diziBoyut;i++){
         								butonDizisi[i].setBackground(Color.red);
         							}
         							son=orta-1;
         							if(bas>son){
         								buton3.setEnabled(false);
         								uyari.setText("Aranan sayý dizide bulunamadý");
         							}
         						}
         						else{//ortadakisayi<aranansayi
         							for(int i=orta;i>=bas;i--){
         								butonDizisi[i].setBackground(Color.red);
         							}
         							bas=orta+1;
         							if(bas>son){
         								buton3.setEnabled(false);
         								uyari.setText("Aranan sayý dizide bulunamadý");
         							}
         						}
         							
         							
         						pencere.revalidate();
         						pencere.repaint();
        					 }
        					 
        				});				
        					
    					
    			 }
    			 
  		 
    		 });
    		 
	 
         }
    }
