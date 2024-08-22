package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class FabricaDeConexoes {
    // Design Patterns / Padrões de Projetos
    // Factory / Fabrica
    // Singleton / Unico
    private static FabricaDeConexoes instancia;
    private FabricaDeConexoes(){}

    public synchronized final static  FabricaDeConexoes getInstancia(){
        if(instancia == null){
            instancia = new FabricaDeConexoes();
        }
        return instancia;
    }

    public Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:meu_banco.db";
        Connection con = DriverManager.getConnection(url);
        return con;
    }

}
