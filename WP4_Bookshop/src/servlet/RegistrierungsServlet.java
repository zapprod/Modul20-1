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

@WebServlet("/register")
public class RegistrierungsServlet extends HttpServlet
{
   private static final long serialVersionUID = 1124L;

   public RegistrierungsServlet()
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
      Warenkorb wk = (Warenkorb) session.getAttribute("warenkorb");
      if (wk == null)
      {
         wk = new Warenkorb();
         session.setAttribute("warenkorb", wk);
      }

      request.setAttribute("warenkorb", wk);
      
      String nachname = request.getParameter("nachname");
      String vorname = request.getParameter("vorname");
      String email = request.getParameter("email");
      String plz = request.getParameter("plz");
      String ort = request.getParameter("ort");
      
      String userid = request.getParameter("user");
      String passwd = request.getParameter("passwd");
      
      Benutzer b = new Benutzer(nachname, vorname, email, plz, ort);
      b.setUserid(userid);
      byte[] salt = DBFacade.generateSalt();
      byte[] pwd = DBFacade.generatePassword(passwd, salt);
      b.setSalt(salt);
      b.setPwdHash(pwd);
      request.setAttribute("benutzer", b );
      
      try
      {
         DBFacade.getInstance().speicherBenutzer(b);
         session.setAttribute("benutzer", b);
      } catch (BookShopPersitenceException e)
      {
         e.printStackTrace();
         request.setAttribute("error", e);
         getServletContext().getRequestDispatcher("/registrierung.jsp").forward(request, response);
         return;
      }

      getServletContext().getRequestDispatcher("/kaufinformation.jsp").forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      this.doGet(request, response);
   }

}
