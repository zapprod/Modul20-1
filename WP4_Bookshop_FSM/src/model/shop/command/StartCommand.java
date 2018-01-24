package model.shop.command;

public class StartCommand extends Command
{
   public StartCommand(String name, String view, String... cmds)
   {
      super(name, view,cmds);
   }
   
   @Override
   public void execute(CommandContext ctxt)
   {
      // Bis jetzt noch nichts zu tun
   }

}
