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

	      this.addCommand( new StartCmd("start","/index.jsp", "configurator","shoppingcart") );
	      this.addCommand( new ConfigCmd("configurator","/site/pizzaconf.jsp", "start", "shoppingcart", "login") );
	      this.addCommand( new InCartCmd("shoppingcart", "/site/cart.jsp", "start", "login", "register") );
	      this.addCommand( new LoginCmd("login", "/site/login.jsp","shoppingcart", "register", "orderinfo") );
	      /**this.addCommand( new GetRegisterDataCommand("registerdata", "/registrierung.jsp","register") );**/
	      this.addCommand( new RegisterCmd("register", "/site/register.jsp","shoppingcart", "orderinfo") );
	      this.addCommand( new OrderInfoCmd("orderinfo", "/site/orderinfo.jsp","start", "checkout") );
	      this.addCommand( new CheckoutCmd("checkout","/site/checkout.jsp","start") );
	   }
	}


