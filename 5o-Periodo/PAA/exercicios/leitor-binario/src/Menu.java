import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    private static String content;

    public static void setContent(String content) {
        Menu.content = content;
    }

    public static EnumChoice showMenu() throws Exception {
        EnumChoice response;

        System.out.println("\t\tMenu");
        for (String options : EnumChoice.getStrListValues()) {
            System.out.println("\t" + options);
        }
        System.out.print("R.: ");

        short choice = scanner.nextShort();
        response = EnumChoice.get(choice);

        return response;
    }

    public static String getServicoToSave() {
        System.out.println("\t\tCriar Serviço");

        System.out.print("Descrição: ");
        String descricao = scanner.next();

        System.out.print("Valor: ");
        Double valor = scanner.nextDouble();

        Servico.updadeIDControll();
        Servico servico = new Servico(Servico.getIDControll(), descricao, valor);

        return servico.toSave();
    }

    private static String[] splitContentIntoLines() {
        return content.split("\\r?\\n");
    }

    private static boolean hasContent() {
        if (content.isEmpty()) {
            MessageUtil.insiraServicos();
            return false;
        }

        return true;
    }

    public static void listServicos() {
        if (hasContent()) {
            System.out.println("\t\tServiços");

            String[] lines = splitContentIntoLines();
            List<Servico> servicos = Servico.toEntities(lines);

            servicos.forEach(servico -> System.out.println(servico.toString()));
            clearConsole();
        }
    }

    public static String getContentWithLineRemoved() {
        listServicos();

        System.out.println("\t\tDeletar Serviço");

        System.out.print("ID Servico : ");
        Long id = scanner.nextLong();

        String lineToRemove = getLineById(id);

        if (lineToRemove.isEmpty()) {
            return null;
        }

        return stream(splitContentIntoLines())
                    .filter(l -> !l.equals(lineToRemove))
                    .collect(Collectors.joining("\n"));
    }

    public static void searchServico() {
        if (hasContent()) {
            clearConsole();
            System.out.println("\t\tBuscar Serviço");

            System.out.print("ID Servico: ");
            Long id = scanner.nextLong();

            String line = getLineById(id);

            if (!line.isEmpty()) {
                System.out.println(Servico.toEntity(line));
            }
        }
    }

    public static String getLineById(Long id) {
        for (String linha : splitContentIntoLines()) {
            Servico servico = Servico.toEntity(linha);

            if (servico.getIdentificador().equals(id)) {
                return  linha;
            }
        }

        MessageUtil.servicoNaoEncontrado();

        return "";
    }


    public static void clearConsole() {
        for (int i = 0; i < 2; ++i) System.out.println("\b");
    }
}
