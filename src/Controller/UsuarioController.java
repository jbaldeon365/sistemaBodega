/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Beans.Usuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miky_
 */
public class UsuarioController {
        private List<Usuario> lstusuario;

    public UsuarioController() {
        this.lstusuario = new ArrayList<Usuario>();     
        cargar();
    }    
    public void add(Usuario usuario){
        this.lstusuario.add(usuario);
    }
    public Usuario get(int pos){
        return this.lstusuario.get(pos);
    }
    public int size(){
        return this.lstusuario.size();
    }
    public boolean getValidar(String usuario,String password){
        for(int i=0;i<size();i++){
            if(this.lstusuario.get(i).getNombreUsuario().equalsIgnoreCase(usuario) && this.lstusuario.get(i).getPasswordUsuario().equalsIgnoreCase(password)){
                return true;            
            }                
        }
        return false;
    }
    /*ver 2.0*/
    public boolean getValidar2(String Usuario,String Password){
        for(Usuario obj:lstusuario){
            if(obj.getNombreUsuario().equalsIgnoreCase(Usuario) && obj.getPasswordUsuario().equalsIgnoreCase(Password)){
                return true;            
            }                
        }
        return false;
    }
    
   /*Ver 3*/
    public Usuario getValidarObjeto(String usurio,String password){
        for(int i=0;i<size();i++){
            if(this.lstusuario.get(i).getNombreUsuario().equalsIgnoreCase(usurio) && this.lstusuario.get(i).getPasswordUsuario().equalsIgnoreCase(password)){
                return this.lstusuario.get(i);
            }                
        }
        return null;
    } 
  public void grabar(){
    try{
        PrintWriter pw;
        String linea;
        pw= new PrintWriter(new FileWriter("usuario.txt"));
        for(int i=0;i<size();i++){
            linea=(lstusuario.get(i).getCodigo() + ";" + 
                      lstusuario.get(i).getNombreUsuario()+";" + 
                      lstusuario.get(i).getPasswordUsuario() + ";" +
                      lstusuario.get(i).getTipoUsuario()
                    );
            pw.println(linea);//Agregar el registro al archivo
        }
        pw.close();
    }catch(Exception e){
        System.out.println(e.getMessage());
    }    
    }
    public void cargar(){
    try{
        BufferedReader br;
        String linea=null;
        String[] array=null;
        br = new BufferedReader(new FileReader("usuario.txt"));
        while((linea = br.readLine()) != null ){
            array = linea.split(";");
            //Crear el objeto de tipo producto con los datos del archivo
             Usuario objusuario = 
                    new Usuario(Integer.parseInt(array[0].trim()),array[1].trim(),array[2].trim(),array[3].trim());
            //Agregar el objeto al ArrayList
            this.lstusuario.add(objusuario);
        }
        br.close();
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
    }
}
