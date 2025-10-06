package br.com.leiloes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListagemVIEW extends JFrame {
    private JTable table;
    private ProdutoDAO dao = new ProdutoDAO();

    public ListagemVIEW() {
        super("Listagem de Produtos");
        setSize(600,350);
        setLocationRelativeTo(null);
        initComponents();
        loadData();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        table = new JTable();
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void loadData() {
        List<Produto> lista = dao.listarTodos();
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID","Nome","Valor","Status"}, 0) {
            public boolean isCellEditable(int row, int col) { return false; }
        };
        for (Produto p : lista) {
            model.addRow(new Object[]{
                    p.getId(),
                    p.getNome(),
                    p.getValor(),
                    p.getStatus()
            });
        }
        table.setModel(model);
    }
}
