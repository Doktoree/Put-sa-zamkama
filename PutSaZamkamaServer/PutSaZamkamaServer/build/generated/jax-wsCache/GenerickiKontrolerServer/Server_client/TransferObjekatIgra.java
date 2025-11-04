
package Server_client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for transferObjekatIgra complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transferObjekatIgra">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Server/}generickiTransferObjekat">
 *       &lt;sequence>
 *         &lt;element name="igra" type="{http://Server/}igra" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transferObjekatIgra", propOrder = {
    "igra"
})
public class TransferObjekatIgra
    extends GenerickiTransferObjekat
{

    protected Igra igra;

    /**
     * Gets the value of the igra property.
     * 
     * @return
     *     possible object is
     *     {@link Igra }
     *     
     */
    public Igra getIgra() {
        return igra;
    }

    /**
     * Sets the value of the igra property.
     * 
     * @param value
     *     allowed object is
     *     {@link Igra }
     *     
     */
    public void setIgra(Igra value) {
        this.igra = value;
    }

}
