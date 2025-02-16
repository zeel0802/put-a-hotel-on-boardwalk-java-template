package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testCircularLinkedList() {
        CircularLinkedList<String> monopolyBoard = new CircularLinkedList<>();
        monopolyBoard.append("Go");
        monopolyBoard.append("Mediterranean Avenue");
        monopolyBoard.append("Community Chest");
        monopolyBoard.append("Baltic Avenue");
        monopolyBoard.append("Income Tax");

        // Check initial position
        assertEquals("Go", monopolyBoard.getCurrentNode());

        // Step forward
        monopolyBoard.step();
        assertEquals("Mediterranean Avenue", monopolyBoard.getCurrentNode());

        // Test looping around (simulate 5 steps)
        monopolyBoard.step();
        monopolyBoard.step();
        monopolyBoard.step();
        monopolyBoard.step();
        assertEquals("Go", monopolyBoard.getCurrentNode());

        // Roll dice and ensure movement (cannot predict exact position)
        monopolyBoard.rollAndMove();
        assertNotNull(monopolyBoard.getCurrentNode());
    }
}
