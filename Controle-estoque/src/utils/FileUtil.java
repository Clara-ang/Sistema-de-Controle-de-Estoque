package utils;
// ler/gravar arquivos//
//kkh
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static void salvar(String caminho, List<String> linhas) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho))) {
            for (String linha : linhas) {
                writer.write(linha);
                writer.newLine();
            }
        }
    }

    public static List<String> carregar(String caminho) throws IOException {
        List<String> linhas = new ArrayList<>();
        File arquivo = new File(caminho);
        if (!arquivo.exists()) return linhas;

        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                linhas.add(linha);
            }
        }
        return linhas;
    }
}
