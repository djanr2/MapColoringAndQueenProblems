package ia.iimas.unam.mx.problem.map.coloring;

import ia.iimas.unam.mx.model.IConstraint;
import ia.iimas.unam.mx.model.IDomain;
import ia.iimas.unam.mx.model.IVariable;
import ia.iimas.unam.mx.model.SourceFromFile;

import java.util.HashSet;


public class MapColoring extends SourceFromFile {

    public MapColoring() {
        this.generalDomain = (HashSet<IDomain>) Source.getDomain();
        this.generalConstraints = (HashSet<IConstraint>) Source.getConstraints();
        configureNodes();
    }

    public void configureNodes() {
       this.arcs =  (HashSet<IVariable>) Source.getVariables();
       for(IVariable var: this.arcs){
           NodeColor node = (NodeColor) var;
           node.setConstrains(this.generalConstraints);
           node.setDomain(this.generalDomain);
       }
    }


}
