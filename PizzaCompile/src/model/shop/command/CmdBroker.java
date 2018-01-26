package model.shop.command;

import java.util.HashMap;
import java.util.Map;

public class CmdBroker {
	
	   private static class CmdBrokerHolder
	   {
	      private static CmdBroker instance = new CmdBroker();
	   }
	   
	   private Map<String, Command> commands = new HashMap<String, Command>();
	   
	   private CmdBroker()
	   {
	      super();
	      this.init();
	   }
	   
	   public static CmdBroker getInstance()
	   {
	      return CmdBrokerHolder.instance;
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
	      // Die Instanziierungsinformation (Web-Seiten-Graph) k�nnte man auch aus einer
	      // Datei einlesen. Dadurch w�re dann der Broker v�llig generisch.
	      this.addCommand( new StartCmd("start","/index.jsp", "configurator","shoppingcart") );
	      this.addCommand( new ConfigCmd("configurator","/pizzaconf.jsp", "start", "orderinfo") );
	      this.addCommand( new BuchdetailCommand("detail", "/buchdetail.jsp", "start", "warenkorb") );
	      this.addCommand( new InCartCmd("shoppingcart", "/cart.jsp", "start", "login") );
	      this.addCommand( new AnmeldungCommand("anmeldung", "/login.jsp", "registerdata", "login") );
	      this.addCommand( new LoginCommand("login", "/kaufinformation.jsp","start", "danke") );
	      this.addCommand( new GetRegisterDataCommand("registerdata", "/registrierung.jsp","register") );
	      this.addCommand( new RegisterCmd("register", "/orderinfo.jsp","start", "checkout") );
	      this.addCommand( new OrderInfoCmd("orderinfo", "/orderinfo.jsp","start", "checkout") );
	      this.addCommand( new CheckoutCmd("danke","/danke.jsp","start") );
	   }
	}


