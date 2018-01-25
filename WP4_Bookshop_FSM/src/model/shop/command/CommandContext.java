package model.shop.command;

import java.util.HashMap;
import java.util.Set;

import model.shop.Warenkorb;

// Objekte der Klasse kapseln die Request-Parameter
// Die Klasse dient zur Entkopplung der Servlet-Technologie von
// der Business-Logik. 
public class CommandContext
{
   private HashMap<String, Object> context = new HashMap<String, Object>();
   private Warenkorb warenkorb;
   private boolean error = false;
   private Exception exce = null;
   private boolean forward = false;
   private String nextCommandName = null;
   
   public CommandContext()
   {
      super();
   }
   
   // ZUgriffsmethoden für den Warenkorb
   public void setWarenkorb(Warenkorb wk)
   {
      this.warenkorb = wk;
   }
   
   public Warenkorb getWarenkorb()
   {
      return this.warenkorb;
   }
   
   
   // Im Context können beliebige key/Value-Paare hinterlegt werden
   public void setAttribute(String key, Object value)
   {
      this.context.put(key, value);
   }
   
   
   public Object getAttribute(String key)
   {
      return this.context.get(key);
   }
   
   public Set<String> getAttributeNames()
   {
      return this.context.keySet();
   }
   
   // Methoden zur Fehlerbehandlung
   public boolean hasError()
   {
      return this.error;
   }
   
   public void resetError()
   {
      this.error = false;
   }
   
   public void setError(Exception exce)
   {
      this.error = true;
      this.exce = exce;
   }
   
   public Exception getError()
   {
      return this.exce;
   }
   
   // Forward, wenn eine Seite übersprungen wird
   public boolean hasForward()
   {
      return this.forward;
   }
   
   public void resetForward()
   {
      this.forward = false;
   }
   
   public void setForwardCommand(String command)
   {
      this.forward = true;
      this.nextCommandName = command;
   }
   
   public String getForwardCommand()
   {
      return this.nextCommandName;
   }
}
