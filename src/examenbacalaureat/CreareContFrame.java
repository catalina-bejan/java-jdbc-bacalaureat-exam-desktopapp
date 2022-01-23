package examenbacalaureat;

import java.awt.Color;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author catal
 */
public class CreareContFrame extends javax.swing.JFrame {

    LoginFrame login;

    public CreareContFrame() {
        initComponents();
        Connection connection = null;
        OracleConnection.openConnection(connection);
        OracleConnection.closeConnection(connection);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        numeTextField = new javax.swing.JTextField();
        numeLabel = new javax.swing.JLabel();
        prenumeTextField = new javax.swing.JTextField();
        prenumeLabel = new javax.swing.JLabel();
        parolaPasswordField = new javax.swing.JPasswordField();
        passwordLabel = new javax.swing.JLabel();
        creeazaContButton = new javax.swing.JButton();
        statusContLabel = new javax.swing.JLabel();
        cnpLabel = new javax.swing.JLabel();
        cnpTextField = new javax.swing.JTextField();
        usernameContLabel = new javax.swing.JLabel();
        backToLoginButton = new javax.swing.JButton();
        pierdutParolaLabel = new javax.swing.JLabel();
        pierdutParolaLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Creare cont");

        jPanel1.setBackground(new java.awt.Color(204, 51, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Creare Cont", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 18), new java.awt.Color(255, 255, 0))); // NOI18N

        numeLabel.setForeground(new java.awt.Color(255, 255, 0));
        numeLabel.setText("Nume:");

        prenumeLabel.setForeground(new java.awt.Color(255, 255, 0));
        prenumeLabel.setText("Prenume:");

        passwordLabel.setForeground(new java.awt.Color(255, 255, 0));
        passwordLabel.setText("Parola:");

        creeazaContButton.setBackground(new java.awt.Color(51, 255, 255));
        creeazaContButton.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        creeazaContButton.setText("Creează Cont");
        creeazaContButton.setToolTipText("Apasa acest buton pentru a crea contul elevului");
        creeazaContButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                creeazaContButtonMousePressed(evt);
            }
        });

        statusContLabel.setBackground(new java.awt.Color(255, 255, 153));
        statusContLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        statusContLabel.setForeground(new java.awt.Color(0, 255, 51));
        statusContLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        cnpLabel.setForeground(new java.awt.Color(255, 255, 0));
        cnpLabel.setText("CNP:");

