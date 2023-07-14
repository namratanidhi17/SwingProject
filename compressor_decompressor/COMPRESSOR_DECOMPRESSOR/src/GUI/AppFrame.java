package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;

    AppFrame(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("COMPRESSOR DECOMPRESSOR");
        this.setSize(1400, 700);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setVisible(true);
       
        compressButton = new JButton("Select file to compress");
        compressButton.setSize(220,50);
        compressButton.setLocation(390,150);
        compressButton.addActionListener(this);

        decompressButton = new JButton("Select file to decompress");
        decompressButton.setSize(220,50);
        decompressButton.setLocation(740,150);
        decompressButton.addActionListener(this);

        this.add(compressButton);
        this.add(decompressButton);

        Font font = new Font("Arial", Font.BOLD, 14);
        compressButton.setFont(font);
        decompressButton.setFont(font);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compressButton){
            JFileChooser filechooser  = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    compressor.method(file);
                    JOptionPane.showMessageDialog(null, "Successfully Compressed", "Message", JOptionPane.INFORMATION_MESSAGE);
                }
                catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString(), "Warning Message", JOptionPane.WARNING_MESSAGE);
                }

            }
        }

        if(e.getSource()==decompressButton){
            JFileChooser filechooser  = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    decompressor.method(file);
                    JOptionPane.showMessageDialog(null, "Successfully Decompressed", "Message", JOptionPane.INFORMATION_MESSAGE);
                }
                catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString(), "Warning Message", JOptionPane.WARNING_MESSAGE);
                }

            }
        }
    }
}
