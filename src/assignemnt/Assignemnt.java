package assignemnt;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
import java.io.*;
class Data implements ActionListener
        {
         JFrame fr;
         ImageIcon icon;
         JPanel p;
         JLabel l1,l2,l3;
         Font fnt,fnt1;
         DateTimeFormatter dtf ;
         LocalDateTime now;
         JTextField txtt1,txtt3,txt1,txt2,txt3,txtid,txtvehno;
         String[] options = { "Id Type","Uiversity id", "College id", "Employee id", "Aadhar card", "Driving License","Others"};
         String[] optionare = { "Nationality","Afganistan","Australia","America","Bhutan","Bangladesh","China","Denmark","Egypt","Fizi","Germany","Hungry","India","Japan","Russia"};
         String[] option = { "Vehicle Type","Bike", "Car", "Bus","Ambulance","Others",};
         JComboBox txtt2,cmbid,cmbveh;  
         JTextArea txtarea;
         JButton submit;
         
        
        // TODO code application logic here
         Data(){
         try {
         UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
         } 
         catch (Exception e) 
         {
            e.printStackTrace();
          }        
        fr=new JFrame("Securtiy checkup");
        //fr.setUndecorated(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setResizable(false);
        fr.setSize(900,600);
        fr.setLayout(null);
        fr.setLocationRelativeTo(null);
        
        p=new JPanel();
        p.setBounds(0,0,900,600);
        p.setLayout(null);
        fr.getContentPane().add(p);
        
    
        
        
    
     icon = new ImageIcon(Assignemnt.class.getResource("1.png"));
     
     l1= new JLabel();
     l1.setBounds(400, 20, 100, 100);
     l1.setIcon(icon);
     
     l2=new JLabel("SECURITY CHECKUP");
     l2.setBounds(350,130,200,30);
     fnt=new Font("Lucida Grande", Font.BOLD, 18);
     l2.setFont(fnt);
     
     l3=new JLabel("Data Entry");
     l3.setBounds(400,170,100,25);
     fnt1=new Font("Lucida Grande", Font.BOLD, 15);
     l3.setFont(fnt);
     
     dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
     now = LocalDateTime.now();  
     //System.out.print(dtf.format(now)); 
     
    
     txtt1=new JTextField("Date");
     txtt1.setBounds(38,220,250,45);
     txtt1.setText(dtf.format(now).toString());
     
     
     
     txtt2= new JComboBox(optionare);
     txtt2.setBounds(324,220,250,45);
     
     txtt3=new JTextField("Search");
     txtt3.setBounds(601,220,250,45);   
  
     
     txt1=new JTextField("Visitors ID");
     txt1.setBounds(38,285,250,45);
     
     txt2=new JTextField("Name");
     txt2.setBounds(324,285,250,45);
     
     /*txt2.setPreferredSize(txt2.getPreferredSize());
     txt2.setText("");*/
     
     
     txt3=new JTextField("Mobile No.");
     txt3.setBounds(601,285,250,45);
     
     cmbid= new JComboBox(options);
     cmbid.setBounds(38,350,250,45);
     
     txtid=new JTextField("Id Number");
     txtid.setBounds(324,350,250,45);
     
     txtarea=new JTextArea("Purpose of Visit");
     txtarea.setBounds(601,350,250,110);
    
     cmbveh= new JComboBox(option);
     cmbveh.setBounds(38,415,250,45);
     
     txtvehno=new JTextField("Vehicle No.");
     txtvehno.setBounds(324,415,250,45);
     
     
     
     submit=new JButton("SUBMIT");
     submit.setBounds(324,490,250,55);
     //submit.setBackground(Color.blue);
     
     submit.setBackground(new java.awt.Color(0, 153, 51));
     submit.setOpaque(true);
     submit.setBorderPainted(false);
     submit.setForeground(Color.white);
     
     //cmb.setEditable(true);
     
     
     
        p.add(l1);
        p.add(l2);
        p.add(l3);
       
        
        p.add(txt1);
        p.add(txt2);
        p.add(txt3);
        
        p.add(txtt1);
        p.add(txtt2);
        p.add(txtt3);
        
        p.add(cmbid);
        p.add(txtid);
        p.add(txtarea);
        
        p.add(cmbveh);
        p.add(txtvehno);
        
        p.add(submit);
        submit.addActionListener(this);
        
        fr.setVisible(true);        
    
         }
     public void jTextField1FocusGained(java.awt.event.FocusEvent evt) {                                        
        
        if(txt1.getText().trim().toLowerCase().equals("Vistiors ID")){
            txt1.setText("");
            txt1.setForeground(Color.YELLOW);
        }
        
    }                                       

    public void jTextField1FocusLost(java.awt.event.FocusEvent evt) {                                      
      
        if(txt1.getText().trim().equals("") || txt1.getText().trim().toLowerCase().equals("Vistiors ID")){
            txt1.setText("Vistiors Id");
            txt1.setForeground(new Color(236, 240, 241));
        }
        
    } 
         @Override
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getSource()==submit)
        {
            try{
                File f=new File("Data.txt");
                try (FileWriter fw = new FileWriter(f,true)) {
                    String date=txtt1.getText();
                    fw.append(System.lineSeparator());
                    fw.write(date);
                    fw.write("\t\t");
                    String nationality = (String)txtt2.getSelectedItem();
                    fw.write(nationality);
                    fw.write("\t\t");
                    String vid=txt1.getText();
                    fw.write(vid);
                    fw.write("\t\t");
                    String name=txt2.getText();
                    fw.write(name);
                    fw.write("\t\t     ");
                    String mno=txt3.getText();
                    fw.write(mno);
                    fw.write("\t\t");
                    String idtype = (String)cmbid.getSelectedItem();
                    fw.write(idtype);
                    fw.write("\t\t");
                    String idno=txtid.getText();
                    fw.write(idno);
                    fw.write("\t\t");
                    String vehtype = (String)cmbveh.getSelectedItem();
                    fw.write(vehtype);
                    fw.write("\t\t");
                    String vehno = txtvehno.getText();
                    fw.write(vehno);
                    fw.write("\t\t");
                    String purpose = txtarea.getText();
                    fw.write(purpose);
                    JOptionPane.showMessageDialog(null,"Data Succesfully Saved");
                }                
            }
            catch(HeadlessException | IOException E)
            {
                
            }
        }
        
    }
    
}
public class Assignemnt {
    public static void main(String[] args) 
    {
        Data obj=new Data();
    }
}