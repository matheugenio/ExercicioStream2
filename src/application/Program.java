package application;

import entities.Colaborador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new  Scanner(System.in);
        System.out.print("Entre com o caminho do arquivo: ");
        String caminho = sc.nextLine();
        System.out.print("Digite o salário");
        Double salario = sc.nextDouble();

        try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
            List<Colaborador> lista = new ArrayList<>();

            String line = br.readLine();
            while(line !=null) {
                String[] campos = line.split(",");
                lista.add(new Colaborador(campos[0], campos[1], Double.parseDouble(campos[2])));
                line = br.readLine();
            }
            Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
            List<String> emails = lista.stream()
                    .filter(c -> c.getSalary() > salario)
                    .map(c ->  c.getEmail())
                    .sorted()
                    .toList();
            emails.forEach(System.out::println);

            Double sum = lista.stream()
                    .filter(c -> c.getNome().charAt(0) == 'M')
                    .map(c -> c.getSalary())
                    .reduce(0.0, Double::sum);
            System.out.print("Soma do salário de todas as pessoas cujo nome começa com 'M': "+ sum);






        }catch(IOException e){
            System.out.println("Erro : " + e.getMessage());
        }

        sc.close();
    }
}
