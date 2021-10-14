package ejTema1Ficheros;

import java.io.File;
import java.io.FilenameFilter;

// OJO! 1. a�ado --> implements FilenameFilter --> import java.io.FilenameFilter --> add unimplemented methods --> public boolean accept
public class FiltroExtension implements FilenameFilter{

	// 2. incluyo atributo y m�todo constructor
	String extension;
	FiltroExtension(String extension){
		this.extension=extension;
	}
	
	// 3. para que me devuelva solo aquellos ficheros que terminen en la extensi�n --> return name.endsWith(extension);
	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return name.endsWith(extension);
	}

}
