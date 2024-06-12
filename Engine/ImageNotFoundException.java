package Engine;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class ImageNotFoundException extends IOException {
    private String path;

    public ImageNotFoundException (String path) {
        super();
        this.path = path;
        showErrorDialog();
    }

    @Override
    public String toString () {
        return "Imagem não encontrada caminho providenciado: " + this.path + ".";
    }

    private void showErrorDialog() {
        JOptionPane.showMessageDialog(null, "Não foi possível inicializar o jogo.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}