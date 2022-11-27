/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.cliente.util;

 import java.util.List;

/**
 *
 * @author lanylldo
 */
public interface Dao {
    public void insert(Object o);
    public void update(Object o);
    public void delete(Object o);
    public Object select(int i);
    public List select();
}
