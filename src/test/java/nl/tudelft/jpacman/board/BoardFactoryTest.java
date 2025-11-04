package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import nl.tudelft.jpacman.sprite.PacManSprites;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Chananphimon C.
 */
class BoardFactoryTest {

    private BoardFactory boardFactory;
    private PacManSprites sprites;

    /**
     * Set up the test fixtures.
     * Creates a mock PacManSprites and BoardFactory before each test.
     */
    @BeforeEach
    void setUp() {
        sprites = mock(PacManSprites.class);
        boardFactory = new BoardFactory(sprites);
    }

    /**
     * Test that BoardFactory is created successfully.
     */
    @Test
    void testBoardFactoryCreation() {
        assertThat(boardFactory).isNotNull();
    }

    /**
     * Test creating a simple 1x1 board.
     * Verifies that the board is created with correct dimensions.
     */
    @Test
    void testCreateBoard1x1() {
        // Create a 1x1 grid
        Square[][] grid = new Square[1][1];
        grid[0][0] = new BasicSquare();

        // Create the board
        Board board = boardFactory.createBoard(grid);

        // Verify board dimensions
        assertThat(board).isNotNull();
        assertThat(board.getWidth()).isEqualTo(1);
        assertThat(board.getHeight()).isEqualTo(1);
    }

    /**
     * Test creating a 2x2 board.
     * Verifies correct dimensions and that all squares are accessible.
     */
    @Test
    void testCreateBoard2x2() {
        // Create a 2x2 grid
        Square[][] grid = new Square[2][2];
        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 2; y++) {
                grid[x][y] = new BasicSquare();
            }
        }

        // Create the board
        Board board = boardFactory.createBoard(grid);

        // Verify board dimensions
        assertThat(board.getWidth()).isEqualTo(2);
        assertThat(board.getHeight()).isEqualTo(2);

        // Verify all squares are accessible
        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 2; y++) {
                assertThat(board.squareAt(x, y)).isNotNull();
            }
        }
    }


    /**
     * Test creating a ground square.
     * Verifies that ground squares are accessible to units.
     */
    @Test
    void testCreateGround() {
        Square ground = boardFactory.createGround();

        assertThat(ground).isNotNull();

        // Ground should be accessible to any unit
        Unit unit = new BasicUnit();
        assertThat(ground.isAccessibleTo(unit)).isTrue();
    }

    /**
     * Test creating a wall square.
     * Verifies that wall squares are NOT accessible to units.
     */
    @Test
    void testCreateWall() {
        Square wall = boardFactory.createWall();

        assertThat(wall).isNotNull();

        // Wall should NOT be accessible to any unit
        Unit unit = new BasicUnit();
        assertThat(wall.isAccessibleTo(unit)).isFalse();
    }

}
