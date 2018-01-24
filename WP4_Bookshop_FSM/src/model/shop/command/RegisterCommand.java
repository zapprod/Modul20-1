package model.shop.command;

public class RegisterCommand extends Command
{
   public RegisterCommand(String name, String view, String... cmds)
   {
      super(name, view, cmds);
   }

   @Override
   public void execute(CommandContext ctxt)
   {
      // Wenn Registrierung geklappt hat, wird später der Benuter
      // in die Session gelegt
      if( ctxt.getAttribute("benutzer") == null )
      {  
          ctxt.setAttribute("benutzer", new Boolean(true) );
      }
   }

}
