import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;


//6 opções - Reais BRL || Dólar Americano USD || Peso Argentino (ARS)|| Euro (EUR) || Yuan (CNY)

public class Main {
    public static void main(String[] args) throws InterruptedException {


        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        ConverterValor conversor;

        boolean statusPrograma= true;
        int numOp;
        double valor;

        while (statusPrograma){

            System.out.println("**** * Digite o tipo de moeda para converter * ****");
            System.out.println(
                    "1) [USD] Dolar --> Real [BRL]\n" +
                            "2) [BRL] Real --> Dolar [USD]\n" +
                            "3) [CNY] Yuan --> Real [BRL]\n" +
                            "4) [BRL] Real --> Yuan [CNY]\n" +
                            "5) [BRL] ReaL --> Euro [EUR]\n" +
                            "6) [EUR] Euro --> Real [BRL]\n" +
                            "7) Sair"
            );

            System.out.print("Opção: ");
            numOp = sc.nextInt();

            try {
                if (numOp >= 1 && numOp < 7) {
                        System.out.print("Insira o valor a ser convertido: ");
                        valor = sc.nextDouble();
                        System.out.println();
                        conversor = new ConverterValor(numOp, valor);

                        System.out.printf("Valor convertido: %.2f \n", conversor.calcularResultado());
                        System.out.println("Aguarde um momento...");
                        Thread.sleep(4000);
                }
                else if (numOp == 7) {
                        System.out.println("Programa Encerrado.");
                        statusPrograma = false;
                    }
                }catch (InputMismatchException e){
                    System.out.println("Valor inválido, tente novamente.");
                }

        }
    }
}








//    public double valorConvertido(int numOp){
//        AlterarValor alterarValor = new AlterarValor();
//        CoeficienteDeConversao coeficienteDeConversao = new CoeficienteDeConversao();
//        String siglaReferencia;
//        String siglaMoeda;
//
//       switch(numOp){
//           case 1: // USD -> BRL
//               siglaReferencia = "USD";
//               siglaMoeda = alterarValor.getTipoMoeda(2); // 2 acessa o valor BRL na lista em alteraValor
//               return coeficienteDeConversao.valorCoeficienteConversao(siglaReferencia, siglaMoeda);
//               break;
//           case 2: // USD -> BRL
//               siglaReferencia = "BRL";
//               siglaMoeda = alterarValor.getTipoMoeda(1); // 1 acessa o valor USD na lista em alteraValor
//               return coeficienteDeConversao.valorCoeficienteConversao(siglaReferencia, siglaMoeda);
//           break;
//
//       }
