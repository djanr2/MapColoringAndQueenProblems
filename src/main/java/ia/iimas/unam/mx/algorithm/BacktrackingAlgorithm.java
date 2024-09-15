package ia.iimas.unam.mx.algorithm;

import ia.iimas.unam.mx.model.IPropertiesCSP;
import ia.iimas.unam.mx.model.IVariable;
import ia.iimas.unam.mx.problem.map.coloring.NodeColor;

public abstract class BacktrackingAlgorithm implements ICSPAlgortithm{

    protected IPropertiesCSP csp;

    @Override
    public IPropertiesCSP getCsp() {
        return csp;
    }
    @Override
    public void setCsp(IPropertiesCSP csp) {
        this.csp = csp;
    }

}
