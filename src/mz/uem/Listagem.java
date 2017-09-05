package mz.uem;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Classe que contem alguns metodos que sao a correcao dos exercicios.
 * @author José Seie
 * @version 1.0
 */
public class Listagem {

    /**
     * Este eh o metodo que lista os sub-directorios de um directorio e os seus respectivos ficheiros.
     * @param path 
     */
    public static void listar(Path path) {
        if (Files.isRegularFile(path)) {
            System.out.println(path.toAbsolutePath());
        } else {
            String s = "\n" + path.toAbsolutePath();
            System.err.println(s.toUpperCase());
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
                for (Path p : stream) {
                    listar(p);
                }
            } catch (Exception e) {
            }
        }
    }

}
