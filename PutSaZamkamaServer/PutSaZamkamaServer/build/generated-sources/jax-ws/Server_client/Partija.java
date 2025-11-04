
package Server_client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for partija complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="partija">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="brojPoteza" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="kraj" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="matrica" type="{http://jaxb.dev.java.net/array}intArray" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="pocetak" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="poslednjiPotez" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="trenutanRed" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="trenutnaKolona" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "partija", propOrder = {
    "brojPoteza",
    "kraj",
    "matrica",
    "pocetak",
    "poslednjiPotez",
    "trenutanRed",
    "trenutnaKolona"
})
public class Partija {

    protected int brojPoteza;
    @XmlElement(nillable = true)
    protected List<Integer> kraj;
    @XmlElement(nillable = true)
    protected List<IntArray> matrica;
    @XmlElement(nillable = true)
    protected List<Integer> pocetak;
    @XmlElement(nillable = true)
    protected List<Integer> poslednjiPotez;
    protected int trenutanRed;
    protected int trenutnaKolona;

    /**
     * Gets the value of the brojPoteza property.
     * 
     */
    public int getBrojPoteza() {
        return brojPoteza;
    }

    /**
     * Sets the value of the brojPoteza property.
     * 
     */
    public void setBrojPoteza(int value) {
        this.brojPoteza = value;
    }

    /**
     * Gets the value of the kraj property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the kraj property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKraj().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getKraj() {
        if (kraj == null) {
            kraj = new ArrayList<Integer>();
        }
        return this.kraj;
    }

    /**
     * Gets the value of the matrica property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the matrica property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMatrica().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IntArray }
     * 
     * 
     */
    public List<IntArray> getMatrica() {
        if (matrica == null) {
            matrica = new ArrayList<IntArray>();
        }
        return this.matrica;
    }

    /**
     * Gets the value of the pocetak property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pocetak property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPocetak().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getPocetak() {
        if (pocetak == null) {
            pocetak = new ArrayList<Integer>();
        }
        return this.pocetak;
    }

    /**
     * Gets the value of the poslednjiPotez property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the poslednjiPotez property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPoslednjiPotez().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getPoslednjiPotez() {
        if (poslednjiPotez == null) {
            poslednjiPotez = new ArrayList<Integer>();
        }
        return this.poslednjiPotez;
    }

    /**
     * Gets the value of the trenutanRed property.
     * 
     */
    public int getTrenutanRed() {
        return trenutanRed;
    }

    /**
     * Sets the value of the trenutanRed property.
     * 
     */
    public void setTrenutanRed(int value) {
        this.trenutanRed = value;
    }

    /**
     * Gets the value of the trenutnaKolona property.
     * 
     */
    public int getTrenutnaKolona() {
        return trenutnaKolona;
    }

    /**
     * Sets the value of the trenutnaKolona property.
     * 
     */
    public void setTrenutnaKolona(int value) {
        this.trenutnaKolona = value;
    }

}
