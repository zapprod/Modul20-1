package model.shop.command;

import java.util.Collection;

import model.shop.Buch;
import model.shop.ModelFacade;

public class SuchCommand extends Command
{
   private ModelFacade facade = null;
   
   public SuchCommand(String name, String view, String... cmds)
   {
      super(name, view,cmds);
      this.facade = ModelFacade.getInstance();
   }
   
   @Override
   public void execute(CommandContext ctxt)
   {
      String autorname = (String) ctxt.getAttribute("autorname");
      
      Collection<Buch>  buecher = this.facade.findBuecherFromAutor(autorname);
      ctxt.setAttribute("buecher", buecher ); 
   }
}
