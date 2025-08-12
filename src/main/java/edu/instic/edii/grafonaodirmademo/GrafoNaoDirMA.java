/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.instic.edii.grafonaodirmademo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 *
 * @author D.N.Kasso
 * @param <T>
 */
public class GrafoNaoDirMA<T> implements IGrafo<T> {
    private final LinkedList<T> vertices;
    private int[][] matrizAdj;
    
    public int[][] getMatrizAdj() {
        return matrizAdj;
    }

    public GrafoNaoDirMA(){
        vertices = new LinkedList<>();
    }
    @Override
    public boolean eVazio() {
        return vertices.isEmpty();
    }

    @Override
    public int numeroVertices() {
        return vertices.size();
    }
    
    @Override
    public int numeroArestas() {
        int arestas = 0;
        int size = vertices.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if( matrizAdj[i][j] == 1 && i != j)
                    arestas++;
            }
        }
        return arestas / 2 + lacos();
    }
    private int lacos(){
        int size = vertices.size();
        int lacos = 0;
        for (int i = 0; i < size; i++) {
            if(matrizAdj[i][i] == 1)
                lacos++;
        }
        return lacos;
    }
    
    @Override
    public boolean existeOVertice(T vertice){
        return vertices.indexOf(vertice) != -1;
    }
    
    @Override
    public boolean existeAresta(T vertice1, T vertice2){
        int v1 = this.vertices.indexOf(vertice1);
        int v2 = this.vertices.indexOf(vertice2);
        return v1 >= 0 && v2 >= 0 && matrizAdj[v1][v2] != 0; 
    }
 
    @Override
    public void inserirVertice(T vertice)throws Exception{
        if( !existeOVertice(vertice) ){
            vertices.add(vertice);
            int size = vertices.size();
            matrizAdj = new int[size][size];
        }
        else
            throw new Exception("O vertice ja existe");
    }
    
    @Override
    public void inserirAresta(T vertice1, T vertice2) throws Exception{
        int v1 = this.vertices.indexOf(vertice1);
        int v2 = this.vertices.indexOf(vertice2);
        if( v1 >= 0 &&  v2 >= 0 ){
            if(!existeAresta(vertice1, vertice2) ){
                if( String.valueOf(vertice1).compareToIgnoreCase(String.valueOf(vertice2)) != 0 ){
                    matrizAdj[v1][v2] = 1;
                    matrizAdj[v2][v1] = 1;
                }
                else
                    matrizAdj[v1][v1] = 1; // ou matrizAdj[v2][v2] = 1;
            }
            else
                throw new Exception("A aresta entre os vertices " + vertice1 + "e o " + vertice2 + " ja existe" );
        }
        else
            throw new Exception("Os vertices " + vertice1 + "e " + vertice2 + " nao existem" );
    }
    
    @Override
    public LinkedList<T> adjacentes(T vertice) throws Exception{
        LinkedList<T> adjacentes = new LinkedList<>();
        if( existeOVertice(vertice)){
            for (int i = 0; i < vertices.size(); i++) 
                if(existeAresta(vertice, vertices.get(i)))
                    adjacentes.add(vertices.get(i));
        }
        return adjacentes;
    }
    
    public boolean verticesDoisAdjacentes() throws Exception{
        
        for (int i = 0; i < vertices.size(); i++) {
            if( adjacentes(vertices.get(i)).size() != 2 )
                return false;
        }
        return true;
    }
    
    public boolean verticesDoisAdjacentesA(){
        int tamanho = vertices.size();
        int adjacentes, apenasDois = 0;
        for (int i = 0; i < tamanho; i++) {
            adjacentes = 0;
            for (int j = 0; j < tamanho; j++) {
                if(matrizAdj[i][j] == 1)
                    adjacentes++;
            }
            if(adjacentes == 2)
                apenasDois++;
            
        }
        return apenasDois == tamanho;
    }
    public boolean verticesDoisAdjacentesAB(){
        int tamanho = vertices.size();
        int adjacentes, apenasDois = 0;
        for (int i = 0; i < tamanho; i++) {
            adjacentes = 0;
            for (int j = 0; j < tamanho; j++) {
                if(matrizAdj[i][j] == 1)
                    adjacentes++;
            }
            if(adjacentes == 2)
                apenasDois++;
            
        }
        return apenasDois == tamanho;
    }
    
    public boolean verticesDoisAdjacentesX(){
        int tamanho = vertices.size();
        int adjacentes;
        for (int i = 0; i < tamanho; i++) {
            adjacentes = 0;
            for (int j = 0; j < tamanho; j++) {
                adjacentes += matrizAdj[i][j];
            }
            if(adjacentes != 2)
                return false;
            
        }
        return true;
    }
    public boolean verticesDoisAdjacentesC(){
        int tamanho = vertices.size();
        int [] quantAdj = new int[tamanho]; //Nao tao correcto aqui       
        int adjacentes, l = 0;
        for (int i = 0; i < tamanho; i++) {
            adjacentes = 0;
            for (int j = 0; j < tamanho; j++) {
                if(matrizAdj[i][j] == 1)
                    adjacentes++;
            }
            quantAdj[l++] = adjacentes;
            
        }
        for (int i = 0; i < quantAdj.length; i++) {
            if( quantAdj[i] != 2 )
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GrafoNaoDirMA{" + "vertices=" + vertices + '}';
    }
    
    public LinkedList<T> dfs(T u) throws Exception{
        LinkedList<T> lista = new LinkedList<>();
        for(int i = vertices.indexOf(u); i < vertices.size(); i++) //sem ciclo nao percorre os v isolados
           if( !lista.contains(vertices.get(i)) )
                dfsVisit(vertices.get(i), lista);  
        return lista;
    }

    private void dfsVisit(T v, LinkedList<T> list) throws Exception{
            if(!list.contains(v))
                list.add(v);
            for( T a: adjacentes(v) )
                if( !list.contains(a) ){
                   dfsVisit(a, list);
                }
    }
    public LinkedList<T> bfs(T v) throws Exception {
       LinkedList<T> visitados=new LinkedList<>();
        for (int i = vertices.indexOf(v); i < vertices.size(); i++) {
            if (!visitados.contains(vertices.get(i))) {
                bfsVisit(vertices.get(i), visitados);
            }
        }
        return visitados; 
    }
    
    private void bfsVisit(T v, LinkedList<T> visitados) throws Exception
    {
        Queue<T> fila = new LinkedList<>();
        visitados.add(v);
        fila.add(v);   
        while(!fila.isEmpty())
        {
           T u=fila.remove();
           for (T k: adjacentes(u)) {
                if (!visitados.contains(k)) {
                    visitados.add(k);
                    fila.add(k);
                }                 
            }
        }
    }     

} 
