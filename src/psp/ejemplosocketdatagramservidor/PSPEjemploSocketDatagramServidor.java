/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp.ejemplosocketdatagramservidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 *
 * @author pedro argibay
 */
public class PSPEjemploSocketDatagramServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println("Creando DatagramServer");

            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
            DatagramSocket datagramSocket = new DatagramSocket(addr);

            System.out.println("Recibiendo mensaje");

            byte[] mensaje = new byte[25];
            DatagramPacket datagrama1 = new DatagramPacket(mensaje, 25);
            datagramSocket.receive(datagrama1);

            System.out.println("Mensaje recibido: " + new String(mensaje));

            System.out.println("Enviando mensaje");

            InetAddress addr2 = InetAddress.getByName("localhost");
            DatagramPacket datagrama2 = new DatagramPacket(mensaje, mensaje.length, addr2, 5556);
            datagramSocket.send(datagrama2);

            System.out.println("Mensaje enviado");

            System.out.println("Cerrando el DatagramServer");

            datagramSocket.close();

            System.out.println("Terminado con éxito");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
