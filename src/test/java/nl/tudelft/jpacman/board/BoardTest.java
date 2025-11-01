package nl.tudelft.jpacman.board;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
/**
 * @author Chananphimon C.
 */
public class BoardTest {
    /**
     * Test case 1: Construct a valid 1x1 board with a correct BasicSquare.
     * This test should pass as the board is valid.
     */
    @Test
    void testValidBoard() {
        Square[][] board = new Square[1][1];
        board[0][0] = new BasicSquare();
        Board actualBoard = new Board(board);
        // Verify the board is created successfully
        assertThat(actualBoard).isNotNull();
        // Test the squareAt method
        Square square = actualBoard.squareAt(0, 0);
        assertThat(square).isNotNull();
        assertThat(square).isEqualTo(board[0][0]);
    }
    
}
