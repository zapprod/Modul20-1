package servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.user.Benutzer;
import model.user.BookShopPersitenceException;
import model.user.DBFacade;

@WebServlet("/admin")
public class UserAdminServlet extends HttpServlet
{
   private static final long serialVersionUID = 11236565634L;

   private DBFacade facade = null;

   public UserAdminServlet()
   {
      super();
   }

   @Override
   public void init() throws ServletException
   {
      super.init();
      this.facade = DBFacade.getInstance();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      try
      {
         String par = request.getParameter("dbadmin");

         if (par.equals("ClearDB"))
         {
            this.facade.deleteDBContent();
         } 
         else if (par.equals("InitDB"))
         {
            this.facade.deleteDBContent();
            this.facade.createDBContent();
         }

         Collection<Benutzer> benutzer = this.facade.getAlleBenutzer();
         request.setAttribute("benutzer", benutzer);

         getServletContext().getRequestDispatcher("/useradmin.jsp").forward(request, response);
      } catch (BookShopPersitenceException exce)
      {
         exce.printStackTrace();
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      this.doGet(request, response);
   }
}
