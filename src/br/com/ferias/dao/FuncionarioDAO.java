package br.com.ferias.dao;

import br.com.ferias.jdbc.ConnectionFactory;
import br.com.ferias.model.Funcionario;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class FuncionarioDAO {
    
    private Connection con;
    
    public FuncionarioDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void salvarFuncionario(Funcionario func){
        try {
            String sql = "INSERT into tb_funcionarios(nome, rg, cpf, email, senha, cargo, nivel_acesso, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado"
                        + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, func.getNome());
            stmt.setString(2, func.getRg());
            stmt.setString(3, func.getCpf());
            stmt.setString(4, func.getEmail());
            stmt.setString(5, func.getSenha());
            stmt.setString(6, func.getCargo());
            stmt.setString(7, func.getNivelAcesso());
            stmt.setString(8, func.getTelefone());
            stmt.setString(9, func.getCelular());
            stmt.setString(10, func.getCep());
            stmt.setString(11, func.getEndereco());
            stmt.setInt(12, func.getNumero());
            stmt.setString(13, func.getComplemento());
            stmt.setString(14, func.getBairro());
            stmt.setString(15, func.getCidade());
            stmt.setString(16, func.getEstado());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário : \n"+e);
        }
    }
    
}
