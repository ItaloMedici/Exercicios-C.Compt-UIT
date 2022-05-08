import java.io.*;

public class FileUtil {
    private final String origemArquivo;
    private final File file;

    public FileUtil(String origemArquivo) {
        this.origemArquivo = origemArquivo;
        file = new File(this.origemArquivo);
    }

    public void createFile() {
        try {
            file.createNewFile();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public String readFile() {
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
            ByteArrayOutputStream bytesArr = new ByteArrayOutputStream();

            int x = 0;
            while ((x = in.read()) != -1) {
                bytesArr.write(x);
            }
            in.close();

            String content = bytesArr.toString();

            return content;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "";
    }

    public void writeLineInFile(String servicoToSave) {
        if (servicoToSave == null) return;

        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(origemArquivo, true));

            br.write(servicoToSave);
            br.newLine();

            br.close();

            MessageUtil.servicoCadastrado();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rewriteFile(String finalContent) {
        if (finalContent == null) return;

        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(origemArquivo));
            br.write(finalContent);
            br.close();
            MessageUtil.servicoDeletado();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    public void deleteFile() {
        if (file.exists()) {
            boolean result = file.delete();
            if (result) {
                MessageUtil.arquivoExcluido();
            }
        }
    }

}
