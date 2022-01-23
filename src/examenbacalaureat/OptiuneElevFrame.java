package examenbacalaureat;

import java.awt.Color;
import java.sql.Connection;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author catal
 */
public class OptiuneElevFrame extends javax.swing.JFrame {

    LoginFrame login;
    private DefaultTableModel model = new DefaultTableModel();
    public String nume;

    public OptiuneElevFrame() {
        initComponents();
        Connection connection = null;
        OracleConnection.openConnection(connection);
        OracleConnection.closeConnection(connection);
        OptiuneTabbedPane.add("Contestatie", new ContestatiePanel());
        initializareTabel();
        try{
        nume = OracleConnection.selectNumeCompletElev(LoginFrame.cnp).get(0);
        }catch(IndexOutOfBoundsException e){
        }
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        OptiuneTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        backToLoginButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        proba3Table = new javax.swing.JTable();
        adaugaDisciplinaAlegereButton = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();
        contLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proba la alegere");

        jPanel2.setBackground(new java.awt.Color(204, 51, 255));

        OptiuneTabbedPane.setBackground(new java.awt.Color(204, 51, 255));

        jPanel1.setBackground(new java.awt.Color(204, 51, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proba la alegere", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SansSerif", 0, 18), new java.awt.Color(255, 255, 51))); // NOI18N

        backToLoginButton.setBackground(new java.awt.Color(255, 255, 102));
        backToLoginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/examenbacalaureat/image/back-50x50.png"))); // NOI18N
        backToLoginButton.setText("Login");
        backToLoginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backToLoginButtonMousePressed(evt);
            }
        });

        proba3Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Liceu", "Profil", "Selecteaza disciplina la alegere"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(proba3Table);

        adaugaDisciplinaAlegereButton.setBackground(new java.awt.Color(51, 255, 255));
        adaugaDisciplinaAlegereButton.setText("Adauga disciplina la alegere");
        adaugaDisciplinaAlegereButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                adaugaDisciplinaAlegereButtonMousePressed(evt);
            }
        });

        statusLabel.setBackground(new java.awt.Color(255, 255, 153));
        statusLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        contLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        contLabel.setForeground(new java.awt.Color(255, 255, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(adaugaDisciplinaAlegereButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(backToLoginButton)
                        .addGap(0, 443, Short.MAX_VALUE))
                    .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(contLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adaugaDisciplinaAlegereButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backToLoginButton)
                .addContainerGap())
        );

        OptiuneTabbedPane.addTab("Optiune", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(OptiuneTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(OptiuneTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 286, Short.MAX_VALUE)
        );

        OptiuneTabbedPane.getAccessibleContext().setAccessibleName("Optiune elev");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adaugaDisciplinaAlegereButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adaugaDisciplinaAlegereButtonMousePressed
        String probaAlegere = "";
        try {
            probaAlegere = OracleConnection.selectDenprForElev(LoginFrame.cnp, 3).get(0);
            if (!probaAlegere.equals("")) {
                adaugaDisciplinaAlegereButton.setEnabled(false);
                //proba3Table.setEnabled(false);
                statusLabel.setForeground(Color.green);
                statusLabel.setOpaque(true);
                statusLabel.setText("Ai introdus deja disciplina la alegere: " + probaAlegere);
            }
        } catch (IndexOutOfBoundsException e) {
            String denumire_proba = model.getValueAt(0, 2).toString();
            if (denumire_proba.equals("Selecteaza") || denumire_proba.equals("")) {
                adaugaDisciplinaAlegereButton.setEnabled(true);
                statusLabel.setForeground(Color.red);
                statusLabel.setOpaque(true);
                statusLabel.setText("Nu ai selectat disciplina la alegere!");
            } else {
                OracleConnection.insertProba3(LoginFrame.cnp, denumire_proba);
                adaugaDisciplinaAlegereButton.setEnabled(false);
                //proba3Table.setEnabled(false);
                statusLabel.setForeground(Color.green);
                statusLabel.setOpaque(true);
                statusLabel.setText("Ai introdus disciplina la alegere: " + denumire_proba);
                contLabel.setText("Succes la examenul de Bacalaureat, " + OracleConnection.selectNumeCompletElev(LoginFrame.cnp).get(0) + "!");
            }
        }
    }//GEN-LAST:event_adaugaDisciplinaAlegereButtonMousePressed

    private void backToLoginButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backToLoginButtonMousePressed
        login = new LoginFrame();
        this.dispose();
    }//GEN-LAST:event_backToLoginButtonMousePressed

    private void initializareTabel() {
        TableColumn columnProba3 = proba3Table.getColumnModel().getColumn(2);
        JComboBox proba3ComboBox = new JComboBox();
        try {
            umplereComboBoxProba3(proba3ComboBox, OracleConnection.selectDenpFromProfilForElev("", "", LoginFrame.cnp).get(0));
        } catch (IndexOutOfBoundsException e) {
        }
        columnProba3.setCellEditor(new DefaultCellEditor(proba3ComboBox));

        model = (DefaultTableModel) proba3Table.getModel();
        proba3Table.setModel(model);
        try {
            List<String> proba3List = OracleConnection.selectDenprForElev(LoginFrame.cnp, 3);
            model.setValueAt(proba3List.get(0), 0, 2);
        } catch (IndexOutOfBoundsException e) {
            model.setValueAt("Selecteaza", 0, 2);
            contLabel.setText("Bine ai venit, " + OracleConnection.selectNumeCompletElev(LoginFrame.cnp).get(0) + "! Te rog sa introduci disciplina la alegere: ");
        }

        try {
            List<String> liceuList = OracleConnection.selectDenlFromLiceuForElev("", "", LoginFrame.cnp);
            model.setValueAt(liceuList.get(0), 0, 0);
            List<String> profilList = OracleConnection.selectDenpFromProfilForElev("", "", LoginFrame.cnp);
            model.setValueAt(profilList.get(0), 0, 1);
        } catch (IndexOutOfBoundsException e) {
            model.setValueAt("ceva este in neregula", 0, 0);
        }

        String probaAlegere = "";
        try {
            probaAlegere = OracleConnection.selectDenprForElev(LoginFrame.cnp, 3).get(0);
            if (!probaAlegere.equals("")) {
                adaugaDisciplinaAlegereButton.setEnabled(false);
                //proba3Table.setEnabled(false);
                statusLabel.setForeground(Color.green);
                statusLabel.setOpaque(true);
                statusLabel.setText("Ai introdus deja disciplina la alegere: " + probaAlegere);
                contLabel.setText("Succes la examenul de Bacalaureat, " + OracleConnection.selectNumeCompletElev(LoginFrame.cnp).get(0) + "!");
            }
        } catch (IndexOutOfBoundsException e) {
        }
    }

    private void umplereComboBoxProba3(JComboBox proba3ComboBox, String profil) {
        for (int i = 0; i < proba3ComboBox.getItemCount(); i++) {
            proba3ComboBox.remove(i);
        }
        List<String> proba3List = OracleConnection.selectDenpr3FromProba(profil);
        for (int i = 0; i < proba3List.size(); i++) {
            proba3ComboBox.addItem(proba3List.get(i));
        }
    }

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
            java.util.logging.Logger.getLogger(OptiuneElevFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OptiuneElevFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OptiuneElevFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OptiuneElevFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OptiuneElevFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane OptiuneTabbedPane;
    private javax.swing.JButton adaugaDisciplinaAlegereButton;
    private javax.swing.JButton backToLoginButton;
    private javax.swing.JLabel contLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable proba3Table;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
