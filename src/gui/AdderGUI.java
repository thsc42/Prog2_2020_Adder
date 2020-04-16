package gui;

import adder.Adder;
import adder.AdderImpl;
import memory.Speicher;
import memory.SpeicherImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdderGUI {
    public static void main(String[] args) {
        System.out.println("Willkommen zu meinem tollen Adder");
        // control
        Adder adder = new AdderImpl();

        // model
        Speicher speicher = new SpeicherImpl();

        // view
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        boolean again = true;
        while(again) {

            try {
                // read user input
                String cmdLineString = userInput.readLine();

                // entweder zwei zahlen oder nur eine.
                // finish that loop if less than nothing came in
                if(cmdLineString == null) break;

                // trim whitespaces on both sides
                cmdLineString = cmdLineString.trim();

                // extract command
                int spaceIndex = cmdLineString.indexOf(' ');
                spaceIndex = spaceIndex != -1 ? spaceIndex : cmdLineString.length();

                // got zahl1 string
                String zahl1String = cmdLineString.substring(0, spaceIndex);

                int zahl1 = Integer.parseInt(zahl1String);

                // extract parameters string - can be empty
                String zahl2String = cmdLineString.substring(spaceIndex);
                zahl2String = zahl2String.trim();

                int zahl2 = 0;
                boolean zahl2Set = false;
                if(zahl2String != null && zahl2String.length() > 0) {
                    zahl2 = Integer.parseInt(zahl2String);
                    zahl2Set = true;
                }

                int summe = 0;
                if(zahl2Set) {
                    summe = adder.add(zahl1, zahl2);
                    System.out.println(zahl1 + " + " + zahl2 + " = " + summe);
                } else {
                    summe = adder.add(zahl1, speicher.getValue());
                    System.out.println(zahl1 + " + " + speicher.getValue() + " = " + summe);
                }

                speicher.setValue(summe);

            } catch (IOException ex) {
                System.err.println("Probleme mit dem externen Speicher: " + ex.getLocalizedMessage());
            }
            catch(RuntimeException re) {
                System.err.println("synataktisch fehlerhalfte Eingabe: " + re.getLocalizedMessage());
            } catch (Exception e) {
                System.err.println("Überlauf, bitte Eingabe korrigieren");
            }
        }

    // addieren - speichern das Zwischenergebnis

    // fragen ab ob neue DAten auf der Kommandozeile
    }
}
