package ia.iimas.unam.mx.problem.map.coloring;

import ia.iimas.unam.mx.algorithm.BacktrackingAlgorithm;
import ia.iimas.unam.mx.model.IDomain;
import ia.iimas.unam.mx.model.IPropertiesCSP;
import ia.iimas.unam.mx.model.IVariable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class BacktrackSolution  extends BacktrackingAlgorithm {

    private ArrayList<IVariable> node_list;

    private static boolean  clickSetting = true;

    @Override
    public void setCsp(IPropertiesCSP csp) {
        this.csp = csp;
    }

    @Override
    public void run() {
        System.out.println();
        System.out.println("Este programa ejecuta el algoritmo BACKTRACKING para el problema de seleccion de colores");
        System.out.println("encontrara todas las soluciones posibles para el problema");
        System.out.println();

        node_list = new ArrayList<>(this.csp.getArcs());

        System.out.println(node_list);
        System.out.println();

       backtrack(node_list.get(0), new HashSet<>());
    }

    private void backtrack( IVariable current_country,  Set<NodeColor> solution){

        int index;

        NodeColor nodeColor = (NodeColor) current_country;

        for(IDomain color : cloneDomain(nodeColor.getDomain())){
            if(nodeColor.setColor(color)){
                index = node_list.indexOf(nodeColor);
                index++;
                solution.add(nodeColor);
                if(index< node_list.size()) {
                    backtrack(node_list.get(index), solution);
                    nodeColor.removeColor();
                    solution.remove(nodeColor);
                }else{
                    System.out.println(solution);
                    nodeColor.removeColor();
                    solution.remove(nodeColor);
                    if(clickSetting){
                        click();
                    }
                }
            }
        }
    }

    private HashSet<IDomain> cloneDomain(Set<IDomain> domain){
        return new HashSet<>(domain);
    }

    public static void click(){
        try{
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setClickSetting(boolean clickSetting) {
        this.clickSetting = clickSetting;
    }
}
