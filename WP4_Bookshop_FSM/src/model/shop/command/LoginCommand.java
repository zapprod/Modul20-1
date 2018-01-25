package model.shop.command;

import model.shop.Warenkorb;
import model.user.Benutzer;
import model.user.BookShopPersitenceException;
import model.user.DBFacade;

public class LoginCommand extends Command
{
   public LoginCommand(String name, String view, String... cmds)
   {
      super(name, view, cmds);
   }

   @Override
   public void execute(CommandContext ctxt)
   {
      try
      {
         String userid = (String) ctxt.getAttribute("user");
         String passwd = (String) ctxt.getAttribute("passwd");

         boolean loginOK = DBFacade.getInstance().checkLogin(userid, passwd);

         if (loginOK)
         {
            Benutzer benutzer = DBFacade.getInstance().findBenutzer(userid);
            Warenkorb wk = (Warenkorb) ctxt.getAttribute("warenkorb");
            ctxt.setAttribute("benutzer", benutzer);

            ctxt.setAttribute("warenkorb", wk);
         }
         else
         {
            ctxt.setError( new Exception("Logindaten sind falsch") );
            ctxt.setAttribute("error", new BookShopPersitenceException("Logindaten sind falsch"));
         }
      }
      catch (BookShopPersitenceException e)
      {
         ctxt.setError(e);
      }
   }

}
