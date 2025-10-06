package br.com.leiloes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public boolean salvar(Produto p) {
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNome());
            if (p.getValor() == null) ps.setNull(2, Types.INTEGER); else ps.setInt(2, p.getValor());
            ps.setString(3, p.getStatus());
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<Produto> listarTodos() {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT id, nome, valor, status FROM produtos";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Produto p = new Produto(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getObject("valor") == null ? null : rs.getInt("valor"),
                        rs.getString("status")
                );
                lista.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
