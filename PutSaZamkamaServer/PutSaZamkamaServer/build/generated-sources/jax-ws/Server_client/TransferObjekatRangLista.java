
package Server_client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for transferObjekatRangLista complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transferObjekatRangLista">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="poruka" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rangLista" type="{http://Server/}igra" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="signal" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transferObjekatRangLista", propOrder = {
    "poruka",
    "rangLista",
    "signal"
})
public class TransferObjekatRangLista {

    protected String poruka;
    @XmlElement(nillable = true)
    protected List<Igra> rangLista;
    protected boolean signal;

    /**
     * Gets the value of the poruka property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoruka() {
        return poruka;
    }

    /**
     * Sets the value of the poruka property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoruka(String value) {
        this.poruka = value;
    }

    /**
     * Gets the value of the rangLista property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rangLista property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRangLista().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Igra }
     * 
     * 
     */
    public List<Igra> getRangLista() {
        if (rangLista == null) {
            rangLista = new ArrayList<Igra>();
        }
        return this.rangLista;
    }

    /**
     * Gets the value of the signal property.
     * 
     */
    public boolean isSignal() {
        return signal;
    }

    /**
     * Sets the value of the signal property.
     * 
     */
    public void setSignal(boolean value) {
        this.signal = value;
    }

}
