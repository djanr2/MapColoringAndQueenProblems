package ia.iimas.unam.mx.problem.queen;

import ia.iimas.unam.mx.algorithm.BacktrackingAlgorithm;
import ia.iimas.unam.mx.model.IPropertiesCSP;

import java.io.IOException;

public class BacktrackingSolution extends BacktrackingAlgorithm {

    private static boolean  clickSetting = false;

    private int queenNum;
    @Override
    public void run() {

        System.out.println();
        System.out.println("Este programa ejecuta el algoritmo BACKTRACKING para el problema de n reinas");
        System.out.println("encontrara todas las soluciones posibles para el problema");
        System.out.println();

        IPropertiesCSP queenPorperties = new QueenProperties(this.queenNum);
        Board board = ((QueenProperties)queenPorperties).getBoard();

        backtrack(0, board);

    }

    private void backtrack(int col, Board board){
        Queen q;
        int nextCol;
        for (int row=0;row < board.getQueenNumber();row++){
            q=new Queen(row, col);
            if(!board.hasConstraintWithQueens(q)){
                board.getQueens().add(q);
                if(board.getQueens().size()==board.getQueenNumber()){
                    System.out.println(board);
                    System.out.println();
                    if(clickSetting){
                        click();
                    }
                }
                nextCol = col+1;
                if(nextCol < board.getQueenNumber()){
                    backtrack(nextCol, board);
                    board.getQueens().remove(q);
                }
            }
            board.getQueens().remove(q);
        }
    }

    public static void click(){
        try{
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setQueenNum(int queenNum) {
        this.queenNum = queenNum;
    }

    public void setClickSetting(boolean clickSetting) {
        this.clickSetting = clickSetting;
    }
}
