package examenbacalaureat;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author catal
 */
public class LoginFrame extends javax.swing.JFrame {

    CreareContFrame cont;
    OptiuneElevFrame optiune;
    AdminFrame admin;
    RezultateFrame rezultate;
    public static String cnp;
    

    public LoginFrame() {
        initComponents();
        Connection connection = null;
        OracleConnection.openConnection(connection);
        OracleConnection.closeConnection(connection);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        contUtilizatorPasswordField = new javax.swing.JPasswordField();
        contUtilizatorTextField = new javax.swing.JTextField();
        rezultateButton = new javax.swing.JButton();
        accesLoginButton = new javax.swing.JButton();
        photoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        creareContButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Window");

        mainPanel.setBackground(new java.awt.Color(204, 51, 255));
        mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rezultate Bacalaureat", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 18), new java.awt.Color(255, 255, 51))); // NOI18N
        mainPanel.setMaximumSize(new java.awt.Dimension(250, 300));
        mainPanel.setMinimumSize(new java.awt.Dimension(250, 300));

        contUtilizatorPasswordField.setBackground(new java.awt.Color(255, 204, 204));
        contUtilizatorPasswordField.setText("parola");
        contUtilizatorPasswordField.setToolTipText("Conecteaza-te intoducand parola");

        contUtilizatorTextField.setBackground(new java.awt.Color(255, 204, 204));
        contUtilizatorTextField.setText("Utilizator");
        contUtilizatorTextField.setToolTipText("Conecteaza-te intoducand username ");

        rezultateButton.setBackground(new java.awt.Color(255, 255, 102));
        rezultateButton.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        rezultateButton.setText("Rezultate");
        rezultateButton.setBorder(null);
        rezultateButton.setMaximumSize(new java.awt.Dimension(109, 27));
        rezultateButton.setMinimumSize(new java.awt.Dimension(109, 27));
        rezultateButton.setPreferredSize(new java.awt.Dimension(109, 27));
        rezultateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rezultateButtonMousePressed(evt);
            }
        });

        accesLoginButton.setBackground(new java.awt.Color(0, 255, 255));
        accesLoginButton.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        accesLoginButton.setText("Acces");
        accesLoginButton.setBorder(null);
        accesLoginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                accesLoginButtonMousePressed(evt);
            }
        });

        photoPanel.setBackground(new java.awt.Color(255, 102, 255));
        photoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bine ati venit!", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Vivaldi", 2, 24), new java.awt.Color(153, 255, 255)))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/examenbacalaureat/image/Untitled.png"))); // NOI18N

        javax.swing.GroupLayout photoPanelLayout = new javax.swing.GroupLayout(photoPanel);
        photoPanel.setLayout(photoPanelLayout);
        photoPanelLayout.setHorizontalGroup(
            photoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, photoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        photoPanelLayout.setVerticalGroup(
            photoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(photoPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        creareContButton.setBackground(new java.awt.Color(153, 255, 153));
        creareContButton.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        creareContButton.setText("Creare cont");
        creareContButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                creareContButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addComponent(photoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(contUtilizatorTextField)
                                .addComponent(accesLoginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                            .addComponent(contUtilizatorPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rezultateButton, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(creareContButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(photoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(contUtilizatorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contUtilizatorPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(accesLoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rezultateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(creareContButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void creareContButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_creareContButtonMousePressed
        cont = new CreareContFrame();
        this.setVisible(false);
        cont.setVisible(true);
    }//GEN-LAST:event_creareContButtonMousePressed

    private void accesLoginButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accesLoginButtonMousePressed
        String username = contUtilizatorTextField.getText();
        String parola = String.copyValueOf(contUtilizatorPasswordField.getPassword());

        String rezultat;
        try{
        rezultat = OracleConnection.selectFunctieFromUsers(username, parola);
        if ("elev".equals(rezultat)) {
            
            cnp = OracleConnection.selectCNPFromUsers(username,parola).get(0);
            optiune = new OptiuneElevFrame();
            this.setVisible(false);
            optiune.setVisible(true);
        } else if ("admin".equals(rezultat)) {
            admin = new AdminFrame();
            this.setVisible(false);
            admin.setVisible(true);
        }
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println(username+" "+parola+" nu este un cont din baza de date!");
        }
    }//GEN-LAST:event_accesLoginButtonMousePressed

    private void rezultateButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rezultateButtonMousePressed
        rezultate = new RezultateFrame();
        this.setVisible(false);
        rezultate.setVisible(true);
    }//GEN-LAST:event_rezultateButtonMousePressed

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accesLoginButton;
    private javax.swing.JPasswordField contUtilizatorPasswordField;
    private javax.swing.JTextField contUtilizatorTextField;
    private javax.swing.JButton creareContButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel photoPanel;
    private javax.swing.JButton rezultateButton;
    // End of variables declaration//GEN-END:variables
}
