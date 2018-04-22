/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.ia;

import java.util.ArrayList;

/**
 *
 * @author Felipe
 */
public class No {

    int id, num;
    ArrayList filhos;
    String titulo;

    public No(int id, int num, ArrayList filhos, String titulo) {
        this.id = id;
        this.num = num;
        this.filhos = filhos;
        this.titulo = titulo;
    }

    No(int id, String titulo) {
        this.id = id;
        this.num = 0;
        this.filhos = new ArrayList();
        this.titulo = titulo;
    }

    public String getNome() {
        return titulo;
    }

    public void setNome(String nome) {
        this.titulo = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public ArrayList getFilhos() {
        return filhos;
    }

    public void setFilhos(ArrayList filhos) {
        this.filhos = filhos;
    }

    public static No getNo(ArrayList<No> grafo, int v) {
        for (int i = 0; i < grafo.size(); i++) {
            if (grafo.get(i).getId() == v) {
                return grafo.get(i);
            }
        }
        return null;
    }

    public static void atualiza(ArrayList<No> grafo, Aresta a) {

        No no1 = getNo(grafo, a.getV1());
        ArrayList f1 = no1.getFilhos();
        if (!no1.existe(a.getV2())) {
            f1.add(a.getV2());
            no1.setNum(no1.getNum() + 1);
        }
        
        No no2 = getNo(grafo, a.getV2());
        ArrayList f2 = no2.getFilhos();
        if (!no2.existe(a.getV1())) {
            f2.add(a.getV1());
            no2.setNum(no2.getNum() + 1);
        }
        
    }

    public boolean existe(int v) {
        for(int i =0; i<this.filhos.size(); i++){
           if(this.filhos.contains(v)) return true;
        }
        return false;
    }

    public void lista_filhos() {
        System.out.print("Filhos de \"" + this.getTitulo()+ "\":\n{");
        for (int i = 0; i < this.filhos.size(); i++) {
            if (i == this.filhos.size() - 1) {
                System.out.println(this.filhos.get(i) + "}");
            } else {
                System.out.print(this.filhos.get(i) + ", ");
            }
        }
    }
}
