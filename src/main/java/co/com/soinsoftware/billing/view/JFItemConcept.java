/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.soinsoftware.billing.view;

import co.com.soinsoftware.billing.controller.ItemConceptController;
import co.com.soinsoftware.billing.controller.MenuController;
import co.com.soinsoftware.billing.entity.Itemconcept;
import co.com.soinsoftware.billing.entity.User;

import java.awt.GraphicsEnvironment;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

/**
 * @author Carlos Rodriguez
 * @since 15/06/2016
 * @version 1.0
 */
public class JFItemConcept extends JFrame {

    private static final long serialVersionUID = 7962825337634660703L;

    private static final String TITLE = "Facturador - Concepto de facturación";

    private static final String MSG_EMPTY_FIELDS = "Por favor complete el campo nombre";

    private final User loggedUser;

    private final ItemConceptController itemConceptController;

    /**
     * Creates new form JFItemConcept
     *
     * @param loggedUser Current user using application
     */
    @SuppressWarnings("unchecked")
	public JFItemConcept(final User loggedUser) {
        super();
        this.loggedUser = loggedUser;
        this.initComponents();
        this.itemConceptController = new ItemConceptController();
        this.jlsItemConcept.setListData(this.getActiveItemConcepts());
        this.jtfName.setDocument(new JTextFieldLimit(60));
        this.setTitle(this.loggedUser.getCompany().getName() + " - " + TITLE);
        this.setMaximized();
    }

    public void addController(final MenuController controller) {
        final JMenuBar menuBar = new JMBAppMenu(controller);
        this.setJMenuBar(menuBar);
    }

    @SuppressWarnings("unchecked")
	public void refresh() {
        this.cleanFields();
        this.jlsItemConcept.setListData(this.getActiveItemConcepts());
    }
    
    private void setMaximized() {
        final GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.setMaximizedBounds(env.getMaximumWindowBounds());
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }

    private void cleanFields() {
        this.jtfName.setText("");
    }

    private String[] getActiveItemConcepts() {
        String[] itemConceptArray = null;
        final List<Itemconcept> itemConceptList = this.itemConceptController
                .getItemConceptList(this.loggedUser, true);
        if (itemConceptList != null) {
            itemConceptArray = new String[itemConceptList.size()];
            for (int i = 0; i < itemConceptList.size(); i++) {
                itemConceptArray[i] = itemConceptList.get(i).getName();
            }
        }
        return itemConceptArray;
    }

    @SuppressWarnings("rawtypes")
	private void initComponents() {

        pnTitle = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        pnItemConcept = new javax.swing.JPanel();
        jlbName = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jbtSave = new javax.swing.JButton();
        jbtClean = new javax.swing.JButton();
        pnItemConceptList = new javax.swing.JPanel();
        jspItemConcept = new javax.swing.JScrollPane();
        jlsItemConcept = new javax.swing.JList();
        lbImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(510, 360));
        setPreferredSize(new java.awt.Dimension(510, 360));

        pnTitle.setBackground(new java.awt.Color(255, 255, 255));
        pnTitle.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnTitle.setToolTipText("");
        pnTitle.setName("pnTitle"); // NOI18N

        lbTitle.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbTitle.setText("Nuevo concepto");

        javax.swing.GroupLayout pnTitleLayout = new javax.swing.GroupLayout(pnTitle);
        pnTitle.setLayout(pnTitleLayout);
        pnTitleLayout.setHorizontalGroup(
            pnTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnTitleLayout.setVerticalGroup(
            pnTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnItemConcept.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Concepto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        pnItemConcept.setName("pnItemConcept"); // NOI18N
        pnItemConcept.setPreferredSize(new java.awt.Dimension(300, 200));

        jlbName.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jlbName.setText("Nombre:");

        jtfName.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jtfName.setPreferredSize(new java.awt.Dimension(200, 20));

        jbtSave.setBackground(new java.awt.Color(16, 135, 221));
        jbtSave.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jbtSave.setForeground(new java.awt.Color(255, 255, 255));
        jbtSave.setText("Guardar");
        jbtSave.setPreferredSize(new java.awt.Dimension(89, 23));
        jbtSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSaveActionPerformed(evt);
            }
        });

        jbtClean.setBackground(new java.awt.Color(16, 135, 221));
        jbtClean.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jbtClean.setForeground(new java.awt.Color(255, 255, 255));
        jbtClean.setText("Limpiar");
        jbtClean.setPreferredSize(new java.awt.Dimension(89, 23));
        jbtClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCleanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnItemConceptLayout = new javax.swing.GroupLayout(pnItemConcept);
        pnItemConcept.setLayout(pnItemConceptLayout);
        pnItemConceptLayout.setHorizontalGroup(
            pnItemConceptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnItemConceptLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnItemConceptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnItemConceptLayout.createSequentialGroup()
                        .addComponent(jlbName)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jtfName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnItemConceptLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtClean, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnItemConceptLayout.setVerticalGroup(
            pnItemConceptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnItemConceptLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnItemConceptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtClean, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnItemConceptList.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de conceptos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        pnItemConceptList.setName("pnItemConcept"); // NOI18N
        pnItemConceptList.setPreferredSize(new java.awt.Dimension(300, 200));

        jlsItemConcept.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jlsItemConcept.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jlsItemConcept.setEnabled(false);
        jspItemConcept.setViewportView(jlsItemConcept);

        javax.swing.GroupLayout pnItemConceptListLayout = new javax.swing.GroupLayout(pnItemConceptList);
        pnItemConceptList.setLayout(pnItemConceptListLayout);
        pnItemConceptListLayout.setHorizontalGroup(
            pnItemConceptListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspItemConcept, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
        );
        pnItemConceptListLayout.setVerticalGroup(
            pnItemConceptListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnItemConceptListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jspItemConcept, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
        );

        lbImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/soin.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnItemConcept, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnItemConceptList, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnItemConcept, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnItemConceptList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("unchecked")
	private void jbtSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSaveActionPerformed
        final String name = this.jtfName.getText();
        if (!name.trim().equals("")) {
            this.itemConceptController.saveItemConcept(this.loggedUser, name);
            ViewUtils.showMessage(this, ViewUtils.MSG_SAVED, TITLE,
                    JOptionPane.INFORMATION_MESSAGE);
            this.cleanFields();
            this.jlsItemConcept.setListData(this.getActiveItemConcepts());
        } else {
            ViewUtils.showMessage(this, MSG_EMPTY_FIELDS, TITLE,
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jbtSaveActionPerformed

    private void jbtCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCleanActionPerformed
        this.cleanFields();
    }//GEN-LAST:event_jbtCleanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtClean;
    private javax.swing.JButton jbtSave;
    private javax.swing.JLabel jlbName;
    @SuppressWarnings("rawtypes")
	private javax.swing.JList jlsItemConcept;
    private javax.swing.JScrollPane jspItemConcept;
    private javax.swing.JTextField jtfName;
    private javax.swing.JLabel lbImage;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel pnItemConcept;
    private javax.swing.JPanel pnItemConceptList;
    private javax.swing.JPanel pnTitle;
    // End of variables declaration//GEN-END:variables
}
