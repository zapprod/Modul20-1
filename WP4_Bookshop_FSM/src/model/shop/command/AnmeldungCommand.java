package model.shop.command;

public class AnmeldungCommand extends Command
{
   public AnmeldungCommand(String name, String view, String... cmds)
   {
      super(name, view, cmds);
   }

   @Override
   public void execute(CommandContext ctxt)
   {
      
      // Ist Benutzer bereits angemeldet verzweige
      // direkt auf die Kaufübersicht
      if( ctxt.getAttribute("benutzer") != null )
      {
         ctxt.setForwardCommand("kaufinfo");
      }
   }

}
