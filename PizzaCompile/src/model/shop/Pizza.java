package model.shop;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Pizza implements Serializable
{
   private static final long serialVersionUID = 6690657110776756579L;
   private int id;
   private String size;
   private String topping;
   private double cost;
   
   private List<Pizza> pizzas = new ArrayList<Pizza>();
   
   public Pizza(int id, String titel, String verlag, double preis)
   {
      super();
      this.id = id;
      this.size = size;
      this.topping = topping;
      this.cost = cost;
   }
   
   public boolean addPizza(Pizza pizza)
   {
      return this.pizzas.add(pizza);
   }
   
   public List<Pizza> getPizzas()
   {
      List<Pizza>  result = new ArrayList<Pizza>();
      result.addAll( this.pizzas );
      return result;
   }
   
   public String getToppingsAsString()
   {
      StringBuilder strBuild = new StringBuilder();
      
      int i = 0;
      for( i =0; i < this.pizzas.size()-1; i++ )
      {
         Pizza pizza = this.pizzas.get(i);
         strBuild.append( pizza.getVorname() + " " + pizza.getNachname() + ", ");
      }
      Pizza pizza = this.pizzas.get(i);
      strBuild.append( pizza.getVorname() + " " + pizza.getNachname() );
         
      return strBuild.toString();
   }
   
   public int getId()
   {
      return this.id;
   }
   
   public String getSize()
   {
      return this.size;
   }
   
   public String getTopping()
   {
      return this.topping;
   }
   
   public String getCost()
   {
      NumberFormat frmt = DecimalFormat.getInstance();
      frmt.setMinimumFractionDigits(2);
      return frmt.format( this.cost );
   }

   @Override
   public boolean equals(Object obj)
   {
      if( obj instanceof Pizza == false )
         return false;
      
      if( obj == this )
         return true;
      
      if( ((Pizza) obj).id == this.id )
         return true;
      else
         return false;
   }

   @Override
   public int hashCode()
   {
      return String.valueOf(this.id).hashCode();
   }

   @Override
   public String toString()
   {
      StringBuilder pizzas = new StringBuilder();
      int i=0;
      for( i=0; i < this.pizzas.size()-1; i++)
      {
         pizzas.append( this.pizzas.get(i) + ", ");
      }
      pizzas.append( this.pizzas.get(i) );
      
      return pizzas.toString() + " : " + this.size + pizzas.toString();
   }
   
}
