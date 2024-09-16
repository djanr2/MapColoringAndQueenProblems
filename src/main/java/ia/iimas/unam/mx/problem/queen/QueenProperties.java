package ia.iimas.unam.mx.problem.queen;

import ia.iimas.unam.mx.model.IConstraint;
import ia.iimas.unam.mx.model.IDomain;
import ia.iimas.unam.mx.model.IPropertiesCSP;
import ia.iimas.unam.mx.model.IVariable;

import java.util.HashSet;

public class QueenProperties implements IPropertiesCSP {

    private HashSet<IConstraint> constraint;

    private HashSet<IDomain> domain;

    private HashSet<IVariable> variables;

    private Board board;

    public QueenProperties (int num){
        board= new Board(num);
    }



    @Override
    public HashSet<IConstraint> getGeneralConstraints() {
        return this.constraint;
    }

    @Override
    public HashSet<IDomain> getGeneralDomain() {
        return this.domain;
    }

    @Override
    public HashSet<IVariable> getArcs() {
        return this.variables;
    }

    public Board getBoard() {
        return board;
    }
}
