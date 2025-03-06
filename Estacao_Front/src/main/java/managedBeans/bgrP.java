package managedBeans;

import DAL.EstacaoDAO;
import Modelo.clima;

import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

@Named(value = "bgrP")
@RequestScoped
public class bgrP {
    
    private String id;
    private String temperatura;
    private String umidade;
    private String chuva;
    private String mensagem;
    private String valorTemperatura;
    private String valorUmidade;
    private String valorChuva;
    private String diaDaSemana;
    
    public bgrP() 
    {
      
    }

    public void pesquisarPorClima()
    {
        EstacaoDAO estacaoDAO = new EstacaoDAO();
        clima pesquisar = estacaoDAO.Pesquisar(); //Cria um objeto com o mesmo nome do metodo de pegar os dados
        
        if (pesquisar != null) //Ele vai dizer para sempre atualizar o conteudo da tela, buscando os novos dados
        { 
            this.temperatura = pesquisar.getTemperatura();
            this.umidade = pesquisar.getUmidade();
            this.chuva = pesquisar.getChuva();
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask(){
                @Override
                public void run(){
                    pesquisarPorClima();
                }
            },1000,1000);
            
        }
        
    }
public String getImagem() //metodo para modificar o icone dependendo da temperatura, umidade e precipitação
{ 
    int valorTemperatura = 0;
    int valorUmidade = 0;
    int valorChuva = 0;
 
    try 
    { 
       valorTemperatura = Integer.parseInt(temperatura);
       valorUmidade = Integer.parseInt(umidade);
       valorChuva = Integer.parseInt(umidade);
    } 
    catch (NumberFormatException e) 
    { 
    valorTemperatura = -1; 
// ou qualquer outro valor que indique um erro 
    } 
    if (valorTemperatura >= 0 && valorTemperatura <= 22 && valorUmidade <= 40) 
    { 
        return "img/cloud-moon.png";
    } 
        if (valorTemperatura >= 16 && valorTemperatura <= 23)
    { 
        return "img/cloud-sun.png";
    }
        if(valorTemperatura <= 20 && valorChuva >=1000 && valorUmidade >= 65)
        {
            return "img/rain.png";
        }
        if(valorTemperatura >= 23 && valorChuva <=999 && valorUmidade <= 60)
        {
            return "img/sun.png";
        }

            return "img/icon.png";

}
  public String getImagemDeFundo() //pega os dados e modifica a imagem de Background, dependendo dos dados
  { 
    int valorTemperatura = 0;
    int valorUmidade = 0;
    int valorChuva = 0;
 
    try 
    { 
       valorTemperatura = Integer.parseInt(temperatura); //transforma String em Int para modificar os dados
       valorUmidade = Integer.parseInt(umidade);
       valorChuva = Integer.parseInt(chuva);
    } 
    catch (NumberFormatException e) 
    { 
    valorTemperatura = -1;
// ou qualquer outro valor que indique um erro 
    } 
    if(valorTemperatura >=0 && valorTemperatura <= 16)
    {
       return "img/chovendo.gif";      
    }
 //Cor de fundo quando o valor está entre 0 e 15    
    if(valorTemperatura >=17 && valorTemperatura <= 22)
    {
       return "img/fresco.gif";      
    }
        return "img/praia.gif";
// img de fundo quando o valor está fora do intervalo 
} 

     public String getDiaDaSemana() 
     { 
         LocalDate hoje = LocalDate.now();  //localizar a data de hoje
         this.diaDaSemana = hoje.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));
         //esse codigo traz que dia da semana estamos, utilizando uma biblioteca do Java para verificar qual o dia da semana no Brasil
         return diaDaSemana; 
     }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getUmidade() {
        return umidade;
    }

    public void setUmidade(String umidade) {
        this.umidade = umidade;
    }

    public String getChuva() {
        return chuva;
    }

    public void setChuva(String chuva) {
        this.chuva = chuva;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getValorTemperatura() {
        return valorTemperatura;
    }

    public void setValorTemperatura(String valorTemperatura) {
        this.valorTemperatura = valorTemperatura;
    }

    public String getValorUmidade() {
        return valorUmidade;
    }

    public void setValorUmidade(String valorUmidade) {
        this.valorUmidade = valorUmidade;
    }

    public String getValorChuva() {
        return valorChuva;
    }

    public void setValorChuva(String valorChuva) {
        this.valorChuva = valorChuva;
    }







    
}
