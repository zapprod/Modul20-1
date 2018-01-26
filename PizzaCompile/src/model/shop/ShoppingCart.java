package model.shop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ShoppingCart implements Serializable{
	
	
	   private static final long serialVersionUID = -8134578379541987433L;

	   private List<Pizza> pizzas = new ArrayList<Pizza>();
	   
	   public ShoppingCart()
	   {
	      super();
	   }
	   
	   public void addPizza(Pizza pizza)
	   {
	      this.pizzas.add(pizza);
	   }
	   
	   public void removeAll()
	   {
	      this.pizzas = new ArrayList<Pizza>();
	   }
	   
	   public Collection<Pizza> getInhalt()
	   {
	      return new ArrayList<Pizza>(this.pizzas);
	   }
	}


