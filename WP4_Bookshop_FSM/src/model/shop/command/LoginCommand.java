package model.shop.command;

public class LoginCommand extends Command
{
   public LoginCommand(String name, String view, String... cmds)
   {
      super(name, view, cmds);
   }

   @Override
   public void execute(CommandContext ctxt)
   {
      // Wenn login geklappt hat, wird später der Benuter
      // in die Session gelegt
      if( ctxt.getAttribute("benutzer") == null )
      {  
          ctxt.setAttribute("benutzer", new Boolean(true) );
      }
   }

}
