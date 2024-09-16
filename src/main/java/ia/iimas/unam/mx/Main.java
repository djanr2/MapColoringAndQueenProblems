package ia.iimas.unam.mx;

import ia.iimas.unam.mx.algorithm.ICSPAlgortithm;
import ia.iimas.unam.mx.problem.queen.BacktrackingSolution;
import ia.iimas.unam.mx.problem.queen.Board;
import ia.iimas.unam.mx.problem.queen.Queen;

public class Main {
    public static void main(String[] args) {

        Board b = new Board(4);

       // Queen q1 = new Queen(0,0);
        Queen q2 = new Queen(1,0);

        System.out.println(q2);

        if(!b.hasConstraintWithQueens(q2)){
            System.out.println("Entro 2");
            b.getQueens().add(q2);
        }

        //System.out.println(b.areConstrained(q1,q2));;

        System.out.println(b);

        ICSPAlgortithm algoritmo =  new BacktrackingSolution();


        algoritmo.run();

/*        Source.setFilePath(Source.FILE_PATH_50);
        Source.setCustomNumberColors(7);

        IPropertiesCSP mcProblem = new MapColoring();
        ICSPAlgortithm algoritmo =  new BacktrackSolution();

        algoritmo.setCsp(mcProblem);
        algoritmo.run();*/
    }
}
