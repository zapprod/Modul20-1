package model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bestellposition
{
   @Id  @GeneratedValue(strategy=GenerationType.SEQUENCE)
   private int id;
   private String beschreibung = null;
   
   @ManyToOne
   @JoinColumn(name="bestellung_id")
   private Bestellung bestellung;
   
   public Bestellposition()
   {
      super();
   }
   
   public Bestellposition(Bestellung bestellung, String beschreibung)
   {
      super();
      this.beschreibung = beschreibung;
      this.bestellung = bestellung;
   }
   
   public Bestellung getBestellung()
   {
      return this.bestellung;
   }
   
   public void setBestellung(Bestellung bestellung)
   {
      this.bestellung = bestellung;
   }
   
   public String getBeschreibung()
   {
      return this.beschreibung;
   }
   
   public void setBeschreibung(String beschreibung)
   {
      this.beschreibung = beschreibung;
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
      Bestellposition other = (Bestellposition) obj;
      if (id != other.id)
         return false;
      return true;
   }

   @Override
   public String toString()
   {
      return beschreibung;
   }
   
   
}
