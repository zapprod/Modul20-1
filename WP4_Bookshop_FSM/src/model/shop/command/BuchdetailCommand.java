package model.shop.command;

import model.shop.Buch;
import model.shop.ModelFacade;

public class BuchdetailCommand extends Command
{
   private ModelFacade facade = null;

   public BuchdetailCommand(String name, String view, String... cmds)
   {
      super(name, view, cmds);
      this.facade = ModelFacade.getInstance();
   }

   @Override
   public void execute(CommandContext ctxt)
   {
      String buchid = (String) ctxt.getAttribute("buchid");

      Buch buch = this.facade.findBuchById(Integer.parseInt(buchid));
      ctxt.setAttribute("buch", buch);
   }

}
