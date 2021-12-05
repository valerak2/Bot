package Tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import bot.MultiuserGame;
import bot.Response;
import org.junit.jupiter.api.Test;

public class MultiuserGameTest {
  Response resp = new Response();
  long id1 = 1;
  long id2 = 2;
  @Test
  void searchTest(){
      assertEquals("Ожидайте других игроков",resp.response("search",id1));
      assertEquals(1,resp.queue.size());
      assertEquals("STARTGAMECODE",resp.response("search",id2));
      assertEquals(0,resp.queue.size());
      assertEquals(id1,resp.multigames.get(id2));
      assertTrue(resp.multigames.containsKey(id2));


  }
  @Test
  void gameStatTest(){
      MultiuserGame stat = new MultiuserGame();
      resp.response("go",id1);
      resp.response("go",id2);
      resp.gameMap.get(id1).rightCount=10;

      resp.gameMap.get(id2).rightCount=8;
      stat.gameStat(resp.gameMap.get(id1),resp.gameMap.get(id2));
      assertEquals("Вы победили!",resp.gameMap.get(id1).getResultOfBattle());
      assertEquals("Вы проиграли!",resp.gameMap.get(id2).getResultOfBattle());

      resp.gameMap.get(id1).rightCount=5;
      resp.gameMap.get(id1).time=5;
      resp.gameMap.get(id2).rightCount=5;
      resp.gameMap.get(id2).time=2;
      stat.gameStat(resp.gameMap.get(id1),resp.gameMap.get(id2));
      assertEquals("Вы победили! По времени, при равном счете",resp.gameMap.get(id1).getResultOfBattle());
      assertEquals("Вы проиграли! По времени, при равном счете",resp.gameMap.get(id2).getResultOfBattle());

      resp.gameMap.get(id1).time=5;
      resp.gameMap.get(id2).time=5;
      stat.gameStat(resp.gameMap.get(id1),resp.gameMap.get(id2));
      assertEquals("Произошла ничья",resp.gameMap.get(id1).getResultOfBattle());
      assertEquals("Произошла ничья",resp.gameMap.get(id2).getResultOfBattle());

      ;

    }
}
