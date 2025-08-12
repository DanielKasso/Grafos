/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.instic.edii.grafonaodirmademo;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author D.N.Kasso
 */
public class GrafoNaoDirMADemo {

    public static void main(String[] args) throws Exception {
        
        GrafoNaoDirMA<Integer> g = new GrafoNaoDirMA();
        //GrafoNaoDirMA<Point> g = new GrafoNaoDirMA();
        g.inserirVertice(0);
        g.inserirVertice(1);
        g.inserirVertice(2);
        g.inserirVertice(3);
        g.inserirVertice(4);
        g.inserirVertice(5);
        g.inserirVertice(6);
        g.inserirVertice(7);
        
        g.inserirAresta(0, 1);
        g.inserirAresta(0, 2);
        g.inserirAresta(0, 3);
        g.inserirAresta(1, 4);
        g.inserirAresta(1, 5);
        g.inserirAresta(2, 6);
        g.inserirAresta(3, 7);
        
//        System.out.println("Busca em Profundidade");
//        LinkedList<Integer> vertices = g.dfs(0);
//        for(int v: vertices)
//           System.out.println(v);        
        
        System.out.println("Busca em largura");
        LinkedList<Integer> vertices = g.bfs(0);
        //vertices = g.bfs(0);
        for(int v: vertices)
           System.out.println(v);
//        
//        System.out.println("DFS iterativo"); // nao esta a funcionar
//        vertices = g.dfsIterativo(0);
//        for(int v: vertices)
//           System.out.println(v);
//        
//        System.out.println("Apenas dois adjacentes: "+g.verticesDoisAdjacentesAB());
//        
//        System.out.println("Arestas: " +g.numeroArestas());
//        System.out.println("Lista de vertices");
//        System.out.println(g);
//        
//        System.out.println("Matriz de adjacencias");
//        
//        for (int i = 0; i < g.getMatrizAdj()[0].length; i++) {
//            for (int j = 0; j < g.getMatrizAdj()[0].length; j++) {
//                System.out.print(g.getMatrizAdj()[i][j] + " ");
//            }
//            System.out.println("");
//        }
//        
//        System.out.print("Adjacentes do vertice B: ");
//        for(int v: g.adjacentes(1))
//            System.out.printf("%d%c ", v, ',');
//        
//        System.out.printf("%c %s ", '\n', "Existe aresta entre os vertices A e C: ");
//        System.out.println(g.existeAresta(0, 3)? "Sim, existe": "Nao, nao existe");
        
        
        
        
        
//        System.out.println("Percorrido em profundidade");
//
//        g.dfsTest('B');
//        for (int i = 0; i < lista.Extensao(); i++) {
//            System.out.println(lista.Obter(i));
//        }
//        System.out.println("Matriz antes de eliminar");
//        for (int i = 0; i < g.getMatrizAdj()[0].length; i++) {
//            for (int j = 0; j < g.getMatrizAdj()[0].length; j++) {
//                System.out.print(g.getMatrizAdj()[i][j] + " ");
//            }
//            System.out.println("");
//        }
//        g.EliminarVertice('C');
//        System.out.println("Matriz depois de eliminar");

//        System.out.println("Percorrido em profundidade depois de eliminar E");
//        lista = g.dfs('C');
//        for (int i = 0; i < lista.Extensao(); i++) {
//            System.out.println(lista.Obter(i));
//        }
        
    }

}
 