package ia.iimas.unam.mx;

import ia.iimas.unam.mx.algorithm.ICSPAlgortithm;
import ia.iimas.unam.mx.model.IPropertiesCSP;
import ia.iimas.unam.mx.problem.map.coloring.BacktrackSolution;
import ia.iimas.unam.mx.problem.map.coloring.MapColoring;
import ia.iimas.unam.mx.problem.map.coloring.Source;
import ia.iimas.unam.mx.problem.queen.BacktrackingSolution;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int option=0;
        int option2=0;
        ICSPAlgortithm algoritmo;

        System.out.println();
        System.out.println("Este programa resuelve el problema de coloreado de grafos o N reinas con el algoritmo Backtrack");
        System.out.println("Selecciona:");
        System.out.println("1. Coloreado de grafos");
        System.out.println("2. N Reinas");

        try{
            while (option != 1 && option !=2){
                System.out.print("> ");
                option = s.nextInt();
            }
        }catch (Exception e ){
            System.out.println("Opcion no valida");
            System.exit(0);
        }
        switch (option){
            case 1:
                System.out.println("Selecciona el problema:");
                System.out.println("1. 50 elementos");
                System.out.println("2. 1000 elementos");
                try{
                    while (option2 != 1 && option2 !=2){
                        System.out.print("> ");
                        option2 = s.nextInt();
                    }
                }catch (Exception e ){
                    System.out.println("Opcion no valida");
                    System.exit(0);
                }
                if(option2 == 1){
                    Source.setFilePath(Source.FILE_PATH_50);
                }else if(option2 == 2){
                    Source.setFilePath(Source.FILE_PATH_1000);
                }

                System.out.println("Selecciona el numero de colores:");
                System.out.print("> ");

                try{
                    option2 = s.nextInt();
                }catch (Exception e ){
                    System.out.println("Opcion no valida");
                    System.exit(0);
                }
                Source.setCustomNumberColors(option2);

                System.out.println("los colores seran elegidos de manera random y seran mostrados en su for ma hexadecimal: ejemplo 0xFFFFFF");
                System.out.println();

                System.out.println("Activar una pausa despues de encontrar un resultado? (Default NO, mostrara todos los resultados)");
                System.out.println("Presiona 1 para activar pausa");
                System.out.print("> ");
                try{
                    option2 = s.nextInt();
                }catch (Exception e ){
                    System.out.println("Opcion no valida");
                    System.exit(0);
                }

                IPropertiesCSP mcProblem = new MapColoring();
                algoritmo =  new BacktrackSolution();
                algoritmo.setCsp(mcProblem);
                ((BacktrackSolution)algoritmo).setClickSetting(option2==1);
                algoritmo.run();
                break;
            case 2:
                System.out.println("Selecciona el numero de reinas:");
                System.out.print("> ");

                try{
                    option2 = s.nextInt();
                }catch (Exception e ){
                    System.out.println("Opcion no valida");
                    System.exit(0);
                }

                algoritmo =  new BacktrackingSolution();
                ((BacktrackingSolution)algoritmo).setQueenNum(option2);

                System.out.println("Activar una pausa despues de encontrar un resultado? (Default NO, mostrara todos los resultados)");
                System.out.println("Presiona 1 para activar pausa");
                System.out.print("> ");
                try{
                    option2 = s.nextInt();
                }catch (Exception e ){
                    System.out.println("Opcion no valida");
                    System.exit(0);
                }

                ((BacktrackingSolution)algoritmo).setClickSetting(option2==1);

                algoritmo.run();

                break;
        }
    }
}
