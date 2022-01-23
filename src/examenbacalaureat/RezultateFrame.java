package examenbacalaureat;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author catal
 */
public class RezultateFrame extends javax.swing.JFrame {

    LoginFrame login;
    DefaultTableModel model = new DefaultTableModel();
    List<String> numeList = new ArrayList<>();
    List<String> denlList = new ArrayList<>();
    List<String> denpList = new ArrayList<>();
    List<String> proba1List = new ArrayList<>();
    List<Double> nota_init1List = new ArrayList<>();
    List<Double> nota_cont1List = new ArrayList<>();
    List<Double> nota_finala1List = new ArrayList<>();
    List<String> proba2List = new ArrayList<>();
    List<Double> nota_init2List = new ArrayList<>();
    List<Double> nota_cont2List = new ArrayList<>();
    List<Double> nota_finala2List = new ArrayList<>();
    List<String> proba3List = new ArrayList<>();
    List<Double> nota_init3List = new ArrayList<>();
    List<Double> nota_cont3List = new ArrayList<>();
    List<Double> nota_finala3List = new ArrayList<>();
    List<Double> mediaList = new ArrayList<>();
    List<String> rezultatList = new ArrayList<>();

    public RezultateFrame() {
        initComponents();
        Connection connection = null;
        OracleConnection.openConnection(connection);
        OracleConnection.closeConnection(connection);
        initializareTabel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backToLoginButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        rezultateTable = new javax.swing.JTable();
        searchTextField = new javax.swing.JTextField();
        exportButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(4000, 4000));

