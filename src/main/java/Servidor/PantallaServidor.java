/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Servidor;


import cazadeltesoro.Casilla;
import java.awt.Color;
import java.util.Random;
import javax.swing.JButton;

/**
 *
 * @author diego
 */
public class PantallaServidor extends javax.swing.JFrame {
    Servidor server;
    public static int FILAS = 15;
    public static int COLUMNAS = 15;
    public static int DIMENSION = 25;
    Casilla[][] casillas = new Casilla[FILAS][COLUMNAS];
    JButton[][] tableroBtns = new JButton[FILAS][COLUMNAS];
    private final double AMENAZAS = 22;
    private final double TESOROS = 22;
    private final double MERCADOS = 22;

    /**
     * Creates new form PantallaServidor
     */
    public PantallaServidor() {
        initComponents();
        server = new Servidor(this);
         for(int i=0;i<FILAS;i++)
        {
            for(int j=0;j<COLUMNAS;j++)
            {
                // coloca imagen a todos vacio
                tableroBtns[i][j] = new JButton("");
                casillas[i][j] = new Casilla();
                
                //añade al panel el boton;
                pnlTablero.add(tableroBtns[i][j]);
                // coloca dimensiones y localidad
                tableroBtns[i][j].setBounds(25+DIMENSION*i, 0+DIMENSION*j, DIMENSION, DIMENSION);
                
                
            }
        }
        colocarAmenazas();
        colocarMercados();
        colocarTesoros();
    }
    
    private void colocarAmenazas() {
        Random rand = new Random();
        int colocadas = 0;
        
        while (colocadas < AMENAZAS) {
            int i = rand.nextInt(FILAS);
            int j = rand.nextInt(COLUMNAS);

            if (!casillas[i][j].isTieneTesoro() && !casillas[i][j].isTieneMercado() && !casillas[i][j].isTieneAmenaza()) {
                casillas[i][j].setTieneAmenaza(true);
                tableroBtns[i][j].setBackground(Color.RED);
                colocadas++;
            }
        }
    }
    
    private void colocarMercados() {
        Random rand = new Random();
        int colocadas = 0;
        
        while (colocadas < MERCADOS) {
            int i = rand.nextInt(FILAS);
            int j = rand.nextInt(COLUMNAS);

            if (!casillas[i][j].isTieneTesoro() && !casillas[i][j].isTieneMercado() && !casillas[i][j].isTieneAmenaza()) {
                casillas[i][j].setTieneMercado(true);
                tableroBtns[i][j].setBackground(Color.GREEN);
                colocadas++;
            }
        }
    }
    
    private void colocarTesoros() {
        Random rand = new Random();
        int colocadas = 0;
        
        while (colocadas < TESOROS) {
            int i = rand.nextInt(FILAS);
            int j = rand.nextInt(COLUMNAS);

            if (!casillas[i][j].isTieneTesoro() && !casillas[i][j].isTieneMercado() && !casillas[i][j].isTieneAmenaza()) {
                casillas[i][j].setTieneTesoro(true);
                tableroBtns[i][j].setBackground(Color.YELLOW);
                colocadas++;
            }
        }
    }
    
    public void write(String text){
        this.jTextArea1.append(text + "\n");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        pnlTablero = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout pnlTableroLayout = new javax.swing.GroupLayout(pnlTablero);
        pnlTablero.setLayout(pnlTableroLayout);
        pnlTableroLayout.setHorizontalGroup(
            pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );
        pnlTableroLayout.setVerticalGroup(
            pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(pnlTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PantallaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaServidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel pnlTablero;
    // End of variables declaration//GEN-END:variables
}
