package br.com.ferias.dao;

import br.com.ferias.jdbc.ConnectionFactory;
import br.com.ferias.model.Funcionario;
import br.com.ferias.model.WebServiceCep;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class FuncionarioDAO {

    private Connection con;

    public FuncionarioDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void salvarFuncionario(Funcionario func) {
        try {
            String sql = "INSERT into tb_funcionarios(nome, rg, cpf, email, senha, cargo, nivel_acesso, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado)"
                    + " values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário : \n" + e);
        }
    }

    public void editarFuncionario(Funcionario func) {
        try {
            String sql = "UPDATE tb_funcionarios set nome=?, rg=?, cpf=?, email=?, senha=?, cargo=?, nivel_acesso=?, telefone=?, celular=?, cep=?, endereco=?,"
                    + " numero=?, complemento=?, bairro=?, cidade=?, estado=?" + " WHERE id = ?";
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

            stmt.setInt(17, func.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Funcionário editado com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha na edição do funcionário: \n" + e);
        }
    }

    public void deletarFuncionario(Funcionario func) {
        try {
            String sql = "DELETE FROM tb_funcionarios WHERE id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, func.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Funcionário deletado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar Funcionário: \n" + e);
        }
    }

    public List<Funcionario> listarFuncionarios() {
        try {
            List<Funcionario> funcionarios = new ArrayList<>();

            String sql = "SELECT * FROM tb_funcionarios";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario func = new Funcionario();
                func.setId(rs.getInt("id"));
                func.setNome(rs.getString("nome"));
                func.setRg(rs.getString("rg"));
                func.setCpf(rs.getString("cpf"));
                func.setEmail(rs.getString("email"));
                func.setSenha(rs.getString("senha"));
                func.setCargo(rs.getString("cargo"));
                func.setNivelAcesso(rs.getString("nivel_acesso"));
                func.setTelefone(rs.getString("telefone"));
                func.setCelular(rs.getString("celular"));
                func.setCep(rs.getString("cep"));
                func.setEndereco(rs.getString("endereco"));
                func.setNumero(rs.getInt("numero"));
                func.setComplemento(rs.getString("complemento"));
                func.setBairro(rs.getString("bairro"));
                func.setCidade(rs.getString("cidade"));
                func.setEstado(rs.getString("estado"));

                funcionarios.add(func);
            }

            return funcionarios;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao listar: \n" + e);
            return null;
        }
    }

    public List<Funcionario> buscarFuncionarioNome(String nome) {
        try {
            List<Funcionario> funcionarios = new ArrayList<>();

            String sql = "SELECT * FROM tb_funcionarios WHERE nome LIKE ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario func = new Funcionario();
                func.setId(rs.getInt("id"));
                func.setNome(rs.getString("nome"));
                func.setRg(rs.getString("rg"));
                func.setCpf(rs.getString("cpf"));
                func.setEmail(rs.getString("email"));
                func.setSenha(rs.getString("senha"));
                func.setCargo(rs.getString("cargo"));
                func.setNivelAcesso(rs.getString("nivel_acesso"));
                func.setTelefone(rs.getString("telefone"));
                func.setCelular(rs.getString("celular"));
                func.setCep(rs.getString("cep"));
                func.setEndereco(rs.getString("endereco"));
                func.setNumero(rs.getInt("numero"));
                func.setComplemento(rs.getString("complemento"));
                func.setBairro(rs.getString("bairro"));
                func.setCidade(rs.getString("cidade"));
                func.setEstado(rs.getString("estado"));

                funcionarios.add(func);
            }

            return funcionarios;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na consulta: \n" + e);
            return null;
        }
    }
    
    public Funcionario consultarFuncionario(String cpf){
        try {
            
            String sql = "SELECT * FROM tb_funcionarios WHERE cpf = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            
            ResultSet rs = stmt.executeQuery();
            
            Funcionario func = new Funcionario();
            
            if (rs.next()) {
                func.setId(rs.getInt("id"));
                func.setNome(rs.getString("nome"));
                func.setRg(rs.getString("rg"));
                func.setCpf(rs.getString("cpf"));
                func.setEmail(rs.getString("email"));
                func.setSenha(rs.getString("senha"));
                func.setCargo(rs.getString("cargo"));
                func.setNivelAcesso(rs.getString("nivel_acesso"));
                func.setTelefone(rs.getString("telefone"));
                func.setCelular(rs.getString("celular"));
                func.setCep(rs.getString("cep"));
                func.setEndereco(rs.getString("endereco"));
                func.setNumero(rs.getInt("numero"));
                func.setComplemento(rs.getString("complemento"));
                func.setBairro(rs.getString("bairro"));
                func.setCidade(rs.getString("cidade"));
                func.setEstado(rs.getString("estado"));
            }
            
            return func;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a pesquisa: \n"+e);
            return null;
        }
    }
    
    public Funcionario buscaCep(String cep) {
       
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
       

        Funcionario func = new Funcionario();

        if (webServiceCep.wasSuccessful()) {
            func.setEndereco(webServiceCep.getLogradouroFull());
            func.setCidade(webServiceCep.getCidade());
            func.setBairro(webServiceCep.getBairro());
            func.setEstado(webServiceCep.getUf());
            return func;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            return null;
        }

    }
    
}
