package Modelo;

import java.util.List;

public class Validacao
{
    public String mensagem;
    public String id;
  
    
    public void validarDadosSerial(List<String> listaDadosSerial)
    {
        this.mensagem = "";
        try
        {
            this.id = "";
            if (listaDadosSerial.get(1).length() < 1)
                this.mensagem += "Temperatura não pode ser nula \n";
            if (listaDadosSerial.get(2).length() < 1)
                this.mensagem += "Umidade não pode ser nula \n";
            if (listaDadosSerial.get(3).length() < 1)
                this.mensagem += "Chuva não pode ser nula \n";
            
        } catch (Exception e)
        {
            this.mensagem += "Erro validacao";
        }
    }
    
}
