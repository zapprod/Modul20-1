package model.user;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Collection;
import java.util.List;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

@SuppressWarnings("unchecked")
public class DBFacade
{
   private static class InstanceHolder
   {
      private static DBFacade instance = new DBFacade();
   }

   public static DBFacade getInstance()
   {
      return InstanceHolder.instance;
   }

   private EntityManagerFactory factory = null;

   private DBFacade()
   {
      super();
      this.factory = Persistence.createEntityManagerFactory("bookshop");
   }

   private EntityManager getNewEntityManager()
   {
      return factory.createEntityManager();
   }

   public boolean checkLogin(String username, String passwd) throws BookShopPersitenceException
   {
      Benutzer b = this.findBenutzer(username);

      byte[] pwd = b.getPwdHash();
      byte[] salt = b.getSalt();

      byte[] pwdToTest = generatePassword(passwd, salt);

      boolean compare = true;

      if (pwd.length != pwdToTest.length)
         return false;

      for (int i = 0; i < pwd.length; i++)
      {
         compare &= (pwd[i] == pwdToTest[i]);
      }

      return compare;
   }

   // Merged einen  Benutzer in der DB an
   public void mergeBenutzer(Benutzer benutzer) throws BookShopPersitenceException
   {
      EntityManager em = null;

      em = this.getNewEntityManager();
      em.getTransaction().begin();
      em.merge(benutzer);
      em.getTransaction().commit();
      em.close();

   }

   // Legt einen neuen Benutzer in der DB an
   public void speicherBenutzer(Benutzer benutzer) throws BookShopPersitenceException
   {
      EntityManager em = null;
      try
      {
         em = this.getNewEntityManager();
         em.getTransaction().begin();
         em.persist(benutzer);
         em.getTransaction().commit();
      } catch (RuntimeException e)
      {
         throw new BookShopPersitenceException("Fehler beim Speichern");
      } finally
      {
         em.close();
      }
   }

   public List<Benutzer> getAlleBenutzer() throws BookShopPersitenceException
   {
      EntityManager em = this.getNewEntityManager();
      Query q = em.createQuery("select b from Benutzer b");
      List<Benutzer> benutzerList = q.getResultList();
      em.close();
      return benutzerList;
   }

   public Benutzer findBenutzer(String username) throws BookShopPersitenceException
   {
      EntityManager em = this.getNewEntityManager();
      Query q = em.createQuery("select b from Benutzer b WHERE b.userid = :username");
      q.setParameter("username", username);
      List<Benutzer> benutzerList = q.getResultList();
      em.close();

      if (benutzerList.size() == 1)
      {
         return benutzerList.get(0);
      } else if (benutzerList.size() == 0)
      {
         throw new BookShopPersitenceException("Kein Benutzer mit Namen " + username + " gefunden!");
      } else
      {
         throw new BookShopPersitenceException("Benutzername " + username + " ist nicht eindeutig!");
      }
   }

   // Legt eine neue Bestellung in der Datenbank an
   public void speicherBestellung(Bestellung bestellung)
   {
      EntityManager em = this.getNewEntityManager();
      em.getTransaction().begin();
      em.persist(bestellung);
      em.getTransaction().commit();
      em.close();
   }

   public Collection<Bestellung> findBestellungenVonBenutzer(Benutzer benutzer) throws BookShopPersitenceException
   {
      EntityManager em = this.getNewEntityManager();
      Query q = em.createQuery("select b from Bestellung b WHERE b.benutzer.userid = :username");
      q.setParameter("username", benutzer.getUserid());
      List<Bestellung> bestellungen = q.getResultList();
      em.close();
      return bestellungen;
   }

   // Erzeugt einen Beispielinhalt für die Datenbank
   public void createDBContent() throws BookShopPersitenceException
   {
      Benutzer b1 = new Benutzer("Potter", "Harry", "harry.potter@stud.hs-kl.de", "66482", "Zweibrücken");
      byte[] salt1 = generateSalt();
      byte[] pwd1 = generatePassword("voldemort", salt1);
      b1.setUserid("harry");
      b1.setSalt(salt1);
      b1.setPwdHash(pwd1);

      Bestellung bestellung1 = new Bestellung(b1);
      Bestellposition pos11 = new Bestellposition(bestellung1, "Harry Potter Band 1");
      Bestellposition pos12 = new Bestellposition(bestellung1, "Harry Potter Band 2");
      bestellung1.addBestellpositionen(pos11);
      bestellung1.addBestellpositionen(pos12);
      b1.addBestellung(bestellung1);

      Benutzer b2 = new Benutzer("Beutlin", "Frodo", "frodo.beutlin@stud.hs-kl.de", "66482", "Zweibrücken");
      b2.setUserid("frodo");
      byte[] salt2 = generateSalt();
      byte[] pwd2 = generatePassword("gandalf", salt2);
      b2.setSalt(salt2);
      b2.setPwdHash(pwd2);

      Bestellung bestellung21 = new Bestellung(b2);
      Bestellposition pos21a = new Bestellposition(bestellung21, "Herr der Ringe Band 1");
      Bestellposition pos21b = new Bestellposition(bestellung21, "Herr der Ringe Band 2");
      Bestellposition pos21c = new Bestellposition(bestellung21, "Herr der Ringe Band 3");
      bestellung21.addBestellpositionen(pos21a);
      bestellung21.addBestellpositionen(pos21b);
      bestellung21.addBestellpositionen(pos21c);
      b2.addBestellung(bestellung21);

      Bestellung bestellung22 = new Bestellung(b2);
      Bestellposition pos22 = new Bestellposition(bestellung22, "Der kleine Hobbit");
      bestellung22.addBestellpositionen(pos22);
      b2.addBestellung(bestellung22);

      this.speicherBenutzer(b1);
      this.speicherBenutzer(b2);
   }

   // Löscht den Inhalt der Datenbank
   public void deleteDBContent()
   {
      EntityManager em = this.getNewEntityManager();
      Query q1 = em.createNativeQuery("DELETE FROM Bestellposition");
      Query q2 = em.createNativeQuery("DELETE FROM Bestellung");
      Query q3 = em.createNativeQuery("DELETE FROM Benutzer");

      EntityTransaction tx = em.getTransaction();
      tx.begin();
      q1.executeUpdate();
      q2.executeUpdate();
      q3.executeUpdate();
      tx.commit();
      em.close();

   }


   public static byte[] generatePassword(String password, byte[] salt)
   {
      try
      {
         SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
         KeySpec ks = new PBEKeySpec(password.toCharArray(), salt, 10000, 160);
         SecretKey s = f.generateSecret(ks);
         Key k = new SecretKeySpec(s.getEncoded(), "AES");
         return k.getEncoded();
      } catch (InvalidKeySpecException | NoSuchAlgorithmException e)
      {
         e.printStackTrace();
         return new byte[0];
      }
   }

   public static byte[] generateSalt()
   {

      try
      {
         SecureRandom random;
         random = SecureRandom.getInstance("SHA1PRNG");
         byte[] salt = new byte[8];
         random.nextBytes(salt);
         return salt;
      } catch (NoSuchAlgorithmException e)
      {
         return new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
      }

   }

}
