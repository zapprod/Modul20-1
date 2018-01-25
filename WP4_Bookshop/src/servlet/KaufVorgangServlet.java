package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/startkaufen")
public class KaufVorgangServlet extends HttpServlet
{
   private static final long serialVersionUID = 1123L;

   public KaufVorgangServlet()
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
            HttpSession session = request.getSession();
            
            if( session.getAttribute("benutzer") == null )
            {
               getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            }
            else
            {
               getServletContext().getRequestDispatcher("/kaufinformation.jsp").forward(request, response);
            }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      this.doGet(request, response);
   }
}
