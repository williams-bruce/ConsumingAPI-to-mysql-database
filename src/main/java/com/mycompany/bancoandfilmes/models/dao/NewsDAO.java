/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancoandfilmes.models.dao;

import com.mycompany.bancoandfilmes.models.bo.CriarConexao;
import com.mycompany.bancoandfilmes.models.vo.NewsMCU;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Williams Bruce
 */
public class NewsDAO {
    private final Connection banco;

    public NewsDAO() throws ClassNotFoundException, SQLException {
        CriarConexao con = new CriarConexao();
        banco = con.conexao();
    }
    
    @Override
    @SuppressWarnings("FinalizeDeclaration")
    protected void finalize() throws SQLException, Throwable {
        try{
            banco.close();
        }
        finally{
            super.finalize();
        }
    }
    
    public int inserir(NewsMCU news) throws ClassNotFoundException, SQLException {
        PreparedStatement stmt = banco.prepareStatement("INSERT INTO NEWS (days_until,"
                +"overview,poster_url,release_date,title,type) VALUES(?,?,?,?,?,?)");
        
        java.util.Date data = news.getRelease_date();
        java.sql.Date databanco = new java.sql.Date(data.getTime());
        
        stmt.setString(1, news.getDays_until());
        stmt.setString(2, news.getOverview());
        stmt.setString(3, news.getPoster_url());
        stmt.setDate(4, databanco);
        stmt.setString(5, news.getTitle());
        stmt.setString(6, news.getType());
        
        return stmt.executeUpdate();
    }
}
