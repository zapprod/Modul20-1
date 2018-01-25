package model.shop.command;

import model.user.Benutzer;
import model.user.BookShopPersitenceException;
import model.user.DBFacade;

public class KaufInfoCommand extends Command
{
   public KaufInfoCommand(String name, String view, String... cmds)
   {
      super(name, view,cmds);
   }

   @Override
   public void execute(CommandContext ctxt)
   {
      Benutzer benutzer = (Benutzer) ctxt.getAttribute("benutzer");
      
      try
      {
         DBFacade.getInstance().speicherBenutzer(benutzer);
         ctxt.setAttribute("benutzer", benutzer);
      } catch (BookShopPersitenceException e)
      {
         //e.printStackTrace();
         ctxt.setAttribute("error", e);
         return;
      }
   }

}
