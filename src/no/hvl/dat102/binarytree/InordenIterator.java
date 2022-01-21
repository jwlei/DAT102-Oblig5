package no.hvl.dat102.binarytree;

import java.util.*;


public class InordenIterator<T> implements Iterator<T>{
    private Stack<BinaerTreNode<T>> s = null;
    private BinaerTreNode<T> aktuell = null;


    private BinaerTreNode<T> gaaTilVenstre(BinaerTreNode<T> p){
        if (p == null)
            return null;
        while (p.getVenstre() != null){
            s.push(p);
            p = p.getVenstre();
        }
        return p;
    }


    public InordenIterator(BinaerTreNode<T> rot){
        s = new Stack<BinaerTreNode<T>>();
        aktuell = gaaTilVenstre(rot);
    }


    public boolean hasNext(){
        return (aktuell != null);
    }


    public T next() {
        T resultat = null;

        if(hasNext()){
            resultat = aktuell.getElement();

            if (aktuell.getHoyre() != null)
                aktuell = gaaTilVenstre(aktuell.getHoyre());
            else if (!s.isEmpty())

                aktuell = (BinaerTreNode<T>)s.pop();
            else
                aktuell = null;
        }
        return resultat;
    }

}