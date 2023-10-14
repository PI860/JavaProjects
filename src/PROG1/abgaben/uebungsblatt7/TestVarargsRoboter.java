package PROG1.abgaben.uebungsblatt7;

/**
 * @author Paulina Pyczot
 * @date 22.11.2022
 **/

public class TestVarargsRoboter {

    // Attribute:
    double energie;

    // Konstruktoren:

    // Methoden:
    public void energieLaden(double... nums){ // ... = varargs (Parameter nums wird dadurch als Array behandelt); bewirkt, dass die von außen zugewiesenen Werte für nums die Länge von nums bestimmen
        for(int i = 0; i < nums.length; i++){
            energie += nums[i];
            System.out.println(nums[i]);
        }
    }
}
