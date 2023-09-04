/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bancoandfilmes;

import com.mycompany.bancoandfilmes.models.vo.NewsMCU;
import com.mycompany.bancoandfilmes.models.bo.ServiceMCU;
import com.mycompany.bancoandfilmes.models.dao.NewsDAO;

/**
 *
 * @author Williams Bruce
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ServiceMCU s = new ServiceMCU();
        NewsMCU news = s.newsMCU();
        System.out.println(news.getDays_until());
        
        NewsDAO operacao = new NewsDAO();
        
        int resultado = operacao.inserir(news);
        
        System.out.println((resultado==1)?"Inseriu":"Não inseriu");
    }
}
