package ia.iimas.unam.mx.problem.queen;

import ia.iimas.unam.mx.model.IConstraint;
import ia.iimas.unam.mx.model.IDomain;
import ia.iimas.unam.mx.model.IVariable;
import ia.iimas.unam.mx.problem.map.coloring.NodeColor;

import java.util.Set;

public class Queen implements IVariable {
    private int row;
    private int column;

    public Queen(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public Set<IConstraint> getConstraints() {
        return null;
    }

    @Override
    public void setConstrains(Set<IConstraint> constrains) {

    }

    @Override
    public Set<IDomain> getDomain() {
        return null;
    }

    @Override
    public void setDomain(Set<IDomain> constrains) {

    }

    @Override
    public boolean removeDomainElement(IDomain domain) {
        return false;
    }

    @Override
    public boolean removeConstraint(IConstraint element) {
        return false;
    }

    @Override
    public boolean addDomainElement(IDomain element) {
        return false;
    }

    @Override
    public boolean addConstraintElement(IConstraint element) {
        return false;
    }

    @Override
    public void setNeighbors(Set<IVariable> neighbors) {

    }

    @Override
    public Set<IVariable> getNeighbors() {
        return null;
    }

    @Override
    public boolean addNeighbor(IVariable element) {
        return false;
    }

    @Override
    public boolean removeNighbor(IVariable element) {
        return false;
    }

    @Override
    public int countLegalValues() {
        return 0;
    }

    @Override
    public NodeColor cloneElement() {
        return null;
    }

    @Override
    public final int hashCode() {
        int result = 1000;
        result=column*result;
        result=row*result;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Queen)) {
            return false;
        }
        Queen c = (Queen) o;
        return this.row==c.getRow()&&this.column==c.getColumn();
    }

    @Override
    public String toString(){
        return this.column+":"+this.row;
    }

}
