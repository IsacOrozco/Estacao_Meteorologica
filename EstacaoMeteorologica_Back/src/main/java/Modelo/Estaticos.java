package Modelo;

import java.time.LocalDateTime;
public class Estaticos
{
    //variavel estatica para definir se a thread esta ou não ativa
    public static Boolean coletaSerial = false;
    //variaveis coletadas pelo arduino
    public static String temperatura;
    public static String umidade;
    public static String chuva;
    //variavel adicionada para controle dos dados no banco
    //adiciona a data atual ao banco
    public static LocalDateTime data_afericao = LocalDateTime.now();
}



