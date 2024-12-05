package mx.edu.uacm.is.stl.as.ws.controlador;

import java.sql.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import mx.edu.uacm.is.stl.as.ws.modelo.Poliza;

@Repository
public interface PolizaRepositorio extends JpaRepository<Poliza, UUID> {
    // Los métodos básicos (findById, save, deleteById) ya están implementados
	
	@PutMapping("/cliente/{nombres}/{primer_apellido}/{segundo_apellido}/{direccion}/{curp}/{fecha_nacimiento}")
    public default ResponseEntity<String> actualizarCliente(
            @PathVariable String nombres,
            @PathVariable String primer_apellido,
            @PathVariable(required = false) String segundo_apellido,
            @PathVariable String direccion,
            @PathVariable String curp,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha_nacimiento) {

        // Simular recepción de datos y preparación para actualizar
        System.out.println("Nombres: " + nombres);
        System.out.println("Primer Apellido: " + primer_apellido);
        System.out.println("Segundo Apellido: " + (segundo_apellido != null ? segundo_apellido : "No proporcionado"));
        System.out.println("Dirección: " + direccion);
        System.out.println("CURP: " + curp);
        System.out.println("Fecha de Nacimiento: " + fecha_nacimiento);

        // Respuesta de prueba para confirmar que está listo
        return ResponseEntity.ok("Cliente con CURP " + curp + " preparado para actualización.");
    }
}