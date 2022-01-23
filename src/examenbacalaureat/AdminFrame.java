package examenbacalaureat;

import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author catal
 */
public class AdminFrame extends javax.swing.JFrame {

    LoginFrame login;
    private int selectedRow;
    List<String> numeList = new ArrayList<>();
    List<String> cnpList = new ArrayList<>();
    List<String> denlList = new ArrayList<>();
    List<String> denpList = new ArrayList<>();
    List<String> numeListCont = new ArrayList<>();
    List<String> cnpListCont = new ArrayList<>();
    List<String> denprListCont = new ArrayList<>();
    List<Double> nota_contListCont = new ArrayList<>();
    DefaultTableModel modelElevi = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column == 0;
        }
    };
    DefaultTableModel modelProbe = new DefaultTableModel();
    DefaultTableModel modelContestatie = new DefaultTableModel();

    /**
     * The Constructor for class AdminFrame
     */
    public AdminFrame() {
        initComponents();
        Connection connection = null;
        OracleConnection.openConnection(connection);
        OracleConnection.closeConnection(connection);
        initializareTabelElevi();
        initializareComboBoxLiceu();
        tabelProbe();
        initializareTabelContestatie();

        eleviTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting()) {
                    tableRowSelected(evt);
                    tabelProbe();
                }

            }
        });
    }

    private void tableRowSelected(ListSelectionEvent e) {

        deleteButton.setEnabled(true);
        selectedRow = eleviTable.getSelectedRow();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        adaugareElevButton = new javax.swing.JButton();
        numeTextField = new javax.swing.JTextField();
        initialaTextField = new javax.swing.JTextField();
        prenumeTextField = new javax.swing.JTextField();
        cnpTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        liceuComboBox = new javax.swing.JComboBox<>();
        statusElevLabel = new javax.swing.JLabel();
        backToLoginButton = new javax.swing.JButton();
        profilComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        eleviTable = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        probeTable = new javax.swing.JTable();
        updateButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        contestatieTable = new javax.swing.JTable();
        adaugaContestatieButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrator");

        jPanel1.setBackground(new java.awt.Color(204, 51, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Administrator", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 18), new java.awt.Color(255, 255, 0))); // NOI18N

        adaugareElevButton.setBackground(new java.awt.Color(51, 255, 255));
        adaugareElevButton.setText("Adauga elev");
        adaugareElevButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                adaugareElevButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                adaugareElevButtonMouseReleased(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nume");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Initiala tata");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Prenume");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CNP");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Profil");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Liceu");

        liceuComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecteaza liceul" }));
        liceuComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                liceuComboBoxActionPerformed(evt);
            }
        });

        statusElevLabel.setBackground(new java.awt.Color(255, 255, 204));
        statusElevLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        statusElevLabel.setForeground(new java.awt.Color(255, 255, 0));
        statusElevLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusElevLabel.setText("Toate campurile trebuie sa fie completate!");

        backToLoginButton.setBackground(new java.awt.Color(255, 255, 102));
        backToLoginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/examenbacalaureat/image/back-50x50.png"))); // NOI18N
        backToLoginButton.setText("Login");
        backToLoginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backToLoginButtonMousePressed(evt);
            }
        });

        profilComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecteaza profilul" }));

        eleviTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nume", "CNP", "Liceu", "Profil"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        eleviTable.setToolTipText("Tabelul elevilor din baza de date");
        eleviTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(eleviTable);

        deleteButton.setBackground(new java.awt.Color(255, 51, 51));
        deleteButton.setText("Sterge elev");
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                deleteButtonMouseReleased(evt);
            }
        });

        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyReleased(evt);
            }
        });

        probeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Limba si literatura romana", "Nota initiala / absent", "Disciplina obligatorie a profilului", "Nota initiala / absent", "Disciplina la alegere", "Nota initiala / absent"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        probeTable.setToolTipText("Probele si notele elevului selectat");
        probeTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(probeTable);

        updateButton.setBackground(new java.awt.Color(102, 255, 102));
        updateButton.setText("Modifica");
        updateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                updateButtonMousePressed(evt);
            }
        });

        contestatieTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nume", "CNP", "Proba", "Nota contestatie"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        contestatieTable.setToolTipText("Tabelul cu elevii care au facut contestatii");
        jScrollPane4.setViewportView(contestatieTable);

        adaugaContestatieButton.setBackground(new java.awt.Color(51, 51, 255));
        adaugaContestatieButton.setText("Adauga nota contestatie");
        adaugaContestatieButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                adaugaContestatieButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusElevLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(389, 389, 389))
                    .addComponent(adaugareElevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 1059, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(numeTextField, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(initialaTextField)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(prenumeTextField)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cnpTextField)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(liceuComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(profilComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(backToLoginButton)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(496, 496, 496)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deleteButton)
                            .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(468, 468, 468)
                        .addComponent(adaugaContestatieButton)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(initialaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prenumeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cnpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(liceuComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profilComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(adaugareElevButton)
                .addGap(18, 18, 18)
                .addComponent(statusElevLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adaugaContestatieButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backToLoginButton)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adaugareElevButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adaugareElevButtonMousePressed
        boolean letterError = false;
        try {
            for (int i = 0; i < numeTextField.getText().length(); i++) {
                if (!Character.isLetter(numeTextField.getText().charAt(i))) {
                    letterError = true;
                }
            }
            for (int i = 0; i < prenumeTextField.getText().length(); i++) {
                if (!Character.isLetter(prenumeTextField.getText().charAt(i))) {
                    letterError = true;
                }
            }
            if (!Character.isLetter(initialaTextField.getText().charAt(0))) {
                letterError = true;
            }
        } catch (IndexOutOfBoundsException ex) {
            statusElevLabel.setOpaque(true);
            statusElevLabel.setBackground(Color.yellow);
            statusElevLabel.setForeground(Color.red);
            statusElevLabel.setText("Nu ati adaugat elevul in mod corect!");
        }
        if (!(numeTextField.getText().isEmpty())
                && !(initialaTextField.getText().isEmpty())
                && initialaTextField.getText().length() == 1
                && !(prenumeTextField.getText().isEmpty())
                && !(cnpTextField.getText().isEmpty())
                && cnpTextField.getText().length() == 13
                && cnpTextField.getText().matches("[0-9]+")
                && (profilComboBox.getSelectedIndex() != 0)
                && (liceuComboBox.getSelectedIndex() != 0)
                && letterError == false) {

            OracleConnection.insertIntoElev(numeTextField.getText(),
                    initialaTextField.getText(),
                    prenumeTextField.getText(),
                    cnpTextField.getText(),
                    profilComboBox.getSelectedItem().toString(),
                    liceuComboBox.getSelectedItem().toString());
            statusElevLabel.setForeground(Color.green);
            statusElevLabel.setOpaque(false);
            statusElevLabel.setText("Elev adaugat cu succes!");

            numeTextField.setText("");
            initialaTextField.setText("");
            prenumeTextField.setText("");
            cnpTextField.setText("");
            liceuComboBox.setSelectedIndex(0);
        } else {
            statusElevLabel.setOpaque(true);
            statusElevLabel.setBackground(Color.yellow);
            statusElevLabel.setForeground(Color.red);
            statusElevLabel.setText("Nu ati adaugat elevul in mod corect!");
        }
    }//GEN-LAST:event_adaugareElevButtonMousePressed

    private void backToLoginButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backToLoginButtonMousePressed
        login = new LoginFrame();
        this.dispose();
    }//GEN-LAST:event_backToLoginButtonMousePressed

    private void liceuComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_liceuComboBoxActionPerformed
        List<String> denumireProfil = new ArrayList();
        denumireProfil.clear();
        profilComboBox.removeAllItems();
        profilComboBox.addItem("Selecteaza profilul");
        denumireProfil = OracleConnection.selectDenpFromProfilWhereLiceuIsSelected(liceuComboBox.getSelectedItem().toString());
        for (int i = 0; i < denumireProfil.size(); i++) {
            System.out.println(denumireProfil.get(i));
            profilComboBox.addItem(denumireProfil.get(i));
        }
    }//GEN-LAST:event_liceuComboBoxActionPerformed

    private void adaugareElevButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adaugareElevButtonMouseReleased
        initializareTabelElevi();
        searchTable(eleviTable, modelElevi, numeList, cnpList, denlList, denpList);
    }//GEN-LAST:event_adaugareElevButtonMouseReleased

    private void deleteButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMousePressed
        String cnp = eleviTable.getValueAt(eleviTable.getSelectedRow(), 1).toString();
        OracleConnection.deleteElev(cnp);
    }//GEN-LAST:event_deleteButtonMousePressed

    private void deleteButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseReleased
        initializareTabelElevi();
        initializareTabelContestatie();
        searchTable(eleviTable, modelElevi, numeList, cnpList, denlList, denpList);
        searchContestatieTable(contestatieTable, modelContestatie, numeListCont, cnpListCont, denprListCont, nota_contListCont);
    }//GEN-LAST:event_deleteButtonMouseReleased

    private void searchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyReleased
        searchTable(eleviTable, modelElevi, numeList, cnpList, denlList, denpList);
        searchContestatieTable(contestatieTable, modelContestatie, numeListCont, cnpListCont, denprListCont, nota_contListCont);
    }//GEN-LAST:event_searchTextFieldKeyReleased

    private void updateButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMousePressed
        String numeElev = eleviTable.getValueAt(eleviTable.getSelectedRow(), 0).toString();
        String nume = "";
        String init_tata = "";
        String prenume = "";
        Double nota_initiala1 = 0.0;
        Double nota_initiala2 = 0.0;
        Double nota_initiala3 = 0.0;
        for (int i = 0; i < numeElev.length(); i++) {
            if (numeElev.charAt(i) == ' ') {
                nume = numeElev.substring(0, i);
                init_tata = numeElev.substring(i + 1, i + 2);
                prenume = numeElev.substring(i + 4, numeElev.length());
                break;
            }
        }

        String cnp = eleviTable.getValueAt(eleviTable.getSelectedRow(), 1).toString();
        String proba3 = probeTable.getValueAt(0, 4).toString();

        try {
            if (!probeTable.getValueAt(0, 1).toString().toLowerCase().equals("absent")) {
                nota_initiala1 = Double.parseDouble(probeTable.getValueAt(0, 1).toString());
            } else {
                nota_initiala1 = 0.0;
            }
            if (!probeTable.getValueAt(0, 3).toString().toLowerCase().equals("absent")) {
                nota_initiala2 = Double.parseDouble(probeTable.getValueAt(0, 3).toString());
            } else {
                nota_initiala2 = 0.0;
            }
            if (!probeTable.getValueAt(0, 5).toString().toLowerCase().equals("absent") && !probeTable.getValueAt(0, 5).toString().toLowerCase().equals("")) {
                nota_initiala3 = Double.parseDouble(probeTable.getValueAt(0, 5).toString());
            } else {
                nota_initiala3 = 0.0;
            }
        } catch (NullPointerException e) {
            probeTable.setValueAt(0.0, 0, 1);
            probeTable.setValueAt(0.0, 0, 3);
            probeTable.setValueAt(0.0, 0, 5);
        }
        if (!proba3.equals("elevul nu a ales inca")) {
            OracleConnection.updateElevAndProba(nume, init_tata, prenume, cnp, proba3, nota_initiala1, nota_initiala2, nota_initiala3);
        } else {
            OracleConnection.updateElev(nume, init_tata, prenume, cnp, nota_initiala1, nota_initiala2);
        }
        initializareTabelContestatie();
        searchContestatieTable(contestatieTable, modelContestatie, numeListCont, cnpListCont, denprListCont, nota_contListCont);
    }//GEN-LAST:event_updateButtonMousePressed

    private void adaugaContestatieButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adaugaContestatieButtonMousePressed
        try {
            for (int i = 0; i < contestatieTable.getRowCount(); i++) {
                if (!contestatieTable.getValueAt(i, 3).toString().equals("")) {
                    OracleConnection.updateNota_cont(contestatieTable.getValueAt(i, 1).toString(), Double.parseDouble(contestatieTable.getValueAt(i, 3).toString()), contestatieTable.getValueAt(i, 2).toString());
                }
            }
        } catch (IndexOutOfBoundsException e) {
        }
    }//GEN-LAST:event_adaugaContestatieButtonMousePressed

    private void searchTable(JTable table, DefaultTableModel model, List<String> numeList, List<String> cnpList, List<String> denlList, List<String> denpList) {
        for (int i = 0; i < table.getRowCount(); i++) {
            model.removeRow(i);
            i--;
        }
        for (int i = 0; i < numeList.size(); i++) {
            if (numeList.get(i).toLowerCase().contains(searchTextField.getText().toLowerCase())) {
                model.addRow(new Object[]{numeList.get(i), cnpList.get(i), denlList.get(i), denpList.get(i)});
            }
        }
    }

    private void searchContestatieTable(JTable table, DefaultTableModel model, List<String> numeList, List<String> cnpList, List<String> denprList, List<Double> nota_contList) {
        for (int i = 0; i < table.getRowCount(); i++) {
            model.removeRow(i);
            i--;
        }
        for (int i = 0; i < numeList.size(); i++) {
            if (numeList.get(i).toLowerCase().contains(searchTextField.getText().toLowerCase())) {
                if (nota_contList.get(i) == -1.0) {
                    model.addRow(new Object[]{numeList.get(i), cnpList.get(i), denprList.get(i), ""});
                } else {
                    model.addRow(new Object[]{numeList.get(i), cnpList.get(i), denprList.get(i), nota_contList.get(i)});
                }
            }
        }
    }

    private void initializareTabelElevi() {
        eleviTable.removeAll();
        String nume = "";
        String prenume = "";
        String cnp = "";

        for (int i = 0; i < numeList.size(); i++) {
            numeList.remove(i);
            cnpList.remove(i);
            denlList.remove(i);
            denpList.remove(i);
            i--;
        }

        numeList = OracleConnection.selectNumeFromElev(nume, prenume, cnp);
        cnpList = OracleConnection.selectCNPFromElev(nume, prenume, cnp);
        denlList = OracleConnection.selectDenlFromLiceuForElev(nume, prenume, cnp);
        denpList = OracleConnection.selectDenpFromProfilForElev(nume, prenume, cnp);

        String column_names[] = {"Nume", "CNP", "Liceu", "Profil"};
        modelElevi = new DefaultTableModel(column_names, 0);
        //modelElevi = (DefaultTableModel) eleviTable.getModel();
        for (int i = 0; i < numeList.size(); i++) {
            modelElevi.addRow(new Object[]{numeList.get(i), cnpList.get(i), denlList.get(i), denpList.get(i)});
        }

        eleviTable.setModel(modelElevi);
    }

    private void tabelProbe() {
        TableColumn columnProba3 = probeTable.getColumnModel().getColumn(4);
        JComboBox proba3ComboBox = new JComboBox();
        try {
            umplereComboBoxProba3(proba3ComboBox, eleviTable.getValueAt(eleviTable.getSelectedRow(), 3).toString());
        } catch (IndexOutOfBoundsException e) {
        }
        columnProba3.setCellEditor(new DefaultCellEditor(proba3ComboBox));

        modelProbe = (DefaultTableModel) probeTable.getModel();
        probeTable.setModel(modelProbe);
        try {
            List<String> proba3List = OracleConnection.selectDenprForElev(eleviTable.getValueAt(eleviTable.getSelectedRow(), 1).toString(), 3);
            modelProbe.setValueAt(proba3List.get(0), 0, 4);
            List<Double> nota_init3List = OracleConnection.selectNota_initForElev(eleviTable.getValueAt(eleviTable.getSelectedRow(), 1).toString(), 3);
            if (nota_init3List.get(0) == 0.0) {
                modelProbe.setValueAt("absent", 0, 5);
            } else {
                modelProbe.setValueAt(nota_init3List.get(0), 0, 5);
            }
        } catch (IndexOutOfBoundsException e) {
            modelProbe.setValueAt("elevul nu a ales inca", 0, 4);
            modelProbe.setValueAt("", 0, 5);
        }

        try {
            List<String> proba1List = OracleConnection.selectDenprForElev(eleviTable.getValueAt(eleviTable.getSelectedRow(), 1).toString(), 1);
            modelProbe.setValueAt(proba1List.get(0), 0, 0);
            List<Double> nota_init1List = OracleConnection.selectNota_initForElev(eleviTable.getValueAt(eleviTable.getSelectedRow(), 1).toString(), 1);
            if (nota_init1List.get(0) == 0.0) {
                modelProbe.setValueAt("absent", 0, 1);
            } else {
                modelProbe.setValueAt(nota_init1List.get(0), 0, 1);
            }
            List<String> proba2List = OracleConnection.selectDenprForElev(eleviTable.getValueAt(eleviTable.getSelectedRow(), 1).toString(), 2);
            modelProbe.setValueAt(proba2List.get(0), 0, 2);
            List<Double> nota_init2List = OracleConnection.selectNota_initForElev(eleviTable.getValueAt(eleviTable.getSelectedRow(), 1).toString(), 2);
            if (nota_init2List.get(0) == 0.0) {
                modelProbe.setValueAt("absent", 0, 3);
            } else {
                modelProbe.setValueAt(nota_init2List.get(0), 0, 3);
            }
        } catch (IndexOutOfBoundsException e) {
            modelProbe.setValueAt("elevul nu e selectat", 0, 0);
            modelProbe.setValueAt("elevul nu e selectat", 0, 2);
        }

    }

    private void initializareTabelContestatie() {
        for (int i = 0; i < contestatieTable.getRowCount(); i++) {
            modelContestatie.removeRow(i);
        }
        for (int i = 0; i < numeListCont.size(); i++) {
            numeListCont.remove(i);
            cnpListCont.remove(i);
            denprListCont.remove(i);
            nota_contListCont.remove(i);
            i--;
        }

        numeListCont = OracleConnection.selectNumeForContestatie();
        cnpListCont = OracleConnection.selectCNPForContestatie();
        denprListCont = OracleConnection.selectDenprForContestatie();
        nota_contListCont = OracleConnection.selectNota_contForContestatie();

        modelContestatie = (DefaultTableModel) contestatieTable.getModel();
        for (int i = 0; i < numeListCont.size(); i++) {
            if (nota_contListCont.get(i) == -1.0) {
                modelContestatie.addRow(new Object[]{numeListCont.get(i), cnpListCont.get(i), denprListCont.get(i), ""});
            } else {
                modelContestatie.addRow(new Object[]{numeListCont.get(i), cnpListCont.get(i), denprListCont.get(i), nota_contListCont.get(i)});
            }
        }
        contestatieTable.setModel(modelContestatie);
    }

    private void initializareComboBoxLiceu() {
        List<String> denumireLiceu = OracleConnection.selectDenlFromLiceu();
        for (int i = 0; i < denumireLiceu.size(); i++) {
            liceuComboBox.addItem(denumireLiceu.get(i));
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
            java.util.logging.Logger.getLogger(AdminFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdminFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adaugaContestatieButton;
    private javax.swing.JButton adaugareElevButton;
    private javax.swing.JButton backToLoginButton;
    private javax.swing.JTextField cnpTextField;
    private javax.swing.JTable contestatieTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTable eleviTable;
    private javax.swing.JTextField initialaTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JComboBox<String> liceuComboBox;
    private javax.swing.JTextField numeTextField;
    private javax.swing.JTextField prenumeTextField;
    private javax.swing.JTable probeTable;
    private javax.swing.JComboBox<String> profilComboBox;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JLabel statusElevLabel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
