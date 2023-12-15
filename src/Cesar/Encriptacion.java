/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Cesar;

import javax.swing.JOptionPane;

/**
 *
 * @author RODRIGO
 */

public class Encriptacion {
    public static String encriptar (String mensaje, int clave){
        StringBuilder mensajeEncriptado = new StringBuilder();
        
        for (int i = 0; i < mensaje.length(); i++) {
           char caracter = mensaje.charAt(i);
           
            if (Character.isLetter(caracter)) {
                char limite = Character.isUpperCase(caracter) ? 'Z' : 'z';
                char base = Character.isUpperCase(caracter) ? 'A' : 'a';
                
                char caracterEncriptado = (char) (base+(caracter-base+clave)%26);
                
                mensajeEncriptado.append(caracterEncriptado);
                              
            } else {
                mensajeEncriptado.append(caracter);
            }
        }
          return mensajeEncriptado.toString();
    }
    
    public static String desencriptar (String mensajeEncriptado,int clave){
        StringBuilder mensajeOriginal = new StringBuilder();
        
        for (int i = 0; i < mensajeEncriptado.length(); i++) {
            char caracter = mensajeEncriptado.charAt(i);
            
            if(Character.isLetter(caracter)){
                char limite = Character.isUpperCase(caracter) ? 'Z' : 'z';
                char base = Character.isUpperCase(caracter) ? 'A' : 'a';
                
                char caracterDesencriptado = (char) (base+(caracter-base-clave+26) % 26);
                
                mensajeOriginal.append(caracterDesencriptado);
                            
            } else {
                mensajeOriginal.append(caracter);
            }
        }
        return mensajeOriginal.toString();
    }
      
    public static void main(String[] args) {
        String mensajeOriginal = JOptionPane.showInputDialog("Ingrese el mensaje que se va a encriptar");

        int clave = 3;
        String mensajeEncriptado = encriptar(mensajeOriginal, clave);

        JOptionPane.showMessageDialog(null, "Mensaje original: " + mensajeOriginal);
        System.out.println("Mensaje original: "+mensajeOriginal);
        JOptionPane.showMessageDialog(null, "Mensaje encriptado: " + mensajeEncriptado);
        System.out.println("Mensaje encriptado: "+mensajeEncriptado);

        String mensajeDesencriptado = desencriptar(mensajeEncriptado, clave);

        JOptionPane.showMessageDialog(null, "Mensaje encriptado: " + mensajeEncriptado);
        System.out.println("Mensaje encriptado: "+mensajeEncriptado);
        JOptionPane.showMessageDialog(null, "Mensaje desencriptado: " + mensajeDesencriptado);
        System.out.println("Mensaje desencriptado: "+mensajeDesencriptado);
    }
   
}
