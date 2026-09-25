package hilos;
import modelo.EventoUniversitario;
import modelo.Inscripcion;
import modelo.actividades.Actividad;

import java.lang.Thread;
import java.util.concurrent.ThreadFactory;

public class EnvioTicketsThread extends java.lang.Thread {
    public EventoUniversitario evento;

public EnvioTicketsThread (EventoUniversitario evento){
    super("Estamos ejecutando el hilo");
    this.evento=evento;
}

@Override
 public void run(){
    System.out.println("[" + getName() + "] Inicio del envio de ticket" );
    for (Actividad actividad : evento.getActividades()){
        for (Inscripcion inscripcion : actividad.getInscripciones()){
            if("CONFIRMADA".equals(inscripcion.getEstado())){
                inscripcion.getTicket().enviarTicket();
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    throw new RuntimeException();
                }
            }
        }
    }
    System.out.println("Fin del envío ticket");
}

}
