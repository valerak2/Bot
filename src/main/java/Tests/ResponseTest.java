package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import bot.Response;
import org.junit.jupiter.api.Test;

class ResponseTest {
  Response resp = new Response();

 @Test
  void responseAddQuestions() {
     assertEquals("Некорректный ввод"
            + "\nДля повторного получения справочной информации напиши \"help\" ", resp.response("add", 12312));
  }
  @Test
  void responseGame() {
    long id = 123;
    resp.response("go",id);
    resp.response("2",id);
    resp.response("2",id);
    assertEquals("""

            Верных ответов:2
            Неверных ответов:0""", resp.gameMap.get(id).statistics());}

  @Test
  void getHelp() {
    assertEquals("""
            Справочная информация:\s
            Для начала игры напиши команду "go"\s
            Для добавления вопроса напиши "add\"""", resp.getHelp());
  }

  @Test
  void sayHello() {
    assertEquals("""
        Привет, я квиз-бот!
        Я могу проводить квиз в одиночном и совместном режиме
        Для начала игры напиши команду "go"
        Для повторного получения справочной информации напиши "help\"""", resp.sayHello());
  }
}