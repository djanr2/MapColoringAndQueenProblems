package ia.iimas.unam.mx.problem.map.coloring;

import ia.iimas.unam.mx.model.IDomain;

import java.util.Random;

public class Color implements IDomain {

    private int order;
    private String hexColor;
    public Color(String hexColor){
        this.order  =  Integer.decode(hexColor);
        this.hexColor= hexColor;
    }


    @Override
    public int getOrder(){
        return this.order;
    }

    public static String getRandomColor() {
        final Random random = new Random();
        final String[] letters = "0123456789ABCDEF".split("");
        String color = "0x";
        for (int i = 0; i < 6; i++) {
            color += letters[Math.round(random.nextFloat() * 15)];
        }
        return color;
    }

    @Override
    public String toString(){
        return this.hexColor;
    }

    @Override
    public int hashCode() {
        final int prime = 19;
        int result = 1;
        result = prime * result + this.order;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Color other = (Color) obj;
        if (this.getOrder() != other.getOrder())
            return false;
        return true;
    }


}
