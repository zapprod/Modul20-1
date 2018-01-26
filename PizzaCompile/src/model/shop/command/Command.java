package model.shop.command;

import java.util.ArrayList;
import java.util.List;

public abstract class Command
{
   private String viewName = null;
   private String name = null;
   private List<String> successor = new ArrayList<String>();
   
   
   public Command(String name, String view, String ... cmds)
   {
      super();
      this.name = name;
      this.viewName = view;
      for( String cmd: cmds )
      {
         this.successor.add(cmd);
      }
   }
   
   public String getName()
   {
      return this.name;
   }
   
   public String getView()
   {
      return this.viewName;
   }
   
   public boolean isAllowedSuccessor(String cmd)
   {
      return this.successor.contains(cmd);
   }
   
   public Command executeCommand(CmdContext ctxt)
   {
      this.execute(ctxt);
      
      // Rekursives forward
      if( ctxt.hasForward() )
      {
        ctxt.resetForward();
        Command cmd = CmdBroker.getInstance().lookupCommand( ctxt.getForwardCommand() );
        if( cmd != null )
        {
           cmd.executeCommand(ctxt);
        }
        return cmd;
      }
      
      return this;
   }
   
   // Hier wird der "Unit of work" des Requests implementiert
   // Über das Context-Objekt hat man Zugriff auf alle Request-Parameter
   public abstract void execute(CmdContext ctxt);
}

