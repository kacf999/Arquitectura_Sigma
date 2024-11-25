package controlador;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import modelo.Poliza;

@RestController
@RequestMapping("/api/polizas")
public class PolizaControlador {

	    private final PolizaServicio polizaService;

	    // Constructor para inyectar el servicio
	    public PolizaControlador(PolizaServicio polizaService) {
	        this.polizaService = polizaService;
	    }

	    // Obtener una póliza por su clave
	    @GetMapping("/{clave}")
	    public ResponseEntity<Poliza> obtenerPoliza(@PathVariable UUID clave) {
	        Poliza poliza = polizaService.obtenerPolizaPorClave(clave);
	        if (poliza != null) {
	            return ResponseEntity.ok(poliza); // Devuelve la póliza en JSON
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Si no existe, error 404
	        }
	    }

	    // Crear una nueva póliza
	    @PostMapping
	    public ResponseEntity<Poliza> crearPoliza(@RequestBody Poliza poliza) {
	        Poliza nuevaPoliza = polizaService.crearPoliza(poliza);
	        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPoliza); // Devuelve la nueva póliza con código 201
	    }

	    // Actualizar una póliza existente
	    @PutMapping("/{clave}")
	    public ResponseEntity<Poliza> actualizarPoliza(@PathVariable UUID clave, @RequestBody Poliza poliza) {
	        Poliza polizaActualizada = polizaService.actualizarPoliza(clave, poliza);
	        if (polizaActualizada != null) {
	            return ResponseEntity.ok(polizaActualizada); // Devuelve la póliza actualizada
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Si no existe, error 404
	        }
	    }

	    // Eliminar una póliza
	    @DeleteMapping("/{clave}")
	    public ResponseEntity<String> borrarPoliza(@PathVariable UUID clave) {
	        boolean eliminada = polizaService.borrarPoliza(clave);
	        if (eliminada) {
	            return ResponseEntity.ok("Póliza eliminada con clave: " + clave);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la póliza con clave: " + clave);
	        }
	    }
}

