
package Server_client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for transferObjekatPartija complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transferObjekatPartija">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nazivOperacije" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partija" type="{http://Server/}partija" minOccurs="0"/>
 *         &lt;element name="partijaZapoceta" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="poruka" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "transferObjekatPartija", propOrder = {
    "nazivOperacije",
    "partija",
    "partijaZapoceta",
    "poruka",
    "signal"
})
public class TransferObjekatPartija {

    protected String nazivOperacije;
    protected Partija partija;
    protected boolean partijaZapoceta;
    protected String poruka;
    protected boolean signal;

    /**
     * Gets the value of the nazivOperacije property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazivOperacije() {
        return nazivOperacije;
    }

    /**
     * Sets the value of the nazivOperacije property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazivOperacije(String value) {
        this.nazivOperacije = value;
    }

    /**
     * Gets the value of the partija property.
     * 
     * @return
     *     possible object is
     *     {@link Partija }
     *     
     */
    public Partija getPartija() {
        return partija;
    }

    /**
     * Sets the value of the partija property.
     * 
     * @param value
     *     allowed object is
     *     {@link Partija }
     *     
     */
    public void setPartija(Partija value) {
        this.partija = value;
    }

    /**
     * Gets the value of the partijaZapoceta property.
     * 
     */
    public boolean isPartijaZapoceta() {
        return partijaZapoceta;
    }

    /**
     * Sets the value of the partijaZapoceta property.
     * 
     */
    public void setPartijaZapoceta(boolean value) {
        this.partijaZapoceta = value;
    }

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
