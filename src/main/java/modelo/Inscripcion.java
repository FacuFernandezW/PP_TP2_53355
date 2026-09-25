package modelo;

import modelo.actividades.Actividad;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase asociativa entre modelo.actividades.Actividad y Estudiantes.
 * La inscripción existe porque un estudiante se inscribe a una actividad concreta.
 * Debe notarse que esta relación tiene atributos propios que no pertenecen ni a la actividad ni al estudiante,
 * por eso es necesario modelarla como una clase independiente.
 */
public class Inscripcion implements Serializable {
    private Actividad actividad;
    private Estudiante estudiante;
    private LocalDate fecha;
    private String estado;
    private TicketDeAcceso ticket;

    public Inscripcion(Actividad actividad, Estudiante estudiante, LocalDate fecha, String estado) {
        this.actividad = actividad;
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.estado = estado;
    }

    //TICKET
    public TicketDeAcceso getTicket(){
        return ticket;

    }

    public Actividad getActividad() {
        return actividad;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void confirmar() {
        this.estado = "CONFIRMADA";
    }


    public final class TicketDeAcceso implements Serializable {
        private String idTicket;
        private LocalDate fechaEmision;

        public TicketDeAcceso(){
            this.idTicket= "TICKET-" + actividad.getId() + "-" + estudiante.getLegajo() + "-" + System.currentTimeMillis();
            this.fechaEmision=LocalDate.now();
            System.out.println("Ticket generado correctamente para la inscripción");
        }
        public void enviarTicket(){
            System.out.println("Enviando ticket "+ idTicket + "al estudiante: "+ estudiante.getNombre() + "de legajo: "+ estudiante.getLegajo());
        }
    }
}

