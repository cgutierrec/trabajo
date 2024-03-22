import java.util.Scanner; 
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); 
    System.out.println("Bienvenido al software de control de tiempo"); 
    System.out.println("¿Usas Instagram?");
    String resp1 = sc.next(); 

    if (resp1.equals ("si")){
      System.out.println("Ingrese el tiempo que la usa diariamente (horas): ");
      Float tiempo_instagram = sc.nextFloat();
    }
    System.out.println("¿Usas TikTok?");
    String resp2 = sc.next();

    if (resp2.equals ("si")){
      System.out.println("Ingrese el tiempo que la usa diariamente (horas): ");
      Float tiempo_tiktok = sc.nextFloat();
    }
    System.out.println("¿Realizas actividad física?");
    String resp3 = sc.next(); 

    if (resp3.equals("si")){
      System.out.println("¿Cuánto tiempo diario dedicas? (horas)");
      Float tiempo_actividad_fisica = sc.nextFloat(); 
    }
      if ((resp1.equals("si")) || (resp2.equals("si")) || (resp3.equals("si"))){
      System.out.println("Datos ingresados correctamente");
    }else{
      System.out.println("No se ingresaron horas para el control");
    }
  }
}
