package sample;

import java.util.ArrayList;

public class Log {

    private int contador = 0;
    private int tamChecker = 0;
    private ArrayList<StringBuilder> operationsList;
    private ArrayList<String> typeOperationList;

    public Log() {
        this.operationsList = new ArrayList<>();
        this.typeOperationList = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder().append("Últimas contas realizadas\n");
        for (StringBuilder string : operationsList) {
            stringBuilder.append(string).append("\n");
        }
        stringBuilder.append("Você realizou ").append(contador).append(" operações");
        return stringBuilder.toString();
    }

    public String getOperationsTypeNumber() {
        StringBuilder stringBuilder = new StringBuilder().append("Contas realizadas:\n");
        ArrayList checkList = new ArrayList();
        int opCount = 0;
        for (String string : typeOperationList) {
            if (!checkList.contains(string)) {
                checkList.add(string);
                stringBuilder.append(string).append(" : ");
                for (String s : typeOperationList) {
                    if (s.equals(string)) {
                        opCount++;
                    }
                }
                stringBuilder.append(opCount).append("\n");
                opCount = 0;
            }
        }
        return stringBuilder.toString();
    }

    public void addTypeToVector(String title) {
        typeOperationList.add(title);
    }

    public void addOperationToVetor(StringBuilder stringBuilder2) {
        if (operationsList.size() != 5) {
            operationsList.add(stringBuilder2);
            contador++;
        } else {
            operationsList.set(tamChecker, stringBuilder2);
            tamChecker++;
            contador++;
            if (tamChecker == 5) {
                tamChecker = 0;
            }
        }
    }
}
