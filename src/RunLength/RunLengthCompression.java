
package RunLength;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;


public class RunLengthCompression extends javax.swing.JFrame {

    
    static String word;
      StringBuilder build=new StringBuilder();
   
        
    public RunLengthCompression(String word) {
        initComponents();
        jTextField1.setEnabled(false);
        this.word=word;
        Compression();
        
    }
    
    
    public void Compression(){
        
      
   
        int i=0;
        int count=0;
        int temp=0;
        while (i<word.length()) {
          count=1;    
            for(int k=i+1;k<word.length() && word.charAt(i)==word.charAt(k);k++){          
                    count++;
               }
           
            temp=count;
           

            build.append(word.charAt(i));
            build.append(temp);
            i+=count;
        }
        
        System.out.println(word.length()+"");
        
     }
  
    public void paint(Graphics g){
        g.drawString(build.toString(), getWidth()/2, getHeight()/2);
        //write in file
        
        
        try {
            FileWriter fw=new FileWriter("D:\\MultiMedia_Project_1\\RunLength.txt");
            BufferedWriter bfw=new BufferedWriter(fw);
            bfw.write(build.toString());
            bfw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(RunLengthCompression.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Decompress");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(255, 204, 255));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.setText("Result");

        jButton2.setBackground(new java.awt.Color(255, 204, 204));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("compressionRatio");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(260, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String line="";
        String text="";
        try {
            // TODO add your handling code here:
            FileReader fr=new FileReader("D:\\MultiMedia_Project_1\\RunLength.txt");
            BufferedReader bfr=new BufferedReader(fr);
             line =bfr.readLine();
            bfr.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RunLengthCompression.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RunLengthCompression.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=1;i<line.length();i+=2){
            int count=Integer.parseInt(String.valueOf(line.charAt(i)));
            for(int j=1;j<=count;j++){
                text+=line.charAt(i-1);
            }
        }
        new RunLengthDecompression(text).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        String line="";
        String text="";
        try {
            // TODO add your handling code here:
            FileReader fr=new FileReader("D:\\MultiMedia_Project_1\\RunLength.txt");
            BufferedReader bfr=new BufferedReader(fr);
            line =bfr.readLine();
            bfr.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RunLengthCompression.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RunLengthCompression.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=1;i<line.length();i+=2){
            int count=Integer.parseInt(String.valueOf(line.charAt(i)));
            for(int j=1;j<=count;j++){
                text+=line.charAt(i-1);
            }
        }
           System.out.println("line"+line.length()+"");
        double t=(double)((((word.length()*8)-(double)(line.length()))/(double)word.length())*100);
        jTextField1.setText(t+"");
        System.out.println(t);
    }//GEN-LAST:event_jButton2ActionPerformed

    // 
    
     
    
    
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
            java.util.logging.Logger.getLogger(RunLengthCompression.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RunLengthCompression.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RunLengthCompression.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RunLengthCompression.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RunLengthCompression(word).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
