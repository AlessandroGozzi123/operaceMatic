
package gozzi;

import java.util.Scanner;

/**
 *
 * @author Alessandro Gozzi
 */
public class zapocet {
    
    public static final Scanner sc = new Scanner(System.in);
    
    public static void vypisMenu() {
        System.out.println("Operace:");
        System.out.println("1.Zapsat prvni matici.");
        System.out.println("2.Zapsat druhou matici.");
        System.out.println("3.Vypsat matice.");
        System.out.println("4.Test rozmeru.");
        System.out.println("5.Test shody hodnot.");
        System.out.println("6.Test shody struktury.");
        System.out.println("7.Test nulovych hodnot.");
        System.out.println("8.Test transpozice.");
        System.out.println("9.Test souctu v radcich.");
        System.out.println("10.Test maximalnich abs hodnot.");
        System.out.println("11.Ukonceni programu.");
        System.out.println("Napiste cislo vyberu.");
    }
    
    public static boolean testNull(int[][] prvniMatice, int[][] druhaMatice) {
        boolean vysledek = true;
        if (prvniMatice  == null || druhaMatice == null) {
            vysledek = false;
            System.out.println("");
            System.out.println("Obe matice by meli byt zapsane.");
            System.out.println("");
        }
        return vysledek;
    }
    
    public static void vypisMatic(int[][] matice, String titulek) {
        if (matice == null) {
            System.out.println(titulek);
            System.out.println("Matice neni zapsana.");
            System.out.println("");
        } else {
        
            System.out.println("");
            System.out.println(titulek);
            for (int[] v : matice) {
                for (int x : v) {
                    System.out.print(x+" ");
                }
                System.out.println("");
            }
            System.out.println("");
        }
    }
    
