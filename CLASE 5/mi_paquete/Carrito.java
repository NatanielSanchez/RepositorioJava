package mi_paquete;

import java.util.Arrays;

public class Carrito // El carrito es un arreglo de items
{
    private ItemCarrito[] carro;

    public Carrito(int x) // crea un carrito con capacidad de x items
    {
        this.carro = new ItemCarrito[x];
    }

    public Carrito() // crea un carrito con capacidad de UN SOLO item
    {
        this.carro = new ItemCarrito[1];
    }

    public void setItem(int i, ItemCarrito x) // meto un item en el carro
    {
        carro[i] = x;
    }

    public ItemCarrito getItem(int i)
    {
        return carro[i];
    }

    public int getLength()
    {
        return carro.length;
    }

    public void añadirItem(ItemCarrito x) // añado un item al carrito
    {
        ItemCarrito[] v_aux = new ItemCarrito[carro.length + 1];
        for (int i=0; i < carro.length; i++)
        {
            v_aux[i] = carro[i];
        }
        v_aux[v_aux.length - 1] = x;
        carro = v_aux;
    }

    public float montoTotal() // calculo el total a pagar
    {
        float total = 0;
        for (int i=0; i < carro.length; i++)
        {
            total += carro[i].subTotal();
        }
        return total;
    }

    @Override
    public String toString() // imprime el carrito
    {
        String txt = "";
        for (int i=0; i < carro.length; i++)
        {
            txt = txt + carro[i].toString() + "\n";
        }
        return txt;
    }
}
