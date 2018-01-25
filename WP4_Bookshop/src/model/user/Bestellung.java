package model.user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Bestellung
{
   private static SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
   
   @Id  @GeneratedValue(strategy=GenerationType.SEQUENCE)
   private int id;
   private String datum = null;
   
   @ManyToOne
   @JoinColumn(name="benutzer_id")
   private Benutzer benutzer= null;
 
   @OneToMany(mappedBy="bestellung",cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
   private List<Bestellposition> bestellpositionen = null;
   
   public Bestellung()
   {
      super();
   }
   
   public Bestellung(Benutzer benutzer)
   {
      super();
      this.benutzer = benutzer;
      this.bestellpositionen = new ArrayList<Bestellposition>();
      this.datum = Bestellung.formatter.format (new Date() );
   }

   
   public Benutzer getBenutzer()
   {
      return this.benutzer;
   }
   
   public void setBenutzer(Benutzer benutzer)
   {  
      this.benutzer = benutzer;
   }
   
   public String getDatum()
   {
      return this.datum;
   }
   
   public void setDatum(String datum)
   {
      this.datum = datum;
   }
   
   public void addBestellpositionen(Bestellposition pos)
   {
      this.bestellpositionen.add(pos);
   }
   
   public List<Bestellposition> getBestellpositionen()
   {
      return this.bestellpositionen;
   }
   
   public void setBestellpositionen(List<Bestellposition> bestellPositionen)
   {
      this.bestellpositionen = bestellPositionen;
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
      Bestellung other = (Bestellung) obj;
      if (id != other.id)
         return false;
      return true;
   }

   @Override
   public String toString()
   {
      StringBuilder strBuil = new StringBuilder();
      strBuil.append("Bestellung [datum=" + datum + ", bestellpositionen=" + Arrays.toString( this.bestellpositionen.toArray() ) + "]");
      return strBuil.toString();
   }
   
   
}
