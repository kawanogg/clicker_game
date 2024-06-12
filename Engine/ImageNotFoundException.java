package Engine;

import java.io.File;
import java.io.IOException;

public class ImageNotFoundException extends IOException {
    private String path;

    public ImageNotFoundException (String path) {
        super();
        this.path = path;
    }

    @Override
    public String toString () {
        return "Imagem não encontrada caminho providenciado: " + this.path + ".";
    }
}