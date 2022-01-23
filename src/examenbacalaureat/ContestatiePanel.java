package examenbacalaureat;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author catal
 */
public class ContestatiePanel extends javax.swing.JPanel {

    private boolean contestatie1;
    private boolean contestatie2;
    private boolean contestatie3;

    public ContestatiePanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contestatie1CheckBox = new javax.swing.JCheckBox();
        contestatie2CheckBox = new javax.swing.JCheckBox();
        contestatie3CheckBox = new javax.swing.JCheckBox();
        trimiteContestatieButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        statusLabel1 = new javax.swing.JLabel();
        statusLabel2 = new javax.swing.JLabel();
        statusLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 51, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contestatie", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SansSerif", 0, 18), new java.awt.Color(255, 255, 51))); // NOI18N

        contestatie1CheckBox.setText("Contestatie proba1");

        contestatie2CheckBox.setText("Contestatie proba2");

        contestatie3CheckBox.setText("Contestatie proba3");

        trimiteContestatieButton.setBackground(new java.awt.Color(51, 255, 255));
        trimiteContestatieButton.setText("Trimite contestatie");
        trimiteContestatieButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                trimiteContestatieButtonMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 51));
        jLabel1.setText("Bifeaza probele la care doresti sa faci contestatie, apoi apasa butonul \"Trimite contestatie\":");

        statusLabel1.setForeground(new java.awt.Color(255, 255, 102));

        statusLabel2.setForeground(new java.awt.Color(255, 255, 102));

        statusLabel3.setForeground(new java.awt.Color(255, 255, 102));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(contestatie1CheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(statusLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 4, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(contestatie3CheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(statusLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(contestatie2CheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(statusLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(trimiteContestatieButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contestatie1CheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contestatie2CheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contestatie3CheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(trimiteContestatieButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void trimiteContestatieButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trimiteContestatieButtonMousePressed
        contestatie1 = contestatie1CheckBox.isSelected();
        contestatie2 = contestatie2CheckBox.isSelected();
        contestatie3 = contestatie3CheckBox.isSelected();
        
        trimiteContestatieButton.setEnabled(false);

        if (contestatie1 == true) {
            if (OracleConnection.selectNota_contForElev(LoginFrame.cnp, 1).get(0) == 0.0) {
                if (OracleConnection.selectNota_initForElev(LoginFrame.cnp, 1).get(0) != 0.0) {
                    OracleConnection.updateNota_cont(LoginFrame.cnp, -1.0, 1);
                } else {
                    statusLabel1.setText("Sunteti absent la proba 1, deci nu puteti contesta nota!");
                }
            }
        }
        if (contestatie2 == true) {
            if (OracleConnection.selectNota_contForElev(LoginFrame.cnp, 2).get(0) == 0.0) {
                if (OracleConnection.selectNota_initForElev(LoginFrame.cnp, 2).get(0) != 0.0) {
                    OracleConnection.updateNota_cont(LoginFrame.cnp, -1.0, 2);
                } else {
                    statusLabel2.setText("Sunteti absent la proba 2, deci nu puteti contesta nota!");
                }
            }
        }

        if (contestatie3 == true) {
            if (OracleConnection.selectNota_contForElev(LoginFrame.cnp, 3).get(0) == 0.0) {
                if (OracleConnection.selectNota_initForElev(LoginFrame.cnp, 3).get(0) != 0.0) {
                    OracleConnection.updateNota_cont(LoginFrame.cnp, -1.0, 3);
                } else {
                    statusLabel3.setText("Sunteti absent la proba 3, deci nu puteti contesta nota!");
                }
            }
        }
    }//GEN-LAST:event_trimiteContestatieButtonMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox contestatie1CheckBox;
    private javax.swing.JCheckBox contestatie2CheckBox;
    private javax.swing.JCheckBox contestatie3CheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel statusLabel1;
    private javax.swing.JLabel statusLabel2;
    private javax.swing.JLabel statusLabel3;
    private javax.swing.JButton trimiteContestatieButton;
    // End of variables declaration//GEN-END:variables
}
