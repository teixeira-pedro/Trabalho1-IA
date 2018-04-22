/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.ia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Felipe
 */
public class Trabalho1IA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Cria as duas estruturas de nó e arestas
        ArrayList<No> grafo = new ArrayList<>();
        ArrayList<Aresta> aresta = new ArrayList();

        Scanner ler = new Scanner(System.in);

        //Le os vertices e cria a estutura de nós...
        try {
            FileReader arq = new FileReader("C:\\Users\\Felipe\\Documents\\NetBeansProjects\\Trabalho1-IA\\src\\trabalho1\\ia\\vertices.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            Aresta a;
            String linha = lerArq.readLine();
            No g;
            while (linha != null) {
                String[] palavra = linha.split("\t");
                g = new No(Integer.parseInt(palavra[0]), palavra[1]);
                grafo.add(g);
                linha = lerArq.readLine(); // lê da segunda até a última linha
            }

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        try {
            FileReader arq = new FileReader("C:\\Users\\Felipe\\Documents\\NetBeansProjects\\Trabalho1-IA\\src\\trabalho1\\ia\\arestas.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            Aresta a;
            String linha = lerArq.readLine();
            while (linha != null) {

                String palavra[] = linha.split("\t");
                a = new Aresta(Integer.parseInt(palavra[0]), Integer.parseInt(palavra[1].split(" ")[0]));
                aresta.add(a);
                linha = lerArq.readLine();
            }

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        //Atualiza os atributos de cada nó, de acordo com o arquivo de texto de entrada
        for (int i = 0; i < aresta.size(); i++) {
            No.atualiza(grafo, aresta.get(i));
        }

        //Consulta dos nós
        String nome;
        while (true) {
            System.out.print("Entre o ID do No: ");
            nome = ler.nextLine();
            int num = Integer.parseInt(nome);
            if (num < 0 || num > 2554) {
                System.out.println("Numero Invalido");
            } else {
                grafo.get(num).lista_filhos();
                System.out.println("Quantidade de filhos: " + grafo.get(num).getNum() + "\n");
            }
        }

    }

}
