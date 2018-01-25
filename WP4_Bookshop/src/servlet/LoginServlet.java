package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.shop.Warenkorb;
import model.user.Benutzer;
import model.user.BookShopPersitenceException;
import model.user.DBFacade;

@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
   private static final long serialVersionUID = 1123L;

   public LoginServlet()
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
         String userid = request.getParameter("user");
         String passwd = request.getParameter("passwd");

         boolean loginOK = DBFacade.getInstance().checkLogin(userid, passwd);

         if (loginOK)
         {
            Benutzer benutzer = DBFacade.getInstance().findBenutzer(userid);
            request.setAttribute("benutzer", benutzer);

            HttpSession session = request.getSession();
            Warenkorb wk = (Warenkorb) session.getAttribute("warenkorb");
            if (wk == null)
            {
               wk = new Warenkorb();
               session.setAttribute("warenkorb", wk);
            }
            session.setAttribute("benutzer", benutzer);
            
            request.setAttribute("warenkorb", wk);

            getServletContext().getRequestDispatcher("/kaufinformation.jsp").forward(request, response);
         } 
         else
         {
            request.setAttribute("error", new BookShopPersitenceException("Logindaten sind falsch") );
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
         }
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
