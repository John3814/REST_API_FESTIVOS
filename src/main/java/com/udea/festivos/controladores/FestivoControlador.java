package com.udea.festivos.controladores;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udea.festivos.interfaces.IFestivoServicio;

@RestController
@RequestMapping("/festivos")
@CrossOrigin("*")
public class FestivoControlador {

    private IFestivoServicio servicio;

    public FestivoControlador(IFestivoServicio servicio) {
        this.servicio = servicio;
    }

    /**
     * Método para verificar si una fecha es válida y si es un día festivo.
     *
     * @param año Año de la fecha a verificar.
     * @param mes Mes de la fecha a verificar.
     * @param dia Día de la fecha a verificar.
     * @return ResponseEntity con el mensaje "Es festivo" si la fecha es válida y es
     *         un día festivo,
     *         "No es Festivo" si la fecha es válida y no es un día festivo,
     *         o "Fecha no valida" si la fecha no es válida.
     */
    @GetMapping("/verificar/{año}/{mes}/{dia}")
    public ResponseEntity<String> verificar(@PathVariable Integer año, @PathVariable Integer mes,
            @PathVariable Integer dia) {
        String fecha = año.toString() + "-" + mes.toString() + "-" + dia.toString();
        if (this.servicio.esFechaValida(fecha)) {
            String mensaje = this.servicio.esFestivo(new Date(año - 1900, mes - 1, dia)) ? "Es festivo"
                    : "No es Festivo";
            return ResponseEntity.ok().body(mensaje);
        }
        return ResponseEntity.badRequest().body("Fecha no valida");
    }

}
