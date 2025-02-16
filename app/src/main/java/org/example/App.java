package org.example;

import java.util.Random;

// Node class for Circular Linked List
class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

// Circular Linked List class
class CircularLinkedList<T> {
    private Node<T> head;
    private Node<T> current;
    private Random random;

    public CircularLinkedList() {
        this.head = null;
        this.current = null;
        this.random = new Random();
    }

    // Append a node to the circular linked list
    public void append(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node<T> temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }

        if (current == null) {
            current = head;
        }
    }

    // Retrieve data from the current node
    public T getCurrentNode() {
        if (current != null) {
            return current.data;
        } else {
            throw new RuntimeException("List is empty");
        }
    }

    // Step forward in the circular linked list
    public void step() {
        if (current != null) {
            current = current.next;
        }
    }

    // Roll two six-sided dice and move forward
    public void rollAndMove() {
        int roll = random.nextInt(6) + 1 + random.nextInt(6) + 1;
        System.out.println("Rolled: " + roll);
        for (int i = 0; i < roll; i++) {
            step();
        }
    }
}

public class App {
    public static void main(String[] args) {
        CircularLinkedList<String> monopolyBoard = new CircularLinkedList<>();
        monopolyBoard.append("Go");
        monopolyBoard.append("Mediterranean Avenue");
        monopolyBoard.append("Community Chest");
        monopolyBoard.append("Baltic Avenue");
        monopolyBoard.append("Income Tax");

        System.out.println("Starting at: " + monopolyBoard.getCurrentNode());

        monopolyBoard.step();
        System.out.println("Moved to: " + monopolyBoard.getCurrentNode());

        monopolyBoard.rollAndMove();
        System.out.println("After rolling dice, landed on: " + monopolyBoard.getCurrentNode());
    }
}
