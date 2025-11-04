
package Server_client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for transferObjekatKorisnikLogin complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transferObjekatKorisnikLogin">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="kor" type="{http://Server/}korisnikLogin" minOccurs="0"/>
 *         &lt;element name="poruka" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signal" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="indeks" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nazivOperacije" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transferObjekatKorisnikLogin", propOrder = {
    "kor",
    "poruka",
    "signal",
    "indeks",
    "nazivOperacije",
    "id"
})
public class TransferObjekatKorisnikLogin {

    protected KorisnikLogin kor;
    protected String poruka;
    protected boolean signal;
    protected int indeks;
    protected String nazivOperacije;
    protected int id;

    /**
     * Gets the value of the kor property.
     * 
     * @return
     *     possible object is
     *     {@link KorisnikLogin }
     *     
     */
    public KorisnikLogin getKor() {
        return kor;
    }

    /**
     * Sets the value of the kor property.
     * 
     * @param value
     *     allowed object is
     *     {@link KorisnikLogin }
     *     
     */
    public void setKor(KorisnikLogin value) {
        this.kor = value;
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

    /**
     * Gets the value of the indeks property.
     * 
     */
    public int getIndeks() {
        return indeks;
    }

    /**
     * Sets the value of the indeks property.
     * 
     */
    public void setIndeks(int value) {
        this.indeks = value;
    }

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
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

}
