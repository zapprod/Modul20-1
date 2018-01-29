package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.shop.ShoppingCart;
import model.shop.command.CmdBroker;
import model.shop.command.CmdContext;
import model.shop.command.Command;

@WebServlet("/controller")
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 6300206478409157574L;
	private CmdBroker broker = null;

	   public FrontController()
	   {
	      super();
	   }

	   @Override
	   public void init() throws ServletException
	   {
	      super.init();
	      this.broker = CmdBroker.getInstance();
	   }

	   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	   {
	      HttpSession session = request.getSession();
	      ShoppingCart sc = (ShoppingCart) session.getAttribute("shoppingcart");
	      if (sc == null)
	      {
	         sc = new ShoppingCart();
	         session.setAttribute("shoppingcart", sc);
	      }
	      
	      // Der Warenkorb steht jeder JSP auch zur Verf�gung
	      request.setAttribute("shoppingcart", sc);

	      String commandName = request.getParameter("command");
	      // Wird kein Command-Parameter gefunden, wird auf die Einstiegsseite
	      // verzweigt
	      if (commandName == null)
	      {
	         Command command = this.broker.lookupCommand("start");
	         // In der Session wird das ausgef�hrte Command hinterlegt
	         session.setAttribute("__command", command);
	         getServletContext().getRequestDispatcher(command.getView()).forward(request, response);
	         return;
	      }
	      
	      // Das zuletzt ausgef�hrte Command wird ermittelt
	      Command previous = (Command) session.getAttribute("__command");
	      Command command = broker.lookupCommand(commandName);

	      // Alle Informationen werden in ein Context-Objekt kopiert
	      CmdContext ctxt = this.createContext(request);
	      ctxt.setShoppingCart(sc);
	      
	      
	      // Pr�fe, ob der �bergang erlaubt ist
	      if (previous != null && previous.isAllowedSuccessor(command.getName()) == false)
	      {
	         // Kein erlaubter �bergang!!
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

	   private CmdContext createContext(HttpServletRequest request)
	   {
	      CmdContext ctxt = new CmdContext();

	      // �bertrage Request-Parameter in den CmdContext
	      Map<String, String[]> paramMap = request.getParameterMap();
	      for (String key : paramMap.keySet())
	      {
	         String[] values = paramMap.get(key);
	         // TODO: Es werden in dieser Version nur einwertige
	         // Parameter unterst�tzt
	         // Hier m�sste man ggf. die Unterst�tzung f�r "mehrwertige Paramter"
	         // erg�nzen!
	         if (values.length == 1)
	         {
	            ctxt.setAttribute(key, values[0]);
	         }
	      }
	   // Gibt es einen Benutzer in der Session, wird dieser in den Context
	      // gelegt
	      Object  user = request.getSession().getAttribute("user");
	      if( user != null )
	      {
	         ctxt.setAttribute("user", user);
	      }
	      
	      return ctxt;
	   }

	   private void copyContextIntoRequest(CmdContext ctxt, HttpServletRequest request)
	   {
	      // Übertrage CommandContext in Request-Parameter
	      for (String key : ctxt.getAttributeNames())
	      {
	         Object value = ctxt.getAttribute(key);
	         request.setAttribute(key, value);
	      }
	      
	      request.setAttribute("shoppingcart", ctxt.getShoppingCart() );
	      
	      if( ctxt.hasError() )
	      {
	         request.setAttribute("error", ctxt.getError() );
	      }
	      
	      // Wenn sich ein Benutzer angemeldet hat, wird er in die Session gelegt
	      if( ctxt.getAttribute("user") != null )
	      {
	         request.getSession().setAttribute("user",  ctxt.getAttribute("user"));
	      }
	      
	      return;
	   }


  }

