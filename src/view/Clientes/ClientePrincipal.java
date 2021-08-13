/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Clientes;

import static Util.coalesce.coalesce;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import Util.Mascara;
import Util.ValidaNumeros;
import Util.data;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;


/**
 *
 * @author Jonas Santos
 */
public class ClientePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form ClientePrincipal
     */
    public ClientePrincipal() {
        initComponents();
        TableColumnModel modeltable = grid.getColumnModel();
        modeltable.getColumn(0).setPreferredWidth(50);
        modeltable.getColumn(1).setPreferredWidth(200);
        modeltable.getColumn(2).setPreferredWidth(130);
        modeltable.getColumn(3).setPreferredWidth(100);
        modeltable.getColumn(4).setPreferredWidth(240);
        modeltable.getColumn(5).setPreferredWidth(150);
        modeltable.getColumn(6).setPreferredWidth(150);
        modeltable.getColumn(7).setPreferredWidth(150);
        modeltable.getColumn(8).setPreferredWidth(150);
        txtCodigo.setDocument(new ValidaNumeros());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitulo = new javax.swing.JLabel();
        lbCodigo1 = new javax.swing.JLabel();
        lbCodigo2 = new javax.swing.JLabel();
        lbCodigo3 = new javax.swing.JLabel();
        lbCodigo4 = new javax.swing.JLabel();
        lbCodigo5 = new javax.swing.JLabel();
        lbLenlist = new javax.swing.JLabel();
        txtLimite = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btAlterar = new javax.swing.JButton();
        btIncluir = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        grid = new javax.swing.JTable();
        lbCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtCPF = new javax.swing.JFormattedTextField();
        txtRG = new javax.swing.JFormattedTextField();
        btLimpar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbPainelBotoes = new javax.swing.JLabel();
        lbmenu = new javax.swing.JLabel();
        lbfundo = new javax.swing.JLabel();
        lbimagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTitulo.setBackground(new java.awt.Color(0, 0, 0));
        lbTitulo.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("Clientes");
        lbTitulo.setOpaque(true);
        getContentPane().add(lbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 690, 50));

        lbCodigo1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lbCodigo1.setForeground(new java.awt.Color(255, 255, 255));
        lbCodigo1.setText("CPF");
        getContentPane().add(lbCodigo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        lbCodigo2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lbCodigo2.setForeground(new java.awt.Color(255, 255, 255));
        lbCodigo2.setText("RG");
        getContentPane().add(lbCodigo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, 40));

        lbCodigo3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lbCodigo3.setForeground(new java.awt.Color(255, 255, 255));
        lbCodigo3.setText("Nome");
        getContentPane().add(lbCodigo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        lbCodigo4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lbCodigo4.setForeground(new java.awt.Color(255, 255, 255));
        lbCodigo4.setText("Limite");
        getContentPane().add(lbCodigo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, -1, -1));

        lbCodigo5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lbCodigo5.setForeground(new java.awt.Color(255, 255, 255));
        lbCodigo5.setText("E-mail");
        getContentPane().add(lbCodigo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        lbLenlist.setForeground(new java.awt.Color(255, 255, 255));
        lbLenlist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbLenlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 220, 30));

        txtLimite.setText("500");
        getContentPane().add(txtLimite, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 220, -1));

        txtNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomeFocusLost(evt);
            }
        });
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 220, -1));

        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 220, -1));

        btAlterar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btAlterar.setForeground(new java.awt.Color(255, 255, 255));
        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/botaoefetivar5.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.setToolTipText("");
        btAlterar.setBorderPainted(false);
        btAlterar.setContentAreaFilled(false);
        btAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 550, -1, 50));

        btIncluir.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btIncluir.setForeground(new java.awt.Color(255, 255, 255));
        btIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/botaoefetivar5.png"))); // NOI18N
        btIncluir.setText("Incluir");
        btIncluir.setToolTipText("");
        btIncluir.setBorderPainted(false);
        btIncluir.setContentAreaFilled(false);
        btIncluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncluirActionPerformed(evt);
            }
        });
        getContentPane().add(btIncluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 550, 140, 50));

        btCancelar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/botaocancelar6.png"))); // NOI18N
        btCancelar.setText("Fechar");
        btCancelar.setToolTipText("");
        btCancelar.setBorderPainted(false);
        btCancelar.setContentAreaFilled(false);
        btCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 550, 140, 50));

        btExcluir.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/botaocancelar6.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setToolTipText("");
        btExcluir.setBorderPainted(false);
        btExcluir.setContentAreaFilled(false);
        btExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 550, 150, 50));

        btPesquisar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/botaoefetivar5.png"))); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.setToolTipText("");
        btPesquisar.setBorderPainted(false);
        btPesquisar.setContentAreaFilled(false);
        btPesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 550, 130, 50));

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jScrollPane1.setOpaque(false);

        grid.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        grid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "CPF", "RG", "Endereço", "E-mail", "Celular", "Data Alteracao", "Data Cadastro", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grid.setToolTipText("");
        grid.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        grid.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        grid.setGridColor(new java.awt.Color(239, 239, 239));
        grid.setName(""); // NOI18N
        grid.setSelectionBackground(new java.awt.Color(216, 216, 216));
        grid.setSelectionForeground(new java.awt.Color(61, 61, 61));
        grid.setShowHorizontalLines(false);
        grid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gridMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(grid);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 690, 440));

        lbCodigo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lbCodigo.setForeground(new java.awt.Color(255, 255, 255));
        lbCodigo.setText("Código");
        getContentPane().add(lbCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 220, -1));

        txtCPF.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCPF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCPFFocusGained(evt);
            }
        });
        getContentPane().add(txtCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 220, -1));

        txtRG.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRGFocusGained(evt);
            }
        });
        getContentPane().add(txtRG, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 220, -1));

        btLimpar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btLimpar.setForeground(new java.awt.Color(255, 255, 255));
        btLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/botaoefetivar5.png"))); // NOI18N
        btLimpar.setText("Limpar");
        btLimpar.setToolTipText("");
        btLimpar.setBorderPainted(false);
        btLimpar.setContentAreaFilled(false);
        btLimpar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 280, 90));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Filtros");
        jLabel1.setMaximumSize(new java.awt.Dimension(58, 30));
        jLabel1.setMinimumSize(new java.awt.Dimension(58, 30));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(58, 30));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 279, 50));

        lbPainelBotoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPainelBotoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ClientePrincipal_fundo.png"))); // NOI18N
        lbPainelBotoes.setToolTipText("");
        getContentPane().add(lbPainelBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 550, 670, 50));

        lbmenu.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        lbmenu.setForeground(new java.awt.Color(255, 255, 255));
        lbmenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/menuClientePrincipal_fundo.png"))); // NOI18N
        lbmenu.setText("Filtros");
        getContentPane().add(lbmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 300, 540));

        lbfundo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbfundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ClientePrincipal_fundo.png"))); // NOI18N
        getContentPane().add(lbfundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 690, 540));

        lbimagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbimagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/FundoTelaInicial.jpg"))); // NOI18N
        getContentPane().add(lbimagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, -1));

        setSize(new java.awt.Dimension(1020, 675));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    String lenlist;
    
    
    private void btIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIncluirActionPerformed
        IncluirCliente incluir = new IncluirCliente();
        incluir.setVisible(true);
    }//GEN-LAST:event_btIncluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        try{
            Object obj= grid.getValueAt(grid.getSelectedRow(),0);
            AlterarCliente alterar;
            alterar = new AlterarCliente(obj.toString());
            alterar.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Selecione o registro que deseja alterar");
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        int codigo;
        if (txtCodigo.getText().equals("")){
            codigo=0;
        }else{
            codigo = Integer.parseInt(txtCodigo.getText());
        }
        
        String nome= txtNome.getText();
        String cpf= txtCPF.getText();
        String rg=txtRG.getText();
        String email=txtEmail.getText();
        String limite = txtLimite.getText();
        Cliente select = new Cliente(codigo,nome,cpf,rg,email);
        DefaultTableModel modelo = (DefaultTableModel) grid.getModel();
        modelo.setNumRows(0);

        centralizar(grid,0);
        centralizar(grid,1);
        centralizar(grid,2);
        centralizar(grid,3);
        centralizar(grid,4);
        centralizar(grid,5);
        centralizar(grid,6);
        centralizar(grid,7);
        centralizar(grid,8);
        
        if (limite.equals("0") || limite.isEmpty()){
                limite="9999999";
        }else{
            limite=limite;
        }
        try {
            select.selectnoFilter(select, limite);
        } catch (SQLException ex) {
            Logger.getLogger(ClientePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            
            List<Cliente> listagem = select.getResultselect();
            lenlist=String.valueOf(listagem.size());
            for (Cliente cli : listagem) {
                String codigoformat;
                String dataformat;
                codigoformat=String.valueOf(cli.getCodigo());         
                modelo.addRow(new Object[]{codigoformat,cli.getNome(),cli.getCPF(),cli.getRG(),cli.getEndereco(),cli.getEmail(),cli.getCelular(),data.formataDataBD(cli.getData_alteracao()),data.formataDataBD(cli.getData())});
               
            }
            if(lenlist.equals("1")){
                lbLenlist.setText("A pesquisa retornou "+ lenlist+" registro");
            }else{
                lbLenlist.setText("A pesquisa retornou "+lenlist+" registros");
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao listar clientes, contate o suporte técnico");
        }
    }//GEN-LAST:event_btPesquisarActionPerformed
    
    private void txtNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusLost
        String minuscula= txtNome.getText();
        txtNome.setText(minuscula.toUpperCase());
    }//GEN-LAST:event_txtNomeFocusLost

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        String minuscula= txtEmail.getText();
        txtEmail.setText(minuscula.toUpperCase());
    }//GEN-LAST:event_txtEmailFocusLost

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        txtCPF.setFormatterFactory(Mascara.cleanMak());
        txtRG.setFormatterFactory(Mascara.cleanMak());
        txtNome.setText("");
        txtEmail.setText("");
        txtCodigo.setText("");
        
    }//GEN-LAST:event_btLimparActionPerformed

    private void gridMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridMouseClicked
        if(evt.getClickCount() == 2){
            Object obj= grid.getValueAt(grid.getSelectedRow(),0);
            AlterarCliente alterar;
            alterar = new AlterarCliente(obj.toString());
            alterar.setVisible(true);
            
        }
    }//GEN-LAST:event_gridMouseClicked

    private void txtCPFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCPFFocusGained
        txtCPF.setFormatterFactory(Mascara.getCpfMask());
    }//GEN-LAST:event_txtCPFFocusGained

    private void txtRGFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRGFocusGained
        txtRG.setFormatterFactory(Mascara.getRgMask());
    }//GEN-LAST:event_txtRGFocusGained

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        try{
            String codClienteSelecionado= grid.getValueAt(grid.getSelectedRow(),0).toString();
            String nomeClienteSelecionado= grid.getValueAt(grid.getSelectedRow(),1).toString();
            int confirmacao= JOptionPane.showConfirmDialog(null, "Deseja excluir o cliente selecionado ? \n Cliente: "+codClienteSelecionado+" | "+nomeClienteSelecionado, "**** Atenção ****",1);
            
            if (confirmacao==0){
                int cod=Integer.parseInt(codClienteSelecionado);
                Cliente excluirCliente = new Cliente(cod,nomeClienteSelecionado);
                excluirCliente.apagar(excluirCliente);
            }
            btPesquisar.doClick();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Selecione o cliente que deseja excluir !");
            ex.printStackTrace();
            }
    }//GEN-LAST:event_btExcluirActionPerformed
    private static void centralizar(JTable table, int column) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(column).setCellRenderer(centerRenderer);
    }
    
 
    /* * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(ClientePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btIncluir;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JTable grid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbCodigo1;
    private javax.swing.JLabel lbCodigo2;
    private javax.swing.JLabel lbCodigo3;
    private javax.swing.JLabel lbCodigo4;
    private javax.swing.JLabel lbCodigo5;
    private javax.swing.JLabel lbLenlist;
    private javax.swing.JLabel lbPainelBotoes;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbfundo;
    private javax.swing.JLabel lbimagem;
    private javax.swing.JLabel lbmenu;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLimite;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtRG;
    // End of variables declaration//GEN-END:variables
}
