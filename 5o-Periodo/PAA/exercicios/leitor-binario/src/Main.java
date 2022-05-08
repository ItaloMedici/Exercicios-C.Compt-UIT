public class Main {

    private static final String ORIGEM_ARQUIVO = "./src/data.txt";

    private static final FileUtil fileUtil = new FileUtil(ORIGEM_ARQUIVO);

    public static void main(String[] args) {
        fileUtil.createFile();

        boolean keep = true;
        while (keep) {
            try {
                EnumChoice choice = Menu.showMenu();
                handleChoice(choice);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                keep = false;
            }
        }

        fileUtil.deleteFile();
    }

    private static void handleChoice(EnumChoice choice) {
        String content = fileUtil.readFile();
        Menu.setContent(content);

        switch (choice) {
            case INSERIR:
                String toSave = Menu.getServicoToSave();
                fileUtil.writeLineInFile(toSave);
                break;

            case LISTAR:
                Menu.listServicos();
                break;

            case DELETAR:
                String finalContent = Menu.getContentWithLineRemoved();
                fileUtil.rewriteFile(finalContent);
                break;

            case BUSCAR:
                Menu.searchServico();
                break;
        }
    }
}
