package app;

import utils.*;

public class test
{
    public static void main(String[] args)
    {
        String simbolos = "@#$%&01ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        while (true)
        {
            int random = (int) (Math.random() * simbolos.length());

            System.out.print(simbolos.charAt(random));

            Utils.esperar(1);
        }
    }
}
