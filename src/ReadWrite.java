import javax.naming.ldap.PagedResultsControl;
import java.io.*;
import java.lang.classfile.constantpool.IntegerEntry;
import java.util.ArrayList;

public class ReadWrite {


    public ReadWrite(){

    }

    // Metodos Auxiliares

    static Instrutor getInstrutorByName(ArrayList<Instrutor> instrutors, String name){
        for(Instrutor i: instrutors){
            if(i.getNome().equals(name)){
                return i;
            }
        }

        return null;
    }

    static Tempo createDate(String fullDate){
        String params[] = fullDate.strip().split("\\|");
        String date[] = params[0].split("-");
        String time[] = params[1].split(":");

        if(date.length != 3 || time.length != 2) return null;

        return new Tempo(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]), Integer.parseInt(time[0]), Integer.parseInt(time[1]));
    }

    static NivelEnum getNivelEnumByName(String name){
        NivelEnum values[] = NivelEnum.values();
        for(NivelEnum v: values){
            if(v.toString().equals(name)){
                return v;
            }
        }

        return null;
    }

    static ModalidadeEnum getModalidadeEnumByName(String name){
        ModalidadeEnum values[] = ModalidadeEnum.values();
        for(ModalidadeEnum v: values){
            if(v.toString().equals(name)){
                return v;
            }
        }

        return null;
    }


    // Escrita

    public boolean escrever(ArrayList<Socio> socios, ArrayList<Instrutor> instrutores, ArrayList<Atividade> atividades){
        return(escreverSocios(socios) && escreverInstrutores(instrutores) && escreverAtividades(atividades));
    }

    static boolean escreverSocios(ArrayList<Socio> socios){
        File f = new File("socios.txt");
        try{
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Socio s: socios){
                bw.write(s.toWrite());
            }

            bw.close();
            return true;
        } catch (IOException e) {
            System.err.println("Erro a escrever");
        }

        return false;
    }

    static boolean escreverInstrutores(ArrayList<Instrutor> instrutores){
        File f = new File("instrutores.txt");
        try{
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Instrutor i: instrutores){
                bw.write(i.toWrite());
            }

            bw.close();
            return true;
        } catch (IOException e) {
            System.err.println("Erro a escrever");
        }

        return false;
    }

    static boolean escreverAtividades(ArrayList<Atividade> atividades){
        File f = new File("atividades.txt");
        try{
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Atividade a: atividades){
                bw.write(a.toWrite());
            }

            bw.close();
            return true;
        } catch (IOException e) {
            System.err.println("Erro a escrever");
        }

        return false;
    }

    // Leitura

    public boolean ler(ArrayList<Socio> socios, ArrayList<Instrutor> instrutores, ArrayList<Atividade> atividades, int idCount, int sICount, int sECount, int aGCount, int sPTCount){
        return(lerSocios(socios, idCount, sICount, sECount) && lerInstrutores(instrutores) && lerAtividades(atividades, instrutores, aGCount, sPTCount));
    }

    static boolean lerSocios(ArrayList<Socio> socios, int idCount, int sICount, int sECount){
        File f = new File("socios.txt");
        try{
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while((line = br.readLine()) != null){
                String params[] = line.strip().split("\\|");
                if(params.length != 5) return false;
                else{
                    // Verifica o Identificador
                    if(params[0].equals("SI")){
                        socios.add(new SocioIndividual(params[1], Integer.parseInt(params[2]), params[3], Integer.parseInt(params[4])));
                        sICount++;
                        idCount++;
                    } else if (params[0].equals("SE")) {
                        socios.add(new SocioEmpresa(params[1], Integer.parseInt(params[2]), params[3], params[4]));
                        sECount++;
                        idCount++;
                    }
                }

                System.out.println("Lido");
            }

            br.close();
            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static boolean lerInstrutores(ArrayList<Instrutor> instrutors){
        File f = new File("instrutores.txt");
        try{
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while((line = br.readLine()) != null){
                String params[] = line.strip().split("\\|");
                // Verifica o Identificador
                if(params[0].equals("I")){
                    if(params.length != 4) return false;
                    instrutors.add(new Instrutor(params[1], params[2], params[3]));
                }
            }

            br.close();
            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static boolean lerAtividades(ArrayList<Atividade> atividades, ArrayList<Instrutor> instrutors, int aGCount, int sPTCount){
        File f = new File("atividades.txt");
        try{
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while((line = br.readLine()) != null){
                String params[] = line.strip().split("\\|");
                // Verifica o Identificador
                if(params[0].equals("AG")){
                    if(params.length != 7) return false;
                    atividades.add(new AulaGrupo(params[1], getInstrutorByName(instrutors, params[2]), createDate(params[3]), Integer.parseInt(params[4]), getModalidadeEnumByName(params[5]), Integer.parseInt(params[6])));
                    aGCount++;
                } else if (params[0].equals("SPT")) {
                    if(params.length != 6) return false;
                    atividades.add(new SessaoPersonalTrainer(params[1], getInstrutorByName(instrutors, params[2]), createDate(params[3]), Integer.parseInt(params[4]), getNivelEnumByName(params[5])));
                    sPTCount++;
                }
            }

            br.close();
            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }




}
