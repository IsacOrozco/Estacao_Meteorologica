package DAL;

import Modelo.clima;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class EstacaoDAO {
    
    public String mensagem;
    Session session = HibernateUtil.getSessionFactory().openSession();

      public clima Pesquisar()
    {
        
        this.mensagem = "";
        clima pesquisar = null;

        try 
        {
            Query<clima> query = session.createQuery("from clima c order by c.id desc", clima.class);
            //Carrega na lista os dados que foram pegos no banco de dados, utilizando a classe de persistencia Clima
            query.setMaxResults(1);
            //seta que é para aparecer apenas um dado por vez
            pesquisar = query.uniqueResult();
            //guarda o dado pego pelo objeto query e coloca dentro do objeto pesquisar
            if (pesquisar == null) {
                this.mensagem = "Nenhum registro encontrado";
            }
        } catch (Exception e) {
            this.mensagem = "Erro ao buscar o último registro: " + e.getMessage();
        }

        return pesquisar;
        
    }

}