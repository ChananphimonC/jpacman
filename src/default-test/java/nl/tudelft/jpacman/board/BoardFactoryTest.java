package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the linking of squares done by the board factory.
 *
 * @author Jeroen Roosen
 */
class BoardFactoryTest {

    private BoardFactory factory;
    private Square s1;
    private Square s2;

    @BeforeEach
    void setUp() {
        PacManSprites sprites = mock(PacManSprites.class);
        factory = new BoardFactory(sprites);
        s1 = new BasicSquare();
        s2 = new BasicSquare();
    }

    @Test
    void worldIsRound() {
        factory.createBoard(new Square[][]{{s1}});
        assertThat(Arrays.stream(Direction.values())
            .map(s1::getSquareAt))
            .containsOnly(s1);
    }

    @Test
    void connectedEast() {
        factory.createBoard(new Square[][]{
            {s1},
            {s2}
        });
        assertThat(s1.getSquareAt(Direction.EAST)).isEqualTo(s2);
        assertThat(s2.getSquareAt(Direction.WEST)).isEqualTo(s1);
    }

    @Test
    void connectedWest() {
        factory.createBoard(new Square[][]{
            {s1},
            {s2}
        });
        assertThat(s2.getSquareAt(Direction.WEST)).isEqualTo(s1);
        assertThat(s1.getSquareAt(Direction.EAST)).isEqualTo(s2);
    }

    @Test
    void connectedNorth() {
        factory.createBoard(new Square[][]{{s1, s2}});
        assertThat(s2.getSquareAt(Direction.NORTH)).isEqualTo(s1);
        assertThat(s1.getSquareAt(Direction.SOUTH)).isEqualTo(s2);
    }

    @Test
    void connectedSouth() {
        factory.createBoard(new Square[][]{{s1, s2}});
        assertThat(s1.getSquareAt(Direction.SOUTH)).isEqualTo(s2);
        assertThat(s2.getSquareAt(Direction.NORTH)).isEqualTo(s1);
    }

}
