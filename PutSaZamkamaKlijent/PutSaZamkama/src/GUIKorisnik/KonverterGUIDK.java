/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIKorisnik;


import Server_client.GeneralDObject;
import Server_client.Pol;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 *
 * @author Lav
 */
public class KonverterGUIDK {
   
    
  public static boolean konvertujGUIUDK(FXMLDocumentController fxcon,GeneralDObject gdo)
  {
     for(Field f:fxcon.getClass().getDeclaredFields())
       {   f.setAccessible(true);
           for(Field dk:gdo.getClass().getDeclaredFields())
               { dk.setAccessible(true);
                 if (dk.getName().equals(f.getName()))
                  {  if (f.getType().getName().equals("javafx.scene.control.TextField") && dk.getType().getName().equals("int"))
                       { try { 
                               Integer broj =  Integer.valueOf(((javafx.scene.control.TextField)f.get(fxcon)).getText());
                               dk.set(gdo, broj);
                               
                             } catch (IllegalArgumentException | IllegalAccessException ex) 
                               { Logger.getLogger(KonverterGUIDK.class.getName()).log(Level.SEVERE, null, ex);return false;}
                       }
                     if (f.getType().getName().equals("javafx.scene.control.TextField") && dk.getType().getName().equals("java.lang.String"))
                       { try { 
                               dk.set(gdo, ((javafx.scene.control.TextField)f.get(fxcon)).getText());
                             } catch (IllegalArgumentException | IllegalAccessException ex) 
                               { Logger.getLogger(KonverterGUIDK.class.getName()).log(Level.SEVERE, null, ex);return false;}
                       }
                  
                     if (f.getType().getName().equals("javafx.scene.control.PasswordField") && dk.getType().getName().equals("java.lang.String"))
                       { try {  
                               dk.set(gdo, ((javafx.scene.control.PasswordField)f.get(fxcon)).getText());
                             } catch (IllegalArgumentException | IllegalAccessException ex) 
                               { Logger.getLogger(KonverterGUIDK.class.getName()).log(Level.SEVERE, null, ex);return false;}
                       }
                     
                     if (f.getType().getName().equals("javafx.scene.control.DatePicker") && dk.getType().getName().equals("javax.xml.datatype.XMLGregorianCalendar"))
                       { try { 
                               dk.set(gdo,konvertujLocalDateUXMLGregorianCalendar((LocalDate) ((javafx.scene.control.DatePicker) f.get(fxcon)).getValue()));
                             } catch (IllegalArgumentException | IllegalAccessException ex) 
                               { Logger.getLogger(KonverterGUIDK.class.getName()).log(Level.SEVERE, null, ex);return false;}
                       }
                     
                     if (f.getType().getName().equals("javafx.scene.control.ComboBox") && dk.getType().isEnum()){
                        try { 
                               dk.set(gdo, ((javafx.scene.control.ComboBox)f.get(fxcon)).getValue());
                             } catch (IllegalArgumentException | IllegalAccessException ex) 
                               { Logger.getLogger(KonverterGUIDK.class.getName()).log(Level.SEVERE, null, ex);return false;}
                       }
                     
                   } 
              }
       } 
     return true;
  }
  
  public static boolean konvertujDKUGUI(GeneralDObject gdo, FXMLDocumentController fxcon)
  {   
      for(Field f:fxcon.getClass().getDeclaredFields())
       {   for(Field dk:gdo.getClass().getDeclaredFields())
               { dk.setAccessible(true);
                 if (dk.getName().equals(f.getName()))
                  {  if (f.getType().getName().equals("javafx.scene.control.TextField") && dk.getType().getName().equals("int"))
                       { try { 
                               Integer broj = (Integer) dk.get(gdo);
                               
                               ((javafx.scene.control.TextField)f.get(fxcon)).setText(String.valueOf(broj));
                               
                             } catch (IllegalArgumentException | IllegalAccessException ex) 
                               { Logger.getLogger(KonverterGUIDK.class.getName()).log(Level.SEVERE, null, ex);return false;}
                       }
                     if (f.getType().getName().equals("javafx.scene.control.TextField") && dk.getType().getName().equals("java.lang.String"))
                       { try {  
                                ((javafx.scene.control.TextField)f.get(fxcon)).setText((String) dk.get(gdo));
                             } catch (IllegalArgumentException | IllegalAccessException ex) 
                               { Logger.getLogger(KonverterGUIDK.class.getName()).log(Level.SEVERE, null, ex);return false;}
                       }
                  
                     if (f.getType().getName().equals("javafx.scene.control.PasswordField") && dk.getType().getName().equals("java.lang.String"))
                       { try {  
                                ((javafx.scene.control.PasswordField)f.get(fxcon)).setText((String) dk.get(gdo));
                             } catch (IllegalArgumentException | IllegalAccessException ex) 
                               { Logger.getLogger(KonverterGUIDK.class.getName()).log(Level.SEVERE, null, ex);return false;}
                       }
                     
                     
                     if (f.getType().getName().equals("javafx.scene.control.DatePicker") && dk.getType().getName().equals("javax.xml.datatype.XMLGregorianCalendar"))
                       { try {  
                                
                                ((javafx.scene.control.DatePicker)f.get(fxcon)).setValue(((XMLGregorianCalendar) dk.get(gdo)).toGregorianCalendar().toZonedDateTime().toLocalDate());
                                
                             } catch (IllegalArgumentException | IllegalAccessException ex) 
                               { Logger.getLogger(KonverterGUIDK.class.getName()).log(Level.SEVERE, null, ex); return false;}
                       }
                     
                     if (f.getType().getName().equals("javafx.scene.control.ComboBox") && dk.getType().isEnum())
                       { try {  
                                ((javafx.scene.control.ComboBox)f.get(fxcon)).setValue((Pol) dk.get(gdo));
                             } catch (IllegalArgumentException | IllegalAccessException ex) 
                               { Logger.getLogger(KonverterGUIDK.class.getName()).log(Level.SEVERE, null, ex);return false;}
                       }
                     
                   } 
              }
       } 
     return true;
  
  }  
  
   
    public static LocalDate konvertujUtilDateULocalDate(java.util.Date input) 
    {  SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
       java.sql.Date sqlDate = java.sql.Date.valueOf(sm.format(input)); 
       LocalDate date = sqlDate.toLocalDate();
       return date;  
    }
  
  
  
   public static java.sql.Date konvertujLocalDateUSqlDate(LocalDate input )
      { SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = java.sql.Date.valueOf(input);
        return java.sql.Date.valueOf(sm.format(date)); 
      } 

 public static XMLGregorianCalendar konvertujLocalDateUXMLGregorianCalendar(LocalDate date)
    {  GregorianCalendar gcal = GregorianCalendar.from(date.atStartOfDay(ZoneId.systemDefault()));
      XMLGregorianCalendar xcal = null;
         try {
             xcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
         } catch (DatatypeConfigurationException ex) {
             System.out.println("Nije uspelo konvertovanje!");
         }
       return xcal;  
    }

   
}
