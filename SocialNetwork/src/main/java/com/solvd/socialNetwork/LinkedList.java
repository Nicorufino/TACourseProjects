package com.solvd.socialNetwork;


import org.apache.log4j.Logger;

import java.util.Queue;

public class LinkedList<T> {
    private Node<T> first;
    private Node<T> last;

    Logger LOGGER = Logger.getLogger(LinkedList.class);

    public LinkedList() {
    }

    public LinkedList(Node<T> first, Node<T> last) {
        this.first = first;
        this.last = last;
    }

    public LinkedList(Node<T> first) {
        this.first = first;
    }

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    public Node<T> getLast() {
        return last;
    }

    public void setLast(Node<T> last) {
        this.last = last;
    }

    public void print() {
        if (this.first.getValue() != null) {

            Node<T> current = this.first;
            if (current.getNext() != null) {
                do {
                    LOGGER.debug(current.getValue());
                    current = current.getNext();
                } while (current.getNext() != null);
                LOGGER.debug(current.getValue());
            } else  {
                LOGGER.debug(current.getValue());
            }
        } else {
            LOGGER.debug("list is empty");
        }
    }

    public void printReverse() {
        if (this.last.getValue() != null) {

            Node<T> current = this.last;
            if (current.getPrevious() != null) {
                do {
                    LOGGER.debug(current.getValue());
                    current = current.getPrevious();
                } while (current.getPrevious() != null);
                LOGGER.debug(current.getValue());
            } else  {
                LOGGER.debug(current.getValue());
            }
        } else {
            LOGGER.debug("list is empty or last item is not specified");
        }
    }

    public void addBefore(Node<T> node, T value){
        Node<T> current = this.first;
        Node<T> prevAux;
        while (value != current.getValue() && current.getNext() != null ) {
            current = current.getNext();
        }
        if (this.first == current) {
            this.first = node;
            current.setPrevious(node);
            node.setNext(current);
        } else {
            if (value == current.getValue()) {
                prevAux = current.getPrevious();
                current.setPrevious(node);
                node.setNext(current);
                node.setPrevious(prevAux);
                prevAux.setNext(node);


            } else {
                LOGGER.debug("Specified value doesn't exist");
            }
        }

    }


    public void addAfter(Node<T> node, T value){
        Node<T> current = this.first;
        Node<T> afterAux;
        while (value != current.getValue() && current.getNext() != null ) {
            current = current.getNext();
        }
        if (this.last == current) {
            this.last = node;
            current.setNext(node);
            node.setPrevious(current);
        } else {
            if (value == current.getValue()) {
                afterAux = current.getNext();
                current.setNext(node);
                node.setPrevious(current);
                node.setNext(afterAux);
                afterAux.setPrevious(node);


            } else {
                LOGGER.debug("Specified value doesn't exist");
            }
        }

    }

}
