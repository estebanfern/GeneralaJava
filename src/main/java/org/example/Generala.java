package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.File;

public class Generala {
    String jugada(String dados) {
        if (dados.length() > 5) {
            return "INVALIDO";
        }
        int [] values = new int[6];
        for (char e : dados.toCharArray()) values[Character.getNumericValue(e)-1]++;
        if (isGenerala(values)) return "GENERALA";
        if (isPoker(values)) return "POKER";
        if (isFull(values)) return "FULL";
        if (isEscalera(values)) return "ESCALERA";
        return "NADA";
    }
    
    public static boolean isGenerala(int [] values){
        for (int e : values) {
            if (e == 5) {
                return true;
            }else if (e < 5 && e > 0){
                return false;
            }
        }
        return false;
    }
    
    public static boolean isPoker(int [] values) {
        for (int e : values) {
            if (e == 4) {
                return true;
            }else if (e != 1 && e != 0) {
                return false;
            }
        }
        return false;
    }
    
    public static boolean isFull(int [] values) {
        boolean dos = false, tres = false;
        for (int e : values) {
            if (e == 3) {
                tres = true;
            }else if (e == 2) {
                dos = true;
            }else if (e != 0) {
                return false;
            }
        }
        return (dos && tres);
    }

    public static boolean isEscalera(int [] values) {
        return ((values[0] == 1 && values[1] == 1 && values[2] == 1 && values[3] == 1 && values[4] == 1 && values[5] == 0)
                ||
                (values[0] == 0 && values[1] == 1 && values[2] == 1 && values[3] == 1 && values[4] == 1 && values[5] == 1)
                ||
                (values[0] == 1 && values[1] == 0 && values[2] == 1 && values[3] == 1 && values[4] == 1 && values[5] == 1));
    }
    
    public static void print(int [] arr) {
        for (int k = 0; k < 5; k++) {
            System.out.printf("%d\t", arr[k]);
        }
        System.out.println();
        
    }


    // Ustedes pueden ignorar esto
    String[] jugadas(String[] losdados) {
        String[] ret = new String[losdados.length];
        int i = 0;
        for (String dados : losdados) {
            ret[i] = this.jugada(dados);
            i++;
        }
        return ret;
    }

    static String[] processBatch(String fileName) throws Exception {
        Scanner sc = new Scanner(new File(fileName));
        List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        return lines.toArray(new String[0]);
    }

    public static String generar() {
        Random rd = new Random();
        String cad = "";
        for (int k = 0; k < 5; k++) {
            cad = cad + String.valueOf(rd.nextInt(6) + 1);
        }
        return cad;
    }

    public static void main(String[] args) throws Exception {
        Generala g = new Generala();
        // IGNORAR PORQUE ESTO NO SE VA A EJECUTAR PARA USTEDES
        if (args.length > 0) {
            String[] jugadas = processBatch(args[0]);
            String resultados[] = g.jugadas(jugadas);
            for(String res : resultados) {
            System.out.println(res);
        }
        return;
        }
        // ESTO SI SE EJECUTA PARA USTEDES
        System.out.println("11111 ---> " + g.jugada("11111"));
        System.out.println("33133 ---> " + g.jugada("33133"));
        System.out.println("55353 ---> " + g.jugada("55353"));
        System.out.println("12345 ---> " + g.jugada("12345"));
        System.out.println("23456 ---> " + g.jugada("23456"));
        System.out.println("34561 ---> " + g.jugada("34561"));
        System.out.println("45612 ---> " + g.jugada("45612"));
        System.out.println("456121 ---> " + g.jugada("456121"));

        System.out.println("\t\tGENERANDO NUMEROS ALEATORIOS");
        String gen;
        for (int k = 0; k < 100; k++) {
            gen = generar();
            System.out.println(gen + " ---> " + g.jugada(gen));
        }
    }
}
