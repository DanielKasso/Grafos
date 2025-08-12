/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.instic.edii.grafonaodirmademo;

import java.util.LinkedList;


/**
 *
 * @author D.N.Kasso
 * @param <T>
 */
public interface IGrafo<T> {
    public boolean eVazio();
    public int numeroVertices();
    public int numeroArestas();
    public boolean existeAresta(T vertice1, T vertice2);
    public boolean existeOVertice(T vertice);
    public void inserirVertice(T vertice) throws Exception;
    public void inserirAresta(T vertice1, T vertice2) throws Exception;
    public LinkedList<T> adjacentes(T vertice) throws Exception;
    //public void eliminarVertice(T vertice);
    
}
