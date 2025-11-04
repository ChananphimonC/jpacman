package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Tests for the Direction enum.
 *
 * Verifies that each direction (NORTH, EAST, SOUTH, WEST)
 * has the correct X and Y deltas.
 *
 * @author Arie van Deursen
 */
public class DirectionTest {

    /**
     * Tests that moving NORTH gives a delta of (0, -1).
     */
    @Test
    void testNorth() {
        Direction north = Direction.valueOf("NORTH");
        assertThat(north.getDeltaY()).isEqualTo(-1);
    }

    /**
     * Tests that moving EAST gives a delta of (1, 0).
     */
    @Test
    void testEast() {
        Direction east = Direction.valueOf("EAST");
        assertThat(east.getDeltaX()).isEqualTo(1);
    }

    /**
     * Tests that moving SOUTH gives a delta of (0, 1).
     */
    @Test
    void testSouth() {
        Direction south = Direction.valueOf("SOUTH");
        assertThat(south.getDeltaY()).isEqualTo(1);
    }

    /**
     * Tests that moving WEST gives a delta of (-1, 0).
     */
    @Test
    void testWest() {
        Direction west = Direction.valueOf("WEST");
        assertThat(west.getDeltaX()).isEqualTo(-1);
    }
}
