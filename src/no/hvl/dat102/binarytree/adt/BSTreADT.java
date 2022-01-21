package no.hvl.dat102.binarytree.adt;

public interface BSTreADT<T extends Comparable<T>> {

    /**
     *
     * @return the number of elements in the tree
     */
    int antall();

    /**
     * returns a boolean determining if the tree is empty
     * @return true if the binary tree is empty, false otherwise
     */
    boolean erTom();

    /**
     * adds the specified element to the binary search tree
     * equal elements are added to the right
     *
     * @param element the element to be added
     */
    void leggTil(T element);

    /**
     * Returns a reference to the specified element if it exists in the tree
     *
     * @param element the element to be found
     * @return a reference to the element if found, null otherwise
     */
    T finn(T element);

    /**
     * returns a reference to the smallest element in the tree
     * @return a reference to the element if found, null otherwise
     */
    T finnMin();

    /**
     * returns a reference to the largest element in the tree
     * @return a reference to the element if found, null otherwise
     */
     T finnMaks();

  //  /**
  //   * removes an element from the tree and returns a reference to the removed element
  //   *
  //   * @param element the element to be removed
  //   * @return a reference to the removed element if found, null otherwise
  //   */
  //  T fjern(T element);

    /**
     * removes the smallest element from the tree
     *
     * @return a reference to the removed element if found, null otherwise
     */
    T fjernMin();

    /**
     * removes the largest element from the tree
     *
     * @return a reference to the removed element if found, null otherwise
     */
    T fjernMaks();
}