/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancoandfilmes.models.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author Williams Bruce
 */
public class CriarConexao {
    private String servidor, base, login, senha;

    public CriarConexao() {
        this.servidor = "localhost";
        this.base = "nvd";
        this.login = "root";
        this.senha = "rootroot";
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
    public Connection conexao() throws SQLException {
        Connection conexao = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = (Connection) DriverManager.getConnection("jdbc:mysql://"+getServidor()+
                "/"+getBase(),getLogin(),getSenha());
        }
        catch(ClassNotFoundException ex){
            System.out.println("Driver do banco de dados não localizado.");
        }
        catch(SQLException ex){
            System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
        }
        
        return conexao;
    }
}