        jPanel1.setBackground(new java.awt.Color(204, 51, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rezultate", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 18), new java.awt.Color(255, 255, 0))); // NOI18N

        backToLoginButton.setBackground(new java.awt.Color(255, 255, 102));
        backToLoginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/examenbacalaureat/image/back-50x50.png"))); // NOI18N
        backToLoginButton.setText("Login");
        backToLoginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backToLoginButtonMousePressed(evt);
            }
        });

        rezultateTable.setAutoCreateRowSorter(true);
        rezultateTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nume", "Liceu", "Profil", "Proba1", "Nota_init1", "Nota_cont1", "Nota_finala1", "Proba2", "Nota_init2", "Nota_cont2", "Nota_finala2", "Proba3", "Nota_init3", "Nota_cont3", "Nota_finala3", "Media", "Rezultatul final"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rezultateTable.setToolTipText("Tabel rezultate bacalaureat");
        rezultateTable.setMaximumSize(new java.awt.Dimension(4000, 4000));
        rezultateTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(rezultateTable);

        searchTextField.setToolTipText("Introduceti numele elevului cautat");
        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyReleased(evt);
            }
        });

        exportButton.setBackground(new java.awt.Color(51, 255, 255));
        exportButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/examenbacalaureat/image/export-50x50.png"))); // NOI18N
        exportButton.setText("Export");
        exportButton.setToolTipText("Exportati fisierul in format .pdf");
        exportButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exportButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(backToLoginButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exportButton)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(500, Short.MAX_VALUE)
                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(478, 478, 478))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(searchTextField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backToLoginButton)
                    .addComponent(exportButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backToLoginButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backToLoginButtonMousePressed
        login = new LoginFrame();
        this.setVisible(false);
        login.setVisible(true);
    }//GEN-LAST:event_backToLoginButtonMousePressed

    private void searchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyReleased
        searchTable();
    }//GEN-LAST:event_searchTextFieldKeyReleased

    private void exportButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportButtonMousePressed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save as");
        fileChooser.setSelectedFile(new File("RezultateBacalaureat"));

        int userSelection = fileChooser.showSaveDialog(this);

        File fileToSave = null;
        String absolutePath = null;
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            fileToSave = fileChooser.getSelectedFile();
            absolutePath = fileToSave.getAbsolutePath();
            System.out.println("File saved at: " + absolutePath + ".pdf");
        }

        exportToPDF(rezultateTable, absolutePath + ".pdf");
    }//GEN-LAST:event_exportButtonMousePressed

    private void exportToPDF(javax.swing.JTable table, String destination) {
        try {
            Document document = new Document(PageSize.A2.rotate(), 10f, 10f, 50f, 0f);
            PdfWriter.getInstance(document, new FileOutputStream(destination));
            document.open();

            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
            pdfTable.setWidthPercentage(100);

            // Adding the header            
            for (int i = 0; i < table.getColumnCount(); i++) {
                pdfTable.addCell(table.getColumnModel().getColumn(i).getHeaderValue().toString());
            }

            // Adding the rows
            for (int i = 0; i < table.getRowCount(); i++) {
                for (int j = 0; j < table.getColumnCount(); j++) {
                    pdfTable.addCell(table.getModel().getValueAt(i, j).toString());
                }
            }

            document.add(pdfTable);
            document.close();
        } catch (DocumentException | FileNotFoundException | NullPointerException e) {
        }
    }

    private void searchTable() {
        for (int i = 0; i < rezultateTable.getRowCount(); i++) {
            model.removeRow(i);
            i--;
        }

        for (int i = 0; i < numeList.size(); i++) {
            if (numeList.get(i).toLowerCase().contains(searchTextField.getText().toLowerCase())) {
                model.addRow(new Object[]{numeList.get(i),
                    denlList.get(i),
                    denpList.get(i),
                    proba1List.get(i),
                    nota_init1List.get(i),
                    nota_cont1List.get(i),
                    nota_finala1List.get(i),
                    proba2List.get(i), nota_init2List.get(i), nota_cont2List.get(i), nota_finala2List.get(i),
                    proba3List.get(i), nota_init3List.get(i), nota_cont3List.get(i), nota_finala3List.get(i),
                    String.format("%.2f", mediaList.get(i)), rezultatList.get(i)});
            }
        }
    }

    private void initializareTabel() {
        model = (DefaultTableModel) rezultateTable.getModel();
        rezultateTable.setModel(model);

        for (int i = 0; i < rezultateTable.getRowCount(); i++) {
            model.removeRow(i);
        }
        
        for (int i = 0; i < numeList.size(); i++) {
            numeList.remove(i);
            denlList.remove(i);
            denpList.remove(i);
            proba1List.remove(i);
            nota_init1List.remove(i);
            nota_cont1List.remove(i);
            nota_finala1List.remove(i);
            proba2List.remove(i);
            nota_init2List.remove(i);
            nota_cont2List.remove(i);
            nota_finala2List.remove(i);
            proba3List.remove(i);
            nota_init3List.remove(i);
            nota_cont3List.remove(i);
            nota_finala3List.remove(i);
            mediaList.remove(i);
            rezultatList.remove(i);
            i--;
        }

        numeList = OracleConnection.selectNumeForRezultat();
        denlList = OracleConnection.selectDenlForRezultat();
        denpList = OracleConnection.selectDenpForRezultat();
        proba1List = OracleConnection.selectProba1ForRezultat();
        nota_init1List = OracleConnection.selectNota_init1ForRezultat();
        nota_cont1List = OracleConnection.selectNota_cont1ForRezultat();
        proba2List = OracleConnection.selectProba2ForRezultat();
        nota_init2List = OracleConnection.selectNota_init2ForRezultat();
        nota_cont2List = OracleConnection.selectNota_cont2ForRezultat();
        proba3List = OracleConnection.selectProba3ForRezultat();
        nota_init3List = OracleConnection.selectNota_init3ForRezultat();
        nota_cont3List = OracleConnection.selectNota_cont3ForRezultat();

        System.out.println(numeList.size());
        System.out.println(denlList.size());
        System.out.println(denpList.size());
        System.out.println(proba1List.size());
        System.out.println(nota_init1List.size());
        System.out.println(nota_cont1List.size());
        System.out.println(proba2List.size());
        System.out.println(nota_init2List.size());
        System.out.println(nota_cont2List.size());
        System.out.println(proba3List.size());
        System.out.println(nota_init3List.size());
        System.out.println(nota_cont3List.size());

        for (int i = 0; i < numeList.size(); i++) {
            if (nota_cont1List.get(i) == 0.0 || nota_cont1List.get(i) == -1) {
                nota_finala1List.add(i, nota_init1List.get(i));
            } else {
                nota_finala1List.add(i, nota_cont1List.get(i));
            }

            if (nota_cont2List.get(i) == 0.0 || nota_cont2List.get(i) == -1) {
                nota_finala2List.add(i, nota_init2List.get(i));
            } else {
                nota_finala2List.add(i, nota_cont2List.get(i));
            }

            if (nota_cont3List.get(i) == 0.0 || nota_cont3List.get(i) == -1) {
                nota_finala3List.add(i, nota_init3List.get(i));
            } else {
                nota_finala3List.add(i, nota_cont3List.get(i));
            }
            Double media = (Double) (nota_finala1List.get(i) + nota_finala2List.get(i) + nota_finala3List.get(i)) / 3.0;
            mediaList.add(i, media);

            if (mediaList.get(i) > 6.0 && nota_finala1List.get(i) > 5.0 && nota_finala2List.get(i) > 5.0 && nota_finala3List.get(i) > 5.0) {
                rezultatList.add(i, "ADMIS");
            } else {
                rezultatList.add(i, "RESPINS");
            }

            if (nota_finala1List.get(i) == 0 || nota_finala2List.get(i) == 0 || nota_finala3List.get(i) == 0) {
                rezultatList.set(i, "NEPREZENTAT");
            }
        }

        model = (DefaultTableModel) rezultateTable.getModel();

        for (int i = 0; i < numeList.size(); i++) {
            model.addRow(new Object[]{numeList.get(i),
                denlList.get(i),
                denpList.get(i),
                proba1List.get(i),
                nota_init1List.get(i),
                nota_cont1List.get(i),
                nota_finala1List.get(i),
                proba2List.get(i), nota_init2List.get(i), nota_cont2List.get(i), nota_finala2List.get(i),
                proba3List.get(i), nota_init3List.get(i), nota_cont3List.get(i), nota_finala3List.get(i),
                String.format("%.2f", mediaList.get(i)), rezultatList.get(i)});
        }
        rezultateTable.setModel(model);

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
            java.util.logging.Logger.getLogger(RezultateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RezultateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RezultateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RezultateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RezultateFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToLoginButton;
    private javax.swing.JButton exportButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable rezultateTable;
    private javax.swing.JTextField searchTextField;
    // End of variables declaration//GEN-END:variables
}
