
package multimediaproject.Huffman;

import LZW.LZWCompress;
import LZW.LZWDecompress;
import RunLength.RunLengthCompression;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static multimediaproject.Huffman.Huffman.Letters;
import static multimediaproject.Huffman.Huffman.list;
import static multimediaproject.Huffman.Huffman.word;


public class CodesTable extends javax.swing.JFrame {

    String line="";
    static int i=0;
    static ArrayList<String> codes=new ArrayList<>();
    public ArrayList<String> CodeWord=new ArrayList<>();
    public static ArrayList<String> TextCode=new ArrayList<>();
      DefaultTableModel model;
    public CodesTable() {
        initComponents();
        model= (DefaultTableModel)jTable1.getModel();
        for(int i=0;i<Letters.size();i++){
            boolean found=false;
            CodeWord.add(Letters.get(i));
            found=searchRight(Letters.get(i), list.get(0).right);
            if(!found){
                codes.removeAll(codes);
            searchLeft(Letters.get(i), list.get(0).left);
            }
        }
        line="";
        for(int i=0;i<word.length();i++){
            for(int j=0;j<TextCode.size();j+=2){
                if(String.valueOf(word.charAt(i)).equals(TextCode.get(j))){
                  line+=TextCode.get(j+1);
                  break;
                }
            }
        }
        
            try {
            FileWriter fw=new FileWriter("D:\\MultiMedia_Project_1\\Huffman.txt");
            BufferedWriter bfw=new BufferedWriter(fw);
            bfw.write(line);
            bfw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(CodesTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean searchLeft(String letter,HuffmanNode node){
        boolean found=false;
        if(letter.equals(node.letter)){
            codes.add(node.c);
              printTable();
              found =true;
                return found;
            }else{
            if(node.right!=null){
                if(node.c!=null){
                codes.add(node.c);
                }
            found = searchRight(letter, node.right);
            }
             if(node.left!=null && !found){
//                 if(codes.size()>0)
//                 codes.remove(codes.size()-1);
                if(node.c!=null){
                codes.add(node.c);
                }
               found= searchLeft(letter, node.left);
            }

        }
        if(codes.size()>0)
        codes.remove(codes.size()-1);
        return found;
    }
    
    public boolean searchRight(String letter,HuffmanNode node){
       
        boolean found=false;
        if(letter.equals(node.letter)){
            codes.add(node.c);
              printTable();
              found=true;
                return found;
            }else{
            if(node.right!=null){
                if(node.c!=null){
                codes.add(node.c);
                }
                found = searchRight(letter, node.right);
            }
             if(node.left!=null && !found){
//                 if(codes.size()>0)
//                 codes.remove(codes.size()-1);
                if(node.c!=null){
                codes.add(node.c);
                }
             found =  searchLeft(letter, node.left);
            }
        }
        if(codes.size()>0)
        codes.remove(codes.size()-1);
        return found;
    }
    
    
    
    private void printTable() {
      
        Object [] row ={Letters.get(i),codes.toString()};
           model.addRow(row);  
           line="";
           for(int i=0;i<codes.size();i++){
            line+=codes.get(i);
        }
           TextCode.add(Letters.get(i));
           TextCode.add(line);
           i++;
           CodeWord.add(codes.toString());
           codes.removeAll(codes);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setBackground(new java.awt.Color(255, 204, 255));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Letter", "Code"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Decompression");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 204, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Compression Ratio");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(204, 204, 255));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.setText("Result");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(66, 66, 66)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)))
                        .addGap(9, 9, 9)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String line="";
        String text="";
        try {
            // TODO add your handling code here:
            FileReader fr=new FileReader("D:\\MultiMedia_Project_1\\Huffman.txt");
            BufferedReader bfr=new BufferedReader(fr);
             line =bfr.readLine();
            bfr.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CodesTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CodesTable.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        new HuffmanDecompression(line).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
        
         String line="";
        String text="";
        try {
            // TODO add your handling code here:
            FileReader fr=new FileReader("D:\\MultiMedia_Project_1\\Huffman.txt");
            BufferedReader bfr=new BufferedReader(fr);
             line =bfr.readLine();
            bfr.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CodesTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CodesTable.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        double t=(double)((((word.length()*8)-(double)(line.length()))/(double)word.length())*100);
        jTextField1.setText(t+"");
        System.out.println("humm"+t);
        
       
        
    }//GEN-LAST:event_jButton2ActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CodesTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
