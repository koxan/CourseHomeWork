package org.itstep.shaptala;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * Created by shaptala on 12.06.2017.
 */
public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localhost = InetAddress.getLocalHost();
        System.out.println("Host Name: " + localhost.getHostName());
        System.out.println("IP: " + localhost.getHostAddress());

        InetSocketAddress socketAddress = new InetSocketAddress(localhost, 80);
        System.out.println("Socket Host Name: " + socketAddress.getHostName());
        System.out.println("Socket Address: " + socketAddress.getAddress().getHostAddress());
        System.out.println("Port: " + socketAddress.getPort());


    }
}
