/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudusuarios;

import entidade.Usuario;
import java.beans.*;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author maycon
 */
public class ControladorBean implements Serializable {
    
    private static final HashMap<Integer,Usuario> usuarios = new HashMap<>();
    private static Integer ultimoId = 0;
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";    
    private String sampleProperty;    
    private PropertyChangeSupport propertySupport;
    
    public ControladorBean() {
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public String getSampleProperty() {
        return sampleProperty;
    }
    
    public void setSampleProperty(String value) {
        String oldValue = sampleProperty;
        sampleProperty = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, sampleProperty);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }     
    
    public HashMap<String,String> cadastraUsuario(String nome, String email, String telefone){
        int codUsuario = ultimoId;
        Usuario usuario = new Usuario(nome, codUsuario, email, telefone);
        usuarios.put(ultimoId, usuario);
        HashMap<String,String> retorno = new HashMap<>();
        retorno.put("Nome",nome);
        retorno.put("Telefone",telefone);
        retorno.put("Email", email);
        ultimoId++;
        return retorno; 
    }
    
    public void imprimeMapa() {
        for(Integer i : usuarios.keySet()){
            System.out.println(i + ": " + usuarios.get(i).toString());
        }
    }
    
    public static void removeUsuario(int codUsr){
        usuarios.remove(codUsr);
    }                
    
    public static HashMap<Integer,Usuario> getUsuarios(){
        return usuarios;
    }
    
    public static void alteraUsuario(int codUsr,HashMap<String,String> dados){
        Usuario usuario = usuarios.get(codUsr);
        usuario.setNome(dados.get("Nome"));
        usuario.setEmail(dados.get("Email"));
        usuario.setTelefone(dados.get("Telefone"));
        usuarios.put(codUsr, usuario);
    }
}