        usernameContLabel.setBackground(new java.awt.Color(255, 255, 153));
        usernameContLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        usernameContLabel.setForeground(new java.awt.Color(0, 255, 51));
        usernameContLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        backToLoginButton.setBackground(new java.awt.Color(255, 255, 102));
        backToLoginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/examenbacalaureat/image/back-50x50.png"))); // NOI18N
        backToLoginButton.setText("Login");
        backToLoginButton.setToolTipText("Dupa crearea contului, intoarce-te la pagina de Login");
        backToLoginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backToLoginButtonMousePressed(evt);
            }
        });

        pierdutParolaLabel.setBackground(new java.awt.Color(255, 255, 153));
        pierdutParolaLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pierdutParolaLabel.setForeground(new java.awt.Color(0, 255, 51));

        pierdutParolaLabel2.setBackground(new java.awt.Color(255, 255, 153));
        pierdutParolaLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pierdutParolaLabel2.setForeground(new java.awt.Color(0, 255, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(passwordLabel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(prenumeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(numeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cnpLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(prenumeTextField)
                            .addComponent(numeTextField)
                            .addComponent(creeazaContButton, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(parolaPasswordField)
                            .addComponent(cnpTextField))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(backToLoginButton)
                                .addComponent(usernameContLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                                .addComponent(statusContLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(pierdutParolaLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pierdutParolaLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prenumeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prenumeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cnpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cnpLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(parolaPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel))
                .addGap(18, 18, 18)
                .addComponent(creeazaContButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusContLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameContLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pierdutParolaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pierdutParolaLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backToLoginButton))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void creeazaContButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_creeazaContButtonMousePressed
        if (!(numeTextField.getText().isEmpty())
                && !(prenumeTextField.getText().isEmpty())
                && !(cnpTextField.getText().isEmpty())
                && !(String.copyValueOf(parolaPasswordField.getPassword()).isEmpty())) {

            String nume = numeTextField.getText();
            String prenume = prenumeTextField.getText();
            String cnp = cnpTextField.getText();

            try {
                String usernameCont = OracleConnection.selectUsernameFromUsers(cnpTextField.getText()).get(0);
                statusContLabel.setForeground(Color.red);
                statusContLabel.setOpaque(true);
                usernameContLabel.setForeground(Color.red);
                usernameContLabel.setOpaque(true);
                statusContLabel.setText("Acest elev si-a creat deja contul!");
                usernameContLabel.setText("Username-ul lui este: " + usernameCont);
                pierdutParolaLabel.setForeground(Color.red);
                pierdutParolaLabel.setOpaque(true);
                pierdutParolaLabel.setText(" Daca ati uitat parola, o puteti gasi doar ");
                pierdutParolaLabel2.setForeground(Color.red);
                pierdutParolaLabel2.setOpaque(true);
                pierdutParolaLabel2.setText(" daca aveti acces la tabela Users din baza de date. ");

            } catch (IndexOutOfBoundsException e) {
                try {
                    List<String> rezultat = new ArrayList<>();
                    rezultat = OracleConnection.selectCodlpFromElev(nume, prenume, cnp);
                    String liceu_profil = rezultat.get(0);

                    String username = String.valueOf(numeTextField.getText().charAt(0)).toLowerCase() + String.valueOf(prenumeTextField.getText().charAt(0)).toLowerCase() + Integer.toString((int) (Math.random() * (999 - 100) + 100));
                    OracleConnection.insertIntoUsers(numeTextField.getText(),
                            prenumeTextField.getText(),
                            cnpTextField.getText(),
                            username,
                            String.copyValueOf(parolaPasswordField.getPassword()));

                    statusContLabel.setForeground(Color.green);
                    statusContLabel.setOpaque(false);
                    usernameContLabel.setForeground(Color.green);
                    usernameContLabel.setOpaque(false);
                    statusContLabel.setText("Cont creat cu succes!");
                    usernameContLabel.setText("Username-ul tau este: " + username);
                    pierdutParolaLabel.setForeground(Color.red);
                    pierdutParolaLabel.setOpaque(false);
                    pierdutParolaLabel.setText("");
                    pierdutParolaLabel2.setForeground(Color.red);
                    pierdutParolaLabel2.setOpaque(false);
                    pierdutParolaLabel2.setText("");

                } catch (IndexOutOfBoundsException ex) {
                    statusContLabel.setForeground(Color.red);
                    statusContLabel.setOpaque(true);
                    usernameContLabel.setForeground(Color.red);
                    usernameContLabel.setOpaque(true);
                    statusContLabel.setText("Acest elev nu exista inca in baza de date!");
                    usernameContLabel.setText("Elevul trebuie sa fie introdus de un administrator.");
                    pierdutParolaLabel.setForeground(Color.red);
                    pierdutParolaLabel.setOpaque(false);
                    pierdutParolaLabel.setText("");
                    pierdutParolaLabel2.setForeground(Color.red);
                    pierdutParolaLabel2.setOpaque(false);
                    pierdutParolaLabel2.setText("");
                }
            }

        } else {
            statusContLabel.setForeground(Color.red);
            statusContLabel.setOpaque(true);
            usernameContLabel.setForeground(Color.red);
            usernameContLabel.setOpaque(true);
            statusContLabel.setText("Nu ati creat contul in mod corect!");
            usernameContLabel.setText("Toate campurile trebuie sa fie completate.");
            pierdutParolaLabel.setForeground(Color.red);
            pierdutParolaLabel.setOpaque(false);
            pierdutParolaLabel.setText("");
            pierdutParolaLabel2.setForeground(Color.red);
            pierdutParolaLabel2.setOpaque(false);
            pierdutParolaLabel2.setText("");
        }
    }//GEN-LAST:event_creeazaContButtonMousePressed

    private void backToLoginButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backToLoginButtonMousePressed
        login = new LoginFrame();
        this.setVisible(false);
        login.setVisible(true);
    }//GEN-LAST:event_backToLoginButtonMousePressed

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
            java.util.logging.Logger.getLogger(CreareContFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreareContFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreareContFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreareContFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreareContFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToLoginButton;
    private javax.swing.JLabel cnpLabel;
    private javax.swing.JTextField cnpTextField;
    private javax.swing.JButton creeazaContButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel numeLabel;
    private javax.swing.JTextField numeTextField;
    private javax.swing.JPasswordField parolaPasswordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel pierdutParolaLabel;
    private javax.swing.JLabel pierdutParolaLabel2;
    private javax.swing.JLabel prenumeLabel;
    private javax.swing.JTextField prenumeTextField;
    private javax.swing.JLabel statusContLabel;
    private javax.swing.JLabel usernameContLabel;
    // End of variables declaration//GEN-END:variables
}
