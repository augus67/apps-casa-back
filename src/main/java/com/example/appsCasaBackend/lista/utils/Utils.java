package com.example.appsCasaBackend.lista.utils;

import java.util.Collection;

public class Utils {
	
	/**
	 * Comprobación null-safe de si la colección especificada está vacía.
	 * <p>
	 * Null devuelve true.
	 * </p>
	 *
	 * @param coll - la colección a comprobar, puede ser null
	 * @return true is está vacía o es nula
	 */
	public static boolean isEmpty(final Collection<?> coll) {
		return coll == null || coll.isEmpty();
	}

}
