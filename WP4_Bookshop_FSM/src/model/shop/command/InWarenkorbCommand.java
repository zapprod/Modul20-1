package model.shop.command;

import model.shop.Buch;
import model.shop.ModelFacade;

public class InWarenkorbCommand extends Command
{
   private ModelFacade facade = null;
   
   public InWarenkorbCommand(String name, String view, String... cmds)
   {
      super(name, view, cmds);
      this.facade = ModelFacade.getInstance();
   }

   @Override
   public void execute(CommandContext ctxt)
   {
      String buchid = (String )ctxt.getAttribute("buchid");

      if (buchid != null)
      {
         Buch buch = this.facade.findBuchById(Integer.parseInt(buchid));
         ctxt.getWarenkorb().addBuch(buch);
      }
   }

}
