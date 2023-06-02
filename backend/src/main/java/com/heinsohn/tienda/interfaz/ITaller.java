package com.heinsohn.tienda.interfaz;

import com.heinsohn.tienda.model.Comic;

import java.util.List;

public interface ITaller {

    List<Comic> metodoExeption(List<Comic> comics) throws Exception;
}
