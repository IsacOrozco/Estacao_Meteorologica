package DAL;

import Modelo.Dados;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DadosDAO
{
    public String mensagem;
    Session session = HibernateUtil.getSessionFactory().openSession();
    
    public void cadastrarSerial(Dados dados)
    {
        this.mensagem = "";
        dados.setId(null);
        try
        {
            System.out.print(dados);
            Transaction transaction = session.beginTransaction();
            session.persist(dados);
            transaction.commit();
            this.mensagem = "Dados cadastrados !!!!!!";
        }
        catch (Exception e)
        {
            this.mensagem = "Erro no cadastro " + HibernateUtil.mensagem + e.getMessage();
        }
    }
}
