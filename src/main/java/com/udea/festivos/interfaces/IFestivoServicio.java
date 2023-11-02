package com.udea.festivos.interfaces;

import java.util.Date;
import java.util.List;

import com.udea.festivos.entidades.dtos.FestivoDto;

public interface IFestivoServicio {
    public List<FestivoDto> obtenerFestivos(int año);
    public boolean esFestivo(Date fecha);
    public boolean esFechaValida(String strFecha);
}
