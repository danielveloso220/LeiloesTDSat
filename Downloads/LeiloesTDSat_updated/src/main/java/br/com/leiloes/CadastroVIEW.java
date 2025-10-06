package br.com.leiloes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroVIEW extends JFrame {
    private JTextField tfNome;
    private JTextField tfValor;
    private JComboBox<String> cbStatus;
    private ProdutoDAO dao = new ProdutoDAO();

    public CadastroVIEW() {
        super("Cadastro de Produtos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420,260);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20,20,80,25);
        panel.add(lblNome);

        tfNome = new JTextField();
        tfNome.setBounds(100,20,280,25);
        panel.add(tfNome);

        JLabel lblValor = new JLabel("Valor:");
        lblValor.setBounds(20,60,80,25);
        panel.add(lblValor);

        tfValor = new JTextField();
        tfValor.setBounds(100,60,280,25);
        panel.add(tfValor);

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setBounds(20,100,80,25);
        panel.add(lblStatus);

        cbStatus = new JComboBox<>(new String[] {"A Venda", "Vendido", "Reservado"});
        cbStatus.setBounds(100,100,150,25);
        panel.add(cbStatus);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(100,150,100,30);
        panel.add(btnSalvar);

        JButton btnListar = new JButton("Listar Itens");
        btnListar.setBounds(220,150,160,30);
        panel.add(btnListar);

        getContentPane().add(panel);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarProduto();
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListagemVIEW lv = new ListagemVIEW();
                lv.setVisible(true);
            }
        });
    }

    private void salvarProduto() {
        String nome = tfNome.getText().trim();
        String valorStr = tfValor.getText().trim();
        String status = (String) cbStatus.getSelectedItem();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o nome do produto.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Integer valor = null;
        if (!valorStr.isEmpty()) {
            try {
                valor = Integer.parseInt(valorStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Valor inválido. Informe um número inteiro.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        Produto p = new Produto();
        p.setNome(nome);
        p.setValor(valor);
        p.setStatus(status);

        boolean ok = dao.salvar(p);
        if (ok) {
            JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            // limpar
            tfNome.setText("");
            tfValor.setText("");
            cbStatus.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar. Verifique a conexão com o banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Ensure CadastroVIEW is the initial/main screen
        SwingUtilities.invokeLater(() -> {
            CadastroVIEW cv = new CadastroVIEW();
            cv.setVisible(true);
        });
    }
}
