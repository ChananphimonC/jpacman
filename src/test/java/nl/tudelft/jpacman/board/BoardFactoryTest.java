package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the linking of squares and board creation by BoardFactory.
 *
 * @author
 *     Chananphimon C.
 */
class BoardFactoryTest {

    private BoardFactory boardFactory;
    private PacManSprites sprites;

    /**
     * Sets up a mock PacManSprites and BoardFactory before each test.
     */
    @BeforeEach
    void setUp() {
        sprites = mock(PacManSprites.class);
        boardFactory = new BoardFactory(sprites);
    }

    /**
     * Verifies that BoardFactory is created successfully.
     */
    @Test
    void testBoardFactoryCreation() {
        assertThat(boardFactory).isNotNull();
    }

//    /**
//     * Verifies creating a simple 1x1 board with correct dimensions.
//     */
//    @Test
//    void testCreateBoard1x1() {
//        Square[][] grid = new Square[1][1];
//        grid[0][0] = new BasicSquare();
//
//        Board board = boardFactory.createBoard(grid);
//
//        assertThat(board).isNotNull();
//        assertThat(board.getWidth()).isEqualTo(1);
//        assertThat(board.getHeight()).isEqualTo(1);
//    }

//    /**
//     * Verifies creating a 2x2 board with correct dimensions and accessibility.
//     */
//    @Test
//    void testCreateBoard2x2() {
//        Square[][] grid = new Square[2][2];
//        for (int x = 0; x < 2; x++) {
//            for (int y = 0; y < 2; y++) {
//                grid[x][y] = new BasicSquare();
//            }
//        }
//
//        Board board = boardFactory.createBoard(grid);
//
//        assertThat(board.getWidth()).isEqualTo(2);
//        assertThat(board.getHeight()).isEqualTo(2);
//
//        for (int x = 0; x < 2; x++) {
//            for (int y = 0; y < 2; y++) {
//                assertThat(board.squareAt(x, y)).isNotNull();
//            }
//        }
//    }

    /**
     * Verifies that createGround() returns an accessible square.
     */
    @Test
    void testCreateGround() {
        Square ground = boardFactory.createGround();
        assertThat(ground).isNotNull();

        Unit unit = new BasicUnit();
        assertThat(ground.isAccessibleTo(unit)).isTrue();
    }

    /**
     * Verifies that createWall() returns a non-accessible square.
     */
    @Test
    void testCreateWall() {
        Square wall = boardFactory.createWall();
        assertThat(wall).isNotNull();

        Unit unit = new BasicUnit();
        assertThat(wall.isAccessibleTo(unit)).isFalse();
    }
}
