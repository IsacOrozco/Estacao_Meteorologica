package Modelo;


import Modelo.Estaticos;
import com.fazecast.jSerialComm.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.IOException;
import java.io.InputStream;


@Entity
@Table(name = "Dados")


public class Serial implements Runnable
{
        
    @Override
    public void run()
    {
        executar();
    }
    
    public void executar()
    {
        String leitura = "";
        String[] valores = new String[3];
        SerialPort comPort = SerialPort.getCommPort("COM3");
        comPort.openPort();
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        InputStream in = comPort.getInputStream();
        
        try
        {
            while (Estaticos.coletaSerial)
            {
                leitura += (char) in.read();
                if (leitura.charAt(leitura.length()-1) == '\n')
                {
                    valores = leitura.split(",");
                    System.out.print(valores[0] + " - " + valores [1] + " - " + valores[2]);
                    Estaticos.umidade = valores[0];
                    Estaticos.temperatura = valores[1];
                    Estaticos.chuva = valores[2];
                    leitura = "";
                }
            }
        }
        catch (IOException e)
        {
        }
        comPort.closePort();
    }

    

}
