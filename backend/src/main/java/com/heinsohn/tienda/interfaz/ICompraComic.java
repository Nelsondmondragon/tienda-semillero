package com.heinsohn.tienda.interfaz;

import com.heinsohn.tienda.exception.CompraComicException;

public interface ICompraComic {

    String comprarComic(Long idComic, Integer cantidad) throws CompraComicException;

}
