package ficheros;
//probamos GIT
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase de ejemplo. Crea un fichero en la ruta absoluta especificada y ejecuta
 * una serie de operaciones sobre el. Este codigo escribir Ficheros de Texto
 */
public class OperacionesSobreFicheros {

	private static final String NOMBRE_FICHERO = "cancion.txt";
	private static final String NOMBRE_DIRECTORIO = "cancionero";
	private static final String RUTA_FICHERO = "c://Trastero//";

	public static void main(String[] args) {

		// crea un objeto file, el constructor recibe la
		// ruta del archivo del cual quiero saber sus propiedades
		File file = new File(RUTA_FICHERO + NOMBRE_FICHERO);
		System.out.println("Creado el fichero " + RUTA_FICHERO + NOMBRE_FICHERO);

		// Escribimos algo en el fichero para que lo cree realmente...
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		try {
			// Asignamos el fichero que vamos a escribir
			fileWriter = new FileWriter(RUTA_FICHERO + NOMBRE_FICHERO);
			printWriter = new PrintWriter(fileWriter);

			// Lo mandamos al fichero
			printWriter.println("Ejemplo de manejo de ficheros");

		} catch (IOException e) {
			System.out.println("IOException - Error de escritura en el fichero " + RUTA_FICHERO + NOMBRE_FICHERO);
		} finally {
			printWriter.close();
			try {
				fileWriter.close();
			} catch (IOException e) {
				// Nos da igual
			}
		}

		// para saber si el archivo no existe, devuelve true o false
		System.out.println("Existe? " + file.exists());

		// para saber si directorio, devuelve true o false
		System.out.println("Es un directorio? " + file.isDirectory());

		// para saber la fecha de modificacion
		
		Date fechaLargaNumerica = new Date(file.lastModified());
		DateFormat formato =  new SimpleDateFormat("dd-MM-yyyy hh-MM-ss");
		String fechaFormateada = formato.format(fechaLargaNumerica);
		System.out.println("Ultima modificacion: " + fechaFormateada);

		// para saber el nombre del archivo
		System.out.println("Nombre: " + file.getName());

		// para saber la ruta
		System.out.println("Ruta: " + file.getPath());

		// para saber el tamanio en bytes que ocupa en disco
		System.out.println("Tamanio: " + file.length()+ " bytes");

		// para saber si es de lectura, devuelve true o false
		System.out.println("Es de lectura? " + file.canRead());

		// para saber si es de escritura, devuelve true o false
		System.out.println("Es de escritura? " + file.canWrite());

		// crea un directorio en disco, devuelve true o false, para esto la ruta no debe
		// ser .txt
		// ejemplo: "C:\\archivos\\estudiantes" y crea el directorio estudiantes
		File directory = new File(RUTA_FICHERO + NOMBRE_DIRECTORIO);
		directory.mkdir();
		System.out.println("Creado el directory " + RUTA_FICHERO + NOMBRE_DIRECTORIO);

		// elimina el archivo o directorio (debe estar vacio), devuelve true o false
		System.out.println("Borramos el fichero " + NOMBRE_FICHERO);
		if (file.exists()) {
			file.delete();
			System.out.println("Borrado...");
		} else
			System.out.println("El fichero " + NOMBRE_FICHERO + " no existe");

		// si fuera un directorio, para saber los arhivos que contiene
		if (directory.list().length > 0) {
			System.out.println("El directorio " + NOMBRE_DIRECTORIO + " contiene: ");
			for (String string : directory.list())
				System.out.println(string);
		} else
			System.out.println("El directorio " + NOMBRE_DIRECTORIO + " esta vacio");
	}
}
