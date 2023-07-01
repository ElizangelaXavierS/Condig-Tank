import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] salarios = new double[5];
        int nSalario = 1;
        for (int i = 0; i < salarios.length; i++) {
            System.out.println("Digite o " + nSalario + " salario:");
            salarios[i] = sc.nextDouble();
            nSalario++;
        }

        nSalario = 1;
        for (double salario : salarios) {
            System.out.println("");
            System.out.println("Salario " + nSalario);
            System.out.printf("Salario Bruto: %.2f\n", salario);


            double descontoInss = calculaINSS(salario);
            System.out.printf("Desconto INSS: %.2f\n", descontoInss);


            double descontoImpostoDeRenda = calculaImpostoDeRenda(salario);
            System.out.printf("Desconto Imposto de Renda: %.2f\n", descontoImpostoDeRenda);


            double salarioLiquido = salario - descontoInss - descontoImpostoDeRenda;
            System.out.printf("Salario liquido: %.2f\n", salarioLiquido);
            nSalario++;

        }

    }


    public static double calculaINSS(double salario) {
        double inss = 0, salarioImposto = 0;
        if (salario >= 0) {
            salarioImposto = salario - 1212.00;
            if (salarioImposto <= 0) {
                inss += salario * 0.075;
            } else {
                inss += 1212.00 * 0.075;
            }
        }
        if (salario >= 1212.01) {
            salarioImposto = salario - 1212.01;
            if (salarioImposto >= 1215.34) {
                inss += 1215.34 * 0.09;
            } else {
                inss += salarioImposto * 0.09;
            }
        }
        if (salario >= 2427.36) {
            salarioImposto = salario - 2427.36;
            if (salarioImposto >= 1213.67) {
                inss += 1213.67 * 0.12;
            } else {
                inss += salarioImposto * 0.12;
            }
        }
        if (salario >= 3641.04) {
            salarioImposto = salario - 3641.04;
            if (salarioImposto >= 3446.18) {
                inss += 3446.18 * 0.14;
            } else {
                inss += salarioImposto * 0.14;
            }
        }
        return inss;
    }


    public static double calculaImpostoDeRenda(double salario) {
        double impostoDeRenda = 0, salarioImposto = 0;
        if (salario >= 1903.99) {
            salarioImposto = salario - 1903.98;
            if (salarioImposto >= 922.66) {
                impostoDeRenda += 922.66 * 0.075;
            } else {
                impostoDeRenda += salarioImposto * 0.075;
            }
        }
        if (salario >= 2826.66) {
            salarioImposto = salario - 2826.65;
            if (salarioImposto >= 924.39) {
                impostoDeRenda += 924.39 * 0.15;
            } else {
                impostoDeRenda += salarioImposto * 0.15;
            }
        }
        if (salario >= 3751.06) {
            salarioImposto = salario - 3751.05;
            if (salarioImposto >= 913.62) {
                impostoDeRenda += 913.62 * 0.225;
            } else {
                impostoDeRenda += salarioImposto * 0.225;
            }
        }
        if (salario >= 4664.68) {
            salarioImposto = salario - 4664.67;
            impostoDeRenda += salarioImposto * 0.275;
        }
        return impostoDeRenda;
    }
}












