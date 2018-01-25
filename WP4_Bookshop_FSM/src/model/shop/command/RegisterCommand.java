package model.shop.command;

import model.shop.Warenkorb;
import model.user.Benutzer;
import model.user.BookShopPersitenceException;
import model.user.DBFacade;

public class RegisterCommand extends Command
{
   public RegisterCommand(String name, String view, String... cmds)
   {
      super(name, view, cmds);
   }

   @Override
   public void execute(CommandContext ctxt)
   {
      Warenkorb wk = (Warenkorb) ctxt.getAttribute("warenkorb");

      ctxt.setAttribute("warenkorb", wk);
      
      String nachname = (String) ctxt.getAttribute("nachname");
      String vorname = (String) ctxt.getAttribute("vorname");
      String email = (String) ctxt.getAttribute("email");
      String plz = (String) ctxt.getAttribute("plz");
      String ort = (String) ctxt.getAttribute("ort");
      
      String userid = (String) ctxt.getAttribute("user");
      String passwd = (String) ctxt.getAttribute("passwd");
      
      Benutzer b = new Benutzer(nachname, vorname, email, plz, ort);
      b.setUserid(userid);
      byte[] salt = DBFacade.generateSalt();
      byte[] pwd = DBFacade.generatePassword(passwd, salt);
      b.setSalt(salt);
      b.setPwdHash(pwd);
      ctxt.setAttribute("benutzer", b );
      
      try
      {
         DBFacade.getInstance().speicherBenutzer(b);
         ctxt.setAttribute("benutzer", b);
      } catch (BookShopPersitenceException e)
      {
         ctxt.setError( new Exception("Logindaten sind falsch") );
         return;
      }
   }

}
