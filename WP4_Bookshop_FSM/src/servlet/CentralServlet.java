package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.shop.Warenkorb;
import model.shop.command.Command;
import model.shop.command.CommandBroker;
import model.shop.command.CommandContext;

@WebServlet("/controller")
public class CentralServlet extends HttpServlet
{
   private static final long serialVersionUID = 1123L;
   private CommandBroker broker = null;

   public CentralServlet()
   {
      super();
   }

   @Override
   public void init() throws ServletException
   {
      super.init();
      this.broker = CommandBroker.getInstance();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      // Es wird immer eine Session erzeut und ein
      // Warenkorb angelegt
      HttpSession session = request.getSession();
      Warenkorb wk = (Warenkorb) session.getAttribute("warenkorb");
      if (wk == null)
      {
         wk = new Warenkorb();
         session.setAttribute("warenkorb", wk);
      }
      
      // Der Warenkorb steht jeder JSP auch zur Verfügung
      request.setAttribute("warenkorb", wk);

      String commandName = request.getParameter("command");
      // Wird kein Command-Parameter gefunden, wird auf die Einstiegsseite
      // verzweigt
      if (commandName == null)
      {
         Command command = this.broker.lookupCommand("start");
         // In der Session wird das ausgeführte Command hinterlegt
         session.setAttribute("__command", command);
         getServletContext().getRequestDispatcher(command.getView()).forward(request, response);
         return;
      }
      
      // Das zuletzt ausgeführte Command wird ermittelt
      Command previous = (Command) session.getAttribute("__command");
      Command command = broker.lookupCommand(commandName);

      // Alle Informationen werden in ein Context-Objekt kopiert
      CommandContext ctxt = this.createContext(request);
      ctxt.setWarenkorb(wk);
      
      
      // Prüfe, ob der Übergang erlaubt ist
      if (previous != null && previous.isAllowedSuccessor(command.getName()) == false)
      {
         // Kein erlaubter Übergang!!
         // Man bleibt auf der Seite, es wird nichts gemacht
         this.copyContextIntoRequest(ctxt, request);
         getServletContext().getRequestDispatcher(previous.getView()).forward(request, response);
         return;
      }
      else
      {
         command = command.executeCommand(ctxt);
         this.copyContextIntoRequest(ctxt, request);
         
         if( ctxt.hasError() )
         {
            // Zeige wieder die Ausgangsseite an
            getServletContext().getRequestDispatcher(previous.getView()).forward(request, response);
         }
         else
         {
            session.setAttribute("__command", command);
            getServletContext().getRequestDispatcher(command.getView()).forward(request, response);
         }
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      this.doGet(request, response);
   }

   private CommandContext createContext(HttpServletRequest request)
   {
      CommandContext ctxt = new CommandContext();

      // Übertrage Request-Parameter in den CommandContext
      Map<String, String[]> paramMap = request.getParameterMap();
      for (String key : paramMap.keySet())
      {
         String[] values = paramMap.get(key);
         // TODO: Es werden in dieser Version nur einwertige
         // Parameter unterstützt
         // Hier müsste man ggf. die Unterstützung für "mehrwertige Paramter"
         // ergänzen!
         if (values.length == 1)
         {
            ctxt.setAttribute(key, values[0]);
         }
      }

      // Gibt es einen Benutzer in der Session, wird dieser in den Context
      // gelegt
      Object  benutzer = request.getSession().getAttribute("benutzer");
      if( benutzer != null )
      {
         ctxt.setAttribute("benutzer", benutzer);
      }
      
      return ctxt;
   }

   private void copyContextIntoRequest(CommandContext ctxt, HttpServletRequest request)
   {
      // Übertrage CommandContext in Request-Parameter
      for (String key : ctxt.getAttributeNames())
      {
         Object value = ctxt.getAttribute(key);
         request.setAttribute(key, value);
      }
      
      request.setAttribute("warenkorb", ctxt.getWarenkorb() );
      
      if( ctxt.hasError() )
      {
         request.setAttribute("error", ctxt.getError() );
      }
      
      // Wenn sich ein Benutzer angemeldet hat, wird er in die Session gelegt
      if( ctxt.getAttribute("benutzer") != null )
      {
         request.getSession().setAttribute("benutzer",  ctxt.getAttribute("benutzer"));
      }
      
      return;
   }

}
