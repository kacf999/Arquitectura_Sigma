package controlador;

import java.util.UUID;

import org.springframework.stereotype.Service;

import modelo.Poliza;

@Service
public class PolizaService {

    private final PolizaRepository polizaRepository;

    // Constructor para inyectar el repositorio
    public PolizaService(PolizaRepository polizaRepository) {
        this.polizaRepository = polizaRepository;
    }

    // Obtener una póliza por su clave
    public Poliza obtenerPolizaPorClave(UUID clave) {
        return polizaRepository.findById(clave).orElse(null);
    }

    // Crear una nueva póliza
    public Poliza crearPoliza(Poliza poliza) {
        return polizaRepository.save(poliza); // Persiste la nueva póliza
    }

    // Actualizar una póliza existente
    public Poliza actualizarPoliza(UUID clave, Poliza poliza) {
        if (polizaRepository.existsById(clave)) {
            poliza.setClave(clave); // Asegúrate de usar la misma clave
            return polizaRepository.save(poliza); // Guarda la póliza actualizada
        } else {
            return null; // Si no existe, retorna null
        }
    }

    // Eliminar una póliza por su clave
    public boolean borrarPoliza(UUID clave) {
        if (polizaRepository.existsById(clave)) {
            polizaRepository.deleteById(clave); // Elimina la póliza
            return true;
        } else {
            return false; // Si no existe, retorna false
        }
    }
}
