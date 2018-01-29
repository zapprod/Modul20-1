package model.shop.command;

public class RegisterCmd extends Command
{
   public RegisterCmd(String name, String view, String... cmds)
   {
      super(name, view,cmds);
   }
   
   @Override
   public void execute(CmdContext ctxt)
   {
      // Bis jetzt noch nichts zu tun
   }

}
