package no.hvl.dat102.binarytree;

import no.hvl.dat102.binarytree.adt.BSTreADT;

import java.util.Iterator;

public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T>, Iterable<T> {

    private int antall;
    private BinaerTreNode<T> rot;

    public KjedetBSTre() {
        antall = 0;
        rot = null;
    }

    public KjedetBSTre(T element) {
        rot = new BinaerTreNode<>(element);
        antall = 1;
    }

    public int antall() {
        return antall;
    }

    public boolean erTom() {
        return (antall == 0);
    }

    public void leggTil(T element) {
        if (erTom()) {
            rot = new BinaerTreNode<>(element);
        } else {
            leggTilRek(rot, element);
        }
        antall++;
    }

    private void leggTilRek(BinaerTreNode<T> p, T element) {
        if (element.compareTo(p.getElement()) < 0) {
            if (p.getVenstre() == null){
                p.setVenstre(new BinaerTreNode<>(element));
            } else {
                leggTilRek(p.getVenstre(), element);
            }
        } else {
            if (p.getHoyre() == null) {
                p.setHoyre(new BinaerTreNode<>(element));
            } else {
                leggTilRek(p.getHoyre(), element);
            }
        }
    }


    public void leggTil2(T element) {
        //
    }

    public T fjernMin() {
        T resultat;

        if (rot.getVenstre() == null) {
            resultat = rot.getElement();
            rot = rot.getHoyre();
        } else {
            BinaerTreNode<T> forelder = rot;
            BinaerTreNode<T> aktuell = rot.getVenstre();
            while (aktuell.getVenstre() != null) {
                forelder = aktuell;
                aktuell = aktuell.getVenstre();
            }
            resultat = aktuell.getElement();
            forelder.setVenstre(aktuell.getHoyre());
        }
        return resultat;
    }//

    public T fjernMaks() {
        T resultat;

        if (rot.getHoyre() == null) {
            resultat = rot.getElement();
            rot = rot.getVenstre();
        } else {
            BinaerTreNode<T> forelder = rot;
            BinaerTreNode<T> aktuell = rot.getHoyre();
            while (aktuell.getHoyre() != null) {
                forelder = aktuell;
                aktuell = aktuell.getHoyre();
            }
            resultat = aktuell.getElement();
            forelder.setVenstre(aktuell.getHoyre());
        }
        return resultat;
    }//

    public T finnMin() {
        if (erTom()) {
            return null;
        }

        if (rot.getVenstre() == null) {
            return rot.getElement();
        } else {
            BinaerTreNode<T> aktuell = rot.getVenstre();
            while (aktuell.getVenstre() != null) {
                aktuell = aktuell.getVenstre();
            }
            return aktuell.getElement();
        }
    }

    public T finnMaks() {
        if (erTom()) {
            return null;
        }

        if (rot.getHoyre() == null) {
            return rot.getElement();
        } else {
            BinaerTreNode<T> aktuell = rot.getHoyre();
            while (aktuell.getHoyre() != null) {
                aktuell = aktuell.getHoyre();
            }
            return aktuell.getElement();
        }
    }


    public T finn(T element) {
        if (erTom()) {
            return null;
        }
        return finnRek(element, rot);
    }

    private T finnRek(T element, BinaerTreNode<T> node) {
        if (element.compareTo(node.getElement()) == 0) {
            return element;
        } else if (node.getHoyre() == null  && node.getVenstre() == null) {
            return null;
        } else if (element.compareTo(node.getElement()) < 0) {
            return finnRek(element, node.getVenstre());
        } else {
            return finnRek(element, node.getHoyre());
        }
    }


    public T finn2(T element) {
        if (erTom()) {
            return null;
        }

        BinaerTreNode<T> aktuell = rot;
        while (aktuell != null) {
            if (element.compareTo(aktuell.getElement()) == 0) {
                return element;
            } else if (element.compareTo(aktuell.getElement()) < 0) {
                aktuell = aktuell.getVenstre();
            } else {
                aktuell = aktuell.getHoyre();
            }
        }

        return null;
    }

    public void visInorden() {
        visInorden(rot);
        System.out.println();
    }

    private void visInorden(BinaerTreNode<T> p) {
        if (p != null) {
            visInorden(p.getVenstre());
            System.out.print(" " + p.getElement());
            visInorden(p.getHoyre());
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new InordenIterator<>(rot);

    }

    /**
     * Oppg 2A
     */
    public int hoyde() {
        return hoydeRek(rot);
    }

    private int hoydeRek(BinaerTreNode<T> node) {
        if (node == null) {
            return -1;
        } else {
            return 1 + Math.max(hoydeRek(node.getVenstre()), hoydeRek(node.getHoyre()));
        }
    }


    public static int teoretiskMinHoyde(int n) {
        return (int) (Math.round(Math.log(n)/Math.log(2)));
    }


    public static int teoretiskMaksHoyde(int n) {
        return n - 1;
    }
}