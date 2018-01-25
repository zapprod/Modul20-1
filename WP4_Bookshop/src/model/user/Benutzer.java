package model.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Benutzer
{
   @Id  @GeneratedValue(strategy=GenerationType.SEQUENCE)
   private int id;

   private String name = null;
   private String vorname = null;
   private String email = null;
   private String plz = null;
   private String ort = null;

   private String userid = null;
   
   @Column(name="password")
   private byte[] pwdHash = new byte[0];
   private byte[] salt = new byte[0];
   
   @OneToMany(mappedBy="benutzer",cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
   private List<Bestellung> bestellungen = null;
 
   public Benutzer()
   {
      super();
   }
   
   public Benutzer(String name, String vorname, String email, String plz, String ort)
   {
      super();
      this.name = name;
      this.vorname = vorname;
      this.email = email;
      this.plz = plz;
      this.ort = ort;
      this.bestellungen = new ArrayList<Bestellung>();
   }

   public String getName()
   {
      return this.name;
   }
   
   public void setName(String name)
   {
      this.name = name;
   }


   public String getVorname()
   {
      return this.vorname;
   }
   
   
   public void setVorname(String vorname)
   {
      this.vorname = vorname;
   }


   public String getEmail()
   {
      return this.email;
   }
   
   public void setEmail(String email)
   {
      this.email = email;
   }

 
   public String getPlz()
   {
      return this.plz;
   }
   
   public void setPlz(String plz)
   {
      this.plz = plz;
   }

 
   public String getOrt()
   {
      return this.ort;
   }
   
   public void setOrt(String ort)
   {
      this.ort = ort;
   }


   public String getUserid()
   {
      return this.userid;
   }

   public void setUserid(String userid)
   {
      this.userid = userid;
   }

   public byte[] getPwdHash()
   {
      return this.pwdHash;
   }

   public void setPwdHash(byte[] pwdHash)
   {
      this.pwdHash = pwdHash;
   }

   public byte[] getSalt()
   {
      return this.salt;
   }

   public void setSalt(byte[] salt)
   {
      this.salt = salt;
   }
   
   public void addBestellung(Bestellung bestellung)
   {
      this.bestellungen.add( bestellung );
   }
   
   public List<Bestellung> getBestellungen()
   {
      return this.bestellungen;
   }


   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + id;
      return result;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Benutzer other = (Benutzer) obj;
      if (id != other.id)
         return false;
      return true;
   }

   @Override
   public String toString()
   {
      return this.vorname + " " + this.name;
   }
   
   
}
