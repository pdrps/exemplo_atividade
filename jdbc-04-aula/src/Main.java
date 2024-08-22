import dao.PessoaDAO;
import entity.Pessoa;

import java.sql.*;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        PessoaDAO dao = new PessoaDAO();

        Pessoa pessoa = new Pessoa();
        pessoa.setId(34);
        pessoa.setNome("Qualquer");

        dao.inserir(pessoa);

        Optional<Pessoa> opt = dao.obterPeloId(2);
        if(opt.isPresent()){
            //Pessoa pessoa = opt.get();
        }
        /*
        for(Pessoa p : dao.obterTodos()){
            System.out.println(p);
        }*/


        /*
        String url = "jdbc:sqlite:meu_banco.db";
        try{
            Connection con = DriverManager.getConnection(url);
            System.out.println("Conectou!");
            String create = """
                    create table if not exists pessoa(
                      id_pessoa integer primary key autoincrement,
                      nome varchar(250)
                    )
                    """;
            // Executa apenas uma vez
            // Não permite usar parâmetros
            Statement stat = con.createStatement();
            stat.execute(create);
            String insert = """
                    insert into pessoa(nome) values ("Tom Cruise");
                    """;
            stat = con.createStatement();
            stat.execute(insert);
            String update = """
                    update pessoa set nome = 'Tom Hakws';
                    """;
            stat = con.createStatement();
            stat.execute(update);
            String delete = """
                    delete from pessoa where id_pessoa = 2
                    """;
            stat = con.createStatement();
            stat.execute(delete);
            String insert2 = """
                    insert into pessoa(nome) values ( ? );
                    """;
            // Permite parâmetros
            // Permite reutilizar
            // Impede injeção de SQL
            PreparedStatement p = con.prepareStatement(insert2);
            // Indice começa em 1
            p.setString(1,"Johnny Depp");
            p.execute();
            p.setString(1,"Fulano de Tal");
            p.execute();
            String update2 = """
                    update pessoa set nome = ?
                    where id_pessoa = ?;
                    """;
            p = con.prepareStatement(update2);
            p.setString(1,"Robert");
            p.setInt(2,5);
            p.execute();
            String delete2 = """
                    delete from pessoa where id_pessoa = ?
                    """;
            p = con.prepareStatement(delete2);
            p.setInt(1,2);
            p.execute();
            String query = """
                    select id_pessoa
                          ,nome
                      from pessoa
                    order by nome desc
                    """;
            p = con.prepareStatement(query);
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                // Selecionado um registro da consulta
                int id = rs.getInt("id_pessoa");
                String nome = rs.getString("nome");
                System.out.println(id+" "+nome);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        */
    }
}