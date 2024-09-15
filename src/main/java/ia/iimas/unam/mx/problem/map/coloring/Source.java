package ia.iimas.unam.mx.problem.map.coloring;

import ia.iimas.unam.mx.model.IConstraint;
import ia.iimas.unam.mx.model.IDomain;
import ia.iimas.unam.mx.model.ISource;
import ia.iimas.unam.mx.model.IVariable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class Source implements ISource {

    private static Set<IDomain> domain;
    private static Set<IVariable> variables;
    private static Set<IConstraint> constraints;

    public static final String FILE_PATH_50 = "src/main/resources/gc_50_7";

    public static final String FILE_PATH_1000 = "src/main/resources/gc_1000_9";

    private static String FILE_PATH;


    private static int customColors = 7;

    public static Set<IVariable> getVariables(){

        variables = new HashSet<>();

        if(FILE_PATH!=null){
            getNodesFromFile(FILE_PATH);
        }else {
            getNodesFromFile(FILE_PATH_50);
        }

        return variables;

    }

    public static Set<IDomain> getDomain() {
        Source source = new Source();
        source.domain = new HashSet<>();
        while(domain.size()< source.customColors){
            IDomain color = new Color(Color.getRandomColor());
            domain.add(color);
        }
        return source.domain;
    }


    public static Set<IConstraint> getConstraints(){
        Source source = new Source();
        source.constraints = new HashSet<>();

        source.constraints.add(MapColoringConstraint.DIFFERENT_COLOR);

        return source.constraints;
    }

    public static void setCustomNumberColors(int custom){
        customColors = custom;
    }

    private static void getNodesFromFile(String file)  {
        boolean firstRead = true;
        BufferedReader br;
        String line;
        String[] parts;
        try{
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                parts = line.split(" ");
                if (firstRead){
                    firstRead = !firstRead;
                    generateNodesFromFile(parts);
                }else {
                    IVariable node_find = new NodeColor(Integer.parseInt(parts[0]));
                    IVariable neighbor_find = new NodeColor(Integer.parseInt(parts[1]));
                    IVariable node = getNode(node_find);
                    IVariable neighbor= getNode(neighbor_find);
                    node.addNeighbor(neighbor);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void generateNodesFromFile(String[] parts){
        for (int i = 0; i < Integer.parseInt(parts[0]); i++){
            variables.add(new NodeColor(i));
        }
    }

    private static IVariable getNode(IVariable node){
        for (IVariable v: variables){
            if(node.equals(v)){
                return v;
            }
        }
        return null;
    }

    public static void setFilePath(String filePath){
        if (FILE_PATH_50.equals(filePath)){
            FILE_PATH = FILE_PATH_50;
        } else if (FILE_PATH_1000.equals(filePath)) {
            FILE_PATH = FILE_PATH_1000;
        }else {
            FILE_PATH = filePath;
        }
    }

}
