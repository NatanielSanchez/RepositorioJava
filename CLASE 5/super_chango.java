import mi_paquete.*;
import java.util.Scanner;
import java.io.File;

public class super_chango
{
    public static void main(String[] args)
    {
        File file = new File("lista_del_super.txt");
        Carrito chango = new Carrito();
        boolean primer_vuelta = true;

        try (Scanner sc = new Scanner(file))
        {
            while (sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] txt = line.split(",");
                int x = Integer.parseInt(txt[0]);
                int y = Integer.parseInt(txt[1]);
                Producto producto = new Producto(txt[2], y);
                ItemCarrito item = new ItemCarrito(producto, x);

                if (primer_vuelta)
                {
                    primer_vuelta = false;
                    chango.setItem(0, item);
                    continue;
                }
                chango.añadirItem(item);
            }
        }
        catch (Exception ex)
        {
            System.out.println("Algo salio mal... ");
        }

        System.out.println("*** ESTADO DEL CARRO ***");
        System.out.println(chango);
        System.out.println(" - MONTO TOTAL: $" + chango.montoTotal());

    }
}
