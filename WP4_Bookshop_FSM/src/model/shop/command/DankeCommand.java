package model.shop.command;

import java.util.Collection;

import model.shop.Buch;
import model.shop.Warenkorb;
import model.user.Benutzer;
import model.user.Bestellposition;
import model.user.Bestellung;
import model.user.BookShopPersitenceException;
import model.user.DBFacade;

public class DankeCommand extends Command
{
   public DankeCommand(String name, String view, String... cmds)
   {
      super(name, view, cmds);
   }

   @Override
   public void execute(CommandContext ctxt)
   {
      try
      {
         Benutzer benutzer = (Benutzer) ctxt.getAttribute("benutzer");

         Warenkorb wk = ctxt.getWarenkorb();
         
         Bestellung bestellung = new Bestellung(benutzer);
         benutzer.addBestellung(bestellung);
         Collection<Buch> buecher = wk.getInhalt();
         for( Buch b : buecher )
         {
            Bestellposition pos = new Bestellposition(bestellung, b.getTitel() );
            bestellung.addBestellpositionen(pos);
         }
                 
         DBFacade.getInstance().mergeBenutzer(benutzer);
      } 
      catch (BookShopPersitenceException e)
      {
         e.printStackTrace();
         ctxt.setAttribute("error", e );
      }
   }

}