    public static int[][] zapsaniMatice() {
        
        System.out.println("Zadejte rozmery matice.");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] matice = null;
        boolean spravneRozmery = true;
        if (x < 1 || y < 1) spravneRozmery = false;
        if (spravneRozmery == false) {
            System.out.println("");
            System.out.println("Zadali jste neplatne rozmery matice.");
            System.out.println("");
        } else if (spravneRozmery == true) {
            matice = new int[x][y];
            System.out.println("Zadavejte hodnoty.");
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    matice[i][j] = sc.nextInt();
                }
            }
        }
        return matice;
    }
    
    public static boolean testRozmeru(int[][] prvniMatice, int[][] druhaMatice) {
        boolean vysledek = false;
        int radky = prvniMatice.length;
        int radky2 = druhaMatice.length;
        int sloupce = prvniMatice[0].length;
        int sloupce2 = druhaMatice[0].length;
        if (radky == radky2 && sloupce == sloupce2) {
            vysledek = true;
        }
        return vysledek;
    }
    
    public static void testHodnot(int[][] prvniMatice, int[][] druhaMatice) {
        
            //ulozeni prvku z prvni matice do pole
            int pocetPrvku1 = (prvniMatice.length)*(prvniMatice[0].length);
            int pocetPrvku2 = (druhaMatice.length)*(druhaMatice[0].length);
            int pole1[] = new int[pocetPrvku1];
            int q = 0;
            for (int i = 0; i < prvniMatice.length; i++) {
                for (int j = 0; j < prvniMatice[0].length; j++) {
                    pole1[q] = prvniMatice[i][j];
                    q++;
                }
            }
            //ulozeni prvku z druhe matice do pole
            int pole2[] = new int[pocetPrvku2];
            int e = 0;
            for (int i = 0; i < druhaMatice.length; i++) {
                for (int j = 0; j < druhaMatice[0].length; j++) {
                    pole2[e] = druhaMatice[i][j];
                    e++;
                }
            }
            //porovnani poli
            //vyberu kratsi z matic
            int delka = 0;
            if (pocetPrvku1 > pocetPrvku2) {
                delka = pocetPrvku2;
            } else if (pocetPrvku2 > pocetPrvku1) {
                delka = pocetPrvku1;
            } else if (pocetPrvku1 == pocetPrvku2) {
                delka = pocetPrvku1;
            }
            int shodnePrvky = 0;
            for (int i = 0; i < delka; i++) {
                if (pole1[i] == pole2[i]) shodnePrvky = shodnePrvky + 1;
            }
            //vysledek
            if (shodnePrvky == (pocetPrvku1) && pocetPrvku1 == pocetPrvku2) {
                System.out.println("");
                System.out.println("Matice maji vsechny hodnoty shodne.");
                System.out.println("");
            } else if (shodnePrvky > 0) {
                System.out.println("");
                System.out.println("Matice maji "+shodnePrvky+" shodnych hodnot.");
                System.out.println("");
            } else if (shodnePrvky == 0) {
                System.out.println("");
                System.out.println("Matice nemaji shodne hodnoty.");
                System.out.println("");
            }
    }
    
    public static boolean testShodyStruktury(int[][] prvniMatice, int[][] druhaMatice) {
        
        boolean ShodaStruk = true;
            int pocetShod = 0;
            for (int i = 0; i < prvniMatice.length; i++) {
                for (int j = 0; j < prvniMatice[0].length; j++) {
                    if (prvniMatice[i][j] < 0 && druhaMatice[i][j] > 0) ShodaStruk = false;
                    if (prvniMatice[i][j] > 0 && druhaMatice[i][j] < 0) ShodaStruk = false;
                    if (prvniMatice[i][j] == 0 && druhaMatice[i][j] != 0) ShodaStruk = false;
                    if (prvniMatice[i][j] != 0 && druhaMatice[i][j] == 0) ShodaStruk = false;
                }
        }
        return ShodaStruk;
    }
    
    public static void testNulovychPrvku(int[][] prvniMatice, int[][] druhaMatice) {
        
            int pocetNul = 0;
            int pocetNeNul = 0;
            int pocetNul2 = 0;
            int pocetNeNul2 = 0;
            for (int i = 0; i < prvniMatice.length; i++) {
                for (int j = 0; j < prvniMatice[0].length; j++) {
                    if (prvniMatice[i][j] == 0) pocetNul++; else pocetNeNul++;
                }
            }
            for (int o = 0; o < druhaMatice.length; o++) {
                for (int p = 0; p < druhaMatice[0].length; p++) {
                    if (prvniMatice[o][p] == 0) pocetNul2++; else pocetNeNul2++;
                }
            }
            if (pocetNeNul == pocetNeNul2) {
                System.out.println("");
                System.out.println("Matice maji stejny pocet nenulovych prvku.");
                System.out.println("");
            } else {
                System.out.println("");
                System.out.println("Matice nemaji stejny pocete nenulovych prvku.");
                System.out.println("");
            }
            System.out.println("");
            if (pocetNul == 0 && pocetNul2 == 0) {
                System.out.println("Matice nemaji nulove prvky");
                System.out.println("");
            } else {
                if (pocetNul == pocetNul2) {
                    System.out.println("Matice maji stejny pocet nulovych prvku.");
                    System.out.println("");
                } else {
                    System.out.println("Matice nemaji stejny pocet nulovych prvku.");
                    System.out.println("");
                }
            }
    }
    
    public static boolean testTranspozice(int[][] prvniMatice, int[][] druhaMatice) {
        boolean t = true;
        boolean testPrvku = true;
        if (prvniMatice.length != druhaMatice[0].length || prvniMatice[0].length != druhaMatice.length) {
            t = false;
            testPrvku = false;
        }
        if (testPrvku == true) {
            for (int i = 0; i < prvniMatice.length; i++) {
                for (int j = 0; j < prvniMatice[0].length; j++) {
                    if (prvniMatice[i][j] != druhaMatice[j][i]) t = false;
                }
            }
        }
        return t;
    }
    
    public static boolean testRadku(int[][] prvniMatice, int[][] druhaMatice) {
        
        boolean testRadku = true;
        if (prvniMatice.length != druhaMatice.length) {
            testRadku = false;
            System.out.println("");
            System.out.println("Matice maji rozdilny pocet radku.");
            System.out.println("");
        } else {
            int[] pole1 = new int[prvniMatice.length];
            int[] pole2 = new int[druhaMatice.length];
            int soucetRadku = 0;
            int soucetRadku2 = 0;
            for (int i = 0; i < prvniMatice.length; i++) {
                for (int j = 0; j < prvniMatice[0].length; j++) {
                    soucetRadku = soucetRadku + prvniMatice[i][j];
                }
                pole1[i] = soucetRadku;
                soucetRadku = 0;
            }
            for (int i = 0; i < druhaMatice.length; i++) {
                for (int j = 0; j < druhaMatice[0].length; j++) {
                    soucetRadku2 = soucetRadku2 + druhaMatice[i][j];
                }
                pole2[i] = soucetRadku2;
                soucetRadku2 = 0;
            }
            for (int i = 0; i < pole1.length; i++) {
                if (pole1[i] != pole2[i]) testRadku = false;
            }
        }
        return testRadku;
    }
    
    public static void testMax(int[][] prvniMatice, int[][]druhaMatice) {
        
        
            int prvniAbs = maxMatice(prvniMatice);
            int druhaAbs = maxMatice(druhaMatice);
        
            //vysledek
            if (prvniAbs == druhaAbs) {
                System.out.println("");
                System.out.println("Matice maji stejne absolutni hodnoty.");
                System.out.println("");
            } else {
                System.out.println("");
                System.out.println("Matice nemaji stejne absolutni hodnoty.");
                System.out.println("");
            }
    }
    
    public static int maxMatice(int[][] matice) {
        int vysledek = 0;
        for (int i = 0; i < matice.length; i++) {
            for (int j = 0; j < matice[0].length; j++) {
                if ((Math.abs(matice[i][j])) > vysledek) vysledek = Math.abs(matice[i][j]);
            }
        }
        return vysledek;
    }



    
    public static void main(String[] args) {             //<---------- MAIN CLASS
        
        int[][] prvniMatice = null;
        int[][] druhaMatice = null;
        boolean programPracuje = true;
        while (programPracuje == true) {
        vypisMenu();
        int a = sc.nextInt();
        
        switch(a) {
            case 1:
                prvniMatice = zapsaniMatice();
                break;
            case 2:
                druhaMatice = zapsaniMatice();
                break;
            case 3:
                vypisMatic(prvniMatice, "Prvni matice:");
                vypisMatic(druhaMatice, "Druha matice:");
                break;
            case 4:
                boolean inicializovane = testNull(prvniMatice, druhaMatice);
                if (inicializovane == true) {
                    boolean rozmery = testRozmeru(prvniMatice, druhaMatice);
                    if (rozmery == true) {
                        System.out.println("");
                        System.out.println("Matice maji shodne rozmery.");
                        System.out.println("");
                    } else {
                        System.out.println("");
                        System.out.println("Matice nemaji shodne rozmery.");
                        System.out.println("");
                    }
                }
                break;
            case 5:
                boolean inicializovane2 = testNull(prvniMatice, druhaMatice);
                if (inicializovane2 == true) {
                    testHodnot(prvniMatice, druhaMatice);
                }
                break;
            case 6:
                boolean inicializovane3 = testNull(prvniMatice, druhaMatice);
                if (inicializovane3 == true) {
                    boolean testRozmeru = testRozmeru(prvniMatice, druhaMatice);
                    if (testRozmeru == false) {
                        System.out.println("");
                        System.out.println("Matice by meli mit shodne rozmery.");
                        System.out.println("");
                    } else {
                        boolean shodaStruktury = testShodyStruktury(prvniMatice, druhaMatice);
                        if (shodaStruktury == true) {
                            System.out.println("");
                            System.out.println("Matice maji shodnou strukturu.");
                            System.out.println("");
                        } else {
                            System.out.println("");
                            System.out.println("Matice nemaji shodnou strukturu.");
                            System.out.println("");
                        }
                    }
                }
                break;
            case 7:
                boolean inicializovane4 = testNull(prvniMatice, druhaMatice);
                if (inicializovane4 == true) {
                    testNulovychPrvku(prvniMatice, druhaMatice);
                }
                break;
            case 8:
                boolean inicializovane5 = testNull(prvniMatice, druhaMatice);
                if (inicializovane5 == true) {
                    boolean transpozice = testTranspozice(prvniMatice, druhaMatice);
                    if (transpozice == true) {
                        System.out.println("");
                        System.out.println("Matice jsou transponovane.");
                        System.out.println("");
                    } else {
                        System.out.println("");
                        System.out.println("Matice nejsou transponovane.");
                        System.out.println("");
                    }
                }
                break;
            case 9:
                boolean inicializovane6 = testNull(prvniMatice, druhaMatice);
                if (inicializovane6 == true) {
                    boolean testRadku = testRadku(prvniMatice, druhaMatice);
                    if (testRadku == true) {
                        System.out.println("");
                        System.out.println("Soucty radcich v matich jsou stejne.");
                        System.out.println("");
                    } else {
                        System.out.println("");
                        System.out.println("Soucty radcich v matich nejsou stejne.");
                        System.out.println("");
                    }
                }
                break;
            case 10:
                boolean inicializovane7 = testNull(prvniMatice, druhaMatice);
                if (inicializovane7 == true) {
                    boolean testRadku = testRadku(prvniMatice, druhaMatice);
                    if (testRadku == true) {
                        testMax(prvniMatice, druhaMatice);
                    }
                }
                break;
            case 11:
                programPracuje = false;
                break;
        }   //------------------------------konec switch cyklu
        }   //------------------------------konec while cyklu           
        
        
    }
    
}
