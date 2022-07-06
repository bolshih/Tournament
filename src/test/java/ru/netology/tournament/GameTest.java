package ru.netology.tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

public class GameTest {

    Game game = new Game();

    Player player1 = new Player(1, "Player1", 10);
    Player player2 = new Player(2, "Player2", 15);
    Player player3 = new Player(3, "Player3", 15);
    Player player4 = new Player(4, "Player4", 7);


    @BeforeEach
    public void setup() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
    }


    @Test
    public void shuldRegidtrePlayer() {
        Player[] expected = {player1, player2, player3, player4};
        Player[] actual = game.getPlayers();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddPlayerToRegistr() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Player1");
        expected.add("Player2");
        expected.add("Player3");
        expected.add("Player4");

        ArrayList<String> actual = game.getRegPlayers();

        Assertions.assertEquals(expected, actual);
    }

//       @ParameterizedTest
//       @CsvSource({"Player1, Player4, 1",
//               "Player1, Player2, 2",
//               "PLayer2, Player3, 0"
//       })
//       public void shouldPlayer1Win(String name1, String name2, int win){
//
//        int expected = win;
//        int actual = game.round(name1, name2);
//
//            Assertions.assertEquals(expected, actual);
//    }
    @Test
    public void shouldPlayer1Win() {

        int expected = 1;
        int actual = game.round("Player1", "Player4");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayer2Win() {

        int expected = 2;
        int actual = game.round("Player1", "Player2");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDraw() {

        int expected = 0;
        int actual = game.round("Player2", "Player3");

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"Player5, Player2",
            "Player1, Player5"
    })

    public void shouldThrow(String name1, String name2) {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(name1, name2);
            ;
        });

    }

    @Test
    public void shuldFindStrength() {
        int expected = 0;
        int actual = game.findPlayerStrength("Pkadf");

        Assertions.assertEquals(expected, actual);
    }
}
