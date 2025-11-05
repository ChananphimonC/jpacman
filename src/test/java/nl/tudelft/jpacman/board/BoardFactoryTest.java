package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the linking of squares and board creation by BoardFactory.
 *
 * @author Chananphimon C.
 */
class BoardFactoryTest {

    private BoardFactory boardFactory;
    private PacManSprites sprites;

    /** Sets up a mock PacManSprites and BoardFactory before each test. */
    @BeforeEach
    void setUp() {
        sprites = mock(PacManSprites.class);
        boardFactory = new BoardFactory(sprites);
    }

    /** Verifies that BoardFactory is created successfully. */
    @Test
    void testBoardFactoryCreation() {
        assertThat(boardFactory).isNotNull();
    }

    /** Verifies that createGround() returns an accessible square. */
    @Test
    void testCreateGround() {
        Square ground = boardFactory.createGround();
        assertThat(ground).isNotNull();

        Unit unit = new BasicUnit();
        assertThat(ground.isAccessibleTo(unit)).isTrue();
    }

    /** Verifies that createWall() returns a non-accessible square. */
    @Test
    void testCreateWall() {
        Square wall = boardFactory.createWall();
        assertThat(wall).isNotNull();

        Unit unit = new BasicUnit();
        assertThat(wall.isAccessibleTo(unit)).isFalse();
    }
}
