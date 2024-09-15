package ia.iimas.unam.mx.model;

import java.util.HashSet;

public abstract class SourceFromFile implements IPropertiesCSP {
    protected HashSet<IConstraint> generalConstraints;
    protected HashSet<IDomain> generalDomain;
    protected HashSet<IVariable> arcs;

    public HashSet<IConstraint> getGeneralConstraints() {
        return generalConstraints;
    }

    public HashSet<IDomain> getGeneralDomain() {
        return generalDomain;
    }
    public HashSet<IVariable> getArcs() {
        return arcs;
    }
}
