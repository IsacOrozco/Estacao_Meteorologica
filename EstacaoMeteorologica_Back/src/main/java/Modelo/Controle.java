package Modelo;

import DAL.DadosDAO;
import java.util.List;

public class Controle
{
    public String mensagem;
    
    public void cadastrarSerial(List<String> listaDadosSerial)
    {
        this.mensagem = "";        
        Validacao validacao = new Validacao();
        validacao.validarDadosSerial(listaDadosSerial);
        this.mensagem = validacao.mensagem;
        if (this.mensagem.equals(""))
        {
            Dados dados = new Dados();
            
            dados.setId(0);
            dados.setTemperatura(listaDadosSerial.get(1));
            dados.setUmidade(listaDadosSerial.get(2));
            dados.setChuva(listaDadosSerial.get(3));
            dados.setData_afericao(Estaticos.data_afericao);
            
            DadosDAO dadosDAO = new DadosDAO();
            dadosDAO.cadastrarSerial(dados);
            this.mensagem = dadosDAO.mensagem;
        }
        else
        {
            this.mensagem = validacao.mensagem;
        }
    }
}




