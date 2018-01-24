package model.shop.command;

import java.util.HashMap;
import java.util.Map;

// Instanziiert und Verwaltet die Command-Objekte
public class CommandBroker
{
   private static class CommandBrokerHolder
   {
      private static CommandBroker instance = new CommandBroker();
   }
   
   private Map<String, Command> commands = new HashMap<String, Command>();
   
   private CommandBroker()
   {
      super();
      this.init();
   }
   
   public static CommandBroker getInstance()
   {
      return CommandBrokerHolder.instance;
   }
   
   public Command lookupCommand(String name)
   {
      return this.commands.get(name);
   }
   
   private void addCommand(Command cmd)
   {
      this.commands.put( cmd.getName(), cmd );
   }
   
   private void init()
   {
      // Die Instanziierungsinformation (Web-Seiten-Graph) könnte man auch aus einer
      // Datei einlesen. Dadurch wäre dann der Broker völlig generisch.
      this.addCommand( new StartCommand("start","/index.jsp", "suchen","warenkorb") );
      this.addCommand( new SuchCommand("suchen","/suchergebnis.jsp", "start", "detail") );
      this.addCommand( new BuchdetailCommand("detail", "/buchdetail.jsp", "start", "warenkorb") );
      this.addCommand( new InWarenkorbCommand("warenkorb", "/warenkorb.jsp", "start", "anmeldung") );
      this.addCommand( new AnmeldungCommand("anmeldung", "/login.jsp", "registerdata", "login") );
      this.addCommand( new LoginCommand("login", "/kaufinformation.jsp","start", "danke") );
      this.addCommand( new GetRegisterDataCommand("registerdata", "/registrierung.jsp","register") );
      this.addCommand( new RegisterCommand("register", "/kaufinformation.jsp","start", "danke") );
      this.addCommand( new KaufInfoCommand("kaufinfo", "/kaufinformation.jsp","start", "danke") );
      this.addCommand( new DankeCommand("danke","/danke.jsp","start") );
   }
}
