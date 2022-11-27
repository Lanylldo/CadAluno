/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cliente.dao;

import br.com.cliente.bean.Cliente;
import br.com.cliente.util.Conector;
import br.com.cliente.util.Dao;
import java.util.List;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lanylldo
 */
public class ClienteDao implements Dao{

    @Override
    public void insert(Object arg0) {
        Cliente c = (Cliente) arg0;
        String sql;
        sql = "insert into clientes (nome,endereco,municipio,cep,tel,cel,cpf,cnpj,genero) values (?,?,?,?,?,?,?,?,?)";
        
        try {
           // PreparedStatement ps = Conector.getConexao().prepareStatement(sql);
            PreparedStatement ps = Conector.getConexao().prepareStatement(sql);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getEndereco());
            ps.setString(3, c.getMunicipio());
            ps.setString(4, c.getCep());
            ps.setString(5, c.getTel());
            ps.setString(6, c.getCel());
            ps.setString(7, c.getCpf());
            ps.setString(8, c.getCnpj());
            ps.setString(9, c.getGenero());
            
            ps.execute();
        } catch(SQLException e){
            
            e.printStackTrace();
        }
    }

    @Override
    public void update(Object arg0) {
        Cliente c = (Cliente)arg0;
        String sql = "update clientes set nome=?,endereco=?,municipio=?,cep=?,tel=?,cel=?,cpf=?,cnpj=?,genero=? where id=?";
        try{
            PreparedStatement ps = Conector.getConexao().prepareStatement(sql);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getEndereco());
            ps.setString(3, c.getMunicipio());
            ps.setString(4, c.getCep());
            ps.setString(5, c.getTel());
            ps.setString(6, c.getCel());
            ps.setString(7, c.getCpf());
            ps.setString(8, c.getCnpj());
            ps.setString(9, c.getGenero());
            ps.setInt(10, c.getId());
            
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    @Override
    public void delete(Object arg0) {
        
        Cliente c = (Cliente) arg0;
        String sql = "delete from clientes where id=?";
        
        try {
            PreparedStatement ps = Conector.getConexao().prepareStatement(sql);
            
            ps.setInt(1, c.getId());
           
            ps.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    
    @Override
    public Object select(int i) {
       Cliente c = new Cliente();
       //Faz a instância da classe Cliente;
       String sql = "select * from clientes where id=?";
        //Instrução SQL para seleção de registro específico da tabela cliente, pelo id;
        try {
              PreparedStatement ps = Conector.getConexao().prepareStatement(sql);
              ResultSet rs = ps.executeQuery();
            while(rs.next()){
              //Laço de repetição para preencher com os dados do banco o objeto Cliente;
                    c.setNome(rs.getString("nome"));
                    c.setEndereco(rs.getString("endereco"));
                    c.setMunicipio(rs.getString("municipio"));
                    c.setCep(rs.getString("cep"));
                    c.setTel(rs.getString("tel"));
                    c.setCel(rs.getString("cel"));
                    c.setCpf(rs.getString("cpf"));
                    c.setCnpj(rs.getString("cnpj"));
                    c.setGenero(rs.getString("genero"));
              //"seta" os atributos da classe Cliente com os dados dos campos do banco - pega os dados do banco para pesquisa no formulário;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return c;
        
    }

    
    @Override
    public List select() {
        List list = new ArrayList();
        //Cra uma lista dos objetos da classe Cliente;
        String sql = "select * from clientes";
        //Instrução SQL para seleção de todos os registros da tabela Cliente;
        PreparedStatement ps;
   try {
            ps = Conector.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           //Executa a pesquisa da seleção SQL e atribui o resultado ao ResultSet;
           while(rs.next()){
            Cliente c = new Cliente();
            //Faz a instância da classe Cliente;
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setEndereco(rs.getString("endereco"));
            c.setMunicipio(rs.getString("municipio"));
            c.setCep(rs.getString("cep"));
            c.setTel(rs.getString("tel"));
            c.setCel(rs.getString("cel"));
            c.setCpf(rs.getString("cpf"));
            c.setCnpj(rs.getString("cnpj"));
            c.setGenero(rs.getString("genero"));
            //"seta" os atributos da classe Cliente com os dados dos campos do banco;
            list.add(c);
            //Adiciona à lista os dados do resultado do laço while;
   }
  } catch (SQLException e) {
             e.printStackTrace();
  }
  
   return list; 
        
        
 }
    
    
}
