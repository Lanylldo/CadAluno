package br.com.cliente.controle;

import br.com.cliente.bean.Cliente;
import br.com.cliente.dao.ClienteDao;
import java.util.List;

/**
 *
 * @author lanylldo
 */
public class ClienteCT {
   public void insert(Cliente c){
  ClienteDao dao = new ClienteDao();
  dao.insert(c);
  }
 
  public void update(Cliente c){
  ClienteDao dao = new ClienteDao();
  dao.update(c);
  }
 
  public void delete(Cliente c){
  ClienteDao dao = new ClienteDao();
  dao.delete(c);
  }
 
  public Cliente select(int i){
  ClienteDao dao = new ClienteDao();
  Cliente c = (Cliente) dao.select();
  return c;
  }
 
  public List select(){
  ClienteDao dao = new ClienteDao();
  List c = dao.select();
  return c;
  }
 }