/*
Nombre: Samuel Alarcón Granados 
Fecha:10/02/2024
Docente:
Descripción: En este código se hará una app para descubrir rl total de las 
fuerzas en combate y mostrar las bajas totales.
básicas
 */
package parcial01;

public class Parcial01 {

    public static void main(String[] args) {

        // Facción A
        int InfanteriaMuertosA = 30;
        int InfanteriaHeridosA = 60;
        int InfanteriaDesertoresA = 90;

        int CaballeriaMuertosA = 10;
        int CaballeriaHeridosA = 60;
        int CaballeriaDesertoresA = 30;

        int CabaPesadaMuertosA = 2;
        int CabaPesadaHeridosA = 3;
        int CabaPesadaDesertoresA = 0;

        // Facción B
        int InfanteriaMuertosB = 50;
        int InfanteriaHeridosB = 90;
        int InfanteriaDesertoresB = 10;

        int CaballeriaMuertosB = 200;
        int CaballeriaHeridosB = 180;
        int CaballeriaDesertoresB = 20;

        int CabaPesadaMuertosB = 10;
        int CabaPesadaHeridosB = 5;
        int CabaPesadaDesertoresB = 75;        
        
        // Calcular totales
        int totalFuerzasA = calcularTotalFuerzas(InfanteriaMuertosA,
            InfanteriaHeridosA, InfanteriaDesertoresA)+ calcularTotalFuerzas
            (CaballeriaMuertosA,CaballeriaHeridosA, CaballeriaDesertoresA)
            + calcularTotalFuerzas(CabaPesadaMuertosA,CabaPesadaHeridosA,
            CabaPesadaDesertoresA);

        int totalFuerzasB = calcularTotalFuerzas(InfanteriaMuertosB, 
                InfanteriaHeridosB, InfanteriaDesertoresB)
                + calcularTotalFuerzas(CaballeriaMuertosB, 
                CaballeriaHeridosB, CaballeriaDesertoresB)
                + calcularTotalFuerzas(CabaPesadaMuertosB, 
                CabaPesadaHeridosB,CabaPesadaDesertoresB);

        // Calcular bajas totales
        int bajasInfanteria = InfanteriaMuertosA + InfanteriaMuertosB;
        int bajasCaballeria = CaballeriaMuertosA + CaballeriaMuertosB;
        int bajasCaballeriaPesada = CabaPesadaMuertosA +
            CabaPesadaMuertosB;
       

        // Mostrar resultados
        System.out.println("Total de fuerzas en combate:");
        System.out.println("Faccion A: " + totalFuerzasA);
        System.out.println("Faccion B: " + totalFuerzasB);
        System.out.println("\nBajas totales por tipo de tropa:");
        System.out.println("Infanteria: " + bajasInfanteria);
        System.out.println("Caballeria: " + bajasCaballeria);
        System.out.println("Caballeria Pesada: " + bajasCaballeriaPesada);
    }

    public static int calcularTotalFuerzas(int muertos, int heridos, 
            int desertores) {
        return muertos + heridos + desertores;
    }
}