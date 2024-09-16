package ia.iimas.unam.mx.problem.queen;

import ia.iimas.unam.mx.model.IConstraint;
import ia.iimas.unam.mx.model.IVariable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Board implements IConstraint {

    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";



    private Set<IVariable> queens;

    private int queenNumber;

    public Board (int number){
        this.queenNumber = number;
        this.queens = new HashSet<>();
    }



    @Override
    public boolean areConstrained(IVariable a, IVariable b) {
        Queen qa = (Queen) a;
        Queen qb = (Queen) b;

        int row = qa.getRow();
        int column = qa.getColumn();

        if(qa.getRow() == qb.getRow() || qa.getColumn() == qb.getColumn()) {
            return true;
        }
        while (row>=0&&column<this.queenNumber){
            if(isSamePosition(qb, row, column)){
               return true;
            }
            row--;
            column++;
        }
        row = qa.getRow();
        column = qa.getColumn();
        while (row<this.queenNumber&&column>=0){
            if(isSamePosition(qb, row, column)){
                return true;
            }
            row ++;
            column--;
        }
        row = qa.getRow();
        column = qa.getColumn();

        while (row>=0&&column>=0){
            if(isSamePosition(qb, row, column)){
                return true;
            }
            row--;
            column--;
        }
        row = qa.getRow();
        column = qa.getColumn();
        while (row<this.queenNumber&&column<this.queenNumber){
            if(isSamePosition(qb, row, column)){
                return true;
            }
            row++;
            column++;
        }
        return false;
    }

    private boolean isSamePosition(Queen qb, int row, int column){
        if(qb.getColumn()==column && qb.getRow()==row){
            return true;
        }
        return false;
    }

    public Set<IVariable> getQueens() {
        return queens;
    }

    @Override
    public String toString(){
        boolean colorCol=true;

        for (int row = 0; row < this.queenNumber; row++){
            boolean colorRow = !colorCol;
            for (int col = 0; col < this.queenNumber;col ++){

                if(colorRow){
                    colorRow =!colorRow;
                    if(findQueen(row,col)){
                        System.out.print(ANSI_BLACK_BACKGROUND + ANSI_WHITE + " "+Character.toString('\u265B')+ " " + ANSI_RESET);
                    }else {
                        System.out.print(ANSI_BLACK_BACKGROUND + ANSI_BLACK + " "+Character.toString('\u265B')+ " " + ANSI_RESET);
                    }
                }else{
                    colorRow =!colorRow;
                    if(findQueen(row,col)){
                        System.out.print(ANSI_WHITE_BACKGROUND + ANSI_BLACK + " "+Character.toString('\u265B')+ " " + ANSI_RESET);
                    }else {
                        System.out.print(ANSI_WHITE_BACKGROUND + ANSI_WHITE + " "+Character.toString('\u265B') + " "+ ANSI_RESET);
                    }
                }
            }
            colorCol=!colorCol;
            System.out.println();
        }
        return "";
    }

    private boolean findQueen(int row, int col){
        Queen q = new Queen(row, col);
        if (this.queens.contains(q)){
            return true;
        }
        return false;
    }

    public int getQueenNumber() {
        return queenNumber;
    }

    public boolean hasConstraintWithQueens(Queen qa){
        for (IVariable queen: this.queens){
            if(this.areConstrained(queen, qa)){
                return true;
            }
        }
        return false;
    }
}
