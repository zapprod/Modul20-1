package model.shop.command;


public class GetRegisterDataCommand extends Command
{
   public GetRegisterDataCommand(String name, String view, String... cmds)
   {
      super(name, view, cmds);
   }

   @Override
   public void execute(CommandContext ctxt)
   {
      // Nichts zu tun
   }

}
