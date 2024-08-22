package dao;

import entity.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PessoaDAO extends BaseDAO{

    public void inserir(Pessoa p){
        String sql = """
            insert into pessoa(nome) values(?);
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            pre.setString(1,p.getNome());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizar(Pessoa p){
        String sql = """
            update pessoa set nome = ? where id_pessoa = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            pre.setString(1,p.getNome());
            pre.setInt(2,p.getId());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletar(Pessoa p){
        String sql = """
            delete from pessoa where id_pessoa = ?;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            pre.setInt(1,p.getId());
            pre.execute();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Pessoa> obterTodos(){
        List<Pessoa> lista = new ArrayList<>();
        String sql = """
            select id_pessoa, nome from pessoa
            order by nome asc;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            // Recurso bem caro
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Pessoa p = new Pessoa();
                // Selecionado um registro da consulta
                p.setId(rs.getInt("id_pessoa"));
                p.setNome(rs.getString("nome"));
                lista.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

    public Optional<Pessoa> obterPeloId(int id){
        String sql = """
            select id_pessoa, nome from pessoa
            where id_pessoa = ?
            order by nome asc;
                """;
        // try - with - resources
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setInt(1,id);
            // Recurso bem caro
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                Pessoa p = new Pessoa();
                // Selecionado um registro da consulta
                p.setId(rs.getInt("id_pessoa"));
                p.setNome(rs.getString("nome"));
                return Optional.of(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
