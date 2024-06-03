import java.util.List;

public class ConverterValor {

    private double valor;
    private int opcao;

    public ConverterValor(int opcao, double valor){
        this.opcao = opcao;
        this.valor = valor;
    }

   List<String> tiposMoeda = List.of(new String[]{
           "","USD" , "BRL" , "CNY" , "EUR"}
   );

   public String getTipoMoeda(int opcao){
        return tiposMoeda.get(opcao); //op = indice do vetor
   }


   public double buscarCoeficiente(int opcao){
       CoeficienteDeConversao coeficienteDeConversao = new CoeficienteDeConversao();
       String siglaReferencia;
       String siglaMoeda;

       switch (opcao){
           case 1:  //USD -> BRL
               siglaReferencia = getTipoMoeda(1);
               siglaMoeda = getTipoMoeda(2); // 2 por que acessa BRL em tiposMoeda
               return coeficienteDeConversao.valorCoeficienteConversao(siglaReferencia, siglaMoeda);
           case 2: //BRL -> USD
               siglaReferencia = getTipoMoeda(2);
               siglaMoeda = getTipoMoeda(1); //Acessa USD
               return coeficienteDeConversao.valorCoeficienteConversao(siglaReferencia, siglaMoeda);

           case 3: //CNY -> BRL
               siglaReferencia = getTipoMoeda(3);
               siglaMoeda = getTipoMoeda(2);
               return coeficienteDeConversao.valorCoeficienteConversao(siglaReferencia, siglaMoeda);

           case 4: //BRL -> CNY
               siglaReferencia = getTipoMoeda(2);
               siglaMoeda = getTipoMoeda(3);
               return coeficienteDeConversao.valorCoeficienteConversao(siglaReferencia, siglaMoeda);

           case 5: //BRL --> EUR
               siglaReferencia = getTipoMoeda(2);
               siglaMoeda = getTipoMoeda(4);
               return coeficienteDeConversao.valorCoeficienteConversao(siglaReferencia, siglaMoeda);

           case 6: //EUR --> BRL
               siglaReferencia = getTipoMoeda(4);
               siglaMoeda = getTipoMoeda(2);
               return coeficienteDeConversao.valorCoeficienteConversao(siglaReferencia, siglaMoeda);

       }
       return 0;
   }

   public double calcularResultado(){
       return this.valor * buscarCoeficiente(this.opcao);
   }





 }