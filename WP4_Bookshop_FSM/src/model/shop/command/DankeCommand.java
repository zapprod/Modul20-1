package model.shop.command;

public class DankeCommand extends Command
{
   public DankeCommand(String name, String view, String... cmds)
   {
      super(name, view, cmds);
   }

   @Override
   public void execute(CommandContext ctxt)
   {
      // Bis jetzt noch nichts zu tun
   }

}
