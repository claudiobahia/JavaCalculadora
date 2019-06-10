package sample;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Log log = new Log();
        Calculadora calculadora = new Calculadora();
        String[] options = {"Somar", "Subtrair", "Multiplicar", "Dividir", "Consultar", "Sair"};
        JTextField valorAtxt = new JTextField();
        JTextField valorBtxt = new JTextField();
        Object[] inputDuplo = {"Entre com o valor A", valorAtxt, "Entre com o valor B", valorBtxt};

        System.out.println(calculadora.toString());
        boolean sair = false;
        do {
            int choosedOption = showMenu(options);
            boolean ok = false;
            do {
                if (choosedOption != 4 && choosedOption != 5 && choosedOption != -1) {
                    JOptionPane.showConfirmDialog(null, inputDuplo, "Entre com os valores", JOptionPane.DEFAULT_OPTION);
                    if (tryParse(valorAtxt.getText()) & tryParse(valorBtxt.getText())) {
                        calculadora.setValorA(parseDouble(valorAtxt.getText()));
                        calculadora.setValorB(parseDouble(valorBtxt.getText()));
                        ok = true;
                    }else showMessage("ENTRE COM VALORES VÁLIDOS");

                } else ok = true;
            } while (!ok);
            switch (choosedOption) {
                case 0: //SOMA +
                    showResult(calculadora.getValorA(), calculadora.getValorB(), calculadora.Somar(), "Soma", log);
                    break;
                case 1: //SUBTRAÇÃO -
                    showResult(calculadora.getValorA(), calculadora.getValorB(), calculadora.Subtrair(), "Subtração", log);
                    break;
                case 2: //MULTIPLICAÇÃO *
                    showResult(calculadora.getValorA(), calculadora.getValorB(), calculadora.Multiplicar(), "Multiplicação", log);
                    break;
                case 3://DIVISÃO /
                    if (calculadora.getValorB() == 0) {
                        showMessage("Erro, entre com valor B válido.\na/0 = ERROR");
                    } else {
                        showResult(calculadora.getValorA(), calculadora.getValorB(), calculadora.Dividir(), "Divisão", log);
                    }
                    break;
                case 4://CONSULTAR consulting last 5 operations
                    consult(log);
                    break;
                case 5:
                case -1://SAIR exit
                    sair = true;
                    break;
            }
        } while (!sair);
    }

    private static void showResult(double a, double b, double result, String title, Log log) {
        log.addTypeToVector(title);
        String identifier;
        StringBuilder stringBuilder = new StringBuilder();
        switch (title) {
            case "Soma":
                identifier = "+";
                break;
            case "Subtração":
                identifier = "-";
                break;
            case "Multiplicação":
                identifier = "*";
                break;
            case "Divisão":
                identifier = "/";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + title);
        }
        stringBuilder.append(a).append(" ").append(identifier).append(" ").append(b).append(" = ").append(result);
        log.addOperationToVetor(stringBuilder);
        showMessage(stringBuilder.toString());
    }

    private static void showMessage(String string) {
        JOptionPane.showMessageDialog(null, string);
    }

    private static int showMenu(Object[] objects) {
        return JOptionPane.showOptionDialog(null, "Selecione a opção desejada", "Escolha uma opção",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, objects, null);
    }

    private static boolean tryParse(String valor) {
        try {
            Double.parseDouble(valor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static double parseDouble(String stringValue) {
        try {
            return Double.parseDouble(stringValue);
        } catch (Exception e) {
            showMessage(e.toString());
            return 0;
        }
    }

    private static void consult(Log log) {
        Object[] consultarOque = {"Histórico", "Operações"};
        if (showMenu(consultarOque) == 0) {
            showMessage(log.toString());//ToString RETURN LIST OF OPERATIONS
        } else {
            showMessage(log.getOperationsTypeNumber());//Operacoes RETURN NUMBER OF SUM, ETC.
        }
    }
}