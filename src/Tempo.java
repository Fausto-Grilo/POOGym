public class Tempo {
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;


    //Construtor
    public Tempo(int ano, int mes, int dia, int hora, int minutos){

        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minutos= minutos;

    }

    //Metodos
    public String getDate(){
        return ano + "-" + mes + "-" + dia + " " + hora + "-" + minutos;
    }
}