package servlet;

import java.io.IOException;
import java.util.Collection;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.shop.Buch;
import model.shop.Warenkorb;
import model.user.Benutzer;
import model.user.Bestellposition;
import model.user.Bestellung;
import model.user.BookShopPersitenceException;
import model.user.DBFacade;

@WebServlet("/kaufen")
public class KaufabschlussServlet extends HttpServlet
{
   private static final long serialVersionUID = 1123L;

   public KaufabschlussServlet()
   {
      super();
   }

   @Override
   public void init() throws ServletException
   {
      super.init();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      try
      {
         String userid = request.getParameter("userid");

         Benutzer benutzer = DBFacade.getInstance().findBenutzer(userid);

         HttpSession session = request.getSession();
         Warenkorb wk = (Warenkorb) session.getAttribute("warenkorb");
         if (wk == null)
         {
            wk = new Warenkorb();
            session.setAttribute("warenkorb", wk);
         }
         
         Bestellung bestellung = new Bestellung(benutzer);
         benutzer.addBestellung(bestellung);
         Collection<Buch> buecher = wk.getInhalt();
         for( Buch b : buecher )
         {
            Bestellposition pos = new Bestellposition(bestellung, b.getTitel() );
            bestellung.addBestellpositionen(pos);
         }
                 
         DBFacade.getInstance().mergeBenutzer(benutzer);
         
         getServletContext().getRequestDispatcher("/danke.jsp").forward(request, response);

      } 
      catch (BookShopPersitenceException e)
      {
         e.printStackTrace();
         request.setAttribute("error", e );
         getServletContext().getRequestDispatcher("/registrierung.jsp").forward(request, response);
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      this.doGet(request, response);
   }
}
